void setup(){
  size(1550,500);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][]    { {0, 0, 0},
                                             {0, -1, 0},
                                           {0, 0, 0} } );
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
