/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * ShozokuChosainListComクラスのみで継承して使えます。
     */
    export class ShozokuChosainListCom_Design extends Uz.CommonChildDiv {
    
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
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShozokuChosainListCom",
   "items": [
    {
     "fieldName": "dgShozokuChosainList",
     "items": [],
     "controlType": "DataGrid",
     "width": "300px",
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
     "selectControlID": "dgShozokuChosainList",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "150px",
     "dataSource": [],
     "gridSetting": {
      "isShowModifyButtonColumn": false,
      "rowHeight": 25,
      "isShowFilter": false,
      "isShowFooter": false,
      "limitRowCount": 0,
      "isShowDeleteButtonColumn": false,
      "isShowFilterButton": false,
      "isShowHeader": true,
      "isMultiSelectable": false,
      "isShowRowState": false,
      "selectedRowCount": 0,
      "isShowSelectButtonColumn": false,
      "columns": [
       {
        "isPrivateInfo": false,
        "width": 50,
        "cellType": 8,
        "visible": false,
        "toolTip": "",
        "sortKey": "btnToBindChosain",
        "align": 0,
        "cellDetails": {
         "imageWidth": "",
         "cellType": 8,
         "text": "割付",
         "imageHeight": "",
         "imageFileUrl": "",
         "onClick": ""
        },
        "columnName": "",
        "dataName": "btnToBindChosain",
        "resize": false,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 75,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosainNo",
        "align": 1,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "番号<br>",
        "dataName": "chosainNo",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 150,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "chosainName",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "氏名<br>",
        "dataName": "chosainName",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 55,
        "cellType": 0,
        "visible": true,
        "toolTip": "",
        "sortKey": "waritsukeNum",
        "align": 2,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "割付数<br>",
        "dataName": "waritsukeNum",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 125,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chiku",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "地区",
        "dataName": "chiku",
        "resize": true,
        "bgColor": 0
       },
       {
        "isPrivateInfo": false,
        "width": 0,
        "cellType": 0,
        "visible": false,
        "toolTip": "",
        "sortKey": "chousaItakusakiNo",
        "align": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "columnName": "調査委託先番号",
        "dataName": "chousaItakusakiNo",
        "resize": false,
        "bgColor": 0
       }
      ],
      "header": {
       "headerHeight": 0,
       "frozenColumn": "",
       "combineColumns": []
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
     "sortOrder": "chosainName",
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
   "selectControlID": "ShozokuChosainListCom",
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
 "controlName": "ShozokuChosainListCom",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildProperty": "height",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "height"
  },
  {
   "publicChildProperty": "onSort",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onSort"
  },
  {
   "publicChildProperty": "onSelect",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onSelect"
  },
  {
   "publicChildProperty": "onSelectByDblClick",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onSelectByDblClick"
  },
  {
   "publicChildProperty": "onOnlyRow",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onOnlyRow"
  },
  {
   "publicChildProperty": "onNoRow",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onNoRow"
  },
  {
   "publicChildProperty": "onMultiRows",
   "publicChildFieldName": "dgShozokuChosainList",
   "newPropertyName": "onMultiRows"
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

     export module ShozokuChosainListCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShozokuChosainListCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType() + "_" + fieldName;
            }

            public ShozokuChosainListCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShozokuChosainList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShozokuChosainList"));
            }

        }

     }

}

