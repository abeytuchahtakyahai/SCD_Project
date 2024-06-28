import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class myclass extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblResult;
    private double num1, num2, result;
    private String operator;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	myclass frame = new myclass();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public myclass() {
    	setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblResult = new JLabel("");
        lblResult.setForeground(new Color(0, 0, 0));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBackground(Color.WHITE); 
        lblResult.setOpaque(true); 
        lblResult.setBounds(10, 10, 400, 20);
        contentPane.add(lblResult);

        JLabel lblResultLabel = new JLabel("");
        lblResultLabel.setBounds(10, 10, 50, 20);
        contentPane.add(lblResultLabel);
        lblResult.setBackground(Color.WHITE);
        lblResult.setOpaque(true); 


        JButton btnClear = new JButton("C");
        btnClear.setBackground(new Color(255, 0, 255));
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText("");
                num1 = num2 = result = 0;
                operator = "";
            }
        });
        btnClear.setBounds(86, 54, 50, 20);
        contentPane.add(btnClear);

        JButton btnDelete = new JButton("Del");
        btnDelete.setBackground(new Color(255, 0, 255));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = lblResult.getText();
                if (text.length() > 0) {
                    lblResult.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        btnDelete.setBounds(149, 41, 60, 33);
        contentPane.add(btnDelete);

        JButton btnSquareRoot = new JButton("√");
        btnSquareRoot.setBackground(new Color(0, 255, 255));
        btnSquareRoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(lblResult.getText());
                    lblResult.setText(String.valueOf(Math.sqrt(value)));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnSquareRoot.setBounds(25, 85, 55, 23);
        contentPane.add(btnSquareRoot);

        JButton btnSquare = new JButton("x²");
        btnSquare.setBackground(new Color(0, 255, 255));
        btnSquare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(lblResult.getText());
                    lblResult.setText(String.valueOf(value * value));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnSquare.setBounds(97, 85, 55, 23);
        contentPane.add(btnSquare);

        JButton btnDivide = new JButton("f/x");
        btnDivide.setBackground(new Color(0, 255, 255));
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(lblResult.getText());
                    operator = "/";
                    lblResult.setText("");
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnDivide.setBounds(171, 85, 50, 23);
        contentPane.add(btnDivide);

        JButton btnSubtract = new JButton("-");
        btnSubtract.setBackground(new Color(0, 255, 255));
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(lblResult.getText());
                    operator = "-";
                    lblResult.setText("");
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnSubtract.setBounds(219, 103, 50, 23);
        contentPane.add(btnSubtract);

        JButton btnMultiply = new JButton("×");
        btnMultiply.setBackground(new Color(0, 255, 255));
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(lblResult.getText());
                    operator = "×";
                    lblResult.setText("");
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnMultiply.setBounds(229, 137, 50, 23);
        contentPane.add(btnMultiply);

        JButton btnAdd = new JButton("+");
        btnAdd.setBackground(new Color(0, 255, 255));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(lblResult.getText());
                    operator = "+";
                    lblResult.setText("");
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnAdd.setBounds(229, 171, 50, 23);
        contentPane.add(btnAdd);

        JButton btnEquals = new JButton("=");
        btnEquals.setBackground(new Color(0, 255, 255));
        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    num2 = Double.parseDouble(lblResult.getText());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "×":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                lblResult.setText("Error: Division by zero");
                                return;
                            }
                            break;
                        case "%":
                            result = (num1 * num2) / 100;
                            break;
                        default:
                            lblResult.setText("Error");
                            return;
                    }
                    lblResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error");
                }
            }
        });
        btnEquals.setBounds(203, 205, 76, 45);
        contentPane.add(btnEquals);

        JButton btnZero = new JButton("0");
        btnZero.setForeground(new Color(255, 255, 255));
        btnZero.setBackground(new Color(0, 64, 128));
        btnZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "0");
            }
        });
        btnZero.setBounds(10, 216, 100, 23);
        contentPane.add(btnZero);

        JButton btnDecimal = new JButton(".");
        btnDecimal.setForeground(new Color(255, 255, 255));
        btnDecimal.setBackground(new Color(0, 64, 128));
        btnDecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + ".");
            }
        });
        btnDecimal.setBounds(120, 216, 55, 23);
        contentPane.add(btnDecimal);

        JButton btnOne = new JButton("1");
        btnOne.setForeground(new Color(255, 255, 255));
        btnOne.setBackground(new Color(0, 64, 128));
        btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "1");
            }
        });
        btnOne.setBounds(10, 119, 55, 23);
        contentPane.add(btnOne);

        JButton btnTwo = new JButton("2");
        btnTwo.setForeground(new Color(255, 255, 255));
        btnTwo.setBackground(new Color(0, 64, 128));
        btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "2");
            }
        });
        btnTwo.setBounds(74, 119, 50, 23);
        contentPane.add(btnTwo);

        JButton btnThree = new JButton("3");
        btnThree.setForeground(new Color(255, 255, 255));
        btnThree.setBackground(new Color(0, 64, 128));
        btnThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "3");
            }
        });
        btnThree.setBounds(139, 119, 60, 23);
        contentPane.add(btnThree);

        JButton btnFour = new JButton("4");
        btnFour.setForeground(new Color(255, 255, 255));
        btnFour.setBackground(new Color(0, 64, 128));
        btnFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "4");
            }
        });
        btnFour.setBounds(10, 148, 50, 23);
        contentPane.add(btnFour);

        JButton btnFive = new JButton("5");
        btnFive.setForeground(new Color(255, 255, 255));
        btnFive.setBackground(new Color(0, 64, 128));
        btnFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "5");
            }
        });
        btnFive.setBounds(78, 143, 58, 33);
        contentPane.add(btnFive);

        JButton btnSix = new JButton("6");
        btnSix.setForeground(new Color(255, 255, 255));
        btnSix.setBackground(new Color(0, 64, 128));
        btnSix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "6");
            }
        });
        btnSix.setBounds(144, 153, 55, 23);
        contentPane.add(btnSix);

        JButton btnSeven = new JButton("7");
        btnSeven.setForeground(new Color(255, 255, 255));
        btnSeven.setBackground(new Color(0, 64, 128));
        btnSeven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "7");
            }
        });
        btnSeven.setBounds(10, 171, 49, 34);
        contentPane.add(btnSeven);

        JButton btnEight = new JButton("8");
        btnEight.setForeground(new Color(255, 255, 255));
        btnEight.setBackground(new Color(0, 64, 128));
        btnEight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "8");
            }
        });
        btnEight.setBounds(74, 182, 50, 23);
        contentPane.add(btnEight);

        JButton btnNine = new JButton("9");
        btnNine.setForeground(new Color(255, 255, 255));
        btnNine.setBackground(new Color(0, 64, 128));
        btnNine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(lblResult.getText() + "9");
            }
        });
        btnNine.setBounds(139, 182, 60, 23);
        contentPane.add(btnNine);

        JRadioButton rdbtnOn = new JRadioButton("On");
        rdbtnOn.setBackground(new Color(255, 255, 0));
        rdbtnOn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  enableButtons(true);
            }
        });
        rdbtnOn.setBounds(6, 31, 54, 20);
        contentPane.add(rdbtnOn);

        JRadioButton rdbtnOff = new JRadioButton("Off");
        rdbtnOff.setBackground(new Color(255, 255, 0));
        rdbtnOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  enableButtons(false);
            }
        });
        rdbtnOff.setBounds(10, 54, 50, 24);
        contentPane.add(rdbtnOff);
        
        JButton btnL = new JButton("L");
        btnL.setBackground(new Color(0, 255, 255));
        btnL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = lblResult.getText();
                if (text.length() > 0) {
                    lblResult.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        btnL.setBounds(219, 41, 60, 23);
        contentPane.add(btnL);

    }

  //  private void enableButtons(boolean enabled) {
  //      for (Component c : contentPane.getComponents()) {
   //         if (c instanceof JButton || c instanceof JRadioButton) {
   //             c.setEnabled(enabled);
    //        }
    //    }
    //    lblResult.setText("");
  //  }
}