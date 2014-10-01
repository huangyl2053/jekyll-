/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShisetsuJohoクラスのみで継承して使えます。
     */
    export class ShisetsuJoho_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShisetsuJoho_Design.myLayout, fieldName);
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
   "fieldName": "ShisetsuJoho",
   "items": [
    {
     "fieldName": "radShisetsuShurui",
     "items": [],
     "controlType": "RadioButton",
     "width": "260px",
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
     "marginLeft": "0.15em",
     "marginRight": "0em",
     "selectControlID": "radShisetsuShurui_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "onChange_radShisetsuShurui",
     "selectedItem": null,
     "dataSource": [
      {
       "key": "kaigoHokenShisetsu",
       "value": "介護保険施設"
      },
      {
       "key": "other",
       "value": "その他特例施設"
      }
     ],
     "required": false,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "S",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "disabledItem": [],
     "icon": []
    },
    {
     "fieldName": "lblOtherShisetsuShurui",
     "items": [],
     "controlType": "Label",
     "width": "60px",
     "visible": true,
     "displayNone": true,
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
     "selectControlID": "lblOtherShisetsuShurui",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "align": 1,
     "text": "kannai",
     "isPrivateInfo": false,
     "decorationClass": ""
    },
    {
     "fieldName": "txtShisetsuCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "83px",
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
     "marginLeft": "0em",
     "marginRight": "XS",
     "selectControlID": "txtShisetsuCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "required": false,
     "labelLText": "入所施設",
     "labelLWidth": "70px",
     "labelLAlign": 2,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelRText": "",
     "labelRWidth": "S",
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "btnJigyoshaInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "20px",
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
     "selectControlID": "btnJigyoshaInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "icon": 0,
     "text": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "",
     "imageHeight": "",
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.JigyoshaInputGuide",
     "dataPassing": [
      {
       "key": "jigyoshaCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "jigyoshaMeisho",
       "controlName": "txtShisetsuMeisho"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnOtherTokureiShisetsuInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "20px",
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
     "selectControlID": "btnOtherTokureiShisetsuInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "icon": 0,
     "text": "■",
     "onBeforeClick": "",
     "onAfterClick": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "20px",
     "imageHeight": "15px",
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.OtherTokureiShisetsuInputGuide",
     "dataPassing": [
      {
       "key": "otherShisetsuCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "otherShisetsuMeisho",
       "controlName": "txtShisetsuMeisho"
      },
      {
       "key": "selectRadioButtonKey",
       "controlName": "lblOtherShisetsuShurui"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnJogaiShisetsuInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "20px",
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
     "selectControlID": "btnJogaiShisetsuInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "icon": 0,
     "text": "■",
     "onBeforeClick": "",
     "onAfterClick": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "20px",
     "imageHeight": "15px",
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.TekiyoJogaiShisetsuInputGuide",
     "dataPassing": [
      {
       "key": "shisetsuCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "shisetsuMeisho",
       "controlName": "txtShisetsuMeisho"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "txtShisetsuMeisho",
     "items": [],
     "controlType": "TextBox",
     "width": "450px",
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
     "selectControlID": "txtShisetsuMeisho_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "onChange": "",
     "required": false,
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelRText": "",
     "labelRWidth": "S",
     "labelRAlign": 0,
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "700px",
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
   "selectControlID": "ShisetsuJoho",
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
     "postParameterPanelNames": "ShisetsuJoho"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onChange_radShisetsuShurui",
     "requestUrl": "dbz/db/dbz/ShisetsuJoho/onChange_radShisetsuShurui"
    },
    {
     "eventName": "onBlur_txtShisetsuCode",
     "requestUrl": "dbz/db/dbz/ShisetsuJoho/onBlur_txtShisetsuCode"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "selectRow",
     "value": ""
    },
    {
     "propertyName": "inputMode",
     "value": ""
    }
   ],
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
 "controlName": "ShisetsuJoho",
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
   "eventName": "onChange_radShisetsuShurui"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module ShisetsuJoho {

        export class Events {

            public static onChange_radShisetsuShurui(): string {
                return "onChange_radShisetsuShurui";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuJoho"));
            }

            public radShisetsuShurui(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShisetsuShurui"));
            }

            public lblOtherShisetsuShurui(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblOtherShisetsuShurui"));
            }

            public txtShisetsuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            }

            public btnJigyoshaInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            }

            public btnOtherTokureiShisetsuInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOtherTokureiShisetsuInputGuide"));
            }

            public btnJogaiShisetsuInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJogaiShisetsuInputGuide"));
            }

            public txtShisetsuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuMeisho"));
            }

        }

     }

}

