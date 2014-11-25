/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module JigyoshaInputGuide {

        export class Events {

            public static get onClick_btnSearchJigyosha(): string {
                return "onClick_btnSearchJigyosha";
            }
            public static get onSelectBySelectButton_dgSearchResultJigyosha(): string {
                return "onSelectBySelectButton_dgSearchResultJigyosha";
            }
            public static get onClick_btnKaigoHokenShisetsuReturn(): string {
                return "onClick_btnKaigoHokenShisetsuReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "JigyoshaInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public JigyoshaInputGuide() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public radJigyoshaSearchType() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radJigyoshaSearchType"));

            }

            public txtJigyoshaCode() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));

            }

            public btnSearchJigyosha() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));

            }

            public SearchResultJigyosha() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("SearchResultJigyosha"));

            }

            public dgSearchResultJigyosha() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgSearchResultJigyosha"));

            }

            public btnKaigoHokenShisetsuReturn() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnKaigoHokenShisetsuReturn"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class JigyoshaInputGuide_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, JigyoshaInputGuide_Design.myLayout, fieldName);
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
   "fieldName": "JigyoshaInputGuide",
   "items": [
    {
     "fieldName": "radJigyoshaSearchType",
     "items": [],
     "controlType": "RadioButton",
     "width": "500",
     "visible": true,
     "displayNone": true,
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
     "selectControlID": "radJigyoshaSearchType_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "onClick": "",
     "icon": [],
     "dataSource": [
      {
       "key": "keyJigyosha",
       "value": "事業者検索"
      },
      {
       "key": "keyMeisho",
       "value": "名称検索"
      },
      {
       "key": "keyJusho",
       "value": "住所検索"
      },
      {
       "key": "keyJigyoshaCodeUchiwake",
       "value": "事業者コード内訳検索"
      }
     ],
     "onChange": "",
     "selectedItem": null,
     "required": false,
     "labelLText": "",
     "labelLWidth": "S",
     "labelLAlign": 2,
     "newLineItemNumber": 4,
     "spaceSize": "M",
     "disabledItem": []
    },
    {
     "fieldName": "txtJigyoshaCode",
     "items": [],
     "controlType": "TextBox",
     "width": "100",
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
     "selectControlID": "txtJigyoshaCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
     "onChange": "",
     "required": false,
     "labelLText": "事業者コード",
     "labelRText": "※前方一致",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "onFocus": "",
     "onBlur": "",
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onKeyPress": "",
     "value": "",
     "decorationClass": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "textKind": 0,
     "isComboBox": false,
     "suggest": [],
     "permitCharactor": ""
    },
    {
     "fieldName": "btnSearchJigyosha",
     "items": [],
     "controlType": "Button",
     "width": "145",
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
     "marginRight": "XS",
     "selectControlID": "btnSearchJigyosha",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnSearchJigyosha",
     "text": "事業者を表示する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "SearchResultJigyosha",
     "items": [
      {
       "fieldName": "dgSearchResultJigyosha",
       "items": [],
       "controlType": "DataGrid",
       "width": "1070",
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
       "selectControlID": "dgSearchResultJigyosha",
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
          "columnName": "事業者コード",
          "dataName": "jigyoshaCode",
          "toolTip": "",
          "bgColor": 0,
          "width": 0,
          "visible": false,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "jigyoshaCode"
         },
         {
          "columnName": "事業者名称",
          "dataName": "jigyoshaMeisho",
          "toolTip": "",
          "bgColor": 0,
          "width": 0,
          "visible": false,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": false,
          "isPrivateInfo": false,
          "sortKey": "jigyoshaMeisho"
         },
         {
          "columnName": "事業者",
          "dataName": "jigyosha",
          "toolTip": "",
          "bgColor": 0,
          "width": 270,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "jigyosha"
         },
         {
          "columnName": "住所",
          "dataName": "jusho",
          "toolTip": "",
          "bgColor": 0,
          "width": 320,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "jusho"
         },
         {
          "columnName": "サービス",
          "dataName": "service",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
          "visible": true,
          "cellType": 0,
          "cellDetails": {
           "cellType": 0
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "service"
         },
         {
          "columnName": "認定開始日",
          "dataName": "ninteiKaishiDate",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
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
          "sortKey": "ninteiKaishiDate"
         },
         {
          "columnName": "認定終了日",
          "dataName": "ninteiShuryoDate",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
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
          "sortKey": "ninteiShuryoDate"
         },
         {
          "columnName": "社福法人軽減対象",
          "dataName": "keigenTaisho",
          "toolTip": "",
          "bgColor": 0,
          "width": 140,
          "visible": true,
          "cellType": 0,
          "cellDetails": null,
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "keigenTaisho"
         }
        ]
       },
       "onSort": "",
       "onSelect": "",
       "onSelectByDblClick": "",
       "onSelectBySelectButton": "onSelectBySelectButton_dgSearchResultJigyosha",
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
       "dataSource": [],
       "sortOrder": "service",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1
      }
     ],
     "controlType": "Panel",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "SearchResultJigyosha",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "事業者一覧",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchResultJigyosha"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
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
    },
    {
     "fieldName": "btnKaigoHokenShisetsuReturn",
     "items": [],
     "controlType": "Button",
     "width": "145",
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
     "selectControlID": "btnKaigoHokenShisetsuReturn",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnKaigoHokenShisetsuReturn",
     "text": "閉じる",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "1080",
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
   "selectControlID": "JigyoshaInputGuide",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "事業者入力ガイド",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "JigyoshaInputGuide"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onSelectBySelectButton_dgSearchResultJigyosha",
     "requestUrl": "dbz/db/dbz/JigyoshaInputGuide/onSelectBySelectButton_dgSearchResultJigyosha"
    },
    {
     "eventName": "onClick_btnSearchJigyosha",
     "requestUrl": "dbz/db/dbz/JigyoshaInputGuide/onClick_btnSearchJigyosha"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "jigyoshaCode",
     "value": ""
    },
    {
     "propertyName": "jigyoshaMeisho",
     "value": ""
    },
    {
     "propertyName": "jigyoshaCodeMeisho",
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
 "controlName": "JigyoshaInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [
  {
   "key": "jigyoshaCode",
   "controlName": "JigyoshaInputGuide.jigyoshaCode"
  },
  {
   "key": "jigyoshaMeisho",
   "controlName": "JigyoshaInputGuide.jigyoshaMeisho"
  },
  {
   "key": "jigyoshaCodeMeisho",
   "controlName": "JigyoshaInputGuide.jigyoshaCodeMeisho"
  }
 ],
 "dialogOkEventNameForDialog": "onSelectBySelectButton_dgSearchResultJigyosha",
 "dialogCancelEventNameForDialog": "onClick_btnKaigoHokenShisetsuReturn",
 "canTransferEvent": true,
 "heightForDialog": "Auto"
}        
    }
}

