/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBB {
    /**
     * 自動生成コードです。修正しないでください。
     * RentaiNofuGimushaクラスのみで継承して使えます。
     */
    export class RentaiNofuGimusha_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, RentaiNofuGimusha_Design.myLayout, fieldName);
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
   "fieldName": "RentaiNofuGimusha",
   "items": [
    {
     "fieldName": "txtShikibetsuCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "120",
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
     "marginRight": "0",
     "selectControlID": "txtShikibetsuCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "123456789012345",
     "textKind": 2,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "氏名",
     "labelRText": "",
     "labelLWidth": "60",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "15"
    },
    {
     "fieldName": "txtShimei",
     "items": [],
     "controlType": "TextBox",
     "width": "240",
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
     "marginLeft": "0.1",
     "marginRight": "XS",
     "selectControlID": "txtShimei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "１２３４５６７８９０１２３４５",
     "textKind": 0,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": ""
    },
    {
     "fieldName": "txtKaishiYMD",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "80",
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
     "selectControlID": "txtKaishiYMD_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "placeHolder": "平25.04.01",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "開始日",
     "labelRText": "",
     "labelLWidth": "60",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 1
    },
    {
     "fieldName": "txtSyuryoYMD",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "80",
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
     "selectControlID": "txtSyuryoYMD_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "placeHolder": "平25.04.01",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "終了日",
     "labelRText": "",
     "labelLWidth": "80",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 1
    }
   ],
   "controlType": "Panel",
   "width": "G6",
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
   "selectControlID": "RentaiNofuGimusha",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "RentaiNofuGimusha"
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
 "businessId": "DBB",
 "controlName": "RentaiNofuGimusha",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "nushiShikibetsuCode",
   "controlName": "txtShikibetsuCode"
  },
  {
   "key": "nushiName",
   "controlName": "txtShimei"
  }
 ],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M"
}        
    }
}

