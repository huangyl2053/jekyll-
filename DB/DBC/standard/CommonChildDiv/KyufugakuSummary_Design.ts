/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module KyufugakuSummary {

        export class Events {

            public static get onClick_btnCheckGendogaku(): string {
                return "onClick_btnCheckGendogaku";
            }
            public static get onClick_btnRireki(): string {
                return "onClick_btnRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "KyufugakuSummary";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public KyufugakuSummary() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public tblSeikyuSummary() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));

            }

            public cel11() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel11"));

            }

            public lblSummary() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummary"));

            }

            public cel12() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel12"));

            }

            public lblHiyoTotal() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHiyoTotal"));

            }

            public cel13() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel13"));

            }

            public lblHokenTaishoHiyo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));

            }

            public cel21() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel21"));

            }

            public lblSummaryMae() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummaryMae"));

            }

            public cel22() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel22"));

            }

            public txtHiyoTotalMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalMae"));

            }

            public cel23() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel23"));

            }

            public txtHokenTaishoHiyoMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoMae"));

            }

            public cel31() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel31"));

            }

            public lblSummaryNow() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummaryNow"));

            }

            public cel32() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel32"));

            }

            public txtHiyoTotalNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalNow"));

            }

            public cel33() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel33"));

            }

            public txtHokenTaishoHiyoNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoNow"));

            }

            public cel14() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel14"));

            }

            public lblHokenKyufuAmount() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));

            }

            public cel15() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel15"));

            }

            public lblRiyoshaFutanAmount() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));

            }

            public cel24() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel24"));

            }

            public txtHokenKyufuAmountMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountMae"));

            }

            public cel25() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel25"));

            }

            public txtRiyoshaFutanAmountMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));

            }

            public cel34() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel34"));

            }

            public txtHokenKyufuAmountNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountNow"));

            }

            public cel35() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel35"));

            }

            public txtRiyoshaFutanAmountNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));

            }

            public cel36() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel36"));

            }

            public btnLimitOverCheck() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));

            }

            public cell26() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cell26"));

            }

            public btnRireki() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnRireki"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

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
        
        public get btnRireki_text() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"];
        }
        
        public set btnRireki_text(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[0].items[16].items[0]["text"] = value;
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
            Uz.JSControlUtil.registProperty("btnRireki_text");
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
            editablePropertyInfo["btnRireki_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            
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
         "isPrivateInfo": false,
         "text": "集計",
         "decorationClass": "",
         "align": 1
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "85px",
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
         "isPrivateInfo": false,
         "text": "費用額合計",
         "decorationClass": "",
         "align": 1
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "115px",
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
         "isPrivateInfo": false,
         "text": "保険対象費用額",
         "decorationClass": "",
         "align": 1
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "145px",
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
         "isPrivateInfo": false,
         "text": "前回までの支払結果",
         "decorationClass": "",
         "align": 2
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "145px",
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
         "isPrivateInfo": false,
         "text": "今回の支払状況",
         "decorationClass": "",
         "align": 2
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "85px",
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
         "isPrivateInfo": false,
         "text": "保険給付額",
         "decorationClass": "",
         "align": 1
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "100px",
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
         "isPrivateInfo": false,
         "text": "利用者負担額",
         "decorationClass": "",
         "align": 1
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "width": "70px",
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
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "90px",
         "labelRWidth": "15px",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "icon": 0,
         "onBeforeClick": "",
         "onAfterClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
         "icon": 0,
         "onBeforeClick": "",
         "onAfterClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
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
       "marginLeft": "0em",
       "marginRight": "0em",
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
   "width": "880px",
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
 "businessId": "DBC",
 "controlName": "KyufugakuSummary",
 "marginTop": "0em",
 "marginBottom": "0em",
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
  },
  {
   "publicChildFieldName": "btnRireki",
   "publicChildProperty": "text",
   "newPropertyName": "btnRireki_text"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": ""
}        
    }
}

