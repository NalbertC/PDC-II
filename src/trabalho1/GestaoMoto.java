package trabalho1;

import java.util.Scanner;

public class GestaoMoto {

    public static void main(String[] args) {
        int escolha;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n======= Gestão de Motos =======\n\n1 - Cadastrar moto;\n2 - Visualizar motos;\n3 - Utualizar dados de uma moto;\n4 - Deletar uma moto do Gerenciador;\n0 - Fechar o sistema;\nEscolha uma ação: ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("\nFechando o sistema......");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nCadastrar Moto no Sistema:");

                    Gerenciamento.cadastrarMoto();
                    break;
                case 2:
                    System.out.println("\nListar todas as motos cadastradas:");
                    System.out.println(Gerenciamento.consultarMoto());
                   
                    break;
                case 3:
                    System.out.println("\nAtualizar dados de uma moto:");
                    break;
                case 4:
                    System.out.println("\nExcluir cadastro de uma moto:");
                    break;
                default:
                    System.out.println("\nOpção inválida escolha outra opção!");
            }

        } while (escolha != 0);

    }
}
