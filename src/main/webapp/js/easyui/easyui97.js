/**
 *  <span class="my97-wrap">
 *      <input id="my97_2" type="text" class="easyui-validatebox my97-text" data-options="required:true" onclick="WdatePicker();">
 *      <span>
 *          <span class="my97-arrow" onclick="WdatePicker({el:'my97_2'});"></span>
 *      </span>
 *  </span>
 */
(function ($) {
    $.parser.plugins.push('my97');

    function init(target) {
        $(target).addClass("my97-text")
        var wrap = $("<span class=\"my97-wrap\"></span>").insertBefore(target);
        wrap[0].appendChild(target);
        $("<span class=\"my97-arrow\"></span>").insertAfter(target);
        return wrap;
    }

    function bindEvents(target) {
        var data = $.data(target, "my97");
        var opts = data.options;
        var wrap = $.data(target, "my97").my97;
        var input = wrap.find(".my97-text");
        var arrow = wrap.find(".my97-arrow");
        input.unbind(".my97");
        arrow.unbind(".my97");
        if (!opts.disabled) {
            input.bind("click.my97", function (e) {
                WdatePicker(opts);
            });
            arrow.bind("click.my97", function (e) {
                WdatePicker($.extend({}, opts, {el: opts.id}));
            }).bind('mouseover.my97', function (e) {
                    $(this).addClass('my97-arrow-hover');
            }).bind('mouseout.my97', function (e) {
                    $(this).removeClass('my97-arrow-hover');
            });
        }
    }

    function validate(target, params) {
        var opts = $.data(target, "my97").options;
        var input = $.data(target, "my97").my97.find("input.my97-text");
        input.validatebox(opts);
        if (params) {
            input.validatebox("validate");
        }
    }

    function initValue(target) {
        var opts = $.data(target, "my97").options;
        var input = $.data(target, "my97").my97.find("input.my97-text");
        input.val(opts.value);
    }

    function setDisabled(target, disabled) {
        var ops = $.data(target, "my97").options;
        var my97 = $.data(target, "my97").my97;
        var arrow = my97.find('.my97-arrow');
        if (disabled) {
            ops.disabled = true;
            $(target).attr("disabled", true);
            arrow.unbind('click.my97');
            arrow.unbind('hover.my97');
        } else {
            ops.disabled = false;
            $(target).removeAttr("disabled");
            arrow.unbind('click.my97').bind('click.my97', function () {
                WdatePicker(ops);
            });
            arrow.unbind('mouseover.my97').unbind('mouseout.my97')
                .bind('mouseover.my97', function (e) {
                    this.addClass('my97-arrow-hover');
                }).bind('mouseout.my97', function (e) {
                    this.removeClass('my97-arrow-hover');
                });
        }
    }

    function setWidth(target, width) {
        var opts = $.data(target, "my97").options;
        opts.width = width;
        $(target).width(width);
    }

    function setId(target) {
        var pre = "_easyui_my97_id_";
        var opts = $.data(target, "my97").options;
        opts.id = pre + $.fn.my97.defaults.count;
        $(target).attr("id", opts.id);
        $.fn.my97.defaults.count++;
    }

    $.fn.my97 = function (options, param) {
        if (typeof options == 'string') {
            return $.fn.my97.methods[options](this, param);
        }
        options = options || {};
        return this.each(function () {
            var data = $.data(this, 'my97');
            var opts;
            if (data) {
                opts = $.extend(data.options, options);
            } else {
                opts = $.extend({}, $.fn.my97.defaults, $.fn.my97.parseOptions(this), options);
                var wrap = init(this);
                data = $.data(this, 'my97', {
                    options: opts,
                    my97: wrap
                });
            }
            if (opts.id == undefined) {
                setId(this);
            }
            setWidth(this, data.options.width);
            setDisabled(this, data.options.disabled);
            bindEvents(this);
            validate(this);
            initValue(this);
        });
    }

    $.fn.my97.methods = {
        options: function (target) {
            return $.data(target[0], 'my97').options;
        },
        destroy: function (target, param) {
            return target.each(function () {
                var input = $.data(target, "my97").my97.find("input.my97-text");
                input.validatebox("destroy");
                $.data(target, "my97").my97.remove();
                $(target).remove();
            });
        },
        setWidth: function (target, param) {
            return target.each(function () {
                setWidth(this, param);
            });
        },
        setValue: function (target, param) {
            target.val(param);
        },
        getValue: function (target, param) {
            return target.val();
        }
    }

    $.fn.my97.parseOptions = function (target) {
        var t = $(target);
        return $.extend({}, $.fn.validatebox.parseOptions(target), $.parser.parseOptions(target, ["width", "height", "weekMethod", "lang", "skin", "dateFmt", "realDateFmt", 'realTimeFmt', 'realFullFmt', 'minDate', 'maxDate', 'startDate',
                {
                    doubleCalendar: "boolean",
                    enableKeyboard: "boolean",
                    enableInputMask: "boolean",
                    isShowWeek: "boolean",
                    highLineWeekDay: "boolean",
                    isShowClear: "boolean",
                    isShowOthers: "boolean",
                    readOnly: "boolean",
                    qsEnabled: "boolean",
                    autoShowQS: "boolean",
                    opposite: "boolean"
                }, {
                    firstDayOfWeek: "number",
                    errDealMode: "number"
                }]),
            {
                value: (t.val() || undefined),
                disabled: (t.attr("disabled") ? true : false),
                id: (t.attr("id") || undefined)
            });
    }

    $.fn.my97.defaults = {
        id: null,
        count: 0,
        value: '',
        width: 109,
        height: 22,
        disabled: false,
        doubleCalendar: false,
        enableKeyboard: true,
        enableInputMask: true,
        weekMethod: 'ISO8601',
        position: {},
        lang: 'auto',
        skin: 'default',
        dateFmt: 'yyyy-MM-dd',
        realDateFmt: 'yyyy-MM-dd',
        realTimeFmt: 'HH:mm:ss',
        realFullFmt: '%Date %Time',
        minDate: '1900-01-01 00:00:00',
        maxDate: '2099-12-31 23:59:59',
        startDate: '',
        firstDayOfWeek: 0,
        isShowWeek: false,
        highLineWeekDay: true,
        isShowClear: true,
        isShowOthers: true,
        readOnly: false,
        errDealMode: 0,
        qsEnabled: true,
        autoShowQS: false,
        opposite: false,
        quickSel: [],
        disabledDays: null,
        disabledDates: null,
        specialDates: null,
        specialDays: null,
        onpicking: function () {
        },
        onpicked: function () {
        },
        onclearing: function () {
        },
        oncleared: function () {
        }
    };
})(jQuery);
