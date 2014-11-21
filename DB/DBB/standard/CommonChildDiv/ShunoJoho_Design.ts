/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBB {
    /**
     * 自動生成コードです。修正しないでください。
     * ShunoJohoクラスのみで継承して使えます。
     */
    export class ShunoJoho_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShunoJoho_Design.myLayout, fieldName);
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
   "fieldName": "ShunoJoho",
   "items": [
    {
     "fieldName": "txtChoteiNendo",
     "items": [],
     "controlType": "TextBox",
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
     "selectControlID": "txtChoteiNendo_core",
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
     "labelLText": "調定年度",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtFukaNendo",
     "items": [],
     "controlType": "TextBox",
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
     "selectControlID": "txtFukaNendo_core",
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
     "labelLText": "賦課年度",
     "labelRText": "",
     "labelLWidth": "88px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtTsuchiNo",
     "items": [],
     "controlType": "TextBoxCode",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtTsuchiNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
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
     "labelLText": "通知書番号",
     "labelRText": "",
     "labelLWidth": "100px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": 1
    },
    {
     "fieldName": "ddlChoteiNendo",
     "items": [],
     "controlType": "DropDownList",
     "width": "60px",
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
     "selectControlID": "ddlChoteiNendo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "調定年度",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "key0",
     "dataSource": [
      {
       "key": "key0",
       "value": "平26"
      },
      {
       "key": "key1",
       "value": "平25"
      },
      {
       "key": "key2",
       "value": "平24"
      }
     ],
     "isBlankLine": false
    },
    {
     "fieldName": "ddlFukaNendo",
     "items": [],
     "controlType": "DropDownList",
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
     "selectControlID": "ddlFukaNendo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "賦課年度",
     "labelRText": "",
     "labelLWidth": "70px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "key0",
     "dataSource": [
      {
       "key": "key0",
       "value": "平26"
      },
      {
       "key": "key1",
       "value": "平25"
      },
      {
       "key": "key2",
       "value": "平24"
      }
     ],
     "isBlankLine": false
    },
    {
     "fieldName": "btnNendoChange",
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
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnNendoChange",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "年度を変更する",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "ShunoJohoTokucho",
     "items": [
      {
       "fieldName": "dgTokucho",
       "items": [],
       "controlType": "DataGrid",
       "width": "850px",
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
       "selectControlID": "dgTokucho",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "Auto",
       "dataSource": [],
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
        "limitRowCount": 0,
        "selectedRowCount": 0,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "期",
          "dataName": "txtKi",
          "toolTip": "",
          "bgColor": 0,
          "width": 50,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtKi"
         },
         {
          "columnName": "調定額",
          "dataName": "txtChoteiGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtChoteiGaku"
         },
         {
          "columnName": "収入額",
          "dataName": "txtShunyuGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtShunyuGaku"
         },
         {
          "columnName": "収入日",
          "dataName": "txtShunyuYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtShunyuYMD"
         },
         {
          "columnName": "領収日",
          "dataName": "txtRyosyuYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtRyosyuYMD"
         },
         {
          "columnName": "督促手数料",
          "dataName": "txtTokusokuTesuryo",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtTokusokuTesuryo"
         },
         {
          "columnName": "延滞金",
          "dataName": "txtEntaikin",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtEntaikin"
         },
         {
          "columnName": "調定日",
          "dataName": "txtChoteiYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtChoteiYMD"
         },
         {
          "columnName": "納期限",
          "dataName": "txtNokigen",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtNokigen"
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
       "sortOrder": "txtNokigen",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1,
       "gridAction": []
      },
      {
       "fieldName": "txtTokuChoteiGeoukei",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "90px",
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
       "marginRight": "0em",
       "selectControlID": "txtTokuChoteiGeoukei_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": "16",
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
       "labelLText": "合計",
       "labelRText": "",
       "labelLWidth": "50px",
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
       "fieldName": "txtTokuShunyuGeoukei",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "90px",
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
       "selectControlID": "txtTokuShunyuGeoukei_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": "16",
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
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "50px",
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
      }
     ],
     "controlType": "Panel",
     "width": "G10",
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
     "selectControlID": "ShunoJohoTokucho",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "特別徴収",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "ShunoJohoTokucho"
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
     "focusPositionID": "ShunoJoho_panel_body_area",
     "canPost": true
    },
    {
     "fieldName": "ShunoJohoFucho",
     "items": [
      {
       "fieldName": "dgFucho",
       "items": [],
       "controlType": "DataGrid",
       "width": "850px",
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
       "selectControlID": "dgFucho",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "Auto",
       "dataSource": [],
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
        "limitRowCount": 0,
        "selectedRowCount": 0,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "期",
          "dataName": "txtKi",
          "toolTip": "",
          "bgColor": 0,
          "width": 50,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtKi"
         },
         {
          "columnName": "調定額",
          "dataName": "txtChoteiGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtChoteiGaku"
         },
         {
          "columnName": "収入額",
          "dataName": "txtShunyuGaku",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtShunyuGaku"
         },
         {
          "columnName": "収入日",
          "dataName": "txtShunyuYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtShunyuYMD"
         },
         {
          "columnName": "領収日",
          "dataName": "txtRyosyuYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtRyosyuYMD"
         },
         {
          "columnName": "督促手数料",
          "dataName": "txtTokusokuTesuryo",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtTokusokuTesuryo"
         },
         {
          "columnName": "延滞金",
          "dataName": "txtEntaikin",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 2,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtEntaikin"
         },
         {
          "columnName": "調定日",
          "dataName": "txtChoteiYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtChoteiYMD"
         },
         {
          "columnName": "納期限",
          "dataName": "txtNokigen",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "txtNokigen"
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
       "sortOrder": "defaultDataName3",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1,
       "gridAction": []
      },
      {
       "fieldName": "txtFuChoteiGeoukei",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "90px",
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
       "marginRight": "0em",
       "selectControlID": "txtFuChoteiGeoukei_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": "16",
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
       "labelLText": "合計",
       "labelRText": "",
       "labelLWidth": "50px",
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
       "fieldName": "txtFuShunyuGeoukei",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "90px",
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
       "selectControlID": "txtFuShunyuGeoukei_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "maxLength": "16",
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
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "50px",
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
      }
     ],
     "controlType": "Panel",
     "width": "G10",
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
     "selectControlID": "ShunoJohoFucho",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "普通徴収",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "ShunoJohoTokucho"
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
     "focusPositionID": "ShunoJoho_panel_body_area",
     "canPost": true
    }
   ],
   "controlType": "Panel",
   "width": "950px",
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
   "selectControlID": "ShunoJoho",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "収納情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShunoJoho"
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
   "eraseBorder": true,
   "backgroundColor": 0,
   "widthAuto": false,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto",
   "focusPositionID": "createFile",
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
 "businessId": "DBB",
 "controlName": "ShunoJoho",
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
 "publicEventsAlias": []
}        
    }

     export module ShunoJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShunoJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType() + "_" + fieldName;
            }

            public ShunoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtChoteiNendo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiNendo"));
            }

            public txtFukaNendo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaNendo"));
            }

            public txtTsuchiNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTsuchiNo"));
            }

            public ddlChoteiNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChoteiNendo"));
            }

            public ddlFukaNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            }

            public btnNendoChange(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNendoChange"));
            }

            public ShunoJohoTokucho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShunoJohoTokucho"));
            }

            public dgTokucho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTokucho"));
            }

            public txtTokuChoteiGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuChoteiGeoukei"));
            }

            public txtTokuShunyuGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuShunyuGeoukei"));
            }

            public ShunoJohoFucho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShunoJohoFucho"));
            }

            public dgFucho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFucho"));
            }

            public txtFuChoteiGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFuChoteiGeoukei"));
            }

            public txtFuShunyuGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFuShunyuGeoukei"));
            }

        }

     }

}

