/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * NinteichosaIraiListForByHandComクラスのみで継承して使えます。
     */
    export class NinteichosaIraiListForByHandCom_Design extends Uz.CompositeControl {
    
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
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, NinteichosaIraiListForByHandCom_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onSort");
            Uz.JSControlUtil.registProperty("onSelect");
            Uz.JSControlUtil.registProperty("onSelectByDblClick");
            Uz.JSControlUtil.registProperty("onOnlyRow");
            Uz.JSControlUtil.registProperty("onNoRow");
            Uz.JSControlUtil.registProperty("onMultiRows");
            Uz.JSControlUtil.registProperty("height");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "dgNinteichosaIraiListForByHand",
   "items": [],
   "controlType": "DataGrid",
   "width": "1000",
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
   "gridSetting": {
    "rowHeight": 40,
    "isMultiSelectable": false,
    "isShowFooter": true,
    "isShowFilter": false,
    "isShowFilterButton": true,
    "isShowRowState": false,
    "header": {
     "combineColumns": [
      {
       "combineColumnName": "被保険者",
       "combineItem": [
        "hihokenshaNo",
        "shimei",
        "kanaShimei",
        "shimeiWithKana"
       ]
      },
      {
       "combineColumnName": "認定",
       "combineItem": [
        "ninteiShinseiKubun",
        "ninteiShinseiDate"
       ]
      },
      {
       "combineColumnName": "調査依頼",
       "combineItem": [
        "chosaIraiKubun",
        "chosaIraiDate",
        "chosaKigenDate",
        "iraishoHakkoDate"
       ]
      },
      {
       "combineColumnName": "今回",
       "combineItem": [
        "chosaItakusakiNo",
        "chosaItakusakiName",
        "chosainNo",
        "chosainName"
       ]
      },
      {
       "combineColumnName": "前回",
       "combineItem": [
        "chosaItakusakiNo1TA",
        "chosaItakusakiName1TA",
        "chosainNo1TA",
        "chosainName1TA"
       ]
      },
      {
       "combineColumnName": "前々回",
       "combineItem": [
        "chosaItakusakiNo2TA",
        "chosaItakusakiName2TA",
        "chosainNo2TA",
        "chosainName2TA"
       ]
      },
      {
       "combineColumnName": "督促",
       "combineItem": [
        "tokusokuDate",
        "tokusokuCount"
       ]
      },
      {
       "combineColumnName": "被保険者",
       "combineItem": [
        "yubinNo",
        "jusho",
        "nyushoShisetsu"
       ]
      }
     ],
     "frozenColumn": "",
     "headerHeight": 1
    },
    "columns": [
     {
      "columnName": "調査済みフラグ",
      "dataName": "chosaKanryoFlag",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 2,
      "cellDetails": {
       "cellType": 2,
       "disabled": false
      },
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosaKanryoFlag"
     },
     {
      "columnName": "調査<br>状況",
      "dataName": "chosaJokyo",
      "toolTip": "",
      "bgColor": 0,
      "width": 75,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaJokyo"
     },
     {
      "columnName": "詳細",
      "dataName": "btnToShowDetail",
      "toolTip": "",
      "bgColor": 0,
      "width": 60,
      "visible": true,
      "cellType": 8,
      "cellDetails": {
       "cellType": 8,
       "text": "詳細",
       "onClick": "",
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": ""
      },
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "btnToShowDetail"
     },
     {
      "columnName": "保険者番号",
      "dataName": "hokenshaNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 75,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 1,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "hokenshaNo"
     },
     {
      "columnName": "市町村",
      "dataName": "shichoson",
      "toolTip": "",
      "bgColor": 0,
      "width": 75,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "shichoson"
     },
     {
      "columnName": "支所コード",
      "dataName": "shishoCode",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 1,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "shishoCode"
     },
     {
      "columnName": "支所",
      "dataName": "shoshoName",
      "toolTip": "",
      "bgColor": 0,
      "width": 75,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "shoshoName"
     },
     {
      "columnName": "被保番号",
      "dataName": "hihokenshaNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 100,
      "visible": true,
      "cellType": 0,
      "cellDetails": "\"{\\\"cellType\\\":0}\"",
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "hihokenshaNo"
     },
     {
      "columnName": "氏名",
      "dataName": "shimei",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": "\"{\\\"cellType\\\":0}\"",
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
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "kanaShimei"
     },
     {
      "columnName": "氏名",
      "dataName": "shimeiWithKana",
      "toolTip": "",
      "bgColor": 0,
      "width": 120,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "shimeiWithKana"
     },
     {
      "columnName": "申請区分",
      "dataName": "ninteiShinseiKubun",
      "toolTip": "",
      "bgColor": 0,
      "width": 80,
      "visible": true,
      "cellType": 0,
      "cellDetails": {
       "cellType": 0
      },
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "ninteiShinseiKubun"
     },
     {
      "columnName": "申請日",
      "dataName": "ninteiShinseiDate",
      "toolTip": "",
      "bgColor": 0,
      "width": 81,
      "visible": true,
      "cellType": 7,
      "cellDetails": {
       "cellType": 7,
       "ymdKubun": 2,
       "displayFormat": 0,
       "onChange": ""
      },
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "ninteiShinseiDate"
     },
     {
      "columnName": "依頼区分",
      "dataName": "chosaIraiKubun",
      "toolTip": "",
      "bgColor": 0,
      "width": 80,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaIraiKubun"
     },
     {
      "columnName": "依頼日",
      "dataName": "chosaIraiDate",
      "toolTip": "",
      "bgColor": 0,
      "width": 81,
      "visible": true,
      "cellType": 7,
      "cellDetails": {
       "cellType": 7,
       "ymdKubun": 2,
       "displayFormat": 0,
       "onChange": ""
      },
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaIraiDate"
     },
     {
      "columnName": "期限日",
      "dataName": "chosaKigenDate",
      "toolTip": "",
      "bgColor": 0,
      "width": 81,
      "visible": true,
      "cellType": 7,
      "cellDetails": {
       "cellType": 7,
       "ymdKubun": 2,
       "displayFormat": 0,
       "onChange": ""
      },
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaKigenDate"
     },
     {
      "columnName": "依頼書<br>発行日",
      "dataName": "iraishoHakkoDate",
      "toolTip": "",
      "bgColor": 0,
      "width": 81,
      "visible": true,
      "cellType": 7,
      "cellDetails": {
       "cellType": 7,
       "ymdKubun": 2,
       "displayFormat": 0,
       "onChange": ""
      },
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "iraishoHakkoDate"
     },
     {
      "columnName": "調査委託先コード",
      "dataName": "chosaItakusakiNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiNo"
     },
     {
      "columnName": "調査委託先",
      "dataName": "chosaItakusakiName",
      "toolTip": "",
      "bgColor": 0,
      "width": 120,
      "visible": true,
      "cellType": 0,
      "cellDetails": "\"{\\\"cellType\\\":0}\"",
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiName"
     },
     {
      "columnName": "調査員コード",
      "dataName": "chosainNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosainNo"
     },
     {
      "columnName": "調査員",
      "dataName": "chosainName",
      "toolTip": "",
      "bgColor": 0,
      "width": 90,
      "visible": true,
      "cellType": 0,
      "cellDetails": "null",
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosainName"
     },
     {
      "columnName": "調査委託先コード",
      "dataName": "chosaItakusakiNo1TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiNo1TA"
     },
     {
      "columnName": "調査委託先",
      "dataName": "chosaItakusakiName1TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 120,
      "visible": true,
      "cellType": 0,
      "cellDetails": "\"null\"",
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiName1TA"
     },
     {
      "columnName": "調査員コード",
      "dataName": "chosainNo1TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosainNo1TA"
     },
     {
      "columnName": "調査員",
      "dataName": "chosainName1TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 90,
      "visible": true,
      "cellType": 0,
      "cellDetails": "\"null\"",
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosainName1TA"
     },
     {
      "columnName": "調査委託先コード",
      "dataName": "chosaItakusakiNo2TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiNo2TA"
     },
     {
      "columnName": "調査委託先",
      "dataName": "chosaItakusakiName2TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 120,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "chosaItakusakiName2TA"
     },
     {
      "columnName": "調査員コード",
      "dataName": "chosainNo2TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosainNo2TA"
     },
     {
      "columnName": "調査員",
      "dataName": "chosainName2TA",
      "toolTip": "",
      "bgColor": 0,
      "width": 90,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": false,
      "isPrivateInfo": false,
      "sortKey": "chosainName2TA"
     },
     {
      "columnName": "督促日",
      "dataName": "tokusokuDate",
      "toolTip": "",
      "bgColor": 0,
      "width": 81,
      "visible": true,
      "cellType": 7,
      "cellDetails": {
       "cellType": 7,
       "ymdKubun": 2,
       "displayFormat": 0,
       "onChange": ""
      },
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "tokusokuDate"
     },
     {
      "columnName": "督促<br>回数",
      "dataName": "tokusokuCount",
      "toolTip": "",
      "bgColor": 0,
      "width": 0,
      "visible": false,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "tokusokuCount"
     },
     {
      "columnName": "郵便番号",
      "dataName": "yubinNo",
      "toolTip": "",
      "bgColor": 0,
      "width": 100,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 1,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "yubinNo"
     },
     {
      "columnName": "住所",
      "dataName": "jusho",
      "toolTip": "",
      "bgColor": 0,
      "width": 180,
      "visible": true,
      "cellType": 0,
      "cellDetails": "\"{\\\"cellType\\\":0}\"",
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "jusho"
     },
     {
      "columnName": "入所施設",
      "dataName": "nyushoShisetsu",
      "toolTip": "",
      "bgColor": 0,
      "width": 100,
      "visible": true,
      "cellType": 0,
      "cellDetails": null,
      "align": 0,
      "resize": true,
      "isPrivateInfo": false,
      "sortKey": "nyushoShisetsu"
     }
    ]
   },
   "height": "230",
   "onSort": "",
   "onSelect": "",
   "onSelectByDblClick": "",
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
 "controlName": "NinteichosaIraiListForByHandCom",
 "originalProperty": [
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onSort",
   "newPropertyName": "onSort"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onSelect",
   "newPropertyName": "onSelect"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "onSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onOnlyRow",
   "newPropertyName": "onOnlyRow"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onNoRow",
   "newPropertyName": "onNoRow"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "onMultiRows",
   "newPropertyName": "onMultiRows"
  },
  {
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "publicChildProperty": "height",
   "newPropertyName": "height"
  }
 ]
}        
    }
}

