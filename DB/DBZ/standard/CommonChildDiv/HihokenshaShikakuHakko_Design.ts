/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HihokenshaShikakuHakkoクラスのみで継承して使えます。
     */
    export class HihokenshaShikakuHakko_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HihokenshaShikakuHakko_Design.myLayout, fieldName);
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
   "fieldName": "HihokenshaShikakuHakko",
   "items": [
    {
     "fieldName": "YukoKiGenInfo",
     "items": [
      {
       "fieldName": "txtYokuKiGen",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "txtYokuKiGen_core",
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
       "labelLText": "有効期限",
       "labelRText": "",
       "labelLWidth": "85px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtKofuDate",
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
       "selectControlID": "txtKofuDate_core",
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
       "labelLText": "交付日",
       "labelRText": "",
       "labelLWidth": "XS",
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
       "fieldName": "txtHokensha",
       "items": [],
       "controlType": "TextBox",
       "width": "210px",
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
       "marginRight": "XS",
       "selectControlID": "txtHokensha_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "保険者",
       "labelRText": "",
       "labelLWidth": "65px",
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
       "fieldName": "ddlKofuJiyu",
       "items": [],
       "controlType": "DropDownList",
       "width": "132px",
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
       "selectControlID": "ddlKofuJiyu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "交付事由",
       "labelRText": "",
       "labelLWidth": "65px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "notSelected",
       "dataSource": [
        {
         "key": "notSelected",
         "value": ""
        },
        {
         "key": "shikakuShutoku",
         "value": "資格取得"
        },
        {
         "key": "yokaigoNintei",
         "value": "要介護認定"
        },
        {
         "key": "kyojuKeikaku",
         "value": "居住計画"
        },
        {
         "key": "kyufuSeigen",
         "value": "給付制限"
        },
        {
         "key": "jutokuTekiyo",
         "value": "住所地特例適用"
        },
        {
         "key": "jutokuKaijo",
         "value": "住所地特例解除"
        },
        {
         "key": "koikiTenkyo",
         "value": "広域転居"
        },
        {
         "key": "kigenGire",
         "value": "期限切れ"
        },
        {
         "key": "yoshikiHenko",
         "value": "様式変更"
        },
        {
         "key": "kisaiHenko",
         "value": "記載変更"
        },
        {
         "key": "saikofu",
         "value": "再交付"
        }
       ],
       "isBlankLine": false
      }
     ],
     "controlType": "Panel",
     "width": "950px",
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
     "selectControlID": "YukoKiGenInfo",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "0px",
     "marginBottom": "0px",
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
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "focusPositionID": "ControlList",
     "canPost": false
    },
    {
     "fieldName": "NinteiInfo",
     "items": [
      {
       "fieldName": "txtYokaigodo",
       "items": [],
       "controlType": "TextBox",
       "width": "50px",
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
       "selectControlID": "txtYokaigodo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "要介護状態",
       "labelRText": "",
       "labelLWidth": "85px",
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
       "fieldName": "txtNinteiYMD",
       "items": [],
       "controlType": "TextBoxDate",
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
       "selectControlID": "txtNinteiYMD_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "認定日",
       "labelRText": "",
       "labelLWidth": "80px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtNinteiYukoFromYMD",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "85px",
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
       "marginRight": "XS",
       "selectControlID": "txtNinteiYukoFromYMD_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "有効期間",
       "labelRText": "",
       "labelLWidth": "65px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "lblKara1",
       "items": [],
       "controlType": "Label",
       "width": "20px",
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
       "selectControlID": "lblKara1",
       "helpMessageID": "",
       "jpControlName": "",
       "required": false,
       "isPrivateInfo": false,
       "text": "～",
       "decorationClass": "",
       "align": 2
      },
      {
       "fieldName": "txtNinteiYukoToYMD",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "85px",
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
       "selectControlID": "txtNinteiYukoToYMD_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtShinseiDate",
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
       "selectControlID": "txtShinseiDate_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": true,
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "申請日",
       "labelRText": "",
       "labelLWidth": "68px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "decorationClass": "",
       "textKind": 0,
       "permitCharactor": "./_-"
      }
     ],
     "controlType": "Panel",
     "width": "950px",
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
     "selectControlID": "NinteiInfo",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "0px",
     "marginBottom": "0px",
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
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "focusPositionID": "ControlList",
     "canPost": false
    },
    {
     "fieldName": "tabHihokenshaShikakuShosai",
     "items": [
      {
       "fieldName": "tplGendoGaku",
       "items": [
        {
         "fieldName": "tblGendoGaku",
         "items": [
          {
           "fieldName": "celKubunGendoGaku",
           "items": [
            {
             "fieldName": "KubunGendoGaku",
             "items": [
              {
               "fieldName": "txtKubunShikyuGendoKijunGaku",
               "items": [],
               "controlType": "TextBoxNum",
               "width": "50px",
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
               "selectControlID": "txtKubunShikyuGendoKijunGaku_core",
               "helpMessageID": "",
               "jpControlName": "",
               "readOnly": true,
               "required": false,
               "placeHolder": "",
               "isPrivateInfo": false,
               "isPassword": false,
               "onFocus": "",
               "onBlur": "",
               "onChange": "",
               "onKeyPress": "",
               "text": "",
               "labelLText": "基準額",
               "labelRText": "",
               "labelLWidth": "55px",
               "labelRWidth": "S",
               "labelLAlign": 2,
               "labelRAlign": 0,
               "value": "",
               "decorationClass": "",
               "maxLength": 100000000,
               "minLength": 0,
               "textAlign": 2,
               "textKind": 2,
               "isComboBox": false,
               "suggest": [],
               "maxValue": 1.7976931348623157e+308,
               "minValue": 0,
               "isCurrency": false,
               "isComma": true,
               "decimalPointLength": 0,
               "permitCharactor": "+-,.\\"
              },
              {
               "fieldName": "txtYukoFromYMD",
               "items": [],
               "controlType": "TextBoxDate",
               "width": "85px",
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
               "marginRight": "XS",
               "selectControlID": "txtYukoFromYMD_core",
               "helpMessageID": "",
               "jpControlName": "",
               "readOnly": true,
               "required": false,
               "placeHolder": "",
               "isPrivateInfo": false,
               "isPassword": false,
               "onFocus": "",
               "onBlur": "",
               "onChange": "",
               "onKeyPress": "",
               "text": "",
               "labelLText": "有効期間",
               "labelRText": "",
               "labelLWidth": "80px",
               "labelRWidth": "S",
               "labelLAlign": 2,
               "labelRAlign": 0,
               "ymdKubun": 2,
               "displayFormat": 0,
               "value": "",
               "decorationClass": "",
               "permitCharactor": "./_-"
              },
              {
               "fieldName": "lblKara",
               "items": [],
               "controlType": "Label",
               "width": "20px",
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
               "selectControlID": "lblKara",
               "helpMessageID": "",
               "jpControlName": "",
               "required": false,
               "isPrivateInfo": false,
               "text": "～",
               "decorationClass": "",
               "align": 2
              },
              {
               "fieldName": "txtYukoToYMD",
               "items": [],
               "controlType": "TextBoxDate",
               "width": "85px",
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
               "selectControlID": "txtYukoToYMD_core",
               "helpMessageID": "",
               "jpControlName": "",
               "readOnly": true,
               "required": false,
               "placeHolder": "",
               "isPrivateInfo": false,
               "isPassword": false,
               "onFocus": "",
               "onBlur": "",
               "onChange": "",
               "onKeyPress": "",
               "text": "",
               "labelLText": "",
               "labelRText": "",
               "labelLWidth": "S",
               "labelRWidth": "S",
               "labelLAlign": 2,
               "labelRAlign": 0,
               "ymdKubun": 2,
               "displayFormat": 0,
               "value": "",
               "decorationClass": "",
               "permitCharactor": "./_-"
              }
             ],
             "controlType": "Panel",
             "width": "G2",
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
             "selectControlID": "KubunGendoGaku",
             "helpMessageID": "",
             "jpControlName": "",
             "onLoad": "",
             "title": "区分支給限度額",
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
             "widthAuto": true,
             "panelDisplay": 1,
             "isGroupBox": false,
             "readOnly": false,
             "height": "Auto",
             "focusPositionID": "BasicControlArea",
             "canPost": false
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKubunGendoGaku",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C1"
          },
          {
           "fieldName": "celShuruiGendoKijungaku",
           "items": [
            {
             "fieldName": "ShuruiShikyuGendoKijungaku",
             "items": [
              {
               "fieldName": "dgShuruiShikyuGendoKijunGaku",
               "items": [],
               "controlType": "DataGrid",
               "width": "390px",
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
               "selectControlID": "dgShuruiShikyuGendoKijunGaku",
               "helpMessageID": "",
               "jpControlName": "",
               "readOnly": false,
               "height": "200px",
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
                "selectLimitRowCount": 0,
                "header": {
                 "combineColumns": [],
                 "frozenColumn": "",
                 "headerHeight": 0
                },
                "columns": [
                 {
                  "columnName": "サービス種類",
                  "dataName": "serviceShurui",
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
                  "sortKey": ""
                 },
                 {
                  "columnName": "限度額",
                  "dataName": "gendoGaku",
                  "toolTip": "",
                  "bgColor": 0,
                  "width": 100,
                  "visible": true,
                  "cellType": 0,
                  "cellDetails": {
                   "cellType": 0
                  },
                  "align": 2,
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
               "sortOrder": "serviceShurui",
               "isAscending": true,
               "filterList": [],
               "activeRowId": -1,
               "gridAction": []
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
             "selectControlID": "ShuruiShikyuGendoKijungaku",
             "helpMessageID": "",
             "jpControlName": "",
             "onLoad": "",
             "title": "うち種類支給限度基準額",
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
             "widthAuto": true,
             "panelDisplay": 1,
             "isGroupBox": false,
             "readOnly": false,
             "height": "Auto",
             "focusPositionID": "restoreLayoutButton",
             "canPost": true
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShuruiGendoKijungaku",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C2"
          }
         ],
         "controlType": "TablePanel",
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
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "tblGendoGaku",
         "helpMessageID": "",
         "jpControlName": "",
         "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td></tr>\n  </tbody>\n</table>\n"
        }
       ],
       "controlType": "TabPanel",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplGendoGaku",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "限度額",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplShinsakaiIken",
       "items": [
        {
         "fieldName": "lblShinsakaiIken",
         "items": [],
         "controlType": "Label",
         "width": "290px",
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
         "selectControlID": "lblShinsakaiIken",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "認定審査会意見及びサービス種類の指定",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "txtShinsakaiIken",
         "items": [],
         "controlType": "TextBoxMultiLine",
         "width": "800px",
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
         "selectControlID": "txtShinsakaiIken_text_area",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "100px",
         "required": false,
         "placeHolder": "",
         "isPrivateInfo": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "",
         "labelRText": "",
         "labelLWidth": "XS",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "decorationClass": "",
         "maxLength": "198",
         "minLength": 0,
         "textKind": 0,
         "limitLength": "198",
         "countDisp": true
        }
       ],
       "controlType": "TabPanel",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplShinsakaiIken",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "審査会意見",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplKyufuSeigen",
       "items": [
        {
         "fieldName": "lblKyufuSeigen",
         "items": [],
         "controlType": "Label",
         "width": "70px",
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
         "selectControlID": "lblKyufuSeigen",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "給付制限",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "tblKyuhuSeigen",
         "items": [
          {
           "fieldName": "celKyufuSeigenNaiyoTitle",
           "items": [
            {
             "fieldName": "lblKyufuSeigenNaiyo",
             "items": [],
             "controlType": "Label",
             "width": "70px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblKyufuSeigenNaiyo",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "制限内容",
             "decorationClass": "",
             "align": 2
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenNaiyoTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C1"
          },
          {
           "fieldName": "celKyufuSeigenKikanTitle",
           "items": [
            {
             "fieldName": "lblKyufuSeigenKikan",
             "items": [],
             "controlType": "Label",
             "width": "235px",
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
             "selectControlID": "lblKyufuSeigenKikan",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "制限期間",
             "decorationClass": "",
             "align": 1
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenKikanTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C2"
          },
          {
           "fieldName": "celKyufuSeigenNaiyo1",
           "items": [
            {
             "fieldName": "txtKyufuSeigenNaiyo1",
             "items": [],
             "controlType": "TextBox",
             "width": "200px",
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
             "selectControlID": "txtKyufuSeigenNaiyo1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenNaiyo1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C1"
          },
          {
           "fieldName": "celKyufuSeigenKikan1",
           "items": [
            {
             "fieldName": "txtKyufuSeigenKikan1",
             "items": [],
             "controlType": "TextBoxDateRange",
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
             "selectControlID": "txtKyufuSeigenKikan1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
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
             "ymdKubun": 2,
             "displayFormat": 0,
             "permitCharactor": "",
             "fromPlaceHolder": "",
             "toPlaceHolder": "",
             "minDate": "",
             "maxDate": "",
             "fromText": "",
             "toText": "",
             "fromValue": "",
             "toValue": "",
             "fromSelectControlID": "txtKyufuSeigenKikan1From",
             "toSelectControlID": "txtKyufuSeigenKikan1To",
             "autoRangeTo": true
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenKikan1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C2"
          },
          {
           "fieldName": "celKyufuSeigenNaiyo2",
           "items": [
            {
             "fieldName": "txtKyufuSeigenNaiyo2",
             "items": [],
             "controlType": "TextBox",
             "width": "200px",
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
             "selectControlID": "txtKyufuSeigenNaiyo2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenNaiyo2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C1"
          },
          {
           "fieldName": "celKyufuSeigenKikan2",
           "items": [
            {
             "fieldName": "txtKyufuSeigenKikan2",
             "items": [],
             "controlType": "TextBoxDateRange",
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
             "selectControlID": "txtKyufuSeigenKikan2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
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
             "ymdKubun": 2,
             "displayFormat": 0,
             "permitCharactor": "",
             "fromPlaceHolder": "",
             "toPlaceHolder": "",
             "minDate": "",
             "maxDate": "",
             "fromText": "",
             "toText": "",
             "fromValue": "",
             "toValue": "",
             "fromSelectControlID": "txtKyufuSeigenKikan2From",
             "toSelectControlID": "txtKyufuSeigenKikan2To",
             "autoRangeTo": true
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenKikan2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C2"
          },
          {
           "fieldName": "celKyufuSeigenNaiyo3",
           "items": [
            {
             "fieldName": "txtKyufuSeigenNaiyo3",
             "items": [],
             "controlType": "TextBox",
             "width": "200px",
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
             "selectControlID": "txtKyufuSeigenNaiyo3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenNaiyo3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C1"
          },
          {
           "fieldName": "celKyufuSeigenKikan3",
           "items": [
            {
             "fieldName": "txtKyufuSeigenKikan3",
             "items": [],
             "controlType": "TextBoxDateRange",
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
             "selectControlID": "txtKyufuSeigenKikan3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
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
             "ymdKubun": 2,
             "displayFormat": 0,
             "permitCharactor": "",
             "fromPlaceHolder": "",
             "toPlaceHolder": "",
             "minDate": "",
             "maxDate": "",
             "fromText": "",
             "toText": "",
             "fromValue": "",
             "toValue": "",
             "fromSelectControlID": "txtKyufuSeigenKikan3From",
             "toSelectControlID": "txtKyufuSeigenKikan3To",
             "autoRangeTo": true
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celKyufuSeigenKikan3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C2"
          }
         ],
         "controlType": "TablePanel",
         "width": "XS",
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
         "selectControlID": "tblKyuhuSeigen",
         "helpMessageID": "",
         "jpControlName": "",
         "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1'></td><td id='R4C2'></td></tr>\n  </tbody>\n</table>\n"
        }
       ],
       "controlType": "TabPanel",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplKyufuSeigen",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "給付制限",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplShienJigyosha",
       "items": [
        {
         "fieldName": "lblShienJigyosha",
         "items": [],
         "controlType": "Label",
         "width": "275px",
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
         "selectControlID": "lblShienJigyosha",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "居住介護支援事業者及び事業者の名称",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "tblJigyosha",
         "items": [
          {
           "fieldName": "celJigyoshaTitle",
           "items": [
            {
             "fieldName": "lblJigyosha",
             "items": [],
             "controlType": "Label",
             "width": "55px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblJigyosha",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "事業者",
             "decorationClass": "",
             "align": 2
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celJigyoshaTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C1"
          },
          {
           "fieldName": "celTodokedeDateTitle",
           "items": [
            {
             "fieldName": "lblTodokedeDate",
             "items": [],
             "controlType": "Label",
             "width": "96px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblTodokedeDate",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "届出日",
             "decorationClass": "",
             "align": 1
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTodokedeDateTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C2"
          },
          {
           "fieldName": "celJigyosha1",
           "items": [
            {
             "fieldName": "txtJigyosha1",
             "items": [],
             "controlType": "TextBox",
             "width": "500px",
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
             "selectControlID": "txtJigyosha1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celJigyosha1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C1"
          },
          {
           "fieldName": "celTodokedeDate1",
           "items": [
            {
             "fieldName": "txtTodokedeYMD1",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTodokedeYMD1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTodokedeDate1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C2"
          },
          {
           "fieldName": "celJigyosha2",
           "items": [
            {
             "fieldName": "txtJigyosha2",
             "items": [],
             "controlType": "TextBox",
             "width": "500px",
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
             "selectControlID": "txtJigyosha2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celJigyosha2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C1"
          },
          {
           "fieldName": "celTodokedeDate2",
           "items": [
            {
             "fieldName": "txtTodokedeYMD2",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTodokedeYMD2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTodokedeDate2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C2"
          },
          {
           "fieldName": "celJigyosha3",
           "items": [
            {
             "fieldName": "txtJigyosha3",
             "items": [],
             "controlType": "TextBox",
             "width": "500px",
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
             "selectControlID": "txtJigyosha3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celJigyosha3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C1"
          },
          {
           "fieldName": "celTodokedeDate3",
           "items": [
            {
             "fieldName": "txtTodokedeYMD3",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTodokedeYMD3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTodokedeDate3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C2"
          },
          {
           "fieldName": "celTekiyoStYMD",
           "items": [
            {
             "fieldName": "lblTekiyoStYMD",
             "items": [],
             "controlType": "Label",
             "width": "96px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblTekiyoStYMD",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "適用開始日",
             "decorationClass": "",
             "align": 1
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTekiyoStYMD",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C3"
          },
          {
           "fieldName": "celTekiyoStYMD1",
           "items": [
            {
             "fieldName": "txtTekiyoStYMD1",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTekiyoStYMD1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTekiyoStYMD1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C3"
          },
          {
           "fieldName": "celTekiyoStYMD2",
           "items": [
            {
             "fieldName": "txtTekiyoStYMD2",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTekiyoStYMD2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTekiyoStYMD2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C3"
          },
          {
           "fieldName": "celTekiyoStYMD3",
           "items": [
            {
             "fieldName": "txtTekiyoStYMD3",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtTekiyoStYMD3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celTekiyoStYMD3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C3"
          }
         ],
         "controlType": "TablePanel",
         "width": "XS",
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
         "selectControlID": "tblJigyosha",
         "helpMessageID": "",
         "jpControlName": "",
         "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td><td id='R1C3' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td></tr>\n    <tr><td id='R4C1'></td><td id='R4C2'></td><td id='R4C3'></td></tr>\n  </tbody>\n</table>\n"
        }
       ],
       "controlType": "TabPanel",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplShienJigyosha",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "支援事業者",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      },
      {
       "fieldName": "tplShisetsuNyutaisho",
       "items": [
        {
         "fieldName": "lblKaigoHokensha",
         "items": [],
         "controlType": "Label",
         "width": "115px",
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
         "selectControlID": "lblKaigoHokensha",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "介護保険施設等",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "tblShisetsuNyutaisho",
         "items": [
          {
           "fieldName": "celShisetsuNyushoDateTitle",
           "items": [
            {
             "fieldName": "lblShisetsuNyushoDate",
             "items": [],
             "controlType": "Label",
             "width": "96px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblShisetsuNyushoDate",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "入所日",
             "decorationClass": "",
             "align": 1
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuNyushoDateTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C1"
          },
          {
           "fieldName": "celShisetsuTaishoDateTitle",
           "items": [
            {
             "fieldName": "lblShisetsuTaishoDate",
             "items": [],
             "controlType": "Label",
             "width": "96px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblShisetsuTaishoDate",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "退所日",
             "decorationClass": "",
             "align": 1
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuTaishoDateTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C2"
          },
          {
           "fieldName": "celNyushoShisetsuTitle",
           "items": [
            {
             "fieldName": "lblNyushoShisetsu",
             "items": [],
             "controlType": "Label",
             "width": "70px",
             "visible": true,
             "displayNone": false,
             "disabled": false,
             "accessKey": "",
             "nextFocusFieldName": "",
             "wrap": true,
             "dependencies": [],
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "lblNyushoShisetsu",
             "helpMessageID": "",
             "jpControlName": "",
             "required": false,
             "isPrivateInfo": false,
             "text": "入所施設",
             "decorationClass": "",
             "align": 2
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celNyushoShisetsuTitle",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R1C3"
          },
          {
           "fieldName": "celShisetsuNyushoDate1",
           "items": [
            {
             "fieldName": "txtShisetsuNyushoDate1",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuNyushoDate1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuNyushoDate1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C1"
          },
          {
           "fieldName": "celShisetsuTaishoDate1",
           "items": [
            {
             "fieldName": "txtShisetsuTaishoDate1",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuTaishoDate1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuTaishoDate1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C2"
          },
          {
           "fieldName": "celNyushoShisetsu1",
           "items": [
            {
             "fieldName": "txtNyushoShisetsu1",
             "items": [],
             "controlType": "TextBox",
             "width": "350px",
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
             "selectControlID": "txtNyushoShisetsu1_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celNyushoShisetsu1",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R2C3"
          },
          {
           "fieldName": "celShisetsuNyushoDate2",
           "items": [
            {
             "fieldName": "txtShisetsuNyushoDate2",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuNyushoDate2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuNyushoDate2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C1"
          },
          {
           "fieldName": "celShisetsuTaishoDate2",
           "items": [
            {
             "fieldName": "txtShisetsuTaishoDate2",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuTaishoDate2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuTaishoDate2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C2"
          },
          {
           "fieldName": "celNyushoShisetsu2",
           "items": [
            {
             "fieldName": "txtNyushoShisetsu2",
             "items": [],
             "controlType": "TextBox",
             "width": "350px",
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
             "selectControlID": "txtNyushoShisetsu2_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celNyushoShisetsu2",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R3C3"
          },
          {
           "fieldName": "celShisetsuNyushoDate3",
           "items": [
            {
             "fieldName": "txtShisetsuNyushoDate3",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuNyushoDate3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuNyushoDate3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C1"
          },
          {
           "fieldName": "celShisetsuTaishoDate3",
           "items": [
            {
             "fieldName": "txtShisetsuTaishoDate3",
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
             "float": 1,
             "toolTip": "",
             "authorityMode": 0,
             "marginLeft": "XS",
             "marginRight": "XS",
             "selectControlID": "txtShisetsuTaishoDate3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "S",
             "labelRWidth": "S",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "ymdKubun": 2,
             "displayFormat": 0,
             "value": "",
             "decorationClass": "",
             "textKind": 0,
             "permitCharactor": "./_-"
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celShisetsuTaishoDate3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C2"
          },
          {
           "fieldName": "celNyushoShisetsu3",
           "items": [
            {
             "fieldName": "txtNyushoShisetsu3",
             "items": [],
             "controlType": "TextBox",
             "width": "350px",
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
             "selectControlID": "txtNyushoShisetsu3_core",
             "helpMessageID": "",
             "jpControlName": "",
             "readOnly": true,
             "required": false,
             "placeHolder": "",
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
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
            }
           ],
           "controlType": "TableCell",
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
           "selectControlID": "celNyushoShisetsu3",
           "helpMessageID": "",
           "jpControlName": "",
           "connectTd": "R4C3"
          }
         ],
         "controlType": "TablePanel",
         "width": "XS",
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
         "selectControlID": "tblShisetsuNyutaisho",
         "helpMessageID": "",
         "jpControlName": "",
         "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C3' bgcolor=\"#d7ebf6\"></td><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C3'></td><td id='R2C1'></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C3'></td><td id='R3C1'></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C3'></td><td id='R4C1'></td><td id='R4C2'></td></tr>\n  </tbody>\n</table>\n"
        }
       ],
       "controlType": "TabPanel",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplShisetsuNyutaisho",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "施設入退所",
       "onActive": "",
       "onFirstActive": "",
       "lazyLoadingControls": {}
      }
     ],
     "controlType": "TabContainer",
     "width": "950px",
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
     "selectControlID": "tabHihokenshaShikakuShosai",
     "helpMessageID": "",
     "jpControlName": "",
     "onChange": "",
     "selectedItem": null,
     "tabpanelPosition": [
      "tplGendoGaku",
      "tplShinsakaiIken",
      "tplKyufuSeigen",
      "tplShienJigyosha",
      "tplShisetsuNyutaisho"
     ],
     "isDraggable": false,
     "selectedItemFieldName": "tplShisetsuNyutaisho",
     "initialTab": 0,
     "isLazyLoading": false
    }
   ],
   "controlType": "Panel",
   "width": "1000px",
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
   "selectControlID": "HihokenshaShikakuHakko",
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
     "postParameterPanelNames": "HihokenshaShikakuHakko"
    }
   ],
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
   "focusPositionID": "restoreLayoutButton",
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
 "controlName": "HihokenshaShikakuHakko",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [],
 "publicEventsAlias": []
}        
    }

     export module HihokenshaShikakuHakko {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HihokenshaShikakuHakko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType() + "_" + fieldName;
            }

            public HihokenshaShikakuHakko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public YukoKiGenInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YukoKiGenInfo"));
            }

            public txtYokuKiGen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYokuKiGen"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

            public ddlKofuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKofuJiyu"));
            }

            public NinteiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiInfo"));
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtNinteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYMD"));
            }

            public txtNinteiYukoFromYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYukoFromYMD"));
            }

            public lblKara1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara1"));
            }

            public txtNinteiYukoToYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYukoToYMD"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public tabHihokenshaShikakuShosai(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabHihokenshaShikakuShosai"));
            }

            public tplGendoGaku(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplGendoGaku"));
            }

            public tblGendoGaku(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblGendoGaku"));
            }

            public celKubunGendoGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKubunGendoGaku"));
            }

            public KubunGendoGaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KubunGendoGaku"));
            }

            public txtKubunShikyuGendoKijunGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendoKijunGaku"));
            }

            public txtYukoFromYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoFromYMD"));
            }

            public lblKara(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara"));
            }

            public txtYukoToYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoToYMD"));
            }

            public celShuruiGendoKijungaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShuruiGendoKijungaku"));
            }

            public ShuruiShikyuGendoKijungaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShuruiShikyuGendoKijungaku"));
            }

            public dgShuruiShikyuGendoKijunGaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShuruiShikyuGendoKijunGaku"));
            }

            public tplShinsakaiIken(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShinsakaiIken"));
            }

            public lblShinsakaiIken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            }

            public txtShinsakaiIken(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            }

            public tplKyufuSeigen(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKyufuSeigen"));
            }

            public lblKyufuSeigen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigen"));
            }

            public tblKyuhuSeigen(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKyuhuSeigen"));
            }

            public celKyufuSeigenNaiyoTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyoTitle"));
            }

            public lblKyufuSeigenNaiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenNaiyo"));
            }

            public celKyufuSeigenKikanTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikanTitle"));
            }

            public lblKyufuSeigenKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenKikan"));
            }

            public celKyufuSeigenNaiyo1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo1"));
            }

            public txtKyufuSeigenNaiyo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo1"));
            }

            public celKyufuSeigenKikan1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan1"));
            }

            public txtKyufuSeigenKikan1(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan1"));
            }

            public celKyufuSeigenNaiyo2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo2"));
            }

            public txtKyufuSeigenNaiyo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo2"));
            }

            public celKyufuSeigenKikan2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan2"));
            }

            public txtKyufuSeigenKikan2(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan2"));
            }

            public celKyufuSeigenNaiyo3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo3"));
            }

            public txtKyufuSeigenNaiyo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo3"));
            }

            public celKyufuSeigenKikan3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan3"));
            }

            public txtKyufuSeigenKikan3(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan3"));
            }

            public tplShienJigyosha(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShienJigyosha"));
            }

            public lblShienJigyosha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShienJigyosha"));
            }

            public tblJigyosha(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblJigyosha"));
            }

            public celJigyoshaTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyoshaTitle"));
            }

            public lblJigyosha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblJigyosha"));
            }

            public celTodokedeDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDateTitle"));
            }

            public lblTodokedeDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTodokedeDate"));
            }

            public celJigyosha1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha1"));
            }

            public txtJigyosha1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha1"));
            }

            public celTodokedeDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate1"));
            }

            public txtTodokedeYMD1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD1"));
            }

            public celJigyosha2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha2"));
            }

            public txtJigyosha2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha2"));
            }

            public celTodokedeDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate2"));
            }

            public txtTodokedeYMD2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD2"));
            }

            public celJigyosha3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha3"));
            }

            public txtJigyosha3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha3"));
            }

            public celTodokedeDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate3"));
            }

            public txtTodokedeYMD3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD3"));
            }

            public celTekiyoStYMD(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD"));
            }

            public lblTekiyoStYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTekiyoStYMD"));
            }

            public celTekiyoStYMD1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD1"));
            }

            public txtTekiyoStYMD1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD1"));
            }

            public celTekiyoStYMD2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD2"));
            }

            public txtTekiyoStYMD2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD2"));
            }

            public celTekiyoStYMD3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD3"));
            }

            public txtTekiyoStYMD3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD3"));
            }

            public tplShisetsuNyutaisho(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShisetsuNyutaisho"));
            }

            public lblKaigoHokensha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaigoHokensha"));
            }

            public tblShisetsuNyutaisho(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblShisetsuNyutaisho"));
            }

            public celShisetsuNyushoDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDateTitle"));
            }

            public lblShisetsuNyushoDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuNyushoDate"));
            }

            public celShisetsuTaishoDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDateTitle"));
            }

            public lblShisetsuTaishoDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuTaishoDate"));
            }

            public celNyushoShisetsuTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsuTitle"));
            }

            public lblNyushoShisetsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNyushoShisetsu"));
            }

            public celShisetsuNyushoDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate1"));
            }

            public txtShisetsuNyushoDate1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate1"));
            }

            public celShisetsuTaishoDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate1"));
            }

            public txtShisetsuTaishoDate1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate1"));
            }

            public celNyushoShisetsu1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu1"));
            }

            public txtNyushoShisetsu1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu1"));
            }

            public celShisetsuNyushoDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate2"));
            }

            public txtShisetsuNyushoDate2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate2"));
            }

            public celShisetsuTaishoDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate2"));
            }

            public txtShisetsuTaishoDate2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate2"));
            }

            public celNyushoShisetsu2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu2"));
            }

            public txtNyushoShisetsu2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu2"));
            }

            public celShisetsuNyushoDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate3"));
            }

            public txtShisetsuNyushoDate3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate3"));
            }

            public celShisetsuTaishoDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate3"));
            }

            public txtShisetsuTaishoDate3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate3"));
            }

            public celNyushoShisetsu3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu3"));
            }

            public txtNyushoShisetsu3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu3"));
            }

        }

     }

}

