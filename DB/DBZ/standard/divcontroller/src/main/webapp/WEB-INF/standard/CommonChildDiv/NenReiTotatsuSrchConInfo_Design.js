var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var NenReiTotatsuSrchConInfo_Design = (function (_super) {
        __extends(NenReiTotatsuSrchConInfo_Design, _super);
        function NenReiTotatsuSrchConInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, NenReiTotatsuSrchConInfo_Design.myLayout, fieldName);
        }
        NenReiTotatsuSrchConInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        NenReiTotatsuSrchConInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        NenReiTotatsuSrchConInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "NenReiTotatsuSrchConInfo",
                    "items": [
                        {
                            "fieldName": "txtZenkaiFrom",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "txtZenkaiFrom_core",
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
                            "labelLText": "前回処理期間",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtZenkaiTo",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "marginLeft": "0px",
                            "marginRight": "XS",
                            "selectControlID": "txtZenkaiTo_core",
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
                            "labelLText": "～",
                            "labelRText": "",
                            "labelLWidth": "20px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "btnKensaku",
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
                            "marginRight": "0px",
                            "selectControlID": "btnKensaku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "検索する",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnKensaku",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "txtNenreiTotatsuKikanFrom",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "txtNenreiTotatsuKikanFrom_core",
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
                            "labelLText": "年齢到達期間",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtNenreiTotatsuKikanTo",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "marginLeft": "0px",
                            "marginRight": "XS",
                            "selectControlID": "txtNenreiTotatsuKikanTo_core",
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
                            "labelLText": "～",
                            "labelRText": "",
                            "labelLWidth": "20px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": ""
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
                    "marginLeft": "0px",
                    "marginRight": "0px",
                    "selectControlID": "NenReiTotatsuSrchConInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "年齢到達条件",
                    "marginTop": "0px",
                    "marginBottom": "0px",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "NenReiTotatsuSrchConInfo"
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "NenReiTotatsuSrchConInfo",
            "marginTop": "0px",
            "marginBottom": "0px",
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [
                {
                    "eventName": "onClick_btnKensaku"
                }
            ],
            "publicEventsAlias": []
        };
        return NenReiTotatsuSrchConInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.NenReiTotatsuSrchConInfo_Design = NenReiTotatsuSrchConInfo_Design;

    (function (NenReiTotatsuSrchConInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };
            return Events;
        })();
        NenReiTotatsuSrchConInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NenReiTotatsuSrchConInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NenReiTotatsuSrchConInfo = function () {
                return new UZA.Panel(this.convFiledName("NenReiTotatsuSrchConInfo"));
            };

            Controls.prototype.txtZenkaiFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiFrom"));
            };

            Controls.prototype.txtZenkaiTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiTo"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtNenreiTotatsuKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanFrom"));
            };

            Controls.prototype.txtNenreiTotatsuKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanTo"));
            };
            return Controls;
        })();
        NenReiTotatsuSrchConInfo.Controls = Controls;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
