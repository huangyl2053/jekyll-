/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./KaigoAtenaInfo.ts" />
// <reference path="./KaigoShikakuKihon.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShikakuKihonJohoクラスのみで継承して使えます。
     */
    export class ShikakuKihonJoho_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShikakuKihonJoho_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            
            return editablePropertyInfo;
        }
        public static myLayout = {
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
}        
    }

     export module ShikakuKihonJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuKihonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuKihonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuKihonJoho.Controls.myType() + "_" + fieldName;
            }

            public ShikakuKihonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShikakuKihonJoho"));
            }

            //public ccdKaigoAtenaInfo(): DBZ.KaigoAtenaInfo.ModeController {
            //    return new DBZ.KaigoAtenaInfo.ModeController("ccdKaigoAtenaInfo");
            //}

            //public ccdKaigoShikakuKihon(): DBZ.KaigoShikakuKihon.ModeController {
            //    return new DBZ.KaigoShikakuKihon.ModeController("ccdKaigoShikakuKihon");
            //}

        }

     }

}

