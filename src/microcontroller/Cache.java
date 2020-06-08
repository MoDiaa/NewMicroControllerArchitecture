package microcontroller;

public class Cache {

	static int tag = 0;
	static int index = 0;
	static int hits = 0;
	static int miss = 0;
	static int[][] cashe = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public static void read(int address) {
		tag = address / 4;
		index = address % 4;
		if (cashe[index][0] == 1) {
			if (cashe[index][1] == tag) {
				hits++;
			} else {
				miss++;
				cashe[index][2] = MemAccess.datamem[address];
				cashe[index][1] = tag;
			}
		} else {
			miss++;
			cashe[index][0] = 1;
			cashe[index][1] = tag;
			cashe[index][2] = MemAccess.datamem[address];
		}

	}
}
