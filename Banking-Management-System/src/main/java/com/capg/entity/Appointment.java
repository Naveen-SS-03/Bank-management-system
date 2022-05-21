package com.capg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private Date date;
	    private String location;
	    private String description;
	    private String confirmed;
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }
	    
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String isConfirmed() {
	        return confirmed;
	    }

	    public void setConfirmed(String confirmed) {
	        this.confirmed = confirmed;
	    }

		@Override
		public String toString() {
			return "Appointment [id=" + id + ", name=" + name + ", date=" + date + ", location=" + location
					+ ", description=" + description + ", confirmed=" + confirmed + "]";
		}

		public Integer getAppointmentId() {
			// TODO Auto-generated method stub
			return null;
		}

		public Integer updateAppointment() {
			// TODO Auto-generated method stub
			return null;
		}
}
