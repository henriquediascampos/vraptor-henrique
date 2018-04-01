package br.com.caelum.vraptor.modelos.conta;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.caelum.vraptor.modelos.modeloGenerico.ModeloGenerico;
import br.com.caelum.vraptor.modelos.usuario.Usuario;

@Entity
public class contas extends ModeloGenerico{
	@Id
	@SequenceGenerator(name= "mysequencie", sequenceName="seq_cont_id", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="mysequence")
	private Long id;

	@Column
	private String nome;
	
	@Column(precision = 12, scale = 4)
	private BigDecimal valor;
	
	@Column(name= "quantidade_parcelas")
	private Integer quantidadeParcelas;
	
	@Column
	private Character paga;
	
	@Column
	private Character tipo;
	
	@Column(name= "parcelas_pagas")
	private Integer parcelasPagas;
	
	@Column(name= "dt_quitar")
	private Date dtQuitar;
	
	@ManyToOne
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Character getPaga() {
		return paga;
	}

	public void setPaga(Character paga) {
		this.paga = paga;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
