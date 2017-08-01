package Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.jpamodelgen.xml.jaxb.GenerationType;

@Entity
@Table(name = "DIFICULDADE")
public class Dificuldade {
	
	private int id;
	private String descricao;
	private Set<Palavra> palavras;
	
	
	public Dificuldade() {
		
	}
	
	public Dificuldade(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	
	@Id
	@Column(name="DIFICULDADE_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "DIFICULDADE_DESCRICAO")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dificuldade")
	public Set<Palavra> getPalavras() {
		return palavras;
	}
	*/

	public void setPalavras(Set<Palavra> palavras) {
		this.palavras = palavras;
	}

	@Override
	public String toString() {
		return "Dificuldade [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	

}
