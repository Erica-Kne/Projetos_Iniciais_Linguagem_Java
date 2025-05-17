package banco;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String titular;
		int numeroConta;
		int opcao = 0;
		double saque, deposito;
		
		System.out.print("Titular: ");
		titular = sc.nextLine();
		System.out.print("Nº da conta: ");
		numeroConta = sc.nextInt();
		
		ContaBancaria conta = new ContaBancaria(titular, numeroConta);
		
		do {
			System.out.print("1)Verificar saldo"
					+ "\n2)Realizar saque"
					+ "\n3)Realizar deposito"
					+ "\n4)Sair\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Saldo disponivel: R$ " + conta.getSaldo());
				break;
			case 2:
				System.out.print("Valor a ser sacado: ");
				saque = sc.nextDouble();
				conta.sacar(saque);
				break;
			case 3:
				System.out.print("Valor a ser depositado: ");
				deposito = sc.nextDouble();
				conta.depositar(deposito);
				break;
			case 4:
				break;
			default:
				System.out.println("Opcao invalida");
				}
			} while(opcao != 4);
		
		
		sc.close();

	}

}
