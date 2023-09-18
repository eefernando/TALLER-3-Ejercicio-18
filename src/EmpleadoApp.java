import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Salario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel horasLabel = new JLabel("Horas Trabajadas:");
        JTextField horasField = new JTextField();
        JLabel valorLabel = new JLabel("Valor por Hora:");
        JTextField valorField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        JLabel resultadoLabel = new JLabel();

        panel.add(horasLabel);
        panel.add(horasField);
        panel.add(valorLabel);
        panel.add(valorField);
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double horasTrabajadas = Double.parseDouble(horasField.getText());
                    double valorHora = Double.parseDouble(valorField.getText());

                    double salarioBruto = horasTrabajadas * valorHora;
                    double salarioNeto = salarioBruto * 0.9; // Ejemplo de retención del 10%

                    resultadoLabel.setText("Salario Bruto: $" + salarioBruto + ", Salario Neto: $" + salarioNeto);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Error: Ingresa valores numéricos válidos.");
                }
            }
        });

        frame.add(panel);
        frame.add(resultadoLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
