var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KagoMoshitate_Design = (function (_super) {
        __extends(KagoMoshitate_Design, _super);
        function KagoMoshitate_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KagoMoshitate_Design.myLayout, fieldName);
        }
        Object.defineProperty(KagoMoshitate_Design.prototype, "isGroupBox", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["isGroupBox"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["isGroupBox"] = value;
                } else {
                    this.layout.items[0]["isGroupBox"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KagoMoshitate_Design.prototype, "eraseBorderTop", {
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


        Object.defineProperty(KagoMoshitate_Design.prototype, "eraseBorderBottom", {
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


        Object.defineProperty(KagoMoshitate_Design.prototype, "eraseBorderRight", {
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


        Object.defineProperty(KagoMoshitate_Design.prototype, "eraseBorderLeft", {
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


        Object.defineProperty(KagoMoshitate_Design.prototype, "title", {
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


        KagoMoshitate_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("isGroupBox");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("title");
        };

        KagoMoshitate_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["isGroupBox"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["isGroupBox"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];

            return editablePropertyInfo;
        };
        KagoMoshitate_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KagoMoshitate",
                    "items": [
                        {
                            "fieldName": "txtJigyoshaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
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
                            "selectControlID": "txtJigyoshaNo_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "事業者",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "",
                            "formatLength": "10"
                        },
                        {
                            "fieldName": "txtJigyoshaName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "417",
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
                            "marginLeft": "-0.2",
                            "marginRight": "XS",
                            "selectControlID": "txtJigyoshaName_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtSendYM",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "55",
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
                            "selectControlID": "txtSendYM_core",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "送付年月",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 1,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtMoshitateshaKubun",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "120",
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
                            "selectControlID": "txtMoshitateshaKubun_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "申立者区分",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtShokisaiHokenshaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "50",
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
                            "selectControlID": "txtShokisaiHokenshaNo_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "証記載保険者番号",
                            "labelRText": "",
                            "labelLWidth": "130",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "",
                            "formatLength": "6"
                        },
                        {
                            "fieldName": "txtShokisaiHokenshaName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "200",
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
                            "marginLeft": "-0.2",
                            "marginRight": "XS",
                            "selectControlID": "txtShokisaiHokenshaName_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtTeikyoYM",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "55",
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
                            "selectControlID": "txtTeikyoYM_core",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "提供年月",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 1,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtKagoForm",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "505",
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
                            "selectControlID": "txtKagoForm_core",
                            "readOnly": true,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "様式",
                            "labelRText": "",
                            "labelLWidth": "105",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtMoshitateDate",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "selectControlID": "txtMoshitateDate_core",
                            "readOnly": false,
                            "required": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "申立日",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "ddlKagoMoshitateRiyu",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "400",
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
                            "selectControlID": "ddlKagoMoshitateRiyu_core",
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "申立理由",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "code02",
                            "dataSource": [
                                {
                                    "key": "code00",
                                    "value": ""
                                },
                                {
                                    "key": "code01",
                                    "value": "01:台帳誤り修正による保険者申立の過誤調整"
                                },
                                {
                                    "key": "code02",
                                    "value": "02:請求誤りによる実績取下げ"
                                },
                                {
                                    "key": "code09",
                                    "value": "09:時効による保険者申立の取下げ"
                                },
                                {
                                    "key": "code11",
                                    "value": "11:台帳誤り修正による事業所申立の過誤調整"
                                },
                                {
                                    "key": "code12",
                                    "value": "12:請求誤りによる実績取下げ（同月）"
                                },
                                {
                                    "key": "code21",
                                    "value": "21:台帳誤り修正による公費負担者申立の過誤調整"
                                },
                                {
                                    "key": "code29",
                                    "value": "29:時効による公費負担者申立の取下げ"
                                },
                                {
                                    "key": "code32",
                                    "value": "32:給付管理票取消による実績の取下げ"
                                },
                                {
                                    "key": "code42",
                                    "value": "42:適正化による保険者申立の過誤取下げ"
                                },
                                {
                                    "key": "code49",
                                    "value": "49:適正化による保険者申立の過誤取下げ（同月）"
                                },
                                {
                                    "key": "code52",
                                    "value": "52:適正化による公費負担者申立の過誤取下げ"
                                },
                                {
                                    "key": "code59",
                                    "value": "59:適正化による公費負担者申立の過誤取下げ（同月）"
                                },
                                {
                                    "key": "code62",
                                    "value": "62:不正請求による実績取下げ"
                                },
                                {
                                    "key": "code69",
                                    "value": "69:不正請求による実績取下げ（同月）"
                                },
                                {
                                    "key": "code90",
                                    "value": "90:その他の事由による台帳過誤"
                                },
                                {
                                    "key": "code99",
                                    "value": "99:その他の事由による実績の取下げ"
                                }
                            ]
                        },
                        {
                            "fieldName": "chkForDogetsuShinsa",
                            "items": [],
                            "controlType": "CheckBoxList",
                            "width": "100",
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
                            "marginLeft": "S",
                            "marginRight": "XS",
                            "selectControlID": "chkForDogetsuShinsa_core",
                            "required": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "key": "forDogetsuShinsa",
                                    "value": "同月審査用"
                                }
                            ],
                            "onClick": "",
                            "selectedItems": [],
                            "newLineItemNumber": 1,
                            "minCheckedItem": 0,
                            "maxCheckedItem": 2,
                            "spaceSize": "M",
                            "isAllSelectable": false,
                            "icon": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "815",
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
                    "selectControlID": "KagoMoshitate",
                    "onLoad": "",
                    "title": "過誤申立書情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KagoMoshitate"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false
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
            "marginLeft": 0,
            "marginRight": 0,
            "selectControlID": "defaultLayout",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "KagoMoshitate",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "isGroupBox",
                    "newPropertyName": "isGroupBox"
                },
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "eraseBorderTop",
                    "newPropertyName": "eraseBorderTop"
                },
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "eraseBorderBottom",
                    "newPropertyName": "eraseBorderBottom"
                },
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "eraseBorderRight",
                    "newPropertyName": "eraseBorderRight"
                },
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "eraseBorderLeft",
                    "newPropertyName": "eraseBorderLeft"
                },
                {
                    "publicChildFieldName": "KagoMoshitate",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KagoMoshitate_Design;
    })(Uz.CommonChildDiv);
    DBZ.KagoMoshitate_Design = KagoMoshitate_Design;
})(DBZ || (DBZ = {}));
