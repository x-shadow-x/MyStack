package arraystack;

import java.io.Serializable;
import java.util.Arrays;


public class ArrayStack<T> implements Serializable {

  /**
   * @Fields serialVersionUID : TODO
   */
  private static final long serialVersionUID = 74027006708386243L;

  private Object[] elementData;//����һ���������ڱ���˳��ջ��Ԫ��

  private int size = 0;//����˳��ջ��Ԫ�صĵ�ǰ����

  private int capacity;//��������ĳ���

  public ArrayStack() {
    elementData = new Object[10];//Ĭ�ϳ���Ϊ10��ջ    
  }

  public ArrayStack(int initSize) {
    elementData = new Object[initSize];//Ĭ�ϳ���Ϊ10��ջ
  }

  public ArrayStack(T element) {
    this();
    elementData[0] = element;
    size++;
  }

  public ArrayStack(T element, int initSize) {
    this.capacity = initSize;
    elementData = new Object[capacity];
    elementData[0] = element;
    size++;
  }

  /**
   * @Title: size     
   * @Description: ջ����    
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * @Title: push     
   * @Description: ��ջ    
   * @param element
   */
  public void push(T element) {
    ensureCapacity(size + 1);
    elementData[size++] = element;
  }

  private void ensureCapacity(int minCapacity) {
    //��������ԭ�г���С��Ŀǰ����ĳ���
    int oldCapacity = elementData.length;
    if (minCapacity > oldCapacity) {
      int newCapacity = (oldCapacity * 3) / 2 + 1;
      if (newCapacity < minCapacity)
        newCapacity = minCapacity;
      // minCapacity is usually close to size, so this is a win:
      elementData = Arrays.copyOf(elementData, newCapacity);
    }

  }

  /**
   * @Title: pop     
   * @Description: ��ջ    
   * @return
   */
  public T pop() {
    if (!isEmpty()) {
      T oldValue = (T) elementData[size - 1];
      //�ͷ�ջ��Ԫ��
      elementData[--size] = null;
      return oldValue;
    } else {
      return null;
    }
  }

  /**
   * @Title: peek     
   * @Description: ����ջ��Ԫ�أ�����ɾ��ջ��Ԫ��    
   * @return
   */
  public T peek() {
    if (!isEmpty()) {
      return (T) elementData[size - 1];
    } else {
      throw new IndexOutOfBoundsException("��ջ�쳣");
    }
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
   * @Title: clear     
   * @Description: ���˳��ջ
   */
  public void clear() {
    //���ײ���������Ԫ�ظ�Ϊnull
    Arrays.fill(elementData, null);
    size = 0;
  }

  public String toString() {
    if (size == 0) {
      return "[]";
    } else {
      StringBuilder sb = new StringBuilder("[");
      for (int i = size - 1; i > -1; i--) {
        sb.append(elementData[i].toString() + ", ");
      }
      int len = sb.length();
      return sb.delete(len - 2, len).append("]").toString();
    }
  }
}

