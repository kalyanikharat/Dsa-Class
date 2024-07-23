
public class LinklistL001 {
    private class Node{
        private int data =0;
        private Node next = null;

        Node(int data){
            this.data = data;
        }
    }
    private Node head= null;
    private Node tail= null;
    private int numberofnodes= 0;

    //=========size of linklist=========
    public int size()
    {
        return this.numberofnodes;
    }
    //========= isemptyy=============
    public boolean isempty(){
        return size() == 0;
    }
    //=========handle zero size=========
    protected void handlezerosize(Node node){
        this.head = node;
        this.tail = node;
    }
    //=======addition function(add node first)==========
    protected void addFirstnode(Node node){
        if(size()==0){
            handlezerosize(node);
        }
        else{
            node.next = this.head;
            this.head= node;
        }
        this.numberofnodes++;

    }
    public void addFirst(int data){
        Node node = new Node(data);
        addFirstnode(node);
    }
    //=======add node last======
    protected void addLastnode(Node node){
        if(size()==0){
            handlezerosize(node);
        }
        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.numberofnodes++;

    }
    public void addLast(int data){
        Node node = new Node(data);
        addLastnode(node);
    }
    //===========add At========
    protected void addAt(Node node,int idx){
    if(idx==0){
        addFirstnode(node);
    }
    else if(idx==size()){
        addLastnode(node);

    }
    else{
        Node prev = getNodeAt(idx-1);
        Node curr = prev.next;

        prev.next = node;
        node.next = curr;
    
        this.numberofnodes++;

    }
    }
    public void addat(int data,int idx) throws Exception{
        if(idx <0 || idx > size()){
         
            throw new Exception("Invalid Position");
            
        }
        Node node = new Node(data);
            addAt(node, idx);
    }
    protected Node getNodeAt(int idx){
        Node temp = this.head;
        while(idx > 0){
            temp = temp.next;
            idx--;
        }
        return temp;
    }
    //========remove node function===========
    protected void handlesize1(){
        this.head = null;
        this.tail = null;
    }
    protected Node removeFirstnode(){
        Node temp = this.head;
        if(size()==1){
            handlesize1();
        }
        else{
            this.head = this.head.next;

        }
        temp.next = null;
        this.numberofnodes++;
        return temp;

    }
    public int removefirst() throws Exception{
        if(size()==0){
            throw new Exception("invalid index");
        }
        Node node = removeFirstnode();
        return node.data;
    }
    //======remove last node=========
    protected Node removelastnode(){
        Node temp = this.tail;
        if(size()==1){
            handlesize1();
        }
        else{
            Node secondlastnode = getNodeAt(size()-2);
            secondlastnode.next=null;
            this.tail = secondlastnode;
        }
        this.numberofnodes--;
        return temp;
    }
    //========remove last exception========
    public int removelast() throws Exception{
        if(size()==0){
            throw new Exception("linklist is empty");

        }
        Node node = removelastnode();
        return node.data;
    }
    //===========remove node at======================
    protected Node removeNodeAt(int idx){
        if(idx==0){
             return removeFirstnode();
        }
        else if(idx == size()-1){
            return removelastnode();
        }
        else{
           Node prev = getNodeAt(idx-1);
           Node curr = prev.next;
           Node forw = curr.next;
           
           prev.next = forw;
           curr.next = null;

           this.numberofnodes--;
           return curr;
        }
        }
        public int removeAt(int idx) throws Exception{
            if(size()==0){
                throw new Exception("linklist is empty");

            }
            else if(idx <0 || idx >= size()){
                throw new Exception("invalid exception");
            }
            Node node = removeNodeAt(idx);
            return node.data;
        }
        //================get first node========
        public int getFirst() throws Exception{
            if(size()==0){
                throw new Exception("Linklist is empty");

            }
            return this.head.data;
        }
        //==========================get last node===========
        public int getLast() throws Exception{
            if(size()==0){
                throw new Exception("Linklist is empty");

            }
            return this.tail.data;

        }
        //=================get at==============
        public int getAt(int idx) throws Exception{
            if(size()==0){
                throw new Exception("linklist is empty");

            }
            else if(idx <0 || idx >= size()){
                throw new Exception("invalid index");
            }
            return getNodeAt(idx).data;

        }
    }


