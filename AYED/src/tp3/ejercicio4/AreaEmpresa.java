package tp3.ejercicio4;

public class AreaEmpresa {
	private String identificador;
	private int delay;
	
	public AreaEmpresa(String identificador, int delay) {
		this.identificador = identificador;
		this.delay = delay;
	}
	
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	}
