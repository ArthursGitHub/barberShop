package by.nikolaev.ilya.barbershop.bean;

import java.io.Serializable;
import java.sql.Date;

public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String time;
	private Date data;
	private String phone;
	private int userId;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public Date getData() {
		return data;
	}

	public String getPhone() {
		return phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 88;
		int result = 5;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + userId;
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
		Record other = (Record) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
