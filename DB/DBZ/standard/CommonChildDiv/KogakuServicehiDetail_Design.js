var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
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


        Object.defineProperty(KogakuServicehiDetail_Design.prototype, "eraseBorder", {
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
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("tplJudgementResult_title");
            Uz.JSControlUtil.registProperty("tplKetteiJoho_visible");
        };

        KogakuServicehiDetail_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
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
                            "width": "60px",
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
                            "value": "",
                            "labelLText": "提供年月",
                            "labelRText": "",
                            "labelLWidth": "64px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 1,
                            "displayFormat": 0,
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
                                            "marginLeft": "2.4em",
                                            "marginRight": "0em",
                                            "selectControlID": "Shinseisha",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "title": "",
                                            "relation": [],
                                            "packageName": "",
                                            "businessId": "DBZ",
                                            "controlName": "ShinseishaInfo",
                                            "marginTop": "0em",
                                            "marginBottom": "0em",
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "firstFocusFieldName": "",
                                            "lastFocusFieldName": "",
                                            "modes": [],
                                            "publicEvents": [],
                                            "publicEventsAlias": [],
                                            "panelDisplay": 0,
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true,
                                            "btnJigyoshaInputGuide_displayNone": false,
                                            "txtUkestukeDate_displayNone": true,
                                            "txtJigyoshaNo_disabled": false,
                                            "txtShinseishaName_labelLText": "氏名",
                                            "txtYubinNo_displayNone": false,
                                            "txtAddress_displayNone": false,
                                            "btnJigyoshaInputGuide_disabled": false,
                                            "shinseishaInfo_eraseBorder": true
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
                                            "marginLeft": "0em",
                                            "marginRight": "XS",
                                            "selectControlID": "txtShiharaiTotalAmount_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "required": false,
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
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
                                            "labelLText": "支払金額合計",
                                            "labelRText": "",
                                            "labelLWidth": "105px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        },
                                        {
                                            "fieldName": "txtShinseiRiyu",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "565px",
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
                                            "marginLeft": "0.3em",
                                            "marginRight": "XS",
                                            "selectControlID": "txtShinseiRiyu_text_area",
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
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "申請理由",
                                            "labelRText": "",
                                            "labelLWidth": "100px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "申請者情報",
                                    "onActive": "",
                                    "onFirstActive": "",
                                    "lazyLoadingControls": {}
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
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0em",
                                            "marginRight": "0em",
                                            "selectControlID": "PaymentMethod",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "title": "",
                                            "relation": [],
                                            "packageName": "",
                                            "businessId": "DBZ",
                                            "controlName": "PaymentMethod",
                                            "marginTop": "0em",
                                            "marginBottom": "0em",
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "firstFocusFieldName": "",
                                            "lastFocusFieldName": "",
                                            "modes": [],
                                            "publicEvents": [],
                                            "publicEventsAlias": [],
                                            "eraseBorder": true,
                                            "panelDisplay": 0,
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true,
                                            "KozaPayment_title": "",
                                            "onClick_radPayMethod": "",
                                            "Juryoinin_displayNone": false,
                                            "Madoguchi_displayNone": false,
                                            "Koza_displayNone": false
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "口座情報",
                                    "onActive": "",
                                    "onFirstActive": "",
                                    "lazyLoadingControls": {}
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
                                            "marginLeft": "0em",
                                            "marginRight": "0em",
                                            "selectControlID": "JudgementResult",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "title": "",
                                            "relation": [],
                                            "packageName": "",
                                            "businessId": "DBZ",
                                            "controlName": "KogakuServicehiJudgementResult",
                                            "marginTop": "0em",
                                            "marginBottom": "0em",
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "firstFocusFieldName": "",
                                            "lastFocusFieldName": "",
                                            "modes": [],
                                            "publicEvents": [],
                                            "publicEventsAlias": [],
                                            "panelDisplay": 0,
                                            "eraseBorderTop": true,
                                            "eraseBorderBottom": true,
                                            "eraseBorderRight": true,
                                            "eraseBorderLeft": true
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "判定結果",
                                    "onActive": "",
                                    "onFirstActive": "",
                                    "lazyLoadingControls": {}
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
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "高額決定情報",
                                    "onActive": "",
                                    "onFirstActive": "",
                                    "lazyLoadingControls": {}
                                }
                            ],
                            "controlType": "TabContainer",
                            "width": "1040px",
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
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onChange": "",
                            "selectedItem": null,
                            "tabpanelPosition": [
                                "tplShinseisha",
                                "tplKoza",
                                "tplJudgementResult",
                                "tplKetteiJoho"
                            ],
                            "isDraggable": false,
                            "selectedItemFieldName": "",
                            "initialTab": "0",
                            "isLazyLoading": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G12",
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
                    "marginRight": "XS",
                    "selectControlID": "KogakuServicehiDetail",
                    "helpMessageID": "",
                    "jpControlName": "",
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
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "canPost": true,
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
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "KogakuServicehiDetail",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KogakuServicehiDetail",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
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
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return KogakuServicehiDetail_Design;
    })(Uz.CommonChildDiv);
    DBZ.KogakuServicehiDetail_Design = KogakuServicehiDetail_Design;

    (function (KogakuServicehiDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.tabKogakuServicehiDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            };

            Controls.prototype.tplShinseisha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            };

            Controls.prototype.txtShiharaiTotalAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.tplKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            };

            Controls.prototype.tplJudgementResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            };

            Controls.prototype.tplKetteiJoho = function () {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            };
            return Controls;
        })();
        KogakuServicehiDetail.Controls = Controls;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
