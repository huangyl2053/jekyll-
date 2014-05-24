/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     * PaymentMethodクラスのみで継承して使えます。
     */
    export class PaymentMethod_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
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
   "fieldName": "PaymentMethod",
   "items": [
    {
     "fieldName": "radPayMethod",
     "items": [],
     "controlType": "RadioButton",
     "width": "300",
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
     "onChange": "",
     "selectedItem": "payToKoza",
     "dataSource": [
      {
       "key": "payToKoza",
       "value": "口座払い"
      },
      {
       "key": "payToJuryoinin",
       "value": "受領委任払い"
      },
      {
       "key": "payToMadoguchi",
       "value": "窓口払い"
      }
     ],
     "required": false,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": 1,
     "labelLText": "",
     "labelLWidth": "60",
     "labelLAlign": 2
    },
    {
     "fieldName": "URKoza",
     "items": [
      {
       "fieldName": "txtKari1",
       "items": [],
       "controlType": "TextBox",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "onChange": "",
       "required": false,
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
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
       "labelRAlign": 0
      }
     ],
     "controlType": "Panel",
     "width": "M",
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
     "onLoad": "",
     "title": "口座払い（UR共有子Div）",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "DBZJuryoinin"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "isGroupBox": false
    },
    {
     "fieldName": "DBZJuryoinin",
     "items": [
      {
       "fieldName": "txtKari2",
       "items": [],
       "controlType": "TextBox",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "onChange": "",
       "required": false,
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
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
       "labelRAlign": 0
      }
     ],
     "controlType": "Panel",
     "width": "M",
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
     "onLoad": "",
     "title": "受領委任払い（DBZ共有子Div）",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "DBZJuryoinin"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "isGroupBox": false
    }
   ],
   "controlType": "Panel",
   "width": "480",
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
   "onLoad": "",
   "title": "支払方法",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "PaymentMethod"
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
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
   "backgroundColor": 0,
   "widthAuto": false,
   "isGroupBox": true
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
 "marginLeft": 0,
 "marginRight": 0,
 "relation": [],
 "businessId": "DBC",
 "controlName": "PaymentMethod",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

