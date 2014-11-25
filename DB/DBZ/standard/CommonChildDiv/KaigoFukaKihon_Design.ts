/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KaigoFukaKihonクラスのみで継承して使えます。
     */
    export class KaigoFukaKihon_Design extends Uz.CommonChildDiv {
    
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
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"];
        }
        
        public set btnHihoRireki_visible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[7]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoFukaKihon_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("canOpenAndClose");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("backGroundColor");
            Uz.JSControlUtil.registProperty("btnHihoRireki_visible");
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
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["backGroundColor"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["backgroundColor"];
            editablePropertyInfo["btnHihoRireki_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["visible"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KaigoFukaKihon",
   "items": [
    {
     "fieldName": "txtTsuchishoNo",
     "items": [],
     "controlType": "TextBox",
     "width": "130px",
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
     "marginLeft": "0em",
     "marginRight": "0em",
     "selectControlID": "txtTsuchishoNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": "16",
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
     "labelLText": "通知書番号",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtHihokenshaNo",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0em",
     "marginRight": "0em",
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
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtHokenryoDankai",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0em",
     "marginRight": "0em",
     "selectControlID": "txtHokenryoDankai_core",
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
     "labelLText": "保険料段階",
     "labelRText": "",
     "labelLWidth": "85px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShutokuYmd",
     "items": [],
     "controlType": "TextBoxDate",
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
     "marginLeft": "0em",
     "marginRight": "0em",
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
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtShutokuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0.1em",
     "marginRight": "0em",
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
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "74px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtSoshitsuYmd",
     "items": [],
     "controlType": "TextBoxDate",
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
     "marginLeft": "0em",
     "marginRight": "0em",
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
     "labelLWidth": "70px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtSoshitsuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0.1em",
     "marginRight": "0em",
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
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "74px",
     "labelRWidth": "0px",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "btnHihoRireki",
     "items": [],
     "controlType": "ButtonDialog",
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
     "marginLeft": "0.7em",
     "marginRight": "0em",
     "selectControlID": "btnHihoRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "被保履歴",
     "imageWidth": "",
     "imageHeight": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    }
   ],
   "controlType": "Panel",
   "width": "1105px",
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
   "marginLeft": "0em",
   "marginRight": "0em",
   "selectControlID": "KaigoFukaKihon",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "0em",
   "marginBottom": "0em",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KaigoFukaKihon"
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
 "controlName": "KaigoFukaKihon",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "KaigoFukaKihon",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "KaigoFukaKihon",
   "publicChildProperty": "canOpenAndClose",
   "newPropertyName": "canOpenAndClose"
  },
  {
   "publicChildFieldName": "KaigoFukaKihon",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "eraseBorder"
  },
  {
   "publicChildFieldName": "KaigoFukaKihon",
   "publicChildProperty": "backgroundColor",
   "newPropertyName": "backGroundColor"
  },
  {
   "publicChildFieldName": "btnHihoRireki",
   "publicChildProperty": "visible",
   "newPropertyName": "btnHihoRireki_visible"
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

     export module KaigoFukaKihon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoFukaKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            }

            public KaigoFukaKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTsuchishoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtHokenryoDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
            }

            public txtShutokuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            }

            public txtShutokuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            }

            public txtSoshitsuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            }

            public txtSoshitsuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            }

            public btnHihoRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            }

        }

     }

}

