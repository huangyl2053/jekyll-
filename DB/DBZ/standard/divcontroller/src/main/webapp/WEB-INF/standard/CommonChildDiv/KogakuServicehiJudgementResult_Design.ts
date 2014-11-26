/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KogakuServicehiJudgementResultクラスのみで継承して使えます。
     */
    export class KogakuServicehiJudgementResult_Design extends Uz.CommonChildDiv {
    
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
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KogakuServicehiJudgementResult_Design.myLayout, fieldName);
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
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KogakuServicehiJudgementResult",
   "items": [
    {
     "fieldName": "dgJudgementResult",
     "items": [],
     "controlType": "DataGrid",
     "width": "980px",
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
     "selectControlID": "dgJudgementResult",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "S",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": false,
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": false,
      "isShowDeleteButtonColumn": false,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 1
      },
      "columns": [
       {
        "columnName": "事業者",
        "dataName": "txtJigyosha",
        "toolTip": "",
        "bgColor": 0,
        "width": 295,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtJigyosha"
       },
       {
        "columnName": "サービス種類",
        "dataName": "txtServiceShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 190,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtServiceShurui"
       },
       {
        "columnName": "サービス<br>費用合計",
        "dataName": "txtServiceHiyoTotal",
        "toolTip": "",
        "bgColor": 0,
        "width": 95,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": ""
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtServiceHiyoTotal"
       },
       {
        "columnName": "利用者<br>負担額合計",
        "dataName": "txtRiyoshaFutanTotalAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": ""
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtRiyoshaFutanTotalAmount"
       },
       {
        "columnName": "算定<br>基準額",
        "dataName": "txtSanteiKijunAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": ""
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtSanteiKijunAmount"
       },
       {
        "columnName": "支払済<br>金額",
        "dataName": "txtShiharaizumiAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": ""
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShiharaizumiAmount"
       },
       {
        "columnName": "高額<br>支給額",
        "dataName": "txtKogakuShikyuAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": ""
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKogakuShikyuAmount"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "",
     "onSelectByDeleteButton": "",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtKogakuShikyuAmount",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    },
    {
     "fieldName": "KogakuServicehiJudgementResultDetail1",
     "items": [
      {
       "fieldName": "txtUketsukeDate",
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
       "value": "",
       "labelLText": "受付日",
       "labelRText": "",
       "labelLWidth": "96px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtHonninPaymentAmount",
       "items": [],
       "controlType": "TextBoxNum",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "txtHonninPaymentAmount_core",
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
       "labelLText": "本人支払額",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "+-,.\\",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": true,
       "decimalPointLength": 0
      },
      {
       "fieldName": "txtKetteiDate",
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
       "selectControlID": "txtKetteiDate_core",
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
       "labelLText": "決定日",
       "labelRText": "",
       "labelLWidth": "96px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "radShikyuKubun",
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
       "selectControlID": "radShikyuKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "labelLText": "支給区分",
       "labelLWidth": "80px",
       "labelLAlign": 2,
       "onClick": "",
       "icon": [],
       "dataSource": [
        {
         "key": "shikyu",
         "value": "支給"
        },
        {
         "key": "Fushikyu",
         "value": "不支給"
        }
       ],
       "selectedItem": "shikyu",
       "newLineItemNumber": 2,
       "spaceSize": "S",
       "disabledItem": []
      },
      {
       "fieldName": "txtsetaiShuyakuNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "80px",
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
       "selectControlID": "txtsetaiShuyakuNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "maxLength": 100000000,
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
       "labelLText": "世帯集約番号",
       "labelRText": "",
       "labelLWidth": "96px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtShikyuAmount",
       "items": [],
       "controlType": "TextBoxNum",
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
       "marginLeft": "M",
       "marginRight": "XS",
       "selectControlID": "txtShikyuAmount_core",
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
       "labelLText": "支給金額",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "+-,.\\",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": true,
       "decimalPointLength": 0
      },
      {
       "fieldName": "radIsKogakuAutoShokan",
       "items": [],
       "controlType": "RadioButton",
       "width": "M",
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
       "selectControlID": "radIsKogakuAutoShokan_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "labelLText": "高額自動償還",
       "labelLWidth": "96px",
       "labelLAlign": 2,
       "onClick": "",
       "icon": [],
       "dataSource": [
        {
         "key": "ari",
         "value": "あり"
        },
        {
         "key": "nashi",
         "value": "なし"
        }
       ],
       "selectedItem": "ari",
       "newLineItemNumber": 2,
       "spaceSize": "M",
       "disabledItem": []
      }
     ],
     "controlType": "Panel",
     "width": "485px",
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
     "selectControlID": "KogakuServicehiJudgementResultDetail1",
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
       "postParameterPanelNames": "KogakuServicehiJudgementResultDetail1"
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
    },
    {
     "fieldName": "KogakuServicehiJudgementResultDetail2",
     "items": [
      {
       "fieldName": "txtBiko",
       "items": [],
       "controlType": "TextBox",
       "width": "380px",
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
       "selectControlID": "txtBiko_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
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
       "labelLText": "備考",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "radJudgementMethod",
       "items": [],
       "controlType": "RadioButton",
       "width": "180px",
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
       "selectControlID": "radJudgementMethod_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "labelLText": "審査方法",
       "labelLWidth": "80px",
       "labelLAlign": 2,
       "onClick": "",
       "icon": [],
       "dataSource": [
        {
         "key": "mishinsa",
         "value": "審査依頼"
        },
        {
         "key": "shinsaZumi",
         "value": "審査済み"
        }
       ],
       "selectedItem": "shinsaZumi",
       "newLineItemNumber": 2,
       "spaceSize": "S",
       "disabledItem": []
      },
      {
       "fieldName": "txtFushikyuRiyu",
       "items": [],
       "controlType": "TextBoxMultiLine",
       "width": "380px",
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
       "selectControlID": "txtFushikyuRiyu_text_area",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "XS",
       "required": false,
       "maxLength": "10000000000",
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
       "labelLText": "不支給理由",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "limitLength": "100",
       "countDisp": false
      }
     ],
     "controlType": "Panel",
     "width": "490px",
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
     "marginLeft": "-1.6em",
     "marginRight": "XS",
     "selectControlID": "KogakuServicehiJudgementResultDetail2",
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
       "postParameterPanelNames": "KogakuServicehiJudgementResultDetail2"
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
   "controlType": "Panel",
   "width": "993px",
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
   "selectControlID": "KogakuServicehiJudgementResult",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "判定結果",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KogakuServicehiJudgementResult"
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
 "controlName": "KogakuServicehiJudgementResult",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "KogakuServicehiJudgementResult",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "KogakuServicehiJudgementResult",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "eraseBorder"
  },
  {
   "publicChildFieldName": "KogakuServicehiJudgementResult",
   "publicChildProperty": "panelDisplay",
   "newPropertyName": "panelDisplay"
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

     export module KogakuServicehiJudgementResult {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuServicehiJudgementResult";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            }

            public KogakuServicehiJudgementResult(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgJudgementResult(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            }

            public KogakuServicehiJudgementResultDetail1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            }

            public txtUketsukeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            }

            public txtHonninPaymentAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            }

            public txtKetteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            }

            public radShikyuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            }

            public txtsetaiShuyakuNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            }

            public txtShikyuAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            }

            public radIsKogakuAutoShokan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            }

            public KogakuServicehiJudgementResultDetail2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            }

            public txtBiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            }

            public radJudgementMethod(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            }

            public txtFushikyuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            }

        }

     }

}

