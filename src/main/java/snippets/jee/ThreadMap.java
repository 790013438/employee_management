package snippets.jee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadMap {

    public static void main (String[] args) {

        //Collections工具
        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 5; ++i) {
            Thread thread = new Thread(new Runnable() {
                public void run () {
                    for (Integer i = 0; i < 10000; ++i) {
                        arrayList.add(i);
                    }
                }
            });
            thread.start();
        }
        System.out.println(arrayList);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println(x);
        }));
    }

}
