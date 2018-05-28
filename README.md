```

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

        try {
            A.doprocess();
        } catch (BlockException e) {
            e.printStackTrace();
        }
        System.out.println("=================================");
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


        try {
            A.doprocess();
        } catch (BlockException e) {
            e.printStackTrace();
        }
        System.out.println("=================================");
    }

    public static void demo3(){

        /*
        *
        *
        *          E
        *          |
        *          D --> F
        *          |
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

        B.addChild(G);
        G.addChild(I);
        G.addChild(H);
        I.addChild(J);

        B.addChild(C);
        C.addChild(J);
        J.addChild(K);
        K.addChild(L);
        L.addChild(M);


        try {
            A.doprocess();
        } catch (BlockException e) {
            e.printStackTrace();
        }
        System.out.println("=================================");
    }


    public static void demo4(){

        /*
        *   A -> B -> C
        * */

        BlockA A= new BlockA("A");
        BlockB B= new BlockB("B");
        BlockC C= new BlockC("C");



        //String[] inputsFromA = new String[]{ "video" , "image_0" , "image_1" };
        String[] inputsFromA = new String[]{FEED.VIDEO, gN(FEED.IMAGE,0), gN(FEED.IMAGE,1) };
        A.addChild(B,inputsFromA);
        String[] inputsFromB = new String[]{gN(FEED.VIDEO,0), gN(FEED.VIDEO,1)};
        B.addChild(C,inputsFromB);
        try {
            A.doprocess();
        } catch (BlockException e) {
            System.out.println("i'm the one who called... ");
            e.printStackTrace();
        }

        System.out.println("=================================");
    }

    public static void demo5(){

        /*
        *   A -> B -> C
        * */

        BlockA A= new BlockA("A");
        BlockB B= new BlockB("B1");
        BlockC C= new BlockC("C");


        String[] inputsFromA = new String[]{FEED.VIDEO, gN(FEED.IMAGE,0), gN(FEED.IMAGE,1) };
        A.addChild(B,inputsFromA);
        String[] inputsFromB = new String[]{gN(FEED.VIDEO,0), gN(FEED.VIDEO,1)};
        B.addChild(C,inputsFromB);
        try {
            A.doprocess();
        } catch (BlockException e) {
            System.out.println("i'm the one who called... ");
            e.printStackTrace();
        }
    }


```