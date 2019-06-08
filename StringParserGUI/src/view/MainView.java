package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FileController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainView extends JFrame {

	private JPanel contentPane;
	private File f;
	private FileController controller;
	private File textFile;
	public JTextArea textArea;
	public MainView() {
		init();
		
	}

	public static void main(String[] args) {
		 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	  	        if ("Nimbus".equals(info.getName())) {
	  	            try {
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  	            break;
	  	        }
	  	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1200, 800);
		this.setTitle("String Pharser");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		controller = new FileController(MainView.this);
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JButton btnOpenFile = new JButton("Open file");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFile = controller.browseFiles();
				if(f != null)
					textArea.setText("File opened: " + textFile.getName());
			}
		});
		
		JButton btnSaveFile = new JButton("Save file");
		
		JButton btnRemoveDuplicates = new JButton("Remove duplicates");
		btnRemoveDuplicates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file;
				if(textFile != null) {
				file = controller.removeDuplicates(textFile);
				textArea.setText("File saved: " + file.getName());
				System.out.println(controller.repeated);
				}
				
			}
		});
		
		JButton btnCombineFiles = new JButton("Combine files");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCombineFiles, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnRemoveDuplicates, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnSaveFile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnOpenFile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
					.addGap(66)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
					.addGap(284))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
					.addGap(77))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(btnOpenFile, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(btnRemoveDuplicates, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(46)
					.addComponent(btnCombineFiles, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(178)
					.addComponent(btnSaveFile, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(230))
		);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
	
	
}
