var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var JutakuKaishuShinseiDetailInput_Design = (function (_super) {
        __extends(JutakuKaishuShinseiDetailInput_Design, _super);
        function JutakuKaishuShinseiDetailInput_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JutakuKaishuShinseiDetailInput_Design.myLayout, fieldName);
        }
        Object.defineProperty(JutakuKaishuShinseiDetailInput_Design.prototype, "txtChakkoDate_lableLText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"])["labelLText"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"])["labelLText"] = value;
                } else {
                    this.layout.items[0].items[1].items[5]["labelLText"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(JutakuKaishuShinseiDetailInput_Design.prototype, "txtKanseiDate_lableLText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"])["labelLText"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"])["labelLText"] = value;
                } else {
                    this.layout.items[0].items[1].items[6]["labelLText"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(JutakuKaishuShinseiDetailInput_Design.prototype, "onClick_btnModifyDetail", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[1].items[9]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(JutakuKaishuShinseiDetailInput_Design.prototype, "btnModify_text", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[1].items[9]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        JutakuKaishuShinseiDetailInput_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("txtChakkoDate_lableLText");
            Uz.JSControlUtil.registProperty("txtKanseiDate_lableLText");
            Uz.JSControlUtil.registProperty("onClick_btnModifyDetail");
            Uz.JSControlUtil.registProperty("btnModify_text");
        };

        JutakuKaishuShinseiDetailInput_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["txtChakkoDate_lableLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["txtKanseiDate_lableLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["onClick_btnModifyDetail"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnModify_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["text"];

            return editablePropertyInfo;
        };
        JutakuKaishuShinseiDetailInput_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JutakuKaishuShinseiDetailInput",
                    "items": [
                        {
                            "fieldName": "dgJutakuKaishuDetail",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "540",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0",
                            "marginRight": "0",
                            "selectControlID": "dgJutakuKaishuDetail",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "227",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": true,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 1
                                },
                                "columns": [
                                    {
                                        "columnName": "着工<br>予定日",
                                        "dataName": "txtChakkoDueDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtChakkoDueDate"
                                    },
                                    {
                                        "columnName": "完成<br>予定日",
                                        "dataName": "txtKanseiDueDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKanseiDueDate"
                                    },
                                    {
                                        "columnName": "見積金額",
                                        "dataName": "txtMitsumoriAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtMitsumoriAmount"
                                    },
                                    {
                                        "columnName": "事業者",
                                        "dataName": "txtKaishuJigyosha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuJigyosha"
                                    },
                                    {
                                        "columnName": "改修対象住所",
                                        "dataName": "txtKaishuTaishoAddress",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuTaishoAddress"
                                    },
                                    {
                                        "columnName": "改修内容",
                                        "dataName": "txtKaishuContents",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuContents"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton",
                            "onSelectByDeleteButton": "onSelectByDeleteButton",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "txtKaishuJigyosha",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "JutakuKaishuDetailInput",
                            "items": [
                                {
                                    "fieldName": "txtKaishuContents",
                                    "items": [],
                                    "controlType": "TextBoxMultiLine",
                                    "width": "415",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtKaishuContents_text_area",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "XS",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "limitLength": "",
                                    "countDisp": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "改修の内容・<br>箇所及び規模",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "text": ""
                                },
                                {
                                    "fieldName": "txtKaishuJigyoshaName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "360",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtKaishuJigyoshaName_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "事業者",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "textAlign": 0,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "text": "",
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "lblKaishuTaishoAddress",
                                    "items": [],
                                    "controlType": "Label",
                                    "width": "105",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "lblKaishuTaishoAddress",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "required": false,
                                    "isPrivateInfo": false,
                                    "text": "対象住宅住所",
                                    "decorationClass": "",
                                    "align": 2
                                },
                                {
                                    "fieldName": "btnCopyAddress",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "-0.1",
                                    "marginRight": "XS",
                                    "selectControlID": "btnCopyAddress",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "本人住所をコピーする",
                                    "onClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": false
                                },
                                {
                                    "fieldName": "txtKaishuTaishoAddress",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "415",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "7",
                                    "marginRight": "XS",
                                    "selectControlID": "txtKaishuTaishoAddress_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "XS",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "textAlign": 0,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "text": "",
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtChakkoDueDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "80",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtChakkoDueDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "着工予定日",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "isPassword": false,
                                    "text": "",
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtKanseiDueDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "80",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtKanseiDueDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "完成予定日",
                                    "labelRText": "",
                                    "labelLWidth": "100",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "isPassword": false,
                                    "text": "",
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtEstimatedAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "80",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtEstimatedAmount_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "見積額",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "textAlign": 2,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "text": "",
                                    "suggest": [],
                                    "decorationClass": "",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": true,
                                    "decimalPointLength": 0,
                                    "permitCharactor": "+-,.\\"
                                },
                                {
                                    "fieldName": "btnClearDetail",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "btnClearDetail",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "入力内容をクリアする",
                                    "onClick": "onClick_btnClearDetail",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": false
                                },
                                {
                                    "fieldName": "btnModifyDetail",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 2,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "btnModifyDetail",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "明細を追加する",
                                    "onClick": "onClick_btnModifyDetail",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "540",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "0",
                            "selectControlID": "JutakuKaishuDetailInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "JutakuKaishuDetailInput"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G2",
                    "visible": true,
                    "displayNone": false,
                    "disabled": false,
                    "accessKey": "",
                    "nextFocusFieldName": "",
                    "wrap": false,
                    "dependencies": [],
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "0",
                    "marginRight": "XS",
                    "selectControlID": "JutakuKaishuShinseiDetailInput",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JutakuKaishuShinseiDetailInput"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": true,
                    "backgroundColor": 0,
                    "widthAuto": true,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto"
                }
            ],
            "controlType": "CommonChildDiv",
            "width": "XS",
            "visible": true,
            "displayNone": false,
            "disabled": false,
            "accessKey": "",
            "nextFocusFieldName": "",
            "wrap": false,
            "dependencies": [],
            "float": 0,
            "toolTip": "",
            "authorityMode": 0,
            "marginLeft": "0",
            "marginRight": "0",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "businessId": "DBC",
            "controlName": "JutakuKaishuShinseiDetailInput",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "txtChakkoDueDate",
                    "publicChildProperty": "labelLText",
                    "newPropertyName": "txtChakkoDate_lableLText"
                },
                {
                    "publicChildFieldName": "txtKanseiDueDate",
                    "publicChildProperty": "labelLText",
                    "newPropertyName": "txtKanseiDate_lableLText"
                },
                {
                    "publicChildFieldName": "btnModifyDetail",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "onClick_btnModifyDetail"
                },
                {
                    "publicChildFieldName": "btnModifyDetail",
                    "publicChildProperty": "text",
                    "newPropertyName": "btnModify_text"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return JutakuKaishuShinseiDetailInput_Design;
    })(Uz.CommonChildDiv);
    DBC.JutakuKaishuShinseiDetailInput_Design = JutakuKaishuShinseiDetailInput_Design;
})(DBC || (DBC = {}));
