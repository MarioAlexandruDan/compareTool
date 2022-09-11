package core;

import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

import messages.Messages;
import processes.FileComparing;
import processes.FileLoading;

public class Start {

	public static void main(String[] args) {

		Path path1 = FileLoading.loadFile1();
		Path path2 = FileLoading.loadFile2();

		System.out.println("\n" + Messages.startMessage() + "\n");

		System.out.println(Messages.file1Message() + path1);
		System.out.println(Messages.file1Message() + path2 + "\n");

		if (FileLoading.isValid()) {

			Map<Path, Long> file1List = FileLoading.file1ContentsToMap();
			Map<Path, Long> file2List = FileLoading.file2ContentsToMap();

			System.out.println(Messages.filesExistsMessage() + "\n");
			
			FileComparing.compareFiles(file1List, file2List);

		}

	}
}
