package one.microstream;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.cluster.nodelibrary.common.spi.ClusterStorageManagerProvider;
import one.microstream.storage.DB;
import one.microstream.storage.DataRoot;

public class MyClusterStorageManagerProvider implements ClusterStorageManagerProvider
{
	@Override
	public ClusterStorageManager<DataRoot> provideClusterStorageManager()
	{
		return DB.get().storage();
	}
}
