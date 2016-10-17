package pii.main;

public class Linea {

	private String numero;
	private String lugarSalida;
	private String horaSalida;
	private String lugarLlegada;
	private String horaLlegada;

	public Linea(String numero, String lugarSalida, String horaSalida, String lugarLlegada, String horaLlegada) {
		super();
		this.numero = numero;
		this.lugarSalida = lugarSalida;
		this.horaSalida = horaSalida;
		this.lugarLlegada = lugarLlegada;
		this.horaLlegada = horaLlegada;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLugarSalida() {
		return lugarSalida;
	}

	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getLugarLlegada() {
		return lugarLlegada;
	}

	public void setLugarLlegada(String lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	@Override
	public String toString() {
		return getNumero() + "*" + getLugarSalida() + "*" + getHoraSalida() + "*" + getLugarLlegada() + "*"
				+ getHoraLlegada();
	}
	

}
