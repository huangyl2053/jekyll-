var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var KaigoNinteiKekka_Design = (function (_super) {
        __extends(KaigoNinteiKekka_Design, _super);
        function KaigoNinteiKekka_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoNinteiKekka_Design.myLayout, fieldName);
        }
        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNijiHantei", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[15]["onChange"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNinteiYukoTsukisu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[22]["onChange"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNinteiKubun", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[7]["onChange"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KaigoNinteiKekka_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("selectDdlNijiHantei");
            Uz.JSControlUtil.registProperty("selectDdlNinteiYukoTsukisu");
            Uz.JSControlUtil.registProperty("selectDdlNinteiKubun");
        };

        KaigoNinteiKekka_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["selectDdlNijiHantei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiYukoTsukisu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiKubun"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["onChange"];

            return editablePropertyInfo;
        };
        KaigoNinteiKekka_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoNinteiKekka",
                    "items": [
                        {
                            "fieldName": "lblShinseibi",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 2,
                            "text": "申請日",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtShinseibi",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "valueString": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "lblShinseiKubunShinsei",
                            "items": [],
                            "controlType": "Label",
                            "width": "120",
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
                            "align": 2,
                            "text": "申請区分（申請）",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtShinseiKubunShinsei",
                            "items": [],
                            "controlType": "TextBox",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "区分変更",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "lblShinseiKubunHorei",
                            "items": [],
                            "controlType": "Label",
                            "width": "130",
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
                            "align": 2,
                            "text": "申請区分（法令）",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtShinseiKubunHorei",
                            "items": [],
                            "controlType": "TextBox",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "lblNinteiKubun",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 2,
                            "text": "認定区分",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "ddlNinteiKubun",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "75",
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
                            "text": "",
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "01",
                                    "value": "認定"
                                },
                                {
                                    "key": "02",
                                    "value": "再調査"
                                },
                                {
                                    "key": "03",
                                    "value": "再審査"
                                },
                                {
                                    "key": "09",
                                    "value": "却下"
                                }
                            ]
                        },
                        {
                            "fieldName": "lblIchijiHanteiKekka",
                            "items": [],
                            "controlType": "Label",
                            "width": "128",
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
                            "align": 2,
                            "text": "一次判定結果",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtIchijiHanteiKekka",
                            "items": [],
                            "controlType": "TextBox",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "要介護５",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "lblTokuteiShippei",
                            "items": [],
                            "controlType": "Label",
                            "width": "130",
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
                            "align": 2,
                            "text": "特定疾病",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "ddlTokuteiShippei",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "M",
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
                            "text": "",
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "",
                                    "value": ""
                                },
                                {
                                    "key": "01",
                                    "value": "筋萎縮性側索硬化症"
                                },
                                {
                                    "key": "02",
                                    "value": "後縦靭帯骨化症"
                                }
                            ]
                        },
                        {
                            "fieldName": "lblNinteibi",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 2,
                            "text": "認定日",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtNinteibi",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "lblNijihanteiKekka",
                            "items": [],
                            "controlType": "Label",
                            "width": "120",
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
                            "align": 2,
                            "text": "二次判定結果",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "ddlNijiHanteiKekka",
                            "items": [],
                            "controlType": "DropDownList",
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
                            "text": "",
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "01",
                                    "value": ""
                                },
                                {
                                    "key": "12",
                                    "value": "要支援１"
                                },
                                {
                                    "key": "13",
                                    "value": "要支援２"
                                },
                                {
                                    "key": "21",
                                    "value": "要介護１"
                                },
                                {
                                    "key": "22",
                                    "value": "要介護２"
                                },
                                {
                                    "key": "23",
                                    "value": "要介護３"
                                },
                                {
                                    "key": "24",
                                    "value": "要介護４"
                                },
                                {
                                    "key": "25",
                                    "value": "要介護５"
                                },
                                {
                                    "key": "31",
                                    "value": "非該当"
                                }
                            ]
                        },
                        {
                            "fieldName": "lblJotaiZo",
                            "items": [],
                            "controlType": "Label",
                            "width": "115",
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
                            "align": 2,
                            "text": "状態像例",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "ddlJotaiZo",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "M",
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
                            "text": "",
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "",
                                    "value": ""
                                },
                                {
                                    "key": "01",
                                    "value": "01:認知機能の低下等"
                                },
                                {
                                    "key": "02",
                                    "value": "02:不安定な状態"
                                }
                            ]
                        },
                        {
                            "fieldName": "lblNinteiYukoKikan",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 2,
                            "text": "認定期間",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtNinteiYukoKikanStart",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "lblKara3",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 1,
                            "text": "～",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtNinteiYukoKikanEnd",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "80",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "suggest": [],
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "ddlNinteiYukoTsukisu",
                            "items": [],
                            "controlType": "DropDownList",
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
                            "text": "",
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "24",
                                    "value": "２４ヶ月"
                                },
                                {
                                    "key": "12",
                                    "value": "１２ヶ月"
                                },
                                {
                                    "key": "06",
                                    "value": "６ヶ月"
                                },
                                {
                                    "key": "01",
                                    "value": "１ヶ月"
                                }
                            ]
                        },
                        {
                            "fieldName": "lblShinsakaiIken",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "align": 2,
                            "text": "審査会意見",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "txtShinsakaiIken",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "670",
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
                            "text": "",
                            "isPrivateInfo": false,
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "maxLength": "200",
                            "minLength": 0,
                            "value": "",
                            "height": "S",
                            "limitLength": "200",
                            "countDisp": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "XL",
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
                    "onLoad": "",
                    "title": "認定結果",
                    "marginTop": "XS",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "NinteiKekkaNyuryoku"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false,
                    "backgroundColor": 0,
                    "widthAuto": true
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
            "businessId": "DBE",
            "controlName": "KaigoNinteiKekka",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "ddlNijiHanteiKekka",
                    "publicChildProperty": "onChange",
                    "newPropertyName": "selectDdlNijiHantei"
                },
                {
                    "publicChildFieldName": "ddlNinteiYukoTsukisu",
                    "publicChildProperty": "onChange",
                    "newPropertyName": "selectDdlNinteiYukoTsukisu"
                },
                {
                    "publicChildFieldName": "ddlNinteiKubun",
                    "publicChildProperty": "onChange",
                    "newPropertyName": "selectDdlNinteiKubun"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KaigoNinteiKekka_Design;
    })(Uz.CommonChildDiv);
    DBE.KaigoNinteiKekka_Design = KaigoNinteiKekka_Design;
})(DBE || (DBE = {}));
