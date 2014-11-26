/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module ServiceTeikyoShomeishoShinryoListH1503 {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "ServiceTeikyoShomeishoShinryoListH1503";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public ServiceTeikyoShomeishoShinryoListH1503() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public btnAdd() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnAdd"));

            }

            public dgServiceTeikyoShomeishoShinryoListH1503() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShinryoListH1503"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class ServiceTeikyoShomeishoShinryoListH1503_Design extends Uz.CommonChildDiv {
    
        public get AddButtonVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"];
        }
        
        public set AddButtonVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[0]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get AddButtonDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"];
        }
        
        public set AddButtonDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get AddButtonOnClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"];
        }
        
        public set AddButtonOnClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[0]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListGridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["gridSetting"];
        }
        
        public set MeisaiListGridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[1]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListHeight() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["height"];
        }
        
        public set MeisaiListHeight(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["height"] = value;
            } else {
                this.layout.items[0].items[1]["height"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onSelect"];
        }
        
        public set MeisaiListOnSelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onSelect"] = value;
            } else {
                this.layout.items[0].items[1]["onSelect"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onSelectByDblClick"];
        }
        
        public set MeisaiListOnSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[1]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ServiceTeikyoShomeishoShinryoListH1503_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("AddButtonVisible");
            Uz.JSControlUtil.registProperty("AddButtonDisplayNone");
            Uz.JSControlUtil.registProperty("AddButtonOnClick");
            Uz.JSControlUtil.registProperty("MeisaiListGridSetting");
            Uz.JSControlUtil.registProperty("MeisaiListHeight");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelect");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelectByDblClick");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["AddButtonVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["AddButtonDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["AddButtonOnClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["MeisaiListGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["MeisaiListHeight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["MeisaiListOnSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["MeisaiListOnSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ServiceTeikyoShomeishoShinryoListH1503",
   "items": [
    {
     "fieldName": "btnAdd",
     "items": [],
     "controlType": "Button",
     "width": "150",
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
     "onClick": "",
     "text": "明細情報を追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    },
    {
     "fieldName": "dgServiceTeikyoShomeishoShinryoListH1503",
     "items": [],
     "controlType": "DataGrid",
     "width": "950",
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
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "",
        "dataName": "btnSelect",
        "toolTip": "",
        "bgColor": 0,
        "width": 35,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "選",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "btnSelect"
       },
       {
        "columnName": "",
        "dataName": "btnEdit",
        "toolTip": "",
        "bgColor": 0,
        "width": 35,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "修",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "btnEdit"
       },
       {
        "columnName": "",
        "dataName": "btnDelete",
        "toolTip": "",
        "bgColor": 0,
        "width": 35,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "削",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "btnDelete"
       },
       {
        "columnName": "傷病名",
        "dataName": "txtShobyoName",
        "toolTip": "",
        "bgColor": 0,
        "width": 310,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShobyoName"
       },
       {
        "columnName": "指導管理",
        "dataName": "txtShidoKanri",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtShidoKanri"
       },
       {
        "columnName": "リハビリ",
        "dataName": "txtRehabili",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtRehabili"
       },
       {
        "columnName": "精神科",
        "dataName": "txtSeishinka",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtSeishinka"
       },
       {
        "columnName": "エックス線",
        "dataName": "txtXSen",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtXSen"
       },
       {
        "columnName": "その他１",
        "dataName": "txtEtc1",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtEtc1"
       },
       {
        "columnName": "その他２",
        "dataName": "txtEtc2",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtEtc2"
       },
       {
        "columnName": "合計",
        "dataName": "txtGokei",
        "toolTip": "",
        "bgColor": 0,
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtGokei"
       }
      ]
     },
     "height": "143",
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
   "marginLeft": "0",
   "marginRight": "0",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ServiceTeikyoShomeishoShinryoListH1503"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": true,
   "eraseBorderBottom": true,
   "eraseBorderRight": true,
   "eraseBorderLeft": true,
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
 "businessId": "DBC",
 "controlName": "ServiceTeikyoShomeishoShinryoListH1503",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnAdd",
   "publicChildProperty": "visible",
   "newPropertyName": "AddButtonVisible"
  },
  {
   "publicChildFieldName": "btnAdd",
   "publicChildProperty": "displayNone",
   "newPropertyName": "AddButtonDisplayNone"
  },
  {
   "publicChildFieldName": "btnAdd",
   "publicChildProperty": "onClick",
   "newPropertyName": "AddButtonOnClick"
  },
  {
   "publicChildFieldName": "dgServiceTeikyoShomeishoShinryoListH1503",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "MeisaiListGridSetting"
  },
  {
   "publicChildFieldName": "dgServiceTeikyoShomeishoShinryoListH1503",
   "publicChildProperty": "height",
   "newPropertyName": "MeisaiListHeight"
  },
  {
   "publicChildFieldName": "dgServiceTeikyoShomeishoShinryoListH1503",
   "publicChildProperty": "onSelect",
   "newPropertyName": "MeisaiListOnSelect"
  },
  {
   "publicChildFieldName": "dgServiceTeikyoShomeishoShinryoListH1503",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "MeisaiListOnSelectByDblClick"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

