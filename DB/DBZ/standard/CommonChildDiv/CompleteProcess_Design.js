var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        CompleteProcess.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "CompleteProcess";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.CompleteProcess = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.CompleteProssessPadding = function () {
                return new UZA.Panel(this.convFiledName("CompleteProssessPadding"));
            };

            Controls.prototype.lblCompleteMessage = function () {
                return new UZA.Label(this.convFiledName("lblCompleteMessage"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        CompleteProcess.Controls = Controls;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;

    var CompleteProcess_Design = (function (_super) {
        __extends(CompleteProcess_Design, _super);
        function CompleteProcess_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, CompleteProcess_Design.myLayout, fieldName);
        }
        Object.defineProperty(CompleteProcess_Design.prototype, "lblCompleteMessage_text", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(CompleteProcess_Design.prototype, "CompleteProcess_width", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
                } else {
                    this.layout.items[0]["width"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        CompleteProcess_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("lblCompleteMessage_text");
            Uz.JSControlUtil.registProperty("CompleteProcess_width");
        };

        CompleteProcess_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["lblCompleteMessage_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["CompleteProcess_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];

            return editablePropertyInfo;
        };
        CompleteProcess_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "CompleteProcess",
                    "items": [
                        {
                            "fieldName": "CompleteProssessPadding",
                            "items": [
                                {
                                    "fieldName": "lblCompleteMessage",
                                    "items": [],
                                    "controlType": "Label",
                                    "width": "900",
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
                                    "selectControlID": "lblCompleteMessage",
                                    "required": false,
                                    "align": 1,
                                    "text": "処理が完了しました。",
                                    "isPrivateInfo": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "950",
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
                            "selectControlID": "CompleteProssessPadding",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "10",
                            "marginBottom": "10",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "CompleteProssessPadding"
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
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1100",
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
                    "selectControlID": "CompleteProcess",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0",
                    "marginBottom": "0",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "CompleteProcess"
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
                    "panelDisplay": 1,
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
            "controlName": "CompleteProcess",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "lblCompleteMessage",
                    "publicChildProperty": "text",
                    "newPropertyName": "lblCompleteMessage_text"
                },
                {
                    "publicChildFieldName": "CompleteProcess",
                    "publicChildProperty": "width",
                    "newPropertyName": "CompleteProcess_width"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return CompleteProcess_Design;
    })(Uz.CommonChildDiv);
    DBZ.CompleteProcess_Design = CompleteProcess_Design;
})(DBZ || (DBZ = {}));
