package twitter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aytek.debreli on 2015-08-10.
 */
public class Tweet {


    @Expose
    private Object coordinates;

    @Expose
    private Boolean favorited;

    @Expose
    private Boolean truncated;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("id_str")
    @Expose
    private String idStr;

    @Expose
    private String text;

    @SerializedName("retweet_count")
    @Expose
    private Integer retweetCount;

    @SerializedName("possibly_sensitive")
    @Expose
    private Boolean possiblySensitive;

    @Expose
    private String source;

    /**
     *
     * @return
     * The coordinates
     */
    public Object getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @param coordinates
     * The coordinates
     */
    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * @return
     * The favorited
     */
    public Boolean getFavorited() {
        return favorited;
    }

    /**
     *
     * @param favorited
     * The favorited
     */
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    /**
     *
     * @return
     * The truncated
     */
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     *
     * @param truncated
     * The truncated
     */
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The idStr
     */
    public String getIdStr() {
        return idStr;
    }

    /**
     *
     * @param idStr
     * The id_str
     */
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }


    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The retweetCount
     */
    public Integer getRetweetCount() {
        return retweetCount;
    }

    /**
     *
     * @param retweetCount
     * The retweet_count
     */
    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }



    /**
     *
     * @return
     * The possiblySensitive
     */
    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    /**
     *
     * @param possiblySensitive
     * The possibly_sensitive
     */
    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }



    /**
     *
     * @return
     * The source
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     * The source
     */
    public void setSource(String source) {
        this.source = source;
    }



}
