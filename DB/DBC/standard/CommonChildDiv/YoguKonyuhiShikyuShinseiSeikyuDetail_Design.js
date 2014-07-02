var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var YoguKonyuhiShikyuShinseiSeikyuDetail_Design = (function (_super) {
        __extends(YoguKonyuhiShikyuShinseiSeikyuDetail_Design, _super);
        function YoguKonyuhiShikyuShinseiSeikyuDetail_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, YoguKonyuhiShikyuShinseiSeikyuDetail_Design.myLayout, fieldName);
        }
        Object.defineProperty(YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype, "btnModifyDetail_onClick", {
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


        Object.defineProperty(YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype, "btnModifyDetail_text", {
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


        YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnModifyDetail_onClick");
            Uz.JSControlUtil.registProperty("btnModifyDetail_text");
        };

        YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnModifyDetail_onClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnModifyDetail_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["text"];

            return editablePropertyInfo;
        };
        YoguKonyuhiShikyuShinseiSeikyuDetail_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
                    "items": [
                        {
                            "fieldName": "dgSeikyuDetail",
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
                            "selectControlID": "dgSeikyuDetail",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "236",
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
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "購入日",
                                        "dataName": "txtBuyYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": ""
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtBuyYMD"
                                    },
                                    {
                                        "columnName": "種目",
                                        "dataName": "txtShumoku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 1,
                                        "cellDetails": {
                                            "cellType": 1,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "textAlign": 0,
                                            "onChange": ""
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShumoku"
                                    },
                                    {
                                        "columnName": "商品名",
                                        "dataName": "txtShohinName",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 160,
                                        "visible": true,
                                        "cellType": 1,
                                        "cellDetails": {
                                            "cellType": 1,
                                            "maxLength": "15",
                                            "minLength": "0",
                                            "textAlign": 0,
                                            "onChange": ""
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShohinName"
                                    },
                                    {
                                        "columnName": "購入金額",
                                        "dataName": "txtBuyAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
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
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtBuyAmount"
                                    },
                                    {
                                        "columnName": "審査方法",
                                        "dataName": "txtShinsaMethod",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 1,
                                        "cellDetails": {
                                            "cellType": 1,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "textAlign": 0,
                                            "onChange": ""
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShinsaMethod"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "onSelectBySelectButton",
                            "onSelectByModifyButton": "onSelectByModifyButton",
                            "onSelectByDeleteButton": "onSelectByDeleteButton",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
                            "items": [
                                {
                                    "fieldName": "txtBuyYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "85",
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
                                    "selectControlID": "txtBuyYMD_core",
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
                                    "labelLText": "購入日",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fieldName": "ddlShumoku",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "250",
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
                                    "selectControlID": "ddlShumoku_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "code01",
                                            "value": "01:腰掛便座"
                                        },
                                        {
                                            "key": "code02",
                                            "value": "02:特殊尿器"
                                        },
                                        {
                                            "key": "code03",
                                            "value": "03:入浴補助用具"
                                        },
                                        {
                                            "key": "code04",
                                            "value": "04:簡易浴槽"
                                        },
                                        {
                                            "key": "code05",
                                            "value": "05:移動用リフトのつり具の部分"
                                        },
                                        {
                                            "key": "code06",
                                            "value": "06:自動排泄処理装置の交換可能部品"
                                        },
                                        {
                                            "key": "code00",
                                            "value": ""
                                        }
                                    ],
                                    "required": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "種目",
                                    "labelRText": "",
                                    "labelLWidth": "90",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "code00",
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtShohinName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "340",
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
                                    "selectControlID": "txtShohinName_core",
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
                                    "labelLText": "商品名",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fieldName": "txtSeizoJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
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
                                    "selectControlID": "txtSeizoJigyosha_core",
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
                                    "labelLText": "製造事業者",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fieldName": "txtHanbaiJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
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
                                    "selectControlID": "txtHanbaiJigyosha_core",
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
                                    "labelLText": "販売事業者",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fieldName": "txtBuyAmount",
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
                                    "selectControlID": "txtBuyAmount_core",
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
                                    "labelLText": "購入金額",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fieldName": "txtHinmokuCode",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "300",
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
                                    "selectControlID": "txtHinmokuCode_core",
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
                                    "labelLText": "品目コード",
                                    "labelRText": "",
                                    "labelLWidth": "90",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "textAlign": 0,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "text": "",
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "radShinsaMethod",
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
                                    "selectControlID": "radShinsaMethod_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "judgeRequest",
                                            "value": "審査依頼"
                                        },
                                        {
                                            "key": "judgeDone",
                                            "value": "審査済み"
                                        }
                                    ],
                                    "required": false,
                                    "onChange": "",
                                    "labelLText": "審査方法",
                                    "labelLWidth": "90",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "icon": [],
                                    "selectedItem": "judgeDone",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "M",
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "btnClear",
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
                                    "selectControlID": "btnClear",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "入力内容をクリアする",
                                    "onClick": "onClick_btnClear",
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
                            "selectControlID": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
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
                                    "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetailInput"
                                }
                            ],
                            "requestSettings": [
                                {
                                    "eventName": "onLoad",
                                    "requestUrl": ""
                                }
                            ],
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
                    "width": "1095",
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
                    "selectControlID": "YoguKonyuhiShikyuShinseiSeikyuDetail",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetail"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnAddSeikyuDetail",
                            "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiSeikyuDetail/onClick_btnAddSeikyuDetail"
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": true,
                    "backgroundColor": 0,
                    "widthAuto": true,
                    "panelDisplay": 1,
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
            "controlName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnModifyDetail",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "btnModifyDetail_onClick"
                },
                {
                    "publicChildFieldName": "btnModifyDetail",
                    "publicChildProperty": "text",
                    "newPropertyName": "btnModifyDetail_text"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return YoguKonyuhiShikyuShinseiSeikyuDetail_Design;
    })(Uz.CommonChildDiv);
    DBC.YoguKonyuhiShikyuShinseiSeikyuDetail_Design = YoguKonyuhiShikyuShinseiSeikyuDetail_Design;
})(DBC || (DBC = {}));
