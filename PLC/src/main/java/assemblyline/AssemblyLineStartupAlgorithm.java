package assemblyline;

import plc.PLC;
import plc.PLCMode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AssemblyLineStartupAlgorithm {

	public int runAssemblyLineStartupAlgorithm(int numberOfPLCs, int numberOfEmployees) {
		final int NUMBER_OF_PLCS_IN_RUN_MODE_AT_THE_BEGINNING = 0;
		final int EMPLOYEE_NUMBER_FROM_WHOM_CALCULATIONS_BEGINS = 2;
		final int LAST_EMPLOYEE_NUMBER = numberOfEmployees + 1;
		final int INDEX_OF_FIRST_PLC_THAT_HAS_TO_BE_INCLUDED_IN_CALCULATIONS = 1;

		if (isInputInvalid(numberOfPLCs, numberOfEmployees)) return NUMBER_OF_PLCS_IN_RUN_MODE_AT_THE_BEGINNING;

		final List<PLC> allPLCs = placeAllPLCsInRunMode(numberOfPLCs);
		IntStream.range(EMPLOYEE_NUMBER_FROM_WHOM_CALCULATIONS_BEGINS, LAST_EMPLOYEE_NUMBER)
				.forEach(employeeIndex -> IntStream.range(INDEX_OF_FIRST_PLC_THAT_HAS_TO_BE_INCLUDED_IN_CALCULATIONS, numberOfPLCs)
						.forEach(plcIndex -> {
							if (shouldPLCBeModified(plcIndex, employeeIndex)) allPLCs.get(plcIndex).changeMode();
						}));

		return countPLCsInRunMode(allPLCs);
	}

	private boolean isInputInvalid(int numberOfPLCs, int numberOfEmployees) {
		final int CORRECT_MINIMUM_NUMBER_OF_PLCS = 0;
		final int CORRECT_MINIMUM_NUMBER_OF_EMPLOYEES = 1;
		return numberOfPLCs < CORRECT_MINIMUM_NUMBER_OF_PLCS || numberOfEmployees < CORRECT_MINIMUM_NUMBER_OF_EMPLOYEES;
	}

	private List<PLC> placeAllPLCsInRunMode(int numberOfPLCs) {
		return Stream
				.generate(() -> new PLC(PLCMode.RUN))
				.limit(numberOfPLCs)
				.collect(Collectors.toList());
	}

	private boolean shouldPLCBeModified(int plcIndex, int employeeIndex) {
		final int INDEX_TO_NUMBER_ADJUSTMENT_FACTOR = 1;
		return (plcIndex + INDEX_TO_NUMBER_ADJUSTMENT_FACTOR) % employeeIndex == 0;
	}

	private int countPLCsInRunMode(List<PLC> plcs) {
		return (int) plcs.stream()
				.filter(plc -> plc.getPlcMode() == PLCMode.RUN)
				.count();
	}
}
