package com.boye.threekings.component;

import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent {

    private final int boardLength;

    private BoardComponent(int boardLength) {
        super.setBounds(0, 0, boardLength, boardLength);
        this.boardLength = boardLength;
    }
    
    public static BoardComponent createInstance(int boardLength){
        return new BoardComponent(boardLength);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, boardLength, boardLength);
        g.drawLine(boardLength, 0, 0, boardLength);
        g.drawLine(boardLength / 2, 0, boardLength / 2, boardLength);
        g.drawLine(0, boardLength / 2, boardLength, boardLength / 2);
    }
}
