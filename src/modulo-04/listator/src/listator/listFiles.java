package listator;

import java.io.File;

import javax.swing.JOptionPane;

public class listFiles {

	public static void main(String[] args) {
		
		String folder = JOptionPane.showInputDialog(null, "Digite o caminho:");
		File[] archives = new File(folder).listFiles();

		for (File file : archives) {
			JOptionPane.showMessageDialog(null, file.getName());
		}
	}
}
