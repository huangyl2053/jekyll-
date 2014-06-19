var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var HokenshaJoho_Design = (function (_super) {
        __extends(HokenshaJoho_Design, _super);
        function HokenshaJoho_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, HokenshaJoho_Design.myLayout, fieldName);
        }
        HokenshaJoho_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        HokenshaJoho_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        HokenshaJoho_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "HokenshaJoho",
                    "items": [
                        {
                            "fieldName": "txtHokenshaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
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
                            "selectControlID": "txtHokenshaNo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": "999999",
                            "minLength": "000000",
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "onBlur_txtHokenshaNo",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "保険者",
                            "labelRText": "",
                            "labelLWidth": "55",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "6"
                        },
                        {
                            "fieldName": "btnHokenshaSelect",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "10",
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
                            "selectControlID": "btnHokenshaSelect",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "",
                            "onClick": "",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                            "imageWidth": "20",
                            "imageHeight": "15",
                            "icon": 0,
                            "displayChildDivName": "DBZ.HokenshaInputGuide",
                            "dataPassing": [
                                {
                                    "key": "hokenshaMeisho",
                                    "controlName": "txtHokenshaMeisho"
                                },
                                {
                                    "key": "hokenshaNo",
                                    "controlName": "txtHokenshaNo"
                                }
                            ],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "txtHokenshaMeisho",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "230",
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
                            "selectControlID": "txtHokenshaMeisho_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "maxLength": "10",
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
                        }
                    ],
                    "controlType": "Panel",
                    "width": "400",
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
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "HokenshaJoho",
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
                            "postParameterPanelNames": "HokenshaJoho"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onBlur_txtHokenshaNo",
                            "requestUrl": "dbz/db/dbz/HokenshaJoho/onBlur_txtHokenshaNo"
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": true,
                    "eraseBorderBottom": true,
                    "eraseBorderRight": true,
                    "eraseBorderLeft": true,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "XS"
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
            "controlName": "HokenshaJoho",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return HokenshaJoho_Design;
    })(Uz.CommonChildDiv);
    DBZ.HokenshaJoho_Design = HokenshaJoho_Design;
})(DBZ || (DBZ = {}));
