package ingsoft1920.impldemo.global.DAO;

import ingsoft1920.impldemo.global.Model.UsuarioM;

public class UsuarioDAO {
	
	public UsuarioDAO() {}
	
	public static UsuarioM getUsuarioByNombreUsuario(String nombreUsuario, UsuarioM retTest) {
		if(retTest!=null) {
			return retTest;
		}
		return null;
	}

	public static UsuarioM save(UsuarioM usuarioM) throws Exception {
		//Guardar en DB
		
		
		usuarioM.setIdUsuario(1);
		return usuarioM;		
	}
}
