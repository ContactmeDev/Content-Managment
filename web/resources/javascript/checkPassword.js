/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function checkPassword(form){
    var password = form[form.id + ":password"].value;
    var userid = form[form.id + ":UserID"].value;
    
    if (password !== "" && userid !== "" )
        form.submit();
    else
        alert("Password and User ID shouldn't be empty");
}

