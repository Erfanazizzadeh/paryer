import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prayer {
    private JLabel lbl_God;
    private JButton btnNumber;
    private JFrame app;
    private JLabel lbl_result;
    private JButton btn_Exit;
    private JButton btn_Clear;

    private int[] numbers;
    private int index = 0;
    private static final int NUMBER_LENGTH = 100;


    public void createView() {
        //Frame
        app = new JFrame();
        app.setTitle("صلوات شمار ");
        app.setSize(500, 200);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new GridBagLayout());
        Font font = new Font(Font.DIALOG, Font.BOLD, 18);
        //member
        btnNumber = new JButton("Ok");
        lbl_result = new JLabel("start");
        lbl_God = new JLabel("In The Name of God");
        btn_Exit = new JButton("Exit");
        btn_Clear = new JButton("Clear");

        this.numbers = new int[NUMBER_LENGTH];

        btnNumber.addActionListener(this::actionButton);
        btn_Exit.addActionListener(this::btnExit);
        btnClear();

        //Font
        btnNumber.setFont(font);
        btn_Exit.setFont(font);
        btn_Clear.setFont(font);
        lbl_result.setFont(font);
        lbl_God.setFont(font);


        // Size Members
        AddItem(app, btnNumber, 1, 3, 1, 1, GridBagConstraints.HORIZONTAL);
        AddItem(app, btn_Exit, 3, 3, 1, 1, GridBagConstraints.HORIZONTAL);
        AddItem(app, btn_Clear, 2, 3, 1, 1, GridBagConstraints.HORIZONTAL);
        AddItem(app, lbl_result, 1, 2, 1, 1, GridBagConstraints.HORIZONTAL);
        AddItem(app, lbl_God, 1, 0, 1, 1, GridBagConstraints.HORIZONTAL);


        app.setVisible(true);
    }

    public void actionButton(ActionEvent e) {
            increment();
            lbl_result.setText(" " + (numbers[index]));
    }

    private void reset() {
        System.out.println("index === " + index);
        if (index == numbers.length - 1) {
            this.index = 0;
        }
    }

    private void resetNumber() {
        this.index = 0;
    }
    private void increment() {
        reset();
        index++;
        numbers[index] = index;
    }

    public void btnExit(ActionEvent e) {
          System.exit(0);
    }

    public void btnClear() {
        btn_Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  System.in.reset(Lbl_Resault.setText(null));
                lbl_result.setText("start");
                resetNumber();
            }
        });
    }


//    public  void panel(){
//
//        btnnum = new JButton();
//        btnnum.setFont(new Font("Dialog",Font.BOLD,24));
//        btnnum.setText("Ok");
//       gbc.gridy=1;
//        gbc.gridx=1;
//        app.add(btnnum);


//        label = new JLabel();
//
//        label.setFont(new Font("Dialog",Font.BOLD,24));
//        label.setText("0");

    //        btnnum.addActionListener(new ActionListener() {
//            int N[] = new  int[100];
//            int a = 0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (N[a] == 101){
//                    label.setText(null);
//                System.exit(0);
//                }else {
//                    label.setText(""+ (N[a]++));
//                }
//            }
//
//        });
//        app.add(label);
//    }
    public static void main(String[] args) {
        Prayer app = new Prayer();
        app.createView();


//        btnnum.setFont(new Font("Dialog",Font.BOLD,24));
//        btnnum.setText("Ok");


//        label.setFont(new Font("Dialog",Font.BOLD,24));
////        label.setText("0");


    }

    public void AddItem(JFrame frame, JComponent component, int x, int y, int width, int height, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = y;
        gbc.gridx = x;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        frame.add(component, gbc);
    }
}
