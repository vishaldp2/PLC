package assemblyline;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssemblyLineStartupAlgorithmTest {
	private static final AssemblyLineStartupAlgorithm assemblyLineStartupAlgorithm = new AssemblyLineStartupAlgorithm();

	@Test
	void sameNumberOfPLCsAndEmployees_correctNumberOfPLCsInRunMode() {
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(0, 0));
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(0, 2));
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(2, 0));
		assertEquals(1, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(1, 1));
		assertEquals(2, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(5, 5));
		assertEquals(27, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(750, 750));
		assertEquals(33, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(1100, 1100));
	}

	@Test
	void differentNumberOfPLCsAndEmployees_correctNumberOfPLCsInRunMode() {
		assertEquals(2, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(5, 10));
		assertEquals(3, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(10, 50));
		assertEquals(27, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(50, 5));
		assertEquals(6, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(10, 5));
	}

	@Test
	void incorrectNumberOfPLCsOrEmployees_correctNumberOfPLCsInRunMode() {
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(5, -1));
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(-1, 5));
		assertEquals(0, assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(-1, -1));
	}
}
