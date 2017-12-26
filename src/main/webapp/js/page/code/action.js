$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '表名列表',
        loadMsg: '数据加载中...',
        singleSelect: false,
        columns: colModel,
        toolbar: '#toolbar'
    });

    $('#isColumnNameDelimited').combobox({
        data : [{
            text: "是",
            value: 1,
            selected: 'selected'
        },{
            text: "否",
            value: 2
        }],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });

    $.getJSON('../kv/hint?module=1', function(json) {
        $('#generatorType').combobox({
            data : json.dataList,
            valueField: 'value',
            textField: 'text',
            panelHeight: 'auto'
        });
    });
});

function listLoader(param, success, error) {
    var params = {
        classpath: $('#classpath').val(),
        projectName: $('#projectName').val(),
        user: $('#user').val(),
        password: $('#password').val(),
        url: $('#url').val(),
//        path: $('#path').val(),
        generatorType: $('#generatorType').combobox('getValue'),
        isColumnNameDelimited: $('#isColumnNameDelimited').combobox('getValue')
    };
    page_list('selectTableName', params, success, error);
}

function doSearch() {
    $('#list').datagrid('reload');
}

function doCode() {
    var row = $('#list').datagrid('getChecked');
    if (row.length == 0) {
        $.messager.alert("提示", "请选择需要生成的表", "info");
        return;
    }
    var tableNames = [];
    for (var i = 0; i < row.length; i++) {
        tableNames.push(row[i].tableName);
    }
    $('#queryForm').form('submit', {
        url: "download",
        onSubmit: function(param) {
            param.tableNames = tableNames.toString()
        }
    });
}
