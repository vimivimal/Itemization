import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;


public class HomePage {

	JFrame frmItemizationHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmItemizationHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationHome = new JFrame();
		frmItemizationHome.setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/images/itemization_logo.png")));
		frmItemizationHome.setTitle("ITEMIZATION - Home");
		frmItemizationHome.getContentPane().setBackground(new Color(176, 224, 230));
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					newitem.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newitem.main(null);
				frmItemizationHome.dispose();
				
			}
		});
		
		JButton btnSal = new JButton("Sales Update");
		btnSal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					salesupdatenavigator.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesupdatenavigator.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnReport = new JButton("Trasaction Report");
		btnReport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					transaction.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnItemList = new JButton("Search");
		btnItemList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnItemList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnExit = new JButton("Log out");
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					LoginPage.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Product Name");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					newproductname.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newproductname.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnAddNewLocation = new JButton("Location");
		btnAddNewLocation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnAddNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Item");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					edit.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit.main(null);
				frmItemizationHome.dispose();
			}
		});
		
		JButton btnStockCount = new JButton("Stock Count");
		btnStockCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					stock_count_navi.main(null);
					frmItemizationHome.dispose();
				}
			}
		});
		btnStockCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stock_count_navi.main(null);
				frmItemizationHome.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationHome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(btnAddItem, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(btnItemList, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddNewLocation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSal, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnStockCount, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addGap(104))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddItem)
						.addComponent(btnSal))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnItemList)
						.addComponent(btnReport))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnAddNewLocation))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnStockCount)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(btnExit)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		frmItemizationHome.getContentPane().setLayout(groupLayout);
		frmItemizationHome.setBounds(100, 100, 489, 312);
		frmItemizationHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
