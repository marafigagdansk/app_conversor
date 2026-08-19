package br.com.unicuritiba.sgc.models;

public class Caminhao extends Veiculo {
	
	public Caminhao(String placa, String marca, String modelo, String cor, String motor, String ano) {
		super(placa, marca, modelo, cor, motor, ano);
		
	}
	
	private  int eixos;
	private boolean isBiTruck;
	
	
	
	
	
	public Caminhao(String placa, String marca, String modelo, String cor, String motor, String ano, int eixos,
			boolean isBiTruck) {
		super(placa, marca, modelo, cor, motor, ano);
		setEixos(eixos);
		setBiTruck(isBiTruck);
	}
	
	public int getEixos() {
		return eixos;
	}
	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	public boolean isBiTruck() {
		return isBiTruck;
	}
	public void setBiTruck(boolean isBiTruck) {
		this.isBiTruck = isBiTruck;
	}

}
