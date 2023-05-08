package com.codeusingjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.codeusingjava.model.Auction;
import com.codeusingjava.model.Bid;
import com.codeusingjava.model.Invoice;
import com.codeusingjava.model.InvoiceManager;

@Service
public class AuctionInvoiceService {
	//Connect to the Invoice Manager
    private InvoiceManager invoiceManager;

    //Constructor
    public AuctionInvoiceService() {
        invoiceManager = new InvoiceManager();
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    //Listen for invoices
    @KafkaListener(topics = "invoice", groupId = "group_id")
    public void invoiceAuction(Bid bid) {
    	System.out.println("New Invoice to create for " + bid);
        //Add the invoice to the invoice manager
    	Invoice invoice = invoiceManager.addInvoice(bid);
        
        //Print the invoice to the console
        System.out.println(invoice);

    }
    

}
