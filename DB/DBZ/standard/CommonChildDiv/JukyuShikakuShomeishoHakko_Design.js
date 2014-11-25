var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyuShikakuShomeishoHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "JukyuShikakuShomeishoHakko";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.JukyuShikakuShomeishoHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtIdoYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYoteiDate"));
            };

            Controls.prototype.txtYokaigoJotai = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotai"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.lblNinteiShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblNinteiShinsakaiIken"));
            };

            Controls.prototype.txtNinteiShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinsakaiIken"));
            };

            Controls.prototype.lblBiko = function () {
                return new UZA.Label(this.convFiledName("lblBiko"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            };

            Controls.prototype.chkJushoHihyoji = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJushoHihyoji"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        JukyuShikakuShomeishoHakko.Controls = Controls;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;

    var JukyuShikakuShomeishoHakko_Design = (function (_super) {
        __extends(JukyuShikakuShomeishoHakko_Design, _super);
        function JukyuShikakuShomeishoHakko_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JukyuShikakuShomeishoHakko_Design.myLayout, fieldName);
        }
        JukyuShikakuShomeishoHakko_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JukyuShikakuShomeishoHakko_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JukyuShikakuShomeishoHakko_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JukyuShikakuShomeishoHakko",
                    "items": [
                        {
                            "fieldName": "txtKofuDate",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "交付日",
                            "labelRText": "",
                            "labelLWidth": "85",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtIdoYoteiDate",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "90",
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
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "異動予定日",
                            "labelRText": "",
                            "labelLWidth": "85",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtYokaigoJotai",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "60",
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
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "要介護状態",
                            "labelRText": "",
                            "labelLWidth": "85",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtNinteiYukoKikan",
                            "items": [],
                            "controlType": "TextBoxDateRange",
                            "width": "90",
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
                            "readOnly": true,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "認定有効期間",
                            "labelRText": "",
                            "labelLWidth": "115",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "",
                            "fromPlaceHolder": "",
                            "toPlaceHolder": "",
                            "minDate": "",
                            "maxDate": "",
                            "fromText": "",
                            "toText": "",
                            "fromValue": "",
                            "toValue": ""
                        },
                        {
                            "fieldName": "txtShinseiDate",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "90",
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
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "申請日",
                            "labelRText": "",
                            "labelLWidth": "50",
                            "labelRWidth": "",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "lblNinteiShinsakaiIken",
                            "items": [],
                            "controlType": "Label",
                            "width": "150",
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
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "認定審査会の意見等",
                            "align": 2
                        },
                        {
                            "fieldName": "txtNinteiShinsakaiIken",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "800",
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
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "height": "S",
                            "limitLength": "150",
                            "countDisp": true
                        },
                        {
                            "fieldName": "lblBiko",
                            "items": [],
                            "controlType": "Label",
                            "width": "40",
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
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "備考",
                            "align": 2
                        },
                        {
                            "fieldName": "txtBiko",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "800",
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
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "height": "S",
                            "limitLength": "240",
                            "countDisp": true
                        },
                        {
                            "fieldName": "chkJushoHihyoji",
                            "items": [],
                            "controlType": "CheckBoxList",
                            "width": "100",
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
                            "required": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "jushoHihyoji",
                                    "value": "住所非表示"
                                }
                            ],
                            "onClick": "",
                            "selectedItems": [],
                            "newLineItemNumber": 2,
                            "minCheckedItem": 0,
                            "maxCheckedItem": "1",
                            "spaceSize": 1,
                            "isAllSelectable": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1030",
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
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JukyuShikakuShomeishoHakko"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": true,
                    "eraseBorderBottom": true,
                    "eraseBorderRight": true,
                    "eraseBorderLeft": true,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "isGroupBox": false
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
            "relation": [],
            "businessId": "DBZ",
            "controlName": "JukyuShikakuShomeishoHakko",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return JukyuShikakuShomeishoHakko_Design;
    })(Uz.CommonChildDiv);
    DBZ.JukyuShikakuShomeishoHakko_Design = JukyuShikakuShomeishoHakko_Design;
})(DBZ || (DBZ = {}));
