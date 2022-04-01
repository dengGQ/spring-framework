package com.dgq.algorithm;

public class BitMap {

	// 能存下整数的个数：比如15个整数，len=15
	private int len;
	private byte[] byteArray;

	public BitMap(int len) {
		this.len = len;
		byteArray = new byte[(len>>3)+1];
	}

	public void set(int num, Boolean bool) {

		if (bool) {

			byteArray[num/8] |= 1<< (num%8);
		}else {
			byteArray[num/8] &= ~(1<< (num%8));
		}
	}

	/**
	 * 将num所在的位置从0变成1
	 * 将1左移position位后，position位置上自然就是1，其他位置都是0
	 * 然后和以前的数据做‘或’运算，这样，以前的数据position位置上就替换成1了，其他位置保持不变
	 */
	public void add(int num) {
		byteArray[getIdx(num)] |= 1 << getPosition(num);
	}

	/**
	 * 将num所在的位置从0变成1
	 * 将1左移position位后，position位置上自然就是1，其他位置都是0。然后再取反就变成position位置是0，其他位置都是1
	 * 然后和以前的数据做‘与’运算，这样，以前的数据position位置上替换成0了，其他位置保持不变
	 * @param num
	 */
	public void remove(int num) {
		byteArray[getIdx(num)] &= ~(1 << getPosition(num));
	}

	/**
	 * 判断num是否存在
	 * 同样将1左移position位使position位置上变成1，其他位置都是0，然后用这个数跟原数做与运算
	 * 因为其他位置都是0，只有position位置是1，所以只有原数据position位置也是1运算后的结果才会是1，否则就是0
	 * 如此边确定了num是否存在了
	 * @param num
	 * @return
	 */
	public boolean isExits(int num) {

		return (byteArray[num/8] & (1 << (num % 8))) != 0 ? true : false;
	}

	// num在byte[]数组中的位置
	public int getIdx(int num) {
		return num >> 3;
	}

	// num在byte[idx]中第几位, 等价于：num%8
	public int getPosition(int num) {
		return num & 0x07;
	}

	public byte[] getBitMap(){
		return byteArray;
	}

	public int getLen() {
		return len;
	}
}
