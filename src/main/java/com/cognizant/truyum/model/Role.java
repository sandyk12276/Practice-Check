package com.cognizant.truyum.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ro_id")
	private int id;
	
	@Column(name="ro_name")
	private String roleName;
	
	@ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
	private Set<User> userList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", userList=" + userList + "]";
	}

	/*
	 * public Role(int id, String roleName, Set<User> userList) { super(); this.id =
	 * id; this.roleName = roleName; this.userList = userList; }
	 */
	
	
}
