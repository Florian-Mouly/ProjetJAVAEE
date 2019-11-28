/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author damie
 */
public class Client {
    
    private String Code;
    private String Contact;
    
    public Client(String pf_id, String pf_contact){
        this.Code=pf_id;
        this.Contact=pf_contact;
    }

    public String getCode() {
        return Code;
    }

    public void setID(String code) {
        this.Code = code;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }
    
    
}
