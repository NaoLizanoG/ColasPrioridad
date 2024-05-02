import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel Ventana;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton ingresarButton;
    private JButton atenderButton;
    private JList listPacientes;
Emergencias pacienteEmergencia = new Emergencias();
DefaultListModel dlm =new DefaultListModel();
public Ventana(){

    ingresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pacienteEmergencia.encolar(textField1.getText(),textField2.getText(),Integer.parseInt(comboBox1.getSelectedItem().toString()));
        llenarJList();
        }
    });

}
    public void llenarJList(){
        dlm.removeAllElements();
        List<Paciente>paciente = pacienteEmergencia.listarPacientes();
        Collections.sort(paciente);
        for (Paciente p:paciente){
            dlm.addElement(p);
        }
        listPacientes.setModel(dlm);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
