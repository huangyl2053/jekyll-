var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnClose", {
                get: function () {
                    return "onClick_btnClose";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        SogoShokaiKyufuSeigenInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "SogoShokaiKyufuSeigenInfo";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.SogoShokaiKyufuSeigenInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSeigenTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenTorokuJokyo"));
            };

            Controls.prototype.txtSeigenShuryoJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenShuryoJokyo"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenHenko = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenHenko"));
            };

            Controls.prototype.txtSeigenHenkoYokokuTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoYokokuTorokuYMD"));
            };

            Controls.prototype.txtSeigenHenkoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoKetteiYMD"));
            };

            Controls.prototype.txtSeigenHenkoSashitomeSyuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoSashitomeSyuryoYMD"));
            };

            Controls.prototype.txtSeigenHenkoTekiyoShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoTekiyoShuryoYMD"));
            };

            Controls.prototype.txtSeigenTainoKojoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenTainoKojoKetteiYMD"));
            };

            Controls.prototype.txtSeigenChoshuShometsuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenChoshuShometsuKikan"));
            };

            Controls.prototype.txtSeigenNofuzumiKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenNofuzumiKikan"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenGengaku = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenGengaku"));
            };

            Controls.prototype.txtSeigenGengakuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuKikan"));
            };

            Controls.prototype.txtSeigenGengakuKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenGengakuKetteiYMD"));
            };

            Controls.prototype.txtSeigenGengakuTekiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuTekiyoKikan"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        SogoShokaiKyufuSeigenInfo.Controls = Controls;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;

    var SogoShokaiKyufuSeigenInfo_Design = (function (_super) {
        __extends(SogoShokaiKyufuSeigenInfo_Design, _super);
        function SogoShokaiKyufuSeigenInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SogoShokaiKyufuSeigenInfo_Design.myLayout, fieldName);
        }
        SogoShokaiKyufuSeigenInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        SogoShokaiKyufuSeigenInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        SogoShokaiKyufuSeigenInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SogoShokaiKyufuSeigenInfo",
                    "items": [
                        {
                            "fieldName": "txtSeigenTorokuJokyo",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtSeigenTorokuJokyo_core",
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
                            "labelLText": "登録状況",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtSeigenShuryoJokyo",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtSeigenShuryoJokyo_core",
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
                            "labelLText": "終了状況",
                            "labelRText": "",
                            "labelLWidth": "65",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "SogoShokaiKyufuSeigenHenko",
                            "items": [
                                {
                                    "fieldName": "txtSeigenHenkoYokokuTorokuYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtSeigenHenkoYokokuTorokuYMD_core",
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
                                    "labelLText": "予告登録日",
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
                                    "fieldName": "txtSeigenHenkoKetteiYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtSeigenHenkoKetteiYMD_core",
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
                                    "labelLText": "決定日",
                                    "labelRText": "",
                                    "labelLWidth": "50",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtSeigenHenkoSashitomeSyuryoYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtSeigenHenkoSashitomeSyuryoYMD_core",
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
                                    "labelLText": "一時差止終了日",
                                    "labelRText": "",
                                    "labelLWidth": "115",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtSeigenHenkoTekiyoShuryoYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtSeigenHenkoTekiyoShuryoYMD_core",
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
                                    "labelLText": "適用終了日",
                                    "labelRText": "",
                                    "labelLWidth": "80",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
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
                            "selectControlID": "SogoShokaiKyufuSeigenHenko",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "支払方法変更",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SogoShokaiKyufuSeigenHenko"
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
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "txtSeigenTainoKojoKetteiYMD",
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
                            "selectControlID": "txtSeigenTainoKojoKetteiYMD_core",
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
                            "labelLText": "滞納保険料控除決定日",
                            "labelRText": "",
                            "labelLWidth": "165",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSeigenChoshuShometsuKikan",
                            "items": [],
                            "controlType": "TextBoxDateRange",
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
                            "selectControlID": "txtSeigenChoshuShometsuKikan_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "保険料徴収権消滅期間",
                            "labelRText": "",
                            "labelLWidth": "165",
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
                            "toValue": "",
                            "fromSelectControlID": "txtSeigenChoshuShometsuKikanFrom",
                            "toSelectControlID": "txtSeigenChoshuShometsuKikanTo"
                        },
                        {
                            "fieldName": "txtSeigenNofuzumiKikan",
                            "items": [],
                            "controlType": "TextBoxDateRange",
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
                            "selectControlID": "txtSeigenNofuzumiKikan_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "保険料納付済期間",
                            "labelRText": "",
                            "labelLWidth": "130",
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
                            "toValue": "",
                            "fromSelectControlID": "txtSeigenNofuzumiKikanFrom",
                            "toSelectControlID": "txtSeigenNofuzumiKikanTo"
                        },
                        {
                            "fieldName": "SogoShokaiKyufuSeigenGengaku",
                            "items": [
                                {
                                    "fieldName": "txtSeigenGengakuKikan",
                                    "items": [],
                                    "controlType": "TextBoxDateRange",
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
                                    "selectControlID": "txtSeigenGengakuKikan_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "減額期間",
                                    "labelRText": "",
                                    "labelLWidth": "70",
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
                                    "toValue": "",
                                    "fromSelectControlID": "txtSeigenGengakuKikanFrom",
                                    "toSelectControlID": "txtSeigenGengakuKikanTo"
                                },
                                {
                                    "fieldName": "txtSeigenGengakuKetteiYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtSeigenGengakuKetteiYMD_core",
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
                                    "labelLText": "決定日",
                                    "labelRText": "",
                                    "labelLWidth": "50",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtSeigenGengakuTekiyoKikan",
                                    "items": [],
                                    "controlType": "TextBoxDateRange",
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
                                    "selectControlID": "txtSeigenGengakuTekiyoKikan_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "適用期間",
                                    "labelRText": "",
                                    "labelLWidth": "65",
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
                                    "toValue": "",
                                    "fromSelectControlID": "txtSeigenGengakuTekiyoKikanFrom",
                                    "toSelectControlID": "txtSeigenGengakuTekiyoKikanTo"
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
                            "selectControlID": "SogoShokaiKyufuSeigenGengaku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "給付減額",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SogoShokaiKyufuSeigenGengaku"
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
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnClose",
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
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "閉じる",
                            "onClick": "onClick_btnClose",
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
                    "selectControlID": "SogoShokaiKyufuSeigenInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "給付制限情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SogoShokaiKyufuSeigenInfo"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbu/db/dbu/SogoShokaiInfo/onLoad_KyufuSeigenInfo"
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
            "businessId": "DBZ",
            "controlName": "SogoShokaiKyufuSeigenInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return SogoShokaiKyufuSeigenInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.SogoShokaiKyufuSeigenInfo_Design = SogoShokaiKyufuSeigenInfo_Design;
})(DBZ || (DBZ = {}));
