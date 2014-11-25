/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KozaPaymentクラスのみで継承して使えます。
     */
    export class KozaPayment_Design extends Uz.CommonChildDiv {
    
        public get title() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"];
        }
        
        public set title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorder() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
        }
        
        public set eraseBorder(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
            } else {
                this.layout.items[0]["eraseBorder"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get panelDisplay() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
        }
        
        public set panelDisplay(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
            } else {
                this.layout.items[0]["panelDisplay"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KozaPayment_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KozaPayment",
   "items": [
    {
     "fieldName": "txtKinyuKikanCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "32px",
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
     "selectControlID": "txtKinyuKikanCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "maxLength": 100000000,
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
     "labelLText": "金融機関",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "4"
    },
    {
     "fieldName": "txtKinyuKikanName",
     "items": [],
     "controlType": "TextBox",
     "width": "220px",
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
     "marginLeft": "-0.2em",
     "marginRight": "XS",
     "selectControlID": "txtKinyuKikanName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "radKozaShubetsu",
     "items": [],
     "controlType": "RadioButton",
     "width": "210px",
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
     "selectControlID": "radKozaShubetsu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "onChange": "",
     "labelLText": "口座種別",
     "labelLWidth": "70px",
     "labelLAlign": 2,
     "onClick": "",
     "icon": [],
     "dataSource": [
      {
       "key": "futsu",
       "value": "普通"
      },
      {
       "key": "toza",
       "value": "当座"
      },
      {
       "key": "other",
       "value": "その他"
      }
     ],
     "selectedItem": null,
     "newLineItemNumber": 3,
     "spaceSize": "S",
     "disabledItem": []
    },
    {
     "fieldName": "txtKozaMeigininKana",
     "items": [],
     "controlType": "TextBox",
     "width": "250px",
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
     "marginRight": "XS",
     "selectControlID": "txtKozaMeigininKana_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLText": "口座名義人",
     "labelRText": "",
     "labelLWidth": "90px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtKinyuKikanBrunchCode",
     "items": [],
     "controlType": "TextBoxCode",
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
     "marginRight": "XS",
     "selectControlID": "txtKinyuKikanBrunchCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "maxLength": 100000000,
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
     "labelLText": "支店",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "3"
    },
    {
     "fieldName": "txtKinyuKikanBrunchName",
     "items": [],
     "controlType": "TextBox",
     "width": "220px",
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
     "marginLeft": "-0.2em",
     "marginRight": "XS",
     "selectControlID": "txtKinyuKikanBrunchName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtKozaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "60px",
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
     "selectControlID": "txtKozaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "maxLength": 100000000,
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
     "labelLText": "口座番号",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "7"
    },
    {
     "fieldName": "txtKozaMeiginin",
     "items": [],
     "controlType": "TextBox",
     "width": "250px",
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
     "marginLeft": "14.8em",
     "marginRight": "XS",
     "selectControlID": "txtKozaMeiginin_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLWidth": "80px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "1013px",
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
   "selectControlID": "KozaPayment",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "口座払い",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": false,
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
 "controlName": "KozaPayment",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "KozaPayment",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "KozaPayment",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "eraseBorder"
  },
  {
   "publicChildFieldName": "KozaPayment",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "panelDisplay"
  }
 ],
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

     export module KozaPayment {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KozaPayment";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            }

            public KozaPayment(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            }

            public txtKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            }

            public radKozaShubetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            }

            public txtKozaMeigininKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            }

            public txtKinyuKikanBrunchCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            }

            public txtKinyuKikanBrunchName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            }

            public txtKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            }

            public txtKozaMeiginin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            }

        }

     }

}

