/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShinseishaInfoクラスのみで継承して使えます。
     */
    export class ShinseishaInfo_Design extends Uz.CommonChildDiv {
    
        public get btnSearch_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"];
        }
        
        public set btnSearch_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[4]["displayNone"] = value;
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
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["disabled"];
        }
        
        public set txtJigyoshaNo_disabled(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["disabled"] = value;
            } else {
                this.layout.items[0].items[3]["disabled"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtShinseishaName_labelLText() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["labelLText"];
        }
        
        public set txtShinseishaName_labelLText(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[7]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtYubinNo_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["displayNone"];
        }
        
        public set txtYubinNo_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[10]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtAddress_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"];
        }
        
        public set txtAddress_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[11]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnCopy_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
        }
        
        public set btnCopy_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[5]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnSearchJigyosha_disabled() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"];
        }
        
        public set btnSearchJigyosha_disabled(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"] = value;
            } else {
                this.layout.items[0].items[4]["disabled"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnCopyToHonninInfo_disabled() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"];
        }
        
        public set btnCopyToHonninInfo_disabled(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"] = value;
            } else {
                this.layout.items[0].items[5]["disabled"] = value;
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
            Uz.JSControlUtil.registProperty("btnSearch_displayNone");
            Uz.JSControlUtil.registProperty("txtUkestukeDate_displayNone");
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("txtJigyoshaNo_disabled");
            Uz.JSControlUtil.registProperty("txtShinseishaName_labelLText");
            Uz.JSControlUtil.registProperty("txtYubinNo_displayNone");
            Uz.JSControlUtil.registProperty("txtAddress_displayNone");
            Uz.JSControlUtil.registProperty("btnCopy_displayNone");
            Uz.JSControlUtil.registProperty("btnSearchJigyosha_disabled");
            Uz.JSControlUtil.registProperty("btnCopyToHonninInfo_disabled");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["btnSearch_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtUkestukeDate_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["txtJigyoshaNo_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["txtShinseishaName_labelLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["txtYubinNo_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtAddress_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnCopy_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnSearchJigyosha_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["btnCopyToHonninInfo_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["disabled"];
            
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
     "selectControlID": "txtShinseiDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "申請日",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "isPassword": false,
     "text": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "ddlShinseishaKubun",
     "items": [],
     "controlType": "DropDownList",
     "width": "150",
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
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "申請者区分",
     "labelRText": "",
     "labelLWidth": "90",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "myself"
    },
    {
     "fieldName": "txtUketsukeDate",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "90",
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
     "marginLeft": "2.3",
     "marginRight": "XS",
     "selectControlID": "txtUketsukeDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "受付日",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "isPassword": false,
     "text": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtJigyoshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "85",
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
     "maxLength": 100000000,
     "minLength": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "事業者",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "btnSearchJigyosha",
     "items": [],
     "controlType": "Button",
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
     "selectControlID": "btnSearchJigyosha",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "Button1",
     "onClick": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "btnCopyToHonninInfo",
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
     "marginRight": "0",
     "selectControlID": "btnCopyToHonninInfo",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "本人情報をコピーする",
     "onClick": "onClick_btnCopyToHonninInfo",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "ddlHokensha",
     "items": [],
     "controlType": "DropDownList",
     "width": "120",
     "visible": true,
     "displayNone": true,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
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
     "labelLWidth": "48",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "key0"
    },
    {
     "fieldName": "txtShinseishaNameKana",
     "items": [],
     "controlType": "TextBox",
     "width": "355",
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
     "labelLText": "氏名",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShinseishaName",
     "items": [],
     "controlType": "TextBox",
     "width": "355",
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
     "marginLeft": "3.9",
     "marginRight": "XS",
     "selectControlID": "txtShinseishaName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLWidth": "80",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
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
     "marginLeft": "0.3",
     "marginRight": "XS",
     "selectControlID": "txtTelNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "labelLText": "電話番号",
     "labelRText": "",
     "labelLWidth": "70",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtYubinNo",
     "items": [],
     "controlType": "TextBoxYubinNo",
     "width": "S",
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
     "maxLength": 100000000,
     "minLength": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "value": "",
     "labelLText": "住所",
     "labelRText": "",
     "labelLWidth": "55",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtAddress",
     "items": [],
     "controlType": "TextBox",
     "width": "435",
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
     "selectControlID": "txtAddress_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
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
     "textAlign": 0,
     "isPassword": false,
     "isComboBox": false,
     "text": "",
     "suggest": [],
     "decorationClass": "",
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "637",
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
   "selectControlID": "ShinseishaInfo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "申請者情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "YoguKonyuhiShikyuShinseishaJoho"
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
   "panelDisplay": 1,
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
 "businessId": "DBZ",
 "controlName": "ShinseishaInfo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnSearchJigyosha",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnSearch_displayNone"
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
   "publicChildFieldName": "btnCopyToHonninInfo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnCopy_displayNone"
  },
  {
   "publicChildFieldName": "btnSearchJigyosha",
   "publicChildProperty": "disabled",
   "newPropertyName": "btnSearchJigyosha_disabled"
  },
  {
   "publicChildFieldName": "btnCopyToHonninInfo",
   "publicChildProperty": "disabled",
   "newPropertyName": "btnCopyToHonninInfo_disabled"
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

