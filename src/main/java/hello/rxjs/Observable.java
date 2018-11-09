package hello.rxjs;

import java.io.IOException;

/**
 * 这里模拟实现一个可观察对象，它能推送消息给观察者
 */
public class Observable {
    private Publisher publisher;
    public Observable(Publisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe(Observer observer) throws IOException {
        this.publisher.onSubscribe(observer);
    }
    public static void main(String[] args) throws IOException {
        Observer observer=new Observer() {
            @Override
            public void next(Object item) {
                System.out.println("next item is:"+item);
            }
        };
        Observable source$=new Observable(new Publisher());
        source$.subscribe(observer);
    }
}
