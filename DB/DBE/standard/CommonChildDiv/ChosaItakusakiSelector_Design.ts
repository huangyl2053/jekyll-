/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ChosaItakusakiSelectorクラスのみで継承して使えます。
     */
    export class ChosaItakusakiSelector_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ChosaItakusakiSelector_Design.myLayout, fieldName);
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
   "fieldName": "ChosaItakusakiSelector",
   "items": [
    {
     "fieldName": "ChosaItakusaki",
     "items": [
      {
       "fieldName": "ChosaItakusakiList",
       "items": [
        {
         "fieldName": "btnToMentenanceChosaKikan",
         "items": [],
         "controlType": "Button",
         "width": "200",
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
         "selectControlID": "btnToMentenanceChosaKikan",
         "helpMessageID": "",
         "jpControlName": "",
         "onClick": "",
         "text": "調査委託先情報を修正する",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
         "icon": 0,
         "heightTextBoxMatches": false
        },
        {
         "fieldName": "dgChosaItakusakiList",
         "items": [],
         "controlType": "DataGrid",
         "width": "370",
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
         "selectControlID": "dgChosaItakusakiList",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "220",
         "gridSetting": {
          "rowHeight": 25,
          "isMultiSelectable": false,
          "isShowHeader": true,
          "isShowFooter": true,
          "isShowFilter": true,
          "isShowFilterButton": true,
          "isShowRowState": false,
          "isShowSelectButtonColumn": true,
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
            "columnName": "番号",
            "dataName": "chosaItakusakiNo",
            "toolTip": "",
            "bgColor": 0,
            "width": 82,
            "visible": true,
            "cellType": 0,
            "cellDetails": {
             "cellType": 0
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "chosaItakusakiNo"
           },
           {
            "columnName": "名称",
            "dataName": "chosaItakusakiName",
            "toolTip": "",
            "bgColor": 0,
            "width": 230,
            "visible": true,
            "cellType": 0,
            "cellDetails": {
             "cellType": 0
            },
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "chosaItakusakiName"
           }
          ]
         },
         "onSort": "",
         "onSelect": "onSelect_dgChosaItakusakiList",
         "onSelectByDblClick": "onSelectByDC_ChosaItakusaki",
         "onSelectBySelectButton": "onSelectBySB_ChosaItakusaki",
         "onSelectByModifyButton": "",
         "onSelectByDeleteButton": "",
         "onOnlyRow": "",
         "onNoRow": "",
         "onMultiRows": "",
         "dataSource": [],
         "sortOrder": "chosaItakusakiName",
         "isAscending": true,
         "filterList": [],
         "activeRowId": -1
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
       "marginLeft": "0",
       "marginRight": "0",
       "selectControlID": "ChosaItakusakiList",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "",
       "marginTop": "0",
       "marginBottom": "0",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "ChosaItakusakiList"
        }
       ],
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
       "height": "Auto"
      },
      {
       "fieldName": "Chosain",
       "items": [
        {
         "fieldName": "spaChosain",
         "items": [],
         "controlType": "Space",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "spaChosain",
         "helpMessageID": "",
         "jpControlName": "",
         "spaceCount": 1
        },
        {
         "fieldName": "ChosainList",
         "items": [
          {
           "fieldName": "dgChosainList",
           "items": [],
           "controlType": "DataGrid",
           "width": "290",
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
           "selectControlID": "dgChosainList",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "height": "190",
           "gridSetting": {
            "rowHeight": 25,
            "isMultiSelectable": false,
            "isShowHeader": true,
            "isShowFooter": true,
            "isShowFilter": true,
            "isShowFilterButton": true,
            "isShowRowState": false,
            "isShowSelectButtonColumn": true,
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
              "columnName": "番号",
              "dataName": "chosainNo",
              "toolTip": "",
              "bgColor": 0,
              "width": 82,
              "visible": true,
              "cellType": 0,
              "cellDetails": {
               "cellType": 0
              },
              "align": 1,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "chosainNo"
             },
             {
              "columnName": "氏名",
              "dataName": "chosainName",
              "toolTip": "",
              "bgColor": 0,
              "width": 150,
              "visible": true,
              "cellType": 0,
              "cellDetails": {
               "cellType": 0
              },
              "align": 0,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "chosainName"
             }
            ]
           },
           "onSort": "",
           "onSelect": "",
           "onSelectByDblClick": "onSelectByDC_Chosain",
           "onSelectBySelectButton": "onSelectBySB_Chosain",
           "onSelectByModifyButton": "",
           "onSelectByDeleteButton": "",
           "onOnlyRow": "",
           "onNoRow": "",
           "onMultiRows": "",
           "dataSource": [],
           "sortOrder": "chosainMeisho",
           "isAscending": true,
           "filterList": [],
           "activeRowId": -1
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
         "selectControlID": "ChosainList",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "所属調査員",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "ChosainList"
          },
          {
           "postParameterPanelNames": "ChosaItakusakiList"
          }
         ],
         "requestSettings": [
          {
           "eventName": "onLoad",
           "requestUrl": ""
          },
          {
           "eventName": "onSelect_dgChosaItakusakiList",
           "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onSelect_dgChosaItakusakiList"
          }
         ],
         "hiddenInput": [],
         "onOpen": "",
         "onClose": "",
         "session": {},
         "eraseBorder": false,
         "backgroundColor": 0,
         "widthAuto": true,
         "panelDisplay": 1,
         "isGroupBox": false,
         "readOnly": false,
         "height": "Auto"
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
       "marginRight": "0",
       "selectControlID": "Chosain",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "",
       "marginTop": "0",
       "marginBottom": "0",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "Chosain"
        }
       ],
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
       "height": "Auto"
      }
     ],
     "controlType": "Panel",
     "width": "720",
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
     "selectControlID": "ChosaItakusaki",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "調査委託先",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "ChosaItakusaki"
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "SelectedContents",
     "items": [
      {
       "fieldName": "txtChosaItakusakiCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "82",
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
       "selectControlID": "txtChosaItakusakiCode_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "text": "",
       "required": false,
       "maxLength": "10",
       "minLength": "10",
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
       "suggest": [],
       "value": "",
       "labelLText": "調査委託先",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtChosaItakusakiName",
       "items": [],
       "controlType": "TextBox",
       "width": "250",
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
       "marginRight": "XS",
       "selectControlID": "txtChosaItakusakiName_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "text": "",
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
       "suggest": [],
       "value": "",
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "txtChosainCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "65",
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
       "selectControlID": "txtChosainCode_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "text": "",
       "required": false,
       "maxLength": "8",
       "minLength": "8",
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
       "suggest": [],
       "value": "",
       "labelLText": "調査員",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "8"
      },
      {
       "fieldName": "txtChosainName",
       "items": [],
       "controlType": "TextBox",
       "width": "150",
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
       "marginRight": "XS",
       "selectControlID": "txtChosainName_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "text": "",
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
       "suggest": [],
       "value": "",
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "decorationClass": "",
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
     "width": "720",
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
     "selectControlID": "SelectedContents",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "選択内容",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SelectedContents"
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "btnSelectAndClose",
     "items": [],
     "controlType": "Button",
     "width": "S",
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
     "marginRight": "S",
     "selectControlID": "btnSelectAndClose",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnSelectAndClose",
     "text": "確定",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "btnNonSelectReturn",
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
     "selectControlID": "btnNonSelectReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnNonSelectReturn",
     "text": "取消",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "G8",
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
   "selectControlID": "ChosaItakusakiSelector",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "調査委託先選択",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ChosaItakusakiSelector"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onLoad"
    },
    {
     "eventName": "onSelectByDC_ChosaItakusaki",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onSelectByDC_ChosaItakusaki"
    },
    {
     "eventName": "onSelectBySB_ChosaItakusaki",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onSelectBySB_ChosaItakusaki"
    },
    {
     "eventName": "onSelectByDC_Chosain",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onSelectByDC_Chosain"
    },
    {
     "eventName": "onSelectBySB_Chosain",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onSelectBySB_Chosain"
    },
    {
     "eventName": "onClick_btnSelectAndClose",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onClick_btnSelectAndClose"
    },
    {
     "eventName": "onClick_btnNonSelectReturn",
     "requestUrl": "dbe/db/dbe/ChosaItakusakiSelector/onClick_btnNonSelectReturn"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "chosaItakusakiCode",
     "value": ""
    },
    {
     "propertyName": "chosaItakusakiName",
     "value": ""
    },
    {
     "propertyName": "chosainCode",
     "value": ""
    },
    {
     "propertyName": "chosainName",
     "value": ""
    }
   ],
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
 "businessId": "DBE",
 "controlName": "ChosaItakusakiSelector",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "chosaItakusakiCode",
   "controlName": "ChosaItakusakiSelector.chosaItakusakiCode"
  },
  {
   "key": "chosaItakusakiName",
   "controlName": "ChosaItakusakiSelector.chosaItakusakiName"
  },
  {
   "key": "chosainCode",
   "controlName": "ChosaItakusakiSelector.chosainCode"
  },
  {
   "key": "chosainName",
   "controlName": "ChosaItakusakiSelector.chosainName"
  }
 ],
 "dialogOkEventNameForDialog": "onClick_btnSelectAndClose",
 "dialogCancelEventNameForDialog": "onClick_btnNonSelectReturn",
 "canTransferEvent": true,
 "heightForDialog": "M"
}        
    }
}

