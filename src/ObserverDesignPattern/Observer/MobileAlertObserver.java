package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver{
  String mobileNo;
  StocksObservable observable;

  public MobileAlertObserver(String mobileNo,StocksObservable observable){
      this.mobileNo=mobileNo;
      this.observable=observable;
  }

  @Override
  public void update(){
      sendMobileAlert(mobileNo,"phones are in stock buy as early as possible");
  }

  public void sendMobileAlert(String mobileNo,String msg){
      System.out.println("Please buy mobile");
  }
}
