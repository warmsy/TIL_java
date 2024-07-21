package SSAFY;

import java.util.Arrays;

public class MovieManager {
    private final int MAX_SIZE = 100;
    Movie[] movieList = new Movie[MAX_SIZE];
    int size = 0;

    // 영화 추가
    public void add(Movie movie) {
        System.out.println("***** 영화 추가 *****");
        if (size < 100) {
            movieList[size] = movie;
            size++;
            System.out.println(size + "번 등록완료");
        } else {
            System.out.println("저장공간이 가득 찼습니다.");
        }
    }

    // 영화 리스트
    public Movie[] getList() {
        System.out.println("***** 영화 조회 *****");
        if (size == 0) {
            System.out.println("등록된 영화가 없습니다.");
            return null;
        } else return Arrays.copyOf(movieList, size);
    }


    // 일반 영화 리스트 가져오기
    public Movie[] getMovies() {
        System.out.println("***** 일반 영화 조회 *****");
        if (size == 0) {
            System.out.println("등록된 영화가 없습니다.");
            return null;
        }
        Movie[] movies = new Movie[size];
        int cnt = 0;
        for (Movie m : movieList) {
            if (m != null && !(m instanceof SeriesMovie)) {
                // 여기는 후자만 주면 null 도 카운팅 되니까 outBoundError 발생
                // 킹갓제너럴 인텔리제이 디버깅아! 고마워!
                movies[cnt++] = m;
            }
        }
        return Arrays.copyOf(movies, cnt);
    }

    // 시리즈 영화 가져오기
    public SeriesMovie[] getSeriresMovies() {
        System.out.println("***** 시리즈 영화 조회 *****");
        if (size == 0) {
            System.out.println("등록된 영화가 없습니다.");
            return null;
        } else {
            SeriesMovie[] movies = new SeriesMovie[size];
            int cnt = 0;
            for (Movie m : movieList) {
                if (m instanceof SeriesMovie) { // 여기는 SeriesMoive 타입인지 검증하는 부분이라 null이 걸러진거고
                    movies[cnt++] = (SeriesMovie) m;
                }
            }
            return Arrays.copyOf(movies, cnt);
        }
    }

    // 영화 제목 조회
    public Movie[] searchByTitle(String title) {
        System.out.println("*****제목 조회 :" + title + " *****");
        if (size == 0) {
            System.out.println("조회된 영화가 없습니다.");
            return null;
        } else {
            Movie[] movies = new Movie[size];
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                if (movieList[i].getTitle().contains(title)) {
                    movies[cnt++] = movieList[i];
                }
            }
            if (cnt == 0) {
                System.out.println("찾는 영화가 없습니다.");
                return null;
            } else return Arrays.copyOf(movies, cnt);
        }
    }

    // 러닝타임 평균 계산하기
    public double getRunningTimeAvg() {
        System.out.println("***** 러닝타임 평균 *****");
        if (size == 0) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        } else {
            int total = 0;
            for (Movie m : movieList) {
                if (m != null) total += m.getRunningTime();
            }
            return (double) total / size;
        }
    }

}
