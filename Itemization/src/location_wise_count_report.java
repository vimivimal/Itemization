import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.glass.events.KeyEvent;

import net.proteanit.sql.DbUtils;

/**
 *
 * @author NirmalGds
 */
public class location_wise_count_report extends javax.swing.JFrame {

    /**
     * Creates new form location_wise_count_report
     */
	
	public static JFrame frame = new JFrame();
	public static void checks()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select location,COUNT(*),SUM(gross_weight) FROM stocklist WHERE flag = 1 AND location = ? GROUP BY location");
			pst.setString(1, loc);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				check =0;
			}else
			{
				check=1;
			}
			
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public static void datafill()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select location,COUNT(*),SUM(gross_weight) FROM stocklist WHERE flag = 1 AND location = ? GROUP BY location");
			PreparedStatement pst1 = (PreparedStatement) conn.prepareStatement("SELECT SUM(absent) FROM (SELECT location.name,count(stock.location),location.count,location.count - count(stock.location) as absent  FROM location LEFT OUTER JOIN (SELECT * FROM stocklist WHERE flag = 1) AS stock ON location.name = stock.location WHERE location.name = ? GROUP BY location.name) AS processed");
			PreparedStatement pst2 = (PreparedStatement) conn.prepareStatement("Select id as ID from stocklist where flag = 1 and location = ?");
			pst.setString(1, loc);
			pst1.setString(1, loc);
			pst2.setString(1, loc);
			ResultSet rs = pst.executeQuery();
			ResultSet rs1 = pst1.executeQuery();
			ResultSet rs2 = pst2.executeQuery();
			if(rs.next())
			{
				jTextField1.setText(rs.getString(1));
				jTextField2.setText(String.valueOf(rs.getInt(2))+" Nos.");
				jTextField3.setText(String.valueOf(rs.getDouble(3))+" Grams");
			}else
			{	
			JOptionPane.showMessageDialog(null, "No Item Present in "+loc);
			location_wise_count.main(null);
			}
			if( loc.equals("TRAY 01") || loc.equals("TRAY 02") || loc.equals("TRAY 03") || loc.equals("TRAY 06") || loc.equals("TRAY 07") || loc.equals("TRAY 08") || loc.equals("TRAY 09") || loc.equals("TRAY 10") || loc.equals("TRAY 11") || loc.equals("TRAY 12") || loc.equals("TRAY 13") || loc.equals("TRAY 14") || loc.equals("TRAY 15") || loc.equals("TRAY 16") || loc.equals("TRAY 17") || loc.equals("TRAY 20") || loc.equals("TRAY 23") || loc.equals("TRAY 24") || loc.equals("TRAY 25") || loc.equals("TRAY 25") || loc.equals("TRAY 26") || loc.equals("TRAY 27") || loc.equals("TRAY 28") || loc.equals("TRAY 29") || loc.equals("TRAY 30") || loc.equals("TRAY 31") || loc.equals("TRAY 32") || loc.equals("TRAY 33") || loc.equals("TRAY 34") || loc.equals("TRAY 35") || loc.equals("TRAY 34") || loc.equals("TRAY 35") || loc.equals("TRAY 36") || loc.equals("TRAY 37") || loc.equals("TRAY 38"))
			{	
			if(rs1.next())
			{
				jTextField4.setText(String.valueOf(rs1.getInt(1))+" Nos.");
			}
			else
			{
				frame.dispose();
			}
			}
			else {
				jTextField4.setEnabled(false);
				jTextField4.hide();
				jLabel4.hide();		
			}
			if(rs2 != null)
			{
				jTable1.setModel(DbUtils.resultSetToTableModel(rs2));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
    public location_wise_count_report() {
    	getContentPane().setBackground(new Color(176, 224, 230));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(location_wise_count_report.class.getResource("/images/itemization_logo.png")));
    	setTitle("ITEMIZATION - Location Wise Count Report");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setEnabled(false);
        jTable1 = new javax.swing.JTable();
        jTable1.setEnabled(false);
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Location Name");

        jTextField1.setEditable(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Max. Count");

        jTextField2.setEditable(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jLabel3.setText("Total Weight");

        jTextField3.setEditable(false);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jLabel4.setText("Absent Count");

        jTextField4.setEditable(false);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(45)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel3)
        						.addComponent(jLabel4)
        						.addComponent(jLabel2))
        					.addGap(41)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jTextField2)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jTextField1)
        							.addComponent(jTextField3)
        							.addComponent(jTextField4, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(131)
        					.addComponent(jButton1)))
        			.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        			.addGap(22))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(51)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(59)
        					.addComponent(jButton1))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>  
    private static void exit()
    {
    	
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
        location_wise_count.main(null);
    }                                        

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {                                       
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	this.dispose();
            location_wise_count.main(null);
        }else if(evt.getKeyCode() == KeyEvent.VK_BACKSPACE)
        {
        	this.dispose();
            location_wise_count.main(null);
        }    
    }                                      

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {                                       
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	this.dispose();
            location_wise_count.main(null);
        }else if(evt.getKeyCode() == KeyEvent.VK_BACKSPACE)
        {
        	this.dispose();
            location_wise_count.main(null);
        } 
    }                                      

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {                                       
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	this.dispose();
            location_wise_count.main(null);
        }else if(evt.getKeyCode() == KeyEvent.VK_BACKSPACE)
        {
        	this.dispose();
            location_wise_count.main(null);
        } 
    }                                      

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {                                       
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	this.dispose();
            location_wise_count.main(null);
        }else if(evt.getKeyCode() == KeyEvent.VK_BACKSPACE)
        {
        	this.dispose();
            location_wise_count.main(null);
        } 
    }                                      

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {                                    
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	this.dispose();
            location_wise_count.main(null);
        } 
    }                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String temp) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(location_wise_count_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(location_wise_count_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(location_wise_count_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(location_wise_count_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	loc = temp;
            	checks();
            	if(check == 0)
				{
            		new location_wise_count_report().setVisible(true);
            		datafill();
				}
				else
				{	
					check = 0;
					new location_wise_count_report().setVisible(false);
					datafill();
					
				}
            	
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private static javax.swing.JTextField jTextField3;
    private static javax.swing.JTextField jTextField4;
    public static String loc;
    public static int check =0;
    // End of variables declaration                   
}
