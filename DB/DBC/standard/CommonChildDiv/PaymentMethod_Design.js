var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var PaymentMethod_Design = (function (_super) {
        __extends(PaymentMethod_Design, _super);
        function PaymentMethod_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
        }
        PaymentMethod_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        PaymentMethod_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        PaymentMethod_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "PaymentMethod",
                    "items": [
                        {
                            "fieldName": "radPayMethod",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "300",
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
                            "onChange": "",
                            "selectedItem": "payToKoza",
                            "dataSource": [
                                {
                                    "key": "payToKoza",
                                    "value": "口座払い"
                                },
                                {
                                    "key": "payToJuryoinin",
                                    "value": "受領委任払い"
                                },
                                {
                                    "key": "payToMadoguchi",
                                    "value": "窓口払い"
                                }
                            ],
                            "required": false,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": 1,
                            "labelLText": "",
                            "labelLWidth": "60",
                            "labelLAlign": 2
                        },
                        {
                            "fieldName": "URKoza",
                            "items": [
                                {
                                    "fieldName": "txtKari1",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "onChange": "",
                                    "required": false,
                                    "labelLText": "",
                                    "labelLWidth": "S",
                                    "labelLAlign": 2,
                                    "maxLength": 1000000000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelRText": "",
                                    "labelRWidth": "S",
                                    "labelRAlign": 0
                                }
                            ],
                            "controlType": "Panel",
                            "width": "M",
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
                            "title": "口座払い（UR共有子Div）",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "DBZJuryoinin"
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
                            "widthAuto": true,
                            "isGroupBox": false
                        },
                        {
                            "fieldName": "DBZJuryoinin",
                            "items": [
                                {
                                    "fieldName": "txtKari2",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "onChange": "",
                                    "required": false,
                                    "labelLText": "",
                                    "labelLWidth": "S",
                                    "labelLAlign": 2,
                                    "maxLength": 1000000000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelRText": "",
                                    "labelRWidth": "S",
                                    "labelRAlign": 0
                                }
                            ],
                            "controlType": "Panel",
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
                            "onLoad": "",
                            "title": "受領委任払い（DBZ共有子Div）",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "DBZJuryoinin"
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
                            "widthAuto": true,
                            "isGroupBox": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "480",
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
                    "onLoad": "",
                    "title": "支払方法",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "PaymentMethod"
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
                    "widthAuto": false,
                    "isGroupBox": true
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
            "businessId": "DBC",
            "controlName": "PaymentMethod",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return PaymentMethod_Design;
    })(Uz.CommonChildDiv);
    DBC.PaymentMethod_Design = PaymentMethod_Design;
})(DBC || (DBC = {}));
