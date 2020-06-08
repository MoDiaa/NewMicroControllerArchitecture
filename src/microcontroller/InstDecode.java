package microcontroller;

import java.util.Arrays;

public class InstDecode {
	static int input1;
	static int input2;
	static int input3;
	static int Drs1;
	static int Drt1;
	static int Drd1;
	static int DImm11;
	static int Dsa1;
	static int Doffset1;
	static int target;
	static String op;
	
	static String decout = "";
	static String regname1;
	static String regname2;
	static String regname3;

	

	public static String Decode(String instr, String[] Register) {
		System.out.println("\n"+"Decode stage:"+"\n");
		String rs1 = null;
		String rt1 = null;
		String Imm1 = null;
		String rd1 = null;
		String add = null;
		String sa = null;
		String offset;
		for (int i = 0; i < instr.length(); i++) {
			op = instr.substring(0, 4);
			ControlUnitc.ContUnit(op);
			
			if (op.equals("0000")) {
				// ADD

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				rd1 = instr.substring(12, 16);
				
				// /GET VALUE FOR RS&RT&RD///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];
			}
			if (op.equals("0001")) {
				// ADDI

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				Imm1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&imm///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				DImm11 = Integer.parseInt(Imm1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				String Rrt1 = Register[Drt1];
				input2 = Integer.parseInt(Register[DImm11]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[DImm11];
				regname3 = RegisterFile.names[Drt1];
			}
			if (op.equals("0010")) {
				// SUB

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				rd1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&RD///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];

			}
			if (op.equals("0011")) {
				// MULT

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				rd1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];
			}
			if (op.equals("0100")) {
				// AND

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				rd1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&RD///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];
			}
			if (op.equals("0101")) {
				// Or immediate.

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				Imm1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&imm///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				DImm11 = Integer.parseInt(Imm1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				String Rrt1 = Register[Drt1];
				regname3 = RegisterFile.names[Drt1];
				input2 = Integer.parseInt(Register[DImm11]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[DImm11];
			}
			if (op.equals("0110")) {
				// Shift left logical.

				rt1 = instr.substring(4, 8);
				rd1 = instr.substring(8, 12);
				sa = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&sa///
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				Dsa1 = Integer.parseInt(sa, 2);
				input1 = Integer.parseInt(Register[Drt1]);
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];
				input2 = Integer.parseInt(Register[Dsa1]);
				regname1 = RegisterFile.names[Drt1];
				regname2 = RegisterFile.names[Dsa1];
			}
			if (op.equals("0111")) {
				// Shift right logical.

				rt1 = instr.substring(4, 8);
				rd1 = instr.substring(8, 12);
				sa = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&sa///
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				Dsa1 = Integer.parseInt(sa, 2);
				input1 = Integer.parseInt(Register[Drt1]);
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];
				input2 = Integer.parseInt(Register[Dsa1]);
				regname1 = RegisterFile.names[Drt1];
				regname2 = RegisterFile.names[Dsa1];
			}
			if (op.equals("1000")) {
				// Load word.

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				offset = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&offset///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Doffset1 = Integer.parseInt(offset, 2);
				input1 = Integer.parseInt(Register[Doffset1]);
				String Rrt1 = Register[Drt1];
				regname3 = RegisterFile.names[Drt1];
				input2 = Integer.parseInt(Register[Drs1]);
				regname1 = RegisterFile.names[Doffset1];
				regname2 = RegisterFile.names[Drs1];
			}
			if (op.equals("1001")) {
				// Store word

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				offset = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&offset///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Doffset1 = Integer.parseInt(offset, 2);
				input1 = Integer.parseInt(Register[Doffset1]);
				String Rrt1 = Register[Drt1];
				regname3 = RegisterFile.names[Drt1];
				input2 = Integer.parseInt(Register[Drs1]);
				regname1 = RegisterFile.names[Doffset1];
				regname2 = RegisterFile.names[Drs1];
			}
			if (op.equals("1010")) {
				// Branch on not equal

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				offset = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&offset///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Doffset1 = Integer.parseInt(offset, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				input3 = Doffset1;
				regname3 = RegisterFile.names[Doffset1];
			}
			if (op.equals("1011")) {
				// Branch on greater than

				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				offset = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&offset///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Doffset1 = Integer.parseInt(offset, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				regname1 = RegisterFile.names[Drs1];
				input2 = Doffset1;
				regname2 = RegisterFile.names[Doffset1];
				regname3 = RegisterFile.names[Drt1];
			}
			if (op.equals("1100")) {
				// Set on less than(SLT)
				rs1 = instr.substring(4, 8);
				rt1 = instr.substring(8, 12);
				rd1 = instr.substring(12, 16);
				// /GET VALUE FOR RS&RT&RD///
				Drs1 = Integer.parseInt(rs1, 2);
				Drt1 = Integer.parseInt(rt1, 2);
				Drd1 = Integer.parseInt(rd1, 2);
				input1 = Integer.parseInt(Register[Drs1]);
				input2 = Integer.parseInt(Register[Drt1]);
				regname1 = RegisterFile.names[Drs1];
				regname2 = RegisterFile.names[Drt1];
				String Rrd1 = Register[Drd1];
				regname3 = RegisterFile.names[Drd1];

			}
			if (op.equals("1101")) {
				// Jump
				add = instr.substring(4);
				target = Integer.parseInt(add, 2);
				input1 = target;
			}
			decout = op+input1+input2+input3;
		}
		System.out.println("rs:" + Integer.toBinaryString(Drs1));
		System.out.println("rt:" + Integer.toBinaryString(Drt1));
		System.out.println("rd:" + Integer.toBinaryString(Drd1));
		System.out.println("Regname1 : " + regname1);
		System.out.println("Regname2 : " + regname2);
		System.out.println("Regname3 : " + regname3);
		System.out.println("EX controls: RegDest: " + ControlUnitc.signal[6]
				+ " ALUOp: " + ControlUnitc.signal[0] + " ALUSrc: "
				+ ControlUnitc.signal[1]);

		return decout;
	}
}
