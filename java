import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GridBagLayoutExample extends JFrame {

    public GridBagLayoutExample() {
        // 1. Set the Title and basic configurations
        setTitle("GridBagLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center on screen

        // 2. Set the frame's layout manager to GridBagLayout
        setLayout(new GridBagLayout());
        
        // 3. Create the Constraints object
        GridBagConstraints gbc = new GridBagConstraints();
        
        // General behavior: fill available horizontal space and add padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right margins

        // ----- Row 0: Name Label & TextField -----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0; // Don't give extra horizontal space to labels
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Give all remaining horizontal space to text field
        add(new JTextField(20), gbc);

        // ----- Row 1: Email Label & TextField -----
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        add(new JTextField(20), gbc);

        // ----- Row 2: Comments Label & Multi-row TextArea -----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        // Anchor the label to the top-left of its cell space
        gbc.anchor = GridBagConstraints.NORTHWEST; 
        add(new JLabel("Comments:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; // Give extra vertical space to the text area
        gbc.fill = GridBagConstraints.BOTH; // Expand both horizontally and vertically
        JTextArea textArea = new JTextArea(5, 20);
        add(new JScrollPane(textArea), gbc);

        // ----- Row 3: Buttons Container (Spanning multiple columns) -----
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;  // Span across both column 0 and column 1
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST; // Align buttons to the right side

        // Sub-panel to group buttons nicely together
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Submit"));
        buttonPanel.add(new JButton("Cancel"));
        add(buttonPanel, gbc);
    }

    public static void main(String[] args) {
        // Run the GUI creation code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new GridBagLayoutExample().setVisible(true);
        });
    }
}
