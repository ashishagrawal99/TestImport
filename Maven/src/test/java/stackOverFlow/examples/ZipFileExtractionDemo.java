package stackOverFlow.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileExtractionDemo {

	public static String ZipFileExtraction(String fName) throws Exception 
	{

		String entryName=null;
		byte[] buf = new byte[1024];
		ZipInputStream zinstream = new ZipInputStream(new FileInputStream(fName));
		ZipEntry zentry = zinstream.getNextEntry();
		System.out.println("Name of current Zip Entry : " + zentry + "\n");
		while (zentry != null) {
			entryName = zentry.getName();
			System.out.println("Name of  Zip Entry : " + entryName);
			FileOutputStream outstream = new FileOutputStream(entryName);
			int n;

			while ((n = zinstream.read(buf, 0, 1024)) > -1) {
				outstream.write(buf, 0, n);
			}
			System.out.println("Successfully Extracted File Name : "
					+ entryName);
			System.out.println(entryName.length());
			outstream.close();
			zinstream.closeEntry();
			zentry = zinstream.getNextEntry();
		}
		zinstream.close();
		return entryName;
	}

	public static void main(String[] args) throws Exception {

		ZipFileExtractionDemo.ZipFileExtraction("E:\\Softwares\\Jenkin_Bundle.zip");

	}

}
