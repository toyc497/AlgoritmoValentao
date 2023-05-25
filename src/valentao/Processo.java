package valentao;

import java.util.Objects;
import java.util.Random;

public class Processo {
	
	private Integer id;
	
	private Integer coordenador;
	
	private boolean ativo;
	
	public Processo(Integer id) {
		this.id = id;
		this.coordenador = 7;
		this.ativo = true;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCoordenador() {
		return coordenador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCoordenador(Integer coordenador) {
		this.coordenador = coordenador;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean processoAtivo() {
		
		Random gerador = new Random();
		int valorAtivo = gerador.nextInt(2);
		
		if(valorAtivo == 0) {
			this.ativo = false;
		}else {
			this.ativo = true;
		}
		
		return ativo;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, coordenador, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		return ativo == other.ativo && Objects.equals(coordenador, other.coordenador) && Objects.equals(id, other.id);
	}
	
}
