import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MoreThenThreeAuthers extends JFrame {

    JButton button;

    public MoreThenThreeAuthers() {

        this.setSize(600, 200);
        try {
            this.setTitle(Head.decodeText("Книга с количеством авторов более трех (четыре и больше)", "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(5, 3));
        this.setVisible(true);
        this.setIconImage(Head.icon.getImage());

        StringForInput nameOfBook = new StringForInput("Название книги");
        StringForInput firstNameLetter = new StringForInput("Заглавная буква имени первого автора");
        StringForInput patronymicFirstLetter = new StringForInput("Заглавная буква отчества первого автора");
        StringForInput surName = new StringForInput("Фамилия первого автора");
        StringForInput editedByfirstNameLetter = new StringForInput("Заглаваная буква имени редактора");
        StringForInput editedPatronymicFirstLetter = new StringForInput("Заглаваная буква отчества редактора");
        StringForInput editedBySurName = new StringForInput("Фамилия редактора");
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
            String string = null;
            try {
                string = nameOfBook.transformToUpperCase(nameOfBook) + " / " + firstNameLetter.getText().toUpperCase() + "." +
                        patronymicFirstLetter.getText().toUpperCase() + ". " + surName.transformToUpperCase(surName) + " "+Head.decodeText("[и др.] ; под общ. ред.", "UTF-8") +
                        " " +editedByfirstNameLetter.getText().toUpperCase()+"."+ editedPatronymicFirstLetter.getText().toUpperCase()+". "+
                        editedBySurName.transformToUpperCase(editedBySurName)+". - "+ city.transformToUpperCase(city) +" : "+
                        publisher.transformToUpperCase(publisher) + ", " + year.getText() + ". - " + numberOfPages.getText() + " c.";
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            /*
            JOptionPane.showMessageDialog(LessThenThreeAuthors.this, string);
            */
            JTextArea result = new JTextArea(string, 1, 1);
            result.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            result.setBackground(new Color(185, 150, 178));
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
            this.setSize(1500, 200);
            this.setIconImage(Head.icon.getImage());
            this.setVisible(true);
        });

        this.add(nameOfBook);
        this.add(firstNameLetter);
        this.add(patronymicFirstLetter);
        this.add(surName);
        this.add(editedByfirstNameLetter);
        this.add(editedPatronymicFirstLetter);
        this.add(editedBySurName);
        this.add(city);
        this.add(publisher);
        this.add(year);
        this.add(numberOfPages);

        this.add(button);

        this.pack();
    }
}
