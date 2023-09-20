package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException() {
        ru.job4j.chess.Logic logic = new ru.job4j.chess.Logic();
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.add(new BishopBlack(Cell.C3));
            logic.add(new BishopBlack(Cell.D4));
            logic.move(Cell.C3, Cell.E5);
        });
        assertThat(exception.getMessage()).isEqualTo("Occupied cell on the way");
    }

    @Test
    public void whenMoveThenImpossibleMoveException() {
        ru.job4j.chess.Logic logic = new ru.job4j.chess.Logic();
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.add(new BishopBlack(Cell.C3));
            logic.move(Cell.C3, Cell.C8);
        });
        assertThat(exception.getClass()).isEqualTo(ImpossibleMoveException.class);
    }
}