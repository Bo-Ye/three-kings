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
    private static final long serialVersionUID = 1L;
    private final int diameter;
    private final Color color;
    private PiecePosition currentPosition;
    private Timer flashTimer;

    public PieceComponent(int diameter, Color color, PiecePosition piecePosition) {
        this.color = color;
        this.diameter = diameter;
        super.setPreferredSize(new Dimension(diameter, diameter));
        moveTo(piecePosition);
        super.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, diameter, diameter);
    }

    public final void moveTo(PiecePosition piecePosition) {
        this.setBounds(piecePosition.getXCoordinate(), piecePosition.getYCoordinate(), piecePosition.getWidth(), piecePosition.getHeight());
        this.currentPosition = piecePosition;
    }

    public PiecePosition getPiecePosition() {
        return this.currentPosition;
    }

    public void select() {
        flashTimer = new Timer(500, this);
        flashTimer.start();
    }

    public void deSelect() {
        flashTimer.stop();
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Controller.getInstance().pieceClicked(e);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.setVisible(!this.isVisible());
    }

    public Color getColor() {
        return color;
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
