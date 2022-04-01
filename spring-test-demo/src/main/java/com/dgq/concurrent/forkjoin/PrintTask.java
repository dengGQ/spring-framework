package com.dgq.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class PrintTask extends RecursiveAction {
	private static final long serialVersionUID = 5232453952276485071L;

	public static final int MAX = 50;

	private int start;
	private int end;

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {

		if ((end - start) < MAX) {

			for (int i = start; i < end; i++) {
				System.out.println("Thread name="+Thread.currentThread().getName()+"："+i);
			}
		}else {

			int middle = (start+end)/2;

			PrintTask leftTask = new PrintTask(start, middle);
			PrintTask rightTask = new PrintTask(middle, end);

			leftTask.fork();
			rightTask.fork();
		}
	}

	public static void main(String[] args) {

		final ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(new PrintTask(0, 100));

		forkJoinPool.awaitQuiescence(2, TimeUnit.SECONDS);

		forkJoinPool.shutdown();
	}
}
