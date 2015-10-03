import java.lang.reflect.*;

public class Main
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {

        GetOpt g = new GetOpt(args, "ahmsivcC:");
        int c;
        Class cls = Integer.class;



        System.out.println("command-line option(s):");
        g.opterr(false);  // suppress display error messages

        while( (c = g.getopt()) != -1)
        {
            switch(c)
            {
                case 'm': getMethods(cls); break;
                case 'c': getConstructors(); break;
                case 'C': getConstants(); break;
                case 'v': getVaraibles(); break;
                case 'i': getInterfaces(); break;
                case 's': getSuper(); break;
                case 'h': getHelp(); break;
                case 'a': displayAll();
                    System.exit(1);
            }
        }

        String t[] = g.getarg();           // get filename(s)
        System.out.println("Filename(s):");
        for(String s: t) if(!s.equals("")) System.out.println(s);
    }


    public static void print(String str,boolean isNewLine)
    {
        if(isNewLine)
        {
            System.out.println(str);
        }else{
            System.out.print(str);
        }

    }


    public static void getMethods(Class cls)
    {
        /**
         * Note: I can go directly into the method and get it's information
         * Name of Method
         * member vars
         * return type
         * arguments - Type of argument
         * modifiers
         * print public string getName() one line for each method info
         */

        Method[]methods = cls.getDeclaredMethods();


        int count = 5;

        int m = methods[0].getModifiers();

        String mod = "";

        for(int i=0;i<=count;i++)
        {
            if (methods[i].getModifiers() == Modifier.PUBLIC)
            {
                mod = "public";
            }
            else if(methods[i].getModifiers() == Modifier.PRIVATE)
            {
                mod = "private";
            }
            else if(methods[i].getModifiers() == Modifier.PROTECTED)
            {
                mod = "protected";
            }
            else if(methods[i].getModifiers() == Modifier.ABSTRACT)
            {
                mod = "volatile";
            }



            print(methods[i].getName()
                          + " : " + methods[i].getReturnType()
                          + " : " + mod, true);

        }




//
//        else if ("protected".equals(s))   m |= Modifier.PROTECTED;
//        else if ("private".equals(s))     m |= Modifier.PRIVATE;
//        else if ("static".equals(s))      m |= Modifier.STATIC;
//        else if ("final".equals(s))       m |= Modifier.FINAL;
//        else if ("transient".equals(s))   m |= Modifier.TRANSIENT;
//        else if ("volatile".equals(s))    m |= Modifier.VOLATILE;



        //print("Check this method out\n "+methods[0].toString(),true);


        print("Getting info about all the " +
                      "methods of that class",true);
    }

    public static void getConstructors()
    {
        print("Getting info about all the " +
                      "constructors of that class",true);
    }


    public static void getConstants()
    {
        print("Getting info about all the " +
                      "Constants in the class",true);
    }

    public static void getVaraibles()
    {
        print("Getting info about all variables in the " +
                      "class including pub and private",true);
    }

    public static void getInterfaces()
    {
        print("Getting info about all the " +
                      "interfaces this class uses", true);
    }

    public static void getSuper()
    {
        print("Getting info on the Super Class", true);
    }

    public static void getHelp()
    {
        print("********************Help:********************"+
                      "\nCommand: "+"\"m\"" +" = "
                      +"Display all Methods of the class "
                      + "\nCommand: "+"\"c\"" +" = "
                      +"Display all Constructors of the class "
                      + "\nCommand: "+"\"C\"" +" = "
                      +"Display all Constants of the class "
                      + "\nCommand: "+"\"v\"" +" = "
                      +"Display all Variables of the class "
                      + "\nCommand: "+"\"i\"" +" = "
                      +"Display all Interfaces of the class "
                      + "\nCommand: "+"\"s\"" +" = "
                      +"Display Super Class  of the class "
                      + "\nCommand: "+"\"a\"" +" = "
                      +"Display all Display Options for the class "
                      + "\nCommand: "+"\"h\"" +" = "
                      +"Display Help ",true);
    }


    public static void displayAll()
    {
        print("Displaying all options",true);
    }


}
