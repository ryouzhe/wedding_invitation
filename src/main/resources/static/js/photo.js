const slide_wrap = document.getElementById("photo_wrap");

let view_width = slide_wrap.offsetWidth; //photoView width value
let init_index = 1; // slide_index 초기값
let slide_speed = 300; // slide 이동시간

const slide_items = document.getElementsByClassName("slide_item");
slide_wrap.style.width = view_width * (slide_items.length + 2) + "px";
for (let i = 0; i < slide_items.length; i++) {
    slide_items[i].style.width = view_width + "px";
}

const copy_init_slide = slide_items[0].cloneNode();                      // 첫 번째 슬라이드 복사본
const copy_last_slide = slide_items[slide_items.length - 1].cloneNode(); // 마지막 슬라이드 복사본
slide_wrap.append(copy_init_slide);
slide_wrap.prepend(copy_last_slide);

slide_wrap.style.left = view_width * -selected_index + "px";
let slide_index = selected_index;
let last_index = slide_items.length - 2; // slide_index 복사본 제외한 마지막 값
console.log(slide_index);

// 이전 사진
function movePre() {
    let moveVal = 0;

    if (slide_index === selected_index) moveVal = view_width;
    else if (slide_index < selected_index) moveVal = (selected_index - (slide_index - 1)) * view_width;
    else if (slide_index > selected_index) moveVal = -(slide_index - (selected_index + 1)) * view_width;
    slide_index -= 1;
    console.log(slide_index);

    slide_wrap.style.transition = slide_speed + "ms";
    slide_wrap.style.transform = "translate(" + moveVal + "px, 0px)";

    if (slide_index === 0) {
        setTimeout(() => {
            moveVal = view_width * (last_index - selected_index);
            slide_wrap.style.transition = "0ms";
            slide_wrap.style.transform = "translate(-" + moveVal + "px, 0px)";
            slide_index = last_index;
        }, slide_speed);
    }
}

// 다음 사진
function moveNext() {
    let moveVal = 0;

    if (slide_index === selected_index) moveVal = -view_width;
    else if (slide_index < selected_index) moveVal = (selected_index - (slide_index + 1)) * view_width;
    else if (slide_index > selected_index) moveVal = -(slide_index - (selected_index - 1)) * view_width;;
    slide_index += 1;
    console.log(slide_index);

    slide_wrap.style.transition = slide_speed + "ms";
    slide_wrap.style.transform = "translate(" + moveVal + "px, 0px)";
    // console.log(moveVal);

    if (slide_index === last_index + 1) {
        setTimeout(() => {
            moveVal = (selected_index - init_index) * view_width;
            slide_wrap.style.transition = "0ms";
            slide_wrap.style.transform = "translate(" + moveVal + "px, 0px)";
            slide_index = init_index;
        }, slide_speed);
    }
}

function close_PhotoCard() {
    history.back();
}
