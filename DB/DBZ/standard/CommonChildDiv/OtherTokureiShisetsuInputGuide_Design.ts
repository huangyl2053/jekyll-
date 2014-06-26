/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * OtherTokureiShisetsuInputGuideクラスのみで継承して使えます。
     */
    export class OtherTokureiShisetsuInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, OtherTokureiShisetsuInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "OtherTokureiShisetsuInputGuide",
   "items": [
    {
     "fieldName": "radKannaiKubun",
     "items": [],
     "controlType": "RadioButton",
     "width": "230",
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
     "selectControlID": "radKannaiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onChange": "",
     "selectedItem": "keyAll",
     "dataSource": [
      {
       "key": "keyAll",
       "value": "全て"
      },
      {
       "key": "keyKannai",
       "value": "管内"
      },
      {
       "key": "keyKangai",
       "value": "管外"
      }
     ],
     "required": false,
     "onClick": "",
     "newLineItemNumber": 3,
     "spaceSize": "M",
     "labelLText": "施設種類",
     "labelLWidth": "70",
     "labelLAlign": 2,
     "disabledItem": [],
     "icon": []
    },
    {
     "fieldName": "btnSearchOtherShisetsu",
     "items": [],
     "controlType": "Button",
     "width": "260",
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
     "selectControlID": "btnSearchOtherShisetsu",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnSearchOtherShisetsu",
     "icon": 0,
     "text": "該当する施設を表示する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "lblOtherShisetsuShurui",
     "items": [],
     "controlType": "Label",
     "width": "100",
     "visible": true,
     "displayNone": true,
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
     "selectControlID": "lblOtherShisetsuShurui",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "isPrivateInfo": false,
     "text": "keyKannai",
     "decorationClass": "",
     "align": 2
    },
    {
     "fieldName": "SearchResultOtherShisetsu",
     "items": [
      {
       "fieldName": "dgSearchResultOtherTokureiShisetsu",
       "items": [],
       "controlType": "DataGrid",
       "width": "710",
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
       "selectControlID": "dgSearchResultOtherTokureiShisetsu",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "S",
       "dataSource": [],
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
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
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
          "sortKey": "jigyoshaCode"
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
          "sortKey": "jigyoshaMeisho"
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
          "sortKey": "jigyosha"
         },
         {
          "columnName": "住所",
          "dataName": "jusho",
          "toolTip": "",
          "bgColor": 0,
          "width": 350,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "jusho"
         }
        ]
       },
       "onSort": "",
       "onSelect": "",
       "onSelectByDblClick": "",
       "onSelectBySelectButton": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
       "onSelectByModifyButton": "",
       "onSelectByDeleteButton": "",
       "onOnlyRow": "",
       "onNoRow": "",
       "onMultiRows": "",
       "sortOrder": "jusho",
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
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "SearchResultOtherShisetsu",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "その他特例施設一覧",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchResultOtherShisetsu"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "btnOtherShisetsuReturn",
     "items": [],
     "controlType": "Button",
     "width": "260",
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
     "selectControlID": "btnOtherShisetsuReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnOtherShisetsuReturn",
     "icon": 0,
     "text": "その他特例施設入力ガイドを閉じる",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
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
   "float": 0,
   "toolTip": "",
   "authorityMode": 0,
   "marginLeft": "XS",
   "marginRight": "XS",
   "selectControlID": "OtherTokureiShisetsuInputGuide",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "その他特例施設入力ガイド",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "OtherTokureiShisetsuInputGuide"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onLoad"
    },
    {
     "eventName": "onClick_btnSearchOtherShisetsu",
     "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onClick_btnSearchOtherShisetsu"
    },
    {
     "eventName": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
     "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "shisetsuCode",
     "value": ""
    },
    {
     "propertyName": "shisetsuMeisho",
     "value": ""
    }
   ],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": false,
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
 "businessId": "DBZ",
 "controlName": "OtherTokureiShisetsuInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "otherShisetsuCode",
   "controlName": "OtherTokureiShisetsuInputGuide.shisetsuCode"
  },
  {
   "key": "otherShisetsuMeisho",
   "controlName": "OtherTokureiShisetsuInputGuide.shisetsuMeisho"
  },
  {
   "key": "selectRadioButtonKey",
   "controlName": "lblOtherShisetsuShurui"
  }
 ],
 "dialogOkEventNameForDialog": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
 "dialogCancelEventNameForDialog": "onClick_btnOtherShisetsuReturn",
 "canTransferEvent": true,
 "heightForDialog": "M"
}        
    }
}

