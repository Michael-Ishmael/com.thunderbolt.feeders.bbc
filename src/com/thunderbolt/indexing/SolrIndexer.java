package com.thunderbolt.indexing;

import com.thunderbolt.Clip;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolrIndexer {

  public boolean indexClips(List<Clip> clips) throws IOException, SolrServerException {
    ;
    return indexToSolr(convertClipsToDocuments(clips));
  }

  private List<SolrInputDocument> convertClipsToDocuments(List<Clip> clips) {

    List<SolrInputDocument> documents = new ArrayList<>();
    clips.forEach((c) -> documents.add(convertClipToDocument(c)));
    return documents;

  }

  private SolrInputDocument convertClipToDocument(Clip clip) {
    SolrInputDocument doc = new SolrInputDocument();
    doc.addField("id", clip.getId());
    if (clip.getHostName() != null) doc.addField("host", clip.getHostName());
    if (clip.getUrl() != null) doc.addField("url", clip.getUrl());
    if (clip.getBody() != null) doc.addField("content", clip.getBody());
    if (clip.getTitle() != null) doc.addField("title", clip.getTitle());
    if (clip.getLinks() != null) doc.addField("anchor", clip.getLinks());
    if (clip.getMediaType() != null) doc.addField("mediaType", clip.getMediaType());
    if (clip.getContentLength() > 0) doc.addField("contentLength", clip.getContentLength());
    if (clip.getDateCreated() != null) doc.addField("dateCreated", clip.getDateCreated());
    if (clip.getLang() != null) doc.addField("lang", clip.getLang());
    if (clip.getCountry() != null) doc.addField("country", clip.getCountry());
    if (clip.getAuthor() != null) doc.addField("author", clip.getAuthor());
    if (clip.getTags() != null) doc.addField("tag", clip.getTags());
    if (clip.getFeed() != null) doc.addField("feed", clip.getFeed());
    return doc;
  }

  private boolean indexToSolr(List<SolrInputDocument> documents) throws IOException, SolrServerException {

    String urlString = "http://localhost:8080/solr/tbnewsarchive/";
    try {
      SolrServer solr = new HttpSolrServer(urlString);
      UpdateResponse response = solr.add(documents);

      UpdateResponse commitResponse = solr.commit();
      return response.getStatus() == 0;
    } catch (Exception e) {
      System.out.print(e.getMessage());
      return false;
    }
  }


}
