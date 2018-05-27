/**
 * Created by imal365 on 5/27/18.
 */
public class Main {

    public static void main(String[] args) {


        //demo1();
        demo2();


    }

    public static void demo1(){
        /*
        *
        *
        *
        *   A ---> B ---> D --> E
        *          |             ----> G
        *          C ---------> F
        *
        *
        * */


        Block A = new Block("A");
        Block B = new Block("B");
        Block C = new Block("C");
        Block D = new Block("D");
        Block E = new Block("E");
        Block F = new Block("F");
        Block G = new Block("G");


        A.addChild(B);
        B.addChild(D);
        B.addChild(C);
        D.addChild(E);
        C.addChild(F);
        E.addChild(G);
        F.addChild(G);

        A.doprocess();
    }


    public static void demo2(){

        /*
        *
        *
        *          E --------------------------
        *          |                           |
        *          D --> F --------------------|
        *          |                           |
        *   A ---> B ---> C --> J ---> K ---> L ---> M
        *          |            |              |
        *          G --> I -----               |
        *          |                           |
        *          H --------------------------
        *
        *
        * */


        Block A = new Block("A");
        Block B = new Block("B");
        Block C = new Block("C");
        Block D = new Block("D");
        Block E = new Block("E");
        Block F = new Block("F");
        Block G = new Block("G");
        Block H = new Block("H");
        Block I = new Block("I");
        Block J = new Block("J");
        Block K = new Block("K");
        Block L = new Block("L");
        Block M = new Block("M");

        A.addChild(B);

        B.addChild(D);
        D.addChild(E);
        D.addChild(F);
        E.addChild(L);
        F.addChild(L);

        B.addChild(G);
        G.addChild(I);
        G.addChild(H);
        I.addChild(J);

        B.addChild(C);
        C.addChild(J);
        J.addChild(K);
        K.addChild(L);
        L.addChild(M);


        A.doprocess();
    }
}
