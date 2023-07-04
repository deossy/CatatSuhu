package com.dessy.catatsuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        public class Login {
            public static void main(String[] args) {
                JFrame frame = new JFrame("Login");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // membuat panel login
                JPanel panel = new JPanel();
                JLabel userLabel = new JLabel("Nama Pengguna:");
                JTextField userText = new JTextField(20);
                JLabel passwordLabel = new JLabel("Kata Sandi:");
                JPasswordField passwordText = new JPasswordField(20);
                JButton loginButton = new JButton("Login");

                // menambahkan komponen ke dalam panel
                panel.add(userLabel);
                panel.add(userText);
                panel.add(passwordLabel);
                panel.add(passwordText);
                panel.add(loginButton);

                // menambahkan panel ke dalam frame
                frame.add(panel);

                // menampilkan frame
                frame.setVisible(true);

                // event listener untuk tombol login
                loginButton.addActionListener(e -> {
                    String username = userText.getText();
                    String password = new String(passwordText.getPassword());

                    // Memeriksa apakah pengguna berhasil login
                    if (username.equals("nama_pengguna") && password.equals("kata_sandi")) {
                        JLabel welcomeLabel = new JLabel("Selamat datang, " + username + "!");
                        panel.removeAll();
                        panel.add(welcomeLabel);
                        panel.revalidate();
                        panel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi salah.");
                    }
                });
            }
        }