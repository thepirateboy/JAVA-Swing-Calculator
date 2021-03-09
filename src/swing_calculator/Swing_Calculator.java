package swing_calculator;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Swing_Calculator implements IMathCalc
{
    //private data (form and components)
    private JFrame fm;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    
    private JLabel nbr1_Label;
    private JLabel nbr2_Label;
    private JLabel result_Label;
    
    private JTextField nbr1_Textfield;
    private JTextField nbr2_Textfield;
    private JTextField result_Textfield;
    
    private JButton add_Button;
    private JButton subtract_Button;
    private JButton multiply_Button;
    private JButton devide_Button;
    
    private GridLayout layout;
    
    
    //constructor (like we did on swing_test)
    //set up the frame and components (intantce)
    //set up listeners button
    //setup code for calculation
    public Swing_Calculator()
    {
        //frame
        fm = new JFrame();
        //layout
        layout = new GridLayout(4,1);
        //panels
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        //label
        nbr1_Label = new JLabel("Number 1: ");
        nbr2_Label = new JLabel("Number 2: ");
        result_Label = new JLabel("Result: ");
        //text fields
        nbr1_Textfield = new JTextField("", 20);
        nbr2_Textfield = new JTextField("", 20);
        result_Textfield = new JTextField("", 20);
        //buttons
        add_Button = new JButton("Add");
        subtract_Button = new JButton("Subtrac");
        multiply_Button = new JButton("Multiply");
        devide_Button = new JButton("Devide");
        
        //add component into the JFrame
        fm.getContentPane().add(panel1);
        fm.getContentPane().add(panel2);
        fm.getContentPane().add(panel3);
        fm.getContentPane().add(panel4);
        
        //add components to each panels
        panel1.add(nbr1_Label);
        panel1.add(nbr1_Textfield);
        
        panel2.add(nbr2_Label);
        panel2.add(nbr2_Textfield);
        
        panel3.add(result_Label);
        panel3.add(result_Textfield);
        
        panel4.add(add_Button);
        panel4.add(subtract_Button);
        panel4.add(multiply_Button);
        panel4.add(devide_Button);
        
        //form setup (size, location, title, etc)
        fm.setSize(400, 300);
        fm.setLocation(200, 200);
        fm.setTitle("Swing Calculator");
        fm.setLayout(layout);
        fm.setVisible(true);
        
        
        // add components to frame object (fm)
        //fm.getContentPane().add(nbr1_Label);
        
        // set up the normal close behaviour 
        fm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Buttons events
        //ADD
        add_Button.addActionListener(new ActionListener() 
        { @Override
          public void actionPerformed(ActionEvent ae) 
          {
            calculate("+");
          }
          
        });
        //SUBTRACT
        subtract_Button.addActionListener(new ActionListener() 
        { @Override
          public void actionPerformed(ActionEvent ae) 
          {
            calculate("-");
          }
          
        });
        //MULTIPLY
        multiply_Button.addActionListener(new ActionListener() 
        { @Override
          public void actionPerformed(ActionEvent ae) 
          {
            calculate("*");
          }
          
        });
        //DEVIDE
        devide_Button.addActionListener(new ActionListener() 
        { @Override
          public void actionPerformed(ActionEvent ae) 
          {
            calculate("/");
          }
          
        });

        
    }
    
    public void calculate(String op)
    {
        double result = 0, nbr1, nbr2;
        
        
        
        
        try 
        {
            // 1. Get the 2 numbers that entered by the user
        nbr1 = Double.parseDouble(nbr1_Textfield.getText());
        nbr2 = Double.parseDouble(nbr2_Textfield.getText());
        // 2. Check what math operator is
        if (op.equals("+"))
        {
            result = add(nbr1,nbr2);
        }
        else if (op.equals("-"))
        {
            result = subtract(nbr1,nbr2);
        }
        else if (op.equals("*"))
        {
            result = multiply(nbr1,nbr2);
        }
        else if (op.equals("/"))
        {
            result = devide(nbr1,nbr2);
        }
        
        //display result
        result_Textfield.setText(Double.toString(result));
        }
        
        catch (NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "yo..yo.., number only!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //interface methods 
    //(all complete with implementation code)
    public double add (double d1, double d2)
    {
        return d1 + d2;
    }
    public double subtract (double d1, double d2)
    {
        return d1 - d2;
    }
    public double multiply (double d1, double d2)
    {
        return d1 * d2;
    }
    public double devide (double d1, double d2)
    {
        if (d2 != 0) 
        {
            return d1 / d2;
        }
        else
        {
            return 0;
        }    
    }
    
    public static void main(String[] args) 
    {
        // thread safe
        SwingUtilities.invokeLater (new Runnable(){
            public void run() {
                Swing_Calculator sCalc = new Swing_Calculator();
            } 
        });
    }

    @Override
    public double divide(double d1, double d2) 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
} //end of class
