/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */

package raytracer;

import raytracer.lights.DirectionalLight;
import raytracer.lights.Light;
import raytracer.objects.*;
import raytracer.tools.OBJReader;
import raytracer.lights.PointLight;
import raytracer.tools.Materials;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jafet Rodríguez & Jonathan Cuevas
 */

public class Raytracer {

    /**
     * Method main of de class
     * @param args
     */
    public static void main(String[] args){
        System.out.println(new Date());

        Materials blinnphong = new Materials(0,25,Boolean.FALSE, 0.0);
        Materials mirror = new Materials(0,10,Boolean.TRUE, 0.0);
        Materials neutro = new Materials(0, 0,Boolean.FALSE, 0.0);
        Materials refractive = new Materials(0, 40,Boolean.FALSE, 1.5);


        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 2000, 2000, 8.2f, 50f));
        scene01.addLight(new PointLight(new Vector3D(0.0f, 1.2f, 0f), Color.WHITE, 3.0));
        scene01.addObject(OBJReader.GetPolygon("Plane.obj", new Vector3D(0f, -3.5f, 5f), Color.WHITE, mirror));
        scene01.addObject(OBJReader.GetPolygon("Plane.obj", new Vector3D(0f, 3.5f, 5f), Color.WHITE, mirror));
        scene01.addObject(OBJReader.GetPolygon("PlaneVerticalFront.obj", new Vector3D(0f, 1.15f, 9.75f), Color.WHITE, mirror));
        scene01.addObject(OBJReader.GetPolygon("PlaneVertical.obj", new Vector3D(-3.51f, 0f, 5f), Color.WHITE, blinnphong));
        scene01.addObject(OBJReader.GetPolygon("PlaneVertical.obj", new Vector3D(3.4f, 0f, 5f), Color.WHITE, blinnphong));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-1.8f, -2.8f, 6.2f), Color.BLUE, blinnphong));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapotReverse.obj", new Vector3D(1.9f, -3.25f, 3f), Color.ORANGE, blinnphong));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapotDown.obj", new Vector3D( -1.5f, 2.1f, 5.5f), Color.GREEN, blinnphong));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapotReverseDown.obj", new Vector3D( 1.8f, 2.5f, 6.3f), Color.MAGENTA, blinnphong));
        scene01.addObject(new Sphere(new Vector3D(-1.6f, 2.0f,  1.8f) ,0.5f, Color.WHITE, refractive));
        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(1.7f, -2.5f, 0.3f), Color.WHITE, refractive));
        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-0.7f, -2.5f, 3.5f), Color.WHITE, refractive));


        Scene scene02 = new Scene();
        scene02.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 3000, 3000, 8.2f, 50f));
        scene02.addLight(new PointLight(new Vector3D(0.0f, 1f, -1.5f), Color.WHITE, 3.0f));
        scene02.addLight(new PointLight(new Vector3D(-1.5f, 3f, 0f), Color.WHITE, 3.0f));
        scene02.addObject(OBJReader.GetPolygon("BigPlane.obj", new Vector3D(0f, -3.5f, 6.0f), new Color(56, 52, 105), blinnphong));
        scene02.addObject(new Sphere(new Vector3D(0.7f, -2.9f,  6f) ,0.6f, Color.ORANGE, blinnphong));
        scene02.addObject(new Sphere(new Vector3D(0.7f, -1.7f,  3.4f) ,0.6f, Color.WHITE, refractive));
        scene02.addObject(new Sphere(new Vector3D(0.7f, -0.5f,  6f) ,0.6f, Color.RED, blinnphong));
        scene02.addObject(new Sphere(new Vector3D(0.7f, 0.7f,  3.4f) ,0.6f, Color.WHITE, refractive));
        scene02.addObject(new Sphere(new Vector3D(0.7f, 1.9f,  6f) ,0.6f, Color.BLUE, blinnphong));
        scene02.addObject(new Sphere(new Vector3D(0.7f, 2.7f,  3.4f) ,0.6f, Color.WHITE, refractive));
        scene02.addObject(new Sphere(new Vector3D(-3.0f, -0.5f,  9f) ,0.6f, Color.RED, blinnphong));
        scene02.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-3.2f, -3.4f, 6f), Color.BLUE, new Materials(0,22,Boolean.FALSE, 0.0)));
        scene02.addObject(OBJReader.GetPolygon("RingVertical.obj", new Vector3D(-1.5f, 0f, 6f), Color.WHITE, refractive));
        scene02.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(-2.5f, 2f, 4.5f), Color.GREEN, blinnphong));
        scene02.addObject(OBJReader.GetPolygon("Bunny.obj", new Vector3D(3.3f, -3.75f, 5.1f), new Color(255, 109, 233), new Materials(0,22,Boolean.FALSE, 0.0)));
        scene02.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(3.3f, -2.7f, 2.3f), Color.WHITE, refractive));
        scene02.addObject(OBJReader.GetPolygon("BigCube.obj", new Vector3D(-2.5f, -2.5f, 1.3f), Color.WHITE, refractive));


        Scene scene03 = new Scene();
        scene03.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 5000, 5000, 8.2f, 50f));
        scene03.addLight(new PointLight(new Vector3D(0.0f, 1.2f, 0f), Color.WHITE, 3.0));
        scene03.addObject(OBJReader.GetPolygon("BigPlane.obj", new Vector3D(0f, -3.5f, 5f), Color.WHITE, mirror));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot0.obj", new Vector3D(0f, 1.5f, 2.3f), new Color(87, 35, 100), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot315.obj", new Vector3D(0.95f, 0.95f, 2.3f), new Color(0, 0, 128), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot270.obj", new Vector3D(1.5f, 0f, 2.3f), new Color(0, 205, 219), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot225.obj", new Vector3D(0.95f, -0.95f, 2.3f), new Color(0, 191, 70), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot180.obj", new Vector3D(0f, -1.5f, 2.3f), new Color(148, 241, 0), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot135.obj", new Vector3D(-0.95f, -0.95f, 2.3f), Color.YELLOW, blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot90.obj", new Vector3D(-1.5f, 0f, 2.3f), new Color(255, 146, 14), blinnphong));
        scene03.addObject(OBJReader.GetPolygon("MiniTeapot45.obj", new Vector3D(-0.95f, 0.95f, 2.3f), Color.RED, blinnphong));
        scene03.addObject(new Sphere(new Vector3D(0.0f, 0.0f,  3.0f) ,0.7f, Color.WHITE, mirror));
        scene03.addObject(new Sphere(new Vector3D(.9f, -2.5f, 4.5f),0.3f, new Color(87, 35, 100), mirror));
        scene03.addObject(new Sphere(new Vector3D(-.9f, -2.5f, 4.5f),0.3f, new Color(0, 0, 128), mirror));
        scene03.addObject(new Sphere(new Vector3D(.9f, 2.5f, 4.5f),0.3f, Color.YELLOW, mirror));
        scene03.addObject(new Sphere(new Vector3D(-.9f, 2.5f, 4.5f),0.3f, new Color(148, 241, 0), mirror));
        scene03.addObject(new Sphere(new Vector3D(-2.5f, 1f, 4.5f),0.3f, new Color(0, 191, 70), mirror));
        scene03.addObject(new Sphere(new Vector3D(-2.5f, -1f, 4.5f),0.3f, new Color(0, 205, 219), mirror));
        scene03.addObject(new Sphere(new Vector3D(2.5f, 1f, 4.5f),0.3f, new Color(255, 146, 14), mirror));
        scene03.addObject(new Sphere(new Vector3D(2.5f, -1f, 4.5f),0.3f, Color.RED, mirror));


        BufferedImage image = raytrace(scene02);
        File outputImage = new File("Scene02.png");
        try{
            ImageIO.write(image, "png", outputImage);
        } catch (Exception e){
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    /**
     * Build a image with the scene
     * @param scene Scene contains all data, objects, etc.
     * @return the scene as image
     */
    public static BufferedImage raytrace(Scene scene) {
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = raycast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    if(closestIntersection.getObject().getMaterials().getReflection() == Boolean.TRUE){
                        int count =0;
                        Intersection reflection = Reflection(closestIntersection, objects, mainCamera, count);
                        if(reflection != null){
                            closestIntersection = reflection;
                        }
                    }
                    if(closestIntersection.getObject().getMaterials().getRefractive() > 0.0){
                        Intersection refraction = Refraction(scene, ray, closestIntersection);
                        if(refraction != null){
                            closestIntersection = refraction;
                        }
                    }
                    for (Light light : lights) {
                        float nDotL = light.getNDotL(closestIntersection);
                        float intensity = (float) light.getIntensity() * nDotL;
                        float distance = (float) Vector3D.magnitude(Vector3D.substract(closestIntersection.getPosition(), light.getPosition()));
                        float falloff = (float) (intensity/(Math.pow(distance, 1)));
                        Intersection shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.substract(light.getPosition(), closestIntersection.getPosition())), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                        Color lightColor = light.getColor();
                        Color objColor = closestIntersection.getObject().getColor();
                        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
                        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
                        double specular = Specular(closestIntersection, mainCamera, light);
                        double ambient = 0.035;
                        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                            objColors[colorIndex] *= (falloff+specular+ambient) * lightColors[colorIndex];
                        }
                        Color diffuse = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
                        if(shadow != null){
                            diffuse=Color.BLACK;
                        }
                        pixelColor = addColor(pixelColor, diffuse);
                    }
                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }
        return image;
    }

    /**
     * @param closestIntersection
     * @param camera
     * @param light
     * @return double value for specular parameter
     */
    public static double Specular(Intersection closestIntersection, Camera camera, Light light){
        Vector3D cameraPos = Vector3D.normalize(camera.getPosition());
        Vector3D lightPos = Vector3D.normalize(light.getPosition());
        Vector3D vectorsum = Vector3D.add(cameraPos, lightPos);
        Vector3D HalfVector = Vector3D.normalize(Vector3D.scalarMultiplication(vectorsum, 1/Vector3D.magnitude(vectorsum)));

        double shininess = closestIntersection.getObject().getMaterials().getShininess();
        double specular = Math.pow((Vector3D.dotProduct(closestIntersection.getNormal(), HalfVector)), shininess);
        return specular;
    }

    /**
     * @param value parameter to clamp
     * @param min minimiun value for the parameter
     * @param max max value of the parameter
     * @return the value within the parameters or maximized or minimized
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * @param original
     * @param otherColor
     * @return color blend with another
     */
    public static Color addColor(Color original, Color otherColor){
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * Sending rays to each of the object and see if is the way of the direction.
     * @param ray
     * @param objects
     * @param caster
     * @param clippingPlanes
     * @return intersection of ray, type intersection
     */
    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }
        return closestIntersection;
    }

    /**
     *Reflection function in case the object is reflective
     * @param closestIntersection
     * @param objects
     * @param mainCamera
     * @param count
     * @return the reflection Intersection and get its color
     */
    public static Intersection Reflection(Intersection closestIntersection,  ArrayList<Object3D> objects, Camera mainCamera, int count) {
        Boolean reflective = closestIntersection.getObject().getMaterials().getReflection();
        if (reflective == Boolean.TRUE && count <= 2){
            Vector3D intersectionNormal = closestIntersection.getNormal();
            Vector3D intersectionViewer = Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
            Vector3D doubleNormal= Vector3D.scalarMultiplication(intersectionNormal,-2);

            double nDotL= Vector3D.dotProduct(intersectionNormal,intersectionViewer);

            Vector3D nDotLTimesNormal= Vector3D.scalarMultiplication(doubleNormal,nDotL);
            Vector3D reflection = Vector3D.add(nDotLTimesNormal,intersectionViewer);
            Ray reflectionRay = new Ray(closestIntersection.getPosition(), reflection);

            for (Object3D object : objects) {
                if (!object.equals(closestIntersection.getObject())) {
                    Intersection reflectedIntersection = raycast(reflectionRay, objects, closestIntersection.getObject(), null);
                    if (reflectedIntersection == null) {
                        return closestIntersection;
                    } else {
                        return Reflection(reflectedIntersection, objects, mainCamera, count++);
                    }
                }
            }
        }
        return closestIntersection;
    }

    /**
     * Refraction function in case the object is refractive
     * @param scene
     * @param ray
     * @param closestIntersection
     * @return the refraction Intersection and get its color
     */
    public static Intersection Refraction(Scene scene, Ray ray, Intersection closestIntersection){
        Vector3D incident = Vector3D.normalize(ray.getDirection());
        double n = 1/(closestIntersection.getObject().getMaterials().getRefractive());
        double c1 = Vector3D.dotProduct(closestIntersection.getNormal(), incident);
        double c2 = Math.sqrt(1-Math.pow(n,2)*(1-Math.pow(c1,2)));
        Vector3D refractionVector = Vector3D.add(Vector3D.scalarMultiplication(incident,n), Vector3D.scalarMultiplication(closestIntersection.getNormal(), (n*c1)-c2));
        Ray refractionRay = new Ray(closestIntersection.getPosition(), refractionVector);

        for (Object3D object : scene.getObjects()) {
            if (!object.equals(closestIntersection.getObject())) {
                Intersection refractedIntersection = raycast(refractionRay, scene.getObjects(), closestIntersection.getObject(), null);
                if (refractedIntersection == null) {
                    return closestIntersection;
                } else {
                    return Refraction(scene, ray, refractedIntersection);
                }
            }
        }
        return closestIntersection;
    }
}