var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyodoJukyushaIdoRenrakuhyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "KyodoJukyushaIdoRenrakuhyo";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KyodoJukyushaIdoRenrakuhyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TextBox1 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox1"));
            };

            Controls.prototype.TextBoxDate1 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate1"));
            };

            Controls.prototype.TextBoxDate2 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate2"));
            };

            Controls.prototype.TextBox2 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox2"));
            };

            Controls.prototype.RadioButton5 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton5"));
            };

            Controls.prototype.DropDownList1 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList1"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoTeisei = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));
            };

            Controls.prototype.HorizontalLine1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine1"));
            };

            Controls.prototype.TextBoxDate3 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate3"));
            };

            Controls.prototype.RadioButton6 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton6"));
            };

            Controls.prototype.HorizontalLine5 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine5"));
            };

            Controls.prototype.CheckBoxList1 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList1"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKihon = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihon"));
            };

            Controls.prototype.TextBoxDate4 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate4"));
            };

            Controls.prototype.TextBoxNum1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum1"));
            };

            Controls.prototype.HorizontalLine2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine2"));
            };

            Controls.prototype.TextBox3 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox3"));
            };

            Controls.prototype.TextBox4 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox4"));
            };

            Controls.prototype.TextBox5 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox5"));
            };

            Controls.prototype.TextBoxYubinNo1 = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("TextBoxYubinNo1"));
            };

            Controls.prototype.TextBox7 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox7"));
            };

            Controls.prototype.TextBoxKana1 = function () {
                return new UZA.TextBoxKana(this.convFiledName("TextBoxKana1"));
            };

            Controls.prototype.CheckBoxList2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList2"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoShokan = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokan"));
            };

            Controls.prototype.TextBoxDate5 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate5"));
            };

            Controls.prototype.TextBoxNum2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum2"));
            };

            Controls.prototype.HorizontalLine3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine3"));
            };

            Controls.prototype.TextBoxDateRange1 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("TextBoxDateRange1"));
            };

            Controls.prototype.DropDownList7 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList7"));
            };

            Controls.prototype.TextBoxNum4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum4"));
            };

            Controls.prototype.CheckBoxList3 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList3"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKogaku = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku"));
            };

            Controls.prototype.TextBoxDate6 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate6"));
            };

            Controls.prototype.TextBoxNum3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum3"));
            };

            Controls.prototype.HorizontalLine4 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine4"));
            };

            Controls.prototype.TextBox6 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox6"));
            };

            Controls.prototype.DropDownList8 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList8"));
            };

            Controls.prototype.DropDownList9 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList9"));
            };

            Controls.prototype.Panel1 = function () {
                return new UZA.Panel(this.convFiledName("Panel1"));
            };

            Controls.prototype.RadioButton1 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton1"));
            };

            Controls.prototype.RadioButton2 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton2"));
            };

            Controls.prototype.RadioButton3 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton3"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        KyodoJukyushaIdoRenrakuhyo.Controls = Controls;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;

    var KyodoJukyushaIdoRenrakuhyo_Design = (function (_super) {
        __extends(KyodoJukyushaIdoRenrakuhyo_Design, _super);
        function KyodoJukyushaIdoRenrakuhyo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KyodoJukyushaIdoRenrakuhyo_Design.myLayout, fieldName);
        }
        Object.defineProperty(KyodoJukyushaIdoRenrakuhyo_Design.prototype, "TeiseiInfoVisible", {
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


        Object.defineProperty(KyodoJukyushaIdoRenrakuhyo_Design.prototype, "TeiseiInfoDisplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[6]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KyodoJukyushaIdoRenrakuhyo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("TeiseiInfoVisible");
            Uz.JSControlUtil.registProperty("TeiseiInfoDisplayNone");
        };

        KyodoJukyushaIdoRenrakuhyo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["TeiseiInfoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TeiseiInfoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["displayNone"];

            return editablePropertyInfo;
        };
        KyodoJukyushaIdoRenrakuhyo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KyodoJukyushaIdoRenrakuhyo",
                    "items": [
                        {
                            "fieldName": "TextBox1",
                            "items": [],
                            "controlType": "TextBox",
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
                            "selectControlID": "TextBox1_core",
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
                            "labelLText": "被保番号",
                            "labelRText": "",
                            "labelLWidth": "135",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "TextBoxDate1",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "selectControlID": "TextBoxDate1_core",
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
                            "labelLText": "対象年月",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "TextBoxDate2",
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
                            "selectControlID": "TextBoxDate2_core",
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
                            "labelLText": "異動日",
                            "labelRText": "",
                            "labelLWidth": "55",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "TextBox2",
                            "items": [],
                            "controlType": "TextBox",
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
                            "selectControlID": "TextBox2_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": true,
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
                            "labelLText": "証記載保険者番号",
                            "labelRText": "",
                            "labelLWidth": "135",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "RadioButton5",
                            "items": [],
                            "controlType": "RadioButton",
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
                            "selectControlID": "RadioButton5_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": true,
                            "onChange": "",
                            "labelLText": "異動区分",
                            "labelLWidth": "70",
                            "labelLAlign": 2,
                            "selectedItem": "key0",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "新規"
                                },
                                {
                                    "key": "key1",
                                    "value": "変更"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 2,
                            "spaceSize": "S",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "DropDownList1",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "160",
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
                            "selectControlID": "DropDownList1_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": true,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "異動事由",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "key0",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "value0"
                                },
                                {
                                    "key": "key1",
                                    "value": "value1"
                                }
                            ],
                            "disabledItem": []
                        },
                        {
                            "fieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
                            "items": [
                                {
                                    "fieldName": "HorizontalLine1",
                                    "items": [],
                                    "controlType": "HorizontalLine",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "HorizontalLine1",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "size": "Default"
                                },
                                {
                                    "fieldName": "TextBoxDate3",
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
                                    "selectControlID": "TextBoxDate3_core",
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
                                    "value": "",
                                    "labelLText": "訂正日",
                                    "labelRText": "",
                                    "labelLWidth": "63",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "RadioButton6",
                                    "items": [],
                                    "controlType": "RadioButton",
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
                                    "selectControlID": "RadioButton6_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "onChange": "",
                                    "labelLText": "訂正区分",
                                    "labelLWidth": "70",
                                    "labelLAlign": 2,
                                    "selectedItem": "key0",
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "修正"
                                        },
                                        {
                                            "key": "key1",
                                            "value": "削除"
                                        }
                                    ],
                                    "onClick": "",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "S",
                                    "disabledItem": [],
                                    "icon": []
                                },
                                {
                                    "fieldName": "HorizontalLine5",
                                    "items": [],
                                    "controlType": "HorizontalLine",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "HorizontalLine5",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "size": "Default"
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1105",
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
                            "selectControlID": "KyodoJukyushaIdoRenrakuhyoTeisei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "0",
                            "marginBottom": "0",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [],
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
                            "canPost": false
                        },
                        {
                            "fieldName": "CheckBoxList1",
                            "items": [],
                            "controlType": "CheckBoxList",
                            "width": "200",
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
                            "marginRight": "0",
                            "selectControlID": "CheckBoxList1_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "基本送付情報を追加する"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 2,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": [],
                            "selectedItems": [],
                            "minCheckedItem": 0,
                            "maxCheckedItem": 2,
                            "isAllSelectable": false,
                            "isAllSelectableBreakLine": false
                        },
                        {
                            "fieldName": "KyodoJukyushaIdoRenrakuhyoKihon",
                            "items": [
                                {
                                    "fieldName": "TextBoxDate4",
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
                                    "selectControlID": "TextBoxDate4_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": true,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "異動日",
                                    "labelRText": "",
                                    "labelLWidth": "55",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "TextBoxNum1",
                                    "items": [],
                                    "controlType": "TextBoxNum",
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
                                    "selectControlID": "TextBoxNum1_core",
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
                                    "labelLText": "履歴番号",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": false,
                                    "decimalPointLength": 0,
                                    "permitCharactor": "+-,.\\"
                                },
                                {
                                    "fieldName": "HorizontalLine2",
                                    "items": [],
                                    "controlType": "HorizontalLine",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "HorizontalLine2",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "size": "Default"
                                },
                                {
                                    "fieldName": "TextBox3",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "350",
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
                                    "selectControlID": "TextBox3_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "被保険者氏名",
                                    "labelRText": "",
                                    "labelLWidth": "100",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "TextBox4",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "selectControlID": "TextBox4_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "電話番号",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "TextBox5",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "selectControlID": "TextBox5_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "帳票出力順序コード",
                                    "labelRText": "",
                                    "labelLWidth": "150",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "TextBoxYubinNo1",
                                    "items": [],
                                    "controlType": "TextBoxYubinNo",
                                    "width": "70",
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
                                    "selectControlID": "TextBoxYubinNo1_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "郵便番号",
                                    "labelRText": "",
                                    "labelLWidth": "100",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "TextBox7",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "350",
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
                                    "selectControlID": "TextBox7_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "住所",
                                    "labelRText": "",
                                    "labelLWidth": "35",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "TextBoxKana1",
                                    "items": [],
                                    "controlType": "TextBoxKana",
                                    "width": "350",
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
                                    "selectControlID": "TextBoxKana1_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "カナ",
                                    "labelRText": "",
                                    "labelLWidth": "35",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "kanjiInField": "TextBox1",
                                    "kanaType": 0
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1098",
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
                            "marginRight": "0",
                            "selectControlID": "KyodoJukyushaIdoRenrakuhyoKihon",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "基本送付情報",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoKihon"
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
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": true
                        },
                        {
                            "fieldName": "CheckBoxList2",
                            "items": [],
                            "controlType": "CheckBoxList",
                            "width": "200",
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
                            "marginRight": "0",
                            "selectControlID": "CheckBoxList2_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "償還送付情報を追加する"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 2,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": [],
                            "selectedItems": [],
                            "minCheckedItem": 0,
                            "maxCheckedItem": 2,
                            "isAllSelectable": false,
                            "isAllSelectableBreakLine": false
                        },
                        {
                            "fieldName": "KyodoJukyushaIdoRenrakuhyoShokan",
                            "items": [
                                {
                                    "fieldName": "TextBoxDate5",
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
                                    "selectControlID": "TextBoxDate5_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": true,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "異動日",
                                    "labelRText": "",
                                    "labelLWidth": "55",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "TextBoxNum2",
                                    "items": [],
                                    "controlType": "TextBoxNum",
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
                                    "selectControlID": "TextBoxNum2_core",
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
                                    "labelLText": "履歴番号",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": false,
                                    "decimalPointLength": 0,
                                    "permitCharactor": "+-,.\\"
                                },
                                {
                                    "fieldName": "HorizontalLine3",
                                    "items": [],
                                    "controlType": "HorizontalLine",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "HorizontalLine3",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "size": "Default"
                                },
                                {
                                    "fieldName": "TextBoxDateRange1",
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
                                    "selectControlID": "TextBoxDateRange1_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "一時差止日",
                                    "labelRText": "",
                                    "labelLWidth": "90",
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
                                    "fromSelectControlID": "TextBoxDateRange1From",
                                    "toSelectControlID": "TextBoxDateRange1To"
                                },
                                {
                                    "fieldName": "DropDownList7",
                                    "items": [],
                                    "controlType": "DropDownList",
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
                                    "selectControlID": "DropDownList7_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "一時差止区分",
                                    "labelRText": "",
                                    "labelLWidth": "100",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "key0",
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "value0"
                                        },
                                        {
                                            "key": "key1",
                                            "value": "value1"
                                        }
                                    ],
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "TextBoxNum4",
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
                                    "selectControlID": "TextBoxNum4_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "一時差止金額",
                                    "labelRText": "",
                                    "labelLWidth": "100",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": false,
                                    "decimalPointLength": 0,
                                    "permitCharactor": "+-,.\\"
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1098",
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
                            "marginRight": "0",
                            "selectControlID": "KyodoJukyushaIdoRenrakuhyoShokan",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "償還送付情報",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoShokan"
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
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": true
                        },
                        {
                            "fieldName": "CheckBoxList3",
                            "items": [],
                            "controlType": "CheckBoxList",
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
                            "marginRight": "0",
                            "selectControlID": "CheckBoxList3_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "高額送付情報を追加する"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 2,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": [],
                            "selectedItems": [],
                            "minCheckedItem": 0,
                            "maxCheckedItem": 2,
                            "isAllSelectable": false,
                            "isAllSelectableBreakLine": false
                        },
                        {
                            "fieldName": "KyodoJukyushaIdoRenrakuhyoKogaku",
                            "items": [
                                {
                                    "fieldName": "TextBoxDate6",
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
                                    "selectControlID": "TextBoxDate6_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": true,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "異動日",
                                    "labelRText": "",
                                    "labelLWidth": "55",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "TextBoxNum3",
                                    "items": [],
                                    "controlType": "TextBoxNum",
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
                                    "selectControlID": "TextBoxNum3_core",
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
                                    "labelLText": "履歴番号",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": false,
                                    "decimalPointLength": 0,
                                    "permitCharactor": "+-,.\\"
                                },
                                {
                                    "fieldName": "HorizontalLine4",
                                    "items": [],
                                    "controlType": "HorizontalLine",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": true,
                                    "dependencies": [],
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "HorizontalLine4",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "size": "Default"
                                },
                                {
                                    "fieldName": "TextBox6",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "selectControlID": "TextBox6_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
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
                                    "labelLText": "世帯集約番号",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "DropDownList8",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "220",
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
                                    "selectControlID": "DropDownList8_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": true,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "世帯所得区分",
                                    "labelRText": "",
                                    "labelLWidth": "105",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "key0",
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "value0"
                                        },
                                        {
                                            "key": "key1",
                                            "value": "value1"
                                        }
                                    ],
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "DropDownList9",
                                    "items": [],
                                    "controlType": "DropDownList",
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
                                    "selectControlID": "DropDownList9_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": true,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "所得区分",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "key0",
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "value0"
                                        },
                                        {
                                            "key": "key1",
                                            "value": "value1"
                                        }
                                    ],
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "Panel1",
                                    "items": [
                                        {
                                            "fieldName": "RadioButton1",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "180",
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
                                            "selectControlID": "RadioButton1_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "required": true,
                                            "onChange": "",
                                            "labelLText": "老齢福祉年金",
                                            "labelLWidth": "105",
                                            "labelLAlign": 2,
                                            "selectedItem": "key0",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "受給なし"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "受給あり"
                                                }
                                            ],
                                            "onClick": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": "S",
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "RadioButton2",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "180",
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
                                            "selectControlID": "RadioButton2_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "labelLText": "利用者負担第２段階",
                                            "labelLWidth": "150",
                                            "labelLAlign": 2,
                                            "selectedItem": "key0",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "該当なし"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "該当あり"
                                                }
                                            ],
                                            "onClick": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": "S",
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "RadioButton3",
                                            "items": [],
                                            "controlType": "RadioButton",
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
                                            "selectControlID": "RadioButton3_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "labelLText": "支給申請書出力",
                                            "labelLWidth": "120",
                                            "labelLAlign": 2,
                                            "selectedItem": "key0",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "あり"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "なし"
                                                }
                                            ],
                                            "onClick": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": "S",
                                            "disabledItem": [],
                                            "icon": []
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
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "Panel1",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "0",
                                    "marginBottom": "0",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [],
                                    "requestSettings": [],
                                    "hiddenInput": [],
                                    "onOpen": "",
                                    "onClose": "",
                                    "session": {},
                                    "eraseBorder": true,
                                    "backgroundColor": 0,
                                    "widthAuto": true,
                                    "panelDisplay": 0,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "canPost": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1098",
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
                            "marginRight": "0",
                            "selectControlID": "KyodoJukyushaIdoRenrakuhyoKogaku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "高額送付情報",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoKogaku"
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
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1110",
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
                    "selectControlID": "KyodoJukyushaIdoRenrakuhyo",
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
                            "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyo"
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
                    "focusPositionID": "restoreLayoutButton",
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
            "marginLeft": "0",
            "marginRight": "0",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "businessId": "DBC",
            "controlName": "KyodoJukyushaIdoRenrakuhyo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TeiseiInfoVisible"
                },
                {
                    "publicChildFieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "TeiseiInfoDisplayNone"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": ""
        };
        return KyodoJukyushaIdoRenrakuhyo_Design;
    })(Uz.CommonChildDiv);
    DBC.KyodoJukyushaIdoRenrakuhyo_Design = KyodoJukyushaIdoRenrakuhyo_Design;
})(DBC || (DBC = {}));
