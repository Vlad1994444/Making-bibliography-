import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LessThenThreeAuthors extends JFrame{
    /*
    JTextField firstNameLetter, patronymicFirstLetter,
    nameOfBook, city, publisher, year, numberOfPages;
     */

    JButton button;

    public LessThenThreeAuthors(){

        this.setSize(600,200);
        try {
            this.setTitle(Head.decodeText("Книга с количеством авторов менее трех (три и меньше)", "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(Head.icon.getImage());
        this.setLayout(new GridLayout(3,3));
        this.setVisible(true);

        /*
        surName = new JTextField();
        surName.setPreferredSize(new Dimension(300, 50));
        surName.setHorizontalAlignment(JTextField.CENTER);
        surName.setText(Head.convert(87,117));

        firstNameLetter = new JTextField();
        firstNameLetter.setPreferredSize(new Dimension(300, 50));
        firstNameLetter.setHorizontalAlignment(JTextField.CENTER);
        firstNameLetter.setText(Head.convert(156,182));

        patronymicFirstLetter = new JTextField();
        patronymicFirstLetter.setPreferredSize(new Dimension(300, 50));
        patronymicFirstLetter.setHorizontalAlignment(JTextField.CENTER);
        patronymicFirstLetter.setText(Head.convert(182,211));

        nameOfBook = new JTextField();
        nameOfBook.setPreferredSize(new Dimension(300, 50));
        nameOfBook.setHorizontalAlignment(JTextField.CENTER);
        nameOfBook.setText(Head.convert(217,231));

        city = new JTextField();
        city.setPreferredSize(new Dimension(300, 50));
        city.setHorizontalAlignment(JTextField.CENTER);
        city.setText(Head.convert(231,254));

        publisher = new JTextField();
        publisher.setPreferredSize(new Dimension(300, 50));
        publisher.setHorizontalAlignment(JTextField.CENTER);
        publisher.setText(Head.convert(254,270));

        year = new JTextField();
        year.setPreferredSize(new Dimension(300, 50));
        year.setHorizontalAlignment(JTextField.CENTER);
        year.setText(Head.convert(270,281));

        numberOfPages = new JTextField();
        numberOfPages.setPreferredSize(new Dimension(300, 50));
        numberOfPages.setHorizontalAlignment(JTextField.CENTER);
        numberOfPages.setText(Head.convert(281,299));
        */

        StringForInput surName = new StringForInput("Фамилия первого автора");
        StringForInput firstNameLetter = new StringForInput("Заглавная буква имени первого автора");
        StringForInput patronymicFirstLetter = new StringForInput("Заглавная буква отчества первого автора");
        StringForInput nameOfBook = new StringForInput("Название книги");
        StringForInput city = new StringForInput("Город издания");
        StringForInput publisher = new StringForInput("Фирма (издатель)");
        StringForInput year = new StringForInput("Год издания");
        StringForInput numberOfPages = new StringForInput("Количество страниц");

        try {
            button = new JButton(Head.decodeText("Получить оформленную ссылку", "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setPreferredSize(new Dimension(200, 50));
        button.setHorizontalAlignment(JButton.CENTER);
        button.addActionListener(e -> {
            String string = surName.transformToUpperCase(surName) + ", " + firstNameLetter.getText().toUpperCase() + ". " +
                    patronymicFirstLetter.getText().toUpperCase() + ". "+ nameOfBook.transformToUpperCase(nameOfBook)+" / " +
                    firstNameLetter.getText().toUpperCase()+ ". "+ patronymicFirstLetter.getText().toUpperCase()+ ". "+
                    surName.transformToUpperCase(surName) + ". - " +city.transformToUpperCase(city)+publisher.transformToUpperCase(publisher)+", "+
                    year.getText()+". - "+numberOfPages.getText()+" c.";
            /*
            JOptionPane.showMessageDialog(LessThenThreeAuthors.this, string);
            */
            JTextArea result = new JTextArea(string, 1, 1);
            result.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            result.setBackground(new Color(185, 150,178));
            result.setLineWrap(true);
            result.setWrapStyleWord(true);
            JLabel panel = new JLabel();
            panel.add(result);
            this.setContentPane(result);
            try {
                this.setTitle(Head.decodeText("Готово", "UTF-8"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.setSize(1500,200);
            this.setIconImage(Head.icon.getImage());
            this.setVisible(true);
        });

        this.add(surName);
        this.add(firstNameLetter);
        this.add(patronymicFirstLetter);
        this.add(nameOfBook);
        this.add(city);
        this.add(publisher);
        this.add(year);
        this.add(numberOfPages);

        this.add(button);

        this.pack();

    }
}
