package ingsoft1920.impldemo.global.Model;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ingsoft1920.impldemo.common.AbstractClasses.ClienteAC;
import ingsoft1920.impldemo.global.Beans.LoginBean;
import ingsoft1920.impldemo.global.Beans.SignupBean;
import ingsoft1920.impldemo.global.DAO.UsuarioDAO;
import ingsoft1920.impldemo.global.Services.RandomHashService;

public class UsuarioM extends ClienteAC {
	final static Logger logger = LogManager.getLogger(UsuarioM.class.getName());
	
	int idUsuario;
	String nombreUsuario;
	String pwdHash;
	String pwdSalt;
	String email;
	boolean activo;
	Timestamp fRegistro;	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public String getPwdSalt() {
		return pwdSalt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Timestamp getfRegistro() {
		return fRegistro;
	}

	public void setfRegistro(Timestamp fRegistro) {
		this.fRegistro = fRegistro;
	}

	public boolean logMe(LoginBean loginBean) {
		String hashtext = RandomHashService.hashSHA256(loginBean.getPwd()+this.pwdSalt);
	    return this.pwdHash.equals(hashtext);
	}
	
	public UsuarioM signup(SignupBean signupBean) {
		this.nombreUsuario=signupBean.getNombreUsuario();
		this.email=signupBean.getEmail();
		
		String pwdPlana = signupBean.getPwd();
		this.pwdSalt=RandomHashService.randomString(16);
		pwdPlana+=pwdSalt;
		
		String pwdHash=RandomHashService.hashSHA256(pwdPlana);
		if(pwdHash==null) {
			return null;
		}
		this.pwdHash=pwdHash;
		
		this.activo=true;
		this.fRegistro= new Timestamp(Calendar.getInstance().getTime().getTime());
		
		try {
			return UsuarioDAO.save(this);
		}catch(Exception ex) {
			logger.info(ex.getLocalizedMessage());
			return null;
		}
	}
}
