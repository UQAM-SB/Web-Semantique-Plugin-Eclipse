package ca.uqam.tool.external.jsoop;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class SearchExample {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "querytext=Héon");
		Request request = new Request.Builder()
				.url("http://192.168.7.23:8080/vivo/search")
				.method("POST", body)
				.addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.addHeader("Accept-Language", "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Origin", "http://http://192.168.7.23:8080")
				.addHeader("Connection", "keep-alive")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.build();

		Response response = client.newCall(request).execute();
		String html = response.body().string();
		Document doc = Jsoup.parse(html);
		System.out.println(html);
		Elements elements = doc.getElementsByClass("searchhits");
		Elements links = elements.select("a[href]");
		for (Iterator iterator = links.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			print(" * %s -> %s", element.attr("href"), element.text());
		}
		System.out.println(links);


	}
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

}
