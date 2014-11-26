/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module IryoKikanDialog {

        export class Events {

            public static get onSelect_dgKikanIchiran(): string {
                return "onSelect_dgKikanIchiran";
            }
            public static get CloseOK(): string {
                return "CloseOK";
            }
            public static get CloseCancel(): string {
                return "CloseCancel";
            }
            public static get onSelect_dgShujiiIchiran(): string {
                return "onSelect_dgShujiiIchiran";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "IryoKikanDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public IryoKikanDialog() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public btnToMentenanceChosaKikan() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));

            }

            public dgKikanIchiran() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgKikanIchiran"));

            }

            public dgShujiiIchiran() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgShujiiIchiran"));

            }

            public btnSelectKikan() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnSelectKikan"));

            }

            public btnNonSelectReturn() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class IryoKikanDialog_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, IryoKikanDialog_Design.myLayout, fieldName);
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
   "fieldName": "IryoKikanDialog",
   "items": [
    {
     "fieldName": "btnToMentenanceChosaKikan",
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
     "marginLeft": "S",
     "marginRight": "XS",
     "selectControlID": "btnToMentenanceChosaKikan",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "",
     "text": "機関情報を修正する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "dgKikanIchiran",
     "items": [],
     "controlType": "DataGrid",
     "width": "380",
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
     "marginLeft": "S",
     "marginRight": "XS",
     "selectControlID": "dgKikanIchiran",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "S",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": true,
      "isShowFilterButton": true,
      "isShowRowState": false,
      "isShowSelectButtonColumn": true,
      "isShowModifyButtonColumn": false,
      "isShowDeleteButtonColumn": false,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "機関番号",
        "dataName": "kikanNo",
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
        "sortKey": "kikanNo"
       },
       {
        "columnName": "機関名称",
        "dataName": "kikanMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kikanMeisho"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelect_dgKikanIchiran",
     "onSelectByModifyButton": "",
     "onSelectByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "kikanMeisho",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "dgShujiiIchiran",
     "items": [],
     "controlType": "DataGrid",
     "width": "300",
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
     "marginLeft": "M",
     "marginRight": "XS",
     "selectControlID": "dgShujiiIchiran",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "S",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": true,
      "isShowFilterButton": true,
      "isShowRowState": false,
      "isShowSelectButtonColumn": true,
      "isShowModifyButtonColumn": false,
      "isShowDeleteButtonColumn": false,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "医師番号",
        "dataName": "ishiNo",
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
        "sortKey": "ishiNo"
       },
       {
        "columnName": "医師氏名",
        "dataName": "ishiMeisho",
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
        "sortKey": "ishiMeisho"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "onSelect_dgShujiiIchiran",
     "onSelectByModifyButton": "",
     "onSelectByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "chosainMeisho",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "btnSelectKikan",
     "items": [],
     "controlType": "Button",
     "width": "120",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "M",
     "selectControlID": "btnSelectKikan",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "CloseOK",
     "text": "選択する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "btnNonSelectReturn",
     "items": [],
     "controlType": "Button",
     "width": "120",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "M",
     "selectControlID": "btnNonSelectReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "CloseCancel",
     "text": "キャンセルする",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    }
   ],
   "controlType": "Panel",
   "width": "G8",
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
   "selectControlID": "IryoKikanDialog",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "医療機関",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "IryoKikanDialog"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbe/db/dbe/IryoKikanDialog/onLoad"
    },
    {
     "eventName": "CloseOK",
     "requestUrl": "dbe/db/dbe/IryoKikanDialog/onClick_btnSelectKikan"
    },
    {
     "eventName": "onSelect_dgKikanIchiran",
     "requestUrl": "dbe/db/dbe/IryoKikanDialog/onSelect_dgKikanIchiran"
    },
    {
     "eventName": "onSelect_dgShujiiIchiran",
     "requestUrl": "dbe/db/dbe/IryoKikanDialog/onSelect_dgIshiIchiran"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "iryokikanCode",
     "value": ""
    },
    {
     "propertyName": "iryokikanName",
     "value": ""
    },
    {
     "propertyName": "ishiCode",
     "value": ""
    },
    {
     "propertyName": "ishiName",
     "value": ""
    }
   ],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
   "backgroundColor": 0,
   "widthAuto": false,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto"
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
 "marginLeft": "0",
 "marginRight": "0",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "businessId": "DBE",
 "controlName": "IryoKikanDialog",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "iryokikanCode",
   "controlName": "IryoKikanDialog.iryokikanCode"
  },
  {
   "key": "iryokikanName",
   "controlName": "IryoKikanDialog.iryokikanName"
  },
  {
   "key": "ishiCode",
   "controlName": "IryoKikanDialog.ishiCode"
  },
  {
   "key": "ishiName",
   "controlName": "IryoKikanDialog.ishiName"
  }
 ],
 "dialogOkEventNameForDialog": "CloseOK",
 "dialogCancelEventNameForDialog": "CloseCancel"
}        
    }
}

