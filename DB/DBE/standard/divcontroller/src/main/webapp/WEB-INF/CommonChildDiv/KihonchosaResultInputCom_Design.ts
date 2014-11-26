/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * KihonchosaResultInputComクラスのみで継承して使えます。
     */
    export class KihonchosaResultInputCom_Design extends Uz.CommonChildDiv {
    
        public get text_ItemNo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"];
        }
        
        public set text_ItemNo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[0]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get text_ItemName() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["text"];
        }
        
        public set text_ItemName(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[1]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get visible_ItemNo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"];
        }
        
        public set visible_ItemNo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[0]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dataSource_Choices() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["dataSource"];
        }
        
        public set dataSource_Choices(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["dataSource"] = value;
            } else {
                this.layout.items[0].items[3]["dataSource"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onFocus_Answer() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["onFocus"];
        }
        
        public set onFocus_Answer(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["onFocus"] = value;
            } else {
                this.layout.items[0].items[2]["onFocus"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KihonchosaResultInputCom_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("text_ItemNo");
            Uz.JSControlUtil.registProperty("text_ItemName");
            Uz.JSControlUtil.registProperty("visible_ItemNo");
            Uz.JSControlUtil.registProperty("dataSource_Choices");
            Uz.JSControlUtil.registProperty("onFocus_Answer");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["text_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_ItemName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["visible_ItemNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["dataSource_Choices"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["dataSource"];
            editablePropertyInfo["onFocus_Answer"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["onFocus"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KihonchosaResultInputCom",
   "items": [
    {
     "fieldName": "lblItemNo",
     "items": [],
     "controlType": "Label",
     "width": "32px",
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
     "marginRight": "",
     "selectControlID": "lblItemNo",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "align": 0,
     "text": "1-10",
     "isPrivateInfo": false,
     "decorationClass": ""
    },
    {
     "fieldName": "lblItemName",
     "items": [],
     "controlType": "Label",
     "width": "130px",
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
     "selectControlID": "lblItemName",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "align": 2,
     "text": "話がまとまらない",
     "isPrivateInfo": false,
     "decorationClass": ""
    },
    {
     "fieldName": "txtAnswer",
     "items": [],
     "controlType": "TextBox",
     "width": "15px",
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
     "selectControlID": "txtAnswer_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "decorationClass": "",
     "maxLength": 100000000,
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
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0
    },
    {
     "fieldName": "radChoices",
     "items": [],
     "controlType": "RadioButton",
     "width": "150px",
     "visible": false,
     "displayNone": true,
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
     "selectControlID": "radChoices_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": null,
     "dataSource": [
      {
       "value": "value0",
       "key": "1"
      },
      {
       "value": "value1",
       "key": "2"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 1,
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
   "selectControlID": "KihonchosaResultInputCom",
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
 "controlName": "KihonchosaResultInputCom",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildProperty": "text",
   "publicChildFieldName": "lblItemNo",
   "newPropertyName": "text_ItemNo"
  },
  {
   "publicChildProperty": "text",
   "publicChildFieldName": "lblItemName",
   "newPropertyName": "text_ItemName"
  },
  {
   "publicChildProperty": "visible",
   "publicChildFieldName": "lblItemNo",
   "newPropertyName": "visible_ItemNo"
  },
  {
   "publicChildProperty": "dataSource",
   "publicChildFieldName": "radChoices",
   "newPropertyName": "dataSource_Choices"
  },
  {
   "publicChildProperty": "onFocus",
   "publicChildFieldName": "txtAnswer",
   "newPropertyName": "onFocus_Answer"
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

     export module KihonchosaResultInputCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonchosaResultInputCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType() + "_" + fieldName;
            }

            public KihonchosaResultInputCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblItemNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblItemNo"));
            }

            public lblItemName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblItemName"));
            }

            public txtAnswer(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAnswer"));
            }

            public radChoices(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChoices"));
            }

        }

     }

}

