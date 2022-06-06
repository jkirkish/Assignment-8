package com.coderscampus.Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuService {
	
	public void runExecutorStats(ExecutorService executor) {

		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

		System.out.println("Core threads: " + pool.getCorePoolSize());
		System.out.println("Largest executions: " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + pool.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + pool.getPoolSize());
		System.out.println("Currently executing threads: " + pool.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + pool.getTaskCount());

		executor.shutdown();
	}

	public List<Long> runNumberFilter(List<Integer> aList) {
		List<Long> counts = new ArrayList<>();

		Long count = aList.stream().filter(t -> t == 0).count();

		Long count1 = aList.stream().filter(t -> t == 1).count();

		Long count2 = aList.stream().filter(t -> t == 2).count();

		Long count3 = aList.stream().filter(t -> t == 3).count();

		Long count4 = aList.stream().filter(t -> t == 4).count();

		Long count5 = aList.stream().filter(t -> t == 5).count();

		Long count6 = aList.stream().filter(t -> t == 6).count();

		Long count7 = aList.stream().filter(t -> t == 7).count();

		Long count8 = aList.stream().filter(t -> t == 8).count();

		Long count9 = aList.stream().filter(t -> t == 3).count();

		Long count10 = aList.stream().filter(t -> t == 10).count();

		Long count11 = aList.stream().filter(t -> t == 11).count();

		Long count12 = aList.stream().filter(t -> t == 12).count();

		Long count13 = aList.stream().filter(t -> t == 13).count();

		Long count14 = aList.stream().filter(t -> t == 14).count();

		counts.add(count);
		counts.add(count1);
		counts.add(count2);
		counts.add(count3);
		counts.add(count4);
		counts.add(count5);
		counts.add(count6);
		counts.add(count7);
		counts.add(count8);
		counts.add(count9);
		counts.add(count10);
		counts.add(count11);
		counts.add(count12);
		counts.add(count13);
		counts.add(count14);
		System.out.print("{");
		for (int i = 0; i < counts.size(); i++) {
			System.out.print(i + "=" + counts.get(i) + ", ");
		}
		System.out.print("}\n");
		return counts;
	}

}
