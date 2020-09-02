package snake;

import javax.swing.JFrame;

public class MainPage extends javax.swing.JFrame {

    private void finish() {
        this.dispose();
    }

    MainPage() {
        initComponents();
        setSize(440, 400);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MainPage().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        startLevel1 = new javax.swing.JButton();
        startLevel4 = new javax.swing.JButton();
        startLevel2 = new javax.swing.JButton();
        startLevel3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(26, 188, 156));

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        jLabel1.setText("Snake Game");

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        startLevel1.setBackground(new java.awt.Color(26, 188, 156));
        startLevel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startLevel1.setText("start a game with level 1");
        startLevel1.setBorder(null);
        startLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLevel1ActionPerformed(evt);
            }
        });

        startLevel4.setBackground(new java.awt.Color(26, 188, 156));
        startLevel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startLevel4.setText("start a game with level 4");
        startLevel4.setBorder(null);
        startLevel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLevel4ActionPerformed(evt);
            }
        });

        startLevel2.setBackground(new java.awt.Color(26, 188, 156));
        startLevel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startLevel2.setText("start a game with level 2");
        startLevel2.setBorder(null);
        startLevel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLevel2ActionPerformed(evt);
            }
        });

        startLevel3.setBackground(new java.awt.Color(26, 188, 156));
        startLevel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startLevel3.setText("start a game with level 3");
        startLevel3.setBorder(null);
        startLevel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLevel3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startLevel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(startLevel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startLevel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startLevel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(startLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(startLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLevel1ActionPerformed
        GamePlay q = new GamePlay(1);
        finish();
    }//GEN-LAST:event_startLevel1ActionPerformed

    private void startLevel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLevel4ActionPerformed
        GamePlay q = new GamePlay(4);
        finish();

    }//GEN-LAST:event_startLevel4ActionPerformed

    private void startLevel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLevel2ActionPerformed
        GamePlay q = new GamePlay(2);
        finish();

    }//GEN-LAST:event_startLevel2ActionPerformed

    private void startLevel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLevel3ActionPerformed
        GamePlay q = new GamePlay(3);
        finish();

    }//GEN-LAST:event_startLevel3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startLevel1;
    private javax.swing.JButton startLevel2;
    private javax.swing.JButton startLevel3;
    private javax.swing.JButton startLevel4;
    // End of variables declaration//GEN-END:variables
}
