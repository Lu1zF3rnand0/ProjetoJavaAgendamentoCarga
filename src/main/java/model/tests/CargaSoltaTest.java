package model.tests;

import exceptions.MercadoriaInvalidaException;
import exceptions.PortoInvalidoException;
import model.domain.CargaSolta;

public class CargaSoltaTest {

	public static void main(String[] args) {
		
		try {
			CargaSolta cargaSolta = new CargaSolta("MSC TESTE", "21/765432-1", "BRRIO");
			cargaSolta.setImo(false);
			cargaSolta.setOog(true);
			cargaSolta.setMercadoria("Tubos");
			System.out.println(cargaSolta);
		} catch (PortoInvalidoException | MercadoriaInvalidaException e) {
			System.out.println(e.getMessage());
		}

	}

}
