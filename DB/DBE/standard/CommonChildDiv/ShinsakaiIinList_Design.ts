/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ShinsakaiIinListクラスのみで継承して使えます。
     */
    export class ShinsakaiIinList_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShinsakaiIinList_Design.myLayout, fieldName);
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
   "fieldName": "ShinsakaiIinList",
   "items": [
    {
     "fieldName": "dgShinsakaiIinList",
     "items": [],
     "controlType": "DataGrid",
     "width": "L",
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
     "gridSetting": {
      "rowHeight": 40,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": true,
      "isShowFilterButton": true,
      "isShowRowState": false,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "選択",
        "dataName": "btnToSelect",
        "toolTip": "",
        "bgColor": 0,
        "width": 50,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "選択",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "btnToSelect"
       },
       {
        "columnName": "審査会委員番号",
        "dataName": "shinsakaiIinNo",
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
        "sortKey": "shinsakaiIinNo"
       },
       {
        "columnName": "氏名",
        "dataName": "shimei",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": false,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "shimei"
       },
       {
        "columnName": "カナ氏名",
        "dataName": "kanaShimei",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": false,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "kanaShimei"
       },
       {
        "columnName": "氏名",
        "dataName": "shimeiAndKanaShimei",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shimeiAndKanaShimei"
       },
       {
        "columnName": "所属機関",
        "dataName": "shozokuKikan",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shozokuKikan"
       },
       {
        "columnName": "性別",
        "dataName": "gender",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "gender"
       },
       {
        "columnName": "資格",
        "dataName": "shikaku",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shikaku"
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
     "dataSource": [],
     "sortOrder": "",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
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
   "title": "審査会委員一覧",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShinsakaiIinList"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbe/db/dbe/ShinsakaiIinList/onLoad"
    }
   ],
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
 "businessId": "DBE",
 "controlName": "ShinsakaiIinList",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

