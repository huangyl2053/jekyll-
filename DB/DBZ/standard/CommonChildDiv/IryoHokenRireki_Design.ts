/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * IryoHokenRirekiクラスのみで継承して使えます。
     */
    export class IryoHokenRireki_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, IryoHokenRireki_Design.myLayout, fieldName);
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
   "fieldName": "IryoHokenRireki",
   "items": [
    {
     "fieldName": "btnAddIryoHoken",
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
     "selectControlID": "btnAddIryoHoken",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnAddIryoHoken",
     "text": "追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": true
    },
    {
     "fieldName": "dgIryoHokenRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "980px",
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
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "state"
       },
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
     "onSelect": "onSelect_dgIryoHokenRireki",
     "onSelectByDblClick": "onSelectByDbClick_dgIryoHokenRireki",
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
     "sortOrder": "hokensha",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    },
    {
     "fieldName": "IryoHokenInput",
     "items": [
      {
       "fieldName": "txtIryoHokenKanyuDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
       "width": "80px",
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
       "selectControlID": "txtIryoHokenKanyuDate_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "加入日",
       "labelRText": "",
       "labelLWidth": "50px",
       "labelRWidth": "0px",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "textKind": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtIryoHokenDattaiDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
       "width": "80px",
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
       "selectControlID": "txtIryoHokenDattaiDate_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "脱退日",
       "labelRText": "",
       "labelLWidth": "50px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "textKind": 0,
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "ddlIryoHokenShubetsu",
       "items": [],
       "controlType": "DropDownList",
       "width": "160px",
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
       "selectControlID": "ddlIryoHokenShubetsu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "kyokai",
         "value": "協会健康保険"
        },
        {
         "key": "kumiai",
         "value": "組合健康保険"
        },
        {
         "key": "hiyatoi",
         "value": "日雇い健康保険"
        },
        {
         "key": "senin",
         "value": "船員健康保険"
        },
        {
         "key": "kyousai",
         "value": "共済組合保険"
        },
        {
         "key": "ippanKokuminn",
         "value": "一般国民健康保険"
        },
        {
         "key": "taishokuKokumin",
         "value": "退職国民健康保険"
        },
        {
         "key": "kukmiaiKokumin",
         "value": "組合国民健康保険"
        }
       ],
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "種別",
       "labelRText": "",
       "labelLWidth": "35px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "kyokai",
       "isBlankLine": false
      },
      {
       "fieldName": "txtIryoHokenHokenshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "80px",
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
       "selectControlID": "txtIryoHokenHokenshaNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "onBlur_txtIryoHokenHokenshaNo",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "保険者",
       "labelRText": "",
       "labelLWidth": "50px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": "0000000000",
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtIryoHokenHokenshaMeisho",
       "items": [],
       "controlType": "TextBox",
       "width": "250px",
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
       "marginRight": "XS",
       "selectControlID": "txtIryoHokenHokenshaMeisho_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
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
       "fieldName": "txtIryoHokenKigoNo",
       "items": [],
       "controlType": "TextBox",
       "width": "440px",
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
       "selectControlID": "txtIryoHokenKigoNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "記号番号",
       "labelRText": "",
       "labelLWidth": "67px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
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
       "fieldName": "btnIryoHokenKakutei",
       "items": [],
       "controlType": "Button",
       "width": "110px",
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
       "selectControlID": "btnIryoHokenKakutei",
       "helpMessageID": "",
       "jpControlName": "",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnIryoHokenKakutei",
       "text": "確定する",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      },
      {
       "fieldName": "btnIryoHokenTorikeshi",
       "items": [],
       "controlType": "Button",
       "width": "110px",
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
       "marginRight": "0em",
       "selectControlID": "btnIryoHokenTorikeshi",
       "helpMessageID": "",
       "jpControlName": "",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnIryoHokenTorikeshi",
       "text": "取消する",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      }
     ],
     "controlType": "Panel",
     "width": "980px",
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
     "marginLeft": "Default",
     "marginRight": "Default",
     "selectControlID": "IryoHokenInput",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "医療保険",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [],
     "requestSettings": [
      {
       "eventName": "onLoad",
       "requestUrl": ""
      }
     ],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": true,
     "height": "Auto",
     "canPost": true
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
 "originalProperty": [],
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
 "publicEvents": [
  {
   "eventName": "onSelectByModifyButton_dgIryoHokenRireki"
  },
  {
   "eventName": "onSelectByDeleteButton_dgIryoHokenRireki"
  },
  {
   "eventName": "onSelect_dgIryoHokenRireki"
  },
  {
   "eventName": "onSelectByDbClick_dgIryoHokenRireki"
  },
  {
   "eventName": "onClick_btnAddIryoHoken"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module IryoHokenRireki {

        export class Events {

            public static onClick_btnAddIryoHoken(): string {
                return "onClick_btnAddIryoHoken";
            }

            public static onSelect_dgIryoHokenRireki(): string {
                return "onSelect_dgIryoHokenRireki";
            }

            public static onSelectByDbClick_dgIryoHokenRireki(): string {
                return "onSelectByDbClick_dgIryoHokenRireki";
            }

            public static onSelectByModifyButton_dgIryoHokenRireki(): string {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            }

            public static onSelectByDeleteButton_dgIryoHokenRireki(): string {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            }

            public static onBlur_txtIryoHokenHokenshaNo(): string {
                return "onBlur_txtIryoHokenHokenshaNo";
            }

            public static onClick_btnIryoHokenKakutei(): string {
                return "onClick_btnIryoHokenKakutei";
            }

            public static onClick_btnIryoHokenTorikeshi(): string {
                return "onClick_btnIryoHokenTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddIryoHoken(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            }

            public dgIryoHokenRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            }

            public IryoHokenInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            }

            public txtIryoHokenKanyuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            }

            public txtIryoHokenDattaiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            }

            public ddlIryoHokenShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            }

            public txtIryoHokenHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            }

            public txtIryoHokenHokenshaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            }

            public txtIryoHokenKigoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            }

            public btnIryoHokenKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            }

            public btnIryoHokenTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            }

        }

     }

}

