package one.microstream;

import io.micronaut.http.annotation.Controller;
import one.microstream.enterprise.cluster.nodelibrary.micronaut.StorageClusterController;

@Controller("/my-microstream-path")
public class MicrostreamController extends StorageClusterController
{
}
