import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "XATctbEZPg33ByCbR8XyTwQvB";
    private final static String CONSUMER_KEY_SECRET = "IJ152mO8uwd1Szb0BS2qYanAMdoEpHaEgl0xMO0OBaVQfo32VM";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "NnF4jJtsW0b689F3dR1TlaMaVGGCOPx64Zu1rEKwYaJkt";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1143046038640402432-iaqWMmVw9eVh3mQQ7xvrhLi5YUpZob";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}