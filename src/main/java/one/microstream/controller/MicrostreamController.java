package one.microstream.controller;

import io.micronaut.http.annotation.Controller;
import one.microstream.cluster.nodelibrary.micronaut.StorageClusterController;

@Controller("/my-microstream-path")
public class MicrostreamController extends StorageClusterController
{
}
