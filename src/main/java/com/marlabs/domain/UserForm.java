package com.marlabs.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UserForm {

//	public static final String regexPhone = "^[1]([3-9])[0-9]{9}$/";

	@NotBlank
	private String username;
	@NotBlank
	@Length(min = 3, message = "Minimum=6")
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String cell;

	public UserForm() {
		super();
	}

	public User convertToUser(UserForm userForm) {
		User user = new User();
		user.setCell(userForm.getCell());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setEmail(userForm.getEmail());
		return user;
	}

	@Override
	public String toString() {
		return "UserForm [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", email=" + email + ", cell=" + cell + "]";
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cell
	 */
	public String getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}

}
