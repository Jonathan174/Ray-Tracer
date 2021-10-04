/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */

package raytracer.objects;

import raytracer.IIntersectable;
import raytracer.Vector3D;
import raytracer.tools.Materials;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

public abstract class Object3D implements IIntersectable {

    private Vector3D position;
    private Color color;
    private Materials materials;

    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Materials getMaterials() { return materials; }

    public void setMaterials(Materials materials) { this.materials = materials; }

    /**
     * Constructor
     * @param position is the position initial of de object
     * @param color color visual of object
     * @param materials can be editable, contiains diffuse, shinnes, reflection and refraction
     */
    public Object3D(Vector3D position, Color color, Materials materials) {
        setPosition(position);
        setColor(color);
        setMaterials(materials);
    }
}