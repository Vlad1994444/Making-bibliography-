import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StringForInput extends JTextField {

    StringForInput(String name){
        this.setPreferredSize(new Dimension(350, 50));
        this.setHorizontalAlignment(JTextField.CENTER);
        try {
            this.setText(Head.decodeText(name, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setFont(new Font("Times New Roman", Font.BOLD, 15));
    }

    public String transformToUpperCase(StringForInput stringForInput){
        String getText = stringForInput.getText();
        String firstLetterUpperCase = getText.substring(0,1).toUpperCase();
        return firstLetterUpperCase+getText.substring(1);
    }
}
