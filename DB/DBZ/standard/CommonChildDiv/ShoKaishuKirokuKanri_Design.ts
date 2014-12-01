/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShoKaishuJokyoList.ts" />
/// <reference path="./ShoKaishuJokyoShosai.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShoKaishuKirokuKanriクラスのみで継承して使えます。
     */
    export class ShoKaishuKirokuKanri_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShoKaishuKirokuKanri_Design.myLayout, fieldName);
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
   "fieldName": "ShoKaishuKirokuKanri",
   "items": [
    {
     "fieldName": "ccdShoKaishuJokyoList",
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
     "selectControlID": "ccdShoKaishuJokyoList",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "packageName": "",
     "businessId": "DBZ",
     "controlName": "ShoKaishuJokyoList",
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
    },
    {
     "fieldName": "ccdShoKaishuJokyoShosai",
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
     "selectControlID": "ccdShoKaishuJokyoShosai",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "packageName": "",
     "businessId": "DBZ",
     "controlName": "ShoKaishuJokyoShosai",
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
    },
    {
     "fieldName": "btnShoKaishuKakutei",
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
     "selectControlID": "btnShoKaishuKakutei",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "onBeforeClick_btnShoKaishuKakutei",
     "onAfterClick": "",
     "onClick": "onClick_btnShoKaishuKakutei",
     "text": "確定する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "btnShoKaishuTorikeshi",
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
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnShoKaishuTorikeshi",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnShoKaishuTorikeshi",
     "text": "取消する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "970px",
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
   "selectControlID": "ShoKaishuKirokuKanri",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
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
 "controlName": "ShoKaishuKirokuKanri",
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

     export module ShoKaishuKirokuKanri {

        export class Events {

            public static onBeforeClick_btnShoKaishuKakutei(): string {
                return "onBeforeClick_btnShoKaishuKakutei";
            }

            public static onClick_btnShoKaishuKakutei(): string {
                return "onClick_btnShoKaishuKakutei";
            }

            public static onClick_btnShoKaishuTorikeshi(): string {
                return "onClick_btnShoKaishuTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuKirokuKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuKirokuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShoKaishuJokyoList(): DBZ.ShoKaishuJokyoList.ModeController {
                return new DBZ.ShoKaishuJokyoList.ModeController("ccdShoKaishuJokyoList");
            }

            public ccdShoKaishuJokyoShosai(): DBZ.ShoKaishuJokyoShosai.ModeController {
                return new DBZ.ShoKaishuJokyoShosai.ModeController("ccdShoKaishuJokyoShosai");
            }

            public btnShoKaishuKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShoKaishuKakutei"));
            }

            public btnShoKaishuTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShoKaishuTorikeshi"));
            }

        }

     }

}

