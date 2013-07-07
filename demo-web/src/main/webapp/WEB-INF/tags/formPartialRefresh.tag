<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="formName" required="true" rtexprvalue="true" description="no need to add a '#'"%>
<%@ attribute name="successHandler" required="false" rtexprvalue="true" description="Callback function to call"%>
<!-- formPartionRefresh -->
<script type="text/javascript">
			$(document).ready(function() {
				var form = $('#${formName}');
				form.bind('submit', function(e) {
					// Ajax validation
					var $inputs = form.find('input, .combobox');
					var data  = collectFormData($inputs);

					
					$.post(form.attr( 'action' ), data,	function(response) {
						form.find('.control-group').removeClass('error');
						form.find('.help-inline').empty();
						form.find('.alert').remove();
						if ("${successHandler}" != undefined){
							${successHandler}(response);
						}
					}, 'json');

					e.preventDefault();
					return false;
				});
			});
		</script>
