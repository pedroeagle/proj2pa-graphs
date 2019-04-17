package view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static model.Main.RandomGraphGenerate;
import static model.Main.grafo;

public class MainPage {

    private JButton createMainButton;
    private JButton bfsMainButton;
    private JButton dfsMainButton;
    private JButton djiMainButton;
    private JButton generateMainButton;
    private JTextArea generateMainText;
    private JPanel MainPagePanel;

    public MainPage(){
        JFrame mainPage = new JFrame("Grafo Debugger");
        if(mainPage!=null) {
            mainPage.setContentPane(MainPagePanel);
            mainPage.setLocation(450, 250);
        }
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.pack();
        mainPage.setVisible(true);
        createMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new QuantityPage();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                generateMainText.setText("Abre uma janela para que seja criado um grafo.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                generateMainText.setText("");
            }
        });
        generateMainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RandomGraphGenerate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                generateMainText.setText("Gera um grafo com tamanhos e nós aleatórios.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                generateMainText.setText(" ");
            }
        });

        if(grafo.isEmpty()) {
            dfsMainButton.setVisible(false);
            bfsMainButton.setVisible(false);
            djiMainButton.setVisible(false);
        }
        else{
            dfsMainButton.setVisible(true);
            bfsMainButton.setVisible(true);
            djiMainButton.setVisible(true);
        }
    }
}
