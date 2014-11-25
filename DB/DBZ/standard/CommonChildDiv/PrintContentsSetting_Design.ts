/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * PrintContentsSettingクラスのみで継承して使えます。
     */
    export class PrintContentsSetting_Design extends Uz.CommonChildDiv {
    
        public get txtSendData_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
        }
        
        public set txtSendData_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[1]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get PrintContentsSetting_title() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"];
        }
        
        public set PrintContentsSetting_title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get PrintContentsSetting_eraseBorder() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
        }
        
        public set PrintContentsSetting_eraseBorder(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
            } else {
                this.layout.items[0]["eraseBorder"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, PrintContentsSetting_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("txtSendData_displayNone");
            Uz.JSControlUtil.registProperty("PrintContentsSetting_title");
            Uz.JSControlUtil.registProperty("PrintContentsSetting_eraseBorder");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["txtSendData_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["PrintContentsSetting_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["PrintContentsSetting_eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "PrintContentsSetting",
   "items": [
    {
     "fieldName": "txtIssueDate",
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
     "selectControlID": "txtIssueDate_core",
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
     "labelLText": "発行日",
     "labelRText": "",
     "labelLWidth": "55px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtSendDate",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "85px",
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
     "marginLeft": "XL",
     "marginRight": "XS",
     "selectControlID": "txtSendDate_core",
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
     "labelLText": "送付日",
     "labelRText": "",
     "labelLWidth": "55px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    }
   ],
   "controlType": "Panel",
   "width": "G2",
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
   "selectControlID": "PrintContentsSetting",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "印字内容設定",
   "marginTop": "Default",
   "marginBottom": "Default",
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
 "controlName": "PrintContentsSetting",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "txtSendDate",
   "publicChildProperty": "displayNone",
   "newPropertyName": "txtSendData_displayNone"
  },
  {
   "publicChildFieldName": "PrintContentsSetting",
   "publicChildProperty": "title",
   "newPropertyName": "PrintContentsSetting_title"
  },
  {
   "publicChildFieldName": "PrintContentsSetting",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "PrintContentsSetting_eraseBorder"
  }
 ],
 "dataPassingForDialog": [
  {
   "key": "",
   "controlName": ""
  }
 ],
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

     export module PrintContentsSetting {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "PrintContentsSetting";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType() + "_" + fieldName;
            }

            public PrintContentsSetting(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtIssueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIssueDate"));
            }

            public txtSendDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSendDate"));
            }

        }

     }

}

