package microcontroller;

public class MemAccess {
	static int[] datamem = new int[1024];
	static int readdata;

	public static String MemAcc(int add, int data, String MemRead,
			String MemWrite) {
		System.out.println("\n"+"Memory stage:"+"\n");

		if (!MemRead.equals(null)) {
			if (MemRead.equals("1")) {
				readdata = datamem[add];
			}
		}
		if (!MemWrite.equals(null)) {
			if (MemWrite.equals("1")) {
				datamem[add] = data;
			}
		}

		System.out.println("Readdata: " + readdata);
		System.out.println("WB controls: MemToReg: " + ControlUnitc.signal[4] + " RegWrite: " + ControlUnitc.signal[6]);
		return Integer.toString(readdata);
	}

}
