import assemblyline.AssemblyLineStartupAlgorithm;

import java.io.IOException;

public class Main {
	private static final AssemblyLineStartupAlgorithm assemblyLineStartupAlgorithm = new AssemblyLineStartupAlgorithm();
	private static final int numberOfPLCs = 1100;
	private static final int numberOfEmployees = 1100;

	public static void main(String[] args) throws IOException {
		System.out.println("Task conditions: 1100 PLCs, 1100 employees" +
				"\nAfter the process is completed with the one thousand one hundredth employee, " +
				assemblyLineStartupAlgorithm.runAssemblyLineStartupAlgorithm(numberOfPLCs, numberOfEmployees) +
				" PLCs are in RUN mode.");

		System.out.println("\nPress Enter to Exit...");
		System.in.read();
	}
}

