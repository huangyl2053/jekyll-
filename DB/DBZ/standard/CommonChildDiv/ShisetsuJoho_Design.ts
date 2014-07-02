/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShisetsuJohoクラスのみで継承して使えます。
     */
    export class ShisetsuJoho_Design extends Uz.CommonChildDiv {
    
        public get btnJigyoshaInputGuide_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
        }
        
        public set btnJigyoshaInputGuide_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[3]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnOtherTokureiShisetsuInputGuide_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"];
        }
        
        public set btnOtherTokureiShisetsuInputGuide_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[4]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnJogaiShisetsuInputGuide_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
        }
        
        public set btnJogaiShisetsuInputGuide_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[5]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get radShisetsuShurui_displayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"];
        }
        
        public set radShisetsuShurui_displayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShisetsuJoho_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
        }
        
        public set ShisetsuJoho_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShisetsuJoho_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("btnOtherTokureiShisetsuInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("btnJogaiShisetsuInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("radShisetsuShurui_displayNone");
            Uz.JSControlUtil.registProperty("ShisetsuJoho_width");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["btnJigyoshaInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnOtherTokureiShisetsuInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnJogaiShisetsuInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["radShisetsuShurui_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["ShisetsuJoho_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShisetsuJoho",
   "items": [
    {
     "fieldName": "radShisetsuShurui",
     "items": [],
     "controlType": "RadioButton",
     "width": "420",
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
     "selectControlID": "radShisetsuShurui_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "onChange_radShisetsuShurui",
     "selectedItem": null,
     "dataSource": [
      {
       "key": "kaigoHokenShisetsu",
       "value": "介護保険施設"
      },
      {
       "key": "other",
       "value": "その他特例施設"
      }
     ],
     "required": false,
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "onClick": "",
     "icon": [],
     "newLineItemNumber": 3,
     "spaceSize": "M",
     "disabledItem": []
    },
    {
     "fieldName": "lblOtherShisetsuShurui",
     "items": [],
     "controlType": "Label",
     "width": "60",
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
     "selectControlID": "lblOtherShisetsuShurui",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "text": "kannai",
     "isPrivateInfo": false,
     "decorationClass": "",
     "align": 1
    },
    {
     "fieldName": "txtShisetsuCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "90",
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
     "selectControlID": "txtShisetsuCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "required": false,
     "labelLText": "入所施設",
     "labelRText": "",
     "labelLWidth": "70",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "onBlur_txtShisetsuCode",
     "text": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "btnJigyoshaInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
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
     "selectControlID": "btnJigyoshaInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.JigyoshaInputGuide",
     "dataPassing": [
      {
       "key": "jigyoshaCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "jigyoshaMeisho",
       "controlName": "txtShisetsuMeisho"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnOtherTokureiShisetsuInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
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
     "selectControlID": "btnOtherTokureiShisetsuInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "■",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "20",
     "imageHeight": "15",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.OtherTokureiShisetsuInputGuide",
     "dataPassing": [
      {
       "key": "otherShisetsuCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "otherShisetsuMeisho",
       "controlName": "txtShisetsuMeisho"
      },
      {
       "key": "selectRadioButtonKey",
       "controlName": "lblOtherShisetsuShurui"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "btnJogaiShisetsuInputGuide",
     "items": [],
     "controlType": "ButtonDialog",
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
     "selectControlID": "btnJogaiShisetsuInputGuide",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "■",
     "appearance": 2,
     "imageFileUrl": "/uz/uza/image/UZ_Search.png",
     "imageWidth": "20",
     "imageHeight": "15",
     "icon": 0,
     "heightTextBoxMatches": true,
     "displayChildDivName": "DBZ.TekiyoJogaiShisetsuInputGuide",
     "dataPassing": [
      {
       "key": "shisetsuCode",
       "controlName": "txtShisetsuCode"
      },
      {
       "key": "shisetsuMeisho",
       "controlName": "txtShisetsuMeisho"
      }
     ],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "txtShisetsuMeisho",
     "items": [],
     "controlType": "TextBox",
     "width": "450",
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
     "selectControlID": "txtShisetsuMeisho_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "onChange": "",
     "required": false,
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "text": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "decorationClass": "",
     "permitCharactor": ""
    }
   ],
   "controlType": "Panel",
   "width": "800",
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
   "selectControlID": "ShisetsuJoho",
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
     "postParameterPanelNames": "ShisetsuJoho"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onChange_radShisetsuShurui",
     "requestUrl": "dbz/db/dbz/ShisetsuJoho/onChange_radShisetsuShurui"
    },
    {
     "eventName": "onBlur_txtShisetsuCode",
     "requestUrl": "dbz/db/dbz/ShisetsuJoho/onBlur_txtShisetsuCode"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "selectRow",
     "value": ""
    },
    {
     "propertyName": "inputMode",
     "value": ""
    }
   ],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": true,
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
 "controlName": "ShisetsuJoho",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnJigyoshaInputGuide",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnJigyoshaInputGuide_displayNone"
  },
  {
   "publicChildFieldName": "btnOtherTokureiShisetsuInputGuide",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnOtherTokureiShisetsuInputGuide_displayNone"
  },
  {
   "publicChildFieldName": "btnJogaiShisetsuInputGuide",
   "publicChildProperty": "displayNone",
   "newPropertyName": "btnJogaiShisetsuInputGuide_displayNone"
  },
  {
   "publicChildFieldName": "radShisetsuShurui",
   "publicChildProperty": "displayNone",
   "newPropertyName": "radShisetsuShurui_displayNone"
  },
  {
   "publicChildFieldName": "ShisetsuJoho",
   "publicChildProperty": "width",
   "newPropertyName": "ShisetsuJoho_width"
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

