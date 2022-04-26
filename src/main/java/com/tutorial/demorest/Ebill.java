package com.tutorial.demorest;

public class Ebill {

	public int billId;
	public int amount;
	public String startDate;
	public String accNo;
	public String refNo;
	public String endDate;
	public int getbillId() {
		return billId;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Ebill [ billId=" +billId+", amount=" + amount+", accNo="+ accNo+", refNo=" +refNo+", startDate=" +startDate+", endDate=" +endDate+"]";
	}
}
