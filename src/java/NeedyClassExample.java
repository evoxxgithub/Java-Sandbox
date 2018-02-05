public class NeedyClassExample {


    public static void main(String[] s)  {


        IOC.instance().setClassObject(new NeedyClassExample());

        try {
            NeedyClassExample example = IOC.instance().resolveObject(NeedyClassExample.class);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
