var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var TokkijikoCom2_Design = (function (_super) {
        __extends(TokkijikoCom2_Design, _super);
        function TokkijikoCom2_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, TokkijikoCom2_Design.myLayout, fieldName);
        }
        TokkijikoCom2_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        TokkijikoCom2_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        TokkijikoCom2_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "TokkijikoCom2",
                    "items": [
                        {
                            "fieldName": "ddlChosaItem",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "175px",
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
                            "selectControlID": "ddlChosaItem_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "対象項目",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "0",
                            "dataSource": [
                                {
                                    "value": "",
                                    "key": "0"
                                },
                                {
                                    "value": "1-1：麻痺",
                                    "key": "1-1"
                                },
                                {
                                    "value": "1-2：拘縮",
                                    "key": "1-2"
                                },
                                {
                                    "value": "1-3：",
                                    "key": "1-3"
                                }
                            ],
                            "disabledItem": [],
                            "isBlankLine": false
                        },
                        {
                            "fieldName": "txtTokkijikoContent",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "481px",
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
                            "selectControlID": "txtTokkijikoContent_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "120px",
                            "required": false,
                            "text": "",
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "maxLength": "200",
                            "minLength": 0,
                            "placeHolder": "",
                            "textKind": 0,
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
                            "countDisp": true
                        },
                        {
                            "fieldName": "lblSpace",
                            "items": [],
                            "controlType": "Label",
                            "width": "S",
                            "visible": false,
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
                            "selectControlID": "lblSpace",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "align": 2,
                            "text": "",
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
                    "selectControlID": "TokkijikoCom2",
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
            "controlName": "TokkijikoCom2",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
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
        return TokkijikoCom2_Design;
    })(Uz.CommonChildDiv);
    DBE.TokkijikoCom2_Design = TokkijikoCom2_Design;

    (function (TokkijikoCom2) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkijikoCom2.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkijikoCom2";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkijikoCom2.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkijikoCom2.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkijikoCom2 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlChosaItem = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItem"));
            };

            Controls.prototype.txtTokkijikoContent = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoContent"));
            };

            Controls.prototype.lblSpace = function () {
                return new UZA.Label(this.convFiledName("lblSpace"));
            };
            return Controls;
        })();
        TokkijikoCom2.Controls = Controls;
    })(DBE.TokkijikoCom2 || (DBE.TokkijikoCom2 = {}));
    var TokkijikoCom2 = DBE.TokkijikoCom2;
})(DBE || (DBE = {}));
