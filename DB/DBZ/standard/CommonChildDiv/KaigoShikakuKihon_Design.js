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
        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "title", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "canOpenAndClose", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "eraseBorderTop", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "eraseBorderBottom", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "eraseBorderRight", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "eraseBorderLeft", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "backGroundColor", {
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


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "btnHihoRireki_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[6]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoShikakuKihon_Design.prototype, "btnNinteiRireki_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[12]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KaigoShikakuKihon_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("canOpenAndClose");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("backGroundColor");
            Uz.JSControlUtil.registProperty("btnHihoRireki_visible");
            Uz.JSControlUtil.registProperty("btnNinteiRireki_visible");
        };

        KaigoShikakuKihon_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["backGroundColor"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["backgroundColor"];
            editablePropertyInfo["btnHihoRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["btnNinteiRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["visible"];

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
                            "width": "85",
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
                            "selectControlID": "txtHihokenshaNo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "10",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "1234567890",
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
                            "labelLWidth": "65",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtShutokuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtShutokuYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平12.04.01",
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
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtShutokuJiyu",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "85",
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
                            "selectControlID": "txtShutokuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "年齢到達",
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
                            "labelLText": "取得事由",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJutokuTekiyo",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtJutokuTekiyo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平21.11.15",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "住特開始",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtYokaigoJotaiKubun",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "100",
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
                            "selectControlID": "txtYokaigoJotaiKubun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "6",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "要介護５",
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
                            "labelLWidth": "95",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtNinteiKaishiYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtNinteiKaishiYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平25.04.01",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "開始",
                            "labelRText": "",
                            "labelLWidth": "50",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "btnHihoRireki",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "80",
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
                            "marginLeft": "0",
                            "marginRight": "-0.1",
                            "selectControlID": "btnHihoRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "被保履歴",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "txtShikakuJotai",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "85",
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
                            "marginRight": "0",
                            "selectControlID": "txtShikakuJotai_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "資格喪失者",
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
                            "labelLText": "資格状態",
                            "labelRText": "",
                            "labelLWidth": "65",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtSoshitsuYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtSoshitsuYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平26.07.02",
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
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtSoshitsuJiyu",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "85",
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
                            "selectControlID": "txtSoshitsuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "5",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "転出",
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
                            "labelLText": "喪失事由",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJutokuKaijo",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtJutokuKaijo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平24.03.15",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "住特終了",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtKyuSochiNyusho",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "20",
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
                            "selectControlID": "txtKyuSochiNyusho_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "1",
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "有",
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
                            "labelLText": "旧措置入所",
                            "labelRText": "",
                            "labelLWidth": "95",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "btnNinteiRireki",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "80",
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
                            "marginLeft": "0",
                            "marginRight": "-0.1",
                            "selectControlID": "btnNinteiRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "認定履歴",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "txtNinteiShuryoYmd",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
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
                            "selectControlID": "txtNinteiShuryoYmd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "平27.03.31",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "終了",
                            "labelRText": "",
                            "labelLWidth": "130",
                            "labelRWidth": "0",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G12",
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
                    "marginRight": "0",
                    "selectControlID": "KaigoShikakuKihon",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0",
                    "marginBottom": "0",
                    "isOpen": true,
                    "canOpenAndClose": false,
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
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
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
            "controlName": "KaigoShikakuKihon",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "canOpenAndClose",
                    "newPropertyName": "canOpenAndClose"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "eraseBorderTop",
                    "newPropertyName": "eraseBorderTop"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "eraseBorderBottom",
                    "newPropertyName": "eraseBorderBottom"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "eraseBorderRight",
                    "newPropertyName": "eraseBorderRight"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "eraseBorderLeft",
                    "newPropertyName": "eraseBorderLeft"
                },
                {
                    "publicChildFieldName": "KaigoShikakuKihon",
                    "publicChildProperty": "backgroundColor",
                    "newPropertyName": "backGroundColor"
                },
                {
                    "publicChildFieldName": "btnHihoRireki",
                    "publicChildProperty": "visible",
                    "newPropertyName": "btnHihoRireki_visible"
                },
                {
                    "publicChildFieldName": "btnNinteiRireki",
                    "publicChildProperty": "visible",
                    "newPropertyName": "btnNinteiRireki_visible"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KaigoShikakuKihon_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoShikakuKihon_Design = KaigoShikakuKihon_Design;
})(DBZ || (DBZ = {}));
