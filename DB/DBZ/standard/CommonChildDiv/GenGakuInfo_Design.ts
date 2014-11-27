/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * GenGakuInfoクラスのみで継承して使えます。
     */
    export class GenGakuInfo_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, GenGakuInfo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "GenGakuInfo",
   "items": [
    {
     "fieldName": "TainoNendo",
     "items": [
      {
       "fieldName": "txtHanteiKijunYMD",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "txtHanteiKijunYMD_core",
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
       "labelLText": "滞納判定基準日",
       "labelRText": "",
       "labelLWidth": "120px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "btnKensaku",
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
       "marginRight": "XS",
       "selectControlID": "btnKensaku",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "基準日で検索する",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      },
      {
       "fieldName": "dgGenGaku",
       "items": [],
       "controlType": "DataGrid",
       "width": "560px",
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
       "selectControlID": "dgGenGaku",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "Auto",
       "gridSetting": {
        "rowHeight": 25,
        "isMultiSelectable": false,
        "isShowHeader": true,
        "isShowFooter": false,
        "isShowFilter": false,
        "isShowFilterButton": false,
        "isShowRowState": false,
        "isShowSelectButtonColumn": true,
        "isShowModifyButtonColumn": false,
        "isShowDeleteButtonColumn": false,
        "limitRowCount": 0,
        "selectedRowCount": 0,
        "selectLimitRowCount": 0,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "調定年度",
          "dataName": "txtChoteiNendo",
          "toolTip": "",
          "bgColor": 0,
          "width": 130,
          "visible": true,
          "cellType": 6,
          "cellDetails": {
           "cellType": 6,
           "ymdKubun": 0,
           "displayFormat": 0,
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "調定額",
          "dataName": "txtChoteiGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 130,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "10",
           "minLength": "0",
           "maxValue": "99999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "収入額",
          "dataName": "txtShunyuGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 130,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "10",
           "minLength": "0",
           "maxValue": "99999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "時効到来未納額",
          "dataName": "txtJikoMinoGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 130,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "10",
           "minLength": "0",
           "maxValue": "99999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
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
       "sortOrder": "",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1,
       "gridAction": []
      },
      {
       "fieldName": "GenGakuKeisan",
       "items": [
        {
         "fieldName": "ChoshuKenKeimetsuKikan1",
         "items": [
          {
           "fieldName": "lblChoShushometsu1",
           "items": [],
           "controlType": "Label",
           "width": "120px",
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
           "marginLeft": "3px",
           "marginRight": "XS",
           "selectControlID": "lblChoShushometsu1",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "徴収権消滅期間",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "txtChoShushometsu1",
           "items": [],
           "controlType": "TextBoxNum",
           "width": "100px",
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
           "marginLeft": "6px",
           "marginRight": "XS",
           "selectControlID": "txtChoShushometsu1_core",
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
           "labelLText": "",
           "labelRText": "",
           "labelLWidth": "S",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "decorationClass": "",
           "maxLength": "5",
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "maxValue": "1",
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": "3",
           "permitCharactor": "+-,.\\"
          },
          {
           "fieldName": "Kakesan",
           "items": [
            {
             "fieldName": "lblKakesan",
             "items": [],
             "controlType": "Label",
             "width": "16px",
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
             "marginRight": "0px",
             "selectControlID": "lblKakesan",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "×",
             "decorationClass": "",
             "align": 2
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
           "marginRight": "0px",
           "selectControlID": "Kakesan",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "-10px",
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
           "focusPositionID": "accessKeyProperty",
           "canPost": false
          }
         ],
         "controlType": "Panel",
         "width": "150px",
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
         "marginRight": "0px",
         "selectControlID": "ChoshuKenKeimetsuKikan1",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "",
         "marginTop": "35px",
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
         "widthAuto": false,
         "panelDisplay": 0,
         "isGroupBox": false,
         "readOnly": false,
         "height": "Auto",
         "focusPositionID": "GenGakuInfo_panel_body_area",
         "canPost": false
        },
        {
         "fieldName": "ChoshuKenKeimetsuKikan2",
         "items": [
          {
           "fieldName": "ChoshuKenKeimetsuKikan3",
           "items": [
            {
             "fieldName": "lblChoShushometsu2",
             "items": [],
             "controlType": "Label",
             "width": "120px",
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
             "marginLeft": "3px",
             "marginRight": "XS",
             "selectControlID": "lblChoShushometsu2",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "徴収権消滅期間",
             "decorationClass": "",
             "align": 0
            },
            {
             "fieldName": "txtChoShushometsu2",
             "items": [],
             "controlType": "TextBoxNum",
             "width": "100px",
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
             "selectControlID": "txtChoShushometsu2_core",
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
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "decorationClass": "",
             "maxLength": "5",
             "minLength": 0,
             "textAlign": 2,
             "textKind": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": "1",
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": "3",
             "permitCharactor": "+-,.\\"
            },
            {
             "fieldName": "lblLine",
             "items": [],
             "controlType": "Label",
             "width": "300px",
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
             "marginLeft": "-80px",
             "marginRight": "0px",
             "selectControlID": "lblLine",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "──────────────────",
             "decorationClass": "",
             "align": 0
            }
           ],
           "controlType": "Panel",
           "width": "125px",
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
           "selectControlID": "ChoshuKenKeimetsuKikan3",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "0px",
           "marginBottom": "0px",
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
           "widthAuto": false,
           "panelDisplay": 0,
           "isGroupBox": false,
           "readOnly": false,
           "height": "50px",
           "focusPositionID": "restoreLayoutButton",
           "canPost": false
          },
          {
           "fieldName": "ChoshuKenKeimetsuKikan4",
           "items": [
            {
             "fieldName": "lblChoShushometsu3",
             "items": [],
             "controlType": "Label",
             "width": "120px",
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
             "marginLeft": "3px",
             "marginRight": "XS",
             "selectControlID": "lblChoShushometsu3",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "徴収権消滅期間",
             "decorationClass": "",
             "align": 0
            },
            {
             "fieldName": "txtChoShushometsu3",
             "items": [],
             "controlType": "TextBoxNum",
             "width": "100px",
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
             "selectControlID": "txtChoShushometsu3_core",
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
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "decorationClass": "",
             "maxLength": "5",
             "minLength": 0,
             "textAlign": 2,
             "textKind": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": "1",
             "minValue": 0,
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "3",
             "permitCharactor": "+-,.\\"
            }
           ],
           "controlType": "Panel",
           "width": "125px",
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
           "selectControlID": "ChoshuKenKeimetsuKikan4",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "0px",
           "marginBottom": "0px",
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
           "widthAuto": false,
           "panelDisplay": 0,
           "isGroupBox": false,
           "readOnly": false,
           "height": "50px",
           "focusPositionID": "restoreLayoutButton",
           "canPost": false
          },
          {
           "fieldName": "Kasan",
           "items": [
            {
             "fieldName": "lblKasan",
             "items": [],
             "controlType": "Label",
             "width": "16px",
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
             "selectControlID": "lblKasan",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "＋",
             "decorationClass": "",
             "align": 2
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
           "selectControlID": "Kasan",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "15px",
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
           "focusPositionID": "accessKeyProperty",
           "canPost": false
          },
          {
           "fieldName": "NofuZumiKikan",
           "items": [
            {
             "fieldName": "lblNofuZumiKikan",
             "items": [],
             "controlType": "Label",
             "width": "100px",
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
             "selectControlID": "lblNofuZumiKikan",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "納付済期間",
             "decorationClass": "",
             "align": 1
            },
            {
             "fieldName": "txtNofuZumiKikan",
             "items": [],
             "controlType": "TextBoxNum",
             "width": "100px",
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
             "selectControlID": "txtNofuZumiKikan_core",
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
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "80px",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "decorationClass": "",
             "maxLength": "5",
             "minLength": 0,
             "textAlign": 2,
             "textKind": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": "1",
             "minValue": 0,
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "3",
             "permitCharactor": "+-,.\\"
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
           "selectControlID": "NofuZumiKikan",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "0px",
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
           "focusPositionID": "restoreLayoutButton",
           "canPost": false
          }
         ],
         "controlType": "Panel",
         "width": "320px",
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
         "marginLeft": "0px",
         "marginRight": "0px",
         "selectControlID": "ChoshuKenKeimetsuKikan2",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "",
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
         "widthAuto": false,
         "panelDisplay": 0,
         "isGroupBox": false,
         "readOnly": false,
         "height": "Auto",
         "focusPositionID": "wrapProperty",
         "canPost": false
        },
        {
         "fieldName": "GnegakuKikan",
         "items": [
          {
           "fieldName": "lblKeisanShiki",
           "items": [],
           "controlType": "Label",
           "width": "160px",
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
           "selectControlID": "lblKeisanShiki",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "× １／２ × １２ ＝",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "GenGakuKikan2",
           "items": [
            {
             "fieldName": "lblGenGakuKikan",
             "items": [],
             "controlType": "Label",
             "width": "120px",
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
             "selectControlID": "lblGenGakuKikan",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "給付額減額期間",
             "decorationClass": "",
             "align": 0
            },
            {
             "fieldName": "txtGenGakuKikan",
             "items": [],
             "controlType": "TextBoxNum",
             "width": "30px",
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
             "marginLeft": "30px",
             "marginRight": "XS",
             "selectControlID": "txtGenGakuKikan_core",
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
             "labelLText": "",
             "labelRText": "ヵ月",
             "labelLWidth": "30px",
             "labelRWidth": "40px",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "decorationClass": "",
             "maxLength": "3",
             "minLength": 0,
             "textAlign": 2,
             "textKind": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": "1",
             "minValue": 0,
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "",
             "permitCharactor": "+-,.\\"
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
           "marginLeft": "0px",
           "marginRight": "XS",
           "selectControlID": "GenGakuKikan2",
           "helpMessageID": "",
           "jpControlName": "",
           "onLoad": "",
           "title": "",
           "marginTop": "-10px",
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
           "focusPositionID": "restoreLayoutButton",
           "canPost": false
          }
         ],
         "controlType": "Panel",
         "width": "320px",
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
         "marginLeft": "0px",
         "marginRight": "XS",
         "selectControlID": "GnegakuKikan",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "",
         "marginTop": "50px",
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
         "widthAuto": false,
         "panelDisplay": 0,
         "isGroupBox": false,
         "readOnly": false,
         "height": "Auto",
         "focusPositionID": "GenGakuInfo_panel_body_area",
         "canPost": false
        }
       ],
       "controlType": "Panel",
       "width": "810px",
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
       "selectControlID": "GenGakuKeisan",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [],
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
       "focusPositionID": "GenGakuInfo_panel_body_area",
       "canPost": false
      }
     ],
     "controlType": "Panel",
     "width": "1110px",
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
     "marginLeft": "0px",
     "marginRight": "0px",
     "selectControlID": "TainoNendo",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "収納情報",
     "marginTop": "0px",
     "marginBottom": "0px",
     "isOpen": false,
     "canOpenAndClose": true,
     "postParameterPanelNames": [],
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
     "canPost": false
    },
    {
     "fieldName": "TainoGengakuShosaiInfo",
     "items": [
      {
       "fieldName": "chkHyojiKirikae",
       "items": [],
       "controlType": "CheckBoxList",
       "width": "380px",
       "visible": true,
       "displayNone": false,
       "disabled": false,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": true,
       "dependencies": [],
       "float": 2,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "200px",
       "selectControlID": "chkHyojiKirikae_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "onClick": "",
       "icon": [],
       "dataSource": [
        {
         "key": "key0",
         "value": "賦課年度、徴収方法、通知書番号を全行表示する"
        }
       ],
       "selectedItem": "",
       "selectedItems": [
        {
         "key": "key0",
         "value": "賦課年度、徴収方法、通知書番号を全行表示する"
        }
       ],
       "newLineItemNumber": 1,
       "minCheckedItem": 0,
       "maxCheckedItem": 2,
       "spaceSize": "M",
       "isAllSelectable": false,
       "isAllSelectableBreakLine": false,
       "disabledItem": []
      },
      {
       "fieldName": "txtNendo",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "40px",
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
       "selectControlID": "txtNendo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "平26",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "年度保険料",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 0,
       "labelRAlign": 0,
       "ymdKubun": 0,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "dgTainoShosaiInfo",
       "items": [],
       "controlType": "DataGrid",
       "width": "890px",
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
       "selectControlID": "dgTainoShosaiInfo",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "400px",
       "gridSetting": {
        "rowHeight": 25,
        "isMultiSelectable": false,
        "isShowHeader": true,
        "isShowFooter": false,
        "isShowFilter": false,
        "isShowFilterButton": false,
        "isShowRowState": false,
        "isShowSelectButtonColumn": false,
        "isShowModifyButtonColumn": false,
        "isShowDeleteButtonColumn": false,
        "limitRowCount": 0,
        "selectedRowCount": 0,
        "selectLimitRowCount": 0,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "賦課年度",
          "dataName": "txtFukaNendo",
          "toolTip": "",
          "bgColor": 0,
          "width": 70,
          "visible": true,
          "cellType": 6,
          "cellDetails": {
           "cellType": 6,
           "ymdKubun": 0,
           "displayFormat": 0,
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "普／特",
          "dataName": "txtChoshuHoHo",
          "toolTip": "",
          "bgColor": 0,
          "width": 60,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "2",
           "minLength": "0",
           "textAlign": 0,
           "onChange": "",
           "textKind": 0,
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "通知書番号",
          "dataName": "txttsuchishoNo",
          "toolTip": "",
          "bgColor": 0,
          "width": 140,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "16",
           "minLength": "0",
           "textAlign": 0,
           "onChange": "",
           "textKind": 2,
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "期",
          "dataName": "txtKi",
          "toolTip": "",
          "bgColor": 0,
          "width": 40,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "3",
           "minLength": "0",
           "textAlign": 0,
           "onChange": "",
           "textKind": 0,
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "調定額",
          "dataName": "txtChoteiGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "7",
           "minLength": "0",
           "maxValue": "999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "納期限",
          "dataName": "txtNokiGen",
          "toolTip": "",
          "bgColor": 0,
          "width": 90,
          "visible": true,
          "cellType": 6,
          "cellDetails": {
           "cellType": 6,
           "ymdKubun": 2,
           "displayFormat": 0,
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "収入額",
          "dataName": "txtShunyuGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "7",
           "minLength": "0",
           "maxValue": "999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "未納額",
          "dataName": "txtMinoGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
          "visible": true,
          "cellType": 5,
          "cellDetails": {
           "cellType": 5,
           "maxLength": "7",
           "minLength": "0",
           "maxValue": "999999",
           "minValue": "0",
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": "0",
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "今回",
          "dataName": "txtKokai",
          "toolTip": "",
          "bgColor": 0,
          "width": 40,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "1",
           "minLength": "0",
           "textAlign": 1,
           "onChange": "",
           "textKind": 0,
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "時効起算日",
          "dataName": "txtJikoKisanYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 90,
          "visible": true,
          "cellType": 6,
          "cellDetails": {
           "cellType": 6,
           "ymdKubun": 2,
           "displayFormat": 0,
           "onChange": "",
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
         },
         {
          "columnName": "時効起算日事由",
          "dataName": "txtJikoKisanKbn",
          "toolTip": "",
          "bgColor": 0,
          "width": 120,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "10",
           "minLength": "0",
           "textAlign": 0,
           "onChange": "",
           "textKind": 0,
           "isSetValueToToolTip": false,
           "readOnly": true
          },
          "align": 0,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": ""
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
       "sortOrder": "",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1,
       "gridAction": []
      },
      {
       "fieldName": "tblComment",
       "items": [
        {
         "fieldName": "celTainocolorKanno",
         "items": [
          {
           "fieldName": "TainocolorKanno",
           "items": [
            {
             "fieldName": "celWhite",
             "items": [
              {
               "fieldName": "lblColorWhite",
               "items": [],
               "controlType": "Label",
               "width": "20px",
               "visible": false,
               "displayNone": false,
               "disabled": false,
               "accessKey": "",
               "nextFocusFieldName": "",
               "wrap": false,
               "dependencies": [],
               "float": 0,
               "toolTip": "",
               "authorityMode": 0,
               "marginLeft": "0px",
               "marginRight": "0px",
               "selectControlID": "lblColorWhite",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "label",
               "decorationClass": "",
               "align": 2
              }
             ],
             "controlType": "TableCell",
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
             "selectControlID": "celWhite",
             "helpMessageID": "",
             "jpControlName": "",
             "connectTd": "R1C1"
            }
           ],
           "controlType": "TablePanel",
           "width": "XS",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "TainocolorKanno",
           "helpMessageID": "",
           "jpControlName": "",
           "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='white'></td></tr>\n  </tbody>\n</table>\n"
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainocolorKanno",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R1C1"
        },
        {
         "fieldName": "celTainoSetsumeiKanno",
         "items": [
          {
           "fieldName": "lblTainoSetsumeiKanno",
           "items": [],
           "controlType": "Label",
           "width": "120px",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "lblTainoSetsumeiKanno",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "完納／未来納期",
           "decorationClass": "",
           "align": 0
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainoSetsumeiKanno",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R1C2"
        },
        {
         "fieldName": "celTainocolorMitorai",
         "items": [
          {
           "fieldName": "TainocolorMitorai",
           "items": [
            {
             "fieldName": "celDummyYellow",
             "items": [
              {
               "fieldName": "lblDummyYellow",
               "items": [],
               "controlType": "Label",
               "width": "20px",
               "visible": false,
               "displayNone": false,
               "disabled": false,
               "accessKey": "",
               "nextFocusFieldName": "",
               "wrap": false,
               "dependencies": [],
               "float": 0,
               "toolTip": "",
               "authorityMode": 0,
               "marginLeft": "0px",
               "marginRight": "0px",
               "selectControlID": "lblDummyYellow",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "label",
               "decorationClass": "",
               "align": 2
              }
             ],
             "controlType": "TableCell",
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
             "selectControlID": "celDummyYellow",
             "helpMessageID": "",
             "jpControlName": "",
             "connectTd": "R1C1"
            }
           ],
           "controlType": "TablePanel",
           "width": "XS",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "TainocolorMitorai",
           "helpMessageID": "",
           "jpControlName": "",
           "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='yellow'></td></tr>\n  </tbody>\n</table>\n"
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainocolorMitorai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R2C1"
        },
        {
         "fieldName": "celTainoSetsumeiMiTorai",
         "items": [
          {
           "fieldName": "lblTainoSetsumeiMiTorai",
           "items": [],
           "controlType": "Label",
           "width": "130px",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "lblTainoSetsumeiMiTorai",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "未納・時効未到来",
           "decorationClass": "",
           "align": 0
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainoSetsumeiMiTorai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R2C2"
        },
        {
         "fieldName": "celTainocolorTorai",
         "items": [
          {
           "fieldName": "TainocolorTorai",
           "items": [
            {
             "fieldName": "celDummyRed",
             "items": [
              {
               "fieldName": "lblDummyRed",
               "items": [],
               "controlType": "Label",
               "width": "20px",
               "visible": false,
               "displayNone": false,
               "disabled": false,
               "accessKey": "",
               "nextFocusFieldName": "",
               "wrap": false,
               "dependencies": [],
               "float": 0,
               "toolTip": "",
               "authorityMode": 0,
               "marginLeft": "0px",
               "marginRight": "0px",
               "selectControlID": "lblDummyRed",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "label",
               "decorationClass": "",
               "align": 2
              }
             ],
             "controlType": "TableCell",
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
             "selectControlID": "celDummyRed",
             "helpMessageID": "",
             "jpControlName": "",
             "connectTd": "R1C1"
            }
           ],
           "controlType": "TablePanel",
           "width": "XS",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "TainocolorTorai",
           "helpMessageID": "",
           "jpControlName": "",
           "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='red'></td></tr>\n  </tbody>\n</table>\n"
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainocolorTorai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R3C1"
        },
        {
         "fieldName": "celTainoSetsumeiTorai",
         "items": [
          {
           "fieldName": "lblTainoSetsumeiTorai",
           "items": [],
           "controlType": "Label",
           "width": "120px",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "lblTainoSetsumeiTorai",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "未納・時効到来",
           "decorationClass": "",
           "align": 0
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainoSetsumeiTorai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R3C2"
        },
        {
         "fieldName": "celTainocolorTaishoGai",
         "items": [
          {
           "fieldName": "TainocolorTaishoGai",
           "items": [
            {
             "fieldName": "celLightSalmon",
             "items": [
              {
               "fieldName": "lblLightSalmon",
               "items": [],
               "controlType": "Label",
               "width": "20px",
               "visible": false,
               "displayNone": false,
               "disabled": false,
               "accessKey": "",
               "nextFocusFieldName": "",
               "wrap": false,
               "dependencies": [],
               "float": 0,
               "toolTip": "",
               "authorityMode": 0,
               "marginLeft": "0px",
               "marginRight": "0px",
               "selectControlID": "lblLightSalmon",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "label",
               "decorationClass": "",
               "align": 2
              }
             ],
             "controlType": "TableCell",
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
             "selectControlID": "celLightSalmon",
             "helpMessageID": "",
             "jpControlName": "",
             "connectTd": "R1C1"
            }
           ],
           "controlType": "TablePanel",
           "width": "XS",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "TainocolorTaishoGai",
           "helpMessageID": "",
           "jpControlName": "",
           "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='lightsalmon'></td></tr>\n  </tbody>\n</table>\n"
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainocolorTaishoGai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R4C1"
        },
        {
         "fieldName": "celTainoSetsumeiTaishoGai",
         "items": [
          {
           "fieldName": "lblTainoSetsumeiTaishoGai",
           "items": [],
           "controlType": "Label",
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
           "marginLeft": "0px",
           "marginRight": "XS",
           "selectControlID": "lblTainoSetsumeiTaishoGai",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "未納・時効対象外",
           "decorationClass": "",
           "align": 0
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainoSetsumeiTaishoGai",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R4C2"
        },
        {
         "fieldName": "celTainocolorKano",
         "items": [
          {
           "fieldName": "TainocolorKano",
           "items": [
            {
             "fieldName": "celDummyGreen",
             "items": [
              {
               "fieldName": "lblDummyGreen",
               "items": [],
               "controlType": "Label",
               "width": "20px",
               "visible": false,
               "displayNone": false,
               "disabled": false,
               "accessKey": "",
               "nextFocusFieldName": "",
               "wrap": false,
               "dependencies": [],
               "float": 0,
               "toolTip": "",
               "authorityMode": 0,
               "marginLeft": "0px",
               "marginRight": "0px",
               "selectControlID": "lblDummyGreen",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "label",
               "decorationClass": "",
               "align": 2
              }
             ],
             "controlType": "TableCell",
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
             "selectControlID": "celDummyGreen",
             "helpMessageID": "",
             "jpControlName": "",
             "connectTd": "R1C1"
            }
           ],
           "controlType": "TablePanel",
           "width": "XS",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "TainocolorKano",
           "helpMessageID": "",
           "jpControlName": "",
           "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='lightGreen'></td></tr>\n  </tbody>\n</table>\n"
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainocolorKano",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R5C1"
        },
        {
         "fieldName": "celTainoSetsumeiKano",
         "items": [
          {
           "fieldName": "lblTainoSetsumeiKano",
           "items": [],
           "controlType": "Label",
           "width": "120px",
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
           "marginLeft": "0px",
           "marginRight": "0px",
           "selectControlID": "lblTainoSetsumeiKano",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "過納",
           "decorationClass": "",
           "align": 0
          }
         ],
         "controlType": "TableCell",
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
         "selectControlID": "celTainoSetsumeiKano",
         "helpMessageID": "",
         "jpControlName": "",
         "connectTd": "R5C2"
        }
       ],
       "controlType": "TablePanel",
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
       "selectControlID": "tblComment",
       "helpMessageID": "",
       "jpControlName": "",
       "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1'></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1'></td><td id='R5C2'></td></tr>\n  </tbody>\n</table>\n"
      },
      {
       "fieldName": "Modoru",
       "items": [
        {
         "fieldName": "btnModoru",
         "items": [],
         "controlType": "Button",
         "width": "140px",
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
         "selectControlID": "btnModoru",
         "helpMessageID": "",
         "jpControlName": "",
         "text": "収納情報に戻る",
         "onBeforeClick": "",
         "onAfterClick": "",
         "onClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
         "icon": 0,
         "heightTextBoxMatches": false
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
       "float": 2,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "0px",
       "selectControlID": "Modoru",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "",
       "marginTop": "200px",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
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
       "canPost": false
      }
     ],
     "controlType": "Panel",
     "width": "1110px",
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
     "marginLeft": "0px",
     "marginRight": "0px",
     "selectControlID": "TainoGengakuShosaiInfo",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "滞納状況詳細（減額用）",
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
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "focusPositionID": "GenGakuInfo_panel_body_area",
     "canPost": false
    },
    {
     "fieldName": "btnReturn",
     "items": [],
     "controlType": "Button",
     "width": "100px",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "閉じる",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnReturn",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "btnKakutei",
     "items": [],
     "controlType": "Button",
     "width": "S",
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
     "selectControlID": "btnKakutei",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "確定する",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "1110px",
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
   "marginLeft": "Default",
   "marginRight": "Default",
   "selectControlID": "GenGakuInfo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "減額情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [],
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
   "focusPositionID": "restoreLayoutButton",
   "canPost": false
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
 "marginLeft": "0px",
 "marginRight": "0px",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBZ",
 "controlName": "GenGakuInfo",
 "marginTop": "0px",
 "marginBottom": "0px",
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
 "publicEventsAlias": []
}        
    }

     export module GenGakuInfo {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "GenGakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.GenGakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.GenGakuInfo.Controls.myType() + "_" + fieldName;
            }

            public GenGakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TainoNendo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo"));
            }

            public txtHanteiKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public dgGenGaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGenGaku"));
            }

            public GenGakuKeisan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan"));
            }

            public ChoshuKenKeimetsuKikan1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan1"));
            }

            public lblChoShushometsu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu1"));
            }

            public txtChoShushometsu1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu1"));
            }

            public Kakesan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan1_Kakesan"));
            }

            public lblKakesan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakesan"));
            }

            public ChoshuKenKeimetsuKikan2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2"));
            }

            public ChoshuKenKeimetsuKikan3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_ChoshuKenKeimetsuKikan3"));
            }

            public lblChoShushometsu2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu2"));
            }

            public txtChoShushometsu2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu2"));
            }

            public lblLine(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLine"));
            }

            public ChoshuKenKeimetsuKikan4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_ChoshuKenKeimetsuKikan4"));
            }

            public lblChoShushometsu3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu3"));
            }

            public txtChoShushometsu3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu3"));
            }

            public Kasan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_Kasan"));
            }

            public lblKasan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKasan"));
            }

            public NofuZumiKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_NofuZumiKikan"));
            }

            public lblNofuZumiKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNofuZumiKikan"));
            }

            public txtNofuZumiKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuZumiKikan"));
            }

            public GnegakuKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_GnegakuKikan"));
            }

            public lblKeisanShiki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKeisanShiki"));
            }

            public GenGakuKikan2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_GnegakuKikan_GenGakuKikan2"));
            }

            public lblGenGakuKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenGakuKikan"));
            }

            public txtGenGakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenGakuKikan"));
            }

            public TainoGengakuShosaiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo"));
            }

            public chkHyojiKirikae(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHyojiKirikae"));
            }

            public txtNendo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNendo"));
            }

            public dgTainoShosaiInfo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTainoShosaiInfo"));
            }

            public tblComment(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblComment"));
            }

            public celTainocolorKanno(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorKanno"));
            }

            public TainocolorKanno(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            }

            public celWhite(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celWhite"));
            }

            public lblColorWhite(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblColorWhite"));
            }

            public celTainoSetsumeiKanno(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKanno"));
            }

            public lblTainoSetsumeiKanno(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKanno"));
            }

            public celTainocolorMitorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorMitorai"));
            }

            public TainocolorMitorai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            }

            public celDummyYellow(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyYellow"));
            }

            public lblDummyYellow(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            }

            public celTainoSetsumeiMiTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiMiTorai"));
            }

            public lblTainoSetsumeiMiTorai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiMiTorai"));
            }

            public celTainocolorTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorTorai"));
            }

            public TainocolorTorai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorTorai"));
            }

            public celDummyRed(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyRed"));
            }

            public lblDummyRed(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            }

            public celTainoSetsumeiTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTorai"));
            }

            public lblTainoSetsumeiTorai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTorai"));
            }

            public celTainocolorTaishoGai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorTaishoGai"));
            }

            public TainocolorTaishoGai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorTaishoGai"));
            }

            public celLightSalmon(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celLightSalmon"));
            }

            public lblLightSalmon(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLightSalmon"));
            }

            public celTainoSetsumeiTaishoGai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTaishoGai"));
            }

            public lblTainoSetsumeiTaishoGai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTaishoGai"));
            }

            public celTainocolorKano(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorKano"));
            }

            public TainocolorKano(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            }

            public celDummyGreen(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyGreen"));
            }

            public lblDummyGreen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            }

            public celTainoSetsumeiKano(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKano"));
            }

            public lblTainoSetsumeiKano(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKano"));
            }

            public Modoru(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo_Modoru"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

