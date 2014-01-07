package com.thunderbolt.feeders.bbc;


import com.thunderbolt.feeders.Feed;
import com.thunderbolt.feeders.FeedMessage;
import com.thunderbolt.feeders.FeedReader;
import com.thunderbolt.queueing.ClipMessage;
import com.thunderbolt.queueing.ClipProducer;

public class BBCFeeder {

  private static FeedReader _feedReader;
  private static ClipProducer _clipProducer;

  public static void main(String[] args) throws Exception {

    _feedReader = new FeedReader("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");
    _clipProducer = new ClipProducer();

    Feed feed = _feedReader.readFeed();
    for (FeedMessage message : feed.getMessages()) {
      ClipMessage newClipMessage = convertMessageToClip(message);
      _clipProducer.send(newClipMessage);
    }

  }

  private static ClipMessage convertMessageToClip(FeedMessage message) {

    return new ClipMessage(message.getTitle(), message.getLink(), message.getGuid());

  }
}
