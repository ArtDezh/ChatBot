import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatBoot extends JFrame {
    final String TITLE_OF_PROGRAM = "Simple ChatBot";
    final int START_LOATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue; //место для диалога
    JCheckBox ai; // пдключить ai
    JTextField message; // поле для ввода сообщения
    //SimpleBot sbot;

    public static void main(String[] args) {
        new ChatBoot();
    }

    public ChatBoot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOATION, START_LOATION, WINDOW_WIDTH, WINDOW_HEIGHT);

        setVisible(true);
    }
}