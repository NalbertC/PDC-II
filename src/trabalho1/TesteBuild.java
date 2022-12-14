package trabalho1;

import java.util.Scanner;

public class TesteBuild {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a marca da moto: ");
        String marca = sc.nextLine();
        System.out.println("Digite o modelo da moto: ");
        String modelo = sc.nextLine();
        System.out.println("Digite a cor da moto: ");
        String cor = sc.nextLine();
        
        Moto moto = new Moto.MotoBuilder()
                .id(23)
                .marca(marca)
                .modelo(modelo)
                .cor(cor)
                .ano(2022)
                .build();

        System.out.println(moto);

    }

}
