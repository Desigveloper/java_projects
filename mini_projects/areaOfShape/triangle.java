package mini_projects.areaOfShape;

class Triangle {
  double area;
  int len, height;
  
  public static void main(String[] args) {
    int x = 0;

    Triangle [] triAngle = new Triangle[4];

    while (x < 4) {
        triAngle[x] = new Triangle();
        triAngle[x].height = (x + 1) * 2;
        triAngle[x].len = x + 4;
        triAngle[x].setArea();
        System.out.println("Triangle " + x + ", area = " + triAngle[x].area);
        x++;
    }

     int y = x;
     x = 27;
     Triangle triAngle5 = triAngle[2];
     triAngle[2].area = 323;

     System.out.println("y = " + y + ", triangle5 area = " + triAngle5.area);
}

     void setArea() {
        area = height * len / 2;
     }

}
