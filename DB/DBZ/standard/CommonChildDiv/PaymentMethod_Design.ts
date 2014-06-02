/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * PaymentMethodクラスのみで継承して使えます。
     */
    export class PaymentMethod_Design extends Uz.CommonChildDiv {
    
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
        
        public get eraseBorderTop() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"];
        }
        
        public set eraseBorderTop(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"] = value;
            } else {
                this.layout.items[0]["eraseBorderTop"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderBottom() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"];
        }
        
        public set eraseBorderBottom(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"] = value;
            } else {
                this.layout.items[0]["eraseBorderBottom"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderRight() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"];
        }
        
        public set eraseBorderRight(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"] = value;
            } else {
                this.layout.items[0]["eraseBorderRight"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderLeft() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"];
        }
        
        public set eraseBorderLeft(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"] = value;
            } else {
                this.layout.items[0]["eraseBorderLeft"] = value;
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
        
        public get KozaPayment_title() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["title"];
        }
        
        public set KozaPayment_title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0].items[2]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("KozaPayment_title");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["KozaPayment_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["title"];
            
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
     "width": "305",
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
     "selectControlID": "radPayMethod_core",
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
     "spaceSize": "M",
     "labelLText": "",
     "labelLWidth": "60",
     "labelLAlign": 2
    },
    {
     "fieldName": "JuryoininJoho",
     "items": [
      {
       "fieldName": "txtJuryoininKeiyakuNo",
       "items": [],
       "controlType": "TextBoxCode",
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
       "selectControlID": "txtJuryoininKeiyakuNo_core",
       "onChange": "",
       "required": false,
       "labelLText": "契約番号",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
       "placeHolder": "",
       "textKind": 2,
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
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtJigyoshaNo",
       "items": [],
       "controlType": "TextBoxCode",
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
       "selectControlID": "txtJigyoshaNo_core",
       "onChange": "",
       "required": false,
       "labelLText": "事業者",
       "labelLWidth": "48",
       "labelLAlign": 2,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
       "placeHolder": "",
       "textKind": 2,
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
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtJigyoshaName",
       "items": [],
       "controlType": "TextBox",
       "width": "L",
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
       "marginLeft": "-0.2",
       "marginRight": "XS",
       "selectControlID": "txtJigyoshaName_core",
       "onChange": "",
       "required": false,
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "maxLength": 100000000,
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
       "labelRAlign": 0,
       "permitCharactor": ""
      },
      {
       "fieldName": "txtJigyoshaNameKana",
       "items": [],
       "controlType": "TextBox",
       "width": "L",
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
       "marginLeft": "20.8",
       "marginRight": "XS",
       "selectControlID": "txtJigyoshaNameKana_core",
       "onChange": "",
       "required": false,
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "maxLength": 100000000,
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
       "labelRAlign": 0,
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
     "width": "745",
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
     "selectControlID": "JuryoininJoho",
     "onLoad": "",
     "title": "受領委任情報",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JuryoininJoho"
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
     "widthAuto": false,
     "panelDisplay": 0,
     "isGroupBox": false
    },
    {
     "fieldName": "KozaPayment",
     "items": [],
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
     "selectControlID": "KozaPayment",
     "title": "口座払い",
     "relation": [],
     "businessId": "DBZ",
     "controlName": "KozaPayment",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "panelDisplay": 0,
     "KozaPayment_title": "口座払い"
    },
    {
     "fieldName": "MadoguchiPayment",
     "items": [
      {
       "fieldName": "txtShiharaiBasho",
       "items": [],
       "controlType": "TextBox",
       "width": "445",
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
       "selectControlID": "txtShiharaiBasho_core",
       "onChange": "",
       "required": false,
       "labelLText": "支払場所",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "maxLength": 100000000,
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
       "labelRAlign": 0,
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiKaishiDate",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "90",
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
       "selectControlID": "txtShiharaiKaishiDate_core",
       "onChange": "",
       "required": false,
       "labelLText": "開始日",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "readOnly": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelRText": "",
       "labelRWidth": "S",
       "labelRAlign": 0,
       "permitCharactor": "./_-",
       "ymdKubun": 2,
       "displayFormat": 0
      },
      {
       "fieldName": "txtShiharaiKaishiDay",
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
       "marginLeft": "-0.5",
       "marginRight": "XS",
       "selectControlID": "txtShiharaiKaishiDay_core",
       "onChange": "",
       "required": false,
       "labelLText": "（",
       "labelLWidth": "16",
       "labelLAlign": 2,
       "maxLength": 100000000,
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
       "labelRText": "）",
       "labelRWidth": "16",
       "labelRAlign": 0,
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiKaishiTime",
       "items": [],
       "controlType": "TextBoxTime",
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
       "selectControlID": "txtShiharaiKaishiTime_core",
       "onChange": "",
       "required": false,
       "labelLText": "開始時間",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
       "placeHolder": "12:00",
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
       "permitCharactor": "",
       "displayFormat": 0,
       "timeKubun": 1
      },
      {
       "fieldName": "txtShiharaiShuryoDate",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "90",
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
       "selectControlID": "txtShiharaiShuryoDate_core",
       "onChange": "",
       "required": false,
       "labelLText": "終了日",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "readOnly": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelRText": "",
       "labelRWidth": "S",
       "labelRAlign": 0,
       "permitCharactor": "./_-",
       "ymdKubun": 2,
       "displayFormat": 0
      },
      {
       "fieldName": "txtShiharaiShuryoDay",
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
       "marginLeft": "-0.5",
       "marginRight": "XS",
       "selectControlID": "txtShiharaiShuryoDay_core",
       "onChange": "",
       "required": false,
       "labelLText": "（",
       "labelLWidth": "16",
       "labelLAlign": 2,
       "maxLength": 100000000,
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
       "labelRText": "）",
       "labelRWidth": "16",
       "labelRAlign": 0,
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiShuryoTime",
       "items": [],
       "controlType": "TextBoxTime",
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
       "selectControlID": "txtShiharaiShuryoTime_core",
       "onChange": "",
       "required": false,
       "labelLText": "終了時間",
       "labelLWidth": "64",
       "labelLAlign": 2,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
       "placeHolder": "12:00",
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
       "permitCharactor": "",
       "displayFormat": 0,
       "timeKubun": 1
      }
     ],
     "controlType": "Panel",
     "width": "530",
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
     "selectControlID": "MadoguchiPayment",
     "onLoad": "",
     "title": "窓口払い",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "MadoguchiPayment"
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
     "widthAuto": false,
     "panelDisplay": 0,
     "isGroupBox": false
    }
   ],
   "controlType": "Panel",
   "width": "1000",
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
   "selectControlID": "PaymentMethod",
   "onLoad": "",
   "title": "支払方法",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "YoguKonyuhiShikyuShinseiPaymentMethod"
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
   "widthAuto": false,
   "panelDisplay": 1,
   "isGroupBox": false
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
 "selectControlID": "defaultLayout",
 "relation": [],
 "businessId": "DBZ",
 "controlName": "PaymentMethod",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "eraseBorderTop",
   "newPropertyName": "eraseBorderTop"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "eraseBorderBottom",
   "newPropertyName": "eraseBorderBottom"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "eraseBorderRight",
   "newPropertyName": "eraseBorderRight"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "eraseBorderLeft",
   "newPropertyName": "eraseBorderLeft"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "panelDisplay"
  },
  {
   "publicChildFieldName": "KozaPayment",
   "publicChildProperty": "title",
   "newPropertyName": "KozaPayment_title"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

