/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package raytracer.lights;

import raytracer.Intersection;
import raytracer.Vector3D;

import java.awt.*;

/**
 * @author Jafet Rodríguez & Jonathan Cuevas
 */
public class PointLight extends Light {
    /**
     * Constructor
     * @param position is de position of our light
     * @param color the color of the light, it can be anything rgb
     * @param intensity ilumination of the light, caution not to exceed
     */
    public PointLight(Vector3D position, Color color, double intensity) {
        super(position, color, intensity);
    }

    @Override
    public float getNDotL(Intersection intersection) {
        return (float) Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.normalize(Vector3D.substract(getPosition(), intersection.getPosition()))), 0.0);
    }
}
