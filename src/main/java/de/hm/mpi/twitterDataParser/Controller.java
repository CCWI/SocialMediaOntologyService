package de.hm.mpi.twitterDataParser;

import java.util.List;

import de.hm.mpi.twitterDataParser.nlp.Triplet;
import de.hm.mpi.twitterDataParser.nlp.TweetParser;
import de.hm.mpi.twitterDataParser.relational.RelationalEntry;
import de.hm.mpi.twitterDataParser.relational.RelationalParser;

public class Controller {

	public static void main(final String[] args) {

		// #1 parse relational Data
		List<RelationalEntry> twitterResults = new RelationalParser()
				.parseRelationalExportedData("src/main/resources/tweet_sample_no_RT_EN_100000.csv");

		// #2 nlp on data
		TweetParser tweetParser = new TweetParser();
		for (RelationalEntry entry : twitterResults) {
			List<Triplet<String, String, String>> tweetTextTripleList = tweetParser.parseTextToTripletList(entry);

			// #3 create rdf
			if (tweetTextTripleList != null && !tweetTextTripleList.isEmpty()) {
				for (Triplet<String, String, String> tweetTriple : tweetTextTripleList) {
					System.out.println("SPO-Analyseergebnis für tweet: " + entry.getTweet_id() + " - Subjekt: "
							+ tweetTriple.getSubject() + ", Verb: " + tweetTriple.getVerb() + ", Object: "
							+ tweetTriple.getObject());
				}
			}
		}
	}
}
