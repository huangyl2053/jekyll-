/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />


/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />


module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module KaigoSaikinShorishaRireki {

        export class Events {

            public static get onClick_btnSaikinShorishaHyoji(): string {
                return "onClick_btnSaikinShorishaHyoji";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "KaigoSaikinShorishaRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public wrappedSaikinShorishaRireki() : URZ.SaikinShorishaRireki.ModeController {
                return new URZ.SaikinShorishaRireki.ModeController("wrappedSaikinShorishaRireki");
            }


            public KaigoSaikinShorishaRireki() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class KaigoSaikinShorishaRireki_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoSaikinShorishaRireki_Design.myLayout, fieldName);
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
}        
    }
}

