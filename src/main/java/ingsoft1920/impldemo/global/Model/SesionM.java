package ingsoft1920.impldemo.global.Model;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.impldemo.global.DAO.SesionDAO;
import ingsoft1920.impldemo.global.Services.RandomHashService;

@Component
@SessionScope
public class SesionM {
	final static Logger logger = LogManager.getLogger(SesionM.class.getName());
	
	UsuarioM usuario;
	String token;
	Timestamp fCaducidad;

	public SesionM() {}
	
	public SesionM(UsuarioM usuario) {
		this.usuario=usuario;
		this.token=RandomHashService.randomString(8);
	}
	
	public UsuarioM getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioM usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getfCaducidad() {
		return fCaducidad;
	}

	public void setfCaducidad(Timestamp fCaducidad) {
		this.fCaducidad = fCaducidad;
	}

	public boolean authMe(String token) {
		if(this.token.equals(token)) {
			String newToken="asdad"; //nueva cadena aleatoria
			setToken(newToken);
			SesionDAO.save(this);
			return true;
		}
		return false;
	}
}
