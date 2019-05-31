import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextArea namesListed;
	private JTextField enterName;
	JButton enterButton;
	private JButton sortButton, clearButton;
	private JScrollPane namesPane;
	private ArrayList<String> namesList = new ArrayList<String>();
	private int lengthOfCurrLine = 0;

	public NamePanel() {

		namesListed = new JTextArea();
		enterName = new JTextField();
		enterButton = new JButton();
		clearButton = new JButton();
		sortButton = new JButton();
		namesPane = new JScrollPane(namesListed);
		Dimension d = new Dimension();

		enterButton.setBackground(Color.WHITE);
		sortButton.setBackground(Color.WHITE);
		clearButton.setBackground(Color.WHITE);

		namesListed.setEditable(false);

		enterButton.setBorder(BorderFactory.createEtchedBorder());
		sortButton.setBorder(BorderFactory.createEtchedBorder());
		clearButton.setBorder(BorderFactory.createEtchedBorder());
		//namesListed.setBorder(BorderFactory.createEtchedBorder());
		namesPane.setBorder(BorderFactory.createEtchedBorder());
		enterName.setBorder(BorderFactory.createEtchedBorder());

		// --- \\

		enterButton.addActionListener(this);
		sortButton.addActionListener(this);
		clearButton.addActionListener(this);

		clearButton.setMnemonic(KeyEvent.VK_C);
		enterButton.setMnemonic(KeyEvent.VK_E);
		sortButton.setMnemonic(KeyEvent.VK_T);

		// --- \\

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// -----------------------------------------------

		// NAMES PANE \\
		
		gc.weightx = 1;
		gc.weighty = 0;

		gc.gridy = 0;
		gc.gridx = 0;
		gc.insets = new Insets(10, 5, 10, 5);

		d = new Dimension(500, 260);
		namesPane.setPreferredSize(d);
		add(namesPane, gc);

		// -----------------------------------------------

		// ENTER NAME \\
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(10, 5, 10, 5);

		d = new Dimension(250, 20);
		enterName.setPreferredSize(d);
		add(enterName, gc);

		// -----------------------------------------------

		// SORT BUTTON \\
		
		gc.gridy = 2;
		gc.gridx = 0;

		d = new Dimension(200, 40);
		sortButton.setText("Sort");
		sortButton.setPreferredSize(d);
		add(sortButton, gc);

		// -----------------------------------------------
		
		// CLEAR BUTTON \\
		
		gc.gridy = 3;
		gc.gridx = 0;

		d = new Dimension(200, 40);
		clearButton.setText("Clear");
		clearButton.setPreferredSize(d);
		add(clearButton, gc);

		// -----------------------------------------------
		
		// ENTER BUTTON \\

		gc.gridy = 4;
		gc.gridx = 0;

		d = new Dimension(200, 40);
		enterButton.setText("Enter");
		enterButton.setPreferredSize(d);
		add(enterButton, gc);
		
		// -----------------------------------------------

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == enterButton) {
			// namesListed.setBackground(Color.RED);
			String text = enterName.getText();

			addText(text);

			enterName.requestFocus();
		}

		// --------------------------------------------------------

		if (e.getSource() == sortButton) {
			// namesListed.setBackground(Color.BLUE);
			lengthOfCurrLine = 0;

			namesList.sort(String::compareToIgnoreCase);

			namesListed.setText("");

			System.out.println(namesList.toString());

			for (int i = 0; i < namesList.size(); i++) {
				addText(namesList.get(i));
			}

			enterName.requestFocus();
		}
		
		if (e.getSource() == clearButton) {
			namesListed.setText("");
		}

	}

	private void addText(String textToAdd) {

		if (textToAdd.length() > 3) {

			if (!(namesList.contains(textToAdd))) {
				namesList.add(textToAdd);
			}

			lengthOfCurrLine = lengthOfCurrLine + textToAdd.length() + 5;

			if (lengthOfCurrLine > 70) {
				namesListed.append(textToAdd + " --- \n");
				lengthOfCurrLine = 0;
			} else {
				namesListed.append(textToAdd + " --- ");
			}

			enterName.setText("");
		}
	}

}
