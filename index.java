import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index implements ActionListener{
JFrame frame;
JTextField textField;
JButton[]numberButtons= new JButton[10];
JButton[]functionButtons=new JButton[8];
JButton addButton,subButton,mulButton,divButton;
JButton decButton,equButton,delButton,clrButton;
JPanel Panel;
Font myFont=new Font("BOLD",Font.BOLD,30);

double num1=0,num2=0,result=0;
char operator;

index(){
    frame=new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420,550);
    frame.setLayout(null);
    
    textField=new JTextField();
    textField.setBounds(50,25,300,50);
    textField.setFont(myFont);
    textField.setEditable(false);

    addButton=new JButton("+");
    subButton=new JButton("-");
    mulButton=new JButton("*");
    divButton=new JButton("/");
    decButton=new JButton(".");
    equButton=new JButton("=");
    clrButton=new JButton("clear");
    delButton=new JButton("delete");

    functionButtons[0]=addButton;
    functionButtons[1]=subButton;
    functionButtons[2]=mulButton;
    functionButtons[3]=divButton;
    functionButtons[4]=decButton;
    functionButtons[5]=equButton;
    functionButtons[6]=clrButton;
    functionButtons[7]=delButton;

    for(int i=0;i<8;i++){
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFont(myFont);
        functionButtons[i].setFocusable(false);
    }
    for(int i=0;i<10;i++){
        numberButtons[i]=new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(myFont);
        numberButtons[i].setFocusable(false);
    }
    delButton.setBounds(50,430,145,50);
    clrButton.setBounds(205,430,145,50);

    Panel=new JPanel();
    Panel.setBounds(50,100 ,300,300);
    Panel.setLayout(new GridLayout(4,4,10,10));
    Panel.setBackground(Color.cyan);

    Panel.add(numberButtons[1]);
    Panel.add(numberButtons[2]);    
    Panel.add(numberButtons[3]);
    Panel.add(addButton);
    Panel.add(numberButtons[4]);
    Panel.add(numberButtons[5]);    
    Panel.add(numberButtons[6]);
    Panel.add(subButton);
    Panel.add(numberButtons[7]);
    Panel.add(numberButtons[8]);    
    Panel.add(numberButtons[9]);
    Panel.add(mulButton);
    Panel.add(decButton);
    Panel.add(numberButtons[0]);
    Panel.add(equButton);
    Panel.add(divButton);
    frame.add(Panel);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textField);
    frame.setVisible(true);
    
}
    public static void main(String[]args){
        index ind= new index();
    }

    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                   result= num1+num2;
                    break;
            case'-':
            result=num1-num2;
            break;
            case'*':
            result=num1*num2;
            break;
            case'/':
            result=num1/num2;
            
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string=textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
     
    }
}