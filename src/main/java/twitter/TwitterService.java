package twitter;

import retrofit.http.*;
import rx.Observable;

import java.util.List;
import java.util.function.Function;

/**
 * Created by aytek.debreli on 2015-08-10.
 */
public interface TwitterService {

    @Headers({ "Content-Type: application/json"})
    @GET("/1.1/statuses/user_timeline.json")
    Observable<List<Tweet>> getTweets(@Query("screen_name")String screenName);
}
