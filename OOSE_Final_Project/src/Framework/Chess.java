package Framework;

public class Chess {
  
  private int x;            //x座標
  private int y;            //y座標
  private int weight;       //優先權
  private int user;         //陣營
  
  public Chess(int x, int y, int weight, int user) {
    
    this.setX(x);
    this.setY(y);
    this.setWeight(weight);
    this.setUser(user);
    
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getUser() {
    return user;
  }

  public void setUser(int user) {
    this.user = user;
  }
  
}
