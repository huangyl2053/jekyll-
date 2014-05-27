/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ShozokuChosainListComクラスのみで継承して使えます。
     */
    export class ShozokuChosainListCom_Design extends Uz.CompositeControl {
    
        public get height() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["height"];
        }
        
        public set height(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["height"] = value;
            } else {
                this.layout.items[0]["height"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSort() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSort"];
        }
        
        public set onSort(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSort"] = value;
            } else {
                this.layout.items[0]["onSort"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelect"];
        }
        
        public set onSelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelect"] = value;
            } else {
                this.layout.items[0]["onSelect"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelectByDblClick"];
        }
        
        public set onSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onOnlyRow() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onOnlyRow"];
        }
        
        public set onOnlyRow(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onOnlyRow"] = value;
            } else {
                this.layout.items[0]["onOnlyRow"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onNoRow() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onNoRow"];
        }
        
        public set onNoRow(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onNoRow"] = value;
            } else {
                this.layout.items[0]["onNoRow"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onMultiRows() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onMultiRows"];
        }
        
        public set onMultiRows(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onMultiRows"] = value;
            } else {
                this.layout.items[0]["onMultiRows"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShozokuChosainListCom_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("height");
            Uz.JSControlUtil.registProperty("onSort");
            Uz.JSControlUtil.registProperty("onSelect");
            Uz.JSControlUtil.registProperty("onSelectByDblClick");
            Uz.JSControlUtil.registProperty("onOnlyRow");
            Uz.JSControlUtil.registProperty("onNoRow");
            Uz.JSControlUtil.registProperty("onMultiRows");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "dgShozokuChosainList",
   "items": [],
   "controlType": "DataGrid",
   "width": "460",
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
    "rowHeight": 25,
    "isMultiSelectable": false,
    "isShowFooter": true,
    "isShowFilter": false,
    "isShowFilterButton": false,
    "isShowRowState": false,
    "header": {
     "combineColumns": [],
     "frozenColumn": "",
     "headerHeight": 1
    },
    "columns": [
     {
      "columnName": "番号",
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
     },
     {
      "columnName": "割付済<br>人数",
      "dataName": "waritsukeNum",
      "toolTip": "",
      "bgColor": 0,
      "width": 60,
      "visible": true,
      "cellType": 0,
      "cellDetails": {
       "cellType": 0
      },
      "align": 2,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "waritsukeNum"
     },
     {
      "columnName": "地区",
      "dataName": "chiku",
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
      "sortKey": "chiku"
     },
     {
      "columnName": "調査委託先番号",
      "dataName": "chousaItakusakiNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chousaItakusakiNo"
     }
    ]
   },
   "height": "181",
   "onSort": "",
   "onSelect": "",
   "onSelectByDblClick": "",
   "onOnlyRow": "",
   "onNoRow": "",
   "onMultiRows": "",
   "dataSource": [],
   "sortOrder": "調査員コード",
   "isAscending": true,
   "filterList": [],
   "activeRowId": -1
  }
 ],
 "controlType": "CompositeControl",
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
 "marginLeft": "XS",
 "marginRight": "XS",
 "relation": [],
 "businessId": "DBE",
 "controlName": "ShozokuChosainListCom",
 "originalProperty": [
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "height",
   "newPropertyName": "height"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onSort",
   "newPropertyName": "onSort"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onSelect",
   "newPropertyName": "onSelect"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "onSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onOnlyRow",
   "newPropertyName": "onOnlyRow"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onNoRow",
   "newPropertyName": "onNoRow"
  },
  {
   "publicChildFieldName": "dgShozokuChosainList",
   "publicChildProperty": "onMultiRows",
   "newPropertyName": "onMultiRows"
  }
 ]
}        
    }
}

