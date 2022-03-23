package model.tests;

import exceptions.ChassiInvalidoException;
import exceptions.MercadoriaInvalidaException;
import exceptions.PortoInvalidoException;
import exceptions.TamanhoInvalidoException;
import model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoTest {

	public static void main(String[] args) {

		List<Carga> cargas = new ArrayList<>();

		try {
			Conteiner conteiner = new Conteiner("MSC TESTE", "21/123456-7", "BRRIO");
			conteiner.setNumero("MSCU123456");
			conteiner.setStatus("Cheio");
			conteiner.setTamanho(40);
			cargas.add(conteiner);
		} catch (PortoInvalidoException | TamanhoInvalidoException e) {
			System.out.println(e.getMessage());

		}

		try {
			CargaSolta cargaSolta = new CargaSolta("MSC TESTE", "21/765432-1", "BRRIO");
			cargaSolta.setImo(false);
			cargaSolta.setOog(true);
			cargaSolta.setMercadoria("Tubos");
			cargas.add(cargaSolta);
		} catch (PortoInvalidoException | MercadoriaInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
		Veiculo veiculo = new Veiculo("MSC TESTE", "21/123456-3", "BRRIO");
		veiculo.setChassi("9BGRD08X04G117971");
		veiculo.setModelo("208");
		veiculo.setMontadora("Peugeot");
		cargas.add(veiculo);
		} catch (PortoInvalidoException | ChassiInvalidoException e) {
			System.out.println(e.getMessage());
		}

		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setCnpj("12.123.456/7890-12");
		cliente.setNome("MSC");
		cliente.setTelefone("21 1234-5678");
		cliente.setEmail("cliente@cliente.com");

		Agendamento agendamento = new Agendamento();
		agendamento.setId(1);
		agendamento.setTipo("Importacao");
		agendamento.setTransportador("TestTransp");
		agendamento.setCliente(cliente);
		agendamento.setCargas(cargas);

		System.out.println(agendamento);

	}

}
