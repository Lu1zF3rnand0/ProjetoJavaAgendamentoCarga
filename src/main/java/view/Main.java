package view;

import exceptions.ChassiInvalidoException;
import exceptions.MercadoriaInvalidaException;
import exceptions.TamanhoInvalidoException;
import model.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws TamanhoInvalidoException, ChassiInvalidoException, MercadoriaInvalidaException {

        List<Usuario> usuarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Carga> cargas = new ArrayList<>();
        List<Agendamento> agendamentos = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int resp;

        do {

            System.out.println("####### Bem vindo a sistema de cadastro de cargas ###################");
            System.out.println("Escolha uma das opções abaixo para iniciar:\n");
            System.out.println("1 => para Usuario.");
            System.out.println("2 => para Cliente.");
            System.out.println("3 => para Carga.");
            System.out.println("4 => para Agendamento.");
            System.out.println("9 => para Sair.");
            resp = scan.nextInt();

            if(resp == 2 && usuarios.isEmpty()){
                System.out.println("Para cadastrar um cliente é precisa cadastrar ao menos um usuário cadastrado!\n\n");
                resp = 0;
            }

            if(resp == 4 && (clientes.isEmpty() || cargas.isEmpty())){
                System.out.println("Para cadastrar um agendamento é preciso ao menos um cliente e uma carga cadastrada!\n\n");
                resp = 0;
            }

            if (resp == 1) {

                System.out.println("######## Usuario ########");
                System.out.println("1 => para listar.");
                System.out.println("2 => para cadastrar.");
                System.out.println("0 => para voltar.");
                System.out.println("9 => para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de Usuarios ########");
                    if (usuarios.isEmpty()) {
                        System.out.println("Não existe usuarios cadastrados!");
                    } else{
                        usuarios.forEach(System.out::println);
                    }

                    System.out.println("\nDigite 0 para voltar ou 9 para sair:");
                    resp = scan.nextInt();
                }

                if (resp == 2) {
                    Usuario usuario = new Usuario();
                    System.out.println("######## Cadastro de Usuário ########");
                    System.out.println("Informe o nome do usuário:");
                    usuario.setNome(scan.next());

                    System.out.println("Informe o email do usuário:");
                    usuario.setEmail(scan.next());

                    System.out.println("O usuário será administrador? s/n: ");
                    usuario.setAdmin(scan.next().equals("s"));

                    System.out.println("Informe a senha do usuario:");
                    usuario.setSenha(scan.next());

                    usuarios.add(usuario);
                    System.out.println("Usuario " + usuario.getNome() + " cadastrado com sucesso!");
                    resp = 0;
                }
            }

            if (resp == 2) {

                System.out.println("######## Cliente ########");
                System.out.println("1 => para listar.");
                System.out.println("2 => para cadastrar.");
                System.out.println("0 => para voltar.");
                System.out.println("9 => para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de Clientes ########");
                    if (clientes.isEmpty()) {
                        System.out.println("Não existe clientes cadastrados!");
                    } else{
                        clientes.forEach(System.out::println);
                    }

                    System.out.println("\nDigite 1 para voltar ou 4 para sair:");
                    resp = scan.nextInt();
                }

                if (resp == 2) {
                    Cliente cliente = new Cliente();
                    System.out.println("######## Cadastro de Clientes ########");
                    System.out.println("Informe o nome do cliente: ");
                    cliente.setNome(scan.next());

                    System.out.println("Informe o email do cliente: ");
                    cliente.setEmail(scan.next());

                    System.out.println("Informe o telefone do cliente: ");
                    cliente.setTelefone(scan.next());

                    System.out.println("Informe o CNPJ do cliente: ");
                    cliente.setCnpj(scan.next());

                    String userNome = "";
                    do {
                        System.out.println("Informe o nome do usuário desse cliente");
                        String c = scan.next();

                        Usuario u = usuarios.stream()
                                .filter(e -> c.equals(e.getNome()))
                                .findAny()
                                .orElse(null);

                        if ((Objects.isNull(u))) {
                            System.out.println("Usuário informado não existe!");
                        } else {
                            cliente.setUsuario(u);
                            clientes.add(cliente);
                            userNome = u.getNome();
                            System.out.println("Cliente "+ cliente.getNome() +" cadastrado com sucesso!");
                        }

                    } while(userNome.equals(""));
                    resp = 0;
                }
            }

            if (resp == 3) {

                System.out.println("######## Cargas ########");
                System.out.println("1 => para listar.");
                System.out.println("2 => para cadastrar Conteiner.");
                System.out.println("3 => para cadastrar Veiculo.");
                System.out.println("4 => para cadastrar Carga Solta.");
                System.out.println("0 => para voltar.");
                System.out.println("9 => para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de Cargas ########");
                    if (cargas.isEmpty()) {
                        System.out.println("Não existe cargas cadastradas!");
                    } else{
                        cargas.forEach(System.out::println);
                    }

                    System.out.println("\nDigite 0 para voltar ou 9 para sair:");
                    resp = scan.nextInt();
                }

                if (resp == 2) {
                    Conteiner conteiner = new Conteiner();
                    System.out.println("######## Cadastro de Conteiner ########\n");

                    System.out.println("Informe o código do porto do conteiner: ");
                    conteiner.setPorto(scan.next());

                    System.out.println("Informe o navio do usuário: ");
                    conteiner.setNavio(scan.next());

                    System.out.println("Informe o numero de documento do conteiner: ");
                    conteiner.setDocumento(scan.next());

                    System.out.println("Informe o numero do conteiner: ");
                    conteiner.setNumero(scan.next());

                    System.out.println("Informe o status (cheio/vazio) do conteiner: ");
                    conteiner.setStatus(scan.next());

                    System.out.println("Informe o tamanho (20/40) do conteiner: ");
                    conteiner.setTamanho(scan.nextInt());

                    cargas.add(conteiner);
                    System.out.println("Conteiner " + conteiner.getNumero() + " cadastrado com sucesso!");
                    resp = 0;
                }

                if (resp == 3) {
                    Veiculo veiculo = new Veiculo();
                    System.out.println("######## Cadastro de Veiculo ########\n");

                    System.out.println("Informe o código do porto do veiculo: ");
                    veiculo.setPorto(scan.next());

                    System.out.println("Informe o navio do veiculo: ");
                    veiculo.setNavio(scan.next());

                    System.out.println("Informe o numero de documento do veiculo: ");
                    veiculo.setDocumento(scan.next());

                    System.out.println("Informe o chassi do veiculo: ");
                    veiculo.setChassi(scan.next());

                    System.out.println("Informe o modelo do veiculo: ");
                    veiculo.setModelo(scan.next());

                    System.out.println("Informe a montadora do veiculo: ");
                    veiculo.setMontadora(scan.next());

                    cargas.add(veiculo);
                    System.out.println("Veiculo " + veiculo.getChassi() + " cadastrado com sucesso!");
                    resp = 0;
                }

                if (resp == 4) {
                    CargaSolta cargaSolta = new CargaSolta();
                    System.out.println("######## Cadastro de Carga Solta ########\n");

                    System.out.println("Informe o código do porto da carga solta: ");
                    cargaSolta.setPorto(scan.next());

                    System.out.println("Informe o navio da carga solta: ");
                    cargaSolta.setNavio(scan.next());

                    System.out.println("Informe o numero de documento da carga solta: ");
                    cargaSolta.setDocumento(scan.next());

                    System.out.println("Informe a mercadora do cargaSolta: ");
                    cargaSolta.setMercadoria(scan.next());

                    System.out.println("Essa carga solta é IMO? s/n");
                    cargaSolta.setImo(scan.next().equals("s"));

                    System.out.println("Essa carga solta é OOG? s/n");
                    cargaSolta.setOog(scan.next().equals("s"));

                    cargas.add(cargaSolta);
                    System.out.println("Carga Solta " + cargaSolta.getMercadoria() + " cadastrada com sucesso!");
                    resp = 0;
                }
            }

            if (resp == 4) {

                System.out.println("######## Agendamento ########");
                System.out.println("1 => para listar.");
                System.out.println("2 => para cadastrar.");
                System.out.println("0 => para voltar.");
                System.out.println("9 => para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de Agendamentos ########");
                    if (agendamentos.isEmpty()) {
                        System.out.println("Não existe agendamentos cadastrados!");
                    } else{
                        agendamentos.forEach(System.out::println);
                    }

                    System.out.println("\nDigite 0 para voltar ou 9 para sair:");
                    resp = scan.nextInt();
                }

                if (resp == 2) {
                    Agendamento agendamento = new Agendamento();
                    System.out.println("######## Cadastro de Agendamentos ########");
                    System.out.println("Informe o tipo de agendamento (Importação/Exportação): ");
                    agendamento.setTipo(scan.next());

                    System.out.println("Informe a transportadora desse agendamento: ");
                    agendamento.setTransportador(scan.next());

                    String continuar = "s";
                    List<Carga> cs = new ArrayList<>();

                    while (continuar.equals("s")) {
                        do {
                            System.out.println("Informe o documento da carga: ");
                            String doc = scan.next();
                            Carga c = cargas.stream()
                                    .filter(e -> doc.equals(e.getDocumento()))
                                    .findAny()
                                    .orElse(null);
                            if ((Objects.isNull(c))) {
                                System.out.println("Documento informado não existe!");
                                continuar = "";
                            } else {
                                cs.add(c);
                                continuar = "n";
                                System.out.println("Carga adicionado ao agendamento!");
                            }
                        } while (continuar.equals(""));
                        System.out.println("Deseja cadastrar outra carga? s/n");
                        continuar = scan.next();
                    }
                    agendamento.setCargas(cs);

                    String clientName = "";
                    do {
                        System.out.println("Informe o nome do cliente desse agendamento: ");
                        String nome = scan.next();

                        Cliente c = clientes.stream()
                                .filter(e -> nome.equals(e.getNome()))
                                .findAny()
                                .orElse(null);

                        if ((Objects.isNull(c))) {
                            System.out.println("Cliente informado não existe!");
                        } else {
                            agendamento.setCliente(c);
                            agendamentos.add(agendamento);
                            clientName = c.getNome();
                            System.out.println("Cliente "+ c.getNome() +" adicionado ao agendamento!");
                            System.out.println("Agendamento numero"+ agendamento.getId() +" cadastradp com sucesso!");
                        }
                    } while(clientName.equals(""));
                    resp = 0;

                }
            }


        }while(resp != 9);


    }
}
