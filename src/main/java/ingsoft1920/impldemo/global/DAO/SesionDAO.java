package ingsoft1920.impldemo.global.DAO;

import ingsoft1920.impldemo.global.Model.SesionM;

public class SesionDAO {
	public static SesionM save(SesionM sesion) {
		//proceso de update en bbdd
		
		//Cambiar a null ultimo parametro
		return getSesionByToken(sesion.getToken(), sesion.getUsuario().getNombreUsuario(), sesion);
	}
	
	public static SesionM getSesionByToken(String token, String usuario, SesionM retTest) {
		//retrieve de bbdd
		return retTest;
	}
}
