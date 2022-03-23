package view;

import model.domain.Cliente;
import model.domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int resp;

        do {

            System.out.println("####### Bem vindo a sistema de cadastro de cargas ###################");
            System.out.println("Escolha uma das opções abaixo para iniciar:\n");
            System.out.println("1 para Usuario.");
            System.out.println("2 para Cliente.");
            System.out.println("4 para Sair.");
            resp = scan.nextInt();

            if (resp == 1) {

                System.out.println("######## Usuario ########");
                System.out.println("1 para listar.");
                System.out.println("2 para cadastrar.");
                System.out.println("4 para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de Usuarios ########");
                    if (usuarios.size() <= 0) {
                        System.out.println("Não existe usuarios cadastrados!");
                    } else{
                        usuarios
                                .forEach(System.out::println);
                    }

                    System.out.println("\nDigite 1 para voltar ou 4 para sair:");
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
                    resp = 1;
                }
            }


            if (resp == 2) {

                System.out.println("######## Cliente ########");
                System.out.println("1 para listar.");
                System.out.println("2 para cadastrar.");
                System.out.println("4 para sair.");
                resp = scan.nextInt();

                if (resp == 1) {
                    System.out.println("\n\n######## Lista de CLlentes ########");
                    if (clientes.size() <= 0) {
                        System.out.println("Não existe clientes cadastrados!");
                    } else{
                        clientes
                                .forEach(System.out::println);
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

                }
            }


        }while(resp != 4);


    }
}
