package core;

import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

import messages.Messages;
import processes.FileLoading;
import processes.FileProcessing;

public class Start {

	public static void main(String[] args) {

		Path path1 = FileLoading.loadFile1();
		Path path2 = FileLoading.loadFile2();

		System.out.println("\n" + Messages.startMessage() + "\n");

		System.out.println(Messages.tipMessage() + "\n");

		System.out.println(Messages.file1Message() + path1);
		System.out.println(Messages.file1Message() + path2 + "\n");

		if (FileLoading.isValid()) {

			Map<Path, Long> file1PathAndModifiedList = FileLoading.file1PathAndModifiedToMap();
			Map<Path, Long> file2PathAndModifiedList = FileLoading.file2PathAndModifiedToMap();
			Map<Path, Long> file1PathAndSizeList = FileLoading.file1PathAndSizeToMap();
			Map<Path, Long> file2PathAndSizeList = FileLoading.file2PathAndSizeToMap();

			System.out.println(Messages.filesExistsMessage() + "\n");

			Map<Path, String> sortedMapOnDateModified = FileProcessing
					.compareFilesOnPathAndDateModified(file1PathAndModifiedList, file2PathAndModifiedList);
			Map<Path, String> sortedMapOnSize = FileProcessing.compareFilesOnPathAndSize(file1PathAndSizeList,
					file2PathAndSizeList);

			System.out.println(Messages.newFilesMessage());
			for (Entry<Path, String> entry : sortedMapOnDateModified.entrySet()) {
				if (entry.getValue().equals("New File")) {
					System.out.println(entry.getKey());
				}
			}

			System.out.println(" }" + "\n" + "\n" + Messages.dateModifiedFilesMessage());

			for (Entry<Path, String> entry : sortedMapOnDateModified.entrySet()) {
				if (entry.getValue().equals("Modified File")) {
					System.out.println(entry.getKey());
				}
			}

			System.out.println(" }" + "\n" + "\n" + Messages.sizeChangedMessage());

			for (Entry<Path, String> entry : sortedMapOnSize.entrySet()) {
				if (entry.getValue().equals("Size Changed")) {
					System.out.println(entry.getKey());
				}
			}
			System.out.println(" }");

		} else {
			System.out.println(Messages.errorMessage());
		}
	}
}
