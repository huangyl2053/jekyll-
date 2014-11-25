/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />


/// <reference path="HihokenshaFinder.ts" />


module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module HihokenshaInputGuide {

        export class Events {

            public static get onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }
            public static get onClickBtnToSearch_HihokenshaFinder(): string {
                return "onClickBtnToSearch_HihokenshaFinder";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "HihokenshaInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public HihokenshaFinder() : DBZ.HihokenshaFinder.ModeController {
                return new DBZ.HihokenshaFinder.ModeController("HihokenshaFinder");
            }


            public HihokenshaInputGuide() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public lblSearchResultOfHihokensha() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSearchResultOfHihokensha"));

            }

            public dgSearchResultOfHihokensha() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgSearchResultOfHihokensha"));

            }

            public btnReturn() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnReturn"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class HihokenshaInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HihokenshaInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "HihokenshaInputGuide",
   "items": [
    {
     "fieldName": "HihokenshaFinder",
     "items": [],
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
     "selectControlID": "HihokenshaFinder",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "businessId": "DBZ",
     "controlName": "HihokenshaFinder",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M",
     "onClick_BtnToSearch": "onClickBtnToSearch_HihokenshaFinder",
     "displayNone_txtTsuchishoNo": true,
     "displayNone_ddlFukaNendo": true,
     "displayNone_SearchCriteriaDetail": false,
     "canOpenAndClose_HihokenshaFinder": false,
     "displayNone_saikinShorisha": true
    },
    {
     "fieldName": "lblSearchResultOfHihokensha",
     "items": [],
     "controlType": "Label",
     "width": "180",
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
     "selectControlID": "lblSearchResultOfHihokensha",
     "helpMessageID": "",
     "jpControlName": "",
     "required": false,
     "isPrivateInfo": false,
     "text": "被保険者検索該当者一覧",
     "decorationClass": "",
     "align": 2
    },
    {
     "fieldName": "dgSearchResultOfHihokensha",
     "items": [],
     "controlType": "DataGrid",
     "width": "1090",
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
     "selectControlID": "dgSearchResultOfHihokensha",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "165",
     "dataSource": [],
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
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "選択",
        "dataName": "btnToDecide",
        "toolTip": "",
        "bgColor": 0,
        "width": 40,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "",
         "onClick": "onClick_btnToDecide",
         "imageFileUrl": "/uz/uza/image/UZ_RowSelect_On.png",
         "imageWidth": "20",
         "imageHeight": "20"
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "被保番号",
        "dataName": "hihokenshaNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
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
        "columnName": "識別コード",
        "dataName": "shikibetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
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
        "columnName": "被保険者区分",
        "dataName": "hihokenshaKubun",
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
        "sortKey": ""
       },
       {
        "columnName": "氏名",
        "dataName": "shimei",
        "toolTip": "",
        "bgColor": 0,
        "width": 180,
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
        "columnName": "カナ氏名",
        "dataName": "kanaShimsei",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "氏名",
        "dataName": "shimeiAndKanaShimsei",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "性別",
        "dataName": "gender",
        "toolTip": "",
        "bgColor": 0,
        "width": 40,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "生年月日",
        "dataName": "birthDay",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
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
        "sortKey": ""
       },
       {
        "columnName": "住所",
        "dataName": "jusho",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "個人番号",
        "dataName": "kojinNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "住民種別",
        "dataName": "juminShubetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "世帯コード",
        "dataName": "setaiCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       }
      ]
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
     "sortOrder": "defaultDataName3",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "btnReturn",
     "items": [],
     "controlType": "Button",
     "width": "100",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "閉じる",
     "onClick": "onClick_btnReturn",
     "icon": 0,
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "G12",
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
   "selectControlID": "HihokenshaInputGuide",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "被保険者入力補助ガイド",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "HihokenshaInputGuide"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbz/db/dbz/HihokenshaInputGuide/onLoad"
    },
    {
     "eventName": "onClickBtnToSearch_HihokenshaFinder",
     "requestUrl": "dbz/db/dbz/HihokenshaInputGuide/onClickBtnToSearch_HihokenshaFinder"
    },
    {
     "eventName": "onClick_btnToDecide",
     "requestUrl": "dbz/db/dbz/HihokenshaInputGuide/onClick_btnToDecide"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "hihokenshaNo",
     "value": ""
    },
    {
     "propertyName": "hihokenshaMeisho",
     "value": ""
    }
   ],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorder": false,
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
 "businessId": "DBZ",
 "controlName": "HihokenshaInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "hihokenshaNo",
   "controlName": "HihokenshaInputGuide.hihokenshaNo"
  },
  {
   "key": "hihokenshaMeisho",
   "controlName": "HihokenshaInputGuide.hihokenshaMeisho"
  }
 ],
 "dialogOkEventNameForDialog": "onClick_btnToDecide",
 "dialogCancelEventNameForDialog": "onClick_btnReturn",
 "canTransferEvent": true,
 "heightForDialog": "620"
}        
    }
}

