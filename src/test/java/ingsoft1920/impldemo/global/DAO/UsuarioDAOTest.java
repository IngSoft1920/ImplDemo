package ingsoft1920.impldemo.global.DAO;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import ingsoft1920.impldemo.global.Model.UsuarioMTest;

@Component
public class UsuarioDAOTest {
	ConcurrentHashMap<String, UsuarioMTest> cache;
	
	public UsuarioDAOTest() {
		cache = new ConcurrentHashMap<String, UsuarioMTest>();
	}
	
	public UsuarioMTest getUsuarioByNombreUsuario(String nombreUsuario) {
		if(this.cache.get(nombreUsuario)!=null) {
			return this.cache.get(nombreUsuario);
		}else {
			//Linea que simula acceso a BBDD
			UsuarioMTest us = new UsuarioMTest();
			
			this.cache.put(nombreUsuario, us);
			return us;
		}		
	}
}
