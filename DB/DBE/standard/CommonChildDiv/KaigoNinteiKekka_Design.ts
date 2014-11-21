/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module KaigoNinteiKekka {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "KaigoNinteiKekka";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public KaigoNinteiKekka() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtShinseibi() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseibi"));

            }

            public txtShinseiKubunShinsei() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));

            }

            public txtShinseiKubunHorei() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHorei"));

            }

            public txtShinsaJun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinsaJun"));

            }

            public ddlNinteiKubun() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlNinteiKubun"));

            }

            public txtIchijiHanteiKekka() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));

            }

            public ddlTokuteiShippei() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));

            }

            public txtNinteibi() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteibi"));

            }

            public ddlNijiHanteiKekka() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));

            }

            public ddlJotaiZo() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlJotaiZo"));

            }

            public txtNinteiYukoKikanStart() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanStart"));

            }

            public lblKara3() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKara3"));

            }

            public txtNinteiYukoKikanEnd() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanEnd"));

            }

            public ddlNinteiYukoTsukisu() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlNinteiYukoTsukisu"));

            }

            public lblShinsakaiIken() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));

            }

            public btnShinsaIkenTeikei() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnShinsaIkenTeikei"));

            }

            public lblShinsakaiMemo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblShinsakaiMemo"));

            }

            public txtShinsakaiIken() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));

            }

            public txtShinsakaiMemo() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiMemo"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class KaigoNinteiKekka_Design extends Uz.CommonChildDiv {
    
        public get selectDdlNijiHantei() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onChange"];
        }
        
        public set selectDdlNijiHantei(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[8]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get selectDdlNinteiYukoTsukisu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["onChange"];
        }
        
        public set selectDdlNinteiYukoTsukisu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[13]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get selectDdlNinteiKubun() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["onChange"];
        }
        
        public set selectDdlNinteiKubun(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[4]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoNinteiKekka_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("selectDdlNijiHantei");
            Uz.JSControlUtil.registProperty("selectDdlNinteiYukoTsukisu");
            Uz.JSControlUtil.registProperty("selectDdlNinteiKubun");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["selectDdlNijiHantei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiYukoTsukisu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiKubun"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["onChange"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KaigoNinteiKekka",
   "items": [
    {
     "fieldName": "txtShinseibi",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "selectControlID": "txtShinseibi_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "申請日",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtShinseiKubunShinsei",
     "items": [],
     "controlType": "TextBox",
     "width": "65",
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
     "selectControlID": "txtShinseiKubunShinsei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
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
     "suggest": [],
     "value": "",
     "labelLText": "申請区分（申請時）",
     "labelRText": "",
     "labelLWidth": "178",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShinseiKubunHorei",
     "items": [],
     "controlType": "TextBox",
     "width": "65",
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
     "selectControlID": "txtShinseiKubunHorei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
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
     "suggest": [],
     "value": "",
     "labelLText": "申請区分（法令）",
     "labelRText": "",
     "labelLWidth": "138",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShinsaJun",
     "items": [],
     "controlType": "TextBox",
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
     "selectControlID": "txtShinsaJun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 1,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "審査順",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "ddlNinteiKubun",
     "items": [],
     "controlType": "DropDownList",
     "width": "75",
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
     "selectControlID": "ddlNinteiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "dataSource": [
      {
       "key": "01",
       "value": "認定"
      },
      {
       "key": "02",
       "value": "再調査"
      },
      {
       "key": "03",
       "value": "再審査"
      },
      {
       "key": "09",
       "value": "却下"
      },
      {
       "key": "11",
       "value": "区却"
      }
     ],
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "認定区分",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "01"
    },
    {
     "fieldName": "txtIchijiHanteiKekka",
     "items": [],
     "controlType": "TextBox",
     "width": "65",
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
     "selectControlID": "txtIchijiHanteiKekka_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
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
     "suggest": [],
     "value": "",
     "labelLText": "一次判定結果",
     "labelRText": "",
     "labelLWidth": "185",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "ddlTokuteiShippei",
     "items": [],
     "controlType": "DropDownList",
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
     "selectControlID": "ddlTokuteiShippei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "dataSource": [
      {
       "key": "00",
       "value": ""
      },
      {
       "key": "01",
       "value": "筋萎縮性側索硬化症"
      },
      {
       "key": "02",
       "value": "後縦靭帯骨化症"
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "特定疾病",
     "labelRText": "",
     "labelLWidth": "138",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": null
    },
    {
     "fieldName": "txtNinteibi",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "selectControlID": "txtNinteibi_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "required": true,
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "認定日",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "ddlNijiHanteiKekka",
     "items": [],
     "controlType": "DropDownList",
     "width": "85",
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
     "selectControlID": "ddlNijiHanteiKekka_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "dataSource": [
      {
       "key": "01",
       "value": ""
      },
      {
       "key": "12",
       "value": "要支援１"
      },
      {
       "key": "13",
       "value": "要支援２"
      },
      {
       "key": "21",
       "value": "要介護１"
      },
      {
       "key": "22",
       "value": "要介護２"
      },
      {
       "key": "23",
       "value": "要介護３"
      },
      {
       "key": "24",
       "value": "要介護４"
      },
      {
       "key": "25",
       "value": "要介護５"
      },
      {
       "key": "31",
       "value": "非該当"
      }
     ],
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "二次判定結果",
     "labelRText": "",
     "labelLWidth": "178",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "01"
    },
    {
     "fieldName": "ddlJotaiZo",
     "items": [],
     "controlType": "DropDownList",
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
     "selectControlID": "ddlJotaiZo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "dataSource": [
      {
       "key": "00",
       "value": ""
      },
      {
       "key": "01",
       "value": "01:認知機能の低下等"
      },
      {
       "key": "02",
       "value": "02:不安定な状態"
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "状態像例",
     "labelRText": "",
     "labelLWidth": "120",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": null
    },
    {
     "fieldName": "txtNinteiYukoKikanStart",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "selectControlID": "txtNinteiYukoKikanStart_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "required": false,
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "認定期間",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "lblKara3",
     "items": [],
     "controlType": "Label",
     "width": "20",
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
     "selectControlID": "lblKara3",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "～",
     "required": false,
     "isPrivateInfo": false,
     "decorationClass": "",
     "align": 1
    },
    {
     "fieldName": "txtNinteiYukoKikanEnd",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": true,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtNinteiYukoKikanEnd_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "text": "",
     "required": false,
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
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
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "ddlNinteiYukoTsukisu",
     "items": [],
     "controlType": "DropDownList",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "ddlNinteiYukoTsukisu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "dataSource": [
      {
       "key": "00",
       "value": ""
      },
      {
       "key": "24",
       "value": "２４"
      },
      {
       "key": "12",
       "value": "１２"
      },
      {
       "key": "06",
       "value": "６"
      },
      {
       "key": "01",
       "value": "１"
      }
     ],
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "ヶ月",
     "labelLWidth": "2",
     "labelRWidth": "40",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": null
    },
    {
     "fieldName": "lblShinsakaiIken",
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
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "S",
     "marginRight": "14",
     "selectControlID": "lblShinsakaiIken",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "■審査会意見",
     "required": false,
     "isPrivateInfo": false,
     "decorationClass": "",
     "align": 2
    },
    {
     "fieldName": "btnShinsaIkenTeikei",
     "items": [],
     "controlType": "ButtonDialog",
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
     "selectControlID": "btnShinsaIkenTeikei",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "定型文",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "lblShinsakaiMemo",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "marginLeft": "4",
     "marginRight": "14",
     "selectControlID": "lblShinsakaiMemo",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "■審査会メモ",
     "required": false,
     "isPrivateInfo": false,
     "decorationClass": "",
     "align": 2
    },
    {
     "fieldName": "txtShinsakaiIken",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "415",
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
     "marginLeft": "1.8",
     "marginRight": "XS",
     "selectControlID": "txtShinsakaiIken_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "40",
     "text": "",
     "required": false,
     "maxLength": "200",
     "minLength": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "limitLength": "200",
     "countDisp": false
    },
    {
     "fieldName": "txtShinsakaiMemo",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "415",
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
     "marginLeft": "1.6",
     "marginRight": "XS",
     "selectControlID": "txtShinsakaiMemo_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "40",
     "text": "",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "limitLength": "200",
     "countDisp": false
    }
   ],
   "controlType": "Panel",
   "width": "1004",
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
   "selectControlID": "KaigoNinteiKekka",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "認定結果",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "NinteiKekkaNyuryoku"
    }
   ],
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
   "eraseBorder": false,
   "backgroundColor": 0,
   "widthAuto": false,
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
 "businessId": "DBE",
 "controlName": "KaigoNinteiKekka",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "ddlNijiHanteiKekka",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNijiHantei"
  },
  {
   "publicChildFieldName": "ddlNinteiYukoTsukisu",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNinteiYukoTsukisu"
  },
  {
   "publicChildFieldName": "ddlNinteiKubun",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNinteiKubun"
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

