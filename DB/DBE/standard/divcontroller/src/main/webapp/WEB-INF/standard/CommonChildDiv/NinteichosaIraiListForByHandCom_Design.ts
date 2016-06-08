/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * NinteichosaIraiListForByHandComクラスのみで継承して使えます。
     */
    export class NinteichosaIraiListForByHandCom_Design extends Uz.CommonChildDiv {
    
        public get onSort() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSort"];
        }
        
        public set onSort(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSort"] = value;
            } else {
                this.layout.items[0].items[0]["onSort"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelect"];
        }
        
        public set onSelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelect"] = value;
            } else {
                this.layout.items[0].items[0]["onSelect"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"];
        }
        
        public set onSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onOnlyRow() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onOnlyRow"];
        }
        
        public set onOnlyRow(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onOnlyRow"] = value;
            } else {
                this.layout.items[0].items[0]["onOnlyRow"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onNoRow() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onNoRow"];
        }
        
        public set onNoRow(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onNoRow"] = value;
            } else {
                this.layout.items[0].items[0]["onNoRow"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onMultiRows() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onMultiRows"];
        }
        
        public set onMultiRows(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onMultiRows"] = value;
            } else {
                this.layout.items[0].items[0]["onMultiRows"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get height() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"];
        }
        
        public set height(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"] = value;
            } else {
                this.layout.items[0].items[0]["height"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get withOfGrid() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"];
        }
        
        public set withOfGrid(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0].items[0]["width"] = value;
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
            Uz.JSControlUtil.registProperty("withOfGrid");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["withOfGrid"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "NinteichosaIraiListForByHandCom",
   "items": [
    {
     "fieldName": "dgNinteichosaIraiListForByHand",
     "items": [],
     "controlType": "DataGrid",
     "width": "1070px",
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
     "selectControlID": "dgNinteichosaIraiListForByHand",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "162px",
     "dataSource": [],
     "gridSetting": {
      "isShowModifyButtonColumn": false,
      "rowHeight": 24,
      "isShowFilter": false,
      "isShowFooter": false,
      "limitRowCount": 0,
      "isShowDeleteButtonColumn": false,
      "isShowFilterButton": false,
      "isShowHeader": true,
      "isMultiSelectable": true,
      "isShowRowState": false,
      "selectedRowCount": 0,
      "isShowSelectButtonColumn": false,
      "columns": [
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 2,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosaKanryoFlag",
        "align": 0,
        "cellDetails": {
         "disabled": true,
         "cellType": 2,
         "onChange": ""
        },
        "columnName": "調査済みフラグ",
        "dataName": "chosaKanryoFlag",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 55,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaJokyo",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "状況",
        "dataName": "chosaJokyo",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 50,
        "cellType": 8,
        "visible": false,
        "toolTip": "",
        "sortKey": "btnToShowDetail",
        "align": 1,
        "cellDetails": {
         "imageWidth": "",
         "cellType": 8,
         "text": "詳細",
         "imageHeight": "",
         "imageFileUrl": "",
         "onClick": ""
        },
        "columnName": "詳細",
        "dataName": "btnToShowDetail",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 75,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "hokenshaNo",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "保険者番号",
        "dataName": "hokenshaNo",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 75,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "shichoson",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "市町村",
        "dataName": "shichoson",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "shishoCode",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "支所コード",
        "dataName": "shishoCode",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 75,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "shoshoName",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "支所",
        "dataName": "shoshoName",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 85,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "hihokenshaNo",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "被保番号",
        "dataName": "hihokenshaNo",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 120,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "shimei",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "氏名",
        "dataName": "shimei",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "kanaShimei",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "カナ氏名",
        "dataName": "kanaShimei",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "shimeiWithKana",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "氏名",
        "dataName": "shimeiWithKana",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 80,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "ninteiShinseiKubun",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "申請区分",
        "dataName": "ninteiShinseiKubun",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 82,
        "cellType": 7,
        "visible": true,
        "toolTip": "",
        "sortKey": "ninteiShinseiDate",
        "align": 1,
        "cellDetails": {
         "cellType": 7,
         "isSetValueToToolTip": false,
         "displayFormat": 0,
         "onChange": "",
         "ymdKubun": 2,
         "readOnly": true
        },
        "columnName": "申請日",
        "dataName": "ninteiShinseiDate",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 60,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chiku",
        "align": 0,
        "cellDetails": null,
        "columnName": "地区",
        "dataName": "chiku",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 80,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaIraiKubun",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "依頼区分",
        "dataName": "chosaIraiKubun",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 82,
        "cellType": 7,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaIraiDate",
        "align": 1,
        "cellDetails": {
         "cellType": 7,
         "isSetValueToToolTip": false,
         "displayFormat": 0,
         "onChange": "",
         "ymdKubun": 2,
         "readOnly": true
        },
        "columnName": "依頼日",
        "dataName": "chosaIraiDate",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 82,
        "cellType": 7,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaKigenDate",
        "align": 1,
        "cellDetails": {
         "cellType": 7,
         "isSetValueToToolTip": false,
         "displayFormat": 0,
         "onChange": "",
         "ymdKubun": 2,
         "readOnly": true
        },
        "columnName": "期限日",
        "dataName": "chosaKigenDate",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 82,
        "cellType": 7,
        "visible": true,
        "toolTip": "",
        "sortKey": "iraishoHakkoDate",
        "align": 1,
        "cellDetails": {
         "cellType": 7,
         "isSetValueToToolTip": false,
         "displayFormat": 0,
         "onChange": "",
         "ymdKubun": 2,
         "readOnly": true
        },
        "columnName": "発行日",
        "dataName": "iraishoHakkoDate",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosaItakusakiNo",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先コード",
        "dataName": "chosaItakusakiNo",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 120,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaItakusakiName",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先",
        "dataName": "chosaItakusakiName",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosainNo",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員コード",
        "dataName": "chosainNo",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 90,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosainName",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員",
        "dataName": "chosainName",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosaItakusakiNo1TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先コード",
        "dataName": "chosaItakusakiNo1TA",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 120,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaItakusakiName1TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先",
        "dataName": "chosaItakusakiName1TA",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosainNo1TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員コード",
        "dataName": "chosainNo1TA",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 90,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosainName1TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員",
        "dataName": "chosainName1TA",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosaItakusakiNo2TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先コード",
        "dataName": "chosaItakusakiNo2TA",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 120,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosaItakusakiName2TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先",
        "dataName": "chosaItakusakiName2TA",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chosainNo2TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員コード",
        "dataName": "chosainNo2TA",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 90,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosainName2TA",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査員",
        "dataName": "chosainName2TA",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 82,
        "cellType": 7,
        "visible": true,
        "toolTip": "",
        "sortKey": "tokusokuDate",
        "align": 1,
        "cellDetails": {
         "cellType": 7,
         "isSetValueToToolTip": false,
         "displayFormat": 0,
         "onChange": "",
         "ymdKubun": 2,
         "readOnly": true
        },
        "columnName": "督促日",
        "dataName": "tokusokuDate",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "tokusokuCount",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "回数",
        "dataName": "tokusokuCount",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 75,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "yubinNo",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "番号",
        "dataName": "yubinNo",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 180,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "jusho",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "住所",
        "dataName": "jusho",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 100,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "nyushoShisetsu",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "入所施設",
        "dataName": "nyushoShisetsu",
        "resize": true,
        "bgColor": 0
       }
      ],
      "header": {
       "headerHeight": 0,
       "frozenColumn": "",
       "combineColumns": [
        {
         "combineColumnName": "調査",
         "combineItem": [
          "chosaJokyo"
         ]
        },
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
          "chosaKigenDate"
         ]
        },
        {
         "combineColumnName": "依頼書",
         "combineItem": [
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
       ]
      }
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
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
     "sortOrder": "chosaIraiKubun",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
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
   "selectControlID": "NinteichosaIraiListForByHandCom",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [],
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
   "eraseBorder": true,
   "backgroundColor": 0,
   "widthAuto": true,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto",
   "canPost": false
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
 "marginLeft": "XS",
 "marginRight": "XS",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBE",
 "controlName": "NinteichosaIraiListForByHandCom",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildProperty": "onSort",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onSort"
  },
  {
   "publicChildProperty": "onSelect",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onSelect"
  },
  {
   "publicChildProperty": "onSelectByDblClick",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onSelectByDblClick"
  },
  {
   "publicChildProperty": "onOnlyRow",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onOnlyRow"
  },
  {
   "publicChildProperty": "onNoRow",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onNoRow"
  },
  {
   "publicChildProperty": "onMultiRows",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "onMultiRows"
  },
  {
   "publicChildProperty": "height",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "height"
  },
  {
   "publicChildProperty": "width",
   "publicChildFieldName": "dgNinteichosaIraiListForByHand",
   "newPropertyName": "withOfGrid"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [],
 "publicEventsAlias": []
}        
    }

     export module NinteichosaIraiListForByHandCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteichosaIraiListForByHandCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.NinteichosaIraiListForByHandCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.NinteichosaIraiListForByHandCom.Controls.myType() + "_" + fieldName;
            }

            public NinteichosaIraiListForByHandCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgNinteichosaIraiListForByHand(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteichosaIraiListForByHand"));
            }

        }

     }

}

