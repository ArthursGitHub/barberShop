package by.nikolaev.ilya.barbershop.bean;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String surname;
	private String login;
	private String password;
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public int hashCode() {
		final int prime = 88;
		int result = 5;
		result = prime * result + this.id;
		result = prime * result + ((this.login == null) ? 0 : this.login.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
		result = prime * result + (this.status ? 1231 : 1237);
		result = prime * result + ((this.surname == null) ? 0 : this.surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (this.id != other.id)
			return false;
		if (this.login == null) {
			if (other.login != null)
				return false;
		} else if (!this.login.equals(other.login))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		if (this.password == null) {
			if (other.password != null)
				return false;
		} else if (!this.password.equals(other.password))
			return false;
		if (this.status != other.status)
			return false;
		if (this.surname == null) {
			if (other.surname != null)
				return false;
		} else if (!this.surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + "," + " surname=" + surname + ", login=" + login + "," + " password=" + password + ", status=" + status + "]";
	}

}
