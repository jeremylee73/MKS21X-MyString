public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i=0; i<s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index){
    if (index < 0 || index >= data.length){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public int length(){
    return data.length;
  }

  public CharSequence subSequence(int start, int end){
    if (start < 0 || end < 0 || end > data.length || start > end){
      throw new IndexOutOfBoundsException();
    }
    String ans = "";
    for (int i=start; i<end; i++){
      ans += data[i];
    }
    return ans;
  }

  public String toString(){
    String ans = "";
    for (int i=0; i<data.length; i++){
      ans += data[i];
    }
    return ans;
  }

  public int compareTo(CharSequence o){
    int shorter = 0;
    if (this.length() < o.length()){
      shorter = this.length();
    } else{
      shorter = o.length();
    }

    for (int i=0; i<shorter; i++){
      if (this.charAt(i) != o.charAt(i)){
        return this.charAt(i) - o.charAt(i);
      }
    }
    return this.length() - o.length();
  }
}
