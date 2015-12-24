package com.boye.threekings;

import com.boye.threekings.component.BoardComponent;
import com.boye.threekings.component.PieceComponent;
import com.boye.threekings.component.PositionComponent;

import javax.swing.*;
import java.awt.*;

public class ThreeKings {


    private final JFrame lineThreeFrame;
    private final JLayeredPane layeredPane;

    public ThreeKings() {
        this.lineThreeFrame = new JFrame();
        this.layeredPane = new JLayeredPane();
    }

    public static void main(String[] args) {
        new ThreeKings().initialize();
    }

    private void initBoard() {
        // board
        BoardComponent boardComponent = new BoardComponent(Constants.BOARD_SIDE);
        layeredPane.add(boardComponent, JLayeredPane.DEFAULT_LAYER);
    }

    private void initPositions() {
        // A1
        PositionComponent posA1 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.A1);
        layeredPane.add(posA1, JLayeredPane.PALETTE_LAYER);
        // A2
        PositionComponent posA2 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.A2);
        layeredPane.add(posA2, JLayeredPane.PALETTE_LAYER);
        // A2
        PositionComponent posA3 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.A3);
        layeredPane.add(posA3, JLayeredPane.PALETTE_LAYER);
        // B1
        PositionComponent posB1 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.B1);
        layeredPane.add(posB1, JLayeredPane.PALETTE_LAYER);
        // B2
        PositionComponent posB2 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.B2);
        layeredPane.add(posB2, JLayeredPane.PALETTE_LAYER);
        // B3
        PositionComponent posB3 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.B3);
        layeredPane.add(posB3, JLayeredPane.PALETTE_LAYER);
        // C1
        PositionComponent posC1 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.C1);
        layeredPane.add(posC1, JLayeredPane.PALETTE_LAYER);
        // C2
        PositionComponent posC2 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.C2);
        layeredPane.add(posC2, JLayeredPane.PALETTE_LAYER);
        // C3
        PositionComponent posC3 = new PositionComponent(Constants.PIECE_DIAMETER, PiecePosition.C3);
        layeredPane.add(posC3, JLayeredPane.PALETTE_LAYER);
    }

    private void initPieces() {
        // piece red player
        PieceComponent pieceRedOne = new PieceComponent(Constants.PIECE_DIAMETER, Color.RED, PiecePosition.A1);
        layeredPane.add(pieceRedOne, JLayeredPane.DRAG_LAYER);

        PieceComponent pieceRedTwo = new PieceComponent(Constants.PIECE_DIAMETER, Color.RED, PiecePosition.A2);
        layeredPane.add(pieceRedTwo, JLayeredPane.DRAG_LAYER);

        PieceComponent pieceRedThree = new PieceComponent(Constants.PIECE_DIAMETER, Color.RED, PiecePosition.A3);
        layeredPane.add(pieceRedThree, JLayeredPane.DRAG_LAYER);
        // piece green player
        PieceComponent pieceGreenOne = new PieceComponent(Constants.PIECE_DIAMETER, Color.GREEN, PiecePosition.C1);
        layeredPane.add(pieceGreenOne, JLayeredPane.DRAG_LAYER);

        PieceComponent pieceGreenTwo = new PieceComponent(Constants.PIECE_DIAMETER, Color.GREEN, PiecePosition.C2);
        layeredPane.add(pieceGreenTwo, JLayeredPane.DRAG_LAYER);

        PieceComponent pieceGreenThree = new PieceComponent(Constants.PIECE_DIAMETER, Color.GREEN, PiecePosition.C3);
        layeredPane.add(pieceGreenThree, JLayeredPane.DRAG_LAYER);
    }

    public void initialize() {
        layeredPane.setPreferredSize(new Dimension(Constants.BOARD_SIDE, Constants.BOARD_SIDE));
        initBoard();
        initPositions();
        initPieces();
        Controller.getInstance().initialize();
        lineThreeFrame.setContentPane(layeredPane);
        lineThreeFrame.pack();
        lineThreeFrame.setResizable(false);
        lineThreeFrame.setVisible(true);
    }
}
