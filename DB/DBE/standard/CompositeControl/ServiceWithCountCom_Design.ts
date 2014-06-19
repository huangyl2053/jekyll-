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
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["labelLText"];
        }
        
        public set text_Frequency(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[1]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_Unit() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["labelRText"];
        }
        
        public set text_Unit(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"])["labelRText"] = value;
            } else {
                this.layout.items[1]["labelRText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get radKaigoOrYobo_dataSource() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"])["selectedItem"];
        }
        
        public set radKaigoOrYobo_dataSource(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"])["selectedItem"] = value;
            } else {
                this.layout.items[2]["selectedItem"] = value;
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
            Uz.JSControlUtil.registProperty("radKaigoOrYobo_dataSource");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["text_ServiceName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Frequency"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["text_Unit"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[1]["fieldName"]).getEditablePropertyInfo()["labelRText"];
            editablePropertyInfo["radKaigoOrYobo_dataSource"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[2]["fieldName"]).getEditablePropertyInfo()["selectedItem"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "lblServiceName",
   "items": [],
   "controlType": "Label",
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
   "marginLeft": "XS",
   "marginRight": "",
   "selectControlID": "lblServiceName",
   "helpMessageID": "",
   "jpControlName": "",
   "required": false,
   "align": 2,
   "text": "サービス名称",
   "isPrivateInfo": false,
   "decorationClass": ""
  },
  {
   "fieldName": "txtNum",
   "items": [],
   "controlType": "TextBoxNum",
   "width": "24",
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
   "selectControlID": "txtNum_core",
   "helpMessageID": "",
   "jpControlName": "",
   "required": false,
   "text": "",
   "isPrivateInfo": false,
   "decorationClass": "",
   "maxLength": "3",
   "minLength": 0,
   "textAlign": 2,
   "readOnly": false,
   "placeHolder": "123",
   "textKind": 2,
   "isPassword": false,
   "isComboBox": false,
   "onFocus": "",
   "onBlur": "",
   "onChange": "",
   "onKeyPress": "",
   "suggest": [],
   "value": "",
   "labelLText": "月",
   "labelRText": "単位",
   "labelLWidth": "30",
   "labelRWidth": "32",
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
   "fieldName": "radKaigoOrYobo",
   "items": [],
   "controlType": "RadioButton",
   "width": "325",
   "visible": true,
   "displayNone": true,
   "disabled": true,
   "accessKey": "",
   "nextFocusFieldName": "",
   "wrap": true,
   "dependencies": [],
   "float": 0,
   "toolTip": "",
   "authorityMode": 0,
   "marginLeft": "XS",
   "marginRight": "XS",
   "selectControlID": "radKaigoOrYobo_core",
   "helpMessageID": "",
   "jpControlName": "",
   "onChange": "",
   "labelLText": "",
   "labelLWidth": "S",
   "labelLAlign": 2,
   "selectedItem": null,
   "dataSource": [
    {
     "key": "1",
     "value": "介護"
    },
    {
     "key": "2",
     "value": "予防"
    }
   ],
   "onClick": "",
   "newLineItemNumber": 2,
   "spaceSize": "M",
   "disabledItem": [],
   "icon": []
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
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
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
   "publicChildFieldName": "txtNum",
   "publicChildProperty": "labelLText",
   "newPropertyName": "text_Frequency"
  },
  {
   "publicChildFieldName": "txtNum",
   "publicChildProperty": "labelRText",
   "newPropertyName": "text_Unit"
  },
  {
   "publicChildFieldName": "radKaigoOrYobo",
   "publicChildProperty": "selectedItem",
   "newPropertyName": "radKaigoOrYobo_dataSource"
  }
 ]
}        
    }
}

