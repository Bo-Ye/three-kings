package com.boye.threekings.component;

import com.boye.threekings.Controller;
import com.boye.threekings.PiecePosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceComponent extends JComponent implements MouseListener, ActionListener {

    private PiecePosition currentPosition;
    private final int diameter;
    private final Color color;
    private Timer flashTimer;

    private PieceComponent(PiecePosition piecePosition, int diameter, Color color) {
        moveTo(piecePosition);
        this.diameter = diameter;
        this.color = color;
    }

    public static PieceComponent createInstance(PiecePosition piecePosition, int diameter, Color color) {
        PieceComponent pieceComponent = new PieceComponent(piecePosition, diameter, color);
        pieceComponent.addMouseListener(pieceComponent);
        return pieceComponent;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, diameter, diameter);
    }

    public Color getColor() {
        return color;
    }

    public PiecePosition getPiecePosition() {
        return this.currentPosition;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Controller.getInstance().clickPiece((PieceComponent) e.getComponent());
    }

    //flashing effect
    public void select() {
        flashTimer = new Timer(500, this);
        flashTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.setVisible(!this.isVisible());
    }

    public void deSelect() {
        flashTimer.stop();
        this.setVisible(true);
    }

    //end
    //move piece
    public final void moveTo(PiecePosition piecePosition) {
        super.setBounds(piecePosition.getXCoordinate(), piecePosition.getYCoordinate(), piecePosition.getWidth(), piecePosition.getHeight());
        this.currentPosition = piecePosition;
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
