package SSAFY;

public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new Movie(1, "윈브레", "니이사토루","액션", 150);
        Movie m2 = new Movie(2, "하이큐", "후루다테하루이치","스포츠", 150);
        Movie m3 = new Movie(3, "쓰결", "훌닽","스포츠", 120);

        SeriesMovie sm1 = new SeriesMovie(4, "하땅", "훑닽", "드라마", 120, 3, "개쩌는 감동");
        SeriesMovie sm2 = new SeriesMovie(5, "명탐정코난", "고쇼", "추리", 120, 17, "보러가야되는데");

        MovieManager mm = new MovieManager();

        // 1. 영화 추가
        mm.add(m1);
        mm.add(m2);
        mm.add(m3);
        mm.add(sm1);
        mm.add(sm2);

        // 2. 영화 조회
        Movie [] resultGetList = mm.getList();
        if (resultGetList != null) {
            for (Movie m : resultGetList) {
                System.out.println(m);
            }
        } else {
            System.out.println("유감.");
        }

        
        // 3. 일반 영화 가져오기
        Movie [] resultGetMovies = mm.getMovies();
        if (resultGetMovies != null) {
            for (Movie m : resultGetMovies) {
                System.out.println(m);
            }
        } else {
            System.out.println("유감.");
        }

        // 4. 시리즈 영화 가져오기
        Movie [] resultGetSeriseMovies = mm.getSeriresMovies();
        if (resultGetSeriseMovies != null) {
            for (Movie m : resultGetSeriseMovies) {
                System.out.println(m);
            }
        } else {
            System.out.println("유감.");
        }

        // 5. 제목으로 검색하기
        String title = "윈브레";
        Movie [] resultSearchByTitle = mm.searchByTitle(title);
        if (resultSearchByTitle != null) {
            for (Movie m : resultSearchByTitle) {
                System.out.println(m);
            }
        } else {
            System.out.println("유감");
        }

        // 6. 러닝타임 평균 구하기
        double resultRunningTimeAvg = mm.getRunningTimeAvg();
        if (resultRunningTimeAvg == 0) {
            System.out.println("유감.");
        } else {
            System.out.println("영화 상영 시간 평균 : "+resultRunningTimeAvg);
        }

    }
}
