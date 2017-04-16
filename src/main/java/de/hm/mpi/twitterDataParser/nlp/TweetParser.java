package de.hm.mpi.twitterDataParser.nlp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import de.hm.mpi.twitterDataParser.relational.RelationalEntry;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.EnglishGrammaticalRelations;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;

public class TweetParser {

	private Properties properties;
	private StanfordCoreNLP pipeline;
	private Annotation document;
	List<Triplet<String, String, String>> tripletList;

	/**
	 * Default-Constructor
	 */
	public TweetParser() {
		properties = new Properties();
		properties.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
		pipeline = new StanfordCoreNLP(properties);
	}

	/**
	 * Analyze a Text on SPO-Triples.
	 * @param entry
	 * @return
	 */
	public List<Triplet<String, String, String>> parseTextToTripletList(RelationalEntry entry) {
		if (entry.getTweetText() != null) {
			if (entry.getTweetText() != "" && !entry.getTweetText().isEmpty()) {

				validateText(entry);

				this.document = new Annotation(entry.getTweetText());
				this.pipeline.annotate(document);

				List<CoreMap> sentences = this.document.get(SentencesAnnotation.class);

				tripletList = new ArrayList<Triplet<String, String, String>>();

				for (CoreMap sentence : sentences) {
					Tree t = sentence.get(TreeAnnotation.class);

					TreebankLanguagePack languagePack = new PennTreebankLanguagePack();
					GrammaticalStructure structure = languagePack.grammaticalStructureFactory()
							.newGrammaticalStructure(t);
					Collection<TypedDependency> typedDependencies = structure.typedDependenciesCollapsed();
					List<TypedDependency> sPOList = new ArrayList<TypedDependency>();

					for (TypedDependency td : typedDependencies) {
						if (td.reln().equals(EnglishGrammaticalRelations.SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.NOMINAL_SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.CLAUSAL_SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.CONTROLLING_SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.CLAUSAL_PASSIVE_SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.NOMINAL_PASSIVE_SUBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.OBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.DIRECT_OBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.INDIRECT_OBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.PREPOSITIONAL_OBJECT)
								|| td.reln().equals(EnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE)) {
							sPOList.add(td);
							// System.out.println(td.reln() + " - " + td.gov() +
							// " -
							// " +
							// td.dep());
						}
					}
					analyzeSPOList(sPOList);
				}
			}
		}
		return tripletList;
	}

	private void analyzeSPOList(List<TypedDependency> sPOList) {

		for (TypedDependency td1 : sPOList) {
			Boolean tripleFound = false;
			if (td1.reln().equals(EnglishGrammaticalRelations.SUBJECT)
					|| td1.reln().equals(EnglishGrammaticalRelations.NOMINAL_SUBJECT)
					|| td1.reln().equals(EnglishGrammaticalRelations.CLAUSAL_SUBJECT)
					|| td1.reln().equals(EnglishGrammaticalRelations.CONTROLLING_SUBJECT)
					|| td1.reln().equals(EnglishGrammaticalRelations.CLAUSAL_PASSIVE_SUBJECT)
					|| td1.reln().equals(EnglishGrammaticalRelations.NOMINAL_PASSIVE_SUBJECT)) {
				for (TypedDependency td2 : sPOList) {
					if ((td2.reln().equals(EnglishGrammaticalRelations.OBJECT)
							|| td2.reln().equals(EnglishGrammaticalRelations.DIRECT_OBJECT)
							|| td2.reln().equals(EnglishGrammaticalRelations.INDIRECT_OBJECT)
							|| td2.reln().equals(EnglishGrammaticalRelations.PREPOSITIONAL_OBJECT))
							&& td1.gov() == td2.gov()) {
						for (TypedDependency td3 : sPOList) {
							if (td3.reln().equals(EnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE)
									&& td1.gov() == td3.gov()) {
								tripleFound = true;
								tripletList.add(new Triplet<String, String, String>(td1.dep().value(),
										td2.gov().value() + " " + td3.dep().value(), td2.dep().value()));
							}
						}
						if (tripleFound == false) {
							tripletList.add(new Triplet<String, String, String>(td1.dep().value(), td2.gov().value(),
									td2.dep().value()));
						}
					}
				}
			}
		}
	}

	private static void validateText(RelationalEntry entry) {
		if (entry.getTweetText().charAt(entry.getTweetText().length() - 1) != '.') {
			entry.setTweetText(entry.getTweetText() + ".");
		}
	}

}
