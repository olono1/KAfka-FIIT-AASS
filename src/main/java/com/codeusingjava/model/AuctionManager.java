package com.codeusingjava.model;

import java.util.ArrayList;

public class AuctionManager {
    //A class for managing auction objects in an arraylist

    private ArrayList<Auction> auctions = new ArrayList<>();
    private int auctionIdNew;

    //Constructor
    public AuctionManager() {
    	auctionIdNew = 0;
        //Create some auctions
        Auction auction1 = new Auction("Auction 1", 0.00);
        Auction auction2 = new Auction("Auction 2", 0.00);
        addAuction(auction1);
        addAuction(auction2);
        System.out.println("New Auctions have been created: " + auction1);
    }

    //Add an auction to the arraylist
    public void addAuction(Auction auction) {
    	auction.setId(auctionIdNew++);
        auctions.add(auction);
    }

    //Get an auction from the arraylist
    public Auction getAuction(int id) {
        for (Auction auction : auctions) {
            if (auction.getId() == id) {
                return auction;
            }
        }
        return null;
    }

    //Get all auctions from the arraylist
    public ArrayList<Auction> getAllAuctions() {
        return auctions;
    }

    //Increase the number of bids for an auction
    public void increaseNoOfBids(int id) {
        for (Auction auction : auctions) {
            if (auction.getId() == id) {
                auction.increaseNoOfBids();
            }
        }
    }

    //Get the number of bids for an auction
    public int getNoOfBids(int id) {
        for (Auction auction : auctions) {
            if (auction.getId() == id) {
                return auction.getNoOfBids();
            }
        }
        return 0;
    }

    //Register a bid for an auction but only if it is higher than the current winning bid and
    //return the updated auction. 
    public Auction registerBid(int id, double bid) {
    	System.out.println("Searching for a-id:" + id + "and value is: " + bid);
        for (Auction auction : auctions) {
            if (auction.getId() == id) {
                if (bid > auction.getWinningBid()) {
                    auction.setWinningBid(bid);
                    auction.increaseNoOfBids();
                    System.out.println("Registered bid for auction" + auction);
                    return auction;
                }
            }
        }
        return null;
    }

    //Chceck all auctions to see if any have two or more bids and return them in an arraylist
    public ArrayList<Auction> getAuctionsToInvoice() {
        ArrayList<Auction> auctionsToInvoice = new ArrayList<>();
        for (Auction auction : auctions) {
            if (auction.getNoOfBids() >= 2) {
                auctionsToInvoice.add(auction);
            }
        }
        return auctionsToInvoice;
    }

    //Delete the auctions that have been invoiced
    public void deleteAuctionsToInvoice(ArrayList<Auction> auctionsToInvoice) {
        for (Auction auction : auctionsToInvoice) {
            auctions.remove(auction);
        }
    }

}
