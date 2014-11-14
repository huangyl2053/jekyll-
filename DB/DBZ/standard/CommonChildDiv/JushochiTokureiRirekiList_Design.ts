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
     "text": "追加する",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnAdd",
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
     "sortOrder": "tekiyoDate",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    },
    {
     "fieldName": "JutokuInput",
     "items": [
      {
       "fieldName": "JutokuTekiyoInput",
       "items": [
        {
         "fieldName": "txtTekiyoDate",
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
         "selectControlID": "txtTekiyoDate_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "適用日",
         "labelRText": "",
         "labelLWidth": "50px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "ymdKubun": 2,
         "displayFormat": 0
        },
        {
         "fieldName": "txtTekiyoTodokedeDate",
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
         "selectControlID": "txtTekiyoTodokedeDate_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "届出日",
         "labelRText": "",
         "labelLWidth": "50px",
         "labelRWidth": "",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "ymdKubun": 2,
         "displayFormat": 0
        },
        {
         "fieldName": "ddlTekiyoJiyu",
         "items": [],
         "controlType": "DropDownList",
         "width": "140px",
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
         "selectControlID": "ddlTekiyoJiyu_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "適用事由",
         "labelRText": "",
         "labelLWidth": "65px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
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
         "isBlankLine": true
        },
        {
         "fieldName": "tekiyojiHokenshaJoho",
         "items": [
          {
           "fieldName": "ddlTekiyojiShozaiHokensha",
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
           "selectControlID": "ddlTekiyojiShozaiHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
           "isBlankLine": true
          },
          {
           "fieldName": "ddlTekiyojiSochimotoHokensha",
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
           "selectControlID": "ddlTekiyojiSochimotoHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
           "isBlankLine": true
          },
          {
           "fieldName": "ddlTekiyojiKyuHokensha",
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
           "selectControlID": "ddlTekiyojiKyuHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
           "isBlankLine": true
          },
          {
           "fieldName": "ddlTekiyojiJuminJoho",
           "items": [],
           "controlType": "DropDownList",
           "width": "600px",
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
           "selectControlID": "ddlTekiyojiJuminJoho_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
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
         "selectControlID": "tekiyojiHokenshaJoho",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "保険者・住民情報",
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
        }
       ],
       "controlType": "Panel",
       "width": "800px",
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
       "selectControlID": "JutokuTekiyoInput",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "適用情報入力",
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
       "panelDisplay": 1,
       "isGroupBox": false,
       "readOnly": false,
       "height": "Auto",
       "focusPositionID": "restoreLayoutButton",
       "canPost": false
      },
      {
       "fieldName": "JutokuKaijoInput",
       "items": [
        {
         "fieldName": "txtKaijoDate",
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
         "selectControlID": "txtKaijoDate_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "解除日",
         "labelRText": "",
         "labelLWidth": "50px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "ymdKubun": 2,
         "displayFormat": 0
        },
        {
         "fieldName": "txtKaijoTodokedeDate",
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
         "selectControlID": "txtKaijoTodokedeDate_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "placeHolder": "",
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "届出日",
         "labelRText": "",
         "labelLWidth": "50px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "ymdKubun": 2,
         "displayFormat": 0
        },
        {
         "fieldName": "ddlKaijoJiyu",
         "items": [],
         "controlType": "DropDownList",
         "width": "140px",
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
         "selectControlID": "ddlKaijoJiyu_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "解除事由",
         "labelRText": "",
         "labelLWidth": "65px",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "selectedItem": "",
         "dataSource": [
          {
           "key": "key0",
           "value": ""
          },
          {
           "key": "key1",
           "value": ""
          }
         ],
         "isBlankLine": true
        },
        {
         "fieldName": "kaijojiHokenshaJoho",
         "items": [
          {
           "fieldName": "ddlKaijojiShozaiHokensha",
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
           "selectControlID": "ddlKaijojiShozaiHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
           "isBlankLine": true
          },
          {
           "fieldName": "ddlKaijojiSochimotoHokensha",
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
           "selectControlID": "ddlKaijojiSochimotoHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "isBlankLine": true
          },
          {
           "fieldName": "ddlKaijojiKyuHokensha",
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
           "selectControlID": "ddlKaijojiKyuHokensha_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
           "dataSource": [
            {
             "key": "key0",
             "value": ""
            },
            {
             "key": "key1",
             "value": ""
            }
           ],
           "isBlankLine": true
          },
          {
           "fieldName": "ddlKaijojiJuminJono",
           "items": [],
           "controlType": "DropDownList",
           "width": "600px",
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
           "selectControlID": "ddlKaijojiJuminJono_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
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
         "selectControlID": "kaijojiHokenshaJoho",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "保険者・住民情報",
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
         "readOnly": true,
         "height": "Auto",
         "focusPositionID": "labelRTextProperty",
         "canPost": false
        }
       ],
       "controlType": "Panel",
       "width": "800px",
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
       "selectControlID": "JutokuKaijoInput",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "解除情報入力",
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
       "eraseBorder": true,
       "backgroundColor": 0,
       "widthAuto": false,
       "panelDisplay": 1,
       "isGroupBox": false,
       "readOnly": false,
       "height": "Auto",
       "focusPositionID": "restoreLayoutButton",
       "canPost": false
      },
      {
       "fieldName": "btnJutokuKakutei",
       "items": [],
       "controlType": "Button",
       "width": "110px",
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
       "selectControlID": "btnJutokuKakutei",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "確定する",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnJutokuKakutei",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      },
      {
       "fieldName": "btnJutokuTorikeshi",
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
       "selectControlID": "btnJutokuTorikeshi",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "取消する",
       "onBeforeClick": "",
       "onAfterClick": "",
       "onClick": "onClick_btnJutokuTorikeshi",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": true
      }
     ],
     "controlType": "Panel",
     "width": "820px",
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
     "marginRight": "XS",
     "selectControlID": "JutokuInput",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
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

            public static onClick_btnJutokuKakutei(): string {
                return "onClick_btnJutokuKakutei";
            }

            public static onClick_btnJutokuTorikeshi(): string {
                return "onClick_btnJutokuTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgJutoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            }

            public JutokuInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            }

            public JutokuTekiyoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            }

            public txtTekiyoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtTekiyoTodokedeDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            }

            public ddlTekiyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            }

            public tekiyojiHokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            }

            public ddlTekiyojiShozaiHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            }

            public ddlTekiyojiSochimotoHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            }

            public ddlTekiyojiKyuHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            }

            public ddlTekiyojiJuminJoho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            }

            public JutokuKaijoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            }

            public txtKaijoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            }

            public txtKaijoTodokedeDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            }

            public ddlKaijoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            }

            public kaijojiHokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            }

            public ddlKaijojiShozaiHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            }

            public ddlKaijojiSochimotoHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            }

            public ddlKaijojiKyuHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            }

            public ddlKaijojiJuminJono(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            }

            public btnJutokuKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            }

            public btnJutokuTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            }

        }

     }

}

