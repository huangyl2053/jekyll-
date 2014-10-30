/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * JushochiTokureiRirekiListクラスのみで継承して使えます。
     */
    export class JushochiTokureiRirekiList_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, JushochiTokureiRirekiList_Design.myLayout, fieldName);
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
   "fieldName": "JushochiTokureiRirekiList",
   "items": [
    {
     "fieldName": "btnAdd",
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
     "selectControlID": "btnAdd",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnAdd",
     "text": "追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "dgJutoku",
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
     "marginLeft": "0px",
     "marginRight": "0px",
     "selectControlID": "dgJutoku",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "217px",
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
       "combineColumns": [
        {
         "combineColumnName": "適用情報",
         "combineItem": [
          "tekiyoDate",
          "tekiyoTodokedeDate",
          "tekiyoJiyu",
          "tekiyoJiyuKey"
         ]
        },
        {
         "combineColumnName": "解除情報",
         "combineItem": [
          "kaijoDate",
          "kaijoTodokedeDate",
          "kaijoJiyu",
          "kaijoJiyuKey"
         ]
        }
       ],
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
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "state"
       },
       {
        "columnName": "適用日",
        "dataName": "tekiyoDate",
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
        "sortKey": "tekiyoDate"
       },
       {
        "columnName": "届出日",
        "dataName": "tekiyoTodokedeDate",
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
        "sortKey": "tekiyoTodokedeDate"
       },
       {
        "columnName": "適用事由",
        "dataName": "tekiyoJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "tekiyoJiyu"
       },
       {
        "columnName": "適用事由Key",
        "dataName": "tekiyoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 1,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "tekiyoJiyuKey"
       },
       {
        "columnName": "解除日",
        "dataName": "kaijoDate",
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
        "sortKey": "kaijoDate"
       },
       {
        "columnName": "届出日",
        "dataName": "kaijoTodokedeDate",
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
        "sortKey": "kaijoTodokedeDate"
       },
       {
        "columnName": "解除事由",
        "dataName": "kaijoJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kaijoJiyu"
       },
       {
        "columnName": "解除事由Key",
        "dataName": "kaijoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 1,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "kaijoJiyuKey"
       },
       {
        "columnName": "所在保険者",
        "dataName": "shozaiHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shozaiHokensha"
       },
       {
        "columnName": "措置元保険者",
        "dataName": "sochimotoHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "sochimotoHokensha"
       },
       {
        "columnName": "旧保険者",
        "dataName": "kyuHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kyuHokensha"
       },
       {
        "columnName": "処理日時",
        "dataName": "shoriDate",
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
        "sortKey": "shoriDate"
       }
      ]
     },
     "onSort": "",
     "onSelect": "onSelect_dgJutoku",
     "onSelectByDblClick": "onSelectByDblClick_dgJutoku",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton_dgJutoku",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgJutoku",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "tekiyoDate",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    }
   ],
   "controlType": "Panel",
   "width": "1075px",
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
   "marginLeft": "0px",
   "marginRight": "0px",
   "selectControlID": "JushochiTokureiRirekiList",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [],
   "requestSettings": [],
   "hiddenInput": [],
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
 "marginLeft": "0px",
 "marginRight": "0px",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBZ",
 "controlName": "JushochiTokureiRirekiList",
 "marginTop": "0px",
 "marginBottom": "0px",
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
   "eventName": "onClick_btnAdd"
  },
  {
   "eventName": "onSelect_dgJutoku"
  },
  {
   "eventName": "onSelectByDblClick_dgJutoku"
  },
  {
   "eventName": "onSelectByModifyButton_dgJutoku"
  },
  {
   "eventName": "onSelectByDeleteButton_dgJutoku"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module JushochiTokureiRirekiList {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgJutoku(): string {
                return "onSelect_dgJutoku";
            }

            public static onSelectByDblClick_dgJutoku(): string {
                return "onSelectByDblClick_dgJutoku";
            }

            public static onSelectByModifyButton_dgJutoku(): string {
                return "onSelectByModifyButton_dgJutoku";
            }

            public static onSelectByDeleteButton_dgJutoku(): string {
                return "onSelectByDeleteButton_dgJutoku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JushochiTokureiRirekiList"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgJutoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            }

        }

     }

}

