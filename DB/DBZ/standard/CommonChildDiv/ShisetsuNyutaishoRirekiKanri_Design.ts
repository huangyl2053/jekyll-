/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShisetsuNyutaishoRirekiKanriクラスのみで継承して使えます。
     */
    export class ShisetsuNyutaishoRirekiKanri_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShisetsuNyutaishoRirekiKanri_Design.myLayout, fieldName);
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
   "fieldName": "ShisetsuNyutaishoRirekiKanri",
   "items": [
    {
     "fieldName": "btnAddShisetsuNyutaisho",
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
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnAddShisetsuNyutaisho",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnAddShisetsuNyutaisho",
     "text": "追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "dgShisetsuNyutaishoRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "1030px",
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
     "selectControlID": "dgShisetsuNyutaishoRireki",
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
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": true,
      "isShowDeleteButtonColumn": true,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "selectLimitRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "状態",
        "dataName": "state",
        "toolTip": "",
        "bgColor": 0,
        "width": 50,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "入所日",
        "dataName": "nyushoDate",
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
        "sortKey": "nyushoDate"
       },
       {
        "columnName": "退所日",
        "dataName": "taishoDate",
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
        "sortKey": ""
       },
       {
        "columnName": "施設コード",
        "dataName": "shisetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": false,
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
        "columnName": "施設名称",
        "dataName": "shisetsuMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": false,
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
        "columnName": "入所施設",
        "dataName": "shisetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 390,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "台帳種別key",
        "dataName": "daichoShubetsuKey",
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
        "columnName": "台帳種別",
        "dataName": "daichoShubetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 180,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "施設種類key",
        "dataName": "shisetsuShuruiKey",
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
        "columnName": "施設種類",
        "dataName": "shisetsuShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       }
      ]
     },
     "onSort": "",
     "onSelect": "onSelect_dgShisetsuNyutaishoRireki",
     "onSelectByDblClick": "onSelectByDblClick_dgShisetsuNyutaishoRireki",
     "onSelectBySelectButton": "onSelectBySelectButton_dgShisetsuNyutaishoRireki",
     "onSelectByModifyButton": "onSelectByModifyButton_dgShisetsuNyutaishoRireki",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgShisetsuNyutaishoRireki",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "shisetsuShurui",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    }
   ],
   "controlType": "Panel",
   "width": "1035px",
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
   "selectControlID": "ShisetsuNyutaishoRirekiKanri",
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
     "postParameterPanelNames": "ShisetsuNyutaishoRirekiKanri"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [
    {
     "propertyName": "selectRow",
     "value": ""
    },
    {
     "propertyName": "inputMode",
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
 "controlName": "ShisetsuNyutaishoRirekiKanri",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [
  {
   "eventName": "onClick_btnAddShisetsuNyutaisho"
  },
  {
   "eventName": "onSelect_dgShisetsuNyutaishoRireki"
  },
  {
   "eventName": "onSelectByDblClick_dgShisetsuNyutaishoRireki"
  },
  {
   "eventName": "onSelectBySelectButton_dgShisetsuNyutaishoRireki"
  },
  {
   "eventName": "onSelectByModifyButton_dgShisetsuNyutaishoRireki"
  },
  {
   "eventName": "onSelectByDeleteButton_dgShisetsuNyutaishoRireki"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module ShisetsuNyutaishoRirekiKanri {

        export class Events {

            public static onClick_btnAddShisetsuNyutaisho(): string {
                return "onClick_btnAddShisetsuNyutaisho";
            }

            public static onSelect_dgShisetsuNyutaishoRireki(): string {
                return "onSelect_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByDblClick_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByDblClick_dgShisetsuNyutaishoRireki";
            }

            public static onSelectBySelectButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByModifyButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByDeleteButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuNyutaishoRirekiKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuNyutaishoRirekiKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoRirekiKanri"));
            }

            public btnAddShisetsuNyutaisho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            }

            public dgShisetsuNyutaishoRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            }

        }

     }

}

