/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function saveConfirm(state){
    if (state == "VIEW")
    {
        alert('Nothing to save!');
        return false;
    }     
    else if(state == "DELETE") 
    {
        return confirm("Are you sure you want to delete this record?");
    }
    else
    {
        return confirm("Are you sure?");
    }
}

