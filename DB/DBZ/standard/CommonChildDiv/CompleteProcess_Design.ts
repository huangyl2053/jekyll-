/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module CompleteProcess {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "CompleteProcess";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public CompleteProcess() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public CompleteProssessPadding() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("CompleteProssessPadding"));

            }

            public lblCompleteMessage() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblCompleteMessage"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class CompleteProcess_Design extends Uz.CommonChildDiv {
    
        public get lblCompleteMessage_text() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["text"];
        }
        
        public set lblCompleteMessage_text(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[0].items[0]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get CompleteProcess_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
        }
        
        public set CompleteProcess_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, CompleteProcess_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("lblCompleteMessage_text");
            Uz.JSControlUtil.registProperty("CompleteProcess_width");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["lblCompleteMessage_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["CompleteProcess_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "CompleteProcess",
   "items": [
    {
     "fieldName": "CompleteProssessPadding",
     "items": [
      {
       "fieldName": "lblCompleteMessage",
       "items": [],
       "controlType": "Label",
       "width": "900",
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
       "selectControlID": "lblCompleteMessage",
       "required": false,
       "align": 1,
       "text": "処理が完了しました。",
       "isPrivateInfo": false
      }
     ],
     "controlType": "Panel",
     "width": "950",
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
     "selectControlID": "CompleteProssessPadding",
     "onLoad": "",
     "title": "",
     "marginTop": "10",
     "marginBottom": "10",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "CompleteProssessPadding"
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
     "backgroundColor": 4,
     "widthAuto": false,
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false
    }
   ],
   "controlType": "Panel",
   "width": "1100",
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
   "selectControlID": "CompleteProcess",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "CompleteProcess"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
   "backgroundColor": 4,
   "widthAuto": false,
   "panelDisplay": 1,
   "isGroupBox": false,
   "readOnly": false
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
 "marginLeft": 0,
 "marginRight": 0,
 "selectControlID": "defaultLayout",
 "relation": [],
 "businessId": "DBZ",
 "controlName": "CompleteProcess",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "lblCompleteMessage",
   "publicChildProperty": "text",
   "newPropertyName": "lblCompleteMessage_text"
  },
  {
   "publicChildFieldName": "CompleteProcess",
   "publicChildProperty": "width",
   "newPropertyName": "CompleteProcess_width"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

