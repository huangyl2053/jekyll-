/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module SeikatsuhogoRireki {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "SeikatsuhogoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public SeikatsuhogoRireki() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public btnAddRow() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnAddRow"));

            }

            public dgSeikatsuhogoRireki() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgSeikatsuhogoRireki"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class SeikatsuhogoRireki_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, SeikatsuhogoRireki_Design.myLayout, fieldName);
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
   "fieldName": "SeikatsuhogoRireki",
   "items": [
    {
     "fieldName": "btnAddRow",
     "items": [],
     "controlType": "Button",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnAddRow",
     "onClick": "",
     "text": "生活保護情報を追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "dgSeikatsuhogoRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "1075",
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
     "selectControlID": "dgSeikatsuhogoRireki",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "header": {
       "combineColumns": [
        {
         "combineColumnName": "介護保険料代理納付",
         "combineItem": [
          "txtHokenryoDairiNofuKubun",
          "txtHokenryoDairiNofuYM"
         ]
        },
        {
         "combineColumnName": "救護施設",
         "combineItem": [
          "txtKyugoshisetsuNyutaishoKubun",
          "txtKyugoshisetsuNyushoDate",
          "txtKyugoshisetsuTaishoDate"
         ]
        }
       ],
       "frozenColumn": "",
       "headerHeight": 1
      },
      "columns": [
       {
        "columnName": "修<br>正",
        "dataName": "btnModifyRow",
        "toolTip": "",
        "bgColor": 0,
        "width": 50,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "...",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "削<br>除",
        "dataName": "btnDeleteRow",
        "toolTip": "",
        "bgColor": 0,
        "width": 50,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "...",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "受給者<br>番号",
        "dataName": "txtJukyushaNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 4,
        "cellDetails": {
         "cellType": 4,
         "maxLength": "1000000000000",
         "minLength": "0",
         "formatLength": "8",
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtJukyushaNo"
       },
       {
        "columnName": "開始<br>年月",
        "dataName": "txtKaishiYM",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 1,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtKaishiYM"
       },
       {
        "columnName": "廃止<br>年月",
        "dataName": "txtHaishiYM",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 1,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtHaishiYM"
       },
       {
        "columnName": "区分",
        "dataName": "txtHokenryoDairiNofuKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtHokenryoDairiNofuKubun"
       },
       {
        "columnName": "区分<br>年月",
        "dataName": "txtHokenryoDairiNofuYM",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 1,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtHokenryoDairiNofuYM"
       },
       {
        "columnName": "入退所<br>区分",
        "dataName": "txtKyugoshisetsuNyutaishoKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtKyugoshisetsuNyutaishoKubun"
       },
       {
        "columnName": "入所日",
        "dataName": "txtKyugoshisetsuNyushoDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtKyugoshisetsuNyushoDate"
       },
       {
        "columnName": "退所日",
        "dataName": "txtKyugoshisetsuTaishoDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtKyugoshisetsuTaishoDate"
       },
       {
        "columnName": "扶助種類",
        "dataName": "txtFujoShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 260,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtFujoShurui"
       }
      ]
     },
     "height": "S",
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtHaishiYM",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    }
   ],
   "controlType": "Panel",
   "width": "1090",
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
   "marginRight": "XS",
   "selectControlID": "SeikatsuhogoRireki",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "SeikatsuhogoRireki"
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
   "widthAuto": false,
   "panelDisplay": 0,
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
 "selectControlID": "defaultLayout",
 "relation": [],
 "businessId": "DBZ",
 "controlName": "SeikatsuhogoRireki",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

