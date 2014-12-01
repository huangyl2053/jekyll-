/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShikakuHenkoRirekiクラスのみで継承して使えます。
     */
    export class ShikakuHenkoRireki_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShikakuHenkoRireki_Design.myLayout, fieldName);
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
   "fieldName": "ShikakuHenkoRireki",
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
     "fieldName": "dgHenko",
     "items": [],
     "controlType": "DataGrid",
     "width": "870px",
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
     "selectControlID": "dgHenko",
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
        "columnName": "変更日",
        "dataName": "henkoDate",
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
        "sortKey": "henkoDate"
       },
       {
        "columnName": "届出日",
        "dataName": "henkoTodokedeDate",
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
        "sortKey": "henkoTodokedeDate"
       },
       {
        "columnName": "変更事由",
        "dataName": "henkoJiyu",
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
        "sortKey": "henkoJiyu"
       },
       {
        "columnName": "変更事由Key",
        "dataName": "henkoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 1,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "henkoJiyuKey"
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
     "onSelect": "onSelect_dgHenko",
     "onSelectByDblClick": "onSelectByDblClick_dgHenko",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton_dgHenko",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgHenko",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "henkoTodokedeDate",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    },
    {
     "fieldName": "HenkoInput",
     "items": [
      {
       "fieldName": "txtHenkoDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
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
       "selectControlID": "txtHenkoDate_core",
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
       "labelLText": "変更日",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": ""
      },
      {
       "fieldName": "txtHenkoTodokedeDate",
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
       "selectControlID": "txtHenkoTodokedeDate_core",
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
       "labelLText": "変更届出日",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": ""
      },
      {
       "fieldName": "ddlHenkoJiyu",
       "items": [],
       "controlType": "DropDownList",
       "width": "150px",
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
       "selectControlID": "ddlHenkoJiyu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "key0",
         "value": "value0"
        },
        {
         "key": "key1",
         "value": "value1"
        }
       ],
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "変更事由",
       "labelRText": "",
       "labelLWidth": "70px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "",
       "isBlankLine": true
      },
      {
       "fieldName": "HenkoHokenshaJoho",
       "items": [
        {
         "fieldName": "ddlHenkoShozaiHokensha",
         "items": [],
         "controlType": "DropDownList",
         "width": "150px",
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
         "selectControlID": "ddlHenkoShozaiHokensha_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "dataSource": [
          {
           "key": "key0",
           "value": "value0"
          },
          {
           "key": "key1",
           "value": "value1"
          }
         ],
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "所在保険者",
         "labelRText": "",
         "labelLWidth": "80px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
         "isBlankLine": true
        },
        {
         "fieldName": "ddlHenkoSochimotoHokensha",
         "items": [],
         "controlType": "DropDownList",
         "width": "150px",
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
         "selectControlID": "ddlHenkoSochimotoHokensha_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "dataSource": [
          {
           "key": "key0",
           "value": "value0"
          },
          {
           "key": "key1",
           "value": "value1"
          }
         ],
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "措置元保険者",
         "labelRText": "",
         "labelLWidth": "100px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
         "isBlankLine": true
        },
        {
         "fieldName": "ddlHenkoKyuHokensha",
         "items": [],
         "controlType": "DropDownList",
         "width": "150px",
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
         "selectControlID": "ddlHenkoKyuHokensha_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "dataSource": [
          {
           "key": "key0",
           "value": "value0"
          },
          {
           "key": "key1",
           "value": "value1"
          }
         ],
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "旧保険者",
         "labelRText": "",
         "labelLWidth": "70px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
         "isBlankLine": true
        },
        {
         "fieldName": "ddlJuminJoho",
         "items": [],
         "controlType": "DropDownList",
         "width": "750px",
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
         "selectControlID": "ddlJuminJoho_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "dataSource": [
          {
           "key": "key0",
           "value": "value0"
          },
          {
           "key": "key1",
           "value": "value1"
          }
         ],
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "住民情報",
         "labelRText": "",
         "labelLWidth": "80px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
         "isBlankLine": true
        }
       ],
       "controlType": "Panel",
       "width": "G2",
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
       "selectControlID": "HenkoHokenshaJoho",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "保険者",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [],
       "requestSettings": [],
       "hiddenInput": [],
       "onOpen": "",
       "onClose": "",
       "session": {},
       "eraseBorder": false,
       "backgroundColor": 0,
       "widthAuto": true,
       "panelDisplay": 1,
       "isGroupBox": false,
       "readOnly": false,
       "height": "Auto",
       "focusPositionID": "labelRTextProperty",
       "canPost": false
      },
      {
       "fieldName": "btnHenkoKakutei",
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
       "selectControlID": "btnHenkoKakutei",
       "helpMessageID": "",
       "jpControlName": "",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnHenkoKakutei",
       "text": "確定する",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      },
      {
       "fieldName": "btnHenkoTorikeshi",
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
       "selectControlID": "btnHenkoTorikeshi",
       "helpMessageID": "",
       "jpControlName": "",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnHenkoTorikeshi",
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
     "width": "870px",
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
     "selectControlID": "HenkoInput",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "資格変更入力",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [],
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
     "readOnly": true,
     "height": "Auto",
     "focusPositionID": "restoreLayoutButton",
     "canPost": false
    }
   ],
   "controlType": "Panel",
   "width": "880px",
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
   "selectControlID": "ShikakuHenkoRireki",
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
   "widthAuto": true,
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
 "controlName": "ShikakuHenkoRireki",
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
   "eventName": "onSelect_dgHenko"
  },
  {
   "eventName": "onSelectByDblClick_dgHenko"
  },
  {
   "eventName": "onSelectByModifyButton_dgHenko"
  },
  {
   "eventName": "onSelectByDeleteButton_dgHenko"
  }
 ],
 "publicEventsAlias": []
}        
    }

     export module ShikakuHenkoRireki {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgHenko(): string {
                return "onSelect_dgHenko";
            }

            public static onSelectByDblClick_dgHenko(): string {
                return "onSelectByDblClick_dgHenko";
            }

            public static onSelectByModifyButton_dgHenko(): string {
                return "onSelectByModifyButton_dgHenko";
            }

            public static onSelectByDeleteButton_dgHenko(): string {
                return "onSelectByDeleteButton_dgHenko";
            }

            public static onClick_btnHenkoKakutei(): string {
                return "onClick_btnHenkoKakutei";
            }

            public static onClick_btnHenkoTorikeshi(): string {
                return "onClick_btnHenkoTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuHenkoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            }

            public ShikakuHenkoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgHenko(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            }

            public HenkoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HenkoInput"));
            }

            public txtHenkoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoDate"));
            }

            public txtHenkoTodokedeDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTodokedeDate"));
            }

            public ddlHenkoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoJiyu"));
            }

            public HenkoHokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HenkoInput_HenkoHokenshaJoho"));
            }

            public ddlHenkoShozaiHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoShozaiHokensha"));
            }

            public ddlHenkoSochimotoHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoSochimotoHokensha"));
            }

            public ddlHenkoKyuHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoKyuHokensha"));
            }

            public ddlJuminJoho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJuminJoho"));
            }

            public btnHenkoKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHenkoKakutei"));
            }

            public btnHenkoTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHenkoTorikeshi"));
            }

        }

     }

}

