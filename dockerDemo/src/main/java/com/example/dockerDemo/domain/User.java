package com.example.dockerDemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_det")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "seq")
	private Long Id;
	
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}
}
