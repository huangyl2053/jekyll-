/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HihokenshaInputGuideクラスのみで継承して使えます。
     */
    export class HihokenshaInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HihokenshaInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "HihokenshaInputGuide",
   "items": [
    {
     "fieldName": "HihokenshaFinder",
     "items": [],
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
     "marginRight": 0,
     "relation": [],
     "businessId": "DBZ",
     "controlName": "HihokenshaFinder",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "onClickBtnToSearch": "",
     "onClickBtnToClear": ""
    },
    {
     "fieldName": "SearchResultOfHihokensha",
     "items": [],
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
     "controlName": "SearchResultOfHihokensha",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "onClickBtnToResearch": "",
     "gridSetting": {
      "rowHeight": 50,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "header": {
       "combineColumns": [],
       "frozenColumn": ""
      },
      "columns": [
       {
        "columnName": "",
        "dataName": "btnToDecide",
        "width": 50,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "確定",
         "onClick": "",
         "imageFileUrl": ""
        },
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "btnToDecide"
       },
       {
        "columnName": "被保番号",
        "dataName": "hihokenshaNo",
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaNo"
       },
       {
        "columnName": "識別コード",
        "dataName": "shikibetsuCode",
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shikibetsuCode"
       },
       {
        "columnName": "被保険者区分",
        "dataName": "hihokenshaKubun",
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaKubun"
       },
       {
        "columnName": "氏名",
        "dataName": "shimei",
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
        "dataName": "kanaShimsei",
        "width": 150,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "kanaShimsei"
       },
       {
        "columnName": "氏名",
        "dataName": "shimeiAndKanaShimsei",
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kanaShimsei"
       },
       {
        "columnName": "性別",
        "dataName": "gender",
        "width": 50,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "gender"
       },
       {
        "columnName": "生年月日",
        "dataName": "birthDay",
        "width": 110,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 3
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "birthDay"
       },
       {
        "columnName": "郵便番号",
        "dataName": "yubinNo",
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "yubinNo"
       },
       {
        "columnName": "住所",
        "dataName": "jusho",
        "width": 300,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "jusho"
       },
       {
        "columnName": "個人番号",
        "dataName": "kojinNo",
        "width": 120,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "kojinNo"
       },
       {
        "columnName": "住民種別",
        "dataName": "juminShubetsu",
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "juminShubetsu"
       },
       {
        "columnName": "世帯コード",
        "dataName": "setaiCode",
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "setaiCode"
       }
      ]
     }
    }
   ],
   "controlType": "Panel",
   "width": "1000",
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
   "title": "被保険者入力補助",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "HihokenshaInputGuide"
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
   "widthAuto": false,
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
 "controlName": "HihokenshaInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

