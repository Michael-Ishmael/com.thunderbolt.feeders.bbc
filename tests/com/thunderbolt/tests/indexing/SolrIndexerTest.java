package com.thunderbolt.tests.indexing;

import com.thunderbolt.Clip;
import com.thunderbolt.indexing.SolrIndexer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SolrIndexerTest {

  private SolrIndexer _solrIndexer;

  @Before
  public void setUp() throws Exception {
    _solrIndexer = new SolrIndexer();
  }

  @Test
  public void testGetClipXml() throws Exception {

    Clip clip1 = new Clip();
    clip1.setTitle("Test Title 1");
    clip1.setBody("Test Content 1");
    clip1.getLinks().add("Test Link a1");
    clip1.getLinks().add("Test Link b1");
    clip1.getTags().add("Test Tag a1");
    clip1.getTags().add("Test Tag b1");
    clip1.setUrl("http://www.bbc.co.uk/news/uk-25618080");

    Clip clip2 = new Clip();
    clip2.setTitle("Test Title 2");
    clip2.setBody("Test Content 2");
    clip2.getLinks().add("Test Link a2");
    clip2.getLinks().add("Test Link b2");
    clip2.getTags().add("Test Tag a2");
    clip2.getTags().add("Test Tag b2");
    clip2.setUrl("http://www.bbc.co.uk/news/uk-25618081");

    ArrayList<Clip> clips = new ArrayList<Clip>();
    clips.add(clip1);
    clips.add(clip2);

    boolean indexed = _solrIndexer.indexClips(clips);

    assertEquals(true, indexed);
  }
}
