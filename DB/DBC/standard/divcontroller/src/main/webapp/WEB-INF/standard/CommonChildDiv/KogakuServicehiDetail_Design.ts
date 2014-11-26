/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     * KogakuServicehiDetailクラスのみで継承して使えます。
     */
    export class KogakuServicehiDetail_Design extends Uz.CommonChildDiv {
    
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
        
        public get tplJudgementResult_title() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"])["title"];
        }
        
        public set tplJudgementResult_title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0].items[1].items[2]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get tplKetteiJoho_visible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"])["visible"];
        }
        
        public set tplKetteiJoho_visible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[1].items[3]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KogakuServicehiDetail_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("tplJudgementResult_title");
            Uz.JSControlUtil.registProperty("tplKetteiJoho_visible");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["tplJudgementResult_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["tplKetteiJoho_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[3]["fieldName"]).getEditablePropertyInfo()["visible"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KogakuServicehiDetail",
   "items": [
    {
     "fieldName": "txtTeikyoYM",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "60px",
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
     "selectControlID": "txtTeikyoYM_core",
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
     "labelLText": "提供年月",
     "labelRText": "",
     "labelLWidth": "64px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "./_-",
     "ymdKubun": 1,
     "displayFormat": 0
    },
    {
     "fieldName": "tabKogakuServicehiDetail",
     "items": [
      {
       "fieldName": "tplShinseisha",
       "items": [
        {
         "fieldName": "Shinseisha",
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
         "marginLeft": "2.4em",
         "marginRight": "0em",
         "selectControlID": "Shinseisha",
         "helpMessageID": "",
         "jpControlName": "",
         "title": "",
         "relation": [],
         "packageName": "",
         "businessId": "DBZ",
         "controlName": "ShinseishaInfo",
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
         "modes": [],
         "publicEvents": [
          {
           "eventName": "onChange_ddlShinseishaKubun"
          },
          {
           "eventName": "onClick_btnHonninJohoCopy"
          }
         ],
         "publicEventsAlias": [],
         "panelDisplay": 0,
         "btnJigyoshaInputGuide_displayNone": false,
         "txtUkestukeDate_displayNone": true,
         "txtJigyoshaNo_disabled": false,
         "txtShinseishaName_labelLText": "氏名",
         "txtYubinNo_displayNone": false,
         "txtAddress_displayNone": false,
         "btnJigyoshaInputGuide_disabled": false,
         "shinseishaInfo_eraseBorder": false,
         "btnHonninJohoCopy_visible": true,
         "eraseBorderTop": true,
         "eraseBorderBottom": true,
         "eraseBorderRight": true,
         "eraseBorderLeft": true
        },
        {
         "fieldName": "txtShiharaiTotalAmount",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0em",
         "marginRight": "XS",
         "selectControlID": "txtShiharaiTotalAmount_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
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
         "labelLText": "支払金額合計",
         "labelRText": "",
         "labelLWidth": "105px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "permitCharactor": "+-,.\\",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": false,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtShinseiRiyu",
         "items": [],
         "controlType": "TextBoxMultiLine",
         "width": "600px",
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
         "marginLeft": "0.3em",
         "marginRight": "XS",
         "selectControlID": "txtShinseiRiyu_text_area",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "XS",
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
         "labelLText": "申請理由",
         "labelRText": "",
         "labelLWidth": "100px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "limitLength": 20,
         "countDisp": false
        }
       ],
       "controlType": "TabPanel",
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
       "marginRight": "XS",
       "selectControlID": "tplShinseisha",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "申請者情報",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplKoza",
       "items": [
        {
         "fieldName": "PaymentMethod",
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
         "marginLeft": "0em",
         "marginRight": "0em",
         "selectControlID": "PaymentMethod",
         "helpMessageID": "",
         "jpControlName": "",
         "title": "",
         "relation": [],
         "packageName": "",
         "businessId": "DBZ",
         "controlName": "PaymentMethod",
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
         "modes": [],
         "publicEvents": [],
         "publicEventsAlias": [],
         "eraseBorder": false,
         "panelDisplay": 0,
         "KozaPayment_title": "口座払い",
         "onClick_radPayMethod": "",
         "Juryoinin_displayNone": false,
         "Madoguchi_displayNone": false,
         "Koza_displayNone": false,
         "eraseBorderTop": true,
         "eraseBorderBottom": true,
         "eraseBorderRight": true,
         "eraseBorderLeft": true
        }
       ],
       "controlType": "TabPanel",
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
       "marginRight": "XS",
       "selectControlID": "tplKoza",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "口座情報",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplJudgementResult",
       "items": [
        {
         "fieldName": "JudgementResult",
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
         "marginLeft": "0em",
         "marginRight": "0em",
         "selectControlID": "JudgementResult",
         "helpMessageID": "",
         "jpControlName": "",
         "title": "",
         "relation": [],
         "packageName": "",
         "businessId": "DBZ",
         "controlName": "KogakuServicehiJudgementResult",
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
         "modes": [],
         "publicEvents": [],
         "publicEventsAlias": [],
         "panelDisplay": 0,
         "eraseBorderTop": true,
         "eraseBorderBottom": true,
         "eraseBorderRight": true,
         "eraseBorderLeft": true
        }
       ],
       "controlType": "TabPanel",
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
       "marginRight": "XS",
       "selectControlID": "tplJudgementResult",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "判定結果",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplKetteiJoho",
       "items": [],
       "controlType": "TabPanel",
       "width": "XS",
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
       "selectControlID": "tplKetteiJoho",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "高額決定情報",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      }
     ],
     "controlType": "TabContainer",
     "width": "1040px",
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
     "selectControlID": "tabKogakuServicehiDetail",
     "helpMessageID": "",
     "jpControlName": "",
     "onChange": "",
     "selectedItem": null,
     "tabpanelPosition": [
      "tplShinseisha",
      "tplKoza",
      "tplJudgementResult",
      "tplKetteiJoho"
     ],
     "isDraggable": false,
     "selectedItemFieldName": "",
     "initialTab": "0",
     "isLazyLoading": false
    }
   ],
   "controlType": "Panel",
   "width": "1065px",
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
   "selectControlID": "KogakuServicehiDetail",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "高額介護サービス費明細",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KogakuServicehiDetail"
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
   "panelDisplay": 0,
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
 "businessId": "DBC",
 "controlName": "KogakuServicehiDetail",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "KogakuServicehiDetail",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "KogakuServicehiDetail",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "eraseBorder"
  },
  {
   "publicChildFieldName": "KogakuServicehiDetail",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "panelDisplay"
  },
  {
   "publicChildFieldName": "tplJudgementResult",
   "publicChildProperty": "title",
   "newPropertyName": "tplJudgementResult_title"
  },
  {
   "publicChildFieldName": "tplKetteiJoho",
   "publicChildProperty": "visible",
   "newPropertyName": "tplKetteiJoho_visible"
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

     export module KogakuServicehiDetail {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuServicehiDetail";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            }

            public KogakuServicehiDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            }

            public tabKogakuServicehiDetail(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            }

            public tplShinseisha(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            }

            public Shinseisha(): DBZ.ShinseishaInfo.ModeController {
                return new DBZ.ShinseishaInfo.ModeController("Shinseisha");
            }

            public txtShiharaiTotalAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            }

            public txtShinseiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            }

            public tplKoza(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            }

            public PaymentMethod(): DBZ.PaymentMethod.ModeController {
                return new DBZ.PaymentMethod.ModeController("PaymentMethod");
            }

            public tplJudgementResult(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            }

            public JudgementResult(): DBZ.KogakuServicehiJudgementResult.ModeController {
                return new DBZ.KogakuServicehiJudgementResult.ModeController("JudgementResult");
            }

            public tplKetteiJoho(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            }

        }

     }

}

