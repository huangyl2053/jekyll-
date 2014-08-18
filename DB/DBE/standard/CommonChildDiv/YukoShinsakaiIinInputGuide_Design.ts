/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * YukoShinsakaiIinInputGuideクラスのみで継承して使えます。
     */
    export class YukoShinsakaiIinInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, YukoShinsakaiIinInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "YukoShinsakaiIinInputGuide",
   "items": [
    {
     "fieldName": "dgYukoShinsakaiIin",
     "items": [],
     "controlType": "DataGrid",
     "width": "930",
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
     "selectControlID": "dgYukoShinsakaiIin",
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
        "columnName": "委員コード",
        "dataName": "shinsakaiIinCode",
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
        "sortKey": ""
       },
       {
        "columnName": "開始日",
        "dataName": "kaishiDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 7,
        "cellDetails": {
         "cellType": 7,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": "",
         "isSetValueToToolTip": false,
         "readOnly": true
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "事業者コード",
        "dataName": "jigyoshaCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "事業者名称",
        "dataName": "jigyoshaMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "事業者",
        "dataName": "jigyosha",
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
        "sortKey": ""
       },
       {
        "columnName": "氏名",
        "dataName": "shimei",
        "toolTip": "",
        "bgColor": 0,
        "width": 180,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "性別",
        "dataName": "gender",
        "toolTip": "",
        "bgColor": 0,
        "width": 40,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "住所",
        "dataName": "jusho",
        "toolTip": "",
        "bgColor": 0,
        "width": 350,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "電話番号",
        "dataName": "telNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 140,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
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
     "onSelectBySelectButton": "onSelectBySelectButton_dgYukoShinsakaiIin",
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
   "width": "950",
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
   "selectControlID": "YukoShinsakaiIinInputGuide",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "有効審査会委員入力ガイド",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "YukoShinsakaiIinInputGuide"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbe/db/dbe/YukoShinsakaiIinInputGuide/onLoad"
    },
    {
     "eventName": "onSelectBySelectButton_dgYukoShinsakaiIin",
     "requestUrl": "dbe/db/dbe/YukoShinsakaiIinInputGuide/onSelectBySelectButton_dgYukoShinsakaiIin"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "iinCode",
     "value": ""
    },
    {
     "propertyName": "iinMeisho",
     "value": ""
    },
    {
     "propertyName": "shozokuKikanCode",
     "value": ""
    },
    {
     "propertyName": "shozokuKikanMeisho",
     "value": ""
    },
    {
     "propertyName": "shozokuKikan",
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
 "controlName": "YukoShinsakaiIinInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "iinCode",
   "controlName": "YukoShinsakaiIinInputGuide.iinCode"
  },
  {
   "key": "iinMeisho",
   "controlName": "YukoShinsakaiIinInputGuide.iinMeisho"
  },
  {
   "key": "shozokuKikanCode",
   "controlName": "YukoShinsakaiIinInputGuide.shozokuKikanCode"
  },
  {
   "key": "shozokuKikanMeisho",
   "controlName": "YukoShinsakaiIinInputGuide.shozokuKikanMeisho"
  },
  {
   "key": "shozokuKikan",
   "controlName": "YukoShinsakaiIinInputGuide.shozokuKikan"
  }
 ],
 "dialogOkEventNameForDialog": "onSelectBySelectButton_dgYukoShinsakaiIin",
 "dialogCancelEventNameForDialog": "onClick_btnClose",
 "canTransferEvent": true,
 "heightForDialog": "Auto"
}        
    }
}

