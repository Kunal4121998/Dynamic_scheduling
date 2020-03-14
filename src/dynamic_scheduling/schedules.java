/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_scheduling;

/**
 *
 * @author p.charde
 */
class schedules {
     int maxStock=300;
    int openingStock[];
    int closingStock[];
    int minStock=200;
    int dailyConsumption[];
    int orderQuantity[];
    int lotSize=20;
    public schedules() {
        openingStock=new int[100];
        closingStock=new int[100];
        dailyConsumption=new int[100];
        orderQuantity=new int[100];
    }
    
    public void result(){
    for(int i=0; i<31; i++){
        dailyConsumption[i]=28;
    }
    openingStock[0]=300;
    for(int i=0; i<31; i++){
        closingStock[i]=openingStock[i]-dailyConsumption[i];
        if(closingStock[i]<minStock){
            orderQuantity[i]=maxStock-closingStock[i];
            double k=orderQuantity[i]/lotSize;
            int l=(int) Math.round(k);
            orderQuantity[i]=l*lotSize;
            closingStock[i]=orderQuantity[i]+closingStock[i];
        }
        openingStock[i+1]=closingStock[i];
    }
    
    for(int i=0; i<31; i++){
        System.out.println(openingStock[i]+" "+dailyConsumption[i]+" "+closingStock[i]+" "+orderQuantity[i]);
    }
}

}
