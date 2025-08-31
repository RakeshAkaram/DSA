package linkedList;

public class DesignBrowser {
    static Browser currentIndex;
    static Browser head;
    public static void main(String[] args) {
        currentIndex = convertToDLL(new String[]{"Google.com","Facebook.com","Instagram.com","Youtube.com"});
        displayBrowsers(head);
        visit("chatGpt.com");
        back(1);
        back(1);
        front(2);
        front(2);
        back(3);
        back(4);
        front(7);

    }
    private static void displayCurrentIndex(String operation,String times) {
        System.out.println("\nAfter "+operation+"("+times+"):\n\t Current Index at: "+currentIndex.getUrl());
    }

    private static void front(int i) {
        int copyI=i;
        while (i-->0){
            if(currentIndex.getFront()!=null)
                currentIndex=currentIndex.getFront();
            else break;
        }
        displayCurrentIndex("front",copyI+"");
    }

    private static void back(int i) {
        int copyI=i;
        while (i-->0){
            if(currentIndex.getBack()!=null)
                currentIndex=currentIndex.getBack();
            else break;
        }
        displayCurrentIndex("back",copyI+"");
    }

    private static void visit(String url) {
        currentIndex.setFront(new Browser(url,currentIndex,null));
        currentIndex=currentIndex.getFront();
        displayCurrentIndex("visit",url);
    }

    private static void displayBrowsers(Browser head) {
        Browser tempHead=head;
        System.out.println("\nLeft to Right: ");
        while(tempHead.getFront()!=null){
            System.out.print(tempHead.getUrl()+"->");
            tempHead=tempHead.getFront();
        }
        System.out.print(tempHead.getUrl()+"->");
        System.out.print("null");

        System.out.println("\nRight to Left: ");
        while(tempHead.getBack()!=null){
            System.out.print(tempHead.getUrl()+"->");
            tempHead=tempHead.getBack();
        }
        System.out.print(tempHead.getUrl()+"->");
        System.out.print("null");

    }

    private static Browser convertToDLL(String[] urls) {
        Browser currentIndex=null;
        for(String url:urls){
            if(head==null){
                head=new Browser(url);
                currentIndex=head;
            }
            else{
                currentIndex.setFront(new Browser(url,currentIndex,null));
                currentIndex=currentIndex.getFront();
            }
        }
        return currentIndex;
    }

}

class Browser{
    private String url;
    private Browser back;
    private Browser front;

    public Browser(String url) {
        this.url = url;
    }

    public Browser(String url, Browser back, Browser front) {
        this.url = url;
        this.back = back;
        this.front = front;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Browser getBack() {
        return back;
    }

    public void setBack(Browser back) {
        this.back = back;
    }

    public Browser getFront() {
        return front;
    }

    public void setFront(Browser front) {
        this.front = front;
    }

}
