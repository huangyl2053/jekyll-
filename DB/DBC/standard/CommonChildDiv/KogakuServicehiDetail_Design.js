var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var KogakuServicehiDetail_Design = (function (_super) {
        __extends(KogakuServicehiDetail_Design, _super);
        function KogakuServicehiDetail_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KogakuServicehiDetail_Design.myLayout, fieldName);
        }
        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "title", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "eraseBorderTop", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "eraseBorderBottom", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "eraseBorderRight", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "eraseBorderLeft", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "panelDisplay", {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "tplJudgementResult_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0].items[1].items[2]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "tplKetteiJoho_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[1].items[3]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KogakuServicehiDetail_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("tplJudgementResult_title");
            Uz.JSControlUtil.registProperty("tplKetteiJoho_visible");
        };

        KogakuServicehiDetail_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["tplJudgementResult_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["tplKetteiJoho_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]).getEditablePropertyInfo()["visible"];

            return editablePropertyInfo;
        };
        KogakuServicehiDetail_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KogakuServicehiDetail",
                    "items": [
                        {
                            "fieldName": "txtTeikyoYM",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "60",
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
                            "selectControlID": "txtTeikyoYM_core",
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
                            "labelLText": "提供年月",
                            "labelRText": "",
                            "labelLWidth": "64",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 1,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "tabKogakuServicehiDetail",
                            "items": [
                                {
                                    "fieldName": "tplShinseisha",
                                    "items": [
                                        {
                                            "fieldName": "Shinseisha",
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
                                            "marginLeft": "2.4",
                                            "marginRight": 0,
                                            "selectControlID": "Shinseisha",
                                            "title": "",
                                            "relation": [],
                                            "businessId": "DBZ",
                                            "controlName": "ShinseishaInfo",
                                            "marginTop": 0,
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true,
                                            "panelDisplay": 0,
                                            "btnSearch_displayNone": true,
                                            "txtUkestukeDate_displayNone": true,
                                            "txtJigyoshaNo_displayNone": true,
                                            "txtShinseishaName_labelLText": "氏名",
                                            "txtYubinNo_displayNone": false,
                                            "txtAddress_displayNone": false
                                        },
                                        {
                                            "fieldName": "txtShiharaiTotalAmount",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "S",
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
                                            "marginRight": "XS",
                                            "selectControlID": "txtShiharaiTotalAmount_core",
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
                                            "labelLText": "支払金額合計",
                                            "labelRText": "",
                                            "labelLWidth": "105",
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
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0
                                        },
                                        {
                                            "fieldName": "txtShinseiRiyu",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "600",
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
                                            "marginLeft": "0.3",
                                            "marginRight": "XS",
                                            "selectControlID": "txtShinseiRiyu_text_area",
                                            "readOnly": false,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "申請理由",
                                            "labelRText": "",
                                            "labelLWidth": "100",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textKind": 0,
                                            "height": "XS",
                                            "limitLength": 20,
                                            "countDisp": false
                                        }
                                    ],
                                    "controlType": "TabPanel",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplShinseisha",
                                    "title": "申請者情報",
                                    "onActive": ""
                                },
                                {
                                    "fieldName": "tplKoza",
                                    "items": [
                                        {
                                            "fieldName": "PaymentMethod",
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
                                            "marginLeft": 0,
                                            "marginRight": 0,
                                            "selectControlID": "PaymentMethod",
                                            "title": "",
                                            "relation": [],
                                            "businessId": "DBZ",
                                            "controlName": "PaymentMethod",
                                            "marginTop": 0,
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true,
                                            "panelDisplay": 0,
                                            "KozaPayment_title": "口座払い"
                                        }
                                    ],
                                    "controlType": "TabPanel",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplKoza",
                                    "title": "口座情報",
                                    "onActive": ""
                                },
                                {
                                    "fieldName": "tplJudgementResult",
                                    "items": [
                                        {
                                            "fieldName": "JudgementResult",
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
                                            "marginLeft": 0,
                                            "marginRight": 0,
                                            "selectControlID": "JudgementResult",
                                            "title": "",
                                            "relation": [],
                                            "businessId": "DBZ",
                                            "controlName": "KogakuServicehiJudgementResult",
                                            "marginTop": 0,
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true,
                                            "panelDisplay": 0
                                        }
                                    ],
                                    "controlType": "TabPanel",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplJudgementResult",
                                    "title": "判定結果",
                                    "onActive": ""
                                },
                                {
                                    "fieldName": "tplKetteiJoho",
                                    "items": [],
                                    "controlType": "TabPanel",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": true,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplKetteiJoho",
                                    "title": "高額決定情報",
                                    "onActive": ""
                                }
                            ],
                            "controlType": "TabContainer",
                            "width": "1040",
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
                            "selectControlID": "tabKogakuServicehiDetail",
                            "onChange": "",
                            "selectedItem": null,
                            "tabpanelPosition": [
                                "tplShinseisha",
                                "tplKoza",
                                "tplJudgementResult",
                                "tplKetteiJoho"
                            ],
                            "isDraggable": false,
                            "selectedItemFieldName": "tplKoza",
                            "initialTab": "0"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1065",
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
                    "selectControlID": "KogakuServicehiDetail",
                    "onLoad": "",
                    "title": "高額介護サービス費明細",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KogakuServicehiDetail"
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
            "businessId": "DBC",
            "controlName": "KogakuServicehiDetail",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "eraseBorderTop",
                    "newPropertyName": "eraseBorderTop"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "eraseBorderBottom",
                    "newPropertyName": "eraseBorderBottom"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "eraseBorderRight",
                    "newPropertyName": "eraseBorderRight"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "eraseBorderLeft",
                    "newPropertyName": "eraseBorderLeft"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                },
                {
                    "publicChildFieldName": "tplJudgementResult",
                    "publicChildProperty": "title",
                    "newPropertyName": "tplJudgementResult_title"
                },
                {
                    "publicChildFieldName": "tplKetteiJoho",
                    "publicChildProperty": "visible",
                    "newPropertyName": "tplKetteiJoho_visible"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KogakuServicehiDetail_Design;
    })(Uz.CommonChildDiv);
    DBC.KogakuServicehiDetail_Design = KogakuServicehiDetail_Design;
})(DBC || (DBC = {}));
