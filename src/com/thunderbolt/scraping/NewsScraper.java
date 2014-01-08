package com.thunderbolt.scraping;


import com.thunderbolt.Clip;
import com.thunderbolt.queueing.ClipMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class NewsScraper {

  public Clip scrapeOutClip(ClipMessage link) {

    Document doc = null;
    try {
      doc = Jsoup.connect(link.getUrl()).get();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Clip clip = new Clip();
    clip.setUrl(doc.location());
    clip.setTitle(getElementContent(doc, ".story-header"));
    clip.setBody(getAsParagraphs(doc, ".story-body p, .story-body ul"));
    clip.setIssueDate(getClipDate(doc));
    return clip;
  }

  private String getElementContent(Document doc, String selector) {
    Element content = doc.select(selector).first();
    if (content != null) {
      return content.html();
    }
    return "";
  }

  private Date getClipDate(Document doc) {
    String dateString = getElementContent(doc, ".story-date .date");
    String timeString = " " + getElementContent(doc, ".story-date .time");
    DateFormat df = new SimpleDateFormat("dd MMMM yyyy kk:mm:ss z", Locale.ENGLISH);
    try {
      Date issueDate = df.parse(dateString + " " + timeString);
      return issueDate;
    } catch (ParseException e) {
      return null;
    }

  }

  private String getAsParagraphs(Document doc, String selector) {

    Elements paragraphs = doc.select(selector);
    StringBuilder sb = new StringBuilder();
    boolean first = true;

    for (Iterator<Element> i = paragraphs.iterator(); i.hasNext(); ) {
      if (!first) {
        sb.append("\r\r");
      } else {
        first = false;
      }
      Element el = i.next();
      sb.append(el.toString());

    }

    return sb.toString();
  }


}
