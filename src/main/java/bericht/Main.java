package bericht;

import com.krankenhausjakarta.servlet.DBConnection;

import java.io.*;
import java.util.zip.*;
import java.net.URL;
import java.util.zip.ZipEntry;

public class Main {
    public static <ZipFile> void main(String[] args) throws IOException {
        DBConnection.getConnect();

        URL whatismyip = new URL("http://checkip.amazonaws.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        String ip = in.readLine();
        System.out.println(ip);


                // Specify the path to your zip file
                String zipFilePath = "src/main/java/bericht/export_alldata.zip";

                try {
                    // Open an input stream for the zip file
                    FileInputStream fis = new FileInputStream(zipFilePath);
                    ZipInputStream zis = new ZipInputStream(fis);

                    ZipEntry entry;
                    // Iterate over each entry in the zip file
                    while ((entry = zis.getNextEntry()) != null) {
                        // If the entry is a directory, just print its name
                        if (entry.isDirectory()) {
                            System.out.println("Directory: " + entry.getName());
                        } else {
                            // If the entry is a file, print its name and size
                            System.out.println("File: " + entry.getName() + ", Size: " + entry.getSize());

                            // Read the content of the file
                            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = zis.read(buffer)) != -1) {
                                outputStream.write(buffer, 0, bytesRead);
                            }
                            // Print the content of the file
                            System.out.println(outputStream.toString());

                            // Close the output stream
                            outputStream.close();
                        }
                        // Close the current entry
                        zis.closeEntry();
                    }
                    // Close the zip input stream
                    zis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


}

