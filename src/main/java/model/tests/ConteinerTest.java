package model.tests;

import exceptions.PortoInvalidoException;
import exceptions.TamanhoInvalidoException;
import model.domain.Conteiner;

public class ConteinerTest {

	public static void main(String[] args) {

		try {
			Conteiner conteiner = new Conteiner("MSC TESTE", "21/123456-7", "BRRIO");
			conteiner.setNumero("MSCU123456");
			conteiner.setStatus("Vazio");
			conteiner.setTamanho(20);
			System.out.println(conteiner);
			System.out.println(conteiner.retornaNavio());
		} catch (PortoInvalidoException | TamanhoInvalidoException e) {
			System.out.println(e.getMessage());

		}
		
		
		try {
			Conteiner conteiner = new Conteiner("MSC TESTE", "21/123456-7", "BRRIO");
			conteiner.setNumero("MSCU654321");
			conteiner.setStatus("Cheio");
			conteiner.setTamanho(40);
			System.out.println(conteiner);
			System.out.println(conteiner.retornaNavio());
		} catch (PortoInvalidoException | TamanhoInvalidoException e) {
			System.out.println(e.getMessage());

		}
		


	}
}
