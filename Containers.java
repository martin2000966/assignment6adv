
public class Containers implements Comparable<Containers> {
    private String ID; 
    private String shortName;
    private String longName;

    Containers(String ID , String shortName ,String longName ){
        this.ID=ID;
        this.shortName=shortName;
        this.longName=longName;
    }

    Containers(){

    }


    //getters
    public String getID(){
        return ID;
    }

    public String getShortName(){
        return shortName;
    }
    public String getLongName(){
        return longName;
    }


    //setters 
    public void setID(String ID){
        this.ID=ID;
    }
    public void setShortName(String shortName){
        this.shortName=shortName;
    }
    public void setLongName(String longName){
        this.longName=longName;
    }
    
    //compare method 
    
    public int compareTo(Containers o){
        return shortName.compareTo(o.getShortName());
    }

    //print container :
    public String toString (){
        return "    <CONTAINER UUID="+getID()+">\n       <SHORT-NAME>"+
        getShortName()+"</SHORT-NAME>"+"\n      <LONG-NAME>"+getLongName()+
        "</LONG-NAME>\n    </CONTAINER>";

    }
}
