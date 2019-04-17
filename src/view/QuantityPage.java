package view;

import javax.swing.*;

public class QuantityPage {
    private JTextArea infoQuantityButton;
    private JComboBox comboBox1;
    private JButton nextQuantityButton;
    private JPanel QuantityPagePanel;

    QuantityPage(){
        JFrame quantityPage = new JFrame("Tamanho do grafo");
        if(quantityPage!=null) {
            quantityPage.setContentPane(QuantityPagePanel);
            quantityPage.setLocation(450, 250);
        }
        quantityPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quantityPage.pack();
        quantityPage.setVisible(true);
    }
}
