
package com.mycompany.padelrentalform;

import java.awt.*;
import javax.swing.*;
 

public class PadelRentalForm extends JFrame {
   private JTextField tfNama, tfNoHP, tfTanggal, tfJamMulai, tfJamSelesai;
   private JComboBox<String> cbLapangan;
   
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

       JButton btnSubmit = new JButton("Simpan");

       add(new JLabel("Nama Penyewa:")); add(tfNama);
       add(new JLabel("No HP:")); add(tfNoHP);
       add(new JLabel("Tanggal Sewa:")); add(tfTanggal);
       add(new JLabel("Jam Mulai:")); add(tfJamMulai);
       add(new JLabel("Jam Selesai:")); add(tfJamSelesai);
       add(new JLabel("Lapangan:")); add(cbLapangan);
       add(btnSubmit); add(new JLabel());
   }

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PadelRentalForm().setVisible(true));
   }
}