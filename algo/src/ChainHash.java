//チェイン法によるハッシュ
public class ChainHash<K,V> {
	//ハッシュを構成するノード
	class Node<K,V>{
		private K key;//キー値
		private V data;//データ
		private Node<K,V> next;//後続ノードへの参照


	//コンストラクタ
	Node(K key,V data,Node<K,V> next){
		this.key=key;
		this.data=data;
		this.next=next;
	}
	//キー値を返す
	K getKey() {
		return key;
	}
	//データを返す
	V getValue() {
		return data;
	}
	//キーのハッシュ値を返す
	public int hashCode() {
		return key.hashCode();
	}
}


	private int size;//ハッシュ表の大きさ
	private Node<K,V>[] table;//ハッシュ表

	//コンストラクタ
	@SuppressWarnings("unchecked")
	public ChainHash(int capacity) {
		try {
			table=new Node[capacity];
			this.size=capacity;
		}catch(OutOfMemoryError e) {//表を生成できなかった
			this.size=0;
		}
	}
	//ハッシュ値を求める
	public int hashValue(Object key) {
		return key.hashCode()%size;
	}
	//キー値keyをもつ要素の探索（データを返却）
	public V search(K key) {
		int hash=hashValue(key);//探索するデータのハッシュ値
		Node<K,V> p=table[hash];//着目ノード

		while(p!=null) {
			if(p.getKey().equals(key))
				return p.getValue();//探索成功
			p=p.next;//後続ノードに着目
		}
		return null;//探索失敗
	}
	//キー値key・データdataをもつ要素の追加
	public int add(K key,V data) {
		int hash=hashValue(key);//追加するデータのハッシュ値
		Node<K,V> p=table[hash];//着目ノード
		while(p!=null) {
			if(p.getKey().equals(key))//このキー値は登録済み
				return 1;
			p=p.next;//後続ノードに着目
		}
		Node<K,V> temp=new Node<K,V>(key,data,table[hash]);
		table[hash]=temp;//ノードを挿入
		return 0;
	}





	}


