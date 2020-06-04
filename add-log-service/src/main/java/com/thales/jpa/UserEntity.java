package com.thales.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	private long userId;

	@Column(name = "USER_NAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ACTIVE")
	private int active;

	@Column(name = "ROLES")
	private String roles = "";

	@Column(name = "PERMISSIONS")
	private String permissions = "";

	public long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getActive() {
		return active;
	}

	public String getRoles() {
		return roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public List<String> getRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getPermissionList() {
		if (this.permissions.length() > 0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}
}
