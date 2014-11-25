/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module ShinseishaInfo {

        export class Events {

            public static get onChange_ddlShinseishaKubun(): string {
                return "onChange_ddlShinseishaKubun";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "ShinseishaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public ShinseishaInfo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtShinseiDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));

            }

            public ddlShinseishaKubun() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));

            }

            public txtUketsukeDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));

            }

            public txtShinseiRiyu() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));

            }

            public txtJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));

            }

            public btnJigyoshaInputGuide() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));

            }

            public btnHonninJohoCopy() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));

            }

            public ddlHokensha() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));

            }

            public txtShinseishaNameKana() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));

            }

            public txtShinseishaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));

            }

            public txtTelNo() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtTelNo"));

            }

            public txtYubinNo() : UZA.TextBoxYubinNo {

                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));

            }

            public txtAddress() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtAddress"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class ShinseishaInfo_Design extends Uz.CommonChildDiv {
    
        public get btnJigyoshaInputGuide_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
        }
        
        public set btnJigyoshaInputGuide_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[5]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtUkestukeDate_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"];
        }
        
        public set txtUkestukeDate_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[2]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
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
        
        public get txtJigyoshaNo_disabled() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"];
        }
        
        public set txtJigyoshaNo_disabled(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"] = value;
            } else {
                this.layout.items[0].items[4]["disabled"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtShinseishaName_labelLText() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["labelLText"];
        }
        
        public set txtShinseishaName_labelLText(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[8]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtYubinNo_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"];
        }
        
        public set txtYubinNo_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[11]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtAddress_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"];
        }
        
        public set txtAddress_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[12]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnJigyoshaInputGuide_disabled() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"];
        }
        
        public set btnJigyoshaInputGuide_disabled(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"] = value;
            } else {
                this.layout.items[0].items[5]["disabled"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get shinseishaInfo_eraseBorder() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
        }
        
        public set shinseishaInfo_eraseBorder(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
            } else {
                this.layout.items[0]["eraseBorder"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShinseishaInfo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("txtUkestukeDate_displayNone");
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("txtJigyoshaNo_disabled");
            Uz.JSControlUtil.registProperty("txtShinseishaName_labelLText");
            Uz.JSControlUtil.registProperty("txtYubinNo_displayNone");
            Uz.JSControlUtil.registProperty("txtAddress_displayNone");
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_disabled");
            Uz.JSControlUtil.registProperty("shinseishaInfo_eraseBorder");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["btnJigyoshaInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtUkestukeDate_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["txtJigyoshaNo_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["txtShinseishaName_labelLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["txtYubinNo_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtAddress_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnJigyoshaInputGuide_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["shinseishaInfo_eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShinseishaInfo",
   "items": [
    {
     "fieldName": "txtShinseiDate",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "selectControlID": "txtShinseiDate_core",
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
     "labelLText": "申請日",
     "labelRText": "",
     "labelLWidth": "65px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "decorationClass": "",
     "textKind": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "ddlShinseishaKubun",
     "items": [],
     "controlType": "DropDownList",
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
     "marginLeft": "0em",
     "marginRight": "XS",
     "selectControlID": "ddlShinseishaKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "myself",
       "value": "本人"
      },
      {
       "key": "family",
       "value": "家族"
      },
      {
       "key": "serviceJigyosha",
       "value": "サービス事業者"
      },
      {
       "key": "other",
       "value": "その他"
      },
      {
       "key": "blank",
       "value": ""
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "onChange_ddlShinseishaKubun",
     "labelLText": "申請者区分",
     "labelRText": "",
     "labelLWidth": "90px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "myself",
     "isBlankLine": false,
     "disabledItem": []
    },
    {
     "fieldName": "txtUketsukeDate",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "90px",
     "visible": true,
     "displayNone": true,
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
     "selectControlID": "txtUketsukeDate_core",
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
     "labelLText": "受付日",
     "labelRText": "",
     "labelLWidth": "55px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "decorationClass": "",
     "textKind": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtShinseiRiyu",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "560px",
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
     "selectControlID": "txtShinseiRiyu_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "S",
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "申請理由",
     "labelRText": "",
     "labelLWidth": "65px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textKind": 0,
     "limitLength": "200",
     "countDisp": true
    },
    {
     "fieldName": "txtJigyoshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "85px",
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
     "labelLWidth": "65px",
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
     "fieldName": "btnJigyoshaInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "S",
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
     "selectControlID": "btnJigyoshaInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "ButtonDialog1",
     "onClick": "",
     "icon": 0,
     "onBeforeClick": "",
     "onAfterClick": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "",
     "imageHeight": "",
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.JigyoshaInputGuide",
     "dataPassing": [
      {
       "key": "jigyoshaCode",
       "controlName": "txtJigyoshaNo"
      },
      {
       "key": "jigyoshaMeisho",
       "controlName": "txtShinseishaName"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnHonninJohoCopy",
     "items": [],
     "controlType": "Button",
     "width": "200px",
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
     "selectControlID": "btnHonninJohoCopy",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "本人情報をコピーする",
     "onClick": "",
     "icon": 0,
     "onBeforeClick": "",
     "onAfterClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "ddlHokensha",
     "items": [],
     "controlType": "DropDownList",
     "width": "120px",
     "visible": true,
     "displayNone": true,
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
     "selectControlID": "ddlHokensha_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "保険者",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "key0",
     "isBlankLine": false,
     "disabledItem": []
    },
    {
     "fieldName": "txtShinseishaNameKana",
     "items": [],
     "controlType": "TextBox",
     "width": "355px",
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
     "selectControlID": "txtShinseishaNameKana_core",
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
     "labelLText": "氏名",
     "labelRText": "",
     "labelLWidth": "65px",
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
     "fieldName": "txtShinseishaName",
     "items": [],
     "controlType": "TextBox",
     "width": "355px",
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
     "marginLeft": "73px",
     "marginRight": "XS",
     "selectControlID": "txtShinseishaName_core",
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
     "labelLWidth": "80px",
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
     "fieldName": "txtTelNo",
     "items": [],
     "controlType": "TextBox",
     "width": "S",
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
     "marginLeft": "0.3em",
     "marginRight": "XS",
     "selectControlID": "txtTelNo_core",
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
     "labelLText": "電話番号",
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
     "fieldName": "txtYubinNo",
     "items": [],
     "controlType": "TextBoxYubinNo",
     "width": "65px",
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
     "selectControlID": "txtYubinNo_core",
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
     "labelLText": "住所",
     "labelRText": "",
     "labelLWidth": "65px",
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
     "permitCharactor": ""
    },
    {
     "fieldName": "txtAddress",
     "items": [],
     "controlType": "TextBox",
     "width": "481px",
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
     "selectControlID": "txtAddress_core",
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
   "width": "645px",
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
   "selectControlID": "ShinseishaInfo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "申請者情報",
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
 "controlName": "ShinseishaInfo",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "btnJigyoshaInputGuide",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnJigyoshaInputGuide_displayNone"
  },
  {
   "publicChildFieldName": "txtUketsukeDate",
   "publicChildProperty": "displayNone",
   "newPropertyName": "txtUkestukeDate_displayNone"
  },
  {
   "publicChildFieldName": "ShinseishaInfo",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "ShinseishaInfo",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "panelDisplay"
  },
  {
   "publicChildFieldName": "txtJigyoshaNo",
   "publicChildProperty": "disabled",
   "newPropertyName": "txtJigyoshaNo_disabled"
  },
  {
   "publicChildFieldName": "txtShinseishaNameKana",
   "publicChildProperty": "labelLText",
   "newPropertyName": "txtShinseishaName_labelLText"
  },
  {
   "publicChildFieldName": "txtYubinNo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "txtYubinNo_displayNone"
  },
  {
   "publicChildFieldName": "txtAddress",
   "publicChildProperty": "displayNone",
   "newPropertyName": "txtAddress_displayNone"
  },
  {
   "publicChildFieldName": "btnJigyoshaInputGuide",
   "publicChildProperty": "disabled",
   "newPropertyName": "btnJigyoshaInputGuide_disabled"
  },
  {
   "publicChildFieldName": "ShinseishaInfo",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "shinseishaInfo_eraseBorder"
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

