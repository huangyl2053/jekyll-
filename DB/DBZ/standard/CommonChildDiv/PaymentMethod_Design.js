var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var PaymentMethod_Design = (function (_super) {
        __extends(PaymentMethod_Design, _super);
        function PaymentMethod_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
        }
        Object.defineProperty(PaymentMethod_Design.prototype, "title", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "panelDisplay", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "KozaPayment_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0].items[2]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "onClick_radPayMethod", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[0]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Juryoinin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[1]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Madoguchi_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[3]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Koza_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[2]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "eraseBorder", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
                } else {
                    this.layout.items[0]["eraseBorder"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        PaymentMethod_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("KozaPayment_title");
            Uz.JSControlUtil.registProperty("onClick_radPayMethod");
            Uz.JSControlUtil.registProperty("Juryoinin_displayNone");
            Uz.JSControlUtil.registProperty("Madoguchi_displayNone");
            Uz.JSControlUtil.registProperty("Koza_displayNone");
            Uz.JSControlUtil.registProperty("eraseBorder");
        };

        PaymentMethod_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["KozaPayment_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["onClick_radPayMethod"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["Juryoinin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Madoguchi_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Koza_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];

            return editablePropertyInfo;
        };
        PaymentMethod_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "PaymentMethod",
                    "items": [
                        {
                            "fieldName": "radPayMethod",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "L",
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
                            "selectControlID": "radPayMethod_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "selectedItem": null,
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "dataSource": [
                                {
                                    "key": "payToJuryoinin",
                                    "value": "受領委任払い"
                                },
                                {
                                    "key": "payToKoza",
                                    "value": "口座払い"
                                },
                                {
                                    "key": "payToMadoguchi",
                                    "value": "窓口払い"
                                }
                            ],
                            "onClick": "",
                            "icon": [],
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": []
                        },
                        {
                            "fieldName": "JuryoininJoho",
                            "items": [
                                {
                                    "fieldName": "txtJuryoininKeiyakuNo",
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
                                    "selectControlID": "txtJuryoininKeiyakuNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "契約番号",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "事業者",
                                    "labelRText": "",
                                    "labelLWidth": "55",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtJigyoshaName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtJigyoshaNameKana",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
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
                                    "marginLeft": "20.1",
                                    "marginRight": "XS",
                                    "selectControlID": "txtJigyoshaNameKana_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "845",
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
                            "selectControlID": "JuryoininJoho",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "受領委任情報",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "JuryoininJoho"
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
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "KozaPayment",
                            "items": [],
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
                            "selectControlID": "KozaPayment",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "title": "口座払い",
                            "relation": [],
                            "businessId": "DBZ",
                            "controlName": "KozaPayment",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "panelDisplay": 2,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "MadoguchiPayment",
                            "items": [
                                {
                                    "fieldName": "txtShiharaiBasho",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "445",
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
                                    "selectControlID": "txtShiharaiBasho_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "支払場所",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDate",
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
                                    "selectControlID": "txtShiharaiKaishiDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "開始日",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30",
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
                                    "marginLeft": "-0.5",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiKaishiDay_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13",
                                    "labelRWidth": "13",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
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
                                    "selectControlID": "txtShiharaiKaishiTime_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "開始時間",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "displayFormat": 1,
                                    "permitCharactor": "",
                                    "timeKubun": 1
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDate",
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
                                    "selectControlID": "txtShiharaiShuryoDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "終了日",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30",
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
                                    "marginLeft": "-0.5",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiShuryoDay_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13",
                                    "labelRWidth": "13",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
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
                                    "selectControlID": "txtShiharaiShuryoTime_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
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
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "終了時間",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "displayFormat": 1,
                                    "permitCharactor": "",
                                    "timeKubun": 1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "G2",
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
                            "selectControlID": "MadoguchiPayment",
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
                                    "postParameterPanelNames": "MadoguchiPayment"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": true,
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1090",
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
                    "selectControlID": "PaymentMethod",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "支払方法",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseiPaymentMethod"
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
                    "panelDisplay": 1,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false
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
            "controlName": "PaymentMethod",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "title",
                    "newPropertyName": "KozaPayment_title"
                },
                {
                    "publicChildFieldName": "radPayMethod",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "onClick_radPayMethod"
                },
                {
                    "publicChildFieldName": "JuryoininJoho",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Juryoinin_displayNone"
                },
                {
                    "publicChildFieldName": "MadoguchiPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Madoguchi_displayNone"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Koza_displayNone"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return PaymentMethod_Design;
    })(Uz.CommonChildDiv);
    DBZ.PaymentMethod_Design = PaymentMethod_Design;
})(DBZ || (DBZ = {}));
