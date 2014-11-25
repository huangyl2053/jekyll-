var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    (function (KaigoNinteiKekka) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNinteiKekka.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "KaigoNinteiKekka";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KaigoNinteiKekka = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseibi"));
            };

            Controls.prototype.txtShinseiKubunShinsei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));
            };

            Controls.prototype.txtShinseiKubunHorei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHorei"));
            };

            Controls.prototype.txtShinsaJun = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaJun"));
            };

            Controls.prototype.ddlNinteiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiKubun"));
            };

            Controls.prototype.txtIchijiHanteiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            };

            Controls.prototype.ddlTokuteiShippei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));
            };

            Controls.prototype.txtNinteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteibi"));
            };

            Controls.prototype.ddlNijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            };

            Controls.prototype.ddlJotaiZo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJotaiZo"));
            };

            Controls.prototype.txtNinteiYukoKikanStart = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanStart"));
            };

            Controls.prototype.lblKara3 = function () {
                return new UZA.Label(this.convFiledName("lblKara3"));
            };

            Controls.prototype.txtNinteiYukoKikanEnd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanEnd"));
            };

            Controls.prototype.ddlNinteiYukoTsukisu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiYukoTsukisu"));
            };

            Controls.prototype.lblShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            };

            Controls.prototype.btnShinsaIkenTeikei = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShinsaIkenTeikei"));
            };

            Controls.prototype.lblShinsakaiMemo = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiMemo"));
            };

            Controls.prototype.txtShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            };

            Controls.prototype.txtShinsakaiMemo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiMemo"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        KaigoNinteiKekka.Controls = Controls;
    })(DBE.KaigoNinteiKekka || (DBE.KaigoNinteiKekka = {}));
    var KaigoNinteiKekka = DBE.KaigoNinteiKekka;

    var KaigoNinteiKekka_Design = (function (_super) {
        __extends(KaigoNinteiKekka_Design, _super);
        function KaigoNinteiKekka_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoNinteiKekka_Design.myLayout, fieldName);
        }
        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNijiHantei", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[8]["onChange"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNinteiYukoTsukisu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[13]["onChange"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoNinteiKekka_Design.prototype, "selectDdlNinteiKubun", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["onChange"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["onChange"] = value;
                } else {
                    this.layout.items[0].items[4]["onChange"] = value;
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
            editablePropertyInfo["selectDdlNijiHantei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiYukoTsukisu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiKubun"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["onChange"];

            return editablePropertyInfo;
        };
        KaigoNinteiKekka_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoNinteiKekka",
                    "items": [
                        {
                            "fieldName": "txtShinseibi",
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
                            "selectControlID": "txtShinseibi_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "value": "",
                            "labelLText": "申請日",
                            "labelRText": "",
                            "labelLWidth": "100",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtShinseiKubunShinsei",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "65",
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
                            "selectControlID": "txtShinseiKubunShinsei_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
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
                            "suggest": [],
                            "value": "",
                            "labelLText": "申請区分（申請時）",
                            "labelRText": "",
                            "labelLWidth": "178",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtShinseiKubunHorei",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "65",
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
                            "selectControlID": "txtShinseiKubunHorei_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
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
                            "suggest": [],
                            "value": "",
                            "labelLText": "申請区分（法令）",
                            "labelRText": "",
                            "labelLWidth": "138",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtShinsaJun",
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
                            "selectControlID": "txtShinsaJun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "審査順",
                            "labelRText": "",
                            "labelLWidth": "100",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
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
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "ddlNinteiKubun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
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
                                },
                                {
                                    "key": "11",
                                    "value": "区却"
                                }
                            ],
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "認定区分",
                            "labelRText": "",
                            "labelLWidth": "100",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "01"
                        },
                        {
                            "fieldName": "txtIchijiHanteiKekka",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "65",
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
                            "selectControlID": "txtIchijiHanteiKekka_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
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
                            "suggest": [],
                            "value": "",
                            "labelLText": "一次判定結果",
                            "labelRText": "",
                            "labelLWidth": "185",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
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
                            "selectControlID": "ddlTokuteiShippei_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
                            "dataSource": [
                                {
                                    "key": "00",
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
                            ],
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "特定疾病",
                            "labelRText": "",
                            "labelLWidth": "138",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": null
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
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtNinteibi_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
                            "required": true,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "認定日",
                            "labelRText": "",
                            "labelLWidth": "100",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "ddlNijiHanteiKekka",
                            "items": [],
                            "controlType": "DropDownList",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "ddlNijiHanteiKekka_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
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
                            ],
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "二次判定結果",
                            "labelRText": "",
                            "labelLWidth": "178",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "01"
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
                            "selectControlID": "ddlJotaiZo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
                            "dataSource": [
                                {
                                    "key": "00",
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
                            ],
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "状態像例",
                            "labelRText": "",
                            "labelLWidth": "120",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": null
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
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtNinteiYukoKikanStart_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
                            "required": false,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "認定期間",
                            "labelRText": "",
                            "labelLWidth": "100",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 0
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
                            "selectControlID": "lblKara3",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "～",
                            "required": false,
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "align": 1
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
                            "selectControlID": "txtNinteiYukoKikanEnd_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "text": "",
                            "required": false,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "ddlNinteiYukoTsukisu",
                            "items": [],
                            "controlType": "DropDownList",
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
                            "marginLeft": "0",
                            "marginRight": "0",
                            "selectControlID": "ddlNinteiYukoTsukisu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "text": "",
                            "dataSource": [
                                {
                                    "key": "00",
                                    "value": ""
                                },
                                {
                                    "key": "24",
                                    "value": "２４"
                                },
                                {
                                    "key": "12",
                                    "value": "１２"
                                },
                                {
                                    "key": "06",
                                    "value": "６"
                                },
                                {
                                    "key": "01",
                                    "value": "１"
                                }
                            ],
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelRText": "ヶ月",
                            "labelLWidth": "2",
                            "labelRWidth": "40",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": null
                        },
                        {
                            "fieldName": "lblShinsakaiIken",
                            "items": [],
                            "controlType": "Label",
                            "width": "100",
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
                            "marginLeft": "S",
                            "marginRight": "14",
                            "selectControlID": "lblShinsakaiIken",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "■審査会意見",
                            "required": false,
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "align": 2
                        },
                        {
                            "fieldName": "btnShinsaIkenTeikei",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "50",
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
                            "selectControlID": "btnShinsaIkenTeikei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "text": "定型文",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false,
                            "displayChildDivName": "",
                            "dataPassing": [],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "lblShinsakaiMemo",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "4",
                            "marginRight": "14",
                            "selectControlID": "lblShinsakaiMemo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "■審査会メモ",
                            "required": false,
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "align": 2
                        },
                        {
                            "fieldName": "txtShinsakaiIken",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "415",
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
                            "marginLeft": "1.8",
                            "marginRight": "XS",
                            "selectControlID": "txtShinsakaiIken_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "40",
                            "text": "",
                            "required": false,
                            "maxLength": "200",
                            "minLength": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "limitLength": "200",
                            "countDisp": false
                        },
                        {
                            "fieldName": "txtShinsakaiMemo",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "415",
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
                            "marginLeft": "1.6",
                            "marginRight": "XS",
                            "selectControlID": "txtShinsakaiMemo_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "40",
                            "text": "",
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
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "limitLength": "200",
                            "countDisp": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1004",
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
                    "selectControlID": "KaigoNinteiKekka",
                    "helpMessageID": "",
                    "jpControlName": "",
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
                    "eraseBorder": false,
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
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return KaigoNinteiKekka_Design;
    })(Uz.CommonChildDiv);
    DBE.KaigoNinteiKekka_Design = KaigoNinteiKekka_Design;
})(DBE || (DBE = {}));
