package plc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PLCTest {

	@Test
	void changeCurrentMode_correctValue() {
		PLC plcInRunModeThenInProgramMode = new PLC(PLCMode.RUN);
		PLC plcInProgramModeThenInRunMode = new PLC(PLCMode.PROGRAM);

		plcInRunModeThenInProgramMode.changeMode();
		plcInProgramModeThenInRunMode.changeMode();

		assertEquals(PLCMode.PROGRAM, plcInRunModeThenInProgramMode.getPlcMode());
		assertEquals(PLCMode.RUN, plcInProgramModeThenInRunMode.getPlcMode());
	}
}
