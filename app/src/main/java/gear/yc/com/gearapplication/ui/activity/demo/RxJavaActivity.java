package gear.yc.com.gearapplication.ui.activity.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import gear.yc.com.gearapplication.base.BaseActivity;
import rx.Observable;
import rx.Subscriber;

/**
 * GearApplication
 * Created by YichenZ on 2016/3/25 16:40.
 */
public class RxJavaActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        1.
//        mObservable.subscribe(mSubscriber);
//        2.
//        Observable.just("Hello world").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });
        //3.
//        Observable.just("Hello world").subscribe(s -> System.out.println(s));

        //3. map
//        Observable.just("Hello world")
//                .map(s -> s+"Joker")
//                .map(s -> s.hashCode())
//                .map(i -> Integer.toString(i))
//                .subscribe(s -> System.out.println(s));

        //4
//        List<String> urls =new ArrayList<String>();
//        urls.add("a");
//        urls.add("b");
//        Observable.just(urls)
//                .flatMap( u -> Observable.from(u))
//                .subscribe(url -> System.out.println(url));
        //5 Demo
        Observable.just("#Basic Markdown to HTML with lambda")
                .filter(s -> s!=null && s.startsWith("#"))
                .map(s -> "<h1>"+s.substring(1,s.length())+"</h1>")
                .subscribe(System.out::println);


    }
    //4
//    Observable<List<String>> query(String text){
//        return Observable.create(Observable<List<String>>);
//    }

    //1.
    Observable<String> mObservable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello world");
            subscriber.onCompleted();
        }
    });

    //1.
    Subscriber<String> mSubscriber =new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            System.out.println(s);
        }
    };

}
