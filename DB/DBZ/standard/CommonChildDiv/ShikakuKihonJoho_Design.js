var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var ShikakuKihonJoho_Design = (function (_super) {
        __extends(ShikakuKihonJoho_Design, _super);
        function ShikakuKihonJoho_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShikakuKihonJoho_Design.myLayout, fieldName);
        }
        ShikakuKihonJoho_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShikakuKihonJoho_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShikakuKihonJoho_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShikakuKihonJoho",
                    "items": [
                        {
                            "fieldName": "ccdKaigoAtenaInfo",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "ccdKaigoAtenaInfo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "KaigoAtenaInfo",
                            "marginTop": "0px",
                            "marginBottom": "0px",
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
                            "publicEventsAlias": [],
                            "atenaInfo_title": "",
                            "atenaInfo_canOpenAndClose": true,
                            "AtenaShokaiSimple_eraseBorder": true,
                            "AtenaKanaMeisho_visible": true,
                            "AtenaMisho_visible": true,
                            "SeinengappiYMD_visible": true,
                            "Nenrei_visible": true,
                            "Seibetsu_visible": true,
                            "JuminShubetsu_Visible": true,
                            "JuminJotai_visible": true,
                            "YubinNo_visible": true,
                            "Jusho_visible": true,
                            "Gyoseiku_visible": true,
                            "ShikibetsuCode_visible": true,
                            "KojinHojinCode_visible": true,
                            "SetaiCode_visible": true,
                            "lblButtonMargin_displayNone": false,
                            "btnDainosha_displayNone": false,
                            "btnSofusaki_displayNone": false,
                            "btnDainoSofusakiKakunin_displayNone": false,
                            "btnKoza_displayNone": false,
                            "btnRenrakusaki_displayNone": false,
                            "btnShosai_displayNone": false,
                            "btnAtenaRireki_displayNone": false,
                            "btnSetaiIchiran_displayNone": false,
                            "btnDoitsunin_displayNone": false,
                            "btnToriatsukaiChui_displayNone": false,
                            "btnEltax_displayNone": false,
                            "btnShiyoJokyo_displayNone": false,
                            "btnAtesakiKakunin_displayNone": false,
                            "SubGyomuCode": "",
                            "JukiYusennKubun": "1",
                            "AgeArrivalDay": "1",
                            "SubGyomuUmu": "0",
                            "SubGyomuSearchUmu": "0",
                            "DainoninHyojiUmu": "1"
                        },
                        {
                            "fieldName": "ccdKaigoShikakuKihon",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "ccdKaigoShikakuKihon",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "title": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "KaigoShikakuKihon",
                            "marginTop": "0px",
                            "marginBottom": "0px",
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
                            "publicEventsAlias": [],
                            "canOpenAndClose": true,
                            "eraseBorder": true,
                            "btnRenrakusaki_displayNone": true,
                            "backGroundColor": 0,
                            "btnHihoRireki_visible": true,
                            "btnNinteiRireki_visible": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G12",
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
                    "marginLeft": "0px",
                    "marginRight": "0px",
                    "selectControlID": "ShikakuKihonJoho",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [],
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "ShikakuKihonJoho",
            "marginTop": "0px",
            "marginBottom": "0px",
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
        return ShikakuKihonJoho_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShikakuKihonJoho_Design = ShikakuKihonJoho_Design;

    (function (ShikakuKihonJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShikakuKihonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuKihonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuKihonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuKihonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuKihonJoho = function () {
                return new UZA.Panel(this.convFiledName("ShikakuKihonJoho"));
            };
            return Controls;
        })();
        ShikakuKihonJoho.Controls = Controls;
    })(DBZ.ShikakuKihonJoho || (DBZ.ShikakuKihonJoho = {}));
    var ShikakuKihonJoho = DBZ.ShikakuKihonJoho;
})(DBZ || (DBZ = {}));
