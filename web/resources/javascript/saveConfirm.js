/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function saveConfirm(form){
    var state = document.getElementById('formRecord:pageState').value;
    var viewMsg = document.getElementById('formRecord:viewMsg').value;
    var deleteMsg = document.getElementById('formRecord:deleteMsg').value;
    var editMsg = document.getElementById('formRecord:editMsg').value;
   
    
    if (state == "VIEW")
    {
        alert(viewMsg);
        return false;
    }     
    else if(state == "DELETE") 
    {
        return confirm(deleteMsg);
    }
    else
    {
        return confirm(editMsg);
    }
}