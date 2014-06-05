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
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "text_ItemName", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[1]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "visible_ItemNo", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "dataSource_Choices", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["dataSource"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["dataSource"] = value;
                } else {
                    this.layout.items[3]["dataSource"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KihonchosaResultInputCom_Design.prototype, "onFocus_Answer", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"])["onFocus"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"])["onFocus"] = value;
                } else {
                    this.layout.items[2]["onFocus"] = value;
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
            editablePropertyInfo["text_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_ItemName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["visible_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["dataSource_Choices"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]).getEditablePropertyInfo()["dataSource"];
            editablePropertyInfo["onFocus_Answer"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"]).getEditablePropertyInfo()["onFocus"];

            return editablePropertyInfo;
        };
        KihonchosaResultInputCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "lblItemNo",
                    "items": [],
                    "controlType": "Label",
                    "width": "32",
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
                    "required": false,
                    "align": 0,
                    "text": "1-10",
                    "isPrivateInfo": false
                },
                {
                    "fieldName": "lblItemName",
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
                    "marginRight": "",
                    "selectControlID": "lblItemName",
                    "required": false,
                    "align": 2,
                    "text": "話がまとまらない",
                    "isPrivateInfo": false
                },
                {
                    "fieldName": "txtAnswer",
                    "items": [],
                    "controlType": "TextBox",
                    "width": "15",
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
                    "required": false,
                    "text": "",
                    "isPrivateInfo": false,
                    "maxLength": 100000000,
                    "minLength": 0,
                    "textAlign": 2,
                    "readOnly": false,
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
                    "width": "150",
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
                    "required": false,
                    "onChange": "",
                    "labelLText": "",
                    "labelLWidth": "S",
                    "labelLAlign": 2,
                    "selectedItem": null,
                    "dataSource": [
                        {
                            "key": "1",
                            "value": "value0"
                        },
                        {
                            "key": "2",
                            "value": "value1"
                        }
                    ],
                    "onClick": "",
                    "newLineItemNumber": 1,
                    "spaceSize": "M",
                    "icon": []
                }
            ],
            "controlType": "CompositeControl",
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
            "relation": [],
            "businessId": "DBE",
            "controlName": "KihonchosaResultInputCom",
            "originalProperty": [
                {
                    "publicChildFieldName": "lblItemNo",
                    "publicChildProperty": "text",
                    "newPropertyName": "text_ItemNo"
                },
                {
                    "publicChildFieldName": "lblItemName",
                    "publicChildProperty": "text",
                    "newPropertyName": "text_ItemName"
                },
                {
                    "publicChildFieldName": "lblItemNo",
                    "publicChildProperty": "visible",
                    "newPropertyName": "visible_ItemNo"
                },
                {
                    "publicChildFieldName": "radChoices",
                    "publicChildProperty": "dataSource",
                    "newPropertyName": "dataSource_Choices"
                },
                {
                    "publicChildFieldName": "txtAnswer",
                    "publicChildProperty": "onFocus",
                    "newPropertyName": "onFocus_Answer"
                }
            ]
        };
        return KihonchosaResultInputCom_Design;
    })(Uz.CompositeControl);
    DBE.KihonchosaResultInputCom_Design = KihonchosaResultInputCom_Design;
})(DBE || (DBE = {}));
