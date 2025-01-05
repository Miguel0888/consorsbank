package consorsbank.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CertUtil {

    public static File createCertFile(String certContent) throws IOException {
        // Schreibe das Zertifikat in eine temporäre Datei
        File tempFile = File.createTempFile("cert", ".pem");
        tempFile.deleteOnExit(); // Lösche die Datei automatisch nach Beenden des Programms
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(certContent);
        }
        return tempFile;
    }
}
