package com.boye.threekings;

import com.boye.threekings.component.PieceComponent;
import com.boye.threekings.component.PositionComponent;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Controller {

    private static final Map<PiecePosition, PiecePosition[]> POSITION_MOVABLES;
    private static final List<PiecePosition[]> WINNING_POSITIONS;

    static {
        //initialize connectivities
        Map<PiecePosition, PiecePosition[]> map = new HashMap<>();
        map.put(PiecePosition.A1, new PiecePosition[]{PiecePosition.A2, PiecePosition.B1, PiecePosition.B2});
        map.put(PiecePosition.A2, new PiecePosition[]{PiecePosition.A1, PiecePosition.A3, PiecePosition.B2});
        map.put(PiecePosition.A3, new PiecePosition[]{PiecePosition.A2, PiecePosition.B2, PiecePosition.B3});
        map.put(PiecePosition.B1, new PiecePosition[]{PiecePosition.A1, PiecePosition.B2, PiecePosition.C1});
        map.put(PiecePosition.B2, new PiecePosition[]{PiecePosition.A1, PiecePosition.A2, PiecePosition.A3, PiecePosition.B1, PiecePosition.B3, PiecePosition.C1,
            PiecePosition.C2, PiecePosition.C3});
        map.put(PiecePosition.B3, new PiecePosition[]{PiecePosition.A3, PiecePosition.B2, PiecePosition.C3});
        map.put(PiecePosition.C1, new PiecePosition[]{PiecePosition.B1, PiecePosition.B2, PiecePosition.C2});
        map.put(PiecePosition.C2, new PiecePosition[]{PiecePosition.B2, PiecePosition.C1, PiecePosition.C3});
        map.put(PiecePosition.C3, new PiecePosition[]{PiecePosition.B2, PiecePosition.B3, PiecePosition.C2});
        POSITION_MOVABLES = Collections.unmodifiableMap(map);
        //initialize winning positions
        List<PiecePosition[]> list = new ArrayList<>();
        list.add(new PiecePosition[]{PiecePosition.B1, PiecePosition.B2, PiecePosition.B3});
        list.add(new PiecePosition[]{PiecePosition.A1, PiecePosition.B1, PiecePosition.C1});
        list.add(new PiecePosition[]{PiecePosition.A2, PiecePosition.B2, PiecePosition.C2});
        list.add(new PiecePosition[]{PiecePosition.A3, PiecePosition.B3, PiecePosition.C3});
        list.add(new PiecePosition[]{PiecePosition.A1, PiecePosition.B2, PiecePosition.C3});
        list.add(new PiecePosition[]{PiecePosition.A3, PiecePosition.B2, PiecePosition.C1});
        WINNING_POSITIONS = Collections.unmodifiableList(list);
    }

    private static Controller controller;

    private Controller() {
    }

    public synchronized static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    ///////
    private PieceComponent[] greenKings = new PieceComponent[3];
    private PieceComponent[] redKings = new PieceComponent[3];
    private Color currentPlayer;
    private PieceComponent currentSelected;
    private boolean isGameEnd;

    public void setUp(PieceComponent[] greenKings, PieceComponent[] redKings) {
        //set up initial layout
        this.greenKings = greenKings;
        this.redKings = redKings;
        this.currentPlayer = Color.GREEN;
    }

    private void reset() {
        greenKings[0].moveTo(PiecePosition.C1);
        greenKings[1].moveTo(PiecePosition.C2);
        greenKings[2].moveTo(PiecePosition.C3);
        redKings[0].moveTo(PiecePosition.A1);
        redKings[1].moveTo(PiecePosition.A2);
        redKings[2].moveTo(PiecePosition.A3);
        this.currentPlayer = Color.GREEN;
        this.currentSelected = null;
        this.isGameEnd = false;
    }

    private boolean isMovable(PiecePosition from, PiecePosition to) {
        PiecePosition[] movables = POSITION_MOVABLES.get(from);
        return Arrays.binarySearch(movables, to) > -1;
    }

    private void changePlayer() {
        if (currentPlayer.equals(Color.GREEN)) {
            currentPlayer = Color.RED;
        } else {
            currentPlayer = Color.GREEN;
        }
    }

    /**
     * Tell if one player win.
     */
    private boolean existWinningPosition() {
        PieceComponent[] kings = currentPlayer.equals(Color.GREEN) ? greenKings : redKings;
        List<PiecePosition> kingPositions = new ArrayList<>();
        kingPositions.add(kings[0].getPiecePosition());
        kingPositions.add(kings[1].getPiecePosition());
        kingPositions.add(kings[2].getPiecePosition());
        // check win patterns
        for (PiecePosition[] winningPosition : WINNING_POSITIONS) {
            boolean flag = true;
            for (PiecePosition position : winningPosition) {
                if (!kingPositions.contains(position)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
    current player selects the piece and flashes the piece to indicate 
    @param pieceComponent 
     */
    public void clickPiece(PieceComponent pieceComponent) {
        if (!isGameEnd) {
            Color selectedColor = pieceComponent.getColor();
            if (selectedColor.equals(currentPlayer)) {
                if (currentSelected != null) {
                    currentSelected.deSelect();
                }
                pieceComponent.select();
                currentSelected = pieceComponent;
            }
        } else {
            reset();
        }
    }

    /**
    current player moves the piece to targeted position
    @param positionComponent
     */
    public void clickPosition(PositionComponent positionComponent) {
        if (currentSelected != null) {
            PiecePosition from = currentSelected.getPiecePosition();
            PiecePosition to = positionComponent.getPiecePosition();
            if (isMovable(from, to)) {
                currentSelected.moveTo(positionComponent.getPiecePosition());
                currentSelected.deSelect();
                currentSelected = null;
                if (!existWinningPosition()) {
                    changePlayer();
                } else {
                    JOptionPane.showMessageDialog(null, "Congratulation! " + (this.currentPlayer.equals(Color.GREEN) ? "Green kings" : "Red kings") + " WON!");
                    isGameEnd = true;
                }
            }
        }
    }
}
