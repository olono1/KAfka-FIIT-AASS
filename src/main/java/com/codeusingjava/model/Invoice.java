package com.codeusingjava.model;

public class Invoice {
    // A class for managing all details of an invoice

    private static int id;
   	private double amount;
   	private String auctionName;
   	
    
    //Constructor
    public Invoice(Bid bid, int id) {
        //Set invoice attributes
        this.id = id;
        this.amount = bid.getAuctionWinningBid();
        this.auctionName = bid.getAuctionName();    	
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    //To string to output a nicely formatted invoice to the console. Add graphics and dividers
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", auctionName='" + auctionName + '\'' +
                '}';
    }



}
