function view_PhotoCard(filename) {
  const Y_pos = window.scrollY || document.documentElement.scrollTop;
  location.href = "/photoCard/" + filename;
}

function close_PhotoCard() {
  history.back();
}
