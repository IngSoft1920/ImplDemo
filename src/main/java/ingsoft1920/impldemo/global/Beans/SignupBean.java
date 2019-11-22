package ingsoft1920.impldemo.global.Beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignupBean {
	final static Logger logger = LogManager.getLogger(SignupBean.class.getName());

	String nombreUsuario;
	String pwd;
	String email;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
