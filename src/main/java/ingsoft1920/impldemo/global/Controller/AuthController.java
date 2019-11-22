package ingsoft1920.impldemo.global.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.impldemo.global.DAO.SesionDAO;
import ingsoft1920.impldemo.global.Model.SesionM;

@Controller
public class AuthController {

	@PostMapping("/auth")
	public String authMe(String nombreUsuario, String token) {
		SesionM sesion = SesionDAO.getSesionByToken(token, nombreUsuario, null);
		if(sesion!=null) {
			if(sesion.authMe(token)) {
				return "welcome";
			}
			return "login";
		}
		return "login";
	}
}
