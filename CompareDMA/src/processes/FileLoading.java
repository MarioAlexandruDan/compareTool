package processes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileLoading {

	private static Path path1;
	private static Path path2;

	private static boolean valid = true;

	public static Path loadFile1() {

		Path path = Paths.get("File1").toAbsolutePath();

		path = checkForFile(path);
		path1 = path;

		return path;
	}

	public static Path loadFile2() {

		Path path = Paths.get("File2").toAbsolutePath();

		path = checkForFile(path);
		path2 = path;

		return path;
	}

	public static Map<Path, Long> file1PathAndModifiedToMap() {

		Map<Path, Long> map = new HashMap<>();

		try {

			List<Path> list = Files.walk(path1, Integer.MAX_VALUE).filter(input -> !input.equals(path1)).toList();

			for (Path path : list) {
				map.put(path.subpath(path1.getNameCount(), path.getNameCount()),
						Files.readAttributes(path, BasicFileAttributes.class).lastModifiedTime().toMillis());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static Map<Path, Long> file2PathAndModifiedToMap() {

		Map<Path, Long> map = new HashMap<>();

		try {

			List<Path> list = Files.walk(path2, Integer.MAX_VALUE).filter(input -> !input.equals(path2)).toList();

			for (Path path : list) {
				map.put(path.subpath(path2.getNameCount(), path.getNameCount()),
						Files.readAttributes(path, BasicFileAttributes.class).lastModifiedTime().toMillis());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static Map<Path, Long> file1PathAndSizeToMap() {

		Map<Path, Long> map = new HashMap<>();

		try {

			List<Path> list = Files.walk(path1, Integer.MAX_VALUE).filter(input -> !input.equals(path1)).toList();

			for (Path path : list) {
				map.put(path.subpath(path1.getNameCount(), path.getNameCount()),
						Files.readAttributes(path, BasicFileAttributes.class).size());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static Map<Path, Long> file2PathAndSizeToMap() {

		Map<Path, Long> map = new HashMap<>();

		try {

			List<Path> list = Files.walk(path2, Integer.MAX_VALUE).filter(input -> !input.equals(path2)).toList();

			for (Path path : list) {
				map.put(path.subpath(path2.getNameCount(), path.getNameCount()),
						Files.readAttributes(path, BasicFileAttributes.class).size());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static Path checkForFile(Path inputPath) {

		Path path = inputPath;

		if (Files.exists(inputPath)) {
			try {

				List<Path> pathList = Files.list(inputPath).collect(Collectors.toList());

				if (pathList.size() == 1) {
					path = pathList.get(0);
					if (!Files.isDirectory(path)) {
						valid = false;
					}
				} else {
					valid = false;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			valid = false;
		}

		return path;
	}

	public static boolean isValid() {
		return valid;
	}
}
