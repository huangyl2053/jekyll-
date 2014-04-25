/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * SearchResultOfHihokenshaクラスのみで継承して使えます。
     */
    export class SearchResultOfHihokensha_Design extends Uz.CommonChildDiv {
    
        public get onClickBtnToResearch() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onClick"];
        }
        
        public set onClickBtnToResearch(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[1]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get gridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"];
        }
        
        public set gridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[0]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, SearchResultOfHihokensha_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onClickBtnToResearch");
            Uz.JSControlUtil.registProperty("gridSetting");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onClickBtnToResearch"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["gridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "SearchResultOfHihokensha",
   "items": [
    {
     "fieldName": "dgSearchResult",
     "items": [],
     "controlType": "DataGrid",
     "width": "980",
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
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "birthDay"
       },
       {
        "columnName": "郵便番号",
        "dataName": "yubinNo",
        "width": 110,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "yubinNo"
       },
       {
        "columnName": "住所",
        "dataName": "jusho",
        "width": 300,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "jusho"
       },
       {
        "columnName": "住所",
        "dataName": "yubinNoAndJusho",
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
     },
     "height": "S",
     "onSort": "",
     "onSelect": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "juminShubetsu",
     "isAscending": true,
     "filterList": [],
     "clickedRowId": -1
    },
    {
     "fieldName": "btnToResearch",
     "items": [],
     "controlType": "Button",
     "width": "M",
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
     "onClick": "",
     "text": "再検索する",
     "imageFileUrl": ""
    }
   ],
   "controlType": "Panel",
   "width": "M",
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
   "onLoad": "",
   "title": "検索結果",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "SearchResultOfHihokensha"
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
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
   "backgroundColor": 0,
   "widthAuto": true
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
 "controlName": "SearchResultOfHihokensha",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnToResearch",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBtnToResearch"
  },
  {
   "publicChildFieldName": "dgSearchResult",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "gridSetting"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

