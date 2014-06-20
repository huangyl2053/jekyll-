/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ChosaKikanDialogクラスのみで継承して使えます。
     */
    export class ChosaKikanDialog_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ChosaKikanDialog_Design.myLayout, fieldName);
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
   "fieldName": "ChosaKikanDialog",
   "items": [
    {
     "fieldName": "btnToMentenanceChosaKikan",
     "items": [],
     "controlType": "Button",
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
     "marginLeft": "S",
     "marginRight": "XS",
     "selectControlID": "btnToMentenanceChosaKikan",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "機関情報を修正する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "dgKikanIchiran",
     "items": [],
     "controlType": "DataGrid",
     "width": "380",
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
     "marginLeft": "S",
     "marginRight": "XS",
     "selectControlID": "dgKikanIchiran",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "S",
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
        "columnName": "機関番号",
        "dataName": "kikanNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kikanNo"
       },
       {
        "columnName": "機関名称",
        "dataName": "kikanMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kikanMeisho"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelect_dgKikanIchiran",
     "onSelectByModifyButton": "",
     "onSelectByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "dgChosainIchiran",
     "items": [],
     "controlType": "DataGrid",
     "width": "300",
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
     "selectControlID": "dgChosainIchiran",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "S",
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
        "columnName": "調査員番号",
        "dataName": "chosainNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
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
        "columnName": "調査員名",
        "dataName": "chosainMeisho",
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
        "sortKey": "chosainMeisho"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelect_dgChosainIchiran",
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
    },
    {
     "fieldName": "btnSelectKikan",
     "items": [],
     "controlType": "Button",
     "width": "120",
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
     "marginRight": "M",
     "selectControlID": "btnSelectKikan",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "CloseOK",
     "text": "選択する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "btnNonSelectReturn",
     "items": [],
     "controlType": "Button",
     "width": "120",
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
     "marginRight": "M",
     "selectControlID": "btnNonSelectReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "CloseCancel",
     "text": "キャンセルする",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
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
   "selectControlID": "ChosaKikanDialog",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "認定調査機関",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ChosaKikanDialog"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbe/db/dbe/ChosaKikanDialog/onLoad"
    },
    {
     "eventName": "CloseOK",
     "requestUrl": "dbe/db/dbe/ChosaKikanDialog/onClick_btnSelectKikan"
    },
    {
     "eventName": "onSelect_dgKikanIchiran",
     "requestUrl": "dbe/db/dbe/ChosaKikanDialog/onSelect_dgKikanIchiran"
    },
    {
     "eventName": "onSelect_dgChosainIchiran",
     "requestUrl": "dbe/db/dbe/ChosaKikanDialog/onSelect_dgChosainIchiran"
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
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
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
 "controlName": "ChosaKikanDialog",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "chosaItakusakiCode",
   "controlName": "ChosaKikanDialog.chosaItakusakiCode"
  },
  {
   "key": "chosaItakusakiName",
   "controlName": "ChosaKikanDialog.chosaItakusakiName"
  },
  {
   "key": "chosainCode",
   "controlName": "ChosaKikanDialog.chosainCode"
  },
  {
   "key": "chosainName",
   "controlName": "ChosaKikanDialog.chosainName"
  }
 ],
 "dialogOkEventNameForDialog": "CloseOK",
 "dialogCancelEventNameForDialog": "CloseCancel"
}        
    }
}

