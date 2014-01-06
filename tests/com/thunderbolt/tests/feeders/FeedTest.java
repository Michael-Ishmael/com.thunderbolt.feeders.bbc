package com.thunderbolt.tests.feeders;

import com.thunderbolt.feeders.Feed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michaeli on 06/01/14.
 */
public class FeedTest {

    private Feed _feed;

    @Before
    public void setUp() throws Exception {
        _feed = new Feed("BBC", "Link", "BBC News Feed", "English", "CC", "Today");
    }

    @Test
    public void testGetLatest() throws Exception {
        assertEquals("BBC News Feed", _feed.getDescription());
    }


    @After
    public void tearDown() throws Exception {

    }
}
