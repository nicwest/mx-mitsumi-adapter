translate ([0, 0, 2.0]) {
  union () {
    cube ([1.4, 5.0, 4.5], center=true);
    rotate (a=90.0, v=[0, 0, 1]) {
      cube ([1.4, 5.0, 4.5], center=true);
    }
  }
}
