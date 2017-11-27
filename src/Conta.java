public class Conta implements Comparable<Conta>{
	private double saldo;
	private String titular;
	private int numero;
	private int agencia;

	public void saca(double valor) throws Exception {
		if (saldo >= valor) {
			this.saldo -= valor;
		} else {
			// Exception de RuntimeException
			// throw new SaldoInsuficienteException(saldo);
			throw new RuntimeException();
		}
	}

	public synchronized void deposita(double valor) {
		this.saldo += valor;
	}

	public Conta(String nome, int agencia, double saldo) {
		this.titular = nome;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public Conta() {
	}

	public String getNome() {
		return titular;
	}

	public void setNome(String nome) {
		this.titular = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta com saldo " + saldo;
	}

	public void imprime() {

		System.out.println(titular);
		System.out.println(agencia);
		System.out.println(saldo);

	}

	
	
	
	
	@Override
	public int compareTo(Conta outra) {
		if(this.saldo < outra.saldo) return -1;
		if(this.saldo > outra.saldo) return 1;
		return 0;
	}
}