function myFunction(){
   var choice = prompt("Please select the member you wish to request payment from:");
    alert("A payment request has been sent to: " + choice)
return;
}
function otherFunction(){
    confirm("The current payments are pending: (Will display information retrieved from the database)");
return;
}

function contact(){
    //retrieve info from database
    alert("Name: \nPhone Number:\nEmail Address:");
    return;
}

function itemFind(){
   var searched = document.getElementById("query").value;
   alert("Search results for:" + searched);
}