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
     "fieldName": "ddlDaichoShubetsu",
     "items": [],
     "controlType": "DropDownList",
     "width": "200px",
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
     "marginLeft": "0px",
     "marginRight": "XS",
     "selectControlID": "ddlDaichoShubetsu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "selectedItem": null,
     "dataSource": [
      {
       "key": "hihokenshaDaicho",
       "value": "被保険者台帳"
      },
      {
       "key": "tekiyoJogaishaDaicho",
       "value": "適用除外者台帳"
      },
      {
       "key": "tashichosonJushochiTokureishaDaicho",
       "value": "他市町村住所地特例者台帳"
      }
     ],
     "labelLText": "台帳種別",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "isBlankLine": false,
     "disabledItem": []
    },
    {
     "fieldName": "radShisetsuShurui",
     "items": [],
     "controlType": "RadioButton",
     "width": "380px",
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
      },
      {
       "key": "tekiyojogaishisetsu",
       "value": "適用除外施設"
      }
     ],
     "required": false,
     "labelLText": "施設種類",
     "labelLWidth": "70px",
     "labelLAlign": 2,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "S",
     "disabledItem": [],
     "icon": []
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
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "decorationClass": "",
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
     "width": "500px",
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
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "decorationClass": "",
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "750px",
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
     "eventName": "onChange_ddlDaichoShubetsu",
     "requestUrl": "dbz/db/dbz/ShisetsuJoho/onChange_ddlDaichoShubetsu"
    },
    {
     "eventName": "onChange_onChange_radShisetsuShurui",
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
   "focusPositionID": "restoreLayoutButton",
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

            public ddlDaichoShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            }

            public radShisetsuShurui(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShisetsuShurui"));
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

