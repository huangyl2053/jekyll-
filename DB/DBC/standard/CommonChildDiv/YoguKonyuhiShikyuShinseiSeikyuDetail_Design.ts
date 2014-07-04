/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     * YoguKonyuhiShikyuShinseiSeikyuDetailクラスのみで継承して使えます。
     */
    export class YoguKonyuhiShikyuShinseiSeikyuDetail_Design extends Uz.CommonChildDiv {
    
        public get btnModifyDetail_onClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"];
        }
        
        public set btnModifyDetail_onClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[1].items[9]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnModifyDetail_text() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"];
        }
        
        public set btnModifyDetail_text(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[1].items[9]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, YoguKonyuhiShikyuShinseiSeikyuDetail_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("btnModifyDetail_onClick");
            Uz.JSControlUtil.registProperty("btnModifyDetail_text");
            Uz.JSControlUtil.registProperty("");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["btnModifyDetail_onClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnModifyDetail_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["text"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
   "items": [
    {
     "fieldName": "dgSeikyuDetail",
     "items": [],
     "controlType": "DataGrid",
     "width": "545",
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
     "selectControlID": "dgSeikyuDetail",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "236",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": true,
      "isShowDeleteButtonColumn": true,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "購入日",
        "dataName": "txtBuyYMD",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtBuyYMD"
       },
       {
        "columnName": "種目",
        "dataName": "txtShumoku",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 1,
        "cellDetails": {
         "cellType": 1,
         "maxLength": "1000000000000",
         "minLength": "0",
         "textAlign": 0,
         "onChange": ""
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShumoku"
       },
       {
        "columnName": "商品名",
        "dataName": "txtShohinName",
        "toolTip": "",
        "bgColor": 0,
        "width": 160,
        "visible": true,
        "cellType": 1,
        "cellDetails": {
         "cellType": 1,
         "maxLength": "15",
         "minLength": "0",
         "textAlign": 0,
         "onChange": ""
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShohinName"
       },
       {
        "columnName": "購入金額",
        "dataName": "txtBuyAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
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
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtBuyAmount"
       },
       {
        "columnName": "審査方法",
        "dataName": "txtShinsaMethod",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 1,
        "cellDetails": {
         "cellType": 1,
         "maxLength": "1000000000000",
         "minLength": "0",
         "textAlign": 0,
         "onChange": ""
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShinsaMethod"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelectBySelectButton",
     "onSelectByModifyButton": "onSelectByModifyButton",
     "onSelectByDeleteButton": "onSelectByDeleteButton",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtBuyAmount",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
     "items": [
      {
       "fieldName": "txtBuyYMD",
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
       "selectControlID": "txtBuyYMD_core",
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
       "labelLText": "購入日",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "textKind": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "ddlShumoku",
       "items": [],
       "controlType": "DropDownList",
       "width": "250",
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
       "selectControlID": "ddlShumoku_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "code01",
         "value": "01:腰掛便座"
        },
        {
         "key": "code02",
         "value": "02:特殊尿器"
        },
        {
         "key": "code03",
         "value": "03:入浴補助用具"
        },
        {
         "key": "code04",
         "value": "04:簡易浴槽"
        },
        {
         "key": "code05",
         "value": "05:移動用リフトのつり具の部分"
        },
        {
         "key": "code06",
         "value": "06:自動排泄処理装置の交換可能部品"
        },
        {
         "key": "code00",
         "value": ""
        }
       ],
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "種目",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "code00",
       "disabledItem": []
      },
      {
       "fieldName": "txtShohinName",
       "items": [],
       "controlType": "TextBox",
       "width": "340",
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
       "selectControlID": "txtShohinName_core",
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
       "labelLText": "商品名",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "txtSeizoJigyosha",
       "items": [],
       "controlType": "TextBox",
       "width": "300",
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
       "selectControlID": "txtSeizoJigyosha_core",
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
       "labelLText": "製造事業者",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "txtHanbaiJigyosha",
       "items": [],
       "controlType": "TextBox",
       "width": "300",
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
       "selectControlID": "txtHanbaiJigyosha_core",
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
       "labelLText": "販売事業者",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "txtBuyAmount",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "80",
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
       "selectControlID": "txtBuyAmount_core",
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
       "labelLText": "購入金額",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": true,
       "decimalPointLength": 0,
       "permitCharactor": "+-,.\\"
      },
      {
       "fieldName": "txtHinmokuCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "300",
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
       "selectControlID": "txtHinmokuCode_core",
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
       "labelLText": "品目コード",
       "labelRText": "",
       "labelLWidth": "90",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "radShinsaMethod",
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
       "selectControlID": "radShinsaMethod_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "judgeRequest",
         "value": "審査依頼"
        },
        {
         "key": "judgeDone",
         "value": "審査済み"
        }
       ],
       "required": false,
       "onChange": "",
       "labelLText": "審査方法",
       "labelLWidth": "90",
       "labelLAlign": 2,
       "selectedItem": "judgeDone",
       "onClick": "",
       "newLineItemNumber": 2,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "btnClear",
       "items": [],
       "controlType": "Button",
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
       "selectControlID": "btnClear",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "入力内容をクリアする",
       "onClick": "onClick_btnClear",
       "icon": 0,
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      },
      {
       "fieldName": "btnModifyDetail",
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
       "float": 2,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "btnModifyDetail",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "明細を追加する",
       "onClick": "onClick_btnModifyDetail",
       "icon": 0,
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      }
     ],
     "controlType": "Panel",
     "width": "545",
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
     "selectControlID": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
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
       "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetailInput"
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
   "controlType": "Panel",
   "width": "1095",
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
   "selectControlID": "YoguKonyuhiShikyuShinseiSeikyuDetail",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetail"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnAddSeikyuDetail",
     "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiSeikyuDetail/onClick_btnAddSeikyuDetail"
    }
   ],
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
 "businessId": "DBC",
 "controlName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnModifyDetail",
   "publicChildProperty": "onClick",
   "newPropertyName": "btnModifyDetail_onClick"
  },
  {
   "publicChildFieldName": "btnModifyDetail",
   "publicChildProperty": "text",
   "newPropertyName": "btnModifyDetail_text"
  },
  {
   "publicChildFieldName": "",
   "publicChildProperty": "",
   "newPropertyName": ""
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

