public class Circle2d 
{
    private double x,y;
    private double radius;
    
    public Circle2d()
    {
        x=0;
        y=0;
        radius=1.0;
    }
    public Circle2d(double CenterX,double CenterY,double radius1)
    {
    x = CenterX;
    y = CenterY;
    radius = radius1;
    }
public double getX()
{
return x;
}
public double getY()
{
return y;
}
public double getRadius()
{
return radius;
}

public double getArea()
{
return Math.PI*radius*radius;
}
public double getPerimiter()
{
return 2*Math.PI*radius;
}
public boolean isContain(double x1,double y1)
{
double dist = Math.sqrt(((x1-x)*(x1-x))-((y1-y)*(y1-y)));
if(dist>radius) {
return false;
}
else {
return true;
}
}
public boolean isContains(Circle2d circle)
{
    double dist;
dist = Math.sqrt(((x-circle.x)*(x-circle.x))-((y-circle.y)*(y-circle.y)));
if(dist+circle.radius<=radius) {
return true;
}
else {
return false;
}
}
public boolean isOverlaps(Circle2d circle)
{
double dist;
dist = Math.sqrt(((x-circle.x)*(x-circle.x))-((y-circle.y)*(y-circle.y)));
if(dist<(radius+circle.radius)) {
return true;
}
else {
return false;
}
}
}
