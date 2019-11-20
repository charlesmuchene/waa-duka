
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
