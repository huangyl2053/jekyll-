var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (KyufugakuSummary) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnCheckGendogaku", {
                get: function () {
                    return "onClick_btnCheckGendogaku";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnRireki", {
                get: function () {
                    return "onClick_btnRireki";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        KyufugakuSummary.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "KyufugakuSummary";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KyufugakuSummary = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            };

            Controls.prototype.cel11 = function () {
                return new UZA.TableCell(this.convFiledName("cel11"));
            };

            Controls.prototype.lblSummary = function () {
                return new UZA.Label(this.convFiledName("lblSummary"));
            };

            Controls.prototype.cel12 = function () {
                return new UZA.TableCell(this.convFiledName("cel12"));
            };

            Controls.prototype.lblHiyoTotal = function () {
                return new UZA.Label(this.convFiledName("lblHiyoTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenTaishoHiyo = function () {
                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));
            };

            Controls.prototype.cel21 = function () {
                return new UZA.TableCell(this.convFiledName("cel21"));
            };

            Controls.prototype.lblSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            };

            Controls.prototype.cel22 = function () {
                return new UZA.TableCell(this.convFiledName("cel22"));
            };

            Controls.prototype.txtHiyoTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalMae"));
            };

            Controls.prototype.cel23 = function () {
                return new UZA.TableCell(this.convFiledName("cel23"));
            };

            Controls.prototype.txtHokenTaishoHiyoMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoMae"));
            };

            Controls.prototype.cel31 = function () {
                return new UZA.TableCell(this.convFiledName("cel31"));
            };

            Controls.prototype.lblSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            };

            Controls.prototype.cel32 = function () {
                return new UZA.TableCell(this.convFiledName("cel32"));
            };

            Controls.prototype.txtHiyoTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalNow"));
            };

            Controls.prototype.cel33 = function () {
                return new UZA.TableCell(this.convFiledName("cel33"));
            };

            Controls.prototype.txtHokenTaishoHiyoNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoNow"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblHokenKyufuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            };

            Controls.prototype.cel24 = function () {
                return new UZA.TableCell(this.convFiledName("cel24"));
            };

            Controls.prototype.txtHokenKyufuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountMae"));
            };

            Controls.prototype.cel25 = function () {
                return new UZA.TableCell(this.convFiledName("cel25"));
            };

            Controls.prototype.txtRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            };

            Controls.prototype.cel34 = function () {
                return new UZA.TableCell(this.convFiledName("cel34"));
            };

            Controls.prototype.txtHokenKyufuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountNow"));
            };

            Controls.prototype.cel35 = function () {
                return new UZA.TableCell(this.convFiledName("cel35"));
            };

            Controls.prototype.txtRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            };

            Controls.prototype.cel36 = function () {
                return new UZA.TableCell(this.convFiledName("cel36"));
            };

            Controls.prototype.btnLimitOverCheck = function () {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            };

            Controls.prototype.cell26 = function () {
                return new UZA.TableCell(this.convFiledName("cell26"));
            };

            Controls.prototype.btnRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRireki"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        KyufugakuSummary.Controls = Controls;
    })(DBC.KyufugakuSummary || (DBC.KyufugakuSummary = {}));
    var KyufugakuSummary = DBC.KyufugakuSummary;

    var KyufugakuSummary_Design = (function (_super) {
        __extends(KyufugakuSummary_Design, _super);
        function KyufugakuSummary_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KyufugakuSummary_Design.myLayout, fieldName);
        }
        Object.defineProperty(KyufugakuSummary_Design.prototype, "btnLimitOverCheck_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[0].items[15].items[0]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KyufugakuSummary_Design.prototype, "btnRireki_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[0]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KyufugakuSummary_Design.prototype, "btnRireki_text", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KyufugakuSummary_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnLimitOverCheck_displayNone");
            Uz.JSControlUtil.registProperty("btnRireki_displayNone");
            Uz.JSControlUtil.registProperty("btnRireki_text");
        };

        KyufugakuSummary_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnLimitOverCheck_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnRireki_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnRireki_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["text"];

            return editablePropertyInfo;
        };
        KyufugakuSummary_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KyufugakuSummary",
                    "items": [
                        {
                            "fieldName": "tblSeikyuSummary",
                            "items": [
                                {
                                    "fieldName": "cel11",
                                    "items": [
                                        {
                                            "fieldName": "lblSummary",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "XS",
                                            "visible": true,
                                            "displayNone": true,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblSummary",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "集計",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "cel12",
                                    "items": [
                                        {
                                            "fieldName": "lblHiyoTotal",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "85px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblHiyoTotal",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "費用額合計",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "cel13",
                                    "items": [
                                        {
                                            "fieldName": "lblHokenTaishoHiyo",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "115px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblHokenTaishoHiyo",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "保険対象費用額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel13",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C3"
                                },
                                {
                                    "fieldName": "cel21",
                                    "items": [
                                        {
                                            "fieldName": "lblSummaryMae",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "145px",
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
                                            "selectControlID": "lblSummaryMae",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "前回までの支払結果",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel21",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "cel22",
                                    "items": [
                                        {
                                            "fieldName": "txtHiyoTotalMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtHiyoTotalMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel22",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "cel23",
                                    "items": [
                                        {
                                            "fieldName": "txtHokenTaishoHiyoMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtHokenTaishoHiyoMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel23",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "cel31",
                                    "items": [
                                        {
                                            "fieldName": "lblSummaryNow",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "145px",
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
                                            "selectControlID": "lblSummaryNow",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "今回の支払状況",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel31",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "cel32",
                                    "items": [
                                        {
                                            "fieldName": "txtHiyoTotalNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtHiyoTotalNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel32",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "cel33",
                                    "items": [
                                        {
                                            "fieldName": "txtHokenTaishoHiyoNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtHokenTaishoHiyoNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel33",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C3"
                                },
                                {
                                    "fieldName": "cel14",
                                    "items": [
                                        {
                                            "fieldName": "lblHokenKyufuAmount",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "85px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblHokenKyufuAmount",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "保険給付額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel14",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C4"
                                },
                                {
                                    "fieldName": "cel15",
                                    "items": [
                                        {
                                            "fieldName": "lblRiyoshaFutanAmount",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblRiyoshaFutanAmount",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "利用者負担額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel15",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C5"
                                },
                                {
                                    "fieldName": "cel24",
                                    "items": [
                                        {
                                            "fieldName": "txtHokenKyufuAmountMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
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
                                            "selectControlID": "txtHokenKyufuAmountMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel24",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "cel25",
                                    "items": [
                                        {
                                            "fieldName": "txtRiyoshaFutanAmountMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtRiyoshaFutanAmountMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel25",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "cel34",
                                    "items": [
                                        {
                                            "fieldName": "txtHokenKyufuAmountNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
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
                                            "selectControlID": "txtHokenKyufuAmountNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel34",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C4"
                                },
                                {
                                    "fieldName": "cel35",
                                    "items": [
                                        {
                                            "fieldName": "txtRiyoshaFutanAmountNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtRiyoshaFutanAmountNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90px",
                                            "labelRWidth": "15px",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "decorationClass": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel35",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C5"
                                },
                                {
                                    "fieldName": "cel36",
                                    "items": [
                                        {
                                            "fieldName": "btnLimitOverCheck",
                                            "items": [],
                                            "controlType": "Button",
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
                                            "selectControlID": "btnLimitOverCheck",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "text": "限度額をチェックする",
                                            "onClick": "onClick_btnCheckGendogaku",
                                            "icon": 0,
                                            "onBeforeClick": "",
                                            "onAfterClick": "",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": "",
                                            "heightTextBoxMatches": true
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cel36",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C6"
                                },
                                {
                                    "fieldName": "cell26",
                                    "items": [
                                        {
                                            "fieldName": "btnRireki",
                                            "items": [],
                                            "controlType": "ButtonDialog",
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
                                            "selectControlID": "btnRireki",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "text": "過去の住宅改修費を確認する",
                                            "onClick": "",
                                            "icon": 0,
                                            "onBeforeClick": "",
                                            "onAfterClick": "",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": "",
                                            "heightTextBoxMatches": true,
                                            "displayChildDivName": "DBC.JutakuKaishuhiRireki",
                                            "dataPassing": [],
                                            "visibleCloseButton": true,
                                            "onOkClose": "",
                                            "onBeforeOpenDialog": "onClick_btnRireki"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "cell26",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C6"
                                }
                            ],
                            "controlType": "TablePanel",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "tblSeikyuSummary",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table cellspacing=\"0\" cellpadding=\"0\">\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td><td id='R3C6'></td></tr>\n  </tbody>\n</table>\n"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "880px",
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
                    "marginRight": "XS",
                    "selectControlID": "KyufugakuSummary",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KyufugakuSummary"
                        }
                    ],
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
            "businessId": "DBC",
            "controlName": "KyufugakuSummary",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "btnLimitOverCheck",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnLimitOverCheck_displayNone"
                },
                {
                    "publicChildFieldName": "btnRireki",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnRireki_displayNone"
                },
                {
                    "publicChildFieldName": "btnRireki",
                    "publicChildProperty": "text",
                    "newPropertyName": "btnRireki_text"
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
        return KyufugakuSummary_Design;
    })(Uz.CommonChildDiv);
    DBC.KyufugakuSummary_Design = KyufugakuSummary_Design;
})(DBC || (DBC = {}));
