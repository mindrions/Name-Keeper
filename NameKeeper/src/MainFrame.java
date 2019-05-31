import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private NamePanel namePanel;
	public Dimension d;

	public MainFrame() {
		super("NameKeeper");

		setLayout(new BorderLayout());

		namePanel = new NamePanel();
		namePanel.setBackground(Color.WHITE);

		add(namePanel, BorderLayout.CENTER);

//		d = new Dimension(999, 999);
//		d.width = 50;
//		leftPanel.setPreferredSize(d);
//		
//		d = new Dimension(999, 999);
//		d.height = 25;
//		topPanel.setPreferredSize(d);

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//makes it so enter key works on this button
		namePanel.getRootPane().setDefaultButton(namePanel.enterButton);

	}

}
