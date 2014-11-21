var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var KihonchosaResultInputCom_Design = (function (_super) {
        __extends(KihonchosaResultInputCom_Design, _super);
        function KihonchosaResultInputCom_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KihonchosaResultInputCom_Design.myLayout, fieldName);
        }
        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "text_ItemNo", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "text_ItemName", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[1]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "visible_ItemNo", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "dataSource_Choices", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["dataSource"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["dataSource"] = value;
                } else {
                    this.layout.items[0].items[3]["dataSource"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "onFocus_Answer", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["onFocus"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["onFocus"] = value;
                } else {
                    this.layout.items[0].items[2]["onFocus"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KihonchosaResultInputCom_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("text_ItemNo");
            Uz.JSControlUtil.registProperty("text_ItemName");
            Uz.JSControlUtil.registProperty("visible_ItemNo");
            Uz.JSControlUtil.registProperty("dataSource_Choices");
            Uz.JSControlUtil.registProperty("onFocus_Answer");
        };

        KihonchosaResultInputCom_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["text_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_ItemName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["visible_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["dataSource_Choices"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["dataSource"];
            editablePropertyInfo["onFocus_Answer"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["onFocus"];

            return editablePropertyInfo;
        };
        KihonchosaResultInputCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KihonchosaResultInputCom",
                    "items": [
                        {
                            "fieldName": "lblItemNo",
                            "items": [],
                            "controlType": "Label",
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
                            "marginRight": "",
                            "selectControlID": "lblItemNo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "align": 0,
                            "text": "1-10",
                            "isPrivateInfo": false,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "lblItemName",
                            "items": [],
                            "controlType": "Label",
                            "width": "130px",
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
                            "marginRight": "",
                            "selectControlID": "lblItemName",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "align": 2,
                            "text": "話がまとまらない",
                            "isPrivateInfo": false,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtAnswer",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "15px",
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
                            "marginRight": "",
                            "selectControlID": "txtAnswer_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "text": "",
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPassword": false,
                            "isComboBox": false,
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
                            "labelRAlign": 0
                        },
                        {
                            "fieldName": "radChoices",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
                            "visible": false,
                            "displayNone": true,
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
                            "selectControlID": "radChoices_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "value": "value0",
                                    "key": "1"
                                },
                                {
                                    "value": "value1",
                                    "key": "2"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 1,
                            "spaceSize": "M",
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
                    "wrap": false,
                    "dependencies": [],
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "XS",
                    "marginRight": "XS",
                    "selectControlID": "KihonchosaResultInputCom",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "XS",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
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
            "marginRight": "XS",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBE",
            "controlName": "KihonchosaResultInputCom",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildProperty": "text",
                    "publicChildFieldName": "lblItemNo",
                    "newPropertyName": "text_ItemNo"
                },
                {
                    "publicChildProperty": "text",
                    "publicChildFieldName": "lblItemName",
                    "newPropertyName": "text_ItemName"
                },
                {
                    "publicChildProperty": "visible",
                    "publicChildFieldName": "lblItemNo",
                    "newPropertyName": "visible_ItemNo"
                },
                {
                    "publicChildProperty": "dataSource",
                    "publicChildFieldName": "radChoices",
                    "newPropertyName": "dataSource_Choices"
                },
                {
                    "publicChildProperty": "onFocus",
                    "publicChildFieldName": "txtAnswer",
                    "newPropertyName": "onFocus_Answer"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return KihonchosaResultInputCom_Design;
    })(Uz.CommonChildDiv);
    DBE.KihonchosaResultInputCom_Design = KihonchosaResultInputCom_Design;

    (function (KihonchosaResultInputCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KihonchosaResultInputCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonchosaResultInputCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonchosaResultInputCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblItemNo = function () {
                return new UZA.Label(this.convFiledName("lblItemNo"));
            };

            Controls.prototype.lblItemName = function () {
                return new UZA.Label(this.convFiledName("lblItemName"));
            };

            Controls.prototype.txtAnswer = function () {
                return new UZA.TextBox(this.convFiledName("txtAnswer"));
            };

            Controls.prototype.radChoices = function () {
                return new UZA.RadioButton(this.convFiledName("radChoices"));
            };
            return Controls;
        })();
        KihonchosaResultInputCom.Controls = Controls;
    })(DBE.KihonchosaResultInputCom || (DBE.KihonchosaResultInputCom = {}));
    var KihonchosaResultInputCom = DBE.KihonchosaResultInputCom;
})(DBE || (DBE = {}));
