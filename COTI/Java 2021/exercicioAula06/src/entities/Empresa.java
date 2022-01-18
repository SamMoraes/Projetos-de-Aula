package entities;

import java.util.Objects;

public class Empresa {

	private Integer idEmpresa;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;

	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	public Empresa(Integer idEmpresa, String nomeFantasia, String razaoSocial, String cnpj) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial
				+ ", cnpj=" + cnpj + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, idEmpresa, nomeFantasia, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(idEmpresa, other.idEmpresa)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial);
	}
	
	
}
