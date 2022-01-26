/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.ImageIcon;
import Classes.Boyfriend;

/**
 *
 * @author Asus
 */
public class ThemeSwapper extends javax.swing.JFrame {

    private final MainScreen mainScreen;
    Boyfriend player;

    /**
     * Creates new form ThemeSwopper
     *
     * @param m
     */
    public ThemeSwapper(MainScreen m) {
        initComponents();
        mainScreen = m;
        player = mainScreen.getPlayer();
    }

    private void checker() {
        switch (player.getTheme()) {
            case "normal":
                background.setIcon(new ImageIcon(getClass().getResource("/Icons/normal theme.png")));
                break;
            case "bathroom":
                background.setIcon(new ImageIcon(getClass().getResource("/Icons/bathroom.png")));
                break;
            case "libray":
                background.setIcon(new ImageIcon(getClass().getResource("/Icons/libray.png")));
                break;
            default:
                break;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        bathroom = new javax.swing.JButton();
        normal = new javax.swing.JButton();
        libray = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(null);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back);
        Back.setBounds(10, 560, 73, 23);

        bathroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bathroom icon.png"))); // NOI18N
        bathroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bathroomActionPerformed(evt);
            }
        });
        jPanel1.add(bathroom);
        bathroom.setBounds(400, 220, 260, 170);

        normal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/normal theme icon.png"))); // NOI18N
        normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalActionPerformed(evt);
            }
        });
        jPanel1.add(normal);
        normal.setBounds(400, 30, 260, 170);

        libray.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/libray icon.png"))); // NOI18N
        libray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                librayActionPerformed(evt);
            }
        });
        jPanel1.add(libray);
        libray.setBounds(400, 400, 260, 170);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/normal theme.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(-10, 0, 720, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       
        switch (player.getTheme()) {
            case "normal":
                mainScreen.background.setIcon(new ImageIcon(getClass().getResource("/Icons/normal theme.png")));
                mainScreen.left.setVisible(false);
                mainScreen.center.setVisible(true);
                mainScreen.right.setVisible(false);
                player.setPosition("center");
                break;
            case "bathroom":
                mainScreen.background.setIcon(new ImageIcon(getClass().getResource("/Icons/bathroom.png")));
                mainScreen.left.setVisible(true);
                mainScreen.center.setVisible(false);
                mainScreen.right.setVisible(false);
                mainScreen.player.setPosition("left");
                break;
            case "libray":
                mainScreen.background.setIcon(new ImageIcon(getClass().getResource("/Icons/libray.png")));
                mainScreen.left.setVisible(false);
                mainScreen.center.setVisible(false);
                mainScreen.right.setVisible(true);
                player.setPosition("right");
                break;
            default:
                break;
        }
        mainScreen.flag = true;
        mainScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void bathroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bathroomActionPerformed
        player.setTheme("bathroom");
        checker();
    }//GEN-LAST:event_bathroomActionPerformed

    private void normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalActionPerformed
        player.setTheme("normal");
        checker();
    }//GEN-LAST:event_normalActionPerformed

    private void librayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_librayActionPerformed
        player.setTheme("libray");
        checker();
    }//GEN-LAST:event_librayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel background;
    private javax.swing.JButton bathroom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton libray;
    private javax.swing.JButton normal;
    // End of variables declaration//GEN-END:variables
}