package microcontroller;

public class WriteBack {
	// static int WD;
	static int wrr;

	public static String Wback(int ALU, int RWata, String MTG, String RD) {
		System.out.println("\n"+"WB stage:"+"\n");

		if (!RD.equals(null)) {
			if (RD.equals("0")) {
				wrr = InstDecode.Drt1;
			}
			if (RD.equals("1")) {
				wrr = InstDecode.Drd1;
			}
		}
		if (!MTG.equals(null)) {
			if (MTG.equals("0")) {
				String AL = "" + ALU;
				RegisterFile.Register[wrr] = AL;
			}
			if (MTG.equals("1")) {
				String RW1 = "" + RWata;
				RegisterFile.Register[wrr] = RW1;
			}
		}
		
		System.out.println("===============================================");
		return Integer.toString(wrr);
	}
}
