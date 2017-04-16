package de.hm.mpi.twitterDataParser.nlp;

public class Triplet<T, U, V> {

	private final T subject;
	private final U verb;
	private final V object;

	public Triplet(T subject, U verb, V object) {
		this.subject = subject;
		this.verb = verb;
		this.object = object;
	}

	public T getSubject() {
		return subject;
	}

	public U getVerb() {
		return verb;
	}

	public V getObject() {
		return object;
	}
}