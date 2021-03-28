package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public ControlPanel(Game game){

        JPanel s1 = new JPanel();
        JLabel s1Label = new JLabel("Main Menu");
        s1.setBackground(Color.cyan);
        JButton s1DropdownButton = new JButton("Menu1");
        s1DropdownButton.setBackground(Color.cyan);
        JPanel s1Contents = new JPanel();
        s1Contents.setBackground(Color.cyan);
        JButton s1ButtonPause = new JButton("Pause");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s1ButtonResume = new JButton("Resume");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s1ButtonRestart = new JButton("Restart");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s1ButtonQuit = new JButton("Quit");
        s1ButtonPause.setBackground(Color.YELLOW);
        revalidate();

        s1ButtonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });
        s1ButtonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resume();
            }
        });
        s1ButtonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });
        s1ButtonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(s1);

        s1.setLayout(new BoxLayout(s1, BoxLayout.Y_AXIS));
        s1.add(s1DropdownButton);
        s1.add(s1Contents);

        s1Contents.setLayout(new BoxLayout(s1Contents, BoxLayout.Y_AXIS));
        s1Contents.add(s1Label);
        s1Contents.add(s1ButtonPause);
        s1Contents.add(s1ButtonResume);
        s1Contents.add(s1ButtonRestart);
        s1Contents.add(s1ButtonQuit);

        s1DropdownButton.addActionListener(new ActionListener() {
            private boolean visible = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (visible) {
                    s1.remove(s1Contents);
                    visible = false;
                    revalidate();
                } else {
                    s1.add(s1Contents);
                    visible = true;
                    revalidate();
                }

            }
        });

        JPanel s2 = new JPanel();
        JLabel s2Label = new JLabel("Levels Menu");
        s1.setBackground(Color.cyan);
        JButton s2DropdownButton = new JButton("Menu2");
        s1DropdownButton.setBackground(Color.cyan);
        JPanel s2Contents = new JPanel();
        s1Contents.setBackground(Color.cyan);
        JButton s2ButtonLevel1 = new JButton("Level1");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s2ButtonLevel2 = new JButton("Level2");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s2ButtonLevel3 = new JButton("Level3");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s2ButtonLevel4 = new JButton("Level4");
        s1ButtonPause.setBackground(Color.YELLOW);
        JButton s2ButtonLevel5 = new JButton("Level5");
        s1ButtonPause.setBackground(Color.YELLOW);
        revalidate();

        s2ButtonLevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startLevel1();
            }
        });
        s2ButtonLevel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startLevel2();
            }
        });
        s2ButtonLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startLevel3();
            }
        });
        s2ButtonLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startLevel4();
            }
        });
        s2ButtonLevel5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startLevel5();
            }
        });

        s2Contents.add(s2Label);
        s2Contents.add(s2ButtonLevel1);
        s2Contents.add(s2ButtonLevel2);
        s2Contents.add(s2ButtonLevel3);
        s2Contents.add(s2ButtonLevel4);
        s2Contents.add(s2ButtonLevel5);


    }


}



