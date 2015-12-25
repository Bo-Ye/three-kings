package com.boye.threekings.component;

import com.boye.threekings.Controller;
import com.boye.threekings.PiecePosition;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PositionComponent extends JComponent implements MouseListener {

    private final PiecePosition piecePosition;

    private PositionComponent(PiecePosition piecePosition) {
        super.setBounds(piecePosition.getXCoordinate(), piecePosition.getYCoordinate(), piecePosition.getWidth(), piecePosition.getHeight());
        this.piecePosition = piecePosition;
    }

    public static PositionComponent createInstance(PiecePosition piecePosition) {
        PositionComponent instance = new PositionComponent(piecePosition);
        instance.addMouseListener(instance);
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Controller.getInstance().clickPosition((PositionComponent) e.getComponent());
    }

    public PiecePosition getPiecePosition() {
        return this.piecePosition;
    }

    //empty events
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
