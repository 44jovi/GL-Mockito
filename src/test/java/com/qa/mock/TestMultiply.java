package com.qa.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // enables mockito for these tests
public class TestMultiply {

	@Mock // create the mock Random object
	private Scanner scan1;

	@InjectMocks // inserts the mock into the Simulator
	private Simulator sim;

	// TODO: WIP - mock multiple scanner inputs within 1 method call
	@Test
	void test2and4() {
		Mockito.when(this.scan1.nextLine()).thenReturn("2");
		Mockito.when(this.scan1.nextLine()).thenReturn("4");

		assertEquals(8, this.sim.multiply());
	}
}
