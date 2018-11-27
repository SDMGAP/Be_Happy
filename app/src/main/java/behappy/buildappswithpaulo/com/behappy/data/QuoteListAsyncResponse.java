package behappy.buildappswithpaulo.com.behappy.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

import behappy.buildappswithpaulo.com.behappy.model.Quote;

/**
 * Created by paulodichone on 11/8/17.
 */

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
