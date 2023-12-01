package model.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GestorArchivos {
	public static void copyInputStreamToFile(InputStream inputStream, File file) {
		try(FileOutputStream archivoBinario = new FileOutputStream(file)) {
			byte[] bytes = inputStream.readAllBytes();
			archivoBinario.write(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
