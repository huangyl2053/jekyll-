/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     * KyufugakuSummaryクラスのみで継承して使えます。
     */
    export class KyufugakuSummary_Design extends Uz.CommonChildDiv {
    
        public get btnLimitOverCheck_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["displayNone"];
        }
        
        public set btnLimitOverCheck_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[15].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnRireki_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["displayNone"];
        }
        
        public set btnRireki_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[16].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KyufugakuSummary_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("btnLimitOverCheck_displayNone");
            Uz.JSControlUtil.registProperty("btnRireki_displayNone");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["btnLimitOverCheck_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnRireki_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KyufugakuSummary",
   "items": [
    {
     "fieldName": "tblSeikyuSummary",
     "items": [
      {
       "fieldName": "cel11",
       "items": [
        {
         "fieldName": "lblSummary",
         "items": [],
         "controlType": "Label",
         "width": "XS",
         "visible": true,
         "displayNone": true,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "lblSummary",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 1,
         "text": "集計",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel11",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C1"
      },
      {
       "fieldName": "cel12",
       "items": [
        {
         "fieldName": "lblHiyoTotal",
         "items": [],
         "controlType": "Label",
         "width": "85",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "lblHiyoTotal",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 1,
         "text": "費用額合計",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel12",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C2"
      },
      {
       "fieldName": "cel13",
       "items": [
        {
         "fieldName": "lblHokenTaishoHiyo",
         "items": [],
         "controlType": "Label",
         "width": "115",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "lblHokenTaishoHiyo",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 1,
         "text": "保険対象費用額",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel13",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C3"
      },
      {
       "fieldName": "cel21",
       "items": [
        {
         "fieldName": "lblSummaryMae",
         "items": [],
         "controlType": "Label",
         "width": "145",
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
         "selectControlID": "lblSummaryMae",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 2,
         "text": "前回までの支払結果",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel21",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C1"
      },
      {
       "fieldName": "cel22",
       "items": [
        {
         "fieldName": "txtHiyoTotalMae",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtHiyoTotalMae_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel22",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C2"
      },
      {
       "fieldName": "cel23",
       "items": [
        {
         "fieldName": "txtHokenTaishoHiyoMae",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtHokenTaishoHiyoMae_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel23",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C3"
      },
      {
       "fieldName": "cel31",
       "items": [
        {
         "fieldName": "lblSummaryNow",
         "items": [],
         "controlType": "Label",
         "width": "145",
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
         "selectControlID": "lblSummaryNow",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 2,
         "text": "今回の支払状況",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel31",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C1"
      },
      {
       "fieldName": "cel32",
       "items": [
        {
         "fieldName": "txtHiyoTotalNow",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtHiyoTotalNow_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel32",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C2"
      },
      {
       "fieldName": "cel33",
       "items": [
        {
         "fieldName": "txtHokenTaishoHiyoNow",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtHokenTaishoHiyoNow_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel33",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C3"
      },
      {
       "fieldName": "cel14",
       "items": [
        {
         "fieldName": "lblHokenKyufuAmount",
         "items": [],
         "controlType": "Label",
         "width": "85",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "lblHokenKyufuAmount",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 1,
         "text": "保険給付額",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel14",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C4"
      },
      {
       "fieldName": "cel15",
       "items": [
        {
         "fieldName": "lblRiyoshaFutanAmount",
         "items": [],
         "controlType": "Label",
         "width": "100",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "lblRiyoshaFutanAmount",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "align": 1,
         "text": "利用者負担額",
         "isPrivateInfo": false,
         "decorationClass": ""
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel15",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C5"
      },
      {
       "fieldName": "cel24",
       "items": [
        {
         "fieldName": "txtHokenKyufuAmountMae",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
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
         "selectControlID": "txtHokenKyufuAmountMae_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel24",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C4"
      },
      {
       "fieldName": "cel25",
       "items": [
        {
         "fieldName": "txtRiyoshaFutanAmountMae",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtRiyoshaFutanAmountMae_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel25",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C5"
      },
      {
       "fieldName": "cel34",
       "items": [
        {
         "fieldName": "txtHokenKyufuAmountNow",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
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
         "selectControlID": "txtHokenKyufuAmountNow_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel34",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C4"
      },
      {
       "fieldName": "cel35",
       "items": [
        {
         "fieldName": "txtRiyoshaFutanAmountNow",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "70",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 1,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "txtRiyoshaFutanAmountNow_core",
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
         "labelLWidth": "90",
         "labelRWidth": "15",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel35",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C5"
      },
      {
       "fieldName": "cel36",
       "items": [
        {
         "fieldName": "btnLimitOverCheck",
         "items": [],
         "controlType": "Button",
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
         "selectControlID": "btnLimitOverCheck",
         "helpMessageID": "",
         "jpControlName": "",
         "text": "限度額をチェックする",
         "onClick": "onClick_btnCheckGendogaku",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
         "icon": 0,
         "heightTextBoxMatches": true
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cel36",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C6"
      },
      {
       "fieldName": "cell26",
       "items": [
        {
         "fieldName": "btnRireki",
         "items": [],
         "controlType": "ButtonDialog",
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
         "selectControlID": "btnRireki",
         "helpMessageID": "",
         "jpControlName": "",
         "text": "過去の住宅改修費を確認する",
         "onClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
         "icon": 0,
         "heightTextBoxMatches": true,
         "displayChildDivName": "DBC.JutakuKaishuhiRireki",
         "dataPassing": [],
         "visibleCloseButton": true,
         "onOkClose": "",
         "onBeforeOpenDialog": "onClick_btnRireki"
        }
       ],
       "controlType": "TableCell",
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
       "selectControlID": "cell26",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C6"
      }
     ],
     "controlType": "TablePanel",
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
     "selectControlID": "tblSeikyuSummary",
     "helpMessageID": "",
     "jpControlName": "",
     "html": "<table cellspacing=\"0\" cellpadding=\"0\">\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td><td id='R3C6'></td></tr>\n  </tbody>\n</table>\n"
    }
   ],
   "controlType": "Panel",
   "width": "880",
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
   "marginRight": "XS",
   "selectControlID": "KyufugakuSummary",
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
     "postParameterPanelNames": "KyufugakuSummary"
    }
   ],
   "requestSettings": [],
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
 "businessId": "DBC",
 "controlName": "KyufugakuSummary",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnLimitOverCheck",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnLimitOverCheck_displayNone"
  },
  {
   "publicChildFieldName": "btnRireki",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnRireki_displayNone"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M"
}        
    }
}

