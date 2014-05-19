/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * TokkijikoComクラスのみで継承して使えます。
     */
    export class TokkijikoCom_Design extends Uz.CompositeControl {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, TokkijikoCom_Design.myLayout, fieldName);
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
   "fieldName": "lblChosaItem",
   "items": [],
   "controlType": "Label",
   "width": "64",
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
   "required": false,
   "align": 2,
   "text": "対象項目",
   "isPrivateInfo": false
  },
  {
   "fieldName": "ddlChosaItem",
   "items": [],
   "controlType": "DropDownList",
   "width": "175",
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
   "required": false,
   "onChange": "",
   "selectedItem": "0",
   "dataSource": [
    {
     "key": "0",
     "value": ""
    },
    {
     "key": "1-1",
     "value": "1-1：麻痺"
    },
    {
     "key": "1-2",
     "value": "1-2：拘縮"
    }
   ],
   "labelLText": "",
   "labelRText": "",
   "labelLWidth": "S",
   "labelRWidth": "S",
   "labelLAlign": 2,
   "labelRAlign": 0,
   "onFocus": "",
   "onBlur": ""
  },
  {
   "fieldName": "txtTokkijikoContent",
   "items": [],
   "controlType": "TextBoxMultiLine",
   "width": "575",
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
   "required": false,
   "text": "",
   "isPrivateInfo": false,
   "onChange": "",
   "labelLText": "",
   "labelRText": "",
   "labelLWidth": "S",
   "labelRWidth": "S",
   "labelLAlign": 2,
   "labelRAlign": 0,
   "onFocus": "",
   "onBlur": "",
   "maxLength": "200",
   "minLength": 0,
   "readOnly": false,
   "placeHolder": "",
   "textKind": 0,
   "height": "M",
   "limitLength": "200",
   "countDisp": true,
   "onKeyPress": "",
   "value": ""
  }
 ],
 "controlType": "CompositeControl",
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
 "relation": [],
 "businessId": "DBE",
 "controlName": "TokkijikoCom",
 "originalProperty": []
}        
    }
}

