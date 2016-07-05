/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.corba.se.pept.transport.ConnectionCache;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.Spring;

/**
 *
 * @author P@r@G
 */
public class userDAO {

    public  Connection connes() throws ClassNotFoundException, SQLException {
        Class.forName(constant.DRVRNAME);
        Connection connection = DriverManager.getConnection(constant.CONN, constant.UNAME, constant.PASS);

        return connection;
    }

    public int ins(continfo inf) throws ClassNotFoundException, SQLException {
        Connection connection = connes();

        PreparedStatement p1 = connection.prepareStatement("insert into ins_Schema.adcon(name,phno,email,address)values(?,?,?,?)");
        //  p1.setString(1, inf.getName()),inf.getPhno(),inf.getEmail(),inf.getAddress());
        int u = 0;

        try {
            p1.setString(1, inf.getName());
            p1.setString(2, inf.getPhno());
            p1.setString(3, inf.getEmail());
            p1.setString(4, inf.getAddress());
            u = p1.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if (connection == null) {
            connection.close();
        }

        return u;
    }

    int dele(String ff, String str) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection connection = connes();
       // System.out.println(ff + "  " + str);
        PreparedStatement p1 = connection.prepareStatement("DELETE FROM `ins_schema`.`adcon` WHERE "+str+"=?");
       // p1.setString(1, str);
        p1.setString(1, ff);
        int i = p1.executeUpdate();
        return i;
    }

    void serch(String Updat) throws ClassNotFoundException, SQLException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Connection con=connes();
    PreparedStatement p1=con.prepareStatement("select * from `ins_schema`.adcon where phno="+Updat);
   ResultSet r1=p1.executeQuery();
   while(r1.next())
   {
   //updt.edt.setText("UPDATE INFO FOR "+r1.getString(1)+" phone no "+r1.getString());
   updt.set(r1.getString(1),r1.getString(2),r1.getString(3),r1.getString(4));
   }
    }

    int upd(String name, String phone, String email, String address) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection ache =connes();
        PreparedStatement p1=ache.prepareStatement("UPDATE `ins_schema`.`adcon` SET `name`=?,`phno`=?,`email`=?,`address`=? WHERE `phno`='"+phone+"'");//UPDATE `ins_schema`.`adcon` SET `phno`='9566882210' WHERE `phno`='76767676';

        p1.setString(1, name);
        p1.setString(2, phone);
        p1.setString(3, email);
        p1.setString(4, address);
    int r=p1.executeUpdate();
    return r;
    }

    Map<String, Vector> vie() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Connection vo=connes();
    PreparedStatement p1=vo.prepareStatement("Select * from `ins_schema`.adcon");
    ResultSet r1=p1.executeQuery();
    Vector<String>colum=new Vector<String>();
    Vector<String>ro=null;
    Vector<Vector>Final=new Vector<Vector>();
    boolean h=true;
    while(r1.next())
    {
    ro=new Vector<String>();
        ResultSetMetaData rw=r1.getMetaData();
        for(int i=1;i<=rw.getColumnCount();i++)
        {
        if(h)
        {
        colum.addElement(rw.getColumnName(i));
        }
        ro.addElement(r1.getString(i));
        }
        Final.add(ro);
        h=false;
        
    }
    Map<String, Vector> map = new HashMap<String, Vector>();
		map.put("header", colum);
		map.put("dataSet", Final);

		//DataBaseManager.closeAllConnections(connection, prepareStatement,r1);
		return map;
    }
    
}
