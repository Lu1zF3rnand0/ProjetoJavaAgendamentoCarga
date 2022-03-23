package model.tests;

import model.domain.Cliente;
import model.domain.Usuario;

public class ClienteTest {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setEmail("luiz@gmail.com");
		usuario.setNome("Luiz");
		usuario.setAdmin(true);
		usuario.setSenha("123");

		Cliente cliente = new Cliente();
		cliente.setCnpj("12.123.456/7890-12");
		cliente.setNome("MSC");
		cliente.setTelefone("21 1234-5678");
		cliente.setEmail("cliente@cliente.com");
		cliente.setUsuario(usuario);

		System.out.println(cliente);




	}

}
