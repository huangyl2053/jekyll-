/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KaigoShikakuKihonクラスのみで継承して使えます。
     */
    export class KaigoShikakuKihon_Design extends Uz.CommonChildDiv {
    
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
        
        public get canOpenAndClose() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"];
        }
        
        public set canOpenAndClose(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"] = value;
            } else {
                this.layout.items[0]["canOpenAndClose"] = value;
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
        
        public get backGroundColor() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["backgroundColor"];
        }
        
        public set backGroundColor(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["backgroundColor"] = value;
            } else {
                this.layout.items[0]["backgroundColor"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnHihoRireki_visible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"];
        }
        
        public set btnHihoRireki_visible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[6]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnNinteiRireki_visible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"];
        }
        
        public set btnNinteiRireki_visible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[12]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoShikakuKihon_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("canOpenAndClose");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("backGroundColor");
            Uz.JSControlUtil.registProperty("btnHihoRireki_visible");
            Uz.JSControlUtil.registProperty("btnNinteiRireki_visible");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["backGroundColor"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["backgroundColor"];
            editablePropertyInfo["btnHihoRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["btnNinteiRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["visible"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KaigoShikakuKihon",
   "items": [
    {
     "fieldName": "txtHihokenshaNo",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtHihokenshaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "10",
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
     "labelLText": "被保番号",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShutokuYmd",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtShutokuYmd_core",
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
     "labelLText": "資格取得",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtShutokuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtShutokuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "5",
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
     "labelLText": "取得事由",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtJutokuTekiyo",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtJutokuTekiyo_core",
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
     "labelLText": "住特開始",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtYokaigoJotaiKubun",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtYokaigoJotaiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "6",
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
     "labelLText": "要介護状態",
     "labelRText": "",
     "labelLWidth": "89",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtKyuSochiNyusho",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtKyuSochiNyusho_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "1",
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
     "labelLText": "旧措置入所",
     "labelRText": "",
     "labelLWidth": "112",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "btnHihoRireki",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "74",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "0",
     "marginRight": "0.8",
     "selectControlID": "btnHihoRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "被保履歴",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "txtShikakuJotai",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtShikakuJotai_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "5",
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
     "labelLText": "資格状態",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtSoshitsuYmd",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtSoshitsuYmd_core",
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
     "labelLText": "資格喪失",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtSoshitsuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtSoshitsuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "5",
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
     "labelLText": "喪失事由",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtJutokuKaijo",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtJutokuKaijo_core",
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
     "labelLText": "住特終了",
     "labelRText": "",
     "labelLWidth": "74",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtNinteiKikan",
     "items": [],
     "controlType": "TextBoxDateRange",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "txtNinteiKikan_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "認定期間",
     "labelRText": "",
     "labelLWidth": "89",
     "labelRWidth": "0",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "",
     "fromPlaceHolder": "",
     "toPlaceHolder": "",
     "isHolizontal": false,
     "minDate": "",
     "maxDate": "",
     "fromText": "",
     "toText": "",
     "fromValue": "",
     "toValue": "",
     "fromSelectControlID": "txtNinteiKikanFrom",
     "toSelectControlID": "txtNinteiKikanTo"
    },
    {
     "fieldName": "btnNinteiRireki",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "74",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "0",
     "marginRight": "0.8",
     "selectControlID": "btnNinteiRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "認定履歴",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
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
   "selectControlID": "KaigoShikakuKihon",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KaigoShikakuKihon"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": true,
   "eraseBorderBottom": true,
   "eraseBorderRight": true,
   "eraseBorderLeft": true,
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
 "businessId": "DBZ",
 "controlName": "KaigoShikakuKihon",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "canOpenAndClose",
   "newPropertyName": "canOpenAndClose"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "eraseBorderTop",
   "newPropertyName": "eraseBorderTop"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "eraseBorderBottom",
   "newPropertyName": "eraseBorderBottom"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "eraseBorderRight",
   "newPropertyName": "eraseBorderRight"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "eraseBorderLeft",
   "newPropertyName": "eraseBorderLeft"
  },
  {
   "publicChildFieldName": "KaigoShikakuKihon",
   "publicChildProperty": "backgroundColor",
   "newPropertyName": "backGroundColor"
  },
  {
   "publicChildFieldName": "btnHihoRireki",
   "publicChildProperty": "visible",
   "newPropertyName": "btnHihoRireki_visible"
  },
  {
   "publicChildFieldName": "btnNinteiRireki",
   "publicChildProperty": "visible",
   "newPropertyName": "btnNinteiRireki_visible"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

