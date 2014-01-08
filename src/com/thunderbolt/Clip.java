package com.thunderbolt;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class Clip {

  private static AtomicInteger _idGenerator;


  private int _id = -1;
  private String _title;
  private String _body;
  private Date _issueDate;
  private String _author;
  private String _url;
  private String _hostName;
  private List<String> _links;
  private List<String> _tags;
  private Date _dateCreated;

  public Clip() {
    _links = new ArrayList<String>();
    _tags = new ArrayList<String>();
    _dateCreated = new Date();
  }

  public static int getNextId() {
    if (_idGenerator == null) {
      int seed = 1;
      try {
        Properties props = new Properties();
        props.load(Clip.class.getResourceAsStream("thunderbolt.properties"));
        seed = Integer.parseInt(props.getOrDefault("lastid", "1").toString());
      } catch (IOException e) {
      }
      _idGenerator = new AtomicInteger(seed);
    }
    return _idGenerator.getAndIncrement();
  }

  public static void stashId() {
    if (_idGenerator != null) {
      Properties props = new Properties();
      try {
        props.load(Clip.class.getResourceAsStream("thunderbolt.properties"));
        props.setProperty("lastid", (new Integer(_idGenerator.intValue())).toString());
      } catch (IOException e) {

      }

    }
  }

  public int getId() {
    if (_id == -1) {
      _id = Clip.getNextId();
    }
    return _id;
  }

  public String getTitle() {
    return _title;
  }

  public void setTitle(String title) {
    _title = title;
  }

  public String getBody() {
    return _body;
  }

  public void setBody(String body) {
    _body = body;
  }

  public Date getIssueDate() {
    return _issueDate;
  }

  public void setIssueDate(Date issueDate) {
    _issueDate = issueDate;
  }

  public String getAuthor() {
    return _author;
  }

  public void setAuthor(String author) {
    _author = author;
  }

  public String getUrl() {
    return _url;
  }

  public void setUrl(String url) {
    _url = url;
  }

  public String getHostName() {
    return _hostName;
  }

  public void setHostName(String hostName) {
    _hostName = hostName;
  }

  public List<String> getLinks() {
    return _links;
  }

  public List<String> getTags() {
    return _tags;
  }

  public String getMediaType() {
    return "News";
  }

  public int getContentLength() {
    return _body.length();
  }

  public String getLang() {
    return "en";
  }

  public String getCountry() {
    return "gb";
  }

  public Date getDateCreated() {
    return _dateCreated;
  }

  public String getFeed() {
    return "BBC";
  }


}
