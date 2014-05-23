/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ServiceWithCountComクラスのみで継承して使えます。
     */
    export class ServiceWithCountCom_Design extends Uz.CompositeControl {
    
        public get text_ServiceName() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["text"];
        }
        
        public set text_ServiceName(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_Frequency() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["text"];
        }
        
        public set text_Frequency(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["text"] = value;
            } else {
                this.layout.items[1]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_Unit() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["text"];
        }
        
        public set text_Unit(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"])["text"] = value;
            } else {
                this.layout.items[3]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ServiceWithCountCom_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("text_ServiceName");
            Uz.JSControlUtil.registProperty("text_Frequency");
            Uz.JSControlUtil.registProperty("text_Unit");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["text_ServiceName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Frequency"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Unit"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[3]["fieldName"]).getEditablePropertyInfo()["text"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "lblServiceName",
   "items": [],
   "controlType": "Label",
   "width": "325",
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
   "marginRight": "",
   "required": false,
   "align": 2,
   "text": "サービス名称",
   "isPrivateInfo": false
  },
  {
   "fieldName": "lblFrequency",
   "items": [],
   "controlType": "Label",
   "width": "30",
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
   "marginRight": "",
   "required": false,
   "align": 2,
   "text": "月",
   "isPrivateInfo": false
  },
  {
   "fieldName": "txtNum",
   "items": [],
   "controlType": "TextBoxNum",
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
   "required": false,
   "text": "",
   "isPrivateInfo": false,
   "maxLength": "3",
   "minLength": 0,
   "textAlign": 2,
   "readOnly": false,
   "placeHolder": "",
   "textKind": 2,
   "isPassword": false,
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
   "maxValue": "999",
   "minValue": 0,
   "isCurrency": false,
   "isComma": false,
   "decimalPointLength": 0,
   "permitCharactor": "+-,.\\"
  },
  {
   "fieldName": "lblUnit",
   "items": [],
   "controlType": "Label",
   "width": "30",
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
   "marginLeft": "",
   "marginRight": "XS",
   "required": false,
   "align": 0,
   "text": "単位",
   "isPrivateInfo": false
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
 "controlName": "ServiceWithCountCom",
 "originalProperty": [
  {
   "publicChildFieldName": "lblServiceName",
   "publicChildProperty": "text",
   "newPropertyName": "text_ServiceName"
  },
  {
   "publicChildFieldName": "lblFrequency",
   "publicChildProperty": "text",
   "newPropertyName": "text_Frequency"
  },
  {
   "publicChildFieldName": "lblUnit",
   "publicChildProperty": "text",
   "newPropertyName": "text_Unit"
  }
 ]
}        
    }
}

