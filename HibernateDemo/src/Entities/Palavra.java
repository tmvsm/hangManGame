package Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PALAVRA")	
public class Palavra {
	
	private int palavra_id;
	private String descricao;
	private Dificuldade dificuldade;
	private Set<Categoria> listaCategoria;
	
	public Palavra() {
	}
	
	public Palavra(int palavra_id, String descricao, int tamanho) {
		this.palavra_id = palavra_id;
		this.descricao = descricao;
	}
	
	@Id
	@Column(name="PALAVRA_ID")
	public int getId() {
	return palavra_id;
	}
	public void setId(int palavra_id) {
		this.palavra_id = palavra_id;
	}
	@Column(name="PALAVRA_DESCRICAO")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PALAVRA_CATEGORIA", joinColumns = {
			@JoinColumn(name = "PALAVRA_ID") },
			inverseJoinColumns = { @JoinColumn(name = "CATEGORIA_ID") })
	public Set<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(Set<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	@Override
	public String toString() {
		return "Palavra [palavra_id=" + palavra_id + ", descricao=" + descricao + ", dificuldade=" + dificuldade + "]";
	}
	
	
		
}
