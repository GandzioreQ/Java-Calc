package credit_calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.Math;

@Named
@RequestScoped

public class CreditBB {
	
	private String amount;
	private String period;
	private String rate;
	private double result;

	@Inject
	FacesContext ctx;

	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	
	public void countRate() {
		if (amount == "" || period == "" || rate == "") {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter all data", null));
		} else {
			double amount = Double.parseDouble(this.amount);
			double period = Double.parseDouble(this.period);
			double rate = Double.parseDouble(this.rate);
			
			double rate_number = rate / 100; 
			double period_number = period * 12;
			System.out.print(rate_number);
			double q = 1 + (rate_number / 12);
			result = Math.round(amount * Math.pow(q, period_number) * (q - 1) / (Math.pow(q, period_number)-1));
		}
	}
}
