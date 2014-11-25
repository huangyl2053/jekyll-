var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KaigoFukaKihon_Design = (function (_super) {
        __extends(KaigoFukaKihon_Design, _super);
        function KaigoFukaKihon_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoFukaKihon_Design.myLayout, fieldName);
        }
        Object.defineProperty(KaigoFukaKihon_Design.prototype, "title", {
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


        Object.defineProperty(KaigoFukaKihon_Design.prototype, "canOpenAndClose", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"] = value;
                } else {
                    this.layout.items[0]["canOpenAndClose"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoFukaKihon_Design.prototype, "eraseBorder", {
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


        Object.defineProperty(KaigoFukaKihon_Design.prototype, "backGroundColor", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["backgroundColor"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["backgroundColor"] = value;
                } else {
                    this.layout.items[0]["backgroundColor"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoFukaKihon_Design.prototype, "btnHihoRireki_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[7]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KaigoFukaKihon_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("canOpenAndClose");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("backGroundColor");
            Uz.JSControlUtil.registProperty("btnHihoRireki_visible");
        };

        KaigoFukaKihon_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["backGroundColor"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["backgroundColor"];
            editablePropertyInfo["btnHihoRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["visible"];

            return editablePropertyInfo;
        };
        KaigoFukaKihon_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoFukaKihon",
                    "items": [
                        {
                            "fieldName": "txtTsuchishoNo",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "130px",
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
                            "selectControlID": "txtTsuchishoNo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "16",
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
                            "labelLText": "通知書番号",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtHihokenshaNo",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "80px",
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
                            "selectControlID": "txtHihokenshaNo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "10",
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
                            "labelLText": "被保番号",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtHokenryoDankai",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "50px",
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
                            "selectControlID": "txtHokenryoDankai_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
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
                            "labelLText": "保険料段階",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtShutokuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "80px",
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
                            "selectControlID": "txtShutokuYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "資格取得",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtShutokuJiyu",
                            "items": [],
                            "controlType": "TextBox",
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
                            "marginLeft": "0.1em",
                            "marginRight": "0em",
                            "selectControlID": "txtShutokuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
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
                            "labelLWidth": "74px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtSoshitsuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "80px",
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
                            "selectControlID": "txtSoshitsuYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "資格喪失",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSoshitsuJiyu",
                            "items": [],
                            "controlType": "TextBox",
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
                            "marginLeft": "0.1em",
                            "marginRight": "0em",
                            "selectControlID": "txtSoshitsuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
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
                            "labelLWidth": "74px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "btnHihoRireki",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "70px",
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
                            "marginLeft": "0.7em",
                            "marginRight": "0em",
                            "selectControlID": "btnHihoRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "被保履歴",
                            "imageWidth": "",
                            "imageHeight": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "icon": 0,
                            "heightTextBoxMatches": true,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1105px",
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
                    "selectControlID": "KaigoFukaKihon",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0em",
                    "marginBottom": "0em",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KaigoFukaKihon"
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
            "businessId": "DBZ",
            "controlName": "KaigoFukaKihon",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "KaigoFukaKihon",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KaigoFukaKihon",
                    "publicChildProperty": "canOpenAndClose",
                    "newPropertyName": "canOpenAndClose"
                },
                {
                    "publicChildFieldName": "KaigoFukaKihon",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                },
                {
                    "publicChildFieldName": "KaigoFukaKihon",
                    "publicChildProperty": "backgroundColor",
                    "newPropertyName": "backGroundColor"
                },
                {
                    "publicChildFieldName": "btnHihoRireki",
                    "publicChildProperty": "visible",
                    "newPropertyName": "btnHihoRireki_visible"
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
        return KaigoFukaKihon_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoFukaKihon_Design = KaigoFukaKihon_Design;

    (function (KaigoFukaKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoFukaKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoFukaKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoFukaKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHokenryoDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };
            return Controls;
        })();
        KaigoFukaKihon.Controls = Controls;
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));
