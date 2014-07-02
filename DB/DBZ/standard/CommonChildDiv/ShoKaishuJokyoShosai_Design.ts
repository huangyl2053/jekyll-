/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShoKaishuJokyoShosaiクラスのみで継承して使えます。
     */
    export class ShoKaishuJokyoShosai_Design extends Uz.CommonChildDiv {
    
        public get onBlur_txtKaishuDate() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onBlur"];
        }
        
        public set onBlur_txtKaishuDate(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onBlur"] = value;
            } else {
                this.layout.items[0].items[5]["onBlur"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onChange_ddlKaishuJiyu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["onChange"];
        }
        
        public set onChange_ddlKaishuJiyu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[6]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onBlur_txtKaishuRiyu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onBlur"];
        }
        
        public set onBlur_txtKaishuRiyu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onBlur"] = value;
            } else {
                this.layout.items[0].items[7]["onBlur"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShoKaishuJokyoShosai_panelDisplay() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
        }
        
        public set ShoKaishuJokyoShosai_panelDisplay(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
            } else {
                this.layout.items[0]["panelDisplay"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShoKaishuJokyoShosai_canOpenAndClose() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"];
        }
        
        public set ShoKaishuJokyoShosai_canOpenAndClose(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"] = value;
            } else {
                this.layout.items[0]["canOpenAndClose"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShoKaishuJokyoShosai_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuDate");
            Uz.JSControlUtil.registProperty("onChange_ddlKaishuJiyu");
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuRiyu");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_panelDisplay");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_canOpenAndClose");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onBlur_txtKaishuDate"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["onBlur"];
            editablePropertyInfo["onChange_ddlKaishuJiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["onBlur_txtKaishuRiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["onBlur"];
            editablePropertyInfo["ShoKaishuJokyoShosai_panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["ShoKaishuJokyoShosai_canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShoKaishuJokyoShosai",
   "items": [
    {
     "fieldName": "txtShoKofuShurui",
     "items": [],
     "controlType": "TextBox",
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
     "selectControlID": "txtShoKofuShurui_core",
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
     "labelLText": "交付証種類",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtKofuDate",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "selectControlID": "txtKofuDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "交付日",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtYukoKigen",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "90",
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
     "selectControlID": "txtYukoKigen_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "有効期限",
     "labelRText": "",
     "labelLWidth": "70",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "txtKofuJiyu",
     "items": [],
     "controlType": "TextBox",
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
     "marginRight": "XS",
     "selectControlID": "txtKofuJiyu_core",
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
     "labelLText": "交付事由",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtKofuRiyu",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "800",
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
     "selectControlID": "txtKofuRiyu_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "height": "40",
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
     "text": "",
     "value": "",
     "labelLText": "交付理由",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "limitLength": "200",
     "countDisp": false
    },
    {
     "fieldName": "txtKaishuDate",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "selectControlID": "txtKaishuDate_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "回収日",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "ddlKaishuJiyu",
     "items": [],
     "controlType": "DropDownList",
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
     "marginRight": "XS",
     "selectControlID": "ddlKaishuJiyu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "dataSource": [
      {
       "key": "",
       "value": ""
      },
      {
       "key": "00",
       "value": "転出"
      },
      {
       "key": "01",
       "value": "受給者転入"
      },
      {
       "key": "02",
       "value": "死亡"
      },
      {
       "key": "03",
       "value": "紛失等"
      },
      {
       "key": "04",
       "value": "汚損等"
      },
      {
       "key": "05",
       "value": "証記載内容変更"
      },
      {
       "key": "06",
       "value": "居宅サービス計画届出"
      },
      {
       "key": "07",
       "value": "医療保険脱退"
      },
      {
       "key": "08",
       "value": "適用除外施設入所"
      },
      {
       "key": "09",
       "value": "住所地特例適用"
      },
      {
       "key": "10",
       "value": "住所地特例変更"
      },
      {
       "key": "11",
       "value": "住所地特例解除"
      },
      {
       "key": "12",
       "value": "住所地特例終了"
      },
      {
       "key": "13",
       "value": "支払方法変更"
      },
      {
       "key": "14",
       "value": "支払方法変更終了"
      },
      {
       "key": "15",
       "value": "保険給付差止"
      },
      {
       "key": "16",
       "value": "保険給付差止終了"
      },
      {
       "key": "17",
       "value": "滞納保険料控除"
      },
      {
       "key": "18",
       "value": "給付額減額"
      },
      {
       "key": "19",
       "value": "給付額減額免除"
      },
      {
       "key": "20",
       "value": "給付額減額終了"
      }
     ],
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "回収事由",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": ""
    },
    {
     "fieldName": "txtKaishuRiyu",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "800",
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
     "selectControlID": "txtKaishuRiyu_text_area",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "40",
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
     "text": "",
     "value": "",
     "labelLText": "回収理由",
     "labelRText": "",
     "labelLWidth": "85",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "limitLength": "200",
     "countDisp": true
    }
   ],
   "controlType": "Panel",
   "width": "942",
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
   "selectControlID": "ShoKaishuJokyoShosai",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "証類交付情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShoKaishuJokyoShosai"
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
 "businessId": "DBZ",
 "controlName": "ShoKaishuJokyoShosai",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "txtKaishuDate",
   "publicChildProperty": "onBlur",
   "newPropertyName": "onBlur_txtKaishuDate"
  },
  {
   "publicChildFieldName": "ddlKaishuJiyu",
   "publicChildProperty": "onChange",
   "newPropertyName": "onChange_ddlKaishuJiyu"
  },
  {
   "publicChildFieldName": "txtKaishuRiyu",
   "publicChildProperty": "onBlur",
   "newPropertyName": "onBlur_txtKaishuRiyu"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "ShoKaishuJokyoShosai_panelDisplay"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "canOpenAndClose",
   "newPropertyName": "ShoKaishuJokyoShosai_canOpenAndClose"
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

