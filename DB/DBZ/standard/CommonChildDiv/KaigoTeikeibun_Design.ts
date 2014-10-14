/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * KaigoTeikeibunクラスのみで継承して使えます。
     */
    export class KaigoTeikeibun_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoTeikeibun_Design.myLayout, fieldName);
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
   "fieldName": "KaigoTeikeibun",
   "items": [
    {
     "fieldName": "ddlTeikenbunShubetsu",
     "items": [],
     "controlType": "DropDownList",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "ddlTeikenbunShubetsu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "onChange_ddlTeikenbunShubetsu",
     "selectedItem": "",
     "dataSource": [
      {
       "key": "key0",
       "value": "value0"
      },
      {
       "key": "key1",
       "value": "value1"
      }
     ],
     "labelLText": "項目",
     "labelRText": "",
     "labelLWidth": "40",
     "labelRWidth": "S",
     "labelLAlign": 0,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": ""
    },
    {
     "fieldName": "dgTeikeibun",
     "items": [],
     "controlType": "DataGrid",
     "width": "513",
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
     "selectControlID": "dgTeikeibun",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "317",
     "dataSource": [],
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
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
        "columnName": "コード",
        "dataName": "code",
        "toolTip": "",
        "bgColor": 0,
        "width": 55,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "code"
       },
       {
        "columnName": "内容",
        "dataName": "naiyo",
        "toolTip": "",
        "bgColor": 0,
        "width": 400,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "naiyo"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelectBySB_Teikeibun",
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
     "sortOrder": "naiyo",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "btnClose",
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
     "selectControlID": "btnClose",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnClose",
     "text": "閉じる",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "533",
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
   "selectControlID": "KaigoTeikeibun",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "定型文",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KaigoTeikeibun"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbz/db/dbz/KaigoTeikeibunSelector/onLoad"
    },
    {
     "eventName": "onSelectBySB_Teikeibun",
     "requestUrl": "dbz/db/dbz/KaigoTeikeibunSelector/onSelectBySelectButton_dgTeikeibun"
    },
    {
     "eventName": "onChange_ddlTeikenbunShubetsu",
     "requestUrl": "dbz/db/dbz/KaigoTeikeibunSelector/onChange_ddlTeikenbunShubetsu"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "teikeiKbn",
     "value": ""
    },
    {
     "propertyName": "teikeiShubetsu",
     "value": ""
    },
    {
     "propertyName": "teikeibunNaiyo",
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
 "marginLeft": "0",
 "marginRight": "0",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "businessId": "DBZ",
 "controlName": "KaigoTeikeibun",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "teikeiKbn",
   "controlName": "KaigoTeikeibun.teikeiKbn"
  },
  {
   "key": "teikeiShubetsu",
   "controlName": "KaigoTeikeibun.teikeiShubetsu"
  },
  {
   "key": "teikeibunNaiyo",
   "controlName": "KaigoTeikeibun.teikeibunNaiyo"
  }
 ],
 "dialogOkEventNameForDialog": "onSelectBySB_Teikeibun",
 "dialogCancelEventNameForDialog": "onClick_btnClose",
 "canTransferEvent": true,
 "heightForDialog": "Auto"
}        
    }
}

