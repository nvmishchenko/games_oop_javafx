package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell rsl = bishopBlack.position();
        Cell expected = Cell.C1;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell rsl = bishopBlack.copy(Cell.G4).position();
        Cell expected = Cell.G4;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl).isEqualTo(expected);
    }
}