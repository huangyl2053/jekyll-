/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * IryoHokenRirekiクラスのみで継承して使えます。
     */
    export class IryoHokenRireki_Design extends Uz.CommonChildDiv {
    
        public get onSelectByModifyButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByModifyButton"];
        }
        
        public set onSelectByModifyButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByModifyButton"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByModifyButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelectByDeleteButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDeleteButton"];
        }
        
        public set onSelectByDeleteButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDeleteButton"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByDeleteButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get panel_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
        }
        
        public set panel_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get grid_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"];
        }
        
        public set grid_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0].items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get gird_gridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"];
        }
        
        public set gird_gridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[0]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, IryoHokenRireki_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onSelectByModifyButton");
            Uz.JSControlUtil.registProperty("onSelectByDeleteButton");
            Uz.JSControlUtil.registProperty("panel_width");
            Uz.JSControlUtil.registProperty("grid_width");
            Uz.JSControlUtil.registProperty("gird_gridSetting");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onSelectByModifyButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByModifyButton"];
            editablePropertyInfo["onSelectByDeleteButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDeleteButton"];
            editablePropertyInfo["panel_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            editablePropertyInfo["grid_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            editablePropertyInfo["gird_gridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "IryoHokenRireki",
   "items": [
    {
     "fieldName": "dgIryoHokenRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "1010px",
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
     "marginLeft": "0em",
     "marginRight": "0em",
     "selectControlID": "dgIryoHokenRireki",
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
      "isShowRowState": true,
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": true,
      "isShowDeleteButtonColumn": true,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "加入日",
        "dataName": "kanyuDate",
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
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kanyuDate"
       },
       {
        "columnName": "脱退日",
        "dataName": "dattaiDate",
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
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "dattaiDate"
       },
       {
        "columnName": "種別key",
        "dataName": "iryoHokenShubetsuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "iryoHokenShubetsuKey"
       },
       {
        "columnName": "種別",
        "dataName": "iryoHokenShubetsu",
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
        "sortKey": "iryoHokenShubetsu"
       },
       {
        "columnName": "保険者番号",
        "dataName": "hokenshaNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hokenshaNo"
       },
       {
        "columnName": "保険者名称",
        "dataName": "hokenshaMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hokenshaMeisho"
       },
       {
        "columnName": "保険者",
        "dataName": "hokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 300,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hokensha"
       },
       {
        "columnName": "記号番号",
        "dataName": "kigoNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 270,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kigoNo"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton_dgIryoHokenRireki",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgIryoHokenRireki",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "kigoNo",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    }
   ],
   "controlType": "Panel",
   "width": "1015px",
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
   "selectControlID": "IryoHokenRireki",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "IryoHokenRireki"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "mode",
     "value": ""
    }
   ],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": true,
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
 "marginLeft": "0em",
 "marginRight": "0em",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBZ",
 "controlName": "IryoHokenRireki",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "dgIryoHokenRireki",
   "publicChildProperty": "onSelectByModifyButton",
   "newPropertyName": "onSelectByModifyButton"
  },
  {
   "publicChildFieldName": "dgIryoHokenRireki",
   "publicChildProperty": "onSelectByDeleteButton",
   "newPropertyName": "onSelectByDeleteButton"
  },
  {
   "publicChildFieldName": "IryoHokenRireki",
   "publicChildProperty": "width",
   "newPropertyName": "panel_width"
  },
  {
   "publicChildFieldName": "dgIryoHokenRireki",
   "publicChildProperty": "width",
   "newPropertyName": "grid_width"
  },
  {
   "publicChildFieldName": "dgIryoHokenRireki",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "gird_gridSetting"
  }
 ],
 "dataPassingForDialog": [
  {
   "key": "",
   "controlName": ""
  },
  {
   "key": "",
   "controlName": ""
  },
  {
   "key": "",
   "controlName": ""
  }
 ],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [],
 "publicEventsAlias": []
}        
    }

     export module IryoHokenRireki {

        export class Events {

            public static onSelectByModifyButton_dgIryoHokenRireki(): string {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            }

            public static onSelectByDeleteButton_dgIryoHokenRireki(): string {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryoHokenRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            }

            public IryoHokenRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoHokenRireki"));
            }

            public dgIryoHokenRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            }

        }

     }

}

