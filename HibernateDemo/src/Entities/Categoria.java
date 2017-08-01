package Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
	
	private int categoria_id;
	private String categoria_descricao;
	private Set<Palavra> palavras;
	
	public Categoria() {
	}
	
	public Categoria(int categoria_id, String categoria_descricao) {
		this.categoria_id = categoria_id;
		this.categoria_descricao = categoria_descricao;
	}
	
			
	@Id
	@Column(name="CATEGORIA_ID")
	public int getCategoria_id() {
		return categoria_id;
	} 

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	@Column(name="CATEGORIA_DESCRICAO")
	public String getCategoria_descricao() {
		return categoria_descricao;
	}

	public void setCategoria_descricao(String categoria_descricao) {
		this.categoria_descricao = categoria_descricao;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaCategoria")
	public Set<Palavra> getListapalavras() {
		return palavras;
	}

	public void setListapalavras(Set<Palavra> listapalavras) {
		this.palavras = listapalavras;
	}
	
	
	
	
}
