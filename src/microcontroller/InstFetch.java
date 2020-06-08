package microcontroller;

public class InstFetch {
	static int pc = 0;
	static int i = 0;
	static String t;
	static String w;

	public static String[] mem = new String[] { "0000010110101100",
			"0001010110101100", "0010010110101100", "0011010110101100",
			"0100010110101100", "1101000000000010", "0101010110101100",
			"0110010110101100", "0111010110101100", "1001010100001111",
			"1000010100001111", "1010010110101100", "1011010110101100",
			"1100010110101100", };
	// public static String[] mem = new String[] {"0000010110101100"};
	public static String instr;

	public static String fetch() {
		System.out.println("Fetch stage:");
		// pc = pc + 1;
		System.out.println("PC NOW:" + pc);
		instr = mem[pc];
		pc++;
		System.out.println("Instruction:" + instr);
		System.out.println("Next PC:" + pc);
		return instr;
	}

}