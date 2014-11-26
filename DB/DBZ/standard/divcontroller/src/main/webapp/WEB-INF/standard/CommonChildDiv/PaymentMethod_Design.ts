/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />


/// <reference path="KozaPayment.ts" />


module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module PaymentMethod {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "PaymentMethod";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public KozaPayment() : DBZ.KozaPayment.ModeController {
                return new DBZ.KozaPayment.ModeController("KozaPayment");
            }


            public PaymentMethod() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public radPayMethod1() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));

            }

            public JuryoininJoho() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JuryoininJoho"));

            }

            public txtJuryoininKeiyakuNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));

            }

            public txtJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));

            }

            public txtJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));

            }

            public txtJigyoshaNameKana() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));

            }

            public radPayMethod2() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));

            }

            public radPayMethod3() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));

            }

            public MadoguchiPayment() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));

            }

            public txtShiharaiBasho() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));

            }

            public txtShiharaiKaishiDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));

            }

            public txtShiharaiKaishiDay() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));

            }

            public txtShiharaiKaishiTime() : UZA.TextBoxTime {

                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));

            }

            public txtShiharaiShuryoDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));

            }

            public txtShiharaiShuryoDay() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));

            }

            public txtShiharaiShuryoTime() : UZA.TextBoxTime {

                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

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
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"];
        }
        
        public set KozaPayment_title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0].items[3]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClick_radPayMethod() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"];
        }
        
        public set onClick_radPayMethod(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[0]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get Juryoinin_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
        }
        
        public set Juryoinin_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[1]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get Madoguchi_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
        }
        
        public set Madoguchi_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[5]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get Koza_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
        }
        
        public set Koza_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[3]["displayNone"] = value;
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
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("KozaPayment_title");
            Uz.JSControlUtil.registProperty("onClick_radPayMethod");
            Uz.JSControlUtil.registProperty("Juryoinin_displayNone");
            Uz.JSControlUtil.registProperty("Madoguchi_displayNone");
            Uz.JSControlUtil.registProperty("Koza_displayNone");
            Uz.JSControlUtil.registProperty("eraseBorder");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["KozaPayment_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["onClick_radPayMethod"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["Juryoinin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Madoguchi_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Koza_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "PaymentMethod",
   "items": [
    {
     "fieldName": "radPayMethod1",
     "items": [],
     "controlType": "RadioButton",
     "width": "150px",
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
     "selectControlID": "radPayMethod1_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "payToJuryoinin",
       "value": "受領委任払い"
      }
     ],
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": "payToJuryoinin",
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": []
    },
    {
     "fieldName": "JuryoininJoho",
     "items": [
      {
       "fieldName": "txtJuryoininKeiyakuNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "80px",
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
       "labelLText": "契約番号",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtJigyoshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "80px",
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
       "labelLText": "事業者",
       "labelRText": "",
       "labelLWidth": "55px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
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
       "marginLeft": "-0.2em",
       "marginRight": "XS",
       "selectControlID": "txtJigyoshaName_core",
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
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
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
       "marginLeft": "20.1em",
       "marginRight": "XS",
       "selectControlID": "txtJigyoshaNameKana_core",
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
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
     "width": "845px",
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
     "selectControlID": "JuryoininJoho",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
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
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "panelDisplay": 2,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "canPost": true,
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false
    },
    {
     "fieldName": "radPayMethod2",
     "items": [],
     "controlType": "RadioButton",
     "width": "150px",
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
     "selectControlID": "radPayMethod2_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "payToKoza",
       "value": "口座払い"
      }
     ],
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": null,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": []
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
     "marginLeft": "XS",
     "marginRight": "0em",
     "selectControlID": "KozaPayment",
     "helpMessageID": "",
     "jpControlName": "",
     "title": "",
     "relation": [],
     "packageName": "",
     "businessId": "DBZ",
     "controlName": "KozaPayment",
     "marginTop": "0em",
     "marginBottom": "0em",
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M",
     "firstFocusFieldName": "",
     "lastFocusFieldName": "",
     "panelDisplay": 2,
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false
    },
    {
     "fieldName": "radPayMethod3",
     "items": [],
     "controlType": "RadioButton",
     "width": "150px",
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
     "selectControlID": "radPayMethod3_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "payToMadoguchi",
       "value": "窓口払い"
      }
     ],
     "onChange": "",
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "selectedItem": null,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "M",
     "disabledItem": [],
     "icon": []
    },
    {
     "fieldName": "MadoguchiPayment",
     "items": [
      {
       "fieldName": "txtShiharaiBasho",
       "items": [],
       "controlType": "TextBox",
       "width": "445px",
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
       "labelLText": "支払場所",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiKaishiDate",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "90px",
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
       "labelLText": "開始日",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtShiharaiKaishiDay",
       "items": [],
       "controlType": "TextBox",
       "width": "30px",
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
       "marginLeft": "-0.5em",
       "marginRight": "XS",
       "selectControlID": "txtShiharaiKaishiDay_core",
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
       "labelLText": "（",
       "labelRText": "）",
       "labelLWidth": "13px",
       "labelRWidth": "13px",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 1,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiKaishiTime",
       "items": [],
       "controlType": "TextBoxTime",
       "width": "50px",
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
       "labelLText": "開始時間",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "displayFormat": 1,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "",
       "timeKubun": 1
      },
      {
       "fieldName": "txtShiharaiShuryoDate",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "90px",
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
       "labelLText": "終了日",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtShiharaiShuryoDay",
       "items": [],
       "controlType": "TextBox",
       "width": "30px",
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
       "marginLeft": "-0.5em",
       "marginRight": "XS",
       "selectControlID": "txtShiharaiShuryoDay_core",
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
       "labelLText": "（",
       "labelRText": "）",
       "labelLWidth": "13px",
       "labelRWidth": "13px",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 1,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": ""
      },
      {
       "fieldName": "txtShiharaiShuryoTime",
       "items": [],
       "controlType": "TextBoxTime",
       "width": "50px",
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
       "labelLText": "終了時間",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "displayFormat": 1,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "",
       "timeKubun": 1
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "MadoguchiPayment",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
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
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "panelDisplay": 2,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "canPost": true,
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false
    }
   ],
   "controlType": "Panel",
   "width": "1040px",
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
   "selectControlID": "PaymentMethod",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "支払方法",
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
   "panelDisplay": 1,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto",
   "canPost": true,
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false
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
 "controlName": "PaymentMethod",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "title",
   "newPropertyName": "title"
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
  },
  {
   "publicChildFieldName": "radPayMethod1",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClick_radPayMethod"
  },
  {
   "publicChildFieldName": "JuryoininJoho",
   "publicChildProperty": "displayNone",
   "newPropertyName": "Juryoinin_displayNone"
  },
  {
   "publicChildFieldName": "MadoguchiPayment",
   "publicChildProperty": "displayNone",
   "newPropertyName": "Madoguchi_displayNone"
  },
  {
   "publicChildFieldName": "KozaPayment",
   "publicChildProperty": "displayNone",
   "newPropertyName": "Koza_displayNone"
  },
  {
   "publicChildFieldName": "PaymentMethod",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "eraseBorder"
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

