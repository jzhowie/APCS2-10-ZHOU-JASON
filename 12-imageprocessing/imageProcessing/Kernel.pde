public class Kernel {
  float[][]kernel;

  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
    kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    if (x == 0 || y == 0 || x == img.width - 1 || y == img.height - 1) {
      return color(0, 0, 0);
    }
    
    int red = 0;
    int green = 0;
    int blue = 0;
    
    for (int i = 0; i < kernel.length; i++) {
      for (int j = 0; j < kernel[0].length; j++) {
        red += red(img.get(x-1+j, y-1+i)) * kernel[i][j];
        green += green(img.get(x-1+j, y-1+i)) * kernel[i][j];
        blue += blue(img.get(x-1+j, y-1+i)) * kernel[i][j];
      }
    }
    return color(red, green, blue);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.height; i++) {
      for (int j = 0; j < source.width; j++) {
        color c = calcNewColor(source, j, i);
        destination.set(j, i, c);
      }
  }

}
}
