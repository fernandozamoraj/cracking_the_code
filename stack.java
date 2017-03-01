
//https://repl.it/Flm8/3

//copy this code into repl.it to run
class Main {
  public static void main(String[] args) {
    
      MyList list = new MyList();
      list.add(new String("Joe"));
      list.add(new String("John"));
      list.add(new String("Mary"));
      list.add(new String("Jesse"));
      list.add(new String("Mike"));
      
      list.display();
      
      System.out.println("\nGet Joe " + list.get(0));
      System.out.println("\nGet Mike " + list.get(4));
      System.out.println("\nGet Unkn " + list.get(5));
   
      System.out.println("\nContains Joe " + 
               list.contains("Joe"));
      System.out.println("\nContains Mike " + 
              list.contains("Mike"));
      System.out.println("\nContains Danny " + 
              list.contains("Danny"));
            
      System.out.println("List Contents: ");
      for(int i=0;i<list.size();i++){
        System.out.println("" + i +". " + list.get(i));
      }

      list.remove(4);

      System.out.println("After removing Mike" + list);

      list.remove(0);
      System.out.println("After removing Joe " + list);

      list.remove(1);
      System.out.println("After removing Mary " + list);

      list.remove(2);
      System.out.println("After removing out of bounds " + list);

      list.remove(0);
      list.remove(0);
      System.out.println("After removing all " + list);

      list.add(new Integer(1));
      list.add(new Integer(2));
      list.add(new Integer(3));
      
      System.out.println("After adding three integers " + list);
      
      
      list.clear();
      System.out.println("After calling clear " + list);

      
  }
}

/**
 *   Generic Linked List (Not using generics - but generic
 *    in the sense that you can store any type of object in it)
 * 
 *   This list hides the implementation details that it's a linked list
 *   and rather simply implements a linked list to create a list object.
 * 
 * 
 * **/

class Node{
  private Object data;
  private Node next;
  
  public Node(){
    data = null;
    next = null;
  }
  
  public Node(Object data){
    this.data = data;
    this.next = null;
  }
  
  @Override
  public String toString(){
    return this.data.toString();
  }
  
  public void setNext(Node next){
    this.next = next;
  }
  
  public Node getNext(){
    return this.next;
  }
  
  public void setData(Object data){
    this.data = data;
  }
  
  public Object getData(){
    return this.data;
  }
}

class MyList{
  Node head = null;
  Node tail = null;
  int count = 0;
  
  public void add(Object obj){
    if(head == null){
      head = new Node(obj);
      tail = head;
    }
    else{
      tail.setNext( new Node(obj) );
      tail = tail.getNext();
    }
    
    count++;
  }
  
  public void remove(int index){
    if(index >= 0 && index < count){
      Node temp = this.head;
      
      if(index == 0){
        this.head = head.getNext();
        count--;
        return;
      }
      
      // [0,1]->[1,2]-[2,null]
      int i = 0;
      Node previous = temp;
      while(temp.getNext() != null){
        
        if(i == index){
          break;
        }
        previous = temp;
        temp = temp.getNext();
        i++;
      }
      
      previous.setNext(temp.getNext());
      temp = null;
      count--;
    }
  }
  
  public void clear(){
    while(this.size() != 0){
      this.remove(0);
    }
  }
  
  public Object get(int index){
    
    int i = 0;
    
    Node temp = head;
    
    while(temp != null){
      
      if(i == index){
        return temp.getData();
      }
      
      temp = temp.getNext();
      i++;
    }
    
    return null;
  }
  
  @Override
  public String toString(){
    Node temp = head;
    StringBuffer buffer = new StringBuffer();
    
    int i = 0;
    while(temp != null){
      
      buffer.append("\n" + i +". " + temp);
      temp = temp.getNext();
      i++;
      
    }
    
    return buffer.toString();
  }
  
  public void display(){
    
    Node temp = head;
    
    while(temp != null){
      
      System.out.println("\n " + temp);
      temp = temp.getNext();
      
    }
  }
  
  public boolean contains(Object obj){
    
    Node temp = head;
    
    while(temp != null){
      
      if(obj.equals(temp.getData())){
        return true;
      }      
      
      temp = temp.getNext();
    }
    
    return false;
  }
  
  public int size(){
    return this.count;
  }
}



