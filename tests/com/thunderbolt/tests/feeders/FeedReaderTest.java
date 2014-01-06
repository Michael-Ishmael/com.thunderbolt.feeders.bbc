package com.thunderbolt.tests.feeders;

import com.thunderbolt.feeders.Feed;
import com.thunderbolt.feeders.FeedMessage;
import com.thunderbolt.feeders.FeedReader;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by michaeli on 06/01/14.
 */
public class FeedReaderTest {

    private FeedReader _feedReader;

    @Before
    public void setUp() throws Exception {
        _feedReader = new FeedReader("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");
    }

    @Test
    public void testReadFeed() throws Exception {
       Feed feed = _feedReader.readFeed();
       for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
       }
    }


}
