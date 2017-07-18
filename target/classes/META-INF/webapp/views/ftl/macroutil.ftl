<#macro formCreator id="" columns=[] gridWidth=2 formHorizontal=false buttons=[]>
	<form id="${id!}" class="padding-bottom-0 <#if formHorizontal>form-horizontal</#if>">
        <div class="row">
          	<#list columns as column>

          		<@formElementCreator formHorizontal=formHorizontal column=column gridWidth=gridWidth />

          	</#list>
        </div>
    		<div class="text-center">
    			<#list buttons as button>
    				<@buttonCreator class=button.class id=button.id onclick=button.onclick name=button.name />
    			</#list>
    		</div>
    </form>
</#macro>

<#macro formElementCreator formHorizontal=false column={} gridWidth=2>
	<#if column??>
		<#if !column.id??>
			<#assign columnId = column.name>
		<#else>
			<#assign columnId = column.id>
		</#if>
		<#if !column.placeholder??>
			<#assign placeholder = column.label>
		<#else>
			<#assign placeholder = column.placeholder>
		</#if>

		<#assign columnClass = "col-md-"+(12 / gridWidth) />
		<div class="${columnClass}">
			<#if column.type?? && column.type?lower_case=="select">
				<div class="form-group">
					<#if formHorizontal>
						<div class="col-md-3">
							<label class="control-label" for="${columnId!}">${column.label!}</label>
						</div>
		                <div class="col-md-7">
		                	<@dropdownCreator id = columnId value=column.value name = column.name class = "form-control" attrMap = column.attrMap options = column.options />
		                </div>
					<#else>
		                <label for="${columnId!}">${column.label!}</label>
		                <@dropdownCreator id = columnId value=column.value name = column.name class = "form-control" attrMap = column.attrMap options = column.options />
		            </#if>
		        </div>
	                <#-- <select id="${columnId!}" name="${column.name!}" class="form-control"
	                <#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
	                >
	                    <#list column.options as option>
	                    	<option value="${option.value!}">${option.name!}</option>
	                    </#list>
	                </select> -->
	        <#elseif column.columnType?? && column.columnType=='CUSTOM'>
	        	<#include column.name />
	        <#elseif column.columnType?? && column.columnType=='SELECT'>
	        	<div class="form-group">
					<div class="col-md-3">
						<label class="control-label" for="${columnId!}">${column.label!}</label>
					</div>

	                <div class="col-md-7">
	                	<@dropdownCreator id = columnId name = column.name class = "form-control" options =[{"name":"Select","value":""}]+column.options />
	                </div>
		        </div>
		    <#-- <#elseif column.columnType?? && column.columnType=='textArea'>
				<#if formHorizontal>
	        		<div class="col-md-3">
						<label class="control-label" for="${columnId!}">${column.label!}</label>
					</div>
	                <div class="col-md-7">
	                	<textarea cols="10" id="${columnId!}" name="${column.name!}" value="${column.value!}"></textarea>
	                </div>
	            <#else>
	            	<label for="${columnId!}">${column.label!}</label>
	               	<textarea cols="10" id="${columnId!}" name="${column.name!}" value="${column.value!}"></textarea>
	            </#if> -->
	        <#elseif column.type?? && column.type=='DATETIME'>
	        	<#if formHorizontal>
	        		<div class="form-group">
						<div class="col-md-2">
							<label class="control-label" for="${columnId!}">${column.label!}</label>
						</div>
						<div class="col-md-7">
		                	<div class="row">
		                		<div class="controls input-append date newDateTimePicker" data-date-format="dd/mm/yyyy HH:ii P">
				                    <input size="16" type="text" value="" class="form-control newDateTimePickerInput"  name="${column.name!}" id="${column.name!}" data-name="${column.name!}" value=""
				                    <#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
				                    >
				                    <span class="add-on input-group-addon white-background"><i class="icon-remove"></i></span>
									<span class="add-on input-group-addon white-background"><i class="icon-th"></i></span>
				                </div>
		                	</div>
		                </div>
			        </div>
			    <#else>
			    	<label class="control-label" for="${columnId!}">${column.label!}</label>
	            	<div class="row">
	            		<div class="col-md-12">
	            			<div class="row">
		                		<div class="controls input-append date newDateTimePicker" data-date-format="dd/mm/yyyy HH:ii P">
				                    <input size="16" type="text" value="" class="form-control newDateTimePickerInput"  name="${column.name!}" id="${column.name!}" data-name="${column.name!}" value=""
				                    <#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
				                    >
				                    <span class="add-on input-group-addon white-background"><i class="icon-remove"></i></span>
									<span class="add-on input-group-addon white-background"><i class="icon-th"></i></span>
				                </div>
		                	</div>
	            		</div>
	            	</div>
			    </#if>
			<#elseif column.type?? && column.type=='TEXTAREA'>
				<div class="form-group">
	        		<#if formHorizontal>
	            		<div class="col-md-3">
							<label class="control-label" for="${columnId!}">${column.label!}</label>
						</div>
		                <div class="col-md-7">
		                	<textarea rows="5" id="${columnId!}" name="${column.name!}" class="input-block-level"
		                	<#if column.attrMap??>
		                		<#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list>
		                	</#if>
		                	>
		                		${column.value!}
		                	</textarea>
		                </div>
		            <#else>
		            	<label for="${columnId!}">${column.label!}</label>
		                <textarea rows="5" id="${columnId!}" name="${column.name!}" class="input-block-level"
	                	<#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
	                	>${column.value!}</textarea>
		            </#if>
	            </div>
	        <#else>
	        	<div class="form-group">
	        		<#if formHorizontal>
	            		<div class="col-md-3">
							<label class="control-label" for="${columnId!}">${column.label!}</label>
						</div>
		                <div class="col-md-7">
		                	<input type="${column.type!"text"}" class="form-control" id="${columnId!}" name="${column.name!}" placeholder="${placeholder!}" value="${column.value!}"
		                	<#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
		                	>
		                </div>
		            <#else>
		            	<label for="${columnId!}">${column.label!}</label>
		                <input type="${column.type!"text"}" class="form-control" id="${columnId!}" name="${column.name!}" placeholder="${placeholder!}" value="${column.value!}"
		                <#if column.attrMap??><#list column.attrMap?keys as key>${key}="${column.attrMap[key]}"</#list></#if>
		                >
		            </#if>
	            </div>
	    	</#if>
	    </div>
	</#if>
</#macro>

<#macro dropdownCreator id="" name="" value="" class="" onchange="" options=[] attrMap={}>
	<select id="${id!}" name="${name!}" onchange="${onchange!}" class="${class?replace(',', ' ', 'r')!}" <#if attrMap??><#list attrMap?keys as key>${key}="${attrMap[key]}"</#list></#if> >
		<#list options as option>
			<#assign isSelected = false />
			<#if value?? && value?index_of(":") &gt; -1>
				<#if value?eval[option.value]>
					<#assign isSelected = true />
				<#else>
					<#assign isSelected = false />
				</#if>
			<#elseif value??>
				<#if value == option.value>
					<#assign isSelected = true />
				<#else>
					<#assign isSelected = false />
				</#if>
			</#if>
			<option value="${option.value!}" <#if isSelected>selected</#if> <#if option.disabled??>disabled</#if> > ${option.name!}</option>
        </#list>
    </select>
</#macro>

<#macro buttonCreator id="" name="" class="" onclick="" type="" attrMap={}>
	<button class="${class?replace(',', ' ', 'r')!}" onclick="${onclick!}" id="${id!}" type="${type!}" <#if attrMap??><#list attrMap?keys as key>${key}="${attrMap[key]}"</#list></#if> >${name!}</button>
</#macro>
