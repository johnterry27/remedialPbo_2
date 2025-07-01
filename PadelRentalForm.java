package com.mycompany.padelrentalform;

import java.awt.BorderLayout;                       
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;  

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;                     
import javax.swing.JPanel;
import javax.swing.JScrollPane;                     
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
 

public class PadelRentalForm extends JFrame {
   private JTextField tfNama, tfNoHP, tfTanggal, tfJamMulai, tfJamSelesai;
   private JComboBox<String> cbLapangan;
    private JTable drinkTable;
    private DefaultTableModel tableModel;
    private JTextField noHPField;
    private JTextField nameField;
    private JTextField  tanggalField;
    private JTextField jammulaiField;
    private JTextField jammselesaiField;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;

   
   public PadelRentalForm() {
       setTitle("Form Sewa Lapangan Padel");
       setSize(400, 350);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridLayout(7, 2, 10, 10));
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());  

         JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5)); 

       tfNama = new JTextField();
       tfNoHP = new JTextField();
       tfTanggal = new JTextField("yyyy-mm-dd");
       tfJamMulai = new JTextField("08:00");
       tfJamSelesai = new JTextField("09:00");

       String[] lapanganOptions = { "Lapangan 1", "Lapangan 2", "Lapangan 3", "Lapangan 4" };
       cbLapangan = new JComboBox<>(lapanganOptions);

       JButton btnSubmit = new JButton("Simpan");

       add(new JLabel("Nama Penyewa:")); add(tfNama);
       add(new JLabel("No HP:")); add(tfNoHP);
       add(new JLabel("Tanggal Sewa:")); add(tfTanggal);
       add(new JLabel("Jam Mulai:")); add(tfJamMulai);
       add(new JLabel("Jam Selesai:")); add(tfJamSelesai);
       add(new JLabel("Lapangan:")); add(cbLapangan);
       add(btnSubmit); add(new JLabel());

        saveButton = new JButton("Simpan");
        editButton = new JButton("Edit");            
        deleteButton = new JButton("Hapus");         

        formPanel.add(saveButton);
        formPanel.add(editButton);                  
        formPanel.add(deleteButton); 

        add(formPanel, BorderLayout.NORTH);
        tableModel = new DefaultTableModel(new String[]{"Nama Penyewa", "no", "Tanggal Sewa", "Jammulai", "Jamselesai", "Lapangan"}, 0);
        drinkTable = new JTable(tableModel);
        add(new JScrollPane(drinkTable), BorderLayout.CENTER);

        saveButton.addActionListener(e -> {
            try {
                    String  tfnama= nameField.getText();
                    String tfnoHP = noHPField.getText();
                    String tftanggal = tanggalField.getText();
                    String tfjammulai =  jammulaiField.getText();
                    String tfjamselesai=  jammselesaiField.getText();
                clearForm(); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid.");
            }
        });

     
        editButton.addActionListener(e -> {
            int row = drinkTable.getSelectedRow();
            if (row != -1) {
                try {
                    String  tfnama= nameField.getText();
                    String tfnoHP = noHPField.getText();
                    String tftanggal = tanggalField.getText();
                    String tfjammulai =  jammulaiField.getText();
                    String tfjamselesai=  jammselesaiField.getText();
                    clearForm(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

     
        deleteButton.addActionListener(e -> {
            int row = drinkTable.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
                clearForm(); 
            }
        });

       
        drinkTable.getSelectionModel().addListSelectionListener(e -> {
            int row = drinkTable.getSelectedRow();
            if (row != -1) {
                String  tfnama= nameField.getText();
                String tfnoHP = noHPField.getText();
                String tftanggal = tanggalField.getText();
                String tfjammulai =  jammulaiField.getText();
                String tfjamselesai=  jammselesaiField.getText();
            }
        });

        
        setVisible(true);                             
    }
    
    private void clearForm() {
        nameField.setText("");
        noHPField.setText("");
        tanggalField.setText("");
        jammulaiField.setText("");
        jammselesaiFieldField.setText("");
    }
        
   }
 `public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PadelRentalForm().setVisible(true));
    }

   

    
