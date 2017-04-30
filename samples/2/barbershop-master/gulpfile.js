'use strict';

var gulp = require('gulp');
var minify = require('gulp-csso');
var del = require('del');
var run = require('run-sequence');
var uglify = require('gulp-uglify');
var inject = require('gulp-inject');
var sass = require('gulp-sass');
var babelPreset = require('babel-preset-es2015');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var sourcemaps = require('gulp-sourcemaps');
var postcss = require('gulp-postcss');
var autoprefixer = require('autoprefixer');
var mqpacker = require('css-mqpacker');
var imagemin = require('gulp-imagemin');
var svgmin = require('gulp-svgmin');
var svgstore = require('gulp-svgstore');
var ghPages = require('gulp-gh-pages');
var rename = require('gulp-rename');
var server = require('browser-sync');
var plumber = require('gulp-plumber');

gulp.task('copy', function () {
  return gulp.src([
    'src/fonts/**/*',
  ], {
    base: './src'
  })
    .pipe(gulp.dest('build'));
});

gulp.task('app-styles', function () {
  return gulp.src('src/styles/style.scss')
    .pipe(sass())
    .pipe(plumber())
    .pipe(postcss([
      autoprefixer({browsers: [
        'last 1 version',
        'last 2 Chrome versions',
        'last 2 Firefox versions',
        'last 2 Opera versions',
        'last 2 Edge versions'
      ]}),
      mqpacker({
        sort: true
      })
    ]))
    .pipe(minify())
    .pipe(rename('style.min.css'))
    .pipe(gulp.dest('build/styles'))
    .pipe(server.reload({stream: true}));
});

gulp.task('app-scripts', function () {
  var bundler = browserify({
    entries: 'src/js/app.js',
    debug: true
  });
  bundler.transform(babelify, {presets: 'es2015'});

  return bundler.bundle()
    .on('error', function (err) {console.error(err); })
    .pipe(source('app.min.js'))
    .pipe(buffer())
    .pipe(sourcemaps.init({loadMaps: true}))
    .pipe(uglify())
    .pipe(sourcemaps.write('./'))
    .pipe(gulp.dest('build/js'))
    .pipe(server.reload({stream: true}));
});

gulp.task('images', function () {
  return gulp.src(['src/img/**/*.jpeg', 'src/img/**/*.jpg', 'src/img/**/*.png', 'src/img/**/*.gif'])
    .pipe(imagemin([
      imagemin.gifsicle({interlaces: true}),
      imagemin.jpegtran({progressive: true}),
      imagemin.optipng({optimizationLevel: 3}),
    ]))
    .pipe(gulp.dest('build/img'));
});

gulp.task('symbols', function () {
  var svgSprite = gulp
    .src('src/img/*.svg')
    .pipe(svgmin())
    .pipe(svgstore({
      inlineSvg: true
    }));

  function fileContents (filePath, file) {
    return file.contents.toString();
  }

  return gulp.src('build/index.html')
    .pipe(inject(svgSprite, {
      transform: fileContents
    }))
    .pipe(server.reload({stream: true}));
});

var injectSources = [
  './build/styles/style.min.css',
  './build/js/app.min.js'
];

gulp.task('index', function () {
  return gulp.src('./src/*.html')
    .pipe(inject(gulp.src(injectSources, {read: false}),
      {
        ignorePath: 'build',
        addRootSlash: false
      }))
    .pipe(gulp.dest('./build'))
    .pipe(server.reload({stream: true}));
});

gulp.task('clean', function () {
  return del(['build', '.publish']);
});

gulp.task('build', function (callback) {
  run(
      'clean',
      ['copy', 'app-styles', 'app-scripts', 'images'],
      'index',
      'symbols',
      callback
  );
});

gulp.task('serve', ['build'], function () {
  server.init({
    server: './build',
    notify: false,
    open: true,
    ui: false
  });

  gulp.watch('src/styles/**/*.scss', ['app-styles']);
  gulp.watch('src/js/**/*.js', ['app-scripts']);
  gulp.watch('src/*.html', ['index', 'symbols']);
});

gulp.task('deploy', ['build'], function () {
  return gulp.src('./build/**/*')
    .pipe(ghPages());
});

gulp.task('default', ['build', 'serve']);