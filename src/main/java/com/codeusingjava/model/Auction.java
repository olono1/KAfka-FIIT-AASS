package com.codeusingjava.model;

public class Auction {
// A class for managing all details of an auction

    private int id = 0;
    private String name;
    private double winningBid;
    private int noOfBids;

    //Constructor
    public Auction(String name, double winningBid) {
        this.name = name;
        this.winningBid = winningBid;
        id++;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public double getWinningBid() {
        return winningBid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWinningBid(double winningBid) {
        this.winningBid = winningBid;
    }

    public int getNoOfBids() {
        return noOfBids;
    }

    public void increaseNoOfBids() {
        this.noOfBids++;
    }

    //toString method
    @Override
    public String toString() {
        return "Auction{" + "name=" + name + ", winningBid=" + winningBid + '}';
    }



}
