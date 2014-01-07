package com.thunderbolt.scraping;

import com.thunderbolt.Clip;
import com.thunderbolt.queueing.ClipMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsScraperTest {

  private NewsScraper _newsScraper;

  @Before
  public void setUp() throws Exception {

    _newsScraper = new NewsScraper();
  }

  @Test
  public void testScrapeOutClip() throws Exception {

    ClipMessage message = new ClipMessage();
    message.setUrl("http://www.bbc.co.uk/news/uk-25618080");

    Clip clip = _newsScraper.scrapeOutClip(message);

    assertEquals("", clip.getBody());

  }
}
