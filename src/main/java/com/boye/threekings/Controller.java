package com.boye.threekings;

import com.boye.threekings.component.PieceComponent;
import com.boye.threekings.component.PositionComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static Controller controller = null;
    private Controller() {
    }

    public synchronized static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    // /for connectivity between positions
    private static final Map<PiecePosition, PiecePosition[]> POSITION_MOVABLES = new HashMap<>();

    // /for status
    private Color currentPlayer = null;
    private PieceComponent currentSelected = null;



    public void initialize() {
        this.currentPlayer = Color.GREEN;
        this.currentSelected = null;
        POSITION_MOVABLES.put(PiecePosition.A1, new PiecePosition[]{PiecePosition.A2, PiecePosition.B1, PiecePosition.B2});
        POSITION_MOVABLES.put(PiecePosition.A2, new PiecePosition[]{PiecePosition.A1, PiecePosition.A3, PiecePosition.B2});
        POSITION_MOVABLES.put(PiecePosition.A3, new PiecePosition[]{PiecePosition.A2, PiecePosition.B2, PiecePosition.B3});
        POSITION_MOVABLES.put(PiecePosition.B1, new PiecePosition[]{PiecePosition.A1, PiecePosition.B2, PiecePosition.C1});
        POSITION_MOVABLES.put(PiecePosition.B2, new PiecePosition[]{PiecePosition.A1, PiecePosition.A2, PiecePosition.A3, PiecePosition.B1, PiecePosition.B3, PiecePosition.C1,
                PiecePosition.C2, PiecePosition.C3});
        POSITION_MOVABLES.put(PiecePosition.B3, new PiecePosition[]{PiecePosition.A3, PiecePosition.B2, PiecePosition.C3});
        POSITION_MOVABLES.put(PiecePosition.C1, new PiecePosition[]{PiecePosition.B1, PiecePosition.B2, PiecePosition.C2});
        POSITION_MOVABLES.put(PiecePosition.C2, new PiecePosition[]{PiecePosition.B2, PiecePosition.C1, PiecePosition.C3});
        POSITION_MOVABLES.put(PiecePosition.C3, new PiecePosition[]{PiecePosition.B2, PiecePosition.B3, PiecePosition.C2});
    }

    public void pieceClicked(MouseEvent e) {
        PieceComponent pieceComponent = (PieceComponent) e.getComponent();
        Color selectedColor = pieceComponent.getColor();
        if (selectedColor.equals(currentPlayer)) {
            if (currentSelected != null) {
                currentSelected.deSelect();
            }
            pieceComponent.select();
            currentSelected = pieceComponent;
        }
    }

    private boolean isMovable(PiecePosition from, PiecePosition to) {
        PiecePosition[] movables = POSITION_MOVABLES.get(from);
        return Arrays.binarySearch(movables, to) > -1;
    }

    private void changePlayer() {
        currentSelected.deSelect();
        currentSelected = null;
        if (currentPlayer.equals(Color.GREEN)) {
            currentPlayer = Color.RED;
        } else {
            currentPlayer = Color.GREEN;
        }
    }

    public void positionClicked(MouseEvent e) {
        if (currentSelected != null) {
            PiecePosition from = currentSelected.getPiecePosition();
            PositionComponent positionComponent = (PositionComponent) e.getComponent();
            PiecePosition to = positionComponent.getPiecePosition();
            if (isMovable(from, to)) {
                currentSelected.moveTo(positionComponent.getPiecePosition());
                changePlayer();
            }
        }
    }
}
