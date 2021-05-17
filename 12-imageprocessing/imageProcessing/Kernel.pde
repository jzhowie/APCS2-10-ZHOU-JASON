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
    if (x - 1 == 0 || y - 1 == 0 || x == img.height - 1 || y == img.width - 1) {
      return 0;
    }
    return 255;
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    float[][] temp = new float[kernel.length][kernel[0].length];
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        calcNewColor(source, i, j);
      }
  }

}
}
