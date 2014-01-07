package com.thunderbolt.scraping;


import com.thunderbolt.Clip;
import com.thunderbolt.queueing.ClipMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsScraper {

  public Clip scrapeOutClip(ClipMessage link) {

    Document doc = null;
    try {
      doc = Jsoup.connect(link.getUrl()).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Elements content = doc.select(".story-body");
    Clip clip = new Clip();
    clip.setBody(content.first().html());
    return clip;
  }

}
