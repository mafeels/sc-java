package sharecards.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {
	String primeiroNome, ultimoNome, username, dataNascimento, senha, email;

	@Test
	public void testSenha() throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException{
		Usuario user = new Usuario("Will", "Masa", "WillMasa000", "12/4/01", "auguaargorua", "ieawmmf@mauifehna.asf");
		Assert.assertEquals(true, user.checkSenha("auguaargorua"));
	}
}
