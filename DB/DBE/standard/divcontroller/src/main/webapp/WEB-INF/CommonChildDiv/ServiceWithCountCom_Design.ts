/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ServiceWithCountComクラスのみで継承して使えます。
     */
    export class ServiceWithCountCom_Design extends Uz.CommonChildDiv {
    
        public get text_ServiceName() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"];
        }
        
        public set text_ServiceName(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[0]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_Frequency() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelLText"];
        }
        
        public set text_Frequency(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[1]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_Unit() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelRText"];
        }
        
        public set text_Unit(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelRText"] = value;
            } else {
                this.layout.items[0].items[1]["labelRText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get radKaigoOrYobo_dataSource() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["selectedItem"];
        }
        
        public set radKaigoOrYobo_dataSource(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["selectedItem"] = value;
            } else {
                this.layout.items[0].items[2]["selectedItem"] = value;
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
            editablePropertyInfo["text_ServiceName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Frequency"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["text_Unit"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["labelRText"];
            editablePropertyInfo["radKaigoOrYobo_dataSource"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["selectedItem"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ServiceWithCountCom",
   "items": [
    {
     "fieldName": "lblServiceName",
     "items": [],
     "controlType": "Label",
     "width": "400px",
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
     "width": "24px",
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
     "marginRight": "0em",
     "selectControlID": "txtNum_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": "3",
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
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
     "labelLWidth": "30px",
     "labelRWidth": "32px",
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
     "width": "325px",
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
     "readOnly": false,
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": null,
     "dataSource": [
      {
       "value": "介護",
       "key": "1"
      },
      {
       "value": "予防",
       "key": "2"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 2,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": []
    }
   ],
   "controlType": "Panel",
   "width": "G2",
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
   "selectControlID": "ServiceWithCountCom",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [],
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
   "eraseBorder": true,
   "backgroundColor": 0,
   "widthAuto": true,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto",
   "canPost": false
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
 "marginLeft": "XS",
 "marginRight": "XS",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBE",
 "controlName": "ServiceWithCountCom",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildProperty": "text",
   "publicChildFieldName": "lblServiceName",
   "newPropertyName": "text_ServiceName"
  },
  {
   "publicChildProperty": "labelLText",
   "publicChildFieldName": "txtNum",
   "newPropertyName": "text_Frequency"
  },
  {
   "publicChildProperty": "labelRText",
   "publicChildFieldName": "txtNum",
   "newPropertyName": "text_Unit"
  },
  {
   "publicChildProperty": "selectedItem",
   "publicChildFieldName": "radKaigoOrYobo",
   "newPropertyName": "radKaigoOrYobo_dataSource"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [],
 "publicEventsAlias": []
}        
    }

     export module ServiceWithCountCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceWithCountCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType() + "_" + fieldName;
            }

            public ServiceWithCountCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblServiceName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceName"));
            }

            public txtNum(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNum"));
            }

            public radKaigoOrYobo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaigoOrYobo"));
            }

        }

     }

}

