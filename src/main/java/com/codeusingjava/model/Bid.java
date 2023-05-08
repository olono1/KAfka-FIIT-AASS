package com.codeusingjava.model;

public class Bid {

	private String name;
	private double amount;
	private int auctionID;
	private String auctionName;
	private double auctionWinningBid;

	public Bid() {		
	}
	
	public Bid(String name, double amount, int auctionID) {
		this.name = name;
		this.amount = amount;
		this.auctionID = auctionID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return "Bid [name=" + name + ", amount=" + amount + ", auctionID=" + auctionID + ", auctionName=" + auctionName
				+ ", auctionWinningBid=" + auctionWinningBid + "]";
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAuctionID() {
		return auctionID;
	}

	public void setAuctionID(int auctionID) {
		this.auctionID = auctionID;
	}

	public void setAuction(Auction auction) {
		this.auctionName = auction.getName();
		this.auctionWinningBid = auction.getWinningBid();
		
	}

	public String getAuctionName() {
		return auctionName;
	}

	public double getAuctionWinningBid() {
		return auctionWinningBid;
	}


	
	
	
	
	
	

}
