let form = document.forms.calculator;

form.waste_1.oninput = calculate;
form.waste_2.oninput = calculate;
form.waste_3.oninput = calculate;
form.waste_4.oninput = calculate;
form.waste_5.oninput = calculate;
form.waste_6.oninput = calculate;
form.waste_7.oninput = calculate;
form.waste_8.oninput = calculate;
form.waste_9.oninput = calculate;
form.waste_10.oninput = calculate;
form.waste_11.oninput = calculate;
form.waste_12.oninput = calculate;
form.waste_13.oninput = calculate;
form.waste_14.oninput = calculate;


function calculate() {

    let a = +form.waste_1.value;
    if (!a) return;

    let b = +form.waste_2.value;
    if (!b) return;

    let c = +form.waste_3.value;
    if (!c) return;

    let d = +form.waste_4.value;
    if (!d) return;

    let e = +form.waste_5.value;
    if (!e) return;

    let f = +form.waste_6.value;
    if (!f) return;

    let g = +form.waste_7.value;
    if (!g) return;

    let result_1 = a + b + c + d + e + f + g;
    
    document.getElementById('otchet_a_b').value = result_1;

    let z = +form.waste_8.value;
    if (!z) return;

    let i = +form.waste_9.value;
    if (!i) return;

    let k = +form.waste_10.value;
    if (!k) return;

    let v = +form.waste_11.value;
    if (!v) return;

    let r = +form.waste_12.value;
    if (!r) return;

    let l = +form.waste_13.value;
    if (!l) return;

    let w = +form.waste_14.value;
    if (!w) return;

    let result_2 = z + i + k + v + r + l + w;

document.getElementById('otchet_a').value = result_2;

}

calculate();