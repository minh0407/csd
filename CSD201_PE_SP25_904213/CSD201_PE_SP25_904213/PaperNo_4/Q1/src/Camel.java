// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Camel {
  String desert;
  int step,type;
  Camel() {
   }
  Camel(String xDesert, int xStep, int xType){
    desert=xDesert;step=xStep; type=xType;
   }
  public String toString(){
    return("(" +desert+","+step + "," + type + ")");
   }
 }
