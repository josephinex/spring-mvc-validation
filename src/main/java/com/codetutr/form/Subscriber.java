package com.codetutr.form;

import java.util.Date;

import javax.validation.GroupSequence;
import javax.validation.constraints.*;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.codetutr.validator.Phone;
import com.codetutr.validator.Year;
//@GroupSequence(name="default", sequence={"basic", "complex"})
public class Subscriber {

	@NotBlank(message="not empty", groups=ValidateBean.class)
	@Pattern(regexp = "^[0-9]$", groups = Default.class)
	private String name;
	
	@NotEmpty @Email
	private String email;
	
	@NotNull
	private Integer age;
	
	@Size(min=10) @Phone
	private String phone;
	
	@NotNull
	private Gender gender;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past @Year(1989)
	private Date birthday;
	
	private Boolean receiveNewsletter;
	
	public enum Gender {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(Boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	@Override
	public String toString() {
		return "Subscriber [name=" + name + ", email=" + email + ", age=" + age
				+ ", phone=" + phone + ", gender=" + gender + ", birthday="
				+ birthday + ", receiveNewsletter=" + receiveNewsletter + "]";
	}
	
}
