import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interest_Calculator {

	private JFrame frmInterestCalculator;
	private JTextField p;
	private JTextField r;
	private JTextField t;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField cutomfield;
	double n=0;
	boolean flag=false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interest_Calculator window = new Interest_Calculator();
					window.frmInterestCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interest_Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterestCalculator = new JFrame();
		frmInterestCalculator.setTitle("Interest Calculator");
		frmInterestCalculator.setBounds(100, 100, 316, 283);
		frmInterestCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image img = Toolkit.getDefaultToolkit().getImage("icon.png");
		frmInterestCalculator.setIconImage(img);
		
		JLabel lblNewLabel = new JLabel("Principal :");
		lblNewLabel.setBounds(10, 11, 97, 23);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblRateOfInterest = new JLabel("Rate Of Interest :");
		lblRateOfInterest.setBounds(10, 69, 128, 23);
		lblRateOfInterest.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel tlabel = new JLabel("Time Period :");
		tlabel.setBounds(10, 121, 97, 23);
		tlabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		p = new JTextField();
		p.setBounds(10, 33, 145, 25);
		p.setColumns(10);
		
		r = new JTextField();
		r.setBounds(10, 90, 145, 25);
		r.setColumns(10);
		
		t = new JTextField();
		t.setBounds(10, 145, 145, 25);
		t.setColumns(10);
		
		JCheckBox ann = new JCheckBox("Anually");
		ann.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cutomfield.setEnabled(false);
				flag=false;
				n=1;
			}
		});
		buttonGroup.add(ann);
		ann.setBounds(182, 34, 97, 23);
		
		JCheckBox hy = new JCheckBox("Half Yearly");
		hy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cutomfield.setEnabled(false);
				flag=false;
				n=2;
			}
		});
		buttonGroup.add(hy);
		hy.setBounds(182, 52, 97, 23);
		
		JCheckBox quarter = new JCheckBox("Quarterly");
		quarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cutomfield.setEnabled(false);
				flag=false;
				n=4;
			}
		});
		buttonGroup.add(quarter);
		quarter.setBounds(182, 71, 83, 23);
		
		JLabel lblCompounding = new JLabel("Compounding :");
		lblCompounding.setBounds(182, 11, 109, 23);
		lblCompounding.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JCheckBox chckbxMonthly = new JCheckBox("Monthly");
		chckbxMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cutomfield.setEnabled(false);
				flag=false;
				n=12;
			}
		});
		buttonGroup.add(chckbxMonthly);
		chckbxMonthly.setBounds(182, 91, 83, 23);
		frmInterestCalculator.getContentPane().setLayout(null);
		frmInterestCalculator.getContentPane().add(lblNewLabel);
		frmInterestCalculator.getContentPane().add(tlabel);
		frmInterestCalculator.getContentPane().add(t);
		frmInterestCalculator.getContentPane().add(p);
		frmInterestCalculator.getContentPane().add(lblRateOfInterest);
		frmInterestCalculator.getContentPane().add(r);
		frmInterestCalculator.getContentPane().add(ann);
		frmInterestCalculator.getContentPane().add(hy);
		frmInterestCalculator.getContentPane().add(quarter);
		frmInterestCalculator.getContentPane().add(lblCompounding);
		frmInterestCalculator.getContentPane().add(chckbxMonthly);
		
		JCheckBox chckbxCustom = new JCheckBox("Custom");
		chckbxCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cutomfield.setEnabled(true);
				flag=true;
			}
		});
		buttonGroup.add(chckbxCustom);
		chckbxCustom.setBounds(182, 110, 83, 23);
		frmInterestCalculator.getContentPane().add(chckbxCustom);
		
		cutomfield = new JTextField();
		cutomfield.setBounds(186, 134, 100, 20);
		frmInterestCalculator.getContentPane().add(cutomfield);
		cutomfield.setColumns(10);
		cutomfield.setEnabled(false);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String prin=p.getText().trim();
				String time=t.getText().trim();
				String rate=r.getText().trim();
				
				double pr=Double.parseDouble(prin);
				double tm=Double.parseDouble(time);
				double rt=Double.parseDouble(rate);
				rt/=100.0;
				
				String s=cutomfield.getText();
				if(s.length()>0&&flag)
					n=Double.parseDouble(s);
				
				
				double amount=pr*(Math.pow((1+(rt/n)), n*tm));
				
				String message= "Final Amount after "+time+" years is "+amount+"0";
				message=message.substring(0, message.indexOf('.')+3);
				
				JOptionPane.showMessageDialog(frmInterestCalculator,
					    message,
					    "Amount Calculated",
					    JOptionPane.PLAIN_MESSAGE);
				
				
			}
		});
		btnNewButton.setBounds(10, 192, 282, 40);
		frmInterestCalculator.getContentPane().add(btnNewButton);
	}
}
