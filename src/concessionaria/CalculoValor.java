package concessionaria;

public class CalculoValor {
	// Attributes
	private String icms, ipi, confins, comissaoVendedor, numContrato, taxista, valorTotal;

	// Constuctor
	public CalculoValor(String icms, String ipi, String confins, String comissaoVendedor, String numContrato,
			String taxista, String valorTotal) {
		super();
		this.icms = icms;
		this.ipi = ipi;
		this.confins = confins;
		this.comissaoVendedor = comissaoVendedor;
		this.numContrato = numContrato;
		this.taxista = taxista;
		this.valorTotal = valorTotal;
	}

	// Get Set
	public String getIcms() {
		return icms;
	}

	public void setIcms(String icms) {
		this.icms = icms;
	}

	public String getIpi() {
		return ipi;
	}

	public void setIpi(String ipi) {
		this.ipi = ipi;
	}

	public String getConfins() {
		return confins;
	}

	public void setConfins(String confins) {
		this.confins = confins;
	}

	public String getComissaoVendedor() {
		return comissaoVendedor;
	}

	public void setComissaoVendedor(String comissaoVendedor) {
		this.comissaoVendedor = comissaoVendedor;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getTaxista() {
		return taxista;
	}

	public void setTaxista(String taxista) {
		this.taxista = taxista;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

}