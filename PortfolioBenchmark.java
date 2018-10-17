import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PortfolioBenchmark{
    public static void main(String args[]) throws IOException{
            // InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            // BufferedReader in = new BufferedReader(reader);
             String line="Vodafone,STOCK,10,50,0|Google,STOCK,15,50,0|Microsoft,BOND,15,100,0.05:Vodafone,STOCK,15,50,0|Google,STOCK,10,50,0|Microsoft,BOND,15,100,0.05";
            // while ((line = in.readLine()) != null) {
              new PortfolioBenchmark().readInput(line);  
            //}
    }
    public void readInput(String line){
      String[] portfolioAndBenchmarkArray   =   line.split(":");
      String[] portfolioArray               =   null;
      String[] benchMarkArray               =   null;
      ArrayList<PortfolioBenchmarkObjects> portfolioArraylistOfObjects     = new ArrayList<PortfolioBenchmarkObjects>();
      ArrayList<PortfolioBenchmarkObjects> benchMarkArraylistOfObjects     = new ArrayList<PortfolioBenchmarkObjects>();
      ArrayList<PortfolioBenchmarkObjects> OutputList                      = new ArrayList<PortfolioBenchmarkObjects>();
      
      if(portfolioAndBenchmarkArray.length==2){
          portfolioArray           =   portfolioAndBenchmarkArray[0].split("\\|");
          benchMarkArray           =   portfolioAndBenchmarkArray[1].split("\\|");          
      }
      for(int i=0;i<portfolioArray.length;i++){
          String[] portfolio                =   portfolioArray[i].split(",");
          PortfolioBenchmarkObjects portfolioAndBenchmarkObjects = new PortfolioBenchmarkObjects();

          for(int j=0;j<portfolio.length;j++){
              if(j==0){
                portfolioAndBenchmarkObjects.setName(portfolio[j]);
             }if(j==1)
                portfolioAndBenchmarkObjects.setAssetTypes(portfolio[j]);
              if(j==2)
                portfolioAndBenchmarkObjects.setShares(Double.parseDouble(portfolio[j]));
              if(j==3)
                portfolioAndBenchmarkObjects.setPrice(Double.parseDouble(portfolio[j]));
              if(j==4)
                portfolioAndBenchmarkObjects.setAccruedInterest(Double.parseDouble(portfolio[j]));              
            }
            portfolioArraylistOfObjects.add(portfolioAndBenchmarkObjects);  
      }
        for(int j=0;j<benchMarkArray.length;j++){
            String[] benchMark                =   benchMarkArray[j].split(",");
            PortfolioBenchmarkObjects portfolioAndBenchmarkObjects = new PortfolioBenchmarkObjects();
            for(int jk=0;jk<benchMark.length;jk++){
                if(jk==0)
                portfolioAndBenchmarkObjects.setName(benchMark[jk]);
                if(jk==1)
                portfolioAndBenchmarkObjects.setAssetTypes(benchMark[jk]);
                if(jk==2)
                portfolioAndBenchmarkObjects.setShares(Double.parseDouble(benchMark[jk]));
                if(jk==3)
                portfolioAndBenchmarkObjects.setPrice(Double.parseDouble(benchMark[jk]));
                if(jk==4)
                portfolioAndBenchmarkObjects.setAccruedInterest(Double.parseDouble(benchMark[jk]));
            }
            benchMarkArraylistOfObjects.add(portfolioAndBenchmarkObjects);
        }
           ArrayList<PortfolioBenchmarkObjects> outputlist  =   readListAndCalculate(portfolioArraylistOfObjects,benchMarkArraylistOfObjects,OutputList);
           for(PortfolioBenchmarkObjects objects:outputlist){
               if(objects.isBUY){
                   System.out.println("BUY,"+objects.getName()+","+(int)objects.getShares());
               }
               else{
                    System.out.println("SELL,"+objects.getName()+","+(int)objects.getShares());
               }
           }

    }

    public ArrayList<PortfolioBenchmarkObjects> readListAndCalculate(ArrayList<PortfolioBenchmarkObjects> portfolioObjects,ArrayList<PortfolioBenchmarkObjects> benchMarkObjects,ArrayList<PortfolioBenchmarkObjects> OutputList){
        for(PortfolioBenchmarkObjects portfolioOject:portfolioObjects){
                for(PortfolioBenchmarkObjects benchMarkObject:benchMarkObjects){
                    if(portfolioOject.getName().equals(benchMarkObject.getName())&&portfolioOject.getAssetType().equals(benchMarkObject.getAssetType())){                       
                        PortfolioBenchmarkObjects outputObjects = new PortfolioBenchmarkObjects();                    
                        double NumberOfshareMultiplyByPricePortfolio = portfolioOject.getPrice()*portfolioOject.getShares();
                        double NumberOfshareMultiplyByPriceBenchMark = benchMarkObject.getPrice()*benchMarkObject.getShares();
                        if(NumberOfshareMultiplyByPriceBenchMark!=NumberOfshareMultiplyByPricePortfolio){
                            double difference = NumberOfshareMultiplyByPriceBenchMark-NumberOfshareMultiplyByPricePortfolio;
                            if(difference>0){
                            outputObjects.setShares(difference/benchMarkObject.getPrice());
                            outputObjects.setAssetTypes (benchMarkObject.getAssetType());
                            outputObjects.setName(benchMarkObject.getName());
                            outputObjects.isBUY =  true;
                            }
                            else if(difference<0){
                            outputObjects.setShares(Math.abs(difference/portfolioOject.getPrice()));
                            outputObjects.setAssetTypes(portfolioOject.getAssetType());
                            outputObjects.setName(portfolioOject.getName());
                            outputObjects.isBUY =  false;
                        }
                        OutputList.add(outputObjects);
                        }
                    }

                }
            }
            return OutputList;
        }   
}
class PortfolioBenchmarkObjects{
 String Name;
 String AssetType;
 double Shares;
 double AcrruedInterest;
 double Price;
 boolean isBUY  =false;
 public String getName(){
    return this.Name;
 }
 public String getAssetType(){
    return this.AssetType;
 }
 public double getShares(){
    return this.Shares;
 }
 public double getAccruedInterest(){
    return this.AcrruedInterest;   
 }
 public double getPrice(){
    return this.Price;
 }
 public void setName(String Name){
    this.Name       =   Name;
 }
 public void setAssetTypes(String Assettype){
    this.AssetType  =   Assettype;
 }
 public void setShares(double Shares){
    this.Shares=   Shares;
 }
 public void setAccruedInterest(double AccruedInterest){
     this.AcrruedInterest = AccruedInterest;
 }
 public void setPrice(double Price){
    this.Price=   Price;
 }
}