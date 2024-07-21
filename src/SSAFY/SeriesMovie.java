package SSAFY;

public class SeriesMovie extends Movie{
    private int seriresNum;
    private String episode;

    public SeriesMovie() {
        super();
    }

    public SeriesMovie(int id, String title, String director, String genre,
                       int runningtime, int seriresNum, String episode) {
        super(id, title, director, genre, runningtime);
        this.seriresNum = seriresNum;
        this.episode = episode;
    }

    public int getSeriresNum() {
        return seriresNum;
    }

    public void setSeriresNum(int seriresNum) {
        this.seriresNum = seriresNum;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "Series Movie"+getId() + "	|	" + getTitle() + "	|	" + getDirector() + "	|	" + getGenre()
                + "	|	" + getRunningTime() + "	|	"+ seriresNum + "	|	" + episode;
    }
}
