function collectFormData(fields) {
				var data = {};
				for (var i = 0; i < fields.length; i++) {
					var $item = $(fields[i]);
					data[$item.attr('name')] = $item.val(); 
				}
				return data;
			}

			$(document).ajaxError(function(event, xhr, ajaxOptions, errorThrown) {
				if (xhr.status == 400){
					$.each($.parseJSON(xhr.responseText), function(item) {
						var controlGroup = $('#' + this.field);
						controlGroup.addClass('error');
						controlGroup.find('.help-inline').html(this.defaultMessage);
					});
				}
			});
			
