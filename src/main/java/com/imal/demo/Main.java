package com.imal.demo;

import com.imal.block.BlockException;
import com.imal.blockimpl.*;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

import java.util.Map;

import static com.imal.block.AbstractIOBlock.FEED;
import static com.imal.block.AbstractIOBlock.FEED.gN;
/**
 * Created by imal365 on 5/27/18.
 */
public class Main {

    public static void main(String[] args) {


        //demo1();
        //demo2();
        //demo3();
        //demo4();
        //demo5();
        demo6();
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

    public static void demo6(){


       /*
       *
       * -------------- D -----
       * |                     |
       * O                     F
       * |                     |
       * -------------- E -----
       * */

        BlockO O= new BlockO("O");
        BlockD D= new BlockD("D");
        BlockE E= new BlockE("E");
        BlockF F= new BlockF("F");


        /* since o is the first node we will have to pass resolved referances ex : s3Ref, fileRef etc */
        O.getInputs().put(gN(FEED.VIDEO,0), new S3Ref("input/O1",""));
        O.getInputs().put(gN(FEED.VIDEO,1), new S3Ref("input/O2",""));

        O.addChild(D);
        /*
        * here we have your problem
        * O produces ---> IMAGE_X, VIDEO_X, AUDIO_X
        * D Accepts only ---> VIDEO
        *
        * I'm not sure but I think we should get rid of the idea of having VIDEO and VIDEO_X
         * or else system should be able to understand if we pass VIDEO_0 as an input to map it to its VIDEO
         * however we can workaround the probblem like tihs
        * */

        Map<String,Referance> outputs = O.getOutputs();
        E.getInputs().put(FEED.VIDEO, outputs.get(gN(FEED.VIDEO,1)));
        O.addChild(E);
        /*
        * Above case O is the root node and even before we say process it's output referances has been resolved to
        * correct types, and now we are using those referances and mapping them to the D
        * same way should work for the Other childs as well regardlesss the referance is resolved or not
        * */

        D.addChild(F);
        D.addChild(F);

        O.process();
    }
}
