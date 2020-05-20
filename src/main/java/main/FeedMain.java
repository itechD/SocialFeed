package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;
import signpost.RetrofitHttpOAuthConsumer;
import signpost.SigningOkClient;
import twitter.Tweet;
import twitter.TwitterService;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * Created by aytek.debreli on 2015-08-10.
 */
public class FeedMain {


public static void main(String[] args){

    RetrofitHttpOAuthConsumer oAuthConsumer = new RetrofitHttpOAuthConsumer("","");
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    RestAdapter restAdapter  = new RestAdapter.Builder().setEndpoint("https://api.twitter.com/").setClient(new SigningOkClient(oAuthConsumer)).setConverter(new GsonConverter(gson)).
    build();

    TwitterService twitterService = restAdapter.create(TwitterService.class);


    Observable<List<Tweet>> tweets = twitterService.getTweets("NickHolmesPL");

   tweets.subscribe(tweet -> tweet.stream().map(Tweet::getText).forEach(System.out::println));

}

    private static <T, U, R> Function<U, R> curry(BiFunction<T, U, R> f, T t) {
        return u -> f.apply(t, u);
    }
}
