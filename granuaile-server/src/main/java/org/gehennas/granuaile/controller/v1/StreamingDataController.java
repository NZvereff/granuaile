package org.gehennas.granuaile.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

@RestController
@RequestMapping("/stream")
public class StreamingDataController {

    @RequestMapping(value = "/audio/mp3", method = RequestMethod.GET)
    public StreamingResponseBody stream()
            throws FileNotFoundException {
        final InputStream inputStream = new FileInputStream("F:\\coding\\1.mp3");
        return (os) -> {
            readAndWrite(inputStream, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }
}
