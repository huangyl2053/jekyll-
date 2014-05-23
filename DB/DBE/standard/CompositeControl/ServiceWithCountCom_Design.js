var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var ServiceWithCountCom_Design = (function (_super) {
        __extends(ServiceWithCountCom_Design, _super);
        function ServiceWithCountCom_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ServiceWithCountCom_Design.myLayout, fieldName);
        }
        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_ServiceName", {
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


        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_Frequency", {
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


        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_Unit", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[3]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ServiceWithCountCom_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("text_ServiceName");
            Uz.JSControlUtil.registProperty("text_Frequency");
            Uz.JSControlUtil.registProperty("text_Unit");
        };

        ServiceWithCountCom_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["text_ServiceName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Frequency"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Unit"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]).getEditablePropertyInfo()["text"];

            return editablePropertyInfo;
        };
        ServiceWithCountCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "lblServiceName",
                    "items": [],
                    "controlType": "Label",
                    "width": "325",
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
                    "required": false,
                    "align": 2,
                    "text": "サービス名称",
                    "isPrivateInfo": false
                },
                {
                    "fieldName": "lblFrequency",
                    "items": [],
                    "controlType": "Label",
                    "width": "30",
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
                    "required": false,
                    "align": 2,
                    "text": "月",
                    "isPrivateInfo": false
                },
                {
                    "fieldName": "txtNum",
                    "items": [],
                    "controlType": "TextBoxNum",
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
                    "required": false,
                    "text": "",
                    "isPrivateInfo": false,
                    "maxLength": "3",
                    "minLength": 0,
                    "textAlign": 2,
                    "readOnly": false,
                    "placeHolder": "",
                    "textKind": 2,
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
                    "maxValue": "999",
                    "minValue": 0,
                    "isCurrency": false,
                    "isComma": false,
                    "decimalPointLength": 0,
                    "permitCharactor": "+-,.\\"
                },
                {
                    "fieldName": "lblUnit",
                    "items": [],
                    "controlType": "Label",
                    "width": "30",
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
                    "marginLeft": "",
                    "marginRight": "XS",
                    "required": false,
                    "align": 0,
                    "text": "単位",
                    "isPrivateInfo": false
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
            "relation": [],
            "businessId": "DBE",
            "controlName": "ServiceWithCountCom",
            "originalProperty": [
                {
                    "publicChildFieldName": "lblServiceName",
                    "publicChildProperty": "text",
                    "newPropertyName": "text_ServiceName"
                },
                {
                    "publicChildFieldName": "lblFrequency",
                    "publicChildProperty": "text",
                    "newPropertyName": "text_Frequency"
                },
                {
                    "publicChildFieldName": "lblUnit",
                    "publicChildProperty": "text",
                    "newPropertyName": "text_Unit"
                }
            ]
        };
        return ServiceWithCountCom_Design;
    })(Uz.CompositeControl);
    DBE.ServiceWithCountCom_Design = ServiceWithCountCom_Design;
})(DBE || (DBE = {}));
