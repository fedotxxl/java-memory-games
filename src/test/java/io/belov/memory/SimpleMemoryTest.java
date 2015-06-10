package io.belov.memory;

import com.stackcare.io.SimpleTempFileProvider;
import org.junit.Test;

/**
 * Created by fbelov on 11.06.15.
 */
public class SimpleMemoryTest {

    MemoryConsumer mConsumer = new MemoryConsumer();

    @Test
    public void testConsumer() {
        int i = 1;
        int j = 1000;

        while (i < j) {

            mConsumer.consume(i, () -> {});
            i++;
        }
    }

    @Test
    public void testSimpleFileDownloader() {
        SimpleFileDownloader downloader = new SimpleFileDownloader();
        String url = "http://localhost:8000/skype-ubuntu-precise_4.3.0.37-1_i386.deb";

//        for (int i = 1; i < 1000; i++) {
            mConsumer.consume(500, () -> {
                downloader.download(url, SimpleTempFileProvider.INSTANCE.createTempFile());
            });
//        }
    }

}
