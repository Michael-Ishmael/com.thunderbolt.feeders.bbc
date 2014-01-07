package com.thunderbolt;


import java.util.Date;

public class Clip {

  private String _title;
  private String _body;
  private Date _issueDate;
  private String _author;

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
}
