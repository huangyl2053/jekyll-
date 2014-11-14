/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShikakuTokusoRirekiクラスのみで継承して使えます。
     */
    export class ShikakuTokusoRireki_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShikakuTokusoRireki_Design.myLayout, fieldName);
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
   "fieldName": "ShikakuTokusoRireki",
   "items": [
    {
     "fieldName": "btnAddShikakuShutoku",
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
     "selectControlID": "btnAddShikakuShutoku",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnAddShikakuShutoku",
     "text": "追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "dgShikakuShutokuRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "1090px",
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
     "selectControlID": "dgShikakuShutokuRireki",
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
      "isShowModifyButtonColumn": false,
      "isShowDeleteButtonColumn": false,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "selectLimitRowCount": 0,
      "header": {
       "combineColumns": [
        {
         "combineColumnName": "取得情報",
         "combineItem": [
          "shutokuDate",
          "shutokuTodokedeDate",
          "shutokuJiyuKey",
          "shutokuJiyu"
         ]
        },
        {
         "combineColumnName": "喪失情報",
         "combineItem": [
          "soshitsuDate",
          "soshitsuTodokedeDate",
          "soshitsuJiyuKey",
          "soshitsuJiyu"
         ]
        },
        {
         "combineColumnName": "変更情報",
         "combineItem": [
          "henkoDate"
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
        "columnName": "詳細",
        "dataName": "shosai",
        "toolTip": "",
        "bgColor": 0,
        "width": 40,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "",
         "onClick": "onClickShosaiButton_dgShikakuShutokuRireki",
         "imageFileUrl": "/ur/urz/image/UR_Book_On.png",
         "imageWidth": "20",
         "imageHeight": "20"
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "取得日",
        "dataName": "shutokuDate",
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
        "sortKey": "shutokuDate"
       },
       {
        "columnName": "届出日",
        "dataName": "shutokuTodokedeDate",
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
        "sortKey": "shutokuTodokedeDate"
       },
       {
        "columnName": "取得事由Key",
        "dataName": "shutokuJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "shutokuJiyuKey"
       },
       {
        "columnName": "取得事由",
        "dataName": "shutokuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shutokuJiyu"
       },
       {
        "columnName": "被保区分",
        "dataName": "hihokenshaKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaKubun"
       },
       {
        "columnName": "被保区分Key",
        "dataName": "hihokenshaKubunKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaKubunKey"
       },
       {
        "columnName": "喪失日",
        "dataName": "soshitsuDate",
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
        "sortKey": "soshitsuDate"
       },
       {
        "columnName": "届出日",
        "dataName": "soshitsuTodokedeDate",
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
        "sortKey": "soshitsuTodokedeDate"
       },
       {
        "columnName": "喪失事由Key",
        "dataName": "soshitsuJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "soshitsuJiyuKey"
       },
       {
        "columnName": "喪失事由",
        "dataName": "soshitsuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "soshitsuJiyu"
       },
       {
        "columnName": "変更日",
        "dataName": "henkoDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": false,
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
        "sortKey": "henkoDate"
       },
       {
        "columnName": "住特区分",
        "dataName": "jutokuKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "jutokuKubun"
       },
       {
        "columnName": "所在保険者",
        "dataName": "shozaiHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 110,
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
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kyuHokensha"
       },
       {
        "columnName": "識別コード",
        "dataName": "shikibetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shikibetsuCode"
       }
      ]
     },
     "onSort": "",
     "onSelect": "onSelect_dgShikakuShutokuRireki",
     "onSelectByDblClick": "onSelectByDblClick_dgShikakuShutokuRireki",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton_dgShikakuShutokuRireki",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgShikakuShutokuRireki",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "jutokuTekiyoTodokedeDate",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    }
   ],
   "controlType": "Panel",
   "width": "1090px",
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
   "selectControlID": "ShikakuTokusoRireki",
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
     "postParameterPanelNames": "ShikakuTokusoRireki"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnJutokuTekiyo",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnShikakuShutoku",
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
 "marginLeft": "0px",
 "marginRight": "0px",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBZ",
 "controlName": "ShikakuTokusoRireki",
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
   "eventName": "onClick_btnAddShikakuShutoku"
  },
  {
   "eventName": "onSelect_dgShikakuShutokuRireki"
  },
  {
   "eventName": "onSelectByDblClick_dgShikakuShutokuRireki"
  },
  {
   "eventName": "onSelectByModifyButton_dgShikakuShutokuRireki"
  },
  {
   "eventName": "onSelectByDeleteButton_dgShikakuShutokuRireki"
  },
  {
   "eventName": "onClickShosaiButton_dgShikakuShutokuRireki"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module ShikakuTokusoRireki {

        export class Events {

            public static onClick_btnAddShikakuShutoku(): string {
                return "onClick_btnAddShikakuShutoku";
            }

            public static onSelect_dgShikakuShutokuRireki(): string {
                return "onSelect_dgShikakuShutokuRireki";
            }

            public static onSelectByDblClick_dgShikakuShutokuRireki(): string {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            }

            public static onSelectByModifyButton_dgShikakuShutokuRireki(): string {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            }

            public static onSelectByDeleteButton_dgShikakuShutokuRireki(): string {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuTokusoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType() + "_" + fieldName;
            }

            public ShikakuTokusoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddShikakuShutoku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddShikakuShutoku"));
            }

            public dgShikakuShutokuRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            }

        }

     }

}

