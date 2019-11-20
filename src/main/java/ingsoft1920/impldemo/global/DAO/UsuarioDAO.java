package ingsoft1920.impldemo.global.DAO;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import ingsoft1920.impldemo.global.Model.UsuarioM;

@Component
public class UsuarioDAO {
	ConcurrentHashMap<String, UsuarioM> cache;
	
	public UsuarioDAO() {
		cache = new ConcurrentHashMap<String, UsuarioM>();
	}
	
	public UsuarioM getUsuarioByNombreUsuario(String nombreUsuario) {
		if(this.cache.get(nombreUsuario)!=null) {
			return this.cache.get(nombreUsuario);
		}else {
			//Linea que simula acceso a BBDD
			UsuarioM us = new UsuarioM();
			
			this.cache.put(nombreUsuario, us);
			return us;
		}		
	}
}
