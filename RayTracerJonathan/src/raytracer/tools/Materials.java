package raytracer.tools;

public class Materials {

    private double diffuse;
    private double shininess;
    private Boolean reflection;
    private double refractive;

    public double getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(double diffuse) {
        this.diffuse = diffuse;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public Boolean getReflection() {
        return reflection;
    }

    public void setReflection(Boolean reflection) {
        this.reflection = reflection;
    }

    public double getRefractive() {
        return refractive;
    }

    public void setRefractive(double refractive) {
        this.refractive = refractive;
    }

    /**
     * Constructor
     * @param diffuse
     * @param shininess
     * @param reflection
     * @param refractive
     */
    public Materials(double diffuse, double shininess, Boolean reflection, double refractive) {
        setDiffuse(diffuse);
        setShininess(shininess);
        setReflection(reflection);
        setRefractive(refractive);

    }

}

