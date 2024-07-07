import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatBoot extends JFrame implements ActionListener {
    final String TITLE_OF_PROGRAM = "Simple_ChatBot";
    final int START_LOATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue; //место для диалога
    JCheckBox ai; // пдключить ai
    JTextField message; // поле для ввода сообщения
    SimpleBot sbot;

    public static void main(String[] args) {
        new ChatBoot();
    }

    public ChatBoot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOATION, START_LOATION, WINDOW_WIDTH, WINDOW_HEIGHT);

        // место для диалога
        dialogue = new JTextArea();
        dialogue.setLineWrap(true); // перенос строк
        JScrollPane scrollBar = new JScrollPane(dialogue);

        // создаем место для размещения элементов(кнопки, чек-бокс, поле для текста)
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox("AI");
        //ai.doClick();
        message = new JTextField();
        message.addActionListener(this); // возможность нажать "Enter" на клавиатуре
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);

        // добавить все элементы на окно программы
        bp.add(ai);
        bp.add(message);
        bp.add(enter);

        add(BorderLayout.SOUTH, bp);
        add(BorderLayout.CENTER, scrollBar);
        setVisible(true);
        sbot = new SimpleBot(); // создали бота
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 14) + ": " +
                    sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}