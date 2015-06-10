package io.belov.memory;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by fbelov on 11.06.15.
 */
public class SimpleFileDownloader {

    private static final Logger log = LoggerFactory.getLogger(SimpleFileDownloader.class);

    public void download(String url, File file) {
        try {
            log.debug("Downloading {} to {}", url, file);

            FileUtils.copyURLToFile(new URL(url), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
