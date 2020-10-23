package com.tz;
/*
 * 动态数组自实现
 * */
@SuppressWarnings("unchecked")
public class ArrayList<E> {
	private int size;//数组中所有元素数量
	private E[] elements;//数组
	private static final int DEAFULT_CAPATICY = 10; //默认动态数组容量为10
	private static final int DEAFULT_NOT_FOUND = -1; //当前动态数组中无此元素返回
	public ArrayList(){
		this(DEAFULT_CAPATICY);
	}
	public ArrayList(int capaticy){
    	if (capaticy < DEAFULT_CAPATICY) {
			capaticy = DEAFULT_CAPATICY;
		}
    	elements = (E[]) new Object[capaticy];
	}
    private void rangCheckForAdd(int index) {
 	   if(index < 0 || index > size) {
 		   throw new IndexOutOfBoundsException("index is illegal");
 	   }
    }
    private void rangCheck(int index) {
 	   if(index < 0 || index >= size) {
 		   throw new IndexOutOfBoundsException("index is illegal");
 	   }
    }
    /*
     * 扩容
     * */
    private void ensuerCapaticy(int capaticy) {
    	int oldCapaticy = elements.length;
		if (oldCapaticy >= capaticy) {
			//当前数组已满足，无需扩容
			return;
		}else {
			//扩容
			int newcapaticy = oldCapaticy + (oldCapaticy >> 1) ; //扩容后数组长度为旧容量1.5倍
			Object[] newElements = new Object[newcapaticy];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = (E[]) newElements;
			System.out.println(oldCapaticy+"扩容后"+newcapaticy);
		}
	}
	/*
	 * 清除所有元素
	 * */
   public void clear() {
	   for (int i = 0; i < size; i++) {
		elements[i] = null;
		
	}
	   size = 0;
   }
   /*
	 * 数组元素的数量
	 * */
   public int size() {
	  return size;
  }
  /*
	 * 判断数组是否为空
	 * */
   public boolean isEmpty() {
	  return size == 0;
   }
  /*
   * 获取指定位置的元素
   * */
   public E get(int index) {
	  rangCheck(index);
	return elements[index];
   }
  /*
   * 设置指定位置元素并返回原位置元素
   * */
   public E set(int index,E element) {
	   rangCheck(index);
	   E old = elements[index];
	   elements[index] = element;
	   return old;
    }
   /*
    * 查看指定元素的索引
    * */
   public int indexOf(E element) {
	   if (element == null) {
		   for (int i = 0; i < size; i++) {
			if (elements[i] == null) {
				//找出第一个为空的对象即可
				return i;
			}
		}
	}else {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
	    }
	} 
	     return DEAFULT_NOT_FOUND;
    }
   /*
    * 是否包含当前元素
    * */
   public boolean contains(E element) {
	  return indexOf(element) != DEAFULT_NOT_FOUND;
  }
   /*
    * 添加元素
    * */
   public void add(E element) {
	   add(size, element);
  }
   public String toString() {
	   StringBuilder sBuilder = new StringBuilder();
	   for (int i = 0; i < size; i++) {
		 sBuilder.append(elements[i]+ " ");
	}
	   return sBuilder.toString();
  }

   /*
    * 删除指定位置的元素并返回相对应元素
    * */
   public E remove(int index) {
	    rangCheck(index);
	   E oldElement = elements[index];
	   for (int i = index + 1; i < size; i++) {
		  elements[i-1] = elements[i];
	}  
	   size--;
	   elements[size] = null;
 	   return oldElement;
  }
   /*
    * 指定位置添加元素
    * */
   public void add(int index,E element) {
	      rangCheckForAdd(index);
	      ensuerCapaticy(size + 1); //数组动态扩容
	      for (int i = size ; i > index; i--) {
			 elements[i] = elements[i - 1];
		}
	      elements[index] = element;
	      size++;
	   }
}
