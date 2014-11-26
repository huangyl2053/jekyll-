/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module KyodoJukyushaIdoRenrakuhyo {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "KyodoJukyushaIdoRenrakuhyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public KyodoJukyushaIdoRenrakuhyo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public TextBox1() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox1"));

            }

            public TextBoxDate1() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate1"));

            }

            public TextBoxDate2() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate2"));

            }

            public TextBox2() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox2"));

            }

            public RadioButton5() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton5"));

            }

            public DropDownList1() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("DropDownList1"));

            }

            public KyodoJukyushaIdoRenrakuhyoTeisei() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));

            }

            public HorizontalLine1() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine1"));

            }

            public TextBoxDate3() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate3"));

            }

            public RadioButton6() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton6"));

            }

            public HorizontalLine5() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine5"));

            }

            public CheckBoxList1() : UZA.CheckBoxList {

                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList1"));

            }

            public KyodoJukyushaIdoRenrakuhyoKihon() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihon"));

            }

            public TextBoxDate4() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate4"));

            }

            public TextBoxNum1() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum1"));

            }

            public HorizontalLine2() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine2"));

            }

            public TextBox3() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox3"));

            }

            public TextBox4() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox4"));

            }

            public TextBox5() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox5"));

            }

            public TextBoxYubinNo1() : UZA.TextBoxYubinNo {

                return new UZA.TextBoxYubinNo(this.convFiledName("TextBoxYubinNo1"));

            }

            public TextBox7() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox7"));

            }

            public TextBoxKana1() : UZA.TextBoxKana {

                return new UZA.TextBoxKana(this.convFiledName("TextBoxKana1"));

            }

            public CheckBoxList2() : UZA.CheckBoxList {

                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList2"));

            }

            public KyodoJukyushaIdoRenrakuhyoShokan() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokan"));

            }

            public TextBoxDate5() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate5"));

            }

            public TextBoxNum2() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum2"));

            }

            public HorizontalLine3() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine3"));

            }

            public TextBoxDateRange1() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("TextBoxDateRange1"));

            }

            public DropDownList7() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("DropDownList7"));

            }

            public TextBoxNum4() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum4"));

            }

            public CheckBoxList3() : UZA.CheckBoxList {

                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList3"));

            }

            public KyodoJukyushaIdoRenrakuhyoKogaku() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku"));

            }

            public TextBoxDate6() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate6"));

            }

            public TextBoxNum3() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum3"));

            }

            public HorizontalLine4() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine4"));

            }

            public TextBox6() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("TextBox6"));

            }

            public DropDownList8() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("DropDownList8"));

            }

            public DropDownList9() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("DropDownList9"));

            }

            public Panel1() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("Panel1"));

            }

            public RadioButton1() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton1"));

            }

            public RadioButton2() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton2"));

            }

            public RadioButton3() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton3"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class KyodoJukyushaIdoRenrakuhyo_Design extends Uz.CommonChildDiv {
    
        public get TeiseiInfoVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"];
        }
        
        public set TeiseiInfoVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[6]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get TeiseiInfoDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"];
        }
        
        public set TeiseiInfoDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[6]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KyodoJukyushaIdoRenrakuhyo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("TeiseiInfoVisible");
            Uz.JSControlUtil.registProperty("TeiseiInfoDisplayNone");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["TeiseiInfoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TeiseiInfoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KyodoJukyushaIdoRenrakuhyo",
   "items": [
    {
     "fieldName": "TextBox1",
     "items": [],
     "controlType": "TextBox",
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
     "selectControlID": "TextBox1_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
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
     "labelLText": "被保番号",
     "labelRText": "",
     "labelLWidth": "135",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "TextBoxDate1",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "60",
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
     "selectControlID": "TextBoxDate1_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "対象年月",
     "labelRText": "",
     "labelLWidth": "70",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "TextBoxDate2",
     "items": [],
     "controlType": "TextBoxDate",
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
     "selectControlID": "TextBoxDate2_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "異動日",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "TextBox2",
     "items": [],
     "controlType": "TextBox",
     "width": "80",
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
     "selectControlID": "TextBox2_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": true,
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
     "labelLText": "証記載保険者番号",
     "labelRText": "",
     "labelLWidth": "135",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "RadioButton5",
     "items": [],
     "controlType": "RadioButton",
     "width": "120",
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
     "selectControlID": "RadioButton5_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": true,
     "onChange": "",
     "labelLText": "異動区分",
     "labelLWidth": "70",
     "labelLAlign": 2,
     "selectedItem": "key0",
     "dataSource": [
      {
       "key": "key0",
       "value": "新規"
      },
      {
       "key": "key1",
       "value": "変更"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 2,
     "spaceSize": "S",
     "disabledItem": [],
     "icon": []
    },
    {
     "fieldName": "DropDownList1",
     "items": [],
     "controlType": "DropDownList",
     "width": "160",
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
     "selectControlID": "DropDownList1_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "異動事由",
     "labelRText": "",
     "labelLWidth": "70",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "key0",
     "dataSource": [
      {
       "key": "key0",
       "value": "value0"
      },
      {
       "key": "key1",
       "value": "value1"
      }
     ],
     "disabledItem": []
    },
    {
     "fieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
     "items": [
      {
       "fieldName": "HorizontalLine1",
       "items": [],
       "controlType": "HorizontalLine",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "HorizontalLine1",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      },
      {
       "fieldName": "TextBoxDate3",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "TextBoxDate3_core",
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
       "value": "",
       "labelLText": "訂正日",
       "labelRText": "",
       "labelLWidth": "63",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "RadioButton6",
       "items": [],
       "controlType": "RadioButton",
       "width": "120",
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
       "selectControlID": "RadioButton6_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "訂正区分",
       "labelLWidth": "70",
       "labelLAlign": 2,
       "selectedItem": "key0",
       "dataSource": [
        {
         "key": "key0",
         "value": "修正"
        },
        {
         "key": "key1",
         "value": "削除"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 2,
       "spaceSize": "S",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "HorizontalLine5",
       "items": [],
       "controlType": "HorizontalLine",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "HorizontalLine5",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      }
     ],
     "controlType": "Panel",
     "width": "1105",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "KyodoJukyushaIdoRenrakuhyoTeisei",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "0",
     "marginBottom": "0",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorder": true,
     "backgroundColor": 0,
     "widthAuto": false,
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "canPost": false
    },
    {
     "fieldName": "CheckBoxList1",
     "items": [],
     "controlType": "CheckBoxList",
     "width": "200",
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
     "marginRight": "0",
     "selectControlID": "CheckBoxList1_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "key0",
       "value": "基本送付情報を追加する"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 2,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": [],
     "selectedItems": [],
     "minCheckedItem": 0,
     "maxCheckedItem": 2,
     "isAllSelectable": false,
     "isAllSelectableBreakLine": false
    },
    {
     "fieldName": "KyodoJukyushaIdoRenrakuhyoKihon",
     "items": [
      {
       "fieldName": "TextBoxDate4",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "TextBoxDate4_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": true,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelLText": "異動日",
       "labelRText": "",
       "labelLWidth": "55",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "TextBoxNum1",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "60",
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
       "selectControlID": "TextBoxNum1_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
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
       "labelLText": "履歴番号",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": false,
       "decimalPointLength": 0,
       "permitCharactor": "+-,.\\"
      },
      {
       "fieldName": "HorizontalLine2",
       "items": [],
       "controlType": "HorizontalLine",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "HorizontalLine2",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      },
      {
       "fieldName": "TextBox3",
       "items": [],
       "controlType": "TextBox",
       "width": "350",
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
       "selectControlID": "TextBox3_core",
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
       "labelLText": "被保険者氏名",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "TextBox4",
       "items": [],
       "controlType": "TextBox",
       "width": "120",
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
       "selectControlID": "TextBox4_core",
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
       "labelLText": "電話番号",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "TextBox5",
       "items": [],
       "controlType": "TextBox",
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
       "selectControlID": "TextBox5_core",
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
       "labelLText": "帳票出力順序コード",
       "labelRText": "",
       "labelLWidth": "150",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "TextBoxYubinNo1",
       "items": [],
       "controlType": "TextBoxYubinNo",
       "width": "70",
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
       "selectControlID": "TextBoxYubinNo1_core",
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
       "labelLText": "郵便番号",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "TextBox7",
       "items": [],
       "controlType": "TextBox",
       "width": "350",
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
       "selectControlID": "TextBox7_core",
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
       "labelLText": "住所",
       "labelRText": "",
       "labelLWidth": "35",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "TextBoxKana1",
       "items": [],
       "controlType": "TextBoxKana",
       "width": "350",
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
       "selectControlID": "TextBoxKana1_core",
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
       "labelLText": "カナ",
       "labelRText": "",
       "labelLWidth": "35",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "",
       "kanjiInField": "TextBox1",
       "kanaType": 0
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "KyodoJukyushaIdoRenrakuhyoKihon",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "基本送付情報",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoKihon"
      }
     ],
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "CheckBoxList2",
     "items": [],
     "controlType": "CheckBoxList",
     "width": "200",
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
     "marginRight": "0",
     "selectControlID": "CheckBoxList2_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "key0",
       "value": "償還送付情報を追加する"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 2,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": [],
     "selectedItems": [],
     "minCheckedItem": 0,
     "maxCheckedItem": 2,
     "isAllSelectable": false,
     "isAllSelectableBreakLine": false
    },
    {
     "fieldName": "KyodoJukyushaIdoRenrakuhyoShokan",
     "items": [
      {
       "fieldName": "TextBoxDate5",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "TextBoxDate5_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": true,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelLText": "異動日",
       "labelRText": "",
       "labelLWidth": "55",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "TextBoxNum2",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "60",
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
       "selectControlID": "TextBoxNum2_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
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
       "labelLText": "履歴番号",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": false,
       "decimalPointLength": 0,
       "permitCharactor": "+-,.\\"
      },
      {
       "fieldName": "HorizontalLine3",
       "items": [],
       "controlType": "HorizontalLine",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "HorizontalLine3",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      },
      {
       "fieldName": "TextBoxDateRange1",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "TextBoxDateRange1_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "一時差止日",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "TextBoxDateRange1From",
       "toSelectControlID": "TextBoxDateRange1To"
      },
      {
       "fieldName": "DropDownList7",
       "items": [],
       "controlType": "DropDownList",
       "width": "120",
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
       "selectControlID": "DropDownList7_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "一時差止区分",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "key0",
       "dataSource": [
        {
         "key": "key0",
         "value": "value0"
        },
        {
         "key": "key1",
         "value": "value1"
        }
       ],
       "disabledItem": []
      },
      {
       "fieldName": "TextBoxNum4",
       "items": [],
       "controlType": "TextBoxNum",
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
       "selectControlID": "TextBoxNum4_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
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
       "labelLText": "一時差止金額",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": false,
       "decimalPointLength": 0,
       "permitCharactor": "+-,.\\"
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "KyodoJukyushaIdoRenrakuhyoShokan",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "償還送付情報",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoShokan"
      }
     ],
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "CheckBoxList3",
     "items": [],
     "controlType": "CheckBoxList",
     "width": "200",
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
     "selectControlID": "CheckBoxList3_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "key0",
       "value": "高額送付情報を追加する"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 2,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": [],
     "selectedItems": [],
     "minCheckedItem": 0,
     "maxCheckedItem": 2,
     "isAllSelectable": false,
     "isAllSelectableBreakLine": false
    },
    {
     "fieldName": "KyodoJukyushaIdoRenrakuhyoKogaku",
     "items": [
      {
       "fieldName": "TextBoxDate6",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "TextBoxDate6_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": true,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelLText": "異動日",
       "labelRText": "",
       "labelLWidth": "55",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "TextBoxNum3",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "60",
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
       "selectControlID": "TextBoxNum3_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
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
       "labelLText": "履歴番号",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": false,
       "decimalPointLength": 0,
       "permitCharactor": "+-,.\\"
      },
      {
       "fieldName": "HorizontalLine4",
       "items": [],
       "controlType": "HorizontalLine",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "HorizontalLine4",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      },
      {
       "fieldName": "TextBox6",
       "items": [],
       "controlType": "TextBox",
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
       "selectControlID": "TextBox6_core",
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
       "labelLText": "世帯集約番号",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "DropDownList8",
       "items": [],
       "controlType": "DropDownList",
       "width": "220",
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
       "selectControlID": "DropDownList8_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": true,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "世帯所得区分",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "key0",
       "dataSource": [
        {
         "key": "key0",
         "value": "value0"
        },
        {
         "key": "key1",
         "value": "value1"
        }
       ],
       "disabledItem": []
      },
      {
       "fieldName": "DropDownList9",
       "items": [],
       "controlType": "DropDownList",
       "width": "200",
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
       "selectControlID": "DropDownList9_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": true,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "所得区分",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "key0",
       "dataSource": [
        {
         "key": "key0",
         "value": "value0"
        },
        {
         "key": "key1",
         "value": "value1"
        }
       ],
       "disabledItem": []
      },
      {
       "fieldName": "Panel1",
       "items": [
        {
         "fieldName": "RadioButton1",
         "items": [],
         "controlType": "RadioButton",
         "width": "180",
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
         "selectControlID": "RadioButton1_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": true,
         "onChange": "",
         "labelLText": "老齢福祉年金",
         "labelLWidth": "105",
         "labelLAlign": 2,
         "selectedItem": "key0",
         "dataSource": [
          {
           "key": "key0",
           "value": "受給なし"
          },
          {
           "key": "key1",
           "value": "受給あり"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 2,
         "spaceSize": "S",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "RadioButton2",
         "items": [],
         "controlType": "RadioButton",
         "width": "180",
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
         "selectControlID": "RadioButton2_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "labelLText": "利用者負担第２段階",
         "labelLWidth": "150",
         "labelLAlign": 2,
         "selectedItem": "key0",
         "dataSource": [
          {
           "key": "key0",
           "value": "該当なし"
          },
          {
           "key": "key1",
           "value": "該当あり"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 2,
         "spaceSize": "S",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "RadioButton3",
         "items": [],
         "controlType": "RadioButton",
         "width": "120",
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
         "selectControlID": "RadioButton3_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "labelLText": "支給申請書出力",
         "labelLWidth": "120",
         "labelLAlign": 2,
         "selectedItem": "key0",
         "dataSource": [
          {
           "key": "key0",
           "value": "あり"
          },
          {
           "key": "key1",
           "value": "なし"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 2,
         "spaceSize": "S",
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
       "wrap": true,
       "dependencies": [],
       "float": 0,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "0",
       "marginRight": "0",
       "selectControlID": "Panel1",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "",
       "marginTop": "0",
       "marginBottom": "0",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [],
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
       "canPost": false
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "KyodoJukyushaIdoRenrakuhyoKogaku",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "高額送付情報",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyoKogaku"
      }
     ],
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    }
   ],
   "controlType": "Panel",
   "width": "1110",
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
   "selectControlID": "KyodoJukyushaIdoRenrakuhyo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KyodoJukyushaIdoRenrakuhyo"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": true,
   "backgroundColor": 0,
   "widthAuto": false,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto",
   "focusPositionID": "restoreLayoutButton",
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
 "marginLeft": "0",
 "marginRight": "0",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "businessId": "DBC",
 "controlName": "KyodoJukyushaIdoRenrakuhyo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
   "publicChildProperty": "visible",
   "newPropertyName": "TeiseiInfoVisible"
  },
  {
   "publicChildFieldName": "KyodoJukyushaIdoRenrakuhyoTeisei",
   "publicChildProperty": "displayNone",
   "newPropertyName": "TeiseiInfoDisplayNone"
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

