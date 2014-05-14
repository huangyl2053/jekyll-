/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HokenshaInputGuideクラスのみで継承して使えます。
     */
    export class HokenshaInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HokenshaInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "HokenshaInputGuide",
   "items": [
    {
     "fieldName": "ddlHokenshaKenCode",
     "items": [],
     "controlType": "DropDownList",
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
     "onChange": "",
     "selectedItem": "20",
     "dataSource": [
      {
       "key": "20",
       "value": "20 長野"
      },
      {
       "key": "47",
       "value": "47 沖縄"
      }
     ],
     "required": false,
     "labelLText": "県コード",
     "labelRText": "",
     "labelLWidth": "60",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "text": ""
    },
    {
     "fieldName": "btnSearchGaitoHokensha",
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
     "onClick": "onClick_btnSearchGaitoHokensha",
     "text": "該当する保険者を表示する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    },
    {
     "fieldName": "SearchResultHokensha",
     "items": [
      {
       "fieldName": "dgSearchResultHokensha",
       "items": [],
       "controlType": "DataGrid",
       "width": "360",
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
       "dataSource": [],
       "gridSetting": {
        "rowHeight": 25,
        "isMultiSelectable": false,
        "isShowFooter": true,
        "isShowFilter": false,
        "isShowFilterButton": false,
        "isShowRowState": false,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "",
          "dataName": "select",
          "toolTip": "",
          "bgColor": 0,
          "width": 40,
          "visible": true,
          "cellType": 8,
          "cellDetails": {
           "cellType": 8,
           "text": "■",
           "onClick": "onClick_select",
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": ""
          },
          "align": 1,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "select"
         },
         {
          "columnName": "保険者番号",
          "dataName": "hokenshaNo",
          "toolTip": "",
          "bgColor": 0,
          "width": 0,
          "visible": false,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "hokenshaNo"
         },
         {
          "columnName": "保険者名称",
          "dataName": "hokenshaMeisho",
          "toolTip": "",
          "bgColor": 0,
          "width": 0,
          "visible": false,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "hokenshaMeisho"
         },
         {
          "columnName": "保険者",
          "dataName": "hokensha",
          "toolTip": "",
          "bgColor": 0,
          "width": 300,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "hokensha"
         }
        ]
       },
       "height": "S",
       "onSort": "",
       "onSelect": "",
       "onSelectByDblClick": "",
       "onOnlyRow": "",
       "onNoRow": "",
       "onMultiRows": "",
       "sortOrder": "hokensha",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1
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
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "onLoad": "",
     "title": "保険者一覧",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchResultHokensha"
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
     "backgroundColor": 0,
     "widthAuto": true,
     "isGroupBox": false
    },
    {
     "fieldName": "btnHokenshaReturn",
     "items": [],
     "controlType": "Button",
     "width": "80",
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
     "onClick": "onClick_btnHokenshaReturn",
     "text": "キャンセル",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    }
   ],
   "controlType": "Panel",
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
   "onLoad": "",
   "title": "保険者入力ガイド",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "HokenshaInputGuide"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnSearchGaitoHokensha",
     "requestUrl": "dbz/db/dbz/HokenshaInputGuide/onClick_btnSearchGaitoHokensha"
    },
    {
     "eventName": "onClick_select",
     "requestUrl": "dbz/db/dbz/HokenshaInputGuide/onClick_select"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "hokenshaNo",
     "value": ""
    },
    {
     "propertyName": "hokenshaMeisho",
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
   "widthAuto": true,
   "isGroupBox": false
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
 "relation": [],
 "businessId": "DBZ",
 "controlName": "HokenshaInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "hokenshaNo",
   "controlName": "HokenshaInputGuide.hokenshaNo"
  },
  {
   "key": "hokenshaMeisho",
   "controlName": "HokenshaInputGuide.hokenshaMeisho"
  }
 ],
 "dialogOkEventNameForDialog": "onClick_select",
 "dialogCancelEventNameForDialog": "onClick_btnHokenshaReturn"
}        
    }
}

