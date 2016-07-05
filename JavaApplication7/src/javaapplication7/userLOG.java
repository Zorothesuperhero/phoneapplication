/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author P@r@G
 */
public class userLOG
{
   

   public int logn(String nm, String pas) throws ClassNotFoundException, SQLException {
        int i=0;
    userDAO u1=new userDAO();
 Connection con=u1.connes();
       PreparedStatement p1=con.prepareStatement("select name from `ins_schema`.log where name='"+nm+"' and passwd='"+pas+"'");
        ResultSet r1=p1.executeQuery();
        while(r1.next())
        {
        i=1;
        }
       return i;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int chngpass() throws ClassNotFoundException, SQLException {
        int i=0;
    userDAO u1=new userDAO();
 Connection con=u1.connes();
       PreparedStatement p1=con.prepareStatement("update `ins_schema`.log set passwd='"+act.neu+"' where passwd='"+act.old+"'");
         i=p1.executeUpdate();
       
       return i;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public Map<String, Vector> tbl() throws ClassNotFoundException, SQLException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   userDAO u1=new userDAO();
   Connection con=u1.connes();
       System.out.println(act.uname);
 PreparedStatement p1=con.prepareStatement("select `from`,message from `ins_schema`.inbox where sndto='"+act.uname+"'"); 
 ResultSet r1=p1.executeQuery();
// Map<String,Vector>map=null;
Vector<String> columnData = new Vector<String>();
		Vector<String> currentRow = null;
		Vector<Vector> finalDataSet = new Vector<Vector>();
		boolean headerSet = true;
		while (r1.next()) {
			currentRow = new Vector<String>();
			ResultSetMetaData rsmd = r1.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (headerSet) {
					columnData.addElement(rsmd.getColumnName(i));
                                        System.out.println(""+rsmd.getColumnName(i));
				}
				currentRow.addElement(r1.getString(i));
			// System.out.println("yp yo"+r1.getString(i));
                        }
			finalDataSet.add(currentRow);
			headerSet = false;
//		System.out.println("yp yo"+r1.getString(1));
                
                }
		Map<String, Vector> map = new HashMap<String, Vector>();
		map.put("header", columnData);
		map.put("dataSet", finalDataSet);

		//DataBaseManager.closeAllConnections(connection, prepareStatement,r1);
		return map;

   }

    int sndmsg(String to, String message) throws ClassNotFoundException, SQLException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         int i=0;
         int y=0;
    userDAO u1=new userDAO();
 Connection con=u1.connes();
       PreparedStatement p1=con.prepareStatement("insert into ins_schema.inbox(`from`,`message`,`sndto`)values(?,?,?)");
          p1.setString(1, act.uname);
 p1.setString(2, message);
  p1.setString(3,to);
          //ResultSet r1=p1.executeQuery();
   y=p1.executeUpdate();
   return y;
    }

    public Map<String, Vector> tbl2() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     userDAO u1=new userDAO();
   Connection con=u1.connes();
       System.out.println(act.uname);
 PreparedStatement p1=con.prepareStatement("select `sndto`,message from `ins_schema`.inbox where `from`='"+act.uname+"'"); 
 ResultSet r1=p1.executeQuery();
// Map<String,Vector>map=null;
Vector<String> columnData = new Vector<String>();
		Vector<String> currentRow = null;
		Vector<Vector> finalDataSet = new Vector<Vector>();
		boolean headerSet = true;
		while (r1.next()) {
			currentRow = new Vector<String>();
			ResultSetMetaData rsmd = r1.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (headerSet) {
					columnData.addElement(rsmd.getColumnName(i));
                                       // System.out.println(""+rsmd.getColumnName(i));
				}
				currentRow.addElement(r1.getString(i));
			// System.out.println("yp yo"+r1.getString(i));
                        }
			finalDataSet.add(currentRow);
			headerSet = false;
//		System.out.println("yp yo"+r1.getString(1));
                
                }
		Map<String, Vector> map = new HashMap<String, Vector>();
		map.put("header", columnData);
		map.put("dataSet", finalDataSet);

		//DataBaseManager.closeAllConnections(connection, prepareStatement,r1);
		return map;

    
    
    }

    int addacc(String nam, String phone, String pass) throws ClassNotFoundException, SQLException {
        int i=0;
       /// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     if(phone.equals(""))
       {
       return  0;
       }
       if(nam.equals(""))
       {
       return 0;
       }
       if(pass.equals(""))
           return 0;
        
        userDAO u1=new userDAO();
 Connection con=u1.connes();
       PreparedStatement p1=con.prepareStatement("insert into ins_schema.`log`(name,passwd,phone)values(?,?,?)");
      p1.setString(1, nam);
      p1.setString(2, pass);
 p1.setString(3, phone);      
       i=p1.executeUpdate();
       
       return i;
    }
    
}
