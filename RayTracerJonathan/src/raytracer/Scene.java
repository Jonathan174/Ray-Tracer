/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */

package raytracer;

import raytracer.lights.Light;
import raytracer.objects.Camera;
import raytracer.objects.Object3D;

import java.util.ArrayList;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

public class Scene {
    /**
     * class scene data: lights, camera, objects
     */

    private Camera camera;
    private ArrayList<Object3D> objects;
    private ArrayList<Light> lights;

    /**
     * Constructor
     */
    public Scene(){
        setObjects(new ArrayList<Object3D>());
        setLights(new ArrayList<Light>());
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void addObject(Object3D object){
        getObjects().add(object);
    }

    public ArrayList<Object3D> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Object3D> objects) {
        this.objects = objects;
    }

    public ArrayList<Light> getLights() {
        return lights;
    }

    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    public void addLight(Light light){
        getLights().add(light);
    }
}