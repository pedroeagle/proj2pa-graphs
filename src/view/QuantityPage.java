package view;

import model.Pair;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import static model.Main.grafo;

public class QuantityPage {
    private JLabel infoQuantityButton;
    private JButton proximoQuantityButton;
    private JPanel QuantityPagePanel;
    private JTextField selectQuantityIn;

    QuantityPage(){
        JFrame quantityPage = new JFrame("Tamanho do grafo");
        if(quantityPage!=null) {
            quantityPage.setContentPane(QuantityPagePanel);
            quantityPage.setLocation(450, 250);
        }
        proximoQuantityButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    grafo.clear();
                    int size = Integer.valueOf(selectQuantityIn.getText());
                    for (int i = 0; i < size; i++) {
                        grafo.add(new Vector<Pair>());
                    }
                    quantityPage.dispose();
                    new CreatePage();
                }catch (Exception error){
                    quantityPage.dispose();
                    new QuantityPage();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        quantityPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        quantityPage.pack();
        quantityPage.setVisible(true);
    }

}
