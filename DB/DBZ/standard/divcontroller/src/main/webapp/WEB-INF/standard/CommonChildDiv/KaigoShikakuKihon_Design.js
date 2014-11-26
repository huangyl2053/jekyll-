var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KaigoShikakuKihon_Design = (function (_super) {
        __extends(KaigoShikakuKihon_Design, _super);
        function KaigoShikakuKihon_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoShikakuKihon_Design.myLayout, fieldName);
        }
        KaigoShikakuKihon_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        KaigoShikakuKihon_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        KaigoShikakuKihon_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoShikakuKihon",
                    "items": [
                        {
                            "fieldName": "txtHihokenshaNo",
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
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtShutokuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "displayFormat": 0
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
                            "marginLeft": "0em",
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
                            "labelLWidth": "0px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtSoshitsuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "displayFormat": 0
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
                            "marginLeft": "0em",
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
                            "labelLWidth": "0px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJutokuKubun",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "35px",
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
                            "selectControlID": "txtJutokuKubun_core",
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
                            "labelLWidth": "0px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtYokaigoJotaiKubun",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "100px",
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
                            "selectControlID": "txtYokaigoJotaiKubun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "6",
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
                            "labelLText": "要介護認定",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtNinteiKaishiYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "txtNinteiKaishiYmd_core",
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
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "90px",
                            "labelRWidth": "0px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtNinteiShuryoYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "txtNinteiShuryoYmd_core",
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
                            "labelLText": "～",
                            "labelRText": "",
                            "labelLWidth": "20px",
                            "labelRWidth": "0px",
                            "labelLAlign": 1,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "btnNinteiRireki",
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
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0em",
                            "marginRight": "0.4em",
                            "selectControlID": "btnNinteiRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "認定履歴",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
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
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0em",
                            "marginRight": "0.4em",
                            "selectControlID": "btnHihoRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "被保履歴",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "btnRenrakusaki",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "70px",
                            "visible": true,
                            "displayNone": true,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0em",
                            "marginRight": "0.4em",
                            "selectControlID": "btnRenrakusaki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "連絡先",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true,
                            "displayChildDivName": "DBZ.KaigoRenrakusakiInfo",
                            "dataPassing": [
                                {
                                    "key": "hihokenshaNo",
                                    "controlName": "txtHihokenshaNo"
                                }
                            ],
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
                    "selectControlID": "KaigoShikakuKihon",
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
                            "postParameterPanelNames": "KaigoShikakuKihon"
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
            "controlName": "KaigoShikakuKihon",
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
            "publicEventsAlias": []
        };
        return KaigoShikakuKihon_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoShikakuKihon_Design = KaigoShikakuKihon_Design;

    (function (KaigoShikakuKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoShikakuKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoShikakuKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoShikakuKihon = function () {
                return new UZA.Panel(this.convFiledName("KaigoShikakuKihon"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
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

            Controls.prototype.txtJutokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtNinteiKaishiYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            };

            Controls.prototype.txtNinteiShuryoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            };

            Controls.prototype.btnNinteiRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };

            Controls.prototype.btnRenrakusaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            };
            return Controls;
        })();
        KaigoShikakuKihon.Controls = Controls;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
