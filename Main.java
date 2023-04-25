import java.io.*;
import java.util.*;
public class Main{
    public static void main  (String[]args)throws Exception{
        
        ArrayList<Containers> myArray = new ArrayList<Containers>();
        String firstLine=null ;
        try{
            String fileName=getName(args[0]);
            File file = new File (fileName);
            Scanner extract = new Scanner(file);

            //to throw an exeption if the file is empty:
            if (!(extract.hasNext())){
                throw new EmptyAutosarFileException("this file is empty!");
            }

            
           
            

            
            String tempString ;
            String tempID=null;
            String tempShortName=null;
            String tempLongName=null;

            //to copy the first line and put it in the modified  file
            firstLine = extract.nextLine();

            while(extract.hasNextLine()){
            tempString = extract.nextLine();
            //myString.append(tempString);
            //myString.append("\n");

            
            if (tempString.contains("<CONTAINER UUID=")){
                
                tempID = tempString.substring(tempString.indexOf('=')+1,tempString.indexOf('>'));
            }
            else if (tempString.contains("<SHORT-NAME>")){
                tempShortName= tempString.substring(tempString.indexOf('>')+1,tempString.indexOf("</"));
            }
            else if (tempString.contains("<LONG-NAME>")){
                tempLongName= tempString.substring(tempString.indexOf('>')+1,tempString.indexOf("</"));
            }else if (tempString.contains("</CONTAINER>")){

                myArray.add(new Containers(tempID,tempShortName,tempLongName));
                
            }
            
            
            
            }
            //System.out.println(myArray.size());
        }
        

    //catches area 
        catch (NotValidAutosarFileException e){
            System.out.println("the caught exception : "+e.getMessage());
            System.exit(0);
        }
         catch(EmptyAutosarFileException e){
            System.out.println("the caught exception : "+e.getMessage());
            System.exit(0); 
         }
        //outside try and catch block
        
        Collections.sort(myArray);

        //here we will start writing in the new file :
        String oldName =args[0];
        String newName = oldName.substring(0, oldName.indexOf('.'))+"_mod.arxml";
        PrintWriter inp =new PrintWriter(newName);
        inp.println(firstLine);
        inp.println("<AUTOSAR>");
        for(int i =0;i<myArray.size();i++){
            inp.println(myArray.get(i).toString());
        }
        inp.println("</AUTOSAR>");
        
        inp.close();
        }
        



        //method to get the name of the file an throws the  exception :
        public static String getName(String localstr)throws NotValidAutosarFileException{
            if (!(localstr.endsWith(".arxml") )){
                throw new NotValidAutosarFileException("the file name should have .arxml at the end ");
            }
            return localstr;

        }

}




//exception classes 
class NotValidAutosarFileException extends Exception{
    NotValidAutosarFileException(String s){
        super(s);
    }
}


class EmptyAutosarFileException extends Exception {
    EmptyAutosarFileException(String s){
        super(s);
    }
}