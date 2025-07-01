 

package com.mycompany.padelrentalform;

import java.awt.BorderLayout;
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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class PadelRentalForm extends JFrame {
   private JTextField tfNama, tfNoHP, tfTanggal, tfJamMulai, tfJamSelesai;
   private JComboBox<String> cbLapangan;
    private JButton editButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JTable drinkTable;
    private DefaultTableModel tableModel;
    private JTextField noField;
    private JTextField nameField;
    private JTextField tanggalField;
    private JTextField jamulaiField;
     private JTextField jamselesaiField;




   public PadelRentalForm() {
       setTitle("Form Sewa Lapangan Padel");
       setSize(400, 350);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridLayout(7, 2, 10, 10));
       setLocationRelativeTo(null);


       tfNama = new JTextField();
       tfNoHP = new JTextField();
       tfTanggal = new JTextField("yyyy-mm-dd");
       tfJamMulai = new JTextField("08:00");
       tfJamSelesai = new JTextField("09:00");

       String[] lapanganOptions = { "Lapangan 1", "Lapangan 2", "Lapangan 3", "Lapangan 4" };
       cbLapangan = new JComboBox<>(lapanganOptions);
       
              // Tombol CRUD
        saveButton = new JButton("Simpan");
        editButton = new JButton("Edit");           
        deleteButton = new JButton("Hapus");        
        
        
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));

        tableModel = new DefaultTableModel(new String[]{"Kode", "Nama", "Kategori", "Harga Jual", "Stok"}, 0);
        drinkTable = new JTable(tableModel);
        add(new JScrollPane(drinkTable), BorderLayout.CENTER); 

       JButton btnSubmit = new JButton("Simpan");
       btnSubmit.addActionListener(e -> {
        });


       add(new JLabel("Nama Penyewa:")); add(tfNama);
       add(new JLabel("No HP:")); add(tfNoHP);
       add(new JLabel("Tanggal Sewa:")); add(tfTanggal);
       add(new JLabel("Jam Mulai:")); add(tfJamMulai);
       add(new JLabel("Jam Selesai:")); add(tfJamSelesai);
       add(new JLabel("Lapangan:")); add(cbLapangan);
       add(btnSubmit); add(new JLabel());


         // CREATE
        saveButton.addActionListener(e -> {
            try {
                String tfnama = nameField.getText();
                String tfnoHp = noField.getText();
                String  tftanggalsewa= tanggalField.getText();
                String  tfJamMulai = jamulaiField.getText();
                String  tfJamselesai= jamselesaiField.getText();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid.");
            }
        });

        editButton.addActionListener(e -> {
            int row = drinkTable.getSelectedRow();
            if (row != -1) {
                try {
                String tfnama = nameField.getText();
                String tfnoHp = noField.getText();
                String  tftanggalsewa= tanggalField.getText();
                String  tfJamMulai = jamulaiField.getText();
                String  tfJamselesai= jamselesaiField.getText();
                    clearForm(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        // DELETE
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
                String tfnama = nameField.getText();
                String tfnoHp = noField.getText();
                String  tftanggalsewa= tanggalField.getText();
                String  tfJamMulai = jamulaiField.getText();
                String  tfJamselesai= jamselesaiField.getText();
            }
        });

       
        setVisible(true);                             
    }
     private void clearForm() {
        nameField.setText("");
        noField.setText("");
        tanggalField.setText("");;
        tanggalField.setText("");
        jamselesaiField.setText("");
    }

   }
   