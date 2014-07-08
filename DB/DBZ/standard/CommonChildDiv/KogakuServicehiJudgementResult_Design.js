var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KogakuServicehiJudgementResult_Design = (function (_super) {
        __extends(KogakuServicehiJudgementResult_Design, _super);
        function KogakuServicehiJudgementResult_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KogakuServicehiJudgementResult_Design.myLayout, fieldName);
        }
        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "eraseBorderTop", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"] = value;
                } else {
                    this.layout.items[0]["eraseBorderTop"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "eraseBorderBottom", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"] = value;
                } else {
                    this.layout.items[0]["eraseBorderBottom"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "eraseBorderRight", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"] = value;
                } else {
                    this.layout.items[0]["eraseBorderRight"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "eraseBorderLeft", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"] = value;
                } else {
                    this.layout.items[0]["eraseBorderLeft"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KogakuServicehiJudgementResult_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("panelDisplay");
        };

        KogakuServicehiJudgementResult_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];

            return editablePropertyInfo;
        };
        KogakuServicehiJudgementResult_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KogakuServicehiJudgementResult",
                    "items": [
                        {
                            "fieldName": "dgJudgementResult",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "980",
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
                            "selectControlID": "dgJudgementResult",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 1
                                },
                                "columns": [
                                    {
                                        "columnName": "事業者",
                                        "dataName": "txtJigyosha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 295,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJigyosha"
                                    },
                                    {
                                        "columnName": "サービス種類",
                                        "dataName": "txtServiceShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 190,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtServiceShurui"
                                    },
                                    {
                                        "columnName": "サービス<br>費用合計",
                                        "dataName": "txtServiceHiyoTotal",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 95,
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtServiceHiyoTotal"
                                    },
                                    {
                                        "columnName": "利用者<br>負担額合計",
                                        "dataName": "txtRiyoshaFutanTotalAmount",
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtRiyoshaFutanTotalAmount"
                                    },
                                    {
                                        "columnName": "算定<br>基準額",
                                        "dataName": "txtSanteiKijunAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtSanteiKijunAmount"
                                    },
                                    {
                                        "columnName": "支払済<br>金額",
                                        "dataName": "txtShiharaizumiAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShiharaizumiAmount"
                                    },
                                    {
                                        "columnName": "高額<br>支給額",
                                        "dataName": "txtKogakuShikyuAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKogakuShikyuAmount"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "txtKogakuShikyuAmount",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "KogakuServicehiJudgementResultDetail1",
                            "items": [
                                {
                                    "fieldName": "txtUketsukeDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90",
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
                                    "selectControlID": "txtUketsukeDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "受付日",
                                    "labelRText": "",
                                    "labelLWidth": "96",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtHonninPaymentAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "S",
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
                                    "selectControlID": "txtHonninPaymentAmount_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "本人支払額",
                                    "labelRText": "",
                                    "labelLWidth": "80",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "textKind": 2,
                                    "isComboBox": false,
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
                                    "fieldName": "txtKetteiDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90",
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
                                    "selectControlID": "txtKetteiDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "決定日",
                                    "labelRText": "",
                                    "labelLWidth": "96",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "radShikyuKubun",
                                    "items": [],
                                    "controlType": "RadioButton",
                                    "width": "150",
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
                                    "selectControlID": "radShikyuKubun_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "shikyu",
                                            "value": "支給"
                                        },
                                        {
                                            "key": "Fushikyu",
                                            "value": "不支給"
                                        }
                                    ],
                                    "onChange": "",
                                    "labelLText": "支給区分",
                                    "labelLWidth": "80",
                                    "labelLAlign": 2,
                                    "selectedItem": "shikyu",
                                    "onClick": "",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "S",
                                    "disabledItem": [],
                                    "icon": []
                                },
                                {
                                    "fieldName": "txtsetaiShuyakuNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
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
                                    "selectControlID": "txtsetaiShuyakuNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "世帯集約番号",
                                    "labelRText": "",
                                    "labelLWidth": "96",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtShikyuAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "S",
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
                                    "marginLeft": "M",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShikyuAmount_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "支給金額",
                                    "labelRText": "",
                                    "labelLWidth": "80",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "textKind": 2,
                                    "isComboBox": false,
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
                                    "fieldName": "radIsKogakuAutoShokan",
                                    "items": [],
                                    "controlType": "RadioButton",
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
                                    "selectControlID": "radIsKogakuAutoShokan_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "ari",
                                            "value": "あり"
                                        },
                                        {
                                            "key": "nashi",
                                            "value": "なし"
                                        }
                                    ],
                                    "onChange": "",
                                    "labelLText": "高額自動償還",
                                    "labelLWidth": "96",
                                    "labelLAlign": 2,
                                    "selectedItem": "ari",
                                    "onClick": "",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "M",
                                    "disabledItem": [],
                                    "icon": []
                                }
                            ],
                            "controlType": "Panel",
                            "width": "485",
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
                            "selectControlID": "KogakuServicehiJudgementResultDetail1",
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
                                    "postParameterPanelNames": "KogakuServicehiJudgementResultDetail1"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": true,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "KogakuServicehiJudgementResultDetail2",
                            "items": [
                                {
                                    "fieldName": "txtBiko",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "380",
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
                                    "selectControlID": "txtBiko_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "備考",
                                    "labelRText": "",
                                    "labelLWidth": "80",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "radJudgementMethod",
                                    "items": [],
                                    "controlType": "RadioButton",
                                    "width": "180",
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
                                    "selectControlID": "radJudgementMethod_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "mishinsa",
                                            "value": "審査依頼"
                                        },
                                        {
                                            "key": "shinsaZumi",
                                            "value": "審査済み"
                                        }
                                    ],
                                    "onChange": "",
                                    "labelLText": "審査方法",
                                    "labelLWidth": "80",
                                    "labelLAlign": 2,
                                    "selectedItem": "shinsaZumi",
                                    "onClick": "",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "S",
                                    "disabledItem": [],
                                    "icon": []
                                },
                                {
                                    "fieldName": "txtFushikyuRiyu",
                                    "items": [],
                                    "controlType": "TextBoxMultiLine",
                                    "width": "380",
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
                                    "selectControlID": "txtFushikyuRiyu_text_area",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "XS",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "不支給理由",
                                    "labelRText": "",
                                    "labelLWidth": "80",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": "10000000000",
                                    "minLength": 0,
                                    "textKind": 0,
                                    "limitLength": "100",
                                    "countDisp": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "490",
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
                            "marginLeft": "-1.6",
                            "marginRight": "XS",
                            "selectControlID": "KogakuServicehiJudgementResultDetail2",
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
                                    "postParameterPanelNames": "KogakuServicehiJudgementResultDetail2"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": true,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "993",
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
                    "selectControlID": "KogakuServicehiJudgementResult",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "判定結果",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KogakuServicehiJudgementResult"
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
            "businessId": "DBZ",
            "controlName": "KogakuServicehiJudgementResult",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "eraseBorderTop",
                    "newPropertyName": "eraseBorderTop"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "eraseBorderBottom",
                    "newPropertyName": "eraseBorderBottom"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "eraseBorderRight",
                    "newPropertyName": "eraseBorderRight"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "eraseBorderLeft",
                    "newPropertyName": "eraseBorderLeft"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return KogakuServicehiJudgementResult_Design;
    })(Uz.CommonChildDiv);
    DBZ.KogakuServicehiJudgementResult_Design = KogakuServicehiJudgementResult_Design;
})(DBZ || (DBZ = {}));
