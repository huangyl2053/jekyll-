var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBB;
(function (DBB) {
    var RentaiNofuGimusha_Design = (function (_super) {
        __extends(RentaiNofuGimusha_Design, _super);
        function RentaiNofuGimusha_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, RentaiNofuGimusha_Design.myLayout, fieldName);
        }
        RentaiNofuGimusha_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        RentaiNofuGimusha_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        RentaiNofuGimusha_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "RentaiNofuGimusha",
                    "items": [
                        {
                            "fieldName": "txtShikibetsuCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "120px",
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
                            "selectControlID": "txtShikibetsuCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
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
                            "labelLText": "氏名",
                            "labelRText": "",
                            "labelLWidth": "60px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "15"
                        },
                        {
                            "fieldName": "txtShimei",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "240px",
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
                            "marginRight": "XS",
                            "selectControlID": "txtShimei_core",
                            "helpMessageID": "",
                            "jpControlName": "",
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
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKaishiYMD",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "selectControlID": "txtKaishiYMD_core",
                            "helpMessageID": "",
                            "jpControlName": "",
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
                            "labelLText": "開始日",
                            "labelRText": "",
                            "labelLWidth": "60px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 1
                        },
                        {
                            "fieldName": "txtSyuryoYMD",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtSyuryoYMD_core",
                            "helpMessageID": "",
                            "jpControlName": "",
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
                            "labelLText": "終了日",
                            "labelRText": "",
                            "labelLWidth": "80px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 1
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G6",
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
                    "selectControlID": "RentaiNofuGimusha",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "連帯納付義務者",
                    "marginTop": "XS",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "RentaiNofuGimusha"
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
            "businessId": "DBB",
            "controlName": "RentaiNofuGimusha",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "nushiShikibetsuCode",
                    "controlName": "txtShikibetsuCode"
                },
                {
                    "key": "nushiName",
                    "controlName": "txtShimei"
                }
            ],
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
        return RentaiNofuGimusha_Design;
    })(Uz.CommonChildDiv);
    DBB.RentaiNofuGimusha_Design = RentaiNofuGimusha_Design;

    (function (RentaiNofuGimusha) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        RentaiNofuGimusha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RentaiNofuGimusha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RentaiNofuGimusha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShikibetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShikibetsuCode"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            };

            Controls.prototype.txtSyuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSyuryoYMD"));
            };
            return Controls;
        })();
        RentaiNofuGimusha.Controls = Controls;
    })(DBB.RentaiNofuGimusha || (DBB.RentaiNofuGimusha = {}));
    var RentaiNofuGimusha = DBB.RentaiNofuGimusha;
})(DBB || (DBB = {}));
