package ingsoft1920.impldemo.global.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.impldemo.global.Beans.SignupBean;
import ingsoft1920.impldemo.global.Model.UsuarioM;

@Controller
public class SignupController {
	final static Logger logger = LogManager.getLogger(SignupController.class.getName());

	
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("signupBean") SignupBean signupBean) {
		UsuarioM newUsuario = new UsuarioM();
		newUsuario.signup(signupBean);
		
		return "";
	}
}
