union () {
  difference () {
    translate ([0, 0, 2.0]) {
      cylinder ($fn=90, h=4.0, r=2.9, center=true);
    }
    translate ([0, 0, 1.25]) {
      union () {
        cube ([1.5, 4.05, 4.5], center=true);
        rotate (a=90.0, v=[0, 0, 1]) {
          cube ([1.5, 4.05, 4.5], center=true);
        }
      }
    }
  }
  translate ([0, 0, 4.0]) {
    translate ([0, 0, 2.0]) {
      union () {
        cube ([1.4, 5.0, 4.5], center=true);
        rotate (a=90.0, v=[0, 0, 1]) {
          cube ([1.4, 5.0, 4.5], center=true);
        }
      }
    }
  }
}
