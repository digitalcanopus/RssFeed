package com.example.rss;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import java.util.ArrayList;

public class DataFormatter {
    private static final String TAG = "DataFormatter";
    ArrayList<RssFeed> feedData;

    public DataFormatter() {
        feedData = new ArrayList<>();
    }

    public ArrayList<RssFeed> getFeedData() {
        return feedData;
    }

    public boolean format(String s) {
        boolean status = true;
        boolean inItem = false;
        RssFeed cData = null;
        String value = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(s));
            int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String tName = parser.getName();

                switch (event) {
                    case XmlPullParser.START_TAG:
                        if ("item".equalsIgnoreCase(tName)) {
                            inItem = true;
                            cData = new RssFeed();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        value = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inItem) {
                            if ("item".equalsIgnoreCase(tName)) {
                                inItem = false;
                                feedData.add(cData);
                            }
                            else if ("title".equalsIgnoreCase(tName)) {
                                cData.setTitle(value);
                            }
                            else if ("description".equalsIgnoreCase(tName)) {
                                cData.setDescription(value);
                            }
                            else if ("pubdate".equalsIgnoreCase(tName)) {
                                cData.setPubdate(value);
                            }
                        }
                        break;
                }
                event = parser.next();
            }
        }
        catch (Exception e) {
            Log.d(TAG, "format: " + e);
            status = false;
        }

        return status;
    }
}
