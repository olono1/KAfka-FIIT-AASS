package com.codeusingjava.model;

import java.util.ArrayList;

public class InvoiceManager {
    //A class for managing invoice objects in an arraylist

    private static ArrayList<Invoice> invoices = new ArrayList<>();
    //Invoices ID
    private static int id = 0;

    //Add an invoice to the arraylist
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    //Add a new Invoice from the Bid object
    public Invoice addInvoice(Bid bid) {
        Invoice invoice = new Invoice(bid, id++);
        invoices.add(invoice);
        return invoice;
    }

    //Get an invoice from the arraylist
    public Invoice getInvoice(int id) {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    //Get all invoices from the arraylist
    public ArrayList<Invoice> getAllInvoices() {
        return invoices;
    }

    //Get the total number of invoices
    public int getTotalInvoices() {
        return invoices.size();
    }


    
}
