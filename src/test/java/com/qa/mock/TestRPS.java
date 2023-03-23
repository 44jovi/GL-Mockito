package com.qa.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // enables mockito for these tests
public class TestRPS {

	@Mock // create the mock Random object
	private Random rand;

	@InjectMocks // inserts the mock into the Simulator
	private Simulator sim;

	@Test
	void testRockWin() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(2);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.WIN, this.sim.playRPS(RPS.ROCK));
	}

	@Test
	void testPaperWin() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.WIN, this.sim.playRPS(RPS.PAPER));
	}

	@Test
	void testScissorsWin() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.WIN, this.sim.playRPS(RPS.SCISSORS));
	}

	@Test
	void testRockLose() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.LOSE, this.sim.playRPS(RPS.ROCK));
	}

	@Test
	void testPaperLose() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(2);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.LOSE, this.sim.playRPS(RPS.PAPER));
	}

	@Test
	void testScissorsLose() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.LOSE, this.sim.playRPS(RPS.SCISSORS));
	}

	@Test
	void testRockDraw() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.DRAW, this.sim.playRPS(RPS.ROCK));
	}

	@Test
	void testPaperDraw() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.DRAW, this.sim.playRPS(RPS.PAPER));
	}

	@Test
	void testScissorsDraw() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(2);

		for (int i = 0; i < 1000; i++)
			assertEquals(Result.DRAW, this.sim.playRPS(RPS.SCISSORS));
	}

}
