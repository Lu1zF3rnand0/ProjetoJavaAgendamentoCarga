package model.tests;

import exceptions.ChassiInvalidoException;
import exceptions.PortoInvalidoException;
import model.domain.Veiculo;

public class VeiculoTest {

	public static void main(String[] args) {
		
		try {
		Veiculo veiculo = new Veiculo("MSC TESTE", "21/123456-3", "BRRIO");
		veiculo.setChassi("9BGRD08X04G117971");
		veiculo.setModelo("208");
		veiculo.setMontadora("Peugeot");
		} catch (PortoInvalidoException | ChassiInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
