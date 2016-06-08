var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KaigoSaikinShorishaRireki_Design = (function (_super) {
        __extends(KaigoSaikinShorishaRireki_Design, _super);
        function KaigoSaikinShorishaRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoSaikinShorishaRireki_Design.myLayout, fieldName);
        }
        KaigoSaikinShorishaRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        KaigoSaikinShorishaRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        KaigoSaikinShorishaRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoSaikinShorishaRireki",
                    "items": [
                        {
                            "fieldName": "wrappedSaikinShorishaRireki",
                            "items": [],
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "wrappedSaikinShorishaRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "URZ",
                            "controlName": "SaikinShorishaRireki",
                            "marginTop": "0em",
                            "marginBottom": "0em",
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "firstFocusFieldName": "",
                            "lastFocusFieldName": "",
                            "modes": [],
                            "publicEvents": [
                                {
                                    "eventName": "onClick_btnSaikinShorishaHyoji"
                                },
                                {
                                    "eventName": "onBeforeClick_btnSaikinShorishaHyoji"
                                },
                                {
                                    "eventName": "onAfterClick_btnSaikinShorishaHyoji"
                                }
                            ],
                            "publicEventsAlias": [],
                            "isOneCondition": "0",
                            "SaikinShorishaRireki_width": "1100px",
                            "SaikinShorishaRireki_marginLeft": "0em",
                            "ddlSaikinShorisha_marginLeft": "XL",
                            "btnSaikinShorishaHyoji_width": "M"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1100px",
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
                    "marginLeft": "0em",
                    "marginRight": "0em",
                    "selectControlID": "KaigoSaikinShorishaRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0em",
                    "marginBottom": "0em",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KaigoSaikinShorishaRireki"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": true,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "canPost": true
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
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "KaigoSaikinShorishaRireki",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return KaigoSaikinShorishaRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoSaikinShorishaRireki_Design = KaigoSaikinShorishaRireki_Design;

    (function (KaigoSaikinShorishaRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoSaikinShorishaRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoSaikinShorishaRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoSaikinShorishaRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.wrappedSaikinShorishaRireki = function () {
                return new URZ.SaikinShorishaRireki.ModeController("wrappedSaikinShorishaRireki");
            };
            return Controls;
        })();
        KaigoSaikinShorishaRireki.Controls = Controls;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
