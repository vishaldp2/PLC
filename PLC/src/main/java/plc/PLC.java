package plc;

public class PLC {
	private PLCMode plcMode;

	public PLC(PLCMode plcMode) {
		this.plcMode = plcMode;
	}

	public PLCMode getPlcMode() {
		return plcMode;
	}

	public void setPlcMode(PLCMode plcMode) {
		this.plcMode = plcMode;
	}

	public void changeMode() {
		if (plcMode == PLCMode.RUN) setPlcMode(PLCMode.PROGRAM);
		else setPlcMode(PLCMode.RUN);
	}
}
