package trabalho1;

import java.util.Scanner;

public class GestaoMoto {

    public static void main(String[] args) {
        int escolha;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n======= Gestão de Motos =======\n\n1 - Cadastrar moto;\n2 - Visualizar motos;\n3 - Visualizar uma moto;\n4 - Utualizar dados de uma moto;\n5 - Deletar uma moto do Gerenciador;\n0 - Fechar o sistema;\nEscolha uma ação: ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 0 -> {
                    System.out.println("\nFechando o sistema......");
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("\nCadastrar Moto no Sistema: ");
                    Gerenciamento.cadastrarMoto();
                }
                case 2 -> {
                    System.out.println("\nListar todas as motos cadastradas: ");
                    System.out.println(Gerenciamento.listarMotos());
                }
                case 3 -> {
                    System.out.println("\nVisualizar informações de uma moto: ");
                    Gerenciamento.consultarMoto();
                }
                case 4 -> {
                    System.out.println("\nAtualizar dados de uma moto: ");
                    Gerenciamento.atualizarMoto();
                }
                case 5 -> {
                    System.out.println("\nExcluir cadastro de uma moto: ");
                    Gerenciamento.exluirMoto();
                }
                default -> System.out.println("\nOpção inválida escolha outra opção!");
            }

        } while (escolha != 0);

    }
}
