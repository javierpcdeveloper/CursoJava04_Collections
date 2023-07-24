package test;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        //array
        String array[] = {"pepe","juan","luis","jose","asun","lara","pepe","juan","lara","pepe"};
        String[] array2=array.clone();
        Arrays.sort(array2);//ordenar (sólo si no hay nulos)
        System.out.println(Arrays.toString(array2));
        System.out.println("");
        
        //////////////////////
        ///////Listas/////////
        //////////////////////
        ArrayList<String> arraylist=new ArrayList();
        LinkedList<String> linkedlist=new LinkedList();
        for(String nombre:array){
          arraylist.add(nombre);
          linkedlist.add(nombre);
        }
        System.out.println("araylist:"+arraylist);
        System.out.println("linkedlist:"+linkedlist);
        Collections.sort(linkedlist);
        System.out.println("linkedlist ordenado:"+linkedlist);
        //add(valor),set(indice,valor),remove(indice),clear
        //pila
        System.out.println("sacamos el de arriba:"+linkedlist.pop());//sacar de arriba
        linkedlist.push("javi");//meter por arriba
        System.out.println("miramos el de arriba:"+linkedlist.peek());//mirar el de arriba
        //cola
        linkedlist.offer("alex");//meter al final
        System.out.println("sacamos del principio:"+linkedlist.poll());//sacar del principio
        System.out.println("miramos al principio:"+linkedlist.peek());//mirar del principio
        System.out.println("araylist:"+arraylist);
        System.out.println("linkedlist:"+linkedlist);
        //////////
        List miLista=new ArrayList();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        
        //metodo tradicional
        for(int i=0;i<miLista.size();i++){
            System.out.println("Elemento "+i+": "+miLista.get(i));
        }
        System.out.println("");
        
        //método foreach standar
        for(Object obj:miLista){
            System.out.println("Elemento:"+obj);
        }
        System.out.println("");
        
        //método foreach de streams
        miLista.forEach(obj->{
            System.out.print("Elemento ["+obj);
            System.out.println("]");
        });
        System.out.println("");
        
        ///////////////////////////
        /////////Conjuntos/////////
        ///////////////////////////
        HashSet<String> hashset=new HashSet();//desordenado
        LinkedHashSet<String> linkedhashset=new LinkedHashSet();//ordenado según inserción
        TreeSet<String> treeset=new TreeSet();//ordenado
        for(String nombre:array){
          hashset.add(nombre);
          linkedhashset.add(nombre);
          treeset.add(nombre);
        }
        System.out.println("hashset(desordenado):\t\t"+hashset);
        System.out.println("linkedhashset(orden de inserción)\t\t:"+linkedhashset);
        System.out.println("treeset(ordenado):\t\t"+treeset);
        //add(valor),clear,size,isEmpty,contains(valor);
        //addAll(set);//union
        //removeAll(set);//diferencia
        //retainAll(c2);//interseccion
        System.out.println("");
        
        //////////////////////
        /////////Mapas////////
        //////////////////////
        //mapas
        HashMap<String,Integer> hashmap=new HashMap<>();//puede ser sin String???
        TreeMap<String,Integer> treemap=new TreeMap<>();
        LinkedHashMap<String,Integer> linkedhashmap=new LinkedHashMap<>();
        for(String nombre:array){
            hashmap.put(nombre,nombre.length());
            linkedhashmap.put(nombre,nombre.length());
            treemap.put(nombre,nombre.length());
        }
        System.out.println("hashmap: "+hashmap);
        System.out.println("linkedhashmap: "+linkedhashmap);
        System.out.println("treemap: "+treemap);
        ////////////
        Map<Integer,String> mapa = new HashMap<>();//no se puede usar tipos primitivos para un genérico
        mapa.put(1,"Uno");
        mapa.put(2,"Dos");
        mapa.put(3,"Tres");
        //método tradicional
        List<Map.Entry<Integer,String>> entryList = new ArrayList<>(mapa.entrySet());
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Integer,String> entry = entryList.get(i);
            Integer key = entry.getKey();
            String value = entry.getValue();
            // Imprimir la clave y el valor
            System.out.println("Clave: " + key + ", Valor: " + value);
        }
        //metodo foreach
        for (int entero: mapa.keySet()) {
            String seleccionado=mapa.get(entero);
            System.out.println(seleccionado.substring(0, entero));
        }
        //método con streams
        mapa.forEach((clave,valor)->{
            System.out.println(valor.substring(0, clave));
        });
        //////////////////////
        //////Iteradores//////
        //////////////////////
        //https://es.stackoverflow.com/questions/2464/c%C3%B3mo-iterar-a-trav%C3%A9s-de-un-hashmap
        
        System.out.println("Iteradores");
        
        //metodo1 (con keyset)
        for(String clave:hashmap.keySet()){
          System.out.print(clave+"("+hashmap.get(clave)+")");
        }
        System.out.println();
        //metodo2 (con entryset)
        for(Map.Entry<String, Integer> entrada : hashmap.entrySet()) {
            //String key = entrada.getKey();
            //Integer value = entrada.getValue();
            System.out.print(entrada.getKey()+"("+entrada.getValue()+")");
        }
        System.out.println();
        //metodo3 (con iterator y entryset)
        Iterator<Map.Entry<String, Integer>> it = hashmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            //String llave=pair.getKey();
            //Integer valor=pair.getValue();
            System.out.print(pair.getKey()+"("+pair.getValue()+")");
        }
        
    }
}
//List---->Stream of Strings--------------------->Stream of int------------>Stream of int----------->List de int
//  .stream()             .map(s->Integer.valueOf(s))       .filter(n->n%2==0)         .collect(Collectors.toList())