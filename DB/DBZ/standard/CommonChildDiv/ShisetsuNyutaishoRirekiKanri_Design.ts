/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShisetsuNyutaishoRirekiKanriクラスのみで継承して使えます。
     */
    export class ShisetsuNyutaishoRirekiKanri_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShisetsuNyutaishoRirekiKanri_Design.myLayout, fieldName);
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
   "fieldName": "ShisetsuNyutaishoRirekiKanri",
   "items": [
    {
     "fieldName": "btnAddShisetsuNyutaisho",
     "items": [],
     "controlType": "Button",
     "width": "200",
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
     "selectControlID": "btnAddShisetsuNyutaisho",
     "onClick": "onClick_btnAddShisetsuNyutaisho",
     "icon": 0,
     "text": "新規施設入退所を追加する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    },
    {
     "fieldName": "dgShisetsuNyutaishoRireki",
     "items": [],
     "controlType": "DataGrid",
     "width": "990",
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
     "selectControlID": "dgShisetsuNyutaishoRireki",
     "dataSource": [],
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "",
        "dataName": "btnSelect",
        "toolTip": "",
        "bgColor": 0,
        "width": 25,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "",
         "onClick": "onClick_btnSelectShisetsuNyutaisho",
         "imageFileUrl": "/uz/uza/css/Edit.png",
         "imageWidth": "20",
         "imageHeight": "20"
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "",
        "dataName": "btnDelete",
        "toolTip": "",
        "bgColor": 0,
        "width": 25,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "",
         "onClick": "onClick_btnDeleteShisetsuNyutaisho",
         "imageFileUrl": "/uz/uza/css/Delete.png",
         "imageWidth": "15",
         "imageHeight": "15"
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "入所日",
        "dataName": "nyushoDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 7,
        "cellDetails": {
         "cellType": 7,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "nyushoDate"
       },
       {
        "columnName": "退所日",
        "dataName": "taishoDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 7,
        "cellDetails": {
         "cellType": 7,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "施設コード",
        "dataName": "shisetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": false,
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
        "columnName": "施設名称",
        "dataName": "shisetsuMeisho",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
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
        "columnName": "入所施設",
        "dataName": "shisetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 390,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "対象情報key",
        "dataName": "taishoJohoKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "対象情報",
        "dataName": "taishoJoho",
        "toolTip": "",
        "bgColor": 0,
        "width": 180,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "施設種類key",
        "dataName": "shisetsuShuruiKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "施設種類",
        "dataName": "shisetsuShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       }
      ]
     },
     "height": "S",
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectOfModify": "",
     "onSelectOfDelete": "",
     "onOnlyRow": "",
     "onNoRow": "onNoRow_dgShisetsuNyutaishoRireki",
     "onMultiRows": "",
     "sortOrder": "shisetsuShurui",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "ShisetsuNyutaishoInput",
     "items": [
      {
       "fieldName": "ddlTaishoJoho",
       "items": [],
       "controlType": "DropDownList",
       "width": "200",
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
       "selectControlID": "ddlTaishoJoho_core",
       "onChange": "onChange_ddlTaishoJoho",
       "selectedItem": "kannai",
       "dataSource": [
        {
         "key": "kannai",
         "value": "管内施設"
        },
        {
         "key": "jutoku",
         "value": "住所地特例措置"
        },
        {
         "key": "tekiyoJogai",
         "value": "適用除外措置"
        },
        {
         "key": "tashichosonJutoku",
         "value": "他市町村住所地特例措置"
        }
       ],
       "required": false,
       "labelLText": "対象情報",
       "labelLWidth": "70",
       "labelLAlign": 2,
       "onFocus": "",
       "onBlur": "",
       "labelRText": "",
       "labelRWidth": "S",
       "labelRAlign": 0
      },
      {
       "fieldName": "txtNyushoDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
       "width": "80",
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
       "selectControlID": "txtNyushoDate_core",
       "readOnly": false,
       "onChange": "",
       "required": false,
       "labelLText": "入所日",
       "labelLWidth": "50",
       "labelLAlign": 2,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelRText": "",
       "labelRWidth": "S",
       "labelRAlign": 0,
       "permitCharactor": "./_-",
       "ymdKubun": 2,
       "displayFormat": 0
      },
      {
       "fieldName": "txtTaishoDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
       "width": "80",
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
       "selectControlID": "txtTaishoDate_core",
       "readOnly": false,
       "onChange": "",
       "required": false,
       "labelLText": "退所日",
       "labelLWidth": "50",
       "labelLAlign": 2,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onKeyPress": "",
       "text": "",
       "value": "",
       "labelRText": "",
       "labelRWidth": "S",
       "labelRAlign": 0,
       "permitCharactor": "./_-",
       "ymdKubun": 2,
       "displayFormat": 0
      },
      {
       "fieldName": "ShisetsuJoho",
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
       "marginLeft": 0,
       "marginRight": 0,
       "selectControlID": "ShisetsuJoho",
       "relation": [],
       "businessId": "DBZ",
       "controlName": "ShisetsuJoho",
       "marginTop": 0,
       "marginBottom": 0,
       "originalProperty": [],
       "dataPassingForDialog": [],
       "dialogOkEventNameForDialog": "",
       "dialogCancelEventNameForDialog": "",
       "btnJigyoshaInputGuide_displayNone": false,
       "btnOtherTokureiShisetsuInputGuide_displayNone": true,
       "btnJogaiShisetsuInputGuide_displayNone": true,
       "radShisetsuShurui_displayNone": false
      }
     ],
     "controlType": "Panel",
     "width": "990",
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
     "selectControlID": "ShisetsuNyutaishoInput",
     "onLoad": "",
     "title": "施設入退所情報入力",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "ShisetsuNyutaishoInput"
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false
    },
    {
     "fieldName": "btnUpdateShisetsuNyutaisho",
     "items": [],
     "controlType": "Button",
     "width": "200",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "btnUpdateShisetsuNyutaisho",
     "onClick": "onClick_btnUpdateShisetsuNyutaisho",
     "icon": 0,
     "text": "入退所情報を確定する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
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
   "selectControlID": "ShisetsuNyutaishoRirekiKanri",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShisetsuNyutaishoRirekiKanri"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnSelectShisetsuNyutaisho",
     "requestUrl": "dbz/db/dbz/ShisetsuNyutaishoRirekiKanri/onClick_btnSelectShisetsuNyutaisho"
    },
    {
     "eventName": "onClick_btnAddShisetsuNyutaisho",
     "requestUrl": "dbz/db/dbz/ShisetsuNyutaishoRirekiKanri/onClick_btnAddShisetsuNyutaisho"
    },
    {
     "eventName": "onClick_btnUpdateShisetsuNyutaisho",
     "requestUrl": "dbz/db/dbz/ShisetsuNyutaishoRirekiKanri/onClick_btnUpdateShisetsuNyutaisho"
    },
    {
     "eventName": "onClick_btnDeleteShisetsuNyutaisho",
     "requestUrl": "dbz/db/dbz/ShisetsuNyutaishoRirekiKanri/onClick_btnDeleteShisetsuNyutaisho"
    },
    {
     "eventName": "onNoRow_dgShisetsuNyutaishoRireki",
     "requestUrl": ""
    },
    {
     "eventName": "onChange_ddlTaishoJoho",
     "requestUrl": "dbz/db/dbz/ShisetsuNyutaishoRirekiKanri/onChange_ddlTaishoJoho"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "selectRow",
     "value": ""
    },
    {
     "propertyName": "inputMode",
     "value": ""
    }
   ],
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
   "isGroupBox": false,
   "readOnly": false
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
 "controlName": "ShisetsuNyutaishoRirekiKanri",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

