package microcontroller;

import java.util.Arrays;

public class Cpu {
	
//	InstFetch.fetch();
//	InstDecode.Decode(InstFetch.instr,Register);
//	Execute.ALUEvaluator(InstDecode.op, InstDecode.input1, InstDecode.input2, InstDecode.input3);
//	MemAccess.MemAcc(Execute.AlUresult,InstDecode.input2,InstDecode.signal[3],InstDecode.signal[5]);
//	WriteBack.Wback(Execute.AlUresult, MemAccess.readdata, InstDecode.signal[4],InstDecode.signal[6]);

	public static void main(String[] args) {
		int clockcycle = 0;
		String[] pip = new String[5];
		for (int i = 0; i < InstFetch.mem.length; i = InstFetch.pc) {
			clockcycle++;
			System.out.println("clockcycle : " + clockcycle);
			
			pip[0] = InstFetch.fetch();
			pip[1] = InstDecode.Decode(pip[0], RegisterFile.Register);
			
			pip[2] = Execute.ALUEvaluator(InstDecode.op, InstDecode.input1,
					InstDecode.input2, InstDecode.input3);
			System.out.println("AlUresult = " +Integer.toBinaryString(Integer.parseInt(pip[2])));
			pip[3] = MemAccess.MemAcc(Integer.parseInt(pip[2]),
					InstDecode.input2, ControlUnitc.signal[3],
					ControlUnitc.signal[5]);
			
			pip[4] = WriteBack.Wback(Integer.parseInt(pip[2]),
					Integer.parseInt(pip[3]), ControlUnitc.signal[4],
					ControlUnitc.signal[6]);

		}

	}

}
