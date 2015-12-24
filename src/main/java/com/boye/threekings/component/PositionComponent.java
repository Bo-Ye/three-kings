package com.boye.threekings.component;

import com.boye.threekings.Controller;
import com.boye.threekings.PiecePosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PositionComponent extends JComponent implements MouseListener {
    private static final long serialVersionUID = 1L;
    private final PiecePosition piecePosition;

    public PositionComponent(int length, PiecePosition piecePosition) {
        this.piecePosition = piecePosition;
        super.setPreferredSize(new Dimension(length, length));
        super.setBounds(piecePosition.getXCoordinate(), piecePosition.getYCoordinate(), piecePosition.getWidth(), piecePosition.getHeight());
        super.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Controller.getInstance().positionClicked(e);
    }

    public PiecePosition getPiecePosition() {
        return this.piecePosition;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
