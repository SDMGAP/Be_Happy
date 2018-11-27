package behappy.buildappswithpaulo.com.behappy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import behappy.buildappswithpaulo.com.behappy.data.QuoteData;
import behappy.buildappswithpaulo.com.behappy.data.QuoteListAsyncResponse;
import behappy.buildappswithpaulo.com.behappy.data.QuoteViewPagerAdpater;
import behappy.buildappswithpaulo.com.behappy.model.Quote;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdpater quoteViewPagerAdpater;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdpater = new QuoteViewPagerAdpater(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdpater);


    }


    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();
        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                             quotes.get(i).getQuote(),
                             quotes.get(i).getAuthor()
                    );
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdpater.notifyDataSetChanged();/// very important!!

            }
        });




        return fragmentList;
    }
}
