package com.Jaroop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikipediaParagraph {
	private final String baseUrl;

	public WikipediaParagraph() {

		this.baseUrl = String.format("http://en.wikipedia.org/wiki/");

	}

	public String displayFirstParagraph(String topicName) throws IOException {

		String url = baseUrl + topicName;

		Document doc = Jsoup.connect(url).get();

		Elements paragraphs = doc.select("p");

		Element firstParagraph = paragraphs.first();

		return firstParagraph.text();

	}
	

	public static void main(String[] args) {
		try {
			char answer;
			String topicName;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Would like to Type Topic for wiki (y/n)? ");
			answer = (char) br.read();
			br.readLine();
			if (answer == 'y') {
				int i = 0;
				System.out.println("Enter the name of the Topic from wiki: ");
				topicName = br.readLine();
				topicName = topicName.replace(' ', '_');
				System.out.println("The name of your Topic  is: " + topicName);
				WikipediaParagraph parser = new WikipediaParagraph();
				String firstParagraph = parser.displayFirstParagraph(topicName);
				System.out.println(firstParagraph);
			}
			else if (answer == 'n') {
				System.out.println("No Topic Type");
			}
		}
		catch (Exception e) {
			System.out.println("Not found");

		}

	}

}