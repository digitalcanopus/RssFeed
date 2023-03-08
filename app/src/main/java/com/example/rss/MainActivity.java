package com.example.rss;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main activity";
    String Url = "https://feeds.simplecast.com/54nAGcIl";

    String xmlData = "<rss xmlns:atom=\"http://www.w3.org/2005/Atom\" xmlns:content=\"http://purl.org/rss/1.0/modules/content/\" xmlns:googleplay=\"http://www.google.com/schemas/play-podcasts/1.0\" xmlns:itunes=\"http://www.itunes.com/dtds/podcast-1.0.dtd\" version=\"2.0\">\n" +
            "<channel>\n" +
            "<atom:link href=\"https://feeds.simplecast.com/54nAGcIl\" rel=\"self\" title=\"MP3 Audio\" type=\"application/atom+xml\"/>\n" +
            "<atom:link xmlns=\"http://www.w3.org/2005/Atom\" href=\"https://simplecast.superfeedr.com/\" rel=\"hub\"/>\n" +
            "<generator>https://simplecast.com</generator>\n" +
            "<title>The Daily</title>\n" +
            "<description>This is what the news should sound like. The biggest stories of our time, told by the best journalists in the world. Hosted by Michael Barbaro and Sabrina Tavernise. Twenty minutes a day, five days a week, ready by 6 a.m.</description>\n" +
            "<copyright>© 2020-2021 THE NEW YORK TIMES COMPANY; The New York Times encourages the use of RSS feeds for personal use in a news reader or as part of a non-commercial blog, subject to your agreement to our Terms of Service.</copyright>\n" +
            "<language>en</language>\n" +
            "<pubDate>Wed, 8 Mar 2023 10:45:00 +0000</pubDate>\n" +
            "<lastBuildDate>Wed, 8 Mar 2023 11:13:47 +0000</lastBuildDate>\n" +
            "<image>\n" +
            "<link>https://www.nytimes.com/the-daily</link>\n" +
            "<title>The Daily</title>\n" +
            "<url>https://image.simplecastcdn.com/images/03d8b493-87fc-4bd1-931f-8a8e9b945d8a/2cce5659-f647-4366-b318-46e4b67afcfa/3000x3000/c81936f538106550b804e7e4fe2c236319bab7fba37941a6e8f7e5c3d3048b88fc5b2182fb790f7d446bdc820406456c94287f245db89d8656c105d5511ec3de.jpeg?aid=rss_feed</url>\n" +
            "</image>\n" +
            "<link>https://www.nytimes.com/the-daily</link>\n" +
            "<itunes:type>episodic</itunes:type>\n" +
            "<itunes:summary>This is what the news should sound like. The biggest stories of our time, told by the best journalists in the world. Hosted by Michael Barbaro and Sabrina Tavernise. Twenty minutes a day, five days a week, ready by 6 a.m.</itunes:summary>\n" +
            "<itunes:author>The New York Times</itunes:author>\n" +
            "<itunes:explicit>no</itunes:explicit>\n" +
            "<itunes:image href=\"https://image.simplecastcdn.com/images/03d8b493-87fc-4bd1-931f-8a8e9b945d8a/2cce5659-f647-4366-b318-46e4b67afcfa/3000x3000/c81936f538106550b804e7e4fe2c236319bab7fba37941a6e8f7e5c3d3048b88fc5b2182fb790f7d446bdc820406456c94287f245db89d8656c105d5511ec3de.jpeg?aid=rss_feed\"/>\n" +
            "<itunes:new-feed-url>https://feeds.simplecast.com/54nAGcIl</itunes:new-feed-url>\n" +
            "<itunes:owner>\n" +
            "<itunes:name>The New York Times</itunes:name>\n" +
            "<itunes:email>thedaily@nytimes.com</itunes:email>\n" +
            "</itunes:owner>\n" +
            "<itunes:category text=\"News\">\n" +
            "<itunes:category text=\"Daily News\"/>\n" +
            "</itunes:category>\n" +
            "<item>\n" +
            "<guid isPermaLink=\"false\">441bddd3-1374-4a1c-9b1a-e8c51da6efb5</guid>\n" +
            "<title>Who Blew Up the Nord Stream Pipelines?</title>\n" +
            "<description>\n" +
            "<![CDATA[ <p>The sabotage in September of the Nord Stream pipelines carrying Russian gas to Europe has become one of the central mysteries of the war in Ukraine, prompting months of finger-pointing and guesswork.</p><p>Now, new intelligence reporting has provided the first significant known lead about who was responsible.</p><p>Guest: <a href=\"https://www.nytimes.com/by/julian-e-barnes\">Julian E. Barnes</a>, a national security correspondent for The New York Times.</p><p>Background reading: </p><ul><li>Officials say there are still enormous gaps in what American spy agencies and their European partners know about<a href=\"https://www.nytimes.com/2023/03/07/us/politics/nord-stream-pipeline-sabotage-ukraine.html\"> the detonations</a>.</li><li>The Baltic seabed provided a nearly<a href=\"https://www.nytimes.com/2022/12/26/world/europe/nordstream-pipeline-explosion-russia.html\"> ideal crime scene</a>.</li></ul><p>For more information on today’s episode, visit <a href=\"http://nytimes.com/thedaily?smid=pc-thedaily\">nytimes.com/thedaily</a>. Transcripts of each episode will be made available by the next workday.</p> ]]>\n" +
            "</description>\n" +
            "<pubDate>Wed, 8 Mar 2023 10:45:00 +0000</pubDate>\n" +
            "<author>thedaily@nytimes.com (The New York Times)</author>\n" +
            "<link>https://www.nytimes.com/the-daily</link>\n" +
            "<content:encoded>\n" +
            "<![CDATA[ <p>The sabotage in September of the Nord Stream pipelines carrying Russian gas to Europe has become one of the central mysteries of the war in Ukraine, prompting months of finger-pointing and guesswork.</p><p>Now, new intelligence reporting has provided the first significant known lead about who was responsible.</p><p>Guest: <a href=\"https://www.nytimes.com/by/julian-e-barnes\">Julian E. Barnes</a>, a national security correspondent for The New York Times.</p><p>Background reading: </p><ul><li>Officials say there are still enormous gaps in what American spy agencies and their European partners know about<a href=\"https://www.nytimes.com/2023/03/07/us/politics/nord-stream-pipeline-sabotage-ukraine.html\"> the detonations</a>.</li><li>The Baltic seabed provided a nearly<a href=\"https://www.nytimes.com/2022/12/26/world/europe/nordstream-pipeline-explosion-russia.html\"> ideal crime scene</a>.</li></ul><p>For more information on today’s episode, visit <a href=\"http://nytimes.com/thedaily?smid=pc-thedaily\">nytimes.com/thedaily</a>. Transcripts of each episode will be made available by the next workday.</p> ]]>\n" +
            "</content:encoded>\n" +
            "<enclosure length=\"21180665\" type=\"audio/mpeg\" url=\"https://dts.podtrac.com/redirect.mp3/chrt.fm/track/8DB4DB/pdst.fm/e/pfx.vpixl.com/6qj4J/nyt.simplecastaudio.com/03d8b493-87fc-4bd1-931f-8a8e9b945d8a/episodes/2ccd20e0-7d75-4988-8986-f80f9c2a7934/audio/128/default.mp3?aid=rss_feed&awCollectionId=03d8b493-87fc-4bd1-931f-8a8e9b945d8a&awEpisodeId=2ccd20e0-7d75-4988-8986-f80f9c2a7934&feed=54nAGcIl\"/>\n" +
            "<itunes:title>Who Blew Up the Nord Stream Pipelines?</itunes:title>\n" +
            "<itunes:author>The New York Times</itunes:author>\n" +
            "<itunes:duration>00:22:03</itunes:duration>\n" +
            "<itunes:summary>The sabotage in September of the Nord Stream pipelines carrying Russian gas to Europe has become one of the central mysteries of the war in Ukraine, prompting months of finger-pointing and guesswork. Now, new intelligence reporting has provided the first significant known lead about who was responsible. Guest: Julian E. Barnes, a national security correspondent for The New York Times.</itunes:summary>\n" +
            "<itunes:subtitle>The sabotage in September of the Nord Stream pipelines carrying Russian gas to Europe has become one of the central mysteries of the war in Ukraine, prompting months of finger-pointing and guesswork. Now, new intelligence reporting has provided the first significant known lead about who was responsible. Guest: Julian E. Barnes, a national security correspondent for The New York Times.</itunes:subtitle>\n" +
            "<itunes:explicit>no</itunes:explicit>\n" +
            "<itunes:episodeType>full</itunes:episodeType>\n" +
            "</item>\n" +
            "</channel>\n" +
            "</rss>";
    String fileName = "file.xml";

    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls = findViewById(R.id.feedlist);
        //downloadUrl(Url);
    }

    public void downloadUrl(String url) {
        RssHelper helper = new RssHelper();
        helper.execute(url);
    }

    public void xmlWrite() {
        try {
            File xmlFile = new File(getExternalFilesDir(null), fileName);
            FileWriter fileWriter = new FileWriter(xmlFile);
            fileWriter.write(xmlData);
            fileWriter.close();
            Log.d(TAG, "XML file has been created successfully!");
        } catch (IOException e) {
            Log.d(TAG, "Error while creating XML file: " + e.getMessage());
        }
    }

    private class RssHelper extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            DataFormatter formatter = new DataFormatter();
            if (formatter.format(s)) {
                ArrayAdapter<RssFeed> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.adaptlist, formatter.getFeedData());
                ls.setAdapter(adapter);

                ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Bundle bundle = new Bundle();
                        bundle.putString("head", formatter.getFeedData().get(position).getTitle());
                        bundle.putString("sum", formatter.getFeedData().get(position).getDescription());

                        Intent i = new Intent(MainActivity.this, Descript.class);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });
            }
            else {
                Log.d(TAG, "onPostExecute: formatter failed");
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            return downloadData(strings[0]);
        }

        public String downloadData(String address) {
            StringBuilder data = new StringBuilder();
            try {
                URL url = new URL(address);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                Log.d(TAG, "downloadData: response code " + connect.getResponseCode());

                BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    data.append(line);
                }
                reader.close();
            }
            catch (Exception e) {
                Log.d(TAG, "downloadData: " + e);
            }

            return data.toString();
        }
    }
}