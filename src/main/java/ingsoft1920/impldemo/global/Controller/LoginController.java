package ingsoft1920.impldemo.global.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import ingsoft1920.impldemo.global.Beans.LoginBean;
import ingsoft1920.impldemo.global.DAO.UsuarioDAO;
import ingsoft1920.impldemo.global.Model.UsuarioM;

@Controller
public class LoginController {
	@Autowired
	UsuarioDAO usuarioDAO;

	public String logMe(@Valid @ModelAttribute("loginBean") LoginBean loginBean) {
		UsuarioM usuario = usuarioDAO.getUsuarioByNombreUsuario(loginBean.getNombreUsuario());
		
		return usuario.logMe(loginBean)?"welcome":"error";
	}
}
