package com.boye.threekings.component;

import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent {
    private static final long serialVersionUID = 1L;
    private final int boardSize;

    public BoardComponent(int boardSize) {
        super.setPreferredSize(new Dimension(boardSize, boardSize));
        super.setBounds(0, 0, boardSize, boardSize);
        this.boardSize = boardSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawLine(0, 0, boardSize, boardSize);
        g.drawLine(boardSize, 0, 0, boardSize);
        g.drawLine(boardSize / 2, 0, boardSize / 2, boardSize);
        g.drawLine(0, boardSize / 2, boardSize, boardSize / 2);
    }
}
