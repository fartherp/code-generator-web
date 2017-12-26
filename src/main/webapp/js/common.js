function isNullOrEmpty(strVal) {
    if (strVal == '' || strVal == null || strVal == undefined) {
        return true;
    } else {
        return false;
    }
}

function success(data) {
    // 1:为错误，返回false
    if (null == data || '' == data || undefined == data || data.status == 1) {
        $.messager.alert("提示", data.statusInfo, "info");
        return false;
    }
    return true;
}

function successJsonToObject(result) {
    var data = JSON.parse(result);
    // 1:为错误，返回false
    if (null == data || '' == data || undefined == data || data.status == 1) {
        $.messager.alert("提示", data.statusInfo, "info");
        return false;
    }
    return true;
}

function error(data) {
    if (null == data || '' == data || undefined == data || data.status == 1) {
        $.messager.alert("提示", data.statusInfo, "info");
    } else{
        $.messager.alert("提示", "请求数据失败!", "info");
    }
}

function errorJsonToObject(result) {
    var data = JSON.parse(result);
    if (null == data || '' == data || undefined == data || data.status == 1) {
        $.messager.alert("提示", data.statusInfo, "info");
    } else{
        $.messager.alert("提示", "请求数据失败!", "info");
    }
}

function legend(names) {
    var legend = [];
    for (var i = 0; i < names.length; i++) {
        legend.push(names[i]);
    };
    return legend;
}

function series(names, type, datas) {
    var series = [];
    for (var i = 0; i < names.length; i++) {
        series.push({
            name: names[i],
            type: type,
            itemStyle: {normal: {label: {show: true, position: 'inside'}}},
            data: datas[names[i]]
        });
    };
    return series;
}

function clearForm(f) {
    f.form('clear');
}

function openWindow(w) {
    w.window('open');
}

function closeWindow(w) {
    w.window('close');
}

function page_list(url, params, success, error_e) {
    $.getJSON(url, params, function (json) {
        if (json.status) {
            error_e();
            error(json);
        } else {
            var data = {
                total: json.data.total,
                rows: json.data.rows
            };
            success(data);
        }
    });
}

function G(id) {
    return document.getElementById(id);
}