var baseurl = window.location.origin+window.location.pathname;
$(document).ready(function() {
    $('#addEmpTable').DataTable();
});

$("#empForm").on('submit',function(e){
	e.preventDefault();
	var data = JSON.stringify({
		  "firstName": $("#firstName").val(),
		  "lastName": $("#lastName").val(),
		  "address": $("#address").val(),
		  "mobileNo": $("#mobileNo").val(),
		});
	callAjax('POST',baseurl+'/api/employee',data,popupShow)
})

$("#empUpdateForm").on('submit',function(e){
	e.preventDefault();
	var data = JSON.stringify({
		  "firstName": $("#updatefirstName").val(),
		  "lastName": $("#updatelastName").val(),
		  "address": $("#updateaddress").val(),
		  "mobileNo": $("#updatemobileNo").val(),
		});
	callAjax('PUT',baseurl+'/api/employee/'+$("#empId").val(),data,popupShow)
})

function popupShow(data){
	Swal.fire({
		icon: 'success',
	  title: '',
	  text: data.response.message,
	}).then((result) => {
		location.reload();
	})
}

$(".editBtn").on('click',function(e){
	var empId = $(this).attr('empID')
	callAjax('GET',baseurl+'/api/employee/'+empId,null,editModelCallBack)
})

$(".delBtn").on('click',function(e){
	var empId = $(this).attr('empID')
	Swal.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Yes, delete it!'
}).then((result) => {
  if (result.isConfirmed) {
	  callAjax('DELETE',baseurl+'/api/employee/'+empId,null,popupShow)
  }
})
	
	
})



function editModelCallBack(response){
	var data = response.response;
	$('#empUpdateForm')[0].reset();
	$("#updatefirstName").val(data.firstName),
	$("#updatelastName").val(data.lastName),
	$("#updateaddress").val(data.address),
	$("#updatemobileNo").val(data.mobileNo),
	$("#empId").val(data.id)
	$("#updateModel").modal('show');
}

function callAjax(method,url,parameters,successCallback) {
	$.ajax({
        type: method,
        url: url,
        data: parameters,
        contentType: 'application/json;',
        dataType: 'json',
        success:successCallback,
        error: function(xhr, textStatus, errorThrown) {
        	Swal.fire({
        		icon: 'error',
        		title: 'opps..',
        		text: xhr.responseJSON.response.message,
    		})
        }
    });
	
}