/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */

package raytracer;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

public interface IIntersectable {
    public abstract Intersection getIntersection(Ray ray);
}
