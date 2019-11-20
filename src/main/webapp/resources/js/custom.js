$(function () {
    changeFormElemVisibility($('#procBtn'), true);
});

const changeFormElemVisibility = function (elem, val) {
    elem.attr('disabled', val);
};

$('#newBorrow').submit(function (e) {
    e.preventDefault();
    if(areBorrowFormDataValid()) {

    }
});

$('#returnDate').blur(function () {
    areBorrowFormDataValid()
});

$('#borrowedDate').blur(function () {
    areBorrowFormDataValid();
});

const areBorrowFormDataValid = function () {
    let borr = $("#borrowedDate");
    let ret = $("#returnDate");
    let amt = $('#amountPaid');
    let procBtn = $('#procBtn');
    if (borr.valid() && ret.valid()) {
        let amount = Math.ceil((new Date(ret.val() + "").getTime() - new Date(borr.val() + "").getTime()) / 1000 / 3600) * 5;
        if (amount > 0) {
            amt.val(amount);
            changeFormElemVisibility(procBtn, false);
            return true;
        }
    }
    amt.val("0");
    changeFormElemVisibility(procBtn, true);
    return false;
};
