import javax.swing.*;
import java.io.IOException;

public class ButtonsInHead extends JButton {

    public ButtonsInHead (int posX, int posY, int width, int height, String name){

        try {
            this.setText(Head.decodeText(name, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(posX, posY, width, height);
        this.setFocusable(false);
        this.setHorizontalAlignment(JButton.CENTER);
    }
}
