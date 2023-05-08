package com.codeusingjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.codeusingjava.model.Auction;
import com.codeusingjava.model.AuctionManager;
import com.codeusingjava.model.Bid;

@Service
public class AuctionBiddingService {
	
	//Connection to the Auction Array list
	private AuctionManager auctionManager;

	//Constructor
	public AuctionBiddingService() {
		auctionManager = new AuctionManager();
	}
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	

	@KafkaListener(topics = "bid", groupId = "group_id")
	public void consume(Bid bid) {
		System.out.println("Consumed Bid: " + bid);
		Auction auction = auctionManager.registerBid(bid.getAuctionID(), bid.getAmount());
		bid.setAuction(auction);
		System.out.println("New bid" + bid);
		kafkaTemplate.send("auction", bid);
		
	}

	@KafkaListener(topics = "auction", groupId = "group_id")
	public void consumeAuction(Bid bid) {
		//Check if the auction that the bid is for has more than 2 bids
		System.out.println("Bid Accepted for auction ID" + bid.getAuctionID());
		System.out.println(auctionManager.getAuction(bid.getAuctionID()));
		System.out.println("And the bid is: " + bid);
		if (auctionManager.getNoOfBids(bid.getAuctionID()) > 2) {
			//If it does then send the auction to the invoice topic
			System.out.println("The Auction is being invoiced...");
			kafkaTemplate.send("invoice", bid);
			
		}
	}

	
	
	



}
