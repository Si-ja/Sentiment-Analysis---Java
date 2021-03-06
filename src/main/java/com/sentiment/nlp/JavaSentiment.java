package com.sentiment.nlp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JavaSentiment extends JFrame {
    private JPanel MainPanel;
    private JButton btn_Analyse;
    private JTextField text_Output;
    private JTextField text_Input;
    private JLabel lbl_Input;
    private JLabel lbl_Output;
    private JLabel lbl_Greetings;
    private SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();

    public JavaSentiment(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();

        btn_Analyse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Grab the text from the Input field
                // Analyse it
                // Output the text into the output window with proper formating
                String text = text_Input.getText();
                ArrayList<ArrayList<String>> answers = sentimentAnalysis.predictSentiment(text);
                String formatedAnswer = "";
                for (ArrayList<String> list : answers) {
                    String sentence = list.get(0);
                    String sentiment = list.get(1);
                    formatedAnswer += sentence + ": " + sentiment + "\n";
                }
                text_Output.setText(formatedAnswer);

            }
        });
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        text_Output = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets = new Insets(10, 10, 10, 10);
        MainPanel.add(text_Output, gbc);
        text_Input = new JTextField();
        text_Input.setEditable(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets = new Insets(10, 10, 10, 10);
        MainPanel.add(text_Input, gbc);
        btn_Analyse = new JButton();
        Font btn_AnalyseFont = this.$$$getFont$$$("DialogInput", Font.BOLD, 12, btn_Analyse.getFont());
        if (btn_AnalyseFont != null) btn_Analyse.setFont(btn_AnalyseFont);
        btn_Analyse.setText("Analyse the Sentiment");
        btn_Analyse.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 50;
        gbc.insets = new Insets(10, 20, 10, 20);
        MainPanel.add(btn_Analyse, gbc);
        lbl_Input = new JLabel();
        Font lbl_InputFont = this.$$$getFont$$$("DialogInput", Font.BOLD, 14, lbl_Input.getFont());
        if (lbl_InputFont != null) lbl_Input.setFont(lbl_InputFont);
        lbl_Input.setText("Input Text:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        MainPanel.add(lbl_Input, gbc);
        lbl_Output = new JLabel();
        lbl_Output.setEnabled(true);
        Font lbl_OutputFont = this.$$$getFont$$$("DialogInput", Font.BOLD, 14, lbl_Output.getFont());
        if (lbl_OutputFont != null) lbl_Output.setFont(lbl_OutputFont);
        lbl_Output.setText("Output:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        MainPanel.add(lbl_Output, gbc);
        lbl_Greetings = new JLabel();
        Font lbl_GreetingsFont = this.$$$getFont$$$("DialogInput", Font.BOLD, 16, lbl_Greetings.getFont());
        if (lbl_GreetingsFont != null) lbl_Greetings.setFont(lbl_GreetingsFont);
        lbl_Greetings.setText("Sentiment Analyser with Java");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        MainPanel.add(lbl_Greetings, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPanel;
    }
}
