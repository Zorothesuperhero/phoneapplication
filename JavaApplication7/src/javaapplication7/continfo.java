/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.jar.Attributes;

/**
 *
 * @author P@r@G
 */
class continfo {
    public String name,email,phno,address;

    continfo(String dd, String dd1, String e, String a) {
        name=dd;
        phno=dd1;
        email=e;
        address=a;
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhno() {
        return phno;
    }

    public String getAddress() {
        return address;
    }
    
   
        
    
}
