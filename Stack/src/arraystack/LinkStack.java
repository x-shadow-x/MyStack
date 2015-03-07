package arraystack;

import java.io.Serializable;

public class LinkStack<T> implements Serializable{

	private static final long serialVersionUID = -4378447264374701299L;

    private class Node{
      private T data; //����ڵ������ 
    
      private Node next; //ָ���¸��ڵ������
    
      public Node(){
    	  
      }
    
      public Node(T data, Node next){
    	  this.data = data;
    	  this.next = next;
      }
    }
  
    private Node top;  //�������ջ��ջ��Ԫ��   
 
    private int size = 0;   //�������ջ���Ѱ����Ľڵ���,��ջ�ĳ���

    public LinkStack(){
      top = null;
    }
  
    public LinkStack(T element) {
      top = new Node(element , null);   
      size++; 
    }
  
  /**
   * @Title: push     
   * @Description: ��ջ    
   * @param element
   */
  public void push(T element){
    top = new Node(element , top);   
    size++;
  }
  
  /**
   * @Title: pop     
   * @Description: ��ջ    
   * @return
   */
  public T pop(){
    Node oldTop = top;
    top = top.next;
    oldTop.next = null;
    size--;
    return oldTop.data;
  }
  
  /**
   * @Title: peek     
   * @Description: ����ջ��Ԫ��    
   * @return
   */
  public T peek(){
    return top.data;
  }
  
  /**
   * @Title: empty     
   * @Description: �ж�˳��ջ�Ƿ�Ϊ��ջ    
   * @return
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @Title: size     
   * @Description: ջ�ĳ���    
   * @return
   */
  public int size(){
	  return size;
  }
  /**
   * @Title: clear     
   * @Description: ���˳��ջ
   */
  public void clear() {   
    top = null;//��ջ����Ԫ�ظ�Ϊnull
    size = 0;
  }

  public String toString() {   
        //��ջΪ����ջʱ   
    if (isEmpty()) {   
      return "[]";   
    } else {   
      StringBuilder sb = new StringBuilder("[");   
      for (Node current = top ; current != null ; current = current.next ) {   
        sb.append(current.data.toString() + ", ");   
      }   
      int len = sb.length();   
      return sb.delete(len - 2 , len).append("]").toString();   
    }   
  }   

}
