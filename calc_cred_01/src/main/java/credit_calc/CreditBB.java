package credit_calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.Math;


@Named
@RequestScoped

public class CreditBB {
	
	private double amount;
	private double period;
	private double rate;
	private double result;

	@Inject
	FacesContext ctx;

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getPeriod() {
		return period;
	}

	public void setPeriod(double period) {
		this.period = period;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	
	public void countRate() {
		
			double rate_number = rate / 100; 
			double period_number = period * 12;
			System.out.print(rate_number);
			double q = 1 + (rate_number / 12);
			result = Math.round(amount * Math.pow(q, period_number) * (q - 1) / (Math.pow(q, period_number)-1));
		
	}
}
