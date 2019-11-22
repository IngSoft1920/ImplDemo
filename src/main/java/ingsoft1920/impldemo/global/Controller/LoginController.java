package ingsoft1920.impldemo.global.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.impldemo.global.Beans.LoginBean;
import ingsoft1920.impldemo.global.DAO.SesionDAO;
import ingsoft1920.impldemo.global.DAO.UsuarioDAO;
import ingsoft1920.impldemo.global.Model.SesionM;
import ingsoft1920.impldemo.global.Model.UsuarioM;

@Controller
public class LoginController {
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@PostMapping("/login")
	public String logMe(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			HttpServletResponse httpResponse) {
		
		UsuarioM usuario = UsuarioDAO.getUsuarioByNombreUsuario(loginBean.getNombreUsuario(), null);
		
		if(usuario.logMe(loginBean)) {
			SesionM sesion = new SesionM(usuario);
			sesion = SesionDAO.save(sesion);
			if(sesion==null) {
				return "login";
			}
			httpResponse.addCookie(new Cookie("usuario",sesion.getUsuario().getNombreUsuario()));
			httpResponse.addCookie(new Cookie("tokenId",sesion.getToken()));
			return "welcome";
		}
		
		return "login";
	}
}
