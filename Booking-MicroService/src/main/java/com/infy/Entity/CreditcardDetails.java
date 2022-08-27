package com.infy.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class CreditcardDetails {
	@Id
	@Pattern(regexp="^[a-zA-Z0-9]{10}$",message="Invalid card number")
	@NotBlank(message="cardNumber should not empty")
	private String cardNumber;
	@NotBlank(message="apin should not empty")
	@Pattern(regexp="[0-9]{3,}",message="Invalid apin")
	private String apin;
	@NotBlank(message="Card Holder name should not empty")
	@Size(min=3,max=25,message="name should be minimum of 3 characteristics and maximun of 25 characteristics")
	private String cardHolderName;
	@NotBlank(message="Cvv should not empty")
	@Pattern(regexp="[0-9]{3}",message="Invalid Cvv")
	private String cvv;
	@Pattern(regexp="[a-zA-z]{3}",message="Invalid expiry month")
	@NotBlank(message="expiryMonth should not empty")
	private String expiryMonth;
	@NotBlank(message="Expiry year should not empty")
    @Pattern(regexp="^[2-9]{1}[0-9]{3}",message="Invalid year")
	private String expiryYear;
	@NotBlank(message="Total bill should not empty")
	private String totalBill;
	public CreditcardDetails() {
		
	}
	public CreditcardDetails(String cardNumber, String apin, String cardHolderName, String cvv, String expiryMonth,
			String expiryYear, String totalBill) {
		super();
		this.cardNumber = cardNumber;
		this.apin = apin;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	

}
