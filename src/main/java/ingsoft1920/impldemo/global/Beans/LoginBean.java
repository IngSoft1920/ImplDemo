package ingsoft1920.impldemo.global.Beans;

public class LoginBean {
	private String nombreUsuario;
	private String pwd;
	
	public LoginBean() {}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario=nombreUsuario;
	}
	
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}

}
