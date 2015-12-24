package com.boye.threekings;

//@formatter:off
/**
 *   1 2 3
 * A * * *
 * B * * *
 * C * * *
 *
 * two dimension coordinates
 *
 * @author Bo Ye
 *
 */
// @formatter:on
public enum PiecePosition {
    A1, A2, A3, B1, B2, B3, C1, C2, C3;

    public int getXCoordinate() {
        String number = this.name().substring(1, 2);
        switch (Integer.valueOf(number)) {
            case 1:
                return 0;
            case 2:
                return Constants.BOARD_SIDE / 2 - Constants.PIECE_DIAMETER / 2;
            case 3:
                return Constants.BOARD_SIDE - Constants.PIECE_DIAMETER;
            default:
                throw new AssertionError("Impossible x coordinate!");
        }
    }

    public int getYCoordinate() {
        String letter = this.name().substring(0, 1);
        switch (letter) {
            case "A":
                return 0;
            case "B":
                return Constants.BOARD_SIDE / 2 - Constants.PIECE_DIAMETER / 2;
            case "C":
                return Constants.BOARD_SIDE - Constants.PIECE_DIAMETER;
            default:
                throw new AssertionError("Impossible y coordinate!");
        }

    }

    public int getWidth() {
        return Constants.PIECE_DIAMETER;
    }

    public int getHeight() {
        return Constants.PIECE_DIAMETER;
    }
}
