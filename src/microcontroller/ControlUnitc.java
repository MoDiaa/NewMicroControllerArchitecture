package microcontroller;

public class ControlUnitc {
	static String[] signal = new String[8];
	public static String[] ContUnit(String cop) {
		// {ALUop,ALUSrc,Branch,memRead,memtoReg,memWrite,RegDst,RegWrite}
		// System.out.println("countunit "+cop);
		if (!cop.equals(null)) {
			if (cop.matches("0000|0010|0011|0100|0110|0111|1100")) {
				// ADD SUB MULT AND SLL SRL SLT R-type
				signal[0] = "10";
				signal[1] = "0";
				signal[2] = "0";
				signal[3] = "0";
				signal[4] = "0";
				signal[5] = "0";
				signal[6] = "1";
				signal[7] = "1";
			}
			if (cop.matches("0001|0101|1000|1010|1011")) {
				// ADDI ORT BNE BGTZ I-type
				signal[0] = "01";
				signal[1] = "0";
				signal[2] = "1";
				signal[3] = "0";
				signal[4] = "0";
				signal[5] = "0";
				signal[6] = "0";
				signal[7] = "0";
			}
			if (cop.equals("1000")) {
				// LW I-type
				signal[0] = "00";
				signal[1] = "1";
				signal[2] = "0";
				signal[3] = "1";
				signal[4] = "1";
				signal[5] = "0";
				signal[6] = "0";
				signal[7] = "1";
			}
			if (cop.equals("1001")) {
				// SW I-type
				signal[0] = "00";
				signal[1] = "1";
				signal[2] = "0";
				signal[3] = "0";
				signal[4] = "0";
				signal[5] = "1";
				signal[6] = "0";
				signal[7] = "0";
			}

			if (cop.equals("1101")) {
				// J J-type
				signal[0] = "00";
				signal[1] = "0";
				signal[2] = "0";
				signal[3] = "0";
				signal[4] = "0";
				signal[5] = "0";
				signal[6] = "0";
				signal[7] = "0";
			}
		}
		return signal;
	}
	
	
	
}
