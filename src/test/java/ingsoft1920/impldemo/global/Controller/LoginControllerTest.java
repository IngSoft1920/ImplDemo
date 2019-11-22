package ingsoft1920.impldemo.global.Controller;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import ingsoft1920.impldemo.global.Beans.LoginBean;
import ingsoft1920.impldemo.global.DAO.UsuarioDAO;
import ingsoft1920.impldemo.global.Model.UsuarioM;

@Controller
public class LoginControllerTest {
	@Autowired
	UsuarioDAO usuarioDAO;

	@Test
	public void logMeTest(@Valid @ModelAttribute("loginBean") LoginBean loginBean) {
		UsuarioM usuario = usuarioDAO.getUsuarioByNombreUsuario(loginBean.getNombreUsuario(), null);
		boolean a =usuario.logMe(loginBean);
		return;
	}
}
