package ObserverDesignPattern;

import ObserverDesignPattern.Observable.IphoneObservableImp;
import ObserverDesignPattern.Observable.StocksObservable;
import ObserverDesignPattern.Observer.EmailAlertObserver;
import ObserverDesignPattern.Observer.MobileAlertObserver;
import ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args){
        StocksObservable iphoneStockObservable=new IphoneObservableImp();

        NotificationAlertObserver observer1=new EmailAlertObserver("hemantPatwa48@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2=new EmailAlertObserver("shivampatwa21@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3=new MobileAlertObserver("9204718008",iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);


    }
}
