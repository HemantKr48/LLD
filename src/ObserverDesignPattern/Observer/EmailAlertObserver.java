package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserver implements NotificationAlertObserver {

    String emailId;
    StocksObservable observable;

    public EmailAlertObserver(String emailId,StocksObservable observable){
        this.emailId=emailId;
        this.observable=observable;
    }

    @Override
    public void update(){
        sendEmail(emailId,"product is in stock buy as early as possible");
        //Give proper mail
    }

    public void sendEmail(String emailId,String msg){
        System.out.println("mail sent to "+ emailId);
    }

}
