var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiSeikyuDetail) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onSelectByModifyButton", {
                get: function () {
                    return "onSelectByModifyButton";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnModifyDetail", {
                get: function () {
                    return "onClick_btnModifyDetail";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnClear", {
                get: function () {
                    return "onClick_btnClear";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectByDeleteButton", {
                get: function () {
                    return "onSelectByDeleteButton";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectBySelectButton", {
                get: function () {
                    return "onSelectBySelectButton";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "YoguKonyuhiShikyuShinseiSeikyuDetail";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetailInput = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.ddlShumoku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShumoku"));
            };

            Controls.prototype.txtShohinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohinName"));
            };

            Controls.prototype.btnShohinmeiSearch = function () {
                return new UZA.Button(this.convFiledName("btnShohinmeiSearch"));
            };

            Controls.prototype.txtSeizoJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));
            };

            Controls.prototype.txtHanbaiJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));
            };

            Controls.prototype.txtBuyAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));
            };

            Controls.prototype.txtHinmokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));
            };

            Controls.prototype.radShinsaMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radShinsaMethod"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnModifyDetail = function () {
                return new UZA.Button(this.convFiledName("btnModifyDetail"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.Controls = Controls;
    })(DBC.YoguKonyuhiShikyuShinseiSeikyuDetail || (DBC.YoguKonyuhiShikyuShinseiSeikyuDetail = {}));
    var YoguKonyuhiShikyuShinseiSeikyuDetail = DBC.YoguKonyuhiShikyuShinseiSeikyuDetail;

    var YoguKonyuhiShikyuShinseiSeikyuDetail_Design = (function (_super) {
        __extends(YoguKonyuhiShikyuShinseiSeikyuDetail_Design, _super);
        function YoguKonyuhiShikyuShinseiSeikyuDetail_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, YoguKonyuhiShikyuShinseiSeikyuDetail_Design.myLayout, fieldName);
        }
        Object.defineProperty(YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype, "btnModifyDetail_onClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[1].items[10]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype, "btnModifyDetail_text", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[1].items[10]["text"] = value;
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
            Uz.JSControlUtil.registProperty("");
        };

        YoguKonyuhiShikyuShinseiSeikyuDetail_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnModifyDetail_onClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnModifyDetail_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[10]["fieldName"]).getEditablePropertyInfo()["text"];

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
                            "width": "545px",
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "dgSeikyuDetail",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "236px",
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
                            "sortOrder": "txtShinsaMethod",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
                            "items": [
                                {
                                    "fieldName": "txtBuyYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "85px",
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
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "購入日",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "textKind": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "ddlShumoku",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "250px",
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
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "code00",
                                    "isBlankLine": false,
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtShohinName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "340px",
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
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "商品名",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "btnShohinmeiSearch",
                                    "items": [],
                                    "controlType": "Button",
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
                                    "marginLeft": "0px",
                                    "marginRight": "XS",
                                    "selectControlID": "btnShohinmeiSearch",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "",
                                    "onClick": "",
                                    "icon": 0,
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "appearance": 2,
                                    "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "txtSeizoJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300px",
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
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "製造事業者",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtHanbaiJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300px",
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
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "販売事業者",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtBuyAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "80px",
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
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "購入金額",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
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
                                    "width": "300px",
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
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "品目コード",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
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
                                    "labelLWidth": "90px",
                                    "labelLAlign": 2,
                                    "selectedItem": "judgeDone",
                                    "onClick": "",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "M",
                                    "disabledItem": [],
                                    "icon": []
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
                                    "icon": 0,
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
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
                                    "icon": 0,
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "heightTextBoxMatches": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "545px",
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
                            "marginRight": "0em",
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
                            "height": "Auto",
                            "canPost": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1105px",
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
                            "requestUrl": ""
                        }
                    ],
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
                    "height": "Auto",
                    "canPost": true
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
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBC",
            "controlName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
            "marginTop": "0em",
            "marginBottom": "0em",
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
                },
                {
                    "publicChildFieldName": "",
                    "publicChildProperty": "",
                    "newPropertyName": ""
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": ""
        };
        return YoguKonyuhiShikyuShinseiSeikyuDetail_Design;
    })(Uz.CommonChildDiv);
    DBC.YoguKonyuhiShikyuShinseiSeikyuDetail_Design = YoguKonyuhiShikyuShinseiSeikyuDetail_Design;
})(DBC || (DBC = {}));
