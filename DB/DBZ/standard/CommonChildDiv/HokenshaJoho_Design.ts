/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HokenshaJohoクラスのみで継承して使えます。
     */
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

