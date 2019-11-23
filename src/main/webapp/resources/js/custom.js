$(function () {
    changeFormElemVisibility($('#procBtn'), true);
});

const changeFormElemVisibility = function (elem, val) {
    elem.attr('disabled', val);
};

$('#newBorrow').submit(function (e) {
    e.preventDefault();
    if (areBorrowFormDataValid()) {
        $.ajax({
            url: 'save',
            method: 'POST',
            data: JSON.stringify(serializeForm($(this))),
            dataType: 'json',
            success: function (data) {
                location.replace("dashboard");
            },
            error: function (data) {
                console.log(data);
                if(data.responseJSON.errorType === "ValidationError") {
                    alert("Validation");
                } else {
                    alert(data.responseJSON.message);
                }
            }
        });
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
        let amount = Math.ceil((new Date(ret.val() + "").getTime() - new Date(borr.val() + "").getTime()) / 1000 / 3600) * $("#rentPerHour").val();
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

$("#avail-form").submit(function (e) {
    e.preventDefault();
    if (!$('#startDate').valid() || !$('#endDate').valid()) {
        return;
    }
    $.ajax({
        url: 'availability',
        method: 'GET',
        dataType: 'json',
        data: $(this).serialize(),
        success: function (data) {
            $('.avSlot').remove();
            let elements = "";
            for (let i = 0; i < data.length; i++) {
                elements += "<div class='col-lg-4 avSlot'>"
                    + "<p>From: <em class='avStartDate'>" + formatDate(data[i].startDate) + "</em></p>"
                    + "<p>To: <em class='avEndDate'>" + formatDate(data[i].endDate) + "</em></p>"
                    + "<p><button class='btn btn-sm btn-outline-info avBtn' type='button'>Choose</button></p>"
                    + "</div>"
            }
            $('#availableTimeSlots').append(elements);
        }
    });
});

function formatDate(d) {
    let hour = d.hour;
    let minute = d.minute;
    if(("" + hour).length === 1) {
        hour = "0" + hour;
    }
    if(("" + minute).length === 1) {
        minute = "0" + minute;
    }

    return d.monthValue + "/" + d.dayOfMonth + "/" + d.year + " " + hour + ":" + minute;
}

$(document).on('click', '.avBtn', function(e) {
    e.preventDefault();
    let par = $(this).parent().parent();
    $('#borrowedDate').val(par.find("p:nth-child(1)>em").html());
    $('#returnDate').val(par.find("p:nth-child(2)>em").html());
    areBorrowFormDataValid();
});

function serializeForm(form) {
    let json = {};
    let formData = form.serializeArray();
    console.log(formData);
    $.each(formData, function () {
        if(this.name !== 'prod') {
            json[this.name] = this.value;
        }
    });
    console.log(json);
    return json;
}
