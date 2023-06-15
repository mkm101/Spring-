package Hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {

        return instance;
    }

    private SingletonService() {} // 외부클래스에서 싱글톤 서비스 객체를 생성할수없다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출완료");
    }


    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }
}
