/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package raytracer.lights;

import raytracer.*;
import raytracer.objects.*;
import raytracer.tools.Materials;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

public abstract class Light extends Object3D {
    private double intensity;
    private static Materials material = new Materials(0, 0,false, 0.0);

    /**
     * Constructor
     * @param position is de position initial of our light
     * @param color the color of the light, it can be anything rgb
     * @param intensity ilumination of the light, caution not to exceed
     */
    public Light(Vector3D position, Color color, double intensity){
        super(position, color, material);
        setIntensity(intensity);
    }

    /**
     *
     * @return intensity, return a double value
     */
    public double getIntensity() {
        return intensity;
    }

    /**
     *
     * @param intensity type double, is te ilumination magnitud
     */
    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public abstract float getNDotL(Intersection intersection);

    /**
     *
     * @param ray is type Ray, is a ray representing the intersection of de light ray
     * @return a intersection, ray collision
     */
    public Intersection getIntersection(Ray ray){
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}
