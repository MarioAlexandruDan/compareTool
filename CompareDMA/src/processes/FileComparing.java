package processes;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FileComparing {

	public static Map<String, Path> compareFiles(Map<Path, Long> file1, Map<Path, Long> file2) {

		Map<Path, String> map = new HashMap<>();

		List<Path> firstList = new ArrayList<>();
		List<Path> secondList = new ArrayList<>();

		for (Entry<Path, Long> entry2 : file2.entrySet()) {

			if (!file1.containsKey(entry2.getKey())) {
				firstList.add(entry2.getKey());
				map.put(entry2.getKey(), "New file");
			}
		}

		mapDifferenceInCommon(file1, file2);

		return null;
	}

	public static <Path, Long> Map<Path, Long> mapDifferenceInCommon(Map<Path, Long> file1, Map<Path, Long> file2) {

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

		System.out.println(differenceInCommon);

		return differenceInCommon;
	}

}
