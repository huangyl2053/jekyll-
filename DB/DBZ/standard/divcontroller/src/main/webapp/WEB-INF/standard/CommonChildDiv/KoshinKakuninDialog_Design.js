var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "CloseOK", {
                get: function () {
                    return "CloseOK";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "CloseCancel", {
                get: function () {
                    return "CloseCancel";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        KoshinKakuninDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "KoshinKakuninDialog";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KoshinKakuninDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblKoshinMassage = function () {
                return new UZA.Label(this.convFiledName("lblKoshinMassage"));
            };

            Controls.prototype.btnYes = function () {
                return new UZA.Button(this.convFiledName("btnYes"));
            };

            Controls.prototype.btnNo = function () {
                return new UZA.Button(this.convFiledName("btnNo"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        KoshinKakuninDialog.Controls = Controls;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;

    var KoshinKakuninDialog_Design = (function (_super) {
        __extends(KoshinKakuninDialog_Design, _super);
        function KoshinKakuninDialog_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KoshinKakuninDialog_Design.myLayout, fieldName);
        }
        KoshinKakuninDialog_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        KoshinKakuninDialog_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        KoshinKakuninDialog_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KoshinKakuninDialog",
                    "items": [
                        {
                            "fieldName": "lblKoshinMassage",
                            "items": [],
                            "controlType": "Label",
                            "width": "280",
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
                            "selectControlID": "lblKoshinMassage",
                            "required": false,
                            "align": 0,
                            "text": "入力した資格情報で更新しますか？",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "btnYes",
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
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "3",
                            "marginRight": "XS",
                            "selectControlID": "btnYes",
                            "text": "はい",
                            "onClick": "CloseOK",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "btnNo",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
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
                            "selectControlID": "btnNo",
                            "text": "いいえ",
                            "onClick": "CloseCancel",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
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
                    "selectControlID": "KoshinKakuninDialog",
                    "onLoad": "",
                    "title": "更新確認",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KoshinKakuninDialog"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/KoshinKakunin/onLoad"
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
                    "widthAuto": true,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false
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
            "selectControlID": "defaultLayout",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "KoshinKakuninDialog",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "CloseOK",
            "dialogCancelEventNameForDialog": "CloseCancel"
        };
        return KoshinKakuninDialog_Design;
    })(Uz.CommonChildDiv);
    DBZ.KoshinKakuninDialog_Design = KoshinKakuninDialog_Design;
})(DBZ || (DBZ = {}));
