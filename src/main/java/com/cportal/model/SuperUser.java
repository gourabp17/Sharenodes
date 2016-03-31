/*package com.cportal.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class SuperUser {
	
	@Size(min=2, max=30)
    private String regName;
	
	@Size(min=2, max=30)
    private String regComp;
	
	@NotEmpty @Email
    private String regEmail;
	
	@NotNull @NumberFormat(style = Style.NUMBER) @Min(10) @Max(20)
    private String regMobile;
	
	@NotEmpty @Size(min=2, max=30)
    private String regPwd;
	
	@NotEmpty @Size(min=2, max=30)
    private String reRegPwd;
	
	@Size(min=5, max=5) @NotEmpty
    private String captcha;
    
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegComp() {
		return regComp;
	}
	public void setRegComp(String regComp) {
		this.regComp = regComp;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getRegMobile() {
		return regMobile;
	}
	public void setRegMobile(String regMobile) {
		this.regMobile = regMobile;
	}
	public String getRegPwd() {
		return regPwd;
	}
	public void setRegPwd(String regPwd) {
		this.regPwd = regPwd;
	}
	public String getReRegPwd() {
		return reRegPwd;
	}
	public void setReRegPwd(String reRegPwd) {
		this.reRegPwd = reRegPwd;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}*/