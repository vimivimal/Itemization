

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class editlocationfinal {

	private JFrame frmItemizationEdit;
	static String search;
	private static JTextField textField;
	static JComboBox comboBox;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editlocationfinal window = new editlocationfinal();
					search = name;
					textField.setText(search);
					window.frmItemizationEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editlocationfinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationEdit = new JFrame();
		frmItemizationEdit.setTitle("ITEMIZATION - Edit Location");
		frmItemizationEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(editlocationfinal.class.getResource("/images/itemization_logo.png")));
		frmItemizationEdit.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationEdit.setBounds(100, 100, 450, 300);
		frmItemizationEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLocationName = new JLabel("Location Name");
		
		JLabel lblType = new JLabel("Type");
		
		textField = new JTextField();
		textField.setEditable(false);
		
		textField.setColumns(10);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"GOLD", "SILVER"}));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				if(e1.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root","");
						PreparedStatement stmt = con.prepareStatement("UPDATE `location` SET `type`=?,`count`=? WHERE `name` = ?");
						stmt.setString(1, comboBox.getSelectedItem().toString());
						stmt.setInt(2, Integer.valueOf(textField_1.getText()));
						stmt.setString(3, search);
						if(stmt.execute())
						{
							JOptionPane.showMessageDialog(null, "Something Went Wrong. Please Contact Admin");
						}else
						{
							JOptionPane.showMessageDialog(null, textField.getText()+" is Updated Succesfully");
							location.main(null);
							frmItemizationEdit.dispose();
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}else if(e1.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					editlocation.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root","");
					PreparedStatement stmt = con.prepareStatement("UPDATE `location` SET `type`=?,`count`=? WHERE `name` = ?");
					stmt.setString(1, comboBox.getSelectedItem().toString());
					stmt.setInt(2, Integer.valueOf(textField_1.getText()));
					stmt.setString(3, search);
					if(stmt.execute())
					{
						JOptionPane.showMessageDialog(null, "Something Went Wrong. Please Contact Admin");
					}else
					{
						JOptionPane.showMessageDialog(null, textField.getText()+" is Updated Succesfully");
						location.main(null);
						frmItemizationEdit.dispose();
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					editlocation.main(null);
					frmItemizationEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					editlocation.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editlocation.main(null);
				frmItemizationEdit.dispose();
			}
		});
		
		JLabel lblMaxCount = new JLabel("Max. Count");
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char vchar = evt.getKeyChar();
				if(!Character.isDigit(vchar))
				{
					evt.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root","");
						PreparedStatement stmt = con.prepareStatement("UPDATE `location` SET `type`=?,`count`=? WHERE `name` = ?");
						stmt.setString(1, comboBox.getSelectedItem().toString());
						stmt.setInt(2, Integer.valueOf(textField_1.getText()));
						stmt.setString(3, search);
						if(stmt.execute())
						{
							JOptionPane.showMessageDialog(null, "Something Went Wrong. Please Contact Admin");
						}else
						{
							JOptionPane.showMessageDialog(null, textField.getText()+" is Updated Succesfully");
							location.main(null);
							frmItemizationEdit.dispose();
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmItemizationEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLocationName)
								.addComponent(lblMaxCount)
								.addComponent(lblType))
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnSubmit)
							.addGap(78)
							.addComponent(btnCancel)))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocationName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMaxCount)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSubmit))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		frmItemizationEdit.getContentPane().setLayout(groupLayout);
	}
}
