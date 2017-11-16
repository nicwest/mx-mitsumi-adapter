translate ([0, 0, 1.25]) {
  union () {
    cube ([1.5, 4.05, 4.5], center=true);
    rotate (a=90.0, v=[0, 0, 1]) {
      cube ([1.5, 4.05, 4.5], center=true);
    }
  }
}
