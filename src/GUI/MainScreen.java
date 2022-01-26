/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import Classes.Boyfriend;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sun.audio.*;

/**
 *
 * @author Asus
 */
public class MainScreen extends javax.swing.JFrame {
    
    private TitleScreen titleScreen;
    private ThemeSwapper themeswapper;
    private ClotheSwapper clotheSwapper;
    private MazeGame mazeGame;
    Boyfriend player;
    String name, shirt, theme, position;
    int food, sleep, fun, attention, seconds = 0, yoyoCounter = 10, danceCounter = 0, press = 0, clicks;
    ;
    boolean flag = true, flag2 = false, flag3 = false;
    public Timer timer = new Timer();
    public TimerTask time = new TimerTask() {
        
        @Override
        public void run() {
            
            
            if (flag == true) {
                seconds++;
                
                stats();
                
                if (seconds == 10) {
                    seconds = 0;
                }
            }
        }
    };
    public TimerTask yoyo = new TimerTask() {
        
        @Override
        public void run() {
            int position = 0;
            double placeHolder;
            
            if (flag2 == true) {
                
                switch (player.getPosition()) {
                    case "left":
                        position = 1;
                        yoyoLeft.setVisible(true);
                        break;
                    case "center":
                        position = 2;
                        yoyoCenter.setVisible(true);
                        break;
                    case "right":
                        position = 3;
                        yoyoRight.setVisible(true);
                        break;
                    default:
                        break;
                }
                
                if (yoyoCounter > 0) {
                    yoyoCounter--;
                    placeHolder = yoyoCounter % 2;
                    
                    if (placeHolder != 0) {
                        switch (position) {
                            case 1:
                                yoyoLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo up.png")));
                                break;
                            case 2:
                                yoyoCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo up.png")));
                                break;
                            case 3:
                                yoyoRight.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo up.png")));
                                break;
                            default:
                                break;
                        }
                        
                    } else if (placeHolder == 0) {
                        switch (position) {
                            case 1:
                                yoyoLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo down.png")));
                                yoyoSound();
                                break;
                            case 2:
                                yoyoCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo down.png")));
                                yoyoSound();
                                break;
                            case 3:
                                yoyoRight.setIcon(new ImageIcon(getClass().getResource("/Icons/yoyo down.png")));
                                yoyoSound();
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("a");
                    }
                }
                
                if (yoyoCounter == 0) {
                    switch (position) {
                        case 1:
                            yoyoLeft.setVisible(false);
                            break;
                        case 2:
                            yoyoCenter.setVisible(false);
                            break;
                        case 3:
                            yoyoRight.setVisible(false);
                            break;
                        default:
                            break;
                    }
                    yoyoCounter = 10;
                    flag2 = false;
                }
                
            }
        }
    };
    public TimerTask dance = new TimerTask() {
        
        @Override
        public void run() {
            int position = 0, shirt = 0;
            double placeHolder;
            
            if (flag3 == true) {
                
                switch (player.getPosition()) {
                    case "left":
                        position = 1;
                        danceLeft.setVisible(true);
                        left.setVisible(false);
                        break;
                    case "center":
                        position = 2;
                        danceCenter.setVisible(true);
                        center.setVisible(false);
                        break;
                    case "right":
                        position = 3;
                        danceRight.setVisible(true);
                        right.setVisible(false);
                        break;
                    default:
                        break;
                }
                
                switch (player.getShirt()) {
                    case "striped":
                        shirt = 1;
                        break;
                    case "orange":
                        shirt = 2;
                        break;
                    case "walkingdead":
                        shirt = 3;
                        break;
                    default:
                        break;
                }
                
                if (danceCounter > 0) {
                    danceCounter--;
                    placeHolder = danceCounter % 2;
                    
                    System.out.println(danceCounter);
                    
                    if (placeHolder != 0) {
                        
                        if (position == 1 && shirt == 1) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedLeft.png")));
                        } else if (position == 1 && shirt == 2) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeLeft.png")));
                        } else if (position == 1 && shirt == 3) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadLeft.png")));
                        } else if (position == 2 && shirt == 1) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedLeft.png")));
                        } else if (position == 2 && shirt == 2) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeLeft.png")));
                        } else if (position == 2 && shirt == 3) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadLeft.png")));
                        } else if (position == 3 && shirt == 1) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedLeft.png")));
                        } else if (position == 3 && shirt == 2) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeLeft.png")));
                        } else if (position == 3 && shirt == 3) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadLeft.png")));
                        }
                        
                    } else if (placeHolder == 0) {
                        if (position == 1 && shirt == 1) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedRight.png")));
                        } else if (position == 1 && shirt == 2) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeRight.png")));
                        } else if (position == 1 && shirt == 3) {
                            
                            danceLeft.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadRight.png")));
                        } else if (position == 2 && shirt == 1) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedRight.png")));
                        } else if (position == 2 && shirt == 2) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeRight.png")));
                        } else if (position == 2 && shirt == 3) {
                            
                            danceCenter.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadRight.png")));
                        } else if (position == 3 && shirt == 1) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/stripedRight.png")));
                        } else if (position == 3 && shirt == 2) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/orangeRight.png")));
                        } else if (position == 3 && shirt == 3) {
                            
                            danceRight.setIcon(new ImageIcon(getClass().getResource("/Icons/walkingdeadRight.png")));
                        }
                    } else {
                        System.out.println("a");
                    }
                }
                
                if (danceCounter == 0) {
                    switch (position) {
                        case 1:
                            danceLeft.setVisible(false);
                            left.setVisible(true);
                            break;
                        case 2:
                            danceCenter.setVisible(false);
                            center.setVisible(true);
                            break;
                        case 3:
                            danceRight.setVisible(false);
                            right.setVisible(true);
                            break;
                        default:
                    }
                    danceCounter = 10;
                    flag3 = false;
                }
                
            }
        }
    };

    /**
     * Creates new form MainScreen
     *
     * @param t
     */
    public MainScreen(TitleScreen t) {
        initComponents();
        titleScreen = t;
        player = titleScreen.getPlayer();
        name = player.getName();
        shirt = player.getShirt();
        theme = player.getTheme();
        position = player.getPosition();
        food = player.getFood();
        sleep = player.getSleep();
        fun = player.getFun();
        attention = player.getAttention();
        timer.scheduleAtFixedRate(time, 1000, 1000);
        timer.scheduleAtFixedRate(yoyo, 1000, 400);
        timer.scheduleAtFixedRate(dance, 1000, 500);
        foodBar.setForeground(Color.red);
        foodBar.setValue(food);
        sleepBar.setForeground(Color.gray);
        sleepBar.setValue(sleep);
        funBar.setForeground(Color.blue);
        funBar.setValue(fun);
        attentionBar.setForeground(Color.green);
        attentionBar.setValue(attention);
        startUp();
    }
    
    
    private void startUp() {
        switch (player.getPosition()) {
            case "left":
                center.setVisible(false);
                right.setVisible(false);
                break;
            case "center":
                left.setVisible(false);
                right.setVisible(false);
                break;
            case "right":
                center.setVisible(false);
                right.setVisible(false);
                break;
            default:
                break;
        }
        
        yoyoLeft.setVisible(false);
        yoyoCenter.setVisible(false);
        yoyoRight.setVisible(false);
        danceLeft.setVisible(false);
        danceCenter.setVisible(false);
        danceRight.setVisible(false);
        hiden2.setVisible(false);
    }
    
    private void yoyoSound() {
        InputStream yoyo;
        try {
            yoyo = new FileInputStream(new File("src//audio//yoyo.wav"));
            AudioStream audios = new AudioStream(yoyo);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Boyfriend getPlayer() {
        return player;
    }
    
    private void stats() {
        
        if (seconds == 2 || seconds == 4 || seconds == 6 || seconds == 8 || seconds == 10) {
            food = food - 1;
            foodBar.setValue(food);
        }
        if (seconds == 5 || seconds == 10) {
            sleep = sleep - 1;
            sleepBar.setValue(sleep);
        }
        if (seconds == 2 || seconds == 6 || seconds == 10) {
            fun = fun - 1;
            funBar.setValue(fun);
        }
        if (seconds <= 10) {
            attention = attention - 1;
            attentionBar.setValue(attention);
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
        funLabel = new javax.swing.JLabel();
        foodLabel = new javax.swing.JLabel();
        sleepLable = new javax.swing.JLabel();
        attentionLabel = new javax.swing.JLabel();
        clothesButton = new javax.swing.JButton();
        themeButton = new javax.swing.JButton();
        foodBar = new javax.swing.JProgressBar();
        hiden2 = new javax.swing.JButton();
        hiden1 = new javax.swing.JButton();
        sleepBar = new javax.swing.JProgressBar();
        funBar = new javax.swing.JProgressBar();
        attentionBar = new javax.swing.JProgressBar();
        clickHere = new javax.swing.JButton();
        foodButton = new javax.swing.JButton();
        sleepButton = new javax.swing.JButton();
        gameButton = new javax.swing.JButton();
        danceButton = new javax.swing.JButton();
        yoyoButton = new javax.swing.JButton();
        jokeButton = new javax.swing.JButton();
        petButton = new javax.swing.JButton();
        putAway = new javax.swing.JButton();
        danceCenter = new javax.swing.JLabel();
        yoyoCenter = new javax.swing.JLabel();
        center = new javax.swing.JLabel();
        danceRight = new javax.swing.JLabel();
        yoyoRight = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        danceLeft = new javax.swing.JLabel();
        yoyoLeft = new javax.swing.JLabel();
        left = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(null);

        funLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        funLabel.setForeground(new java.awt.Color(255, 255, 255));
        funLabel.setText("FUN");
        jPanel1.add(funLabel);
        funLabel.setBounds(10, 120, 90, 14);

        foodLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        foodLabel.setForeground(new java.awt.Color(255, 255, 255));
        foodLabel.setText("FOOD");
        jPanel1.add(foodLabel);
        foodLabel.setBounds(10, 0, 60, 14);

        sleepLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sleepLable.setForeground(new java.awt.Color(255, 255, 255));
        sleepLable.setText("SLEEP");
        jPanel1.add(sleepLable);
        sleepLable.setBounds(10, 40, 60, 14);

        attentionLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attentionLabel.setForeground(new java.awt.Color(255, 255, 255));
        attentionLabel.setText("ATTENTION");
        jPanel1.add(attentionLabel);
        attentionLabel.setBounds(10, 80, 90, 14);

        clothesButton.setText("Clothes");
        clothesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clothesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(clothesButton);
        clothesButton.setBounds(220, 530, 90, 20);

        themeButton.setText("Theme");
        themeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(themeButton);
        themeButton.setBounds(340, 530, 90, 23);

        foodBar.setBackground(new java.awt.Color(255, 255, 255));
        foodBar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        foodBar.setStringPainted(true);
        jPanel1.add(foodBar);
        foodBar.setBounds(10, 20, 210, 20);

        hiden2.setBackground(new java.awt.Color(79, 205, 255));
        hiden2.setForeground(new java.awt.Color(79, 205, 255));
        hiden2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiden2ActionPerformed(evt);
            }
        });
        jPanel1.add(hiden2);
        hiden2.setBounds(620, 390, 60, 20);

        hiden1.setBackground(new java.awt.Color(79, 205, 255));
        hiden1.setForeground(new java.awt.Color(79, 205, 255));
        hiden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiden1ActionPerformed(evt);
            }
        });
        jPanel1.add(hiden1);
        hiden1.setBounds(350, 160, 70, 20);

        sleepBar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        sleepBar.setStringPainted(true);
        jPanel1.add(sleepBar);
        sleepBar.setBounds(10, 60, 210, 20);

        funBar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        funBar.setStringPainted(true);
        jPanel1.add(funBar);
        funBar.setBounds(10, 140, 210, 20);

        attentionBar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        attentionBar.setStringPainted(true);
        jPanel1.add(attentionBar);
        attentionBar.setBounds(10, 100, 210, 20);

        clickHere.setText("Click Here");
        clickHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickHereActionPerformed(evt);
            }
        });
        jPanel1.add(clickHere);
        clickHere.setBounds(550, 450, 120, 23);

        foodButton.setText("Fed");
        foodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodButtonActionPerformed(evt);
            }
        });
        jPanel1.add(foodButton);
        foodButton.setBounds(130, 530, 70, 23);

        sleepButton.setText("Sleep");
        sleepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleepButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sleepButton);
        sleepButton.setBounds(50, 530, 70, 23);

        gameButton.setText("Game");
        gameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gameButton);
        gameButton.setBounds(460, 530, 90, 23);

        danceButton.setText("Dance");
        danceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danceButtonActionPerformed(evt);
            }
        });
        jPanel1.add(danceButton);
        danceButton.setBounds(580, 490, 90, 23);

        yoyoButton.setText("Yo-Yo");
        yoyoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yoyoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(yoyoButton);
        yoyoButton.setBounds(580, 530, 90, 23);

        jokeButton.setText("Joke");
        jokeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jokeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jokeButton);
        jokeButton.setBounds(460, 490, 90, 23);

        petButton.setText("Pet");
        petButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petButtonActionPerformed(evt);
            }
        });
        jPanel1.add(petButton);
        petButton.setBounds(50, 500, 70, 23);

        putAway.setText("Put Away");
        putAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                putAwayActionPerformed(evt);
            }
        });
        jPanel1.add(putAway);
        putAway.setBounds(550, 30, 110, 23);

        danceCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/stripedLeft.png"))); // NOI18N
        jPanel1.add(danceCenter);
        danceCenter.setBounds(290, 340, 100, 160);

        yoyoCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/yoyo down.png"))); // NOI18N
        yoyoCenter.setPreferredSize(new java.awt.Dimension(80, 150));
        jPanel1.add(yoyoCenter);
        yoyoCenter.setBounds(290, 330, 100, 190);

        center.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/striped.png"))); // NOI18N
        center.setPreferredSize(new java.awt.Dimension(80, 150));
        jPanel1.add(center);
        center.setBounds(290, 330, 100, 190);

        danceRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/stripedLeft.png"))); // NOI18N
        jPanel1.add(danceRight);
        danceRight.setBounds(400, 350, 110, 150);

        yoyoRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/yoyo down.png"))); // NOI18N
        yoyoRight.setToolTipText("");
        jPanel1.add(yoyoRight);
        yoyoRight.setBounds(400, 340, 110, 180);

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/striped.png"))); // NOI18N
        right.setToolTipText("");
        jPanel1.add(right);
        right.setBounds(400, 340, 110, 180);

        danceLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/stripedLeft.png"))); // NOI18N
        jPanel1.add(danceLeft);
        danceLeft.setBounds(100, 350, 120, 160);

        yoyoLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/yoyo up.png"))); // NOI18N
        jPanel1.add(yoyoLeft);
        yoyoLeft.setBounds(100, 350, 110, 150);

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/striped.png"))); // NOI18N
        jPanel1.add(left);
        left.setBounds(100, 350, 110, 150);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/normal theme.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 700, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeButtonActionPerformed
        
        flag = false;
        if (themeswapper == null) {
            themeswapper = new ThemeSwapper(this);
        }
        themeswapper.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_themeButtonActionPerformed

    private void clothesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clothesButtonActionPerformed
        
        flag = false;
        if (clotheSwapper == null) {
            clotheSwapper = new ClotheSwapper(this);
        }
        clotheSwapper.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_clothesButtonActionPerformed

    private void jokeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jokeButtonActionPerformed
        
        int jokePicker;
        
        jokePicker = (int) (Math.random() * 15 + 1);
        
        JOptionPane.showMessageDialog(null, "Button broken");
        

    }//GEN-LAST:event_jokeButtonActionPerformed

    private void danceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danceButtonActionPerformed
        
        int songPicker = (int) (Math.random() * 3 + 1), random = (int) (Math.random() * fun + 1);
        
        fun = fun + random;
        
        if (fun != 100) {
            fun = 100;
        }
        funBar.setValue(fun);
        
        switch (songPicker) {
            case 1:
                danceCounter = 28;
                InputStream music;
                try {
                    music = new FileInputStream(new File("src//audio//yumYum.wav"));
                    AudioStream b = new AudioStream(music);
                    AudioPlayer.player.start(b);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                danceCounter = 27;
                InputStream music1;
                try {
                    music1 = new FileInputStream(new File("src//audio//boogie.wav"));
                    AudioStream b = new AudioStream(music1);
                    AudioPlayer.player.start(b);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 3:
                danceCounter = 29;
                InputStream music2;
                try {
                    music2 = new FileInputStream(new File("src//audio//pancake.wav"));
                    AudioStream b = new AudioStream(music2);
                    AudioPlayer.player.start(b);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            default:
                break;
        }
        
        flag3 = true;
        

    }//GEN-LAST:event_danceButtonActionPerformed

    private void gameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameButtonActionPerformed
        
        JOptionPane.showMessageDialog(null, "Button broken");
        //timer.cancel();
        
        //if (mazeGame == null) {
       //     mazeGame = new MazeGame(this);
       // }
       // mazeGame.setVisible(true);
       // this.setVisible(false);
    }//GEN-LAST:event_gameButtonActionPerformed

    private void petButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petButtonActionPerformed
        int random = (int) (Math.random() * attention + 1);
        
        attention = attention + random;
        
        if (attention != 100) {
            attention = 100;
        }
        attentionBar.setValue(attention);
        

    }//GEN-LAST:event_petButtonActionPerformed

    private void foodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodButtonActionPerformed
        int random = (int) (Math.random() * food + 1);
        
        food = food + random;
        
        if (food != 100) {
            food = 100;
        }
        foodBar.setValue(food);
        

    }//GEN-LAST:event_foodButtonActionPerformed

    private void sleepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sleepButtonActionPerformed
        int random = (int) (Math.random() * sleep + 1);
        
        sleep = sleep + random;
        
        if (sleep != 100) {
            sleep = 100;
        }
        sleepBar.setValue(sleep);
        

    }//GEN-LAST:event_sleepButtonActionPerformed

    private void yoyoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yoyoButtonActionPerformed
        int random = (int) (Math.random() * fun + 1);
        
        flag2 = true;
        fun = fun + random;
        
        if (fun != 100) {
            fun = 100;
        }
        funBar.setValue(fun);
    }//GEN-LAST:event_yoyoButtonActionPerformed

    private void putAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_putAwayActionPerformed
        
        
        
       // player = new Boyfriend(shirt, theme, position, name, fun, attention, food, sleep);
       // try {
         //   FileWriter fw = new FileWriter("src//DataFiles//SaveFile.txt");
         //   BufferedWriter bw = new BufferedWriter(fw);
            
         //   bw.write(shirt + "\n" + theme + "\n" + position + "\n" + name + "\n" + fun + "\n" + attention + "\n" + food + "\n" + sleep);
         //   bw.close();
            
        //    System.out.println("saved");
      //  } catch (IOException e) {
            
       //     System.out.println(e);
      //  }
        
        System.exit(0);
    }//GEN-LAST:event_putAwayActionPerformed

    private void hiden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiden1ActionPerformed
        
        press++;
        
        switch (press) {
            case 1:
                JOptionPane.showMessageDialog(null, "Don't press me");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "STOP IT!!!!!!!!");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "I'm moving");
                hiden1.setVisible(false);
                hiden2.setVisible(true);
                break;
            default:
                break;
        }

    }//GEN-LAST:event_hiden1ActionPerformed

    private void hiden2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiden2ActionPerformed
        
        press++;
        
        switch (press) {
            case 4:
                JOptionPane.showMessageDialog(null, "How did you find me");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Press me one more time");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "I DARE YOU ONE MORE TIME!!!");
                break;
            case 7:
                System.exit(0);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_hiden2ActionPerformed

    private void clickHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickHereActionPerformed
        
        clicks++;
        
        if(clicks == 5){
            JOptionPane.showMessageDialog(null, "This button does nothing\nStop hitting it");
        } else if (clicks == 6){
            clickHere.setVisible(false);
        }
    }//GEN-LAST:event_clickHereActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar attentionBar;
    private javax.swing.JLabel attentionLabel;
    public javax.swing.JLabel background;
    public javax.swing.JLabel center;
    private javax.swing.JButton clickHere;
    private javax.swing.JButton clothesButton;
    private javax.swing.JButton danceButton;
    private javax.swing.JLabel danceCenter;
    private javax.swing.JLabel danceLeft;
    private javax.swing.JLabel danceRight;
    private javax.swing.JProgressBar foodBar;
    private javax.swing.JButton foodButton;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JProgressBar funBar;
    private javax.swing.JLabel funLabel;
    private javax.swing.JButton gameButton;
    private javax.swing.JButton hiden1;
    private javax.swing.JButton hiden2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jokeButton;
    public javax.swing.JLabel left;
    private javax.swing.JButton petButton;
    private javax.swing.JButton putAway;
    public javax.swing.JLabel right;
    private javax.swing.JProgressBar sleepBar;
    private javax.swing.JButton sleepButton;
    private javax.swing.JLabel sleepLable;
    private javax.swing.JButton themeButton;
    private javax.swing.JButton yoyoButton;
    public javax.swing.JLabel yoyoCenter;
    public javax.swing.JLabel yoyoLeft;
    public javax.swing.JLabel yoyoRight;
    // End of variables declaration//GEN-END:variables
}
