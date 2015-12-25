package com.boye.threekings;

import com.boye.threekings.component.BoardComponent;
import com.boye.threekings.component.PieceComponent;
import com.boye.threekings.component.PositionComponent;

import javax.swing.*;
import java.awt.*;

public class ThreeKings {

    private final JFrame threeKingsFrame;
    private final JLayeredPane layeredPane;

    public ThreeKings() {
        this.threeKingsFrame = new JFrame();
        this.layeredPane = new JLayeredPane();
    }

    private void initBoard() {
        // board
        BoardComponent boardComponent = BoardComponent.createInstance(Constants.BOARD_LENGTH);
        layeredPane.add(boardComponent, JLayeredPane.DEFAULT_LAYER);
    }

    private void initPositions() {
        // A1
        PositionComponent posA1 = PositionComponent.createInstance(PiecePosition.A1);
        layeredPane.add(posA1, JLayeredPane.PALETTE_LAYER);
        // A2
        PositionComponent posA2 = PositionComponent.createInstance(PiecePosition.A2);
        layeredPane.add(posA2, JLayeredPane.PALETTE_LAYER);
        // A2
        PositionComponent posA3 = PositionComponent.createInstance(PiecePosition.A3);
        layeredPane.add(posA3, JLayeredPane.PALETTE_LAYER);
        // B1
        PositionComponent posB1 = PositionComponent.createInstance(PiecePosition.B1);
        layeredPane.add(posB1, JLayeredPane.PALETTE_LAYER);
        // B2
        PositionComponent posB2 = PositionComponent.createInstance(PiecePosition.B2);
        layeredPane.add(posB2, JLayeredPane.PALETTE_LAYER);
        // B3
        PositionComponent posB3 = PositionComponent.createInstance(PiecePosition.B3);
        layeredPane.add(posB3, JLayeredPane.PALETTE_LAYER);
        // C1
        PositionComponent posC1 = PositionComponent.createInstance(PiecePosition.C1);
        layeredPane.add(posC1, JLayeredPane.PALETTE_LAYER);
        // C2
        PositionComponent posC2 = PositionComponent.createInstance(PiecePosition.C2);
        layeredPane.add(posC2, JLayeredPane.PALETTE_LAYER);
        // C3
        PositionComponent posC3 = PositionComponent.createInstance(PiecePosition.C3);
        layeredPane.add(posC3, JLayeredPane.PALETTE_LAYER);
    }

    private void initPieces() {
        // green kings
        PieceComponent greenKingOne = PieceComponent.createInstance(PiecePosition.C1, Constants.PIECE_DIAMETER, Color.GREEN);
        layeredPane.add(greenKingOne, JLayeredPane.DRAG_LAYER);
        PieceComponent greenKingTwo = PieceComponent.createInstance(PiecePosition.C2, Constants.PIECE_DIAMETER, Color.GREEN);
        layeredPane.add(greenKingTwo, JLayeredPane.DRAG_LAYER);
        PieceComponent greenKingThree = PieceComponent.createInstance(PiecePosition.C3, Constants.PIECE_DIAMETER, Color.GREEN);
        layeredPane.add(greenKingThree, JLayeredPane.DRAG_LAYER);
        // red kings
        PieceComponent redKingOne = PieceComponent.createInstance(PiecePosition.A1, Constants.PIECE_DIAMETER, Color.RED);
        layeredPane.add(redKingOne, JLayeredPane.DRAG_LAYER);
        PieceComponent redKingTwo = PieceComponent.createInstance(PiecePosition.A2, Constants.PIECE_DIAMETER, Color.RED);
        layeredPane.add(redKingTwo, JLayeredPane.DRAG_LAYER);
        PieceComponent redKingThree = PieceComponent.createInstance(PiecePosition.A3, Constants.PIECE_DIAMETER, Color.RED);
        layeredPane.add(redKingThree, JLayeredPane.DRAG_LAYER);
        //controller sets up kings.
        Controller.getInstance().setUp(new PieceComponent[]{greenKingOne, greenKingTwo, greenKingThree}, new PieceComponent[]{redKingOne, redKingTwo, redKingThree});
    }

    public void initialize() {
        layeredPane.setPreferredSize(new Dimension(Constants.BOARD_LENGTH, Constants.BOARD_LENGTH));
        initBoard();
        initPositions();
        initPieces();
        threeKingsFrame.setContentPane(layeredPane);
        threeKingsFrame.pack();
        threeKingsFrame.setLocationRelativeTo(null);
        threeKingsFrame.setResizable(false);
        threeKingsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ThreeKings().initialize();
    }
}
