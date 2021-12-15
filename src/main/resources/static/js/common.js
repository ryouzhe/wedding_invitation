function view_PhotoCard(filename) {
  let photoNum = parseInt(filename.substring(6,7));
  location.href = "/photoCard/" + photoNum;
}