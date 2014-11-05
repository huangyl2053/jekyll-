/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KaigoShikakuKihonクラスのみで継承して使えます。
     */
    export class KaigoShikakuKihon_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoShikakuKihon_Design.myLayout, fieldName);
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
   "fieldName": "KaigoShikakuKihon",
   "items": [
    {
     "fieldName": "txtHihokenshaNo",
     "items": [],
     "controlType": "TextBox",
     "width": "85px",
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
     "selectControlID": "txtHihokenshaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "10",
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "被保番号",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtShutokuYmd",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "selectControlID": "txtShutokuYmd_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "資格取得",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtShutokuJiyu",
     "items": [],
     "controlType": "TextBox",
     "width": "85px",
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
     "selectControlID": "txtShutokuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "5",
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
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "0px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtSoshitsuYmd",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "selectControlID": "txtSoshitsuYmd_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "資格喪失",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtSoshitsuJiyu",
     "items": [],
     "controlType": "TextBox",
     "width": "85px",
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
     "selectControlID": "txtSoshitsuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "5",
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
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "0px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtJutokuKubun",
     "items": [],
     "controlType": "TextBox",
     "width": "35px",
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
     "selectControlID": "txtJutokuKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
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
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "0px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtYokaigoJotaiKubun",
     "items": [],
     "controlType": "TextBox",
     "width": "100px",
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
     "selectControlID": "txtYokaigoJotaiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "6",
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
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "要介護認定",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtNinteiKaishiYmd",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "selectControlID": "txtNinteiKaishiYmd_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "90px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtNinteiShuryoYmd",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "selectControlID": "txtNinteiShuryoYmd_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "～",
     "labelRText": "",
     "labelLWidth": "20px",
     "labelRWidth": "0px",
     "labelLAlign": 1,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "btnNinteiRireki",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "70px",
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
     "marginLeft": "0em",
     "marginRight": "0.4em",
     "selectControlID": "btnNinteiRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "認定履歴",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnHihoRireki",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "70px",
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
     "marginLeft": "0em",
     "marginRight": "0.4em",
     "selectControlID": "btnHihoRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "被保履歴",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnRenrakusaki",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "70px",
     "visible": true,
     "displayNone": true,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "0em",
     "marginRight": "0.4em",
     "selectControlID": "btnRenrakusaki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "連絡先",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.KaigoRenrakusakiInfo",
     "dataPassing": [
      {
       "key": "hihokenshaNo",
       "controlName": "txtHihokenshaNo"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    }
   ],
   "controlType": "Panel",
   "width": "1105px",
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
   "marginRight": "0em",
   "selectControlID": "KaigoShikakuKihon",
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
     "postParameterPanelNames": "KaigoShikakuKihon"
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
 "controlName": "KaigoShikakuKihon",
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

     export module KaigoShikakuKihon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoShikakuKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            }

            public KaigoShikakuKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoShikakuKihon"));
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtShutokuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            }

            public txtShutokuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            }

            public txtSoshitsuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            }

            public txtSoshitsuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            }

            public txtJutokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            }

            public txtYokaigoJotaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            }

            public txtNinteiKaishiYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            }

            public txtNinteiShuryoYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            }

            public btnNinteiRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            }

            public btnHihoRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            }

            public btnRenrakusaki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            }

        }

     }

}

