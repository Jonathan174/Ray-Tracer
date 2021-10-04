/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package raytracer.lights;

import raytracer.*;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

/**
 *
 */
public class DirectionalLight extends Light {
    private Vector3D direction;

    /**
     * Constructor of DirectionalLight class
     * @param position is de position of our light
     * @param direction is de orientation of our light
     * @param color the color of the light, it can be anything rgb
     * @param intensity ilumination of the light, caution not to exceed
     */
    public DirectionalLight(Vector3D position, Vector3D direction, Color color, double intensity){
        super(position, color, intensity);
        setDirection(Vector3D.normalize(direction));
    }

    /**
     *
     * @return the direction of our light, this parameter is in constructor
     */
    public Vector3D getDirection() {
        return direction;
    }

    /**
     *
     * @param direction indicate where the light is pointing, is type Vector 3D
     */
    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }

    @Override
    public float getNDotL(Intersection intersection) {
        return (float)Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(), -1.0)), 0.0);
    }
}
