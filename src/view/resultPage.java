package view;

import javax.swing.*;

public class resultPage {
    private JPanel resultPagePanel;
    private JLabel finalResultText;
    resultPage(String result){
        JFrame resultPage = new JFrame("Resultado");
        if(resultPage!=null) {
            resultPage.setContentPane(resultPagePanel);
            resultPage.setLocation(450, 250);
        }
        finalResultText.setText(result);
        resultPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultPage.pack();
        resultPage.setVisible(true);

    }
}
