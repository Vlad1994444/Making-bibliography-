import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;

public class Head extends JFrame{

    ImageIcon icon;

    public static String decodeText(String input, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()), Charset.forName(encoding)));
        return reader.readLine();
    }
    /*
    short form in one line
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()),
                Charset.forName(encoding)))
                .readLine();
    }
     */
    /*
    !!!another way with document reader. Do not forget mistakes!!!
    public static String convert(int start, int finish) {
        File file = new File("1.txt");
        InputStreamReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            int a = reader.read();
            while (a != -1) {
                builder.append((char) a);
                a = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.substring(start, finish);
    }
     */


    public Head() {

        icon = new ImageIcon(getClass().getResource("/icon.png"));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,600,399);

        ImageIcon book = new ImageIcon(getClass().getResource("/book.jpg"));
        JLabel backPicture = new JLabel(book);
        backPicture.setBounds(0,0,600,399);

        JLabel question = new JLabel();
        question.setBounds(100, 30, 400, 50);
        try {
            question.setText(decodeText("???????????????? ?????????????????????????? ?????? ????????????????????","UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //question.setText(convert(15, 52));
        question.setFont(new Font("Ponter S", Font.ITALIC, 20));
        question.setForeground(new Color(76,218,218));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setVerticalAlignment(JLabel.CENTER);

//        variantOne = new JButton(convert(52, 87));
//        variantOne.setBounds(30,70,300,50);
//        variantOne.setFocusable(false);
//        variantOne.addActionListener(e -> new LessThenThreeAuthors());

        ButtonsInHead bookLessThenThree  =new ButtonsInHead(30,90,390,50,"?????????? ?? ?????????????????????? ?????????????? ?????????? ???????? (?????? ?? ????????????)");
        bookLessThenThree.addActionListener(e->new LessThenThreeAuthors());
        ButtonsInHead bookMoreThenThree = new ButtonsInHead(115,130,390,50,"?????????? ?? ?????????????????????? ?????????????? ?????????? ???????? (???????????? ?? ????????????)");
        bookMoreThenThree.addActionListener(e->new MoreThenThreeAuthers());

        panel.add(question);
        panel.add(bookLessThenThree);
        panel.add(bookMoreThenThree);
        panel.add(backPicture);

        this.setSize(600, 399);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        this.setIconImage(icon.getImage());
        try {
            this.setTitle(decodeText("???????????? ????????????????????","UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.setTitle(convert(529, 546));

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setContentPane(panel);

    }
}
