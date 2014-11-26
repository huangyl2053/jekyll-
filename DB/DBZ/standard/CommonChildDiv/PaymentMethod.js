var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KozaPayment_Design = (function (_super) {
        __extends(KozaPayment_Design, _super);
        function KozaPayment_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KozaPayment_Design.myLayout, fieldName);
        }
        Object.defineProperty(KozaPayment_Design.prototype, "title", {
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


        Object.defineProperty(KozaPayment_Design.prototype, "eraseBorder", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
                } else {
                    this.layout.items[0]["eraseBorder"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KozaPayment_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KozaPayment_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
        };

        KozaPayment_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];

            return editablePropertyInfo;
        };
        KozaPayment_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KozaPayment",
                    "items": [
                        {
                            "fieldName": "txtKinyuKikanCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "32px",
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
                            "selectControlID": "txtKinyuKikanCode_core",
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
                            "labelLText": "金融機関",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "4"
                        },
                        {
                            "fieldName": "txtKinyuKikanName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "220px",
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
                            "marginLeft": "-0.2em",
                            "marginRight": "XS",
                            "selectControlID": "txtKinyuKikanName_core",
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
                            "fieldName": "radKozaShubetsu",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "210px",
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
                            "selectControlID": "radKozaShubetsu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "onChange": "",
                            "labelLText": "口座種別",
                            "labelLWidth": "70px",
                            "labelLAlign": 2,
                            "onClick": "",
                            "icon": [],
                            "dataSource": [
                                {
                                    "key": "futsu",
                                    "value": "普通"
                                },
                                {
                                    "key": "toza",
                                    "value": "当座"
                                },
                                {
                                    "key": "other",
                                    "value": "その他"
                                }
                            ],
                            "selectedItem": null,
                            "newLineItemNumber": 3,
                            "spaceSize": "S",
                            "disabledItem": []
                        },
                        {
                            "fieldName": "txtKozaMeigininKana",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "250px",
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
                            "selectControlID": "txtKozaMeigininKana_core",
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
                            "labelLText": "口座名義人",
                            "labelRText": "",
                            "labelLWidth": "90px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKinyuKikanBrunchCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "32px",
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
                            "selectControlID": "txtKinyuKikanBrunchCode_core",
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
                            "labelLText": "支店",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "3"
                        },
                        {
                            "fieldName": "txtKinyuKikanBrunchName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "220px",
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
                            "marginLeft": "-0.2em",
                            "marginRight": "XS",
                            "selectControlID": "txtKinyuKikanBrunchName_core",
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
                            "fieldName": "txtKozaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "60px",
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
                            "selectControlID": "txtKozaNo_core",
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
                            "labelLText": "口座番号",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "7"
                        },
                        {
                            "fieldName": "txtKozaMeiginin",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "250px",
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
                            "marginLeft": "14.8em",
                            "marginRight": "XS",
                            "selectControlID": "txtKozaMeiginin_core",
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
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "80px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1013px",
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
                    "selectControlID": "KozaPayment",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "口座払い",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
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
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "KozaPayment",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                }
            ],
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
        return KozaPayment_Design;
    })(Uz.CommonChildDiv);
    DBZ.KozaPayment_Design = KozaPayment_Design;

    (function (KozaPayment) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KozaPayment.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KozaPayment";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KozaPayment = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            };

            Controls.prototype.txtKozaMeigininKana = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            };

            Controls.prototype.txtKinyuKikanBrunchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            };

            Controls.prototype.txtKinyuKikanBrunchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            };
            return Controls;
        })();
        KozaPayment.Controls = Controls;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KozaPayment.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KozaPayment.ModeController = ModeController;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KozaPayment.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KozaPayment().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KozaPayment().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KozaPayment().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KozaPayment().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KozaPayment().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KozaPayment().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KozaPayment.PublicProperties = PublicProperties;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentMethod.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "PaymentMethod";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KozaPayment = function () {
                return new DBZ.KozaPayment.ModeController("KozaPayment");
            };

            Controls.prototype.PaymentMethod = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radPayMethod1 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));
            };

            Controls.prototype.JuryoininJoho = function () {
                return new UZA.Panel(this.convFiledName("JuryoininJoho"));
            };

            Controls.prototype.txtJuryoininKeiyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtJigyoshaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));
            };

            Controls.prototype.radPayMethod2 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));
            };

            Controls.prototype.radPayMethod3 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));
            };

            Controls.prototype.MadoguchiPayment = function () {
                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtShiharaiKaishiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));
            };

            Controls.prototype.txtShiharaiKaishiDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));
            };

            Controls.prototype.txtShiharaiKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            };

            Controls.prototype.txtShiharaiShuryoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));
            };

            Controls.prototype.txtShiharaiShuryoDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));
            };

            Controls.prototype.txtShiharaiShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        PaymentMethod.Controls = Controls;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;

    var PaymentMethod_Design = (function (_super) {
        __extends(PaymentMethod_Design, _super);
        function PaymentMethod_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
        }
        Object.defineProperty(PaymentMethod_Design.prototype, "title", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "KozaPayment_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0].items[3]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "onClick_radPayMethod", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[0]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Juryoinin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[1]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Madoguchi_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[5]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Koza_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[3]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "eraseBorder", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
                } else {
                    this.layout.items[0]["eraseBorder"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        PaymentMethod_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("KozaPayment_title");
            Uz.JSControlUtil.registProperty("onClick_radPayMethod");
            Uz.JSControlUtil.registProperty("Juryoinin_displayNone");
            Uz.JSControlUtil.registProperty("Madoguchi_displayNone");
            Uz.JSControlUtil.registProperty("Koza_displayNone");
            Uz.JSControlUtil.registProperty("eraseBorder");
        };

        PaymentMethod_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["KozaPayment_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["onClick_radPayMethod"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["Juryoinin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Madoguchi_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Koza_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];

            return editablePropertyInfo;
        };
        PaymentMethod_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "PaymentMethod",
                    "items": [
                        {
                            "fieldName": "radPayMethod1",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
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
                            "selectControlID": "radPayMethod1_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToJuryoinin",
                                    "value": "受領委任払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "payToJuryoinin",
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "JuryoininJoho",
                            "items": [
                                {
                                    "fieldName": "txtJuryoininKeiyakuNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
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
                                    "selectControlID": "txtJuryoininKeiyakuNo_core",
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
                                    "labelLText": "契約番号",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtJigyoshaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
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
                                    "selectControlID": "txtJigyoshaNo_core",
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
                                    "labelLText": "事業者",
                                    "labelRText": "",
                                    "labelLWidth": "55px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtJigyoshaName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
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
                                    "marginLeft": "-0.2em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtJigyoshaName_core",
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
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtJigyoshaNameKana",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
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
                                    "marginLeft": "20.1em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtJigyoshaNameKana_core",
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
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "845px",
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
                            "selectControlID": "JuryoininJoho",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "JuryoininJoho"
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
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "canPost": true,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "radPayMethod2",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
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
                            "selectControlID": "radPayMethod2_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToKoza",
                                    "value": "口座払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "KozaPayment",
                            "items": [],
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
                            "marginLeft": "XS",
                            "marginRight": "0em",
                            "selectControlID": "KozaPayment",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "title": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "KozaPayment",
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
                            "panelDisplay": 2,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "radPayMethod3",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
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
                            "selectControlID": "radPayMethod3_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToMadoguchi",
                                    "value": "窓口払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "MadoguchiPayment",
                            "items": [
                                {
                                    "fieldName": "txtShiharaiBasho",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "445px",
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
                                    "selectControlID": "txtShiharaiBasho_core",
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
                                    "labelLText": "支払場所",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtShiharaiKaishiDate_core",
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
                                    "labelLText": "開始日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30px",
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
                                    "marginLeft": "-0.5em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiKaishiDay_core",
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
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13px",
                                    "labelRWidth": "13px",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
                                    "width": "50px",
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
                                    "selectControlID": "txtShiharaiKaishiTime_core",
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
                                    "labelLText": "開始時間",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "displayFormat": 1,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "timeKubun": 1
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtShiharaiShuryoDate_core",
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
                                    "labelLText": "終了日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30px",
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
                                    "marginLeft": "-0.5em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiShuryoDay_core",
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
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13px",
                                    "labelRWidth": "13px",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
                                    "width": "50px",
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
                                    "selectControlID": "txtShiharaiShuryoTime_core",
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
                                    "labelLText": "終了時間",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "displayFormat": 1,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "timeKubun": 1
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
                            "selectControlID": "MadoguchiPayment",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "MadoguchiPayment"
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
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "canPost": true,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1040px",
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
                    "selectControlID": "PaymentMethod",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "支払方法",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 1,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "canPost": true,
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false
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
            "controlName": "PaymentMethod",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "title",
                    "newPropertyName": "KozaPayment_title"
                },
                {
                    "publicChildFieldName": "radPayMethod1",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "onClick_radPayMethod"
                },
                {
                    "publicChildFieldName": "JuryoininJoho",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Juryoinin_displayNone"
                },
                {
                    "publicChildFieldName": "MadoguchiPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Madoguchi_displayNone"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Koza_displayNone"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
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
        return PaymentMethod_Design;
    })(Uz.CommonChildDiv);
    DBZ.PaymentMethod_Design = PaymentMethod_Design;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        PaymentMethod.ModeController = ModeController;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.PaymentMethod().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.PaymentMethod().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentMethod().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentMethod().panelDisplay = value;
            };

            PublicProperties.prototype.getonClick_radPayMethod = function () {
                return this.controls.radPayMethod1().onClick;
            };

            PublicProperties.prototype.setonClick_radPayMethod = function (value) {
                this.controls.radPayMethod1().onClick = value;
            };

            PublicProperties.prototype.getJuryoinin_displayNone = function () {
                return this.controls.JuryoininJoho().displayNone;
            };

            PublicProperties.prototype.setJuryoinin_displayNone = function (value) {
                this.controls.JuryoininJoho().displayNone = value;
            };

            PublicProperties.prototype.getMadoguchi_displayNone = function () {
                return this.controls.MadoguchiPayment().displayNone;
            };

            PublicProperties.prototype.setMadoguchi_displayNone = function (value) {
                this.controls.MadoguchiPayment().displayNone = value;
            };

            PublicProperties.prototype.getKoza_displayNone = function () {
                return this.controls.KozaPayment().Properties().displayNone;
            };

            PublicProperties.prototype.setKoza_displayNone = function (value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.PaymentMethod().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.PaymentMethod().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
