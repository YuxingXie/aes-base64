package hello.rxjs;

import java.io.IOException;
import java.util.Scanner;

/**
 * 发布者持有一个观察者，当发布者被订阅的时候执行onSubscribe方法
 */
public class Publisher {
    public void onSubscribe(Observer observer) throws IOException {
        Scanner input = new Scanner(System.in);
        String item = null;       // 记录输入的字符串
        while (true){
            System.out.print("请输入：");
            item = input.next();// 等待输入值
            observer.next(item);//这一句代码确保发布者发布任何消息时，观察者的next方法必然被执行
        }
    }
}
