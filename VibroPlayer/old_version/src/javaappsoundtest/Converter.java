/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaappsoundtest;

import com.synthbot.jasiohost.AsioDriver;
import com.synthbot.jasiohost.AsioDriverState;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author imdc
 */
public class Converter extends javax.swing.JFrame {

    static File channel1, channel2, channel3, channel4, channel5, channel6, channel7, channel8;
    
    public static AsioDriver driver;
    
    AsioSoundHost listener;
    
    private boolean[] playingChannel;
    
    /**
     * Creates new form NewJFrame
     */
    public Converter() {
        initComponents();
        
        driver = null;
        
        playingChannel = new boolean[8];
        
        for ( int i = 0; i < playingChannel.length; i++ ){
            playingChannel[i] = false;
        }
        
        /* to load config */
        BufferedReader reader;
        try {
            if ( new File ( "config.txt" ).exists() ) {
                reader = new BufferedReader ( new FileReader ( "config.txt" ) );

                String line = null;

                while ( ( line = reader.readLine() ) != null ) {
                    String split[] =  line.split ( ";" );

                    if ( split[0].equals ( "Audio Driver" ) ) {
                        driver = AsioDriver.getDriver( split[1] );
                    }
                }
                
                reader.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println ( ex );
        } catch (IOException ex) {
           System.out.println ( ex );
        }
        
                
        fileChannel1.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                System.out.println ( driver );
                channel1 = getFile ( evt, 1 );
                System.out.println ( channel1 );
            }
        });
        
        labelChannel1.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel1 = getFile ( evt, 1 );
                System.out.println ( channel1 );
            }
        });
        
        fileChannel2.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel2 = getFile ( evt, 2 );
                System.out.println ( channel2 );
            }
        });
        
        labelChannel2.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel2 = getFile ( evt, 2 );
               System.out.println ( channel2 );
           }
        });
        
        fileChannel3.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel3 = getFile ( evt, 3 );
                System.out.println ( channel3 );
            }
        });
        
        labelChannel3.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel3 = getFile ( evt, 3 );
               System.out.println ( channel3 );
           }
        });
        
        fileChannel4.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel4 = getFile ( evt, 4 );
                System.out.println ( channel4 );
            }
        });
        
        labelChannel4.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel4 = getFile ( evt, 4 );
               System.out.println ( channel4 );
           }
        });
        
        fileChannel5.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel5 = getFile ( evt, 5 );
                System.out.println ( channel5 );
            }
        });
        
        labelChannel5.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel5 = getFile ( evt, 5 );
               System.out.println ( channel5 );
           }
        });
        
        fileChannel6.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel6 = getFile ( evt, 6 );
                System.out.println ( channel6 );
            }
        });
        
        labelChannel6.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel6 = getFile ( evt, 6 );
               System.out.println ( channel6 );
           }
        });
        
        fileChannel7.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel7 = getFile ( evt, 7 );
                System.out.println ( channel7 );
            }
        });
        
        labelChannel7.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel7 = getFile ( evt, 7 );
               System.out.println ( channel7 );
           }
        });
        
        fileChannel8.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                channel8 = getFile ( evt, 8 );
                System.out.println ( channel8 );
            }
        });
        
        labelChannel8.addMouseListener ( new java.awt.event.MouseAdapter() {
           public void mouseClicked ( java.awt.event.MouseEvent evt ) {
               channel8 = getFile ( evt, 8 );
               System.out.println ( channel8 );
           }
        });
        
        controlPanelBtn.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                ControlPanel controlPanel = new ControlPanel();
                controlPanel.setVisible ( true );
            }
        });
        
        playChannel1.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 0 );
            }
        });
        
        playChannel2.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 1 );
            }
        });
        
        playChannel3.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 3 );
            }
        });
        
        playChannel4.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 2 );
            }
        });
        
        playChannel5.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 4 );
            }
        });
        
        playChannel6.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 5 );
            }
        });
        
        playChannel7.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 7 );
            }
        });
        
        playChannel8.addMouseListener ( new java.awt.event.MouseAdapter() {
            public void mouseClicked ( java.awt.event.MouseEvent evt ) {
                start ( 6 );
            }
        });
    }
    
    private void start ( int channel ) {
        if ( driver.getCurrentState() != AsioDriverState.RUNNING ) {
            listener = new AsioSoundHost ( driver );
            driver.start();
        }
        
        if ( playingChannel[channel] ) {
            listener.removeChannel ( channel );
            playingChannel[channel] = false;
        }
        else {
            listener.addChannel ( channel );
            playingChannel[channel] = true;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        fileChannel1 = new javax.swing.JTextField();
        labelChannel1 = new javax.swing.JLabel();
        fileChannel2 = new javax.swing.JTextField();
        labelChannel2 = new javax.swing.JLabel();
        fileChannel3 = new javax.swing.JTextField();
        labelChannel3 = new javax.swing.JLabel();
        fileChannel4 = new javax.swing.JTextField();
        labelChannel4 = new javax.swing.JLabel();
        fileChannel5 = new javax.swing.JTextField();
        labelChannel5 = new javax.swing.JLabel();
        fileChannel6 = new javax.swing.JTextField();
        labelChannel6 = new javax.swing.JLabel();
        fileChannel7 = new javax.swing.JTextField();
        labelChannel7 = new javax.swing.JLabel();
        fileChannel8 = new javax.swing.JTextField();
        labelChannel8 = new javax.swing.JLabel();
        controlPanelBtn = new javax.swing.JButton();
        playChannel1 = new javax.swing.JButton();
        playChannel2 = new javax.swing.JButton();
        playChannel3 = new javax.swing.JButton();
        playChannel4 = new javax.swing.JButton();
        playChannel5 = new javax.swing.JButton();
        playChannel6 = new javax.swing.JButton();
        playChannel7 = new javax.swing.JButton();
        playChannel8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Channel 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Channel 2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Channel 3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Channel 4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Channel 5");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Channel 6");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Channel 7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Channel 8");

        fileChannel1.setEditable(false);
        fileChannel1.setText("No file chosen");

        labelChannel1.setText("File:");

        fileChannel2.setEditable(false);
        fileChannel2.setText("No file chosen");

        labelChannel2.setText("File:");

        fileChannel3.setEditable(false);
        fileChannel3.setText("No file chosen");

        labelChannel3.setText("File:");

        fileChannel4.setEditable(false);
        fileChannel4.setText("No file chosen");

        labelChannel4.setText("File:");

        fileChannel5.setEditable(false);
        fileChannel5.setText("No file chosen");

        labelChannel5.setText("File:");

        fileChannel6.setEditable(false);
        fileChannel6.setText("No file chosen");

        labelChannel6.setText("File:");

        fileChannel7.setEditable(false);
        fileChannel7.setText("No file chosen");

        labelChannel7.setText("File:");

        fileChannel8.setEditable(false);
        fileChannel8.setText("No file chosen");

        labelChannel8.setText("File:");

        controlPanelBtn.setText("Control panel");

        playChannel1.setText("Play/Pause");

        playChannel2.setText("Play/Pause");

        playChannel3.setText("Play/Pause");

        playChannel4.setText("Play/Pause");

        playChannel5.setText("Play/Pause");

        playChannel6.setText("Play/Pause");

        playChannel7.setText("Play/Pause");

        playChannel8.setText("Play/Pause");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(controlPanelBtn)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel7, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel6))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel5))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel4))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(126, 126, 126)
                                            .addComponent(labelChannel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fileChannel8))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(playChannel1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(playChannel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playChannel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(0, 3, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator7)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChannel1)
                    .addComponent(playChannel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel2)
                        .addComponent(playChannel2))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel3)
                        .addComponent(playChannel3))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel4)
                        .addComponent(playChannel4))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel5)
                        .addComponent(playChannel5))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel6)
                        .addComponent(playChannel6))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel7)
                        .addComponent(playChannel7))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileChannel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelChannel8)
                        .addComponent(playChannel8))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(controlPanelBtn)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private File getFile ( java.awt.event.MouseEvent evt, int idChannel ) {
        JFileChooser fc = new JFileChooser();
        
        fc.setFileFilter ( new SoundsFilter() );

        
        int returnedValue = fc.showDialog ( rootPane, null );
        
        if ( returnedValue == JFileChooser.APPROVE_OPTION ) {
            File chosenFile = fc.getSelectedFile();
            
            if ( idChannel == 1 ) {
                fileChannel1.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 2 ) {
                fileChannel2.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 3 ) {
                fileChannel3.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 4 ) {
                fileChannel4.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 5 ) {
                fileChannel5.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 6 ) {
                fileChannel6.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 7 ) {
                fileChannel7.setText ( chosenFile.getPath() );
            }
            else if ( idChannel == 8 ) {
                fileChannel8.setText ( chosenFile.getPath() );
            }
            
            return chosenFile;
        }
        
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton controlPanelBtn;
    private javax.swing.JTextField fileChannel1;
    private javax.swing.JTextField fileChannel2;
    private javax.swing.JTextField fileChannel3;
    private javax.swing.JTextField fileChannel4;
    private javax.swing.JTextField fileChannel5;
    private javax.swing.JTextField fileChannel6;
    private javax.swing.JTextField fileChannel7;
    private javax.swing.JTextField fileChannel8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel labelChannel1;
    private javax.swing.JLabel labelChannel2;
    private javax.swing.JLabel labelChannel3;
    private javax.swing.JLabel labelChannel4;
    private javax.swing.JLabel labelChannel5;
    private javax.swing.JLabel labelChannel6;
    private javax.swing.JLabel labelChannel7;
    private javax.swing.JLabel labelChannel8;
    private javax.swing.JButton playChannel1;
    private javax.swing.JButton playChannel2;
    private javax.swing.JButton playChannel3;
    private javax.swing.JButton playChannel4;
    private javax.swing.JButton playChannel5;
    private javax.swing.JButton playChannel6;
    private javax.swing.JButton playChannel7;
    private javax.swing.JButton playChannel8;
    // End of variables declaration//GEN-END:variables

    private FileFilter NewFileFilter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
