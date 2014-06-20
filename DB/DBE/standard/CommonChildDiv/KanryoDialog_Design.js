var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var KanryoDialog_Design = (function (_super) {
        __extends(KanryoDialog_Design, _super);
        function KanryoDialog_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KanryoDialog_Design.myLayout, fieldName);
        }
        KanryoDialog_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("KanryoMessage_width");
        };

        KanryoDialog_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        KanryoDialog_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KanryoDialog",
                    "items": [
                        {
                            "fieldName": "SuccessInfo",
                            "items": [
                                {
                                    "fieldName": "imgSuccess",
                                    "items": [],
                                    "controlType": "StaticImage",
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
                                    "selectControlID": "imgSuccess",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "src": "/ur/urz/img/KanryoMessage.png",
                                    "imageWidth": "35",
                                    "imageHeight": "30"
                                },
                                {
                                    "fieldName": "WrapMessageMain",
                                    "items": [
                                        {
                                            "fieldName": "lblMessageMain",
                                            "items": [],
                                            "controlType": "Label",
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
                                            "selectControlID": "lblMessageMain",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "align": 0,
                                            "text": "処理は正常に行われました。",
                                            "isPrivateInfo": false,
                                            "decorationClass": ""
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
                                    "selectControlID": "WrapMessageMain",
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
                                            "postParameterPanelNames": "WrapMessageMain"
                                        }
                                    ],
                                    "requestSettings": [],
                                    "hiddenInput": [],
                                    "onOpen": "",
                                    "onClose": "",
                                    "session": {},
                                    "eraseBorderTop": true,
                                    "eraseBorderBottom": true,
                                    "eraseBorderRight": true,
                                    "eraseBorderLeft": true,
                                    "backgroundColor": 4,
                                    "widthAuto": true,
                                    "panelDisplay": 0,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto"
                                }
                            ],
                            "controlType": "Panel",
                            "width": "346",
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
                            "selectControlID": "SuccessInfo",
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
                                    "postParameterPanelNames": "SuccessInfo"
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
                            "backgroundColor": 4,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnClose",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "text": "閉じる",
                            "onClick": "onClick_btnClose",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "icon": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G4",
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
                    "selectControlID": "KanryoDialog",
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
                            "postParameterPanelNames": "KanryoDialog"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnClose",
                            "requestUrl": "dbe/db/dbe/KanryoDialog/onClick_btnClose"
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
            "controlName": "KanryoDialog",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "KanryoMessage",
                    "publicChildProperty": "KanryoMessage_width",
                    "newPropertyName": "KanryoMessage_width"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnClose"
        };
        return KanryoDialog_Design;
    })(Uz.CommonChildDiv);
    DBE.KanryoDialog_Design = KanryoDialog_Design;
})(DBE || (DBE = {}));
