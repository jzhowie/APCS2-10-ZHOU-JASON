ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.collide(particles);
    c.display();
    //c.turn(2);
    //c.changeSpeed(0.1);
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow 
   if (mouseButton == LEFT) {
     for (Cow c : particles) {
       c.click();
     }
   }
   if (mouseButton == RIGHT) particles.add(new Cow(20 + (int)(Math.random() * 30), mouseX, mouseY, random(6)-3, random(6)-3));
}

void keyPressed() {
  //if (keyCode == 67) {
  //  particles.get(0).changeSpeed(5);
  //  println(degrees(atan2(-particles.get(0).dy, particles.get(0).dx)));
  //}
  //if (keyCode == 68) {
  //  for (Cow c : particles) {
  //    c.turn(15);
  //  }
  //}
  if (keyCode == 32) particles.clear();
}
