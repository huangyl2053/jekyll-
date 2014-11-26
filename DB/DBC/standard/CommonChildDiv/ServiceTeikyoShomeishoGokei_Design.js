var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoGokei) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnServiceTeikyoShomeishoGokeiReturn", {
                get: function () {
                    return "onClick_btnServiceTeikyoShomeishoGokeiReturn";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        ServiceTeikyoShomeishoGokei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "ServiceTeikyoShomeishoGokei";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.ServiceTeikyoShomeishoGokei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            };

            Controls.prototype.txtHokengaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokengaku"));
            };

            Controls.prototype.txtFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            };

            Controls.prototype.txtRyoyohi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRyoyohi"));
            };

            Controls.prototype.txtShinryohi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShinryohi"));
            };

            Controls.prototype.txtShokujihi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokujihi"));
            };

            Controls.prototype.btnServiceTeikyoShomeishoGokeiReturn = function () {
                return new UZA.Button(this.convFiledName("btnServiceTeikyoShomeishoGokeiReturn"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoGokei.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoGokei || (DBC.ServiceTeikyoShomeishoGokei = {}));
    var ServiceTeikyoShomeishoGokei = DBC.ServiceTeikyoShomeishoGokei;

    var ServiceTeikyoShomeishoGokei_Design = (function (_super) {
        __extends(ServiceTeikyoShomeishoGokei_Design, _super);
        function ServiceTeikyoShomeishoGokei_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ServiceTeikyoShomeishoGokei_Design.myLayout, fieldName);
        }
        ServiceTeikyoShomeishoGokei_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ServiceTeikyoShomeishoGokei_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ServiceTeikyoShomeishoGokei_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ServiceTeikyoShomeishoGokei",
                    "items": [
                        {
                            "fieldName": "txtServiceTani",
                            "items": [],
                            "controlType": "TextBoxNum",
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
                            "selectControlID": "txtServiceTani_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "サービス単位",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "txtHokengaku",
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
                            "selectControlID": "txtHokengaku_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "保険請求額",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "txtFutangaku",
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
                            "selectControlID": "txtFutangaku_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "利用者負担額",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "txtRyoyohi",
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
                            "selectControlID": "txtRyoyohi_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "緊急時施設療養費保険請求分合計額",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "txtShinryohi",
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
                            "selectControlID": "txtShinryohi_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "特定診療費保険請求分合計額",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "txtShokujihi",
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
                            "selectControlID": "txtShokujihi_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
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
                            "labelLText": "食事提供費請求分",
                            "labelRText": "",
                            "labelLWidth": "260",
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
                            "fieldName": "btnServiceTeikyoShomeishoGokeiReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnServiceTeikyoShomeishoGokeiReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "合計を閉じる",
                            "onClick": "onClick_btnServiceTeikyoShomeishoGokeiReturn",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
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
                    "marginRight": "0",
                    "selectControlID": "ServiceTeikyoShomeishoGokei",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "合計",
                    "marginTop": "0",
                    "marginBottom": "0",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ServiceTeikyoShomeishoGokei"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbc/db/dbc/ServiceTeikyoShomeishoGokei/onLoad"
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
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
            "controlName": "ServiceTeikyoShomeishoGokei",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnServiceTeikyoShomeishoGokeiReturn",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return ServiceTeikyoShomeishoGokei_Design;
    })(Uz.CommonChildDiv);
    DBC.ServiceTeikyoShomeishoGokei_Design = ServiceTeikyoShomeishoGokei_Design;
})(DBC || (DBC = {}));
