package pyk.codesample2.contract.callback;

public class Listener {
  public interface SwipyListener {
    public void listPopulate();
    public void networkError(String error);
  }
}
