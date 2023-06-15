package one.microstream.storage;

import one.microstream.enterprise.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.reference.Lazy;


public class DB
{
	private static final DB INSTANCE = new DB();
	
	public static DB get()
	{
		return INSTANCE;
	}
	
	private final Lazy<DataRoot>					root;
	private final ClusterStorageManager<DataRoot>	storage	= new ClusterStorageManager<>(new DataRoot());
	// public final static DataRoot root = new DataRoot();
	// private final static EmbeddedStorageManager storageManager =
	// EmbeddedStorageConfiguration.Builder().setStorageDirectory(
	// "data").createEmbeddedStorageFoundation().createEmbeddedStorageManager(root).start();
	
	public DB()
	{
		this.root = this.storage.getRoot();
	}
	
	public ClusterStorageManager<DataRoot> storage()
	{
		return this.storage;
	}
	
	public DataRoot root()
	{
		return this.root.get();
	}
	
	// public DB()
	// {
	//
	// }
	//
	// public DataRoot root()
	// {
	// return this.root;
	// }
	//
	// public EmbeddedStorageManager storage()
	// {
	// return this.storageManager;
	// }
}
