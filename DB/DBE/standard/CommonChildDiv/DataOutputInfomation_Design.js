var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    (function (DataOutputInfomation) {
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
            return Events;
        })();
        DataOutputInfomation.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "DataOutputInfomation";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.DataOutputInfomation = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.icnKanryo = function () {
                return new UZA.Icon(this.convFiledName("icnKanryo"));
            };

            Controls.prototype.lblMessage = function () {
                return new UZA.Label(this.convFiledName("lblMessage"));
            };

            Controls.prototype.btnKakunin = function () {
                return new UZA.Button(this.convFiledName("btnKakunin"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        DataOutputInfomation.Controls = Controls;
    })(DBE.DataOutputInfomation || (DBE.DataOutputInfomation = {}));
    var DataOutputInfomation = DBE.DataOutputInfomation;

    var DataOutputInfomation_Design = (function (_super) {
        __extends(DataOutputInfomation_Design, _super);
        function DataOutputInfomation_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, DataOutputInfomation_Design.myLayout, fieldName);
        }
        DataOutputInfomation_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        DataOutputInfomation_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        DataOutputInfomation_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "DataOutputInfomation",
                    "items": [
                        {
                            "fieldName": "icnKanryo",
                            "items": [],
                            "controlType": "Icon",
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
                            "selectControlID": "icnKanryo",
                            "icon": 0,
                            "iconSize": 1
                        },
                        {
                            "fieldName": "lblMessage",
                            "items": [],
                            "controlType": "Label",
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
                            "selectControlID": "lblMessage",
                            "required": false,
                            "align": 1,
                            "text": "データ出力が終了しました",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "btnKakunin",
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
                            "float": 1,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnKakunin",
                            "icon": 0,
                            "text": "確認",
                            "onClick": "CloseOK",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G4",
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
                    "selectControlID": "DataOutputInfomation",
                    "onLoad": "",
                    "title": "完了メッセージ",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "DataOutputInfomation"
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
                    "widthAuto": false,
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
            "businessId": "DBE",
            "controlName": "DataOutputInfomation",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "CloseOK",
            "dialogCancelEventNameForDialog": ""
        };
        return DataOutputInfomation_Design;
    })(Uz.CommonChildDiv);
    DBE.DataOutputInfomation_Design = DataOutputInfomation_Design;
})(DBE || (DBE = {}));
