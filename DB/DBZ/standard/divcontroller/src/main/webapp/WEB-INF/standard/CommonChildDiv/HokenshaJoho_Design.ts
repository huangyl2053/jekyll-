/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module HokenshaJoho {

        export class Events {

            public static get onBlur_txtHokenshaNo(): string {
                return "onBlur_txtHokenshaNo";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "HokenshaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public HokenshaJoho() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtHokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));

            }

            public btnHokenshaSelect() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));

            }

            public txtHokenshaMeisho() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class HokenshaJoho_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HokenshaJoho_Design.myLayout, fieldName);
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
   "fieldName": "HokenshaJoho",
   "items": [
    {
     "fieldName": "txtHokenshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "50",
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
     "selectControlID": "txtHokenshaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "required": false,
     "labelLText": "保険者",
     "labelLWidth": "55",
     "labelLAlign": 2,
     "maxLength": "999999",
     "minLength": "000000",
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "onBlur_txtHokenshaNo",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelRText": "",
     "labelRWidth": "S",
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "6"
    },
    {
     "fieldName": "btnHokenshaSelect",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "10",
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
     "selectControlID": "btnHokenshaSelect",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "icon": 0,
     "text": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/css/Link.jpg",
     "imageWidth": "20",
     "imageHeight": "15",
     "heightTextBoxMatches": false,
     "displayChildDivName": "DBZ.HokenshaInputGuide",
     "dataPassing": [
      {
       "key": "hokenshaMeisho",
       "controlName": "txtHokenshaMeisho"
      },
      {
       "key": "hokenshaNo",
       "controlName": "txtHokenshaNo"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "txtHokenshaMeisho",
     "items": [],
     "controlType": "TextBox",
     "width": "230",
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
     "selectControlID": "txtHokenshaMeisho_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "onChange": "",
     "required": false,
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "maxLength": "10",
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelRText": "",
     "labelRWidth": "S",
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "400",
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
   "selectControlID": "HokenshaJoho",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "HokenshaJoho"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onBlur_txtHokenshaNo",
     "requestUrl": "dbz/db/dbz/HokenshaJoho/onBlur_txtHokenshaNo"
    }
   ],
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
   "height": "XS"
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
 "controlName": "HokenshaJoho",
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

