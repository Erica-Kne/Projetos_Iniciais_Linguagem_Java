package banco;

public class ContaBancaria {
	
	private String titular;
	private int numeroConta;
	private double saldo;
	
	
	
	public String getTitular() {
		return titular;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public ContaBancaria(String titular, int numeroConta) {
		this.titular = titular;
		this.numeroConta = numeroConta;
	}
	public String toString() {
		return "Titular: " + titular + "\nNº da conta: " + numeroConta + "\nSaldo: R$ " + saldo;
	}
	public void depositar(double deposito) {
		if( deposito <= 0.0) {
			System.out.println("Valor invalido.\n");
		} else {
			saldo += deposito;
			System.out.println("Deposito realizado com sucesso.\n");
		}
	}
	public void sacar(double saque) {
		if (saque <= 0.0) {
			System.out.print("Saque invalido.\n");
		} else if(saque > saldo){ 
			System.out.print("Saldo insuficiente.\n");
		} else {
			saldo = saldo - saque;
			System.out.print("Saque realizado com sucesso.\n");
		}
	}

}
