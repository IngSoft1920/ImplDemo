package ingsoft1920.impldemo.global.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ingsoft1920.impldemo.global.Beans.LoginBean;
import ingsoft1920.impldemo.global.Beans.SignupBean;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioMTest {
	
	@Test
	public void testLogMe_Correct() {
		SignupBean signup = new SignupBean();
		signup.setNombreUsuario("jovace");
		signup.setPwd("jovacePrueba");
		UsuarioM us = new UsuarioM();
		us.signup(signup);
		
		LoginBean login = new LoginBean();
		login.setNombreUsuario("jovace");
		login.setPwd("jovacePrueba");
		
		assertEquals(true,us.logMe(login));
	}
	
	@Test
	public void testSignup_Correct() {
		SignupBean signup = new SignupBean();
		signup.setNombreUsuario("jovace");
		signup.setPwd("jovacePrueba");
		
		UsuarioM us = new UsuarioM();
		us.signup(signup);
		
		assertNotEquals(0, us.getIdUsuario());
		
	}
	
//	@Before
//	public void startSpring() {
//		String[] arg= {};
//		ImpldemoApplication.main(arg);
//	}
	
}
