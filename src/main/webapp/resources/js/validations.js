
$('#newBorrow').validate({
    rules: {
        borrowedDate: {
            required:true,
            date:true
        },
        returnDate: {
            required:true,
            date:true
        }
    },
    messages: {
        borrowedDate: {
            required:"Borrowed date is required!"
        },
        returnDate: {
            required:"Return date is required!"
        }
    }
});

$('#avail-form').validate({
    rules: {
        startDate: {
            required:true
        },
        endDate: {
            required:true
        }
    },
    messages: {
        startDate: {
            required:"Start date is required!"
        },
        endDate: {
            required:"Start date is required!"
        }
    }
});
