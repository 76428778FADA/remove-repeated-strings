package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import exceptions.NotTextFileException;
import view.FileChooser;
import view.MainView;

public class FileController {

	private JFrame parent;
	public static int repeated = 0;
	public static final int PERIOD = 1000000;

	public FileController(JFrame parent) {
		this.parent = parent;
	}

	public File removeDuplicates(File file) {
		System.out.println("file opened");
		Scanner sc;
		Set<String> set = new HashSet<String>();
		JFileChooser chooser = new JFileChooser();
		File createdFile = null;
		int returnVal = chooser.showSaveDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedWriter bufferedWriter = null;
			createdFile = chooser.getSelectedFile();
			try {			
				
				if (!createdFile.exists()) {
					createdFile.createNewFile();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			sc = new Scanner(file);
				while (sc.hasNextLine()) {
					set.add(sc.nextLine());
					repeated++;
				}
				System.out.println(set.size());
				createdFile = this.writeToFile(set,createdFile);
				set.clear();
				sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createdFile;

	}

	private File writeToFile(Set<String> set, File f) {
			BufferedWriter bufferedWriter = null;
			try {			
				Writer writer = new FileWriter(f, true);
				bufferedWriter = new BufferedWriter(writer);
				for (String str : set) {
					bufferedWriter.write(str);
					bufferedWriter.newLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (bufferedWriter != null)
					try {
						bufferedWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

		
		return f;
	}

	public File browseFiles() {
		File f;
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			return f;
		}
		return null;
	}

}
