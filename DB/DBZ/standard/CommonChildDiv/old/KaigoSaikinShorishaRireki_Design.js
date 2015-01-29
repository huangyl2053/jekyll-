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
                            "marginLeft": "0",
                            "marginRight": "0",
                            "selectControlID": "wrappedSaikinShorishaRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "businessId": "URZ",
                            "controlName": "SaikinShorishaRireki",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "isOneCondition": "0",
                            "SaikinShorishaRireki_width": "G8",
                            "SaikinShorishaRireki_marginLeft": "XS",
                            "ddlSaikinShorisha_marginLeft": "XL",
                            "btnSaikinShorishaHyoji_width": "S",
                            "onClick_btnSaikinShorishaHyoji": "onClick_btnSaikinShorishaHyoji"
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
                    "marginLeft": "0",
                    "marginRight": "0",
                    "selectControlID": "KaigoSaikinShorishaRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0",
                    "marginBottom": "0",
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
                    "widthAuto": true,
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
            "businessId": "DBZ",
            "controlName": "KaigoSaikinShorishaRireki",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return KaigoSaikinShorishaRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoSaikinShorishaRireki_Design = KaigoSaikinShorishaRireki_Design;
})(DBZ || (DBZ = {}));
