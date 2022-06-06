package com.coderscampus.Assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment8App {

	public static void main(String[] args) {

		Assignment8 assignment8 = new Assignment8();
		ExecuService execute = new ExecuService();

		List<Integer> allNumbers = Collections.synchronizedList(new ArrayList<>(1000));

		ExecutorService executor = Executors.newCachedThreadPool();

		List<CompletableFuture<Void>> tasks = new ArrayList<>(1000);

		for (int i = 0; i < 1000; i++) {
			CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> assignment8.getNumbers(), executor)
					.thenAccept(numbers -> allNumbers.addAll(numbers));
			tasks.add(task);
		}

		while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}

		Map<Integer, Integer> output = allNumbers.stream()
				.collect(Collectors.toMap(i -> i, i -> 1, (oldValue, newValue) -> oldValue + 1));
		System.out.println(output);
		execute.runNumberFilter(allNumbers);
		execute.runExecutorStats(executor);
	}

}