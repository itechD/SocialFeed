package signpost;
/*
 * Copyright (C) 2013 Patrik �kerfeldt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

        import java.io.IOException;

        import com.squareup.okhttp.OkHttpClient;
        import oauth.signpost.exception.OAuthCommunicationException;
        import oauth.signpost.exception.OAuthExpectationFailedException;
        import oauth.signpost.exception.OAuthMessageSignerException;
        import org.slf4j.Logger;
        import retrofit.client.OkClient;
        import retrofit.client.Request;
        import retrofit.client.Response;

/**
 * This is a helper class, a {@code retrofit.client.UrlConnectionClient} to use
 * when building your {@code retrofit.RestAdapter}.
 *
 */
public class SigningOkClient extends OkClient {

    private final RetrofitHttpOAuthConsumer mOAuthConsumer;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SigningOkClient.class);

    public SigningOkClient(RetrofitHttpOAuthConsumer consumer) {
        mOAuthConsumer = consumer;
    }

    public SigningOkClient(OkHttpClient client, RetrofitHttpOAuthConsumer consumer) {
        super(client);
        mOAuthConsumer = consumer;
    }

    @Override
    public Response execute(Request request) throws IOException {
        Request requestToSend = request;
        try {
            HttpRequestAdapter signedAdapter = (HttpRequestAdapter) mOAuthConsumer.sign(request);
            requestToSend = (Request) signedAdapter.unwrap();
        } catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
            log.error(e.getMessage(),e);
        }
        return super.execute(requestToSend);
    }

}