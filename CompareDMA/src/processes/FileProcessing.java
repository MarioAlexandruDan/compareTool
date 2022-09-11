package processes;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FileProcessing {

	private static int newFilesCounter = 0;
	private static int modifiedFilesCounter = 0;

	public static Map<Path, String> compareFiles(Map<Path, Long> file1, Map<Path, Long> file2) {

		Map<Path, String> map = new HashMap<>();

		for (Entry<Path, Long> entryFile2 : file2.entrySet()) {
			if (!file1.containsKey(entryFile2.getKey())) {
				map.put(entryFile2.getKey(), "New File");
				newFilesCounter++;
			}
		}

		for (Entry<Path, Long> entryMap : mapDifferenceInCommon(file1, file2).entrySet()) {
			map.put(entryMap.getKey(), "Modified File");
			modifiedFilesCounter++;
		}

		return map;
	}

	public static Map<Path, Long> mapDifferenceInCommon(Map<Path, Long> file1, Map<Path, Long> file2) {

		Map<Path, Long> mergeInCommon = new LinkedHashMap<>();
		Map<Path, Long> differenceInCommon = new LinkedHashMap<>();
		mergeInCommon.putAll(file1);

		for (Entry<Path, Long> entry : file2.entrySet()) {

			if (mergeInCommon.containsKey(entry.getKey())) {
				mergeInCommon.replace(entry.getKey(), entry.getValue());
			}
		}

		for (Entry<Path, Long> entry : file1.entrySet()) {

			if (!mergeInCommon.containsValue(entry.getValue())) {
				differenceInCommon.put(entry.getKey(), entry.getValue());
			}
		}

		return differenceInCommon;
	}

	public static int getNewFilesCounter() {
		return newFilesCounter;
	}

	public static int getModifiedFilesCounter() {
		return modifiedFilesCounter;
	}
}
