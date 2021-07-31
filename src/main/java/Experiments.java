import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Experiments {
    public static String decodeText(String input, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), Charset.forName(encoding)));
        return reader.readLine();
    }
//        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()),
//                Charset.forName(encoding))).readLine();
//    }

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        String end = null;
        try {
            end = decodeText("влоа кроп", "UTF-8");
            frame.setTitle(end);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setLayout(null);

        JLabel text = new JLabel(end);
        text.setBounds(30, 80, 50, 50);

        ImageIcon icon = new ImageIcon("src\\main\\java\\icon.png");
        JLabel picture = new JLabel(icon);
        picture.setVerticalAlignment(JLabel.TOP);
        picture.setBounds(300, 300, 700, 700);
        picture.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JButton button = new JButton();
        button.setBounds(300, 300, 200, 50);

        panel.add(text);
        panel.add(button);
        panel.add(picture);

        frame.setContentPane(panel);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
