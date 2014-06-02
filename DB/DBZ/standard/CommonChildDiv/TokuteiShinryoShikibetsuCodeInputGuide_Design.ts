/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * TokuteiShinryoShikibetsuCodeInputGuideクラスのみで継承して使えます。
     */
    export class TokuteiShinryoShikibetsuCodeInputGuide_Design extends Uz.CommonChildDiv {
    
        public get onClickDialogBtnCancel() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onClick"];
        }
        
        public set onClickDialogBtnCancel(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[5]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, TokuteiShinryoShikibetsuCodeInputGuide_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onClickDialogBtnCancel");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onClickDialogBtnCancel"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["onClick"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "TokuteiShinryoShikibetsuCodeInputGuide",
   "items": [
    {
     "fieldName": "txtServiceShuruiCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "20",
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
     "selectControlID": "txtServiceShuruiCode_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "識別番号",
     "labelRText": "",
     "labelLWidth": "64",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "2"
    },
    {
     "fieldName": "txtTokuteiShinryoShikibetsuCode",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "35",
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
     "marginLeft": "-0.2",
     "marginRight": "XS",
     "selectControlID": "txtTokuteiShinryoShikibetsuCode_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "4"
    },
    {
     "fieldName": "btnSearchTokuteiShinryoShikibetsuCode",
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
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "btnSearchTokuteiShinryoShikibetsuCode",
     "text": "コードを検索する",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    },
    {
     "fieldName": "txtKijunYM",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "60",
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
     "selectControlID": "txtKijunYM_core",
     "required": false,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "基準年月",
     "labelRText": "",
     "labelLWidth": "64",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 1,
     "displayFormat": 0
    },
    {
     "fieldName": "dgTokuteiShinryoShikibetsuCode",
     "items": [],
     "controlType": "DataGrid",
     "width": "570",
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
     "selectControlID": "dgTokuteiShinryoShikibetsuCode",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": false,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "確定",
        "dataName": "btnSelectRow",
        "toolTip": "",
        "bgColor": 0,
        "width": 50,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "...",
         "onClick": "onClick_btnSelectRow",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "btnSelectRow"
       },
       {
        "columnName": "特定診療識別コード",
        "dataName": "txtTokuteiShinryoShikibetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 500,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTokuteiShinryoShikibetsuCode"
       }
      ]
     },
     "height": "M",
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtTokuteiShinryoShikibetsuCode",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "btnCancel",
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
     "selectControlID": "btnCancel",
     "text": "コード検索をやめる",
     "onClick": "onClick_btnCloseDialog",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0
    }
   ],
   "controlType": "Panel",
   "width": "590",
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
   "selectControlID": "TokuteiShinryoShikibetsuCodeInputGuide",
   "onLoad": "",
   "title": "特定診療識別コード選択",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "TokuteiShinryoShikibetsuCodeInputGuide"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
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
 "controlName": "TokuteiShinryoShikibetsuCodeInputGuide",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnCancel",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickDialogBtnCancel"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "onClick_btnSelectRow",
 "dialogCancelEventNameForDialog": "onClick_btnCloseDialog"
}        
    }
}

