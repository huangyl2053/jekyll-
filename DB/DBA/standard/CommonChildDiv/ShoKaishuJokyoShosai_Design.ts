/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {
    /**
     * 自動生成コードです。修正しないでください。
     * ShoKaishuJokyoShosaiクラスのみで継承して使えます。
     */
    export class ShoKaishuJokyoShosai_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShoKaishuJokyoShosai_Design.myLayout, fieldName);
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
   "fieldName": "ShoKaishuJokyoShosai",
   "items": [
    {
     "fieldName": "txtShoKofuShurui",
     "items": [],
     "controlType": "TextBox",
     "width": "160px",
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
     "selectControlID": "txtShoKofuShurui_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "交付証種類",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtKofuDate",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "90px",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKofuDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "交付日",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtYukoKigen",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "90px",
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
     "selectControlID": "txtYukoKigen_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "有効期限",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtKofuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKofuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "交付事由",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtKofuRiyu",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "800px",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKofuRiyu_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "height": "40px",
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "交付理由",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "limitLength": "200",
     "countDisp": false
    },
    {
     "fieldName": "txtKaishuDate",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "90px",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKaishuDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "回収日",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "ddlKaishuJiyu",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "ddlKaishuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "",
       "value": ""
      },
      {
       "key": "00",
       "value": "転出"
      },
      {
       "key": "01",
       "value": "受給者転入"
      },
      {
       "key": "02",
       "value": "死亡"
      },
      {
       "key": "03",
       "value": "紛失等"
      },
      {
       "key": "04",
       "value": "汚損等"
      },
      {
       "key": "05",
       "value": "証記載内容変更"
      },
      {
       "key": "06",
       "value": "居宅サービス計画届出"
      },
      {
       "key": "07",
       "value": "医療保険脱退"
      },
      {
       "key": "08",
       "value": "適用除外施設入所"
      },
      {
       "key": "09",
       "value": "住所地特例適用"
      },
      {
       "key": "10",
       "value": "住所地特例変更"
      },
      {
       "key": "11",
       "value": "住所地特例解除"
      },
      {
       "key": "12",
       "value": "住所地特例終了"
      },
      {
       "key": "13",
       "value": "支払方法変更"
      },
      {
       "key": "14",
       "value": "支払方法変更終了"
      },
      {
       "key": "15",
       "value": "保険給付差止"
      },
      {
       "key": "16",
       "value": "保険給付差止終了"
      },
      {
       "key": "17",
       "value": "滞納保険料控除"
      },
      {
       "key": "18",
       "value": "給付額減額"
      },
      {
       "key": "19",
       "value": "給付額減額免除"
      },
      {
       "key": "20",
       "value": "給付額減額終了"
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "回収事由",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "",
     "isBlankLine": false
    },
    {
     "fieldName": "txtKaishuRiyu",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "800px",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKaishuRiyu_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "40px",
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "回収理由",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "limitLength": "200",
     "countDisp": true
    }
   ],
   "controlType": "Panel",
   "width": "942px",
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
   "selectControlID": "ShoKaishuJokyoShosai",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "証類交付情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShoKaishuJokyoShosai"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    }
   ],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": false,
   "backgroundColor": 0,
   "widthAuto": false,
   "panelDisplay": 2,
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
 "businessId": "DBA",
 "controlName": "ShoKaishuJokyoShosai",
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
}        
    }

     export module ShoKaishuJokyoShosai {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuJokyoShosai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShoKaishuJokyoShosai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShoKaishuJokyoShosai.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuJokyoShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShoKofuShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtYukoKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            }

            public txtKofuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            }

            public txtKofuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            }

            public txtKaishuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            }

            public ddlKaishuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            }

            public txtKaishuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            }

        }

     }

}

