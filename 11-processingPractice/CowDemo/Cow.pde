public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    //stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    
    if (selected) {
      fill(0);
      ellipse(x + (radius / 2), y - (radius / 3), radius/4, radius/4);
      ellipse(x - (radius / 2), y - (radius / 3), radius/4, radius/4);
      stroke(0);
      line(x, y + (radius / 2), x + (radius / 2), y + (radius / 3));
      line(x, y + (radius / 2), x - (radius / 2), y + (radius / 3));
      textSize(10);
      text("SpeedX: "+dx+"\nSpeedY: "+dy, x + (radius + 3), y - (radius / 4));
    }
      
  }

  void click() {
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (dist(mouseX, mouseY, x, y) <= radius) {
    selected = !selected;
   }

}
}
