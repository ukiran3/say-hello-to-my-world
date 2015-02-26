import java.io.*;
public abstract class GeometricObject
{
	public abstract int getArea();
	public abstract GeometricObject max(GeometricObject o1, GeometricObject o2);
}