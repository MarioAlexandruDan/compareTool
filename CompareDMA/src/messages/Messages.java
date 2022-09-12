package messages;

import processes.FileProcessing;

public class Messages {

	public static String startMessage() {

		String message = " This program compares 2 files to determine which files were added and which files were modified!";

		return message;
	}

	public static String tipMessage() {

		String message = " Tips for 100% accurate test: " + "\n"
				+ " 1) Use the following command in cmd for copying the files in File1 & File2 :" + "\n"
				+ " \"ROBOCOPY \"File1 path\" \"File2 path\" /MIR /COPY:DAT /DCOPY:T\"" + "\n"
				+ " 2) If you make some changes to an common file, you should have the same \"Date"
				+ " modified\" on both directories and subdirectories. " + "\n"
				+ " You can achive this by using the same command in cmd from \"1) Tip\" for copying the files"
				+ " before doing any changes to the original file." + "\n"
				+ " 3) Inside \"File1\" Should be the original file and in \"File2\" should be the comparison file."
				+ "\n" + " 4) If you don't want to copy your files into \"File1\" & \"File2\" you need to provide the"
				+ "\n"
				+ " path to each file in \"FileLoading.file1ContentsToMap()\" & \"FileLoading.file2ContentsToMap()\"."
				+ " I suggest using the absolute path";

		return message;
	}

	public static String file1Message() {

		String message = " File1: ";

		return message;
	}

	public static String file2Message() {

		String message = " File2: ";

		return message;
	}

	public static String filesExistsMessage() {

		String message = " Both files Exists and are directories!";

		return message;
	}

	public static String newFilesMessage() {

		String message = " The number of new files created are: " + FileProcessing.getNewFilesCounter() + " {";

		return message;
	}

	public static String modifiedFilesMessage() {

		String message = " The number of modified files are: " + FileProcessing.getModifiedFilesCounter() + " {";

		return message;
	}

	public static String errorMessage() {

		String message = " There has been a critical error! Be sure you meet the following requirement:" + "\n"
				+ " -Have only one directory in File1 & File2 with the same name.";

		return message;
	}
}
