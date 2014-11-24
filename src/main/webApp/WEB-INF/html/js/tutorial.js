/**
	* This part show the modal window and allow  us submitting the deleting operation
	*/
	$('#confirm-delete').on('show.bs.modal', function(e) {
	    $(this).find('.danger').attr('href', $(e.relatedTarget).data('href'));
	});
	/**
	 * We delete the employe and refresh the table
	 * @param employeId
	 * @returns
	 */
	function deleteEmploye(employeId){
		$.ajax({
			  url: "../delete.employe?employeId="+employeId,
			  context: document.body
			}).done(function(data) {
				refreshEmployeTable(data);
				$( this ).addClass( "done" );
			});
	}
	
	function getCurrentEmployeValues(employeId){
		$.ajax({
			  url: "../get.employe?employeId="+employeId,
			  context: document.body
			}).done(function(data) {
				fillFormData(data);
				$( this ).addClass( "done" );
			});
	}
	/**
	 * This function refresh the list of employes
	 */
	function refreshEmployeTable(data){
		newEmployeList = "<table width=\"100%\" id=\"listEmploye\">"+
		"<th>EMPLOYE ID</th>"+
		"<th>FIRST NAME</th>"+
		"<th>LAST NAME</th>"+
		"<th>EXPERIENCE</th>";
		// we parse the Json file for display refresh
		for(var i=0;i<data.length;i++){
			newEmployeList = newEmployeList + "<tr>";
	        var employe = data[i];
	        for(var key in employe){
	            var attrName = key;
	            var attrValue = employe[key];
	            if (key=="employeId") currEmployeId = attrValue;// we get the current id in order to set it out of this loop
	            newEmployeList = newEmployeList + "<td>"+attrValue+"</td>";
	        };
	        newEmployeList = newEmployeList + "<td>" +
			"<button type=\"submit\" id=\"delete"+currEmployeId+"\" data-loading-text=\"deleting...\" class=\"btn btn-danger\" autocomplete=\"off\" onclick=\"javascript: employeId = "+currEmployeId+";\" value=\""+currEmployeId+"\" data-toggle=\"modal\" data-target=\"#confirm-delete\">Delete</button>"+
			"</td>";
			newEmployeList = newEmployeList + "<td>" +
	        "<button type=\"submit\" id=\"update"+currEmployeId+"\" data-loading-text=\"updating...\" class=\"btn btn-info\" autocomplete=\"off\" onclick=\"getCurrentEmployeValues("+currEmployeId+")\" value=\""+currEmployeId+"\" data-toggle=\"modal\" data-target=\"#modal-edit-window\">Edit</button>"+
	        "</td>"; 
	        newEmployeList = newEmployeList + "</tr>";  
		};
		newEmployeList = newEmployeList + "</table>";
		$('#listEmploye').html(newEmployeList);
	}
	
	
	/**
	 * This function fill form Data
	 */
	function fillFormData(data){
		$('#employeId').val(data['employeId']);
		$('#firstName').val(data['firstName']);
		$('#lastName').val(data['lastName']);
		$('#experience').val(data['experience']);		
	}