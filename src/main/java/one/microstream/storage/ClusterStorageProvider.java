package one.microstream.storage;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.cluster.nodelibrary.common.spi.ClusterStorageManagerProvider;

public class ClusterStorageProvider implements ClusterStorageManagerProvider
{

	@Override
	public ClusterStorageManager<?> provideClusterStorageManager()
	{
		return DB.get().storage();
	}
	
}
