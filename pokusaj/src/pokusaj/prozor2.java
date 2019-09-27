package pokusaj;
//Handela sve u vezi spinnera
import javax.swing.*; 
//Handela evente
import java.awt.event.*;
import java.io.BufferedWriter;
//Za saveanje
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//Sadrzi  dimenzije
import java.awt.Dimension;
//Za spremati velicine
//Sadrzi datoteku datuma
import java.util.Date;
//Kalendar sadrzi dosta toga vezano uz datume
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * Aplikacija za rezervacije stolova
 * @author pesti
 *
 */

public class prozor2 extends JFrame {

	//Definiramo nazive
	JButton button17, button18, button19, button27, button28, clearAll, saveAll;
	JPanel thePanel;
	JLabel bckgrnd, lblBrOsoba, lblStolica, lblStol, lblIme, lblDatum, lblTerasa;
	JSpinner spinner1, spinner2;
	JTextField textField1,ime;
	JTextArea textArea1, textArea2, textArea3, textArea4, textArea5;
	JScrollPane scroll1, scroll2, scroll3, scroll4, scroll5;
	JCheckBox djecijaStolica;
	
	/**
	 * Glavna metoda
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		new prozor2();

	}
	/**
	 * Glavni prozor
	 * Definira se kako će izgledati i njegove komponene
	 */
	
	public prozor2(){
		
		//Sve vzano uz postavljanje prozora
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Rezervacija");
		
		//Glavni panel
		thePanel = new JPanel();
		
		
		lblStol = new JLabel("Izbor stola:");
		thePanel.add(lblStol);
		
		//Kreiramo botunee
		button17 = new JButton("Stol broj 17");
		ListenForButton lForButton = new ListenForButton();
		button17.addActionListener(lForButton);
		
		button18 = new JButton("Stol broj 18");
		button18.addActionListener(lForButton);
		
		button19 = new JButton("Stol broj 19");
		button19.addActionListener(lForButton);
		
		button27 = new JButton("Stol broj 27");
		button27.addActionListener(lForButton);
		
		button28 = new JButton("Stol broj 28");
		button28.addActionListener(lForButton);
		
		//Addamo botune
		thePanel.add(button17);
		thePanel.add(button18);
		thePanel.add(button19);
		thePanel.add(button27);
		thePanel.add(button28);
		
		lblBrOsoba = new JLabel("                                                              Broj osoba:");
		thePanel.add(lblBrOsoba);      
		
		//Kreiramo  TextField
		textField1 = new JTextField("", 2);
		textField1.setToolTipText("Broj osoba:");
		thePanel.add(textField1);
		
		lblDatum = new JLabel("Datum/Vrijeme:");
		thePanel.add(lblDatum);
		
		//Date model radimo i grabimo danasnji dan
		Date todaysDate = new Date();
		spinner2 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
		//Editor za dateove 
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner2, "dd/MM/yy HH:mm a");
		spinner2.setEditor(dateEditor);
		thePanel.add(spinner2);

		lblStolica = new JLabel("Stolica za djecu:");
		thePanel.add(lblStolica);
		
		//Kreiramo checkBox
		djecijaStolica  = new JCheckBox();
		thePanel.add(djecijaStolica);
		
		lblIme = new JLabel("Vaše ime:");
		thePanel.add(lblIme);
		
		ime = new JTextField("", 10);
		ime.setToolTipText("Upisite vase ime");
		thePanel.add(ime);
		
		
		
		//Kreiramo TextArea Stol 17
		lblTerasa = new JLabel("                       Stolovi:");
		thePanel.add(lblTerasa);
		textArea1 =  new  JTextArea(10, 10);
		textArea1.setText("(Stol 17) \n");
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		//Stol 18
		textArea2 =  new  JTextArea(10, 10);
		textArea2.setText("(Stol 18) \n");
		textArea2.setLineWrap(true);
		textArea2.setWrapStyleWord(true);
		//Stol 19
		textArea3 =  new  JTextArea(10, 10);
		textArea3.setText("(Stol 19) \n");
		textArea3.setLineWrap(true);
		textArea3.setWrapStyleWord(true);
		//Stol 27
		textArea4 =  new  JTextArea(10, 10);
		textArea4.setText("(Stol 27) \n");
		textArea4.setLineWrap(true);
		textArea4.setWrapStyleWord(true);
		//Stol 28
		textArea5 =  new  JTextArea(10, 10);
		textArea5.setText("(Stol 28) \n");
		textArea5.setLineWrap(true);
		textArea5.setWrapStyleWord(true);
	
		//Radimo scroller
		JScrollPane scroll1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll3 = new JScrollPane(textArea3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll4 = new JScrollPane(textArea4, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll5 = new JScrollPane(textArea5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//Addamo scroller
		thePanel.add(scroll1);	
		thePanel.add(scroll2);
		thePanel.add(scroll3);
		thePanel.add(scroll4);
		thePanel.add(scroll5);

		//Clear all botun
		clearAll =  new JButton("Clear all");
		clearAll.addActionListener(lForButton);
		thePanel.add(clearAll);
		
		//Botun za saveat file
		saveAll = new JButton("Save");
		saveAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
				
				File fw = new File("Info o stolovima");
				if(!fw.exists()) {
					fw.createNewFile();
				}
			//Pomoću FileWritera sređujemo da ispisuje
			FileWriter fw2 = new FileWriter(fw.getAbsoluteFile(), true);
			textArea1.write(fw2);
			textArea2.write(fw2);
			textArea3.write(fw2);
			textArea4.write(fw2);
			textArea5.write(fw2);
			
			//Dajemo do znanja useru porukom da je ispisano
			JOptionPane.showMessageDialog(null, "Zapisano!");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			
			
			
		});
		//Dodajemo save botun u panel
		thePanel.add(saveAll);
		
		
		
		
		//Addamo glavni panel i radimo ga visible
		this.add(thePanel);
		this.setVisible(true);
		
		
	}
	/**
	 * Listener za botune
	 * @author pesti
	 *
	 */
	
	private class ListenForButton implements ActionListener {

		//Kada je pretisnut odredeni botun podaci ce se dodati na tocan stol
		public void actionPerformed(ActionEvent e) {
			String str = textArea1.getText();
			if (e.getSource() == button17 && textArea1.getText().equals("(Stol 17) \n")) {
				
				textArea1.append("Rezervirano za "  + textField1.getText() + " osoba " + "/Djecija stolica " + djecijaStolica.isSelected() + 
					" /Datuma " + spinner2.getValue() + " /Na ime " + ime.getText() +  "\n");
				
			} else {
				
				if (e.getSource() == button18) {
					
					textArea2.append("Rezervirano za "  + textField1.getText() + " osoba " + "/Djecija stolica " + djecijaStolica.isSelected() + 
							" /Datuma " + spinner2.getValue() + " /Na ime " + ime.getText() +  "\n");
				
			} else {
				
				if (e.getSource() == button19) {
					
					textArea3.append("Rezervirano za "  + textField1.getText() + " osoba " + "/Djecija stolica " + djecijaStolica.isSelected() + 
							" /Datuma " + spinner2.getValue() + " /Na ime " + ime.getText() +  "\n");
				
			} else {
				
				if (e.getSource() == button27) {
					
					textArea4.append("Rezervirano za "  + textField1.getText() + " osoba " + "/Djecija stolica " + djecijaStolica.isSelected() + 
							" /Datuma " + spinner2.getValue() + " /Na ime " + ime.getText() +  "\n");
			
			} else {
			
				if (e.getSource() == button28) {
				
					textArea5.append("Rezervirano za "  + textField1.getText() + " osoba " + "/Djecija stolica " + djecijaStolica.isSelected() + 
							" /Datuma " + spinner2.getValue() + " /Na ime " + ime.getText() +  "\n");
		
		
			} else {
		
				if (e.getSource() == clearAll) {
					//Brisemo sve zapisano u textArea
					int input = JOptionPane.showConfirmDialog(null, "Izbriši sve");
			        
					textArea1.setText(null);
					textArea2.setText(null);
					textArea3.setText(null);
					textArea4.setText(null);
					textArea5.setText(null);
		
	}
}
}
}
}
}
}
}
}
