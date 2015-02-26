
class TestCircle2d
{
    public static void main(String[] args)
    {
        Circle2d circle1 = new Circle2d(2,2,5.5);
        System.out.println("The area of cricle1 is :"+circle1.getArea()+"perimeter :"+circle1.getPerimiter());
        
        System.out.println("The circle with 3,3 contains  :"+circle1.isContain(3, 3));
        System.out.println("The circle with 4,5 with radius 10.5 contains  :"+circle1.isContains(new Circle2d(4, 5, 10.5)));
         System.out.println("The circle with 3,5 with radius 2.3 overlops  :"+circle1.isOverlaps(new Circle2d(3, 5, 2.3)));
    }
}
