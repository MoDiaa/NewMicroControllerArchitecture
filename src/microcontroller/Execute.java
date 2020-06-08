package microcontroller;

public class Execute {
	static int AlUresult;

	// AlUresult=AlUresult that out from Execute
	public static String ALUEvaluator(String Op, int Operand1, int Operand2,
			int Operand3) {
		System.out.println("\n"+"Execute stage:"+"\n");
		
		// TODO Auto-generated method stub
		if (Op.equals("0000")) {
			add(Op, Operand1, Operand2);
		}
		if (Op.equals("0001")) {
			ADDI(Op, Operand1, Operand2);
		}
		if (Op.equals("0010")) {
			sub(Op, Operand1, Operand2);
		}
		if (Op.equals("0011")) {
			MULT(Op, Operand1, Operand2);
		}
		if (Op.equals("0100")) {
			AND(Op, Operand1, Operand2);
		}
		if (Op.equals("0101")) {
			ORI(Op, Operand1, Operand2);
		}
		if (Op.equals("0110")) {
			SLL(Op, Operand1, Operand2);
		}
		if (Op.equals("0111")) {
			SRL(Op, Operand1, Operand2);
		}
		if (Op.equals("1000")) {
			LwOp(Op, Operand1, Operand2);
		}
		if (Op.equals("1001")) {
			SwOp(Op, Operand1, Operand2);
		}
		if (Op.equals("1010")) {
			BNE(Op, Operand1, Operand2, Operand3);
		}
		if (Op.equals("1011")) {
			BGTZ(Op, Operand1, Operand2);
		}
		if (Op.equals("1100")) {
			SLT(Op, Operand1, Operand2);
		}
		if (Op.equals("1101")) {
			Jump(Op, Operand1, Operand2);
		}
		System.out.println("MEM controls: MemRead: " + ControlUnitc.signal[3] + " MemWrite:"
				+ ControlUnitc.signal[5]);
		String ALUresult2 = Integer.toString(AlUresult);
		return ALUresult2;
	}

	public static void add(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A + B;
		System.out.println("R-type(ADD)");
		// action rd=rs+rt//
		// AlUresult=alu res
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void ADDI(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A + B;
		System.out.println("I-type(ADDI)");
		// action rt=rs+imm//

		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}

	}

	public static void sub(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A - B;
		System.out.println("R-type(SUB)");
		// action rd=rs-rt
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}

	}

	public static void MULT(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A * B;
		System.out.println("R-type(MULT)");
		// action HI,LO=rs*rt//
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}

	}

	public static void AND(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A & B;
		System.out.println("R-type(AND)");
		// action rd=rs&rt//
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void ORI(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A | B;
		System.out.println("I-type(ORT)");
		// action rt=rs|imm//
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void SLL(String Op, int A, int B) {
		// TODO Auto-generated method stub
		AlUresult = A << B;
		System.out.println("R-type(SLL)");
		// action rd=rt<<sa//
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void SRL(String Op, int A, int B) {
		AlUresult = A >> B;
		System.out.println("R-type(SRL)");
		// action=rd=rt>>sa
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void LwOp(String Op, int A, int B) {
		AlUresult = A + B;
		System.out.println("I-type(LW)");
		// action rt=(int)(offset+rs)
	}

	public static void SwOp(String Op, int A, int B) {
		AlUresult = A + B;
		System.out.println("I-type(SW)");
		// action=*(int*)(offset+rs)=rt
	}

	public static void BNE(String Op, int A, int B, int C) {
		C = C - 1;
		System.out.println("I-type(BNE)");
		if (A != B)
			InstFetch.pc += C;
		// Action: if(rs!=rt) pc+=offset4
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void BGTZ(String Op, int A, int B) {
		B = B - 1;
		System.out.println("I-type(BGTZ)");
		if (A > 0)
			InstFetch.pc += B;
		// Action: if(rs>0) pc+=offset4
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void SLT(String Op, int A, int B) {
		System.out.println("R-type(SLT)");
		if (A < B) {
			AlUresult = 1;
			// rd=rs<rt
		} else {
			AlUresult = 0;
		}
		if (AlUresult == 0) {
			System.out.println("Z_Flag Value :" + 1);
		} else {
			System.out.println("Z_Flag Value :" + 0);
		}
	}

	public static void Jump(String Op, int A, int B) {
		A = A- 1;
		// el mafrod el A = htnot kam nata mn ele anta wa2ef 3leh.
		System.out.println("J-type(J):"+ "Jump Target: = "+A);
		InstFetch.pc += A;
		// action: pc=pc_upper|(target<<2)
	}
}
