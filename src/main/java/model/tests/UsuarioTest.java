package model.tests;
import model.domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UsuarioTest {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setEmail("luiz@gmail.com");
        usuario.setNome("Luiz");
        usuario.setAdmin(true);
        usuario.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("marcio@gmail.com");
        usuario2.setNome("Marcio");
        usuario2.setAdmin(false);
        usuario2.setSenha("123");


        Scanner scan = new Scanner(System.in);
        String [] nomes = new String[2];


        System.out.println("Digite seu nome1: ");
        nomes [0] = scan.nextLine();

        System.out.println("Digite seu nome2: ");
        nomes [1] = scan.nextLine();

        System.out.println(nomes.toString());


        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(usuario);
        usuarios.add(usuario2);

        Usuario u = usuarios.stream()
                .filter(e -> "Marcio".equals(e.getNome()))
                .findAny()
                .orElse(null);


        if ((Objects.isNull(u))) {
            System.out.println("Está vazio");
        } else {
            System.out.println(u.getNome());
        }


        List<Usuario> admins = usuarios.stream()
                .filter(e-> !e.isAdmin())
                .collect(Collectors.toList());

        admins.forEach(System.out::println);


//        System.out.println(usuario);
    }
}
