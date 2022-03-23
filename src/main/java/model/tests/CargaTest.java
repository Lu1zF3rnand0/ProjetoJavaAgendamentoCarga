package model.tests;

import exceptions.ChassiInvalidoException;
import exceptions.MercadoriaInvalidaException;
import exceptions.PortoInvalidoException;
import exceptions.TamanhoInvalidoException;
import model.domain.CargaSolta;
import model.domain.Conteiner;
import model.domain.Veiculo;

public class CargaTest {

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
			CargaSolta cargaSolta = new CargaSolta("MSC TESTE", "21/765432-1", "BRRIO");
			cargaSolta.setImo(false);
			cargaSolta.setOog(true);
			cargaSolta.setMercadoria("Tubos");
			System.out.println(cargaSolta);
			System.out.println(cargaSolta.retornaNavio());
		} catch (PortoInvalidoException | MercadoriaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
		Veiculo veiculo = new Veiculo("MSC TESTE", "21/123456-3", "BRRIO");
		veiculo.setChassi("9BGRD08X04G117975");
		veiculo.setModelo("208");
		veiculo.setMontadora("Peugeot");
		System.out.println(veiculo);
		System.out.println(veiculo.retornaNavio());
		} catch (PortoInvalidoException | ChassiInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
