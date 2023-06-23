/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Nurul Mustofa`
 */
public class DLLMain {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addLast(10);
        dll.addLast(100);
        dll.addLast(34);
        dll.addLast(20);
        dll.addLast(200);
        dll.addLast(75);
        System.out.println("Tampilan Data Awal DLL : ");
        dll.print();

        //cek fungsi toArray()
        System.out.println("Tampilan data array hasil dari fungsi toArray() : ");
        int[] arr = dll.toArray();
        for(int x : arr){            
            if (x == 10) {
                System.out.print(""+x);                
            }else {
                System.out.print(", "+x);                
            }
        }
        System.out.println();

        System.out.println("Tampilan Data dari List Hasil dari fungsi sublist (1,3) : ");
        //cek fungsi sublist()
        DLL subList = dll.sublist(1, 3);
        subList.print();
        

        System.out.println("Tampilan data dari list hasil dari fungsi addALL() : ");
        //cek fungsi addAll()
        DLL dll2 = new DLL();
        dll2.addLast(212);
        dll2.addLast(212);
        dll2.addLast(212);
        dll.addAll(dll2);
        dll.print();
        
        System.out.println("Tampilan data dari fungsi containsALL() : ");
        //cek fungsi containAll
        DLL dll3 = new DLL();
        dll3.addLast(100);
        dll3.addLast(34);
        dll3.addLast(212);
        System.out.println(""+dll.containsAll(dll3));
        
        System.out.println("Tampilan Data Dari fungsi removeALL() : ");
        //cek fungsi removeAll()
        dll.removeAll(dll3);
        dll.print();
    }
}