package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileBrowser extends JFileChooser {

	public FileBrowser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileBrowser(File currentDirectory, FileSystemView fsv) {
		super(currentDirectory, fsv);
		// TODO Auto-generated constructor stub
	}

	public FileBrowser(File currentDirectory) {
		super(currentDirectory);
		// TODO Auto-generated constructor stub
	}

	public FileBrowser(FileSystemView fsv) {
		super(fsv);
		// TODO Auto-generated constructor stub
	}

	public FileBrowser(String currentDirectoryPath, FileSystemView fsv) {
		super(currentDirectoryPath, fsv);
		// TODO Auto-generated constructor stub
	}

	public FileBrowser(String currentDirectoryPath) {
		super(currentDirectoryPath);
	
	}
	

}
