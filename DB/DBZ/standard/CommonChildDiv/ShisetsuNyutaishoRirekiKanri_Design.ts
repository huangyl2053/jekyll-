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
     "width": "180",
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
     "onClick": "onClick_btnAddShisetsuNyutaisho",
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
     "width": "1050",
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
        "sortKey": "btnSelect"
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
        "sortKey": "btnDelete"
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
        "align": 0,
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
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "taishoDate"
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
        "sortKey": "shisetsuCode"
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
        "sortKey": "shisetsuMeisho"
       },
       {
        "columnName": "入所施設",
        "dataName": "shisetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 450,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shisetsu"
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
        "sortKey": "taishoJoho"
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
        "sortKey": "shisetsuShurui"
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
       "width": "190",
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
       "dataSource": [
        {
         "key": "",
         "value": ""
        },
        {
         "key": "kannai",
         "value": "管内施設"
        },
        {
         "key": "jushochiTokurei",
         "value": "住所地特例措置"
        },
        {
         "key": "tekiyoJogai",
         "value": "適用除外措置"
        },
        {
         "key": "tashichosonJushochiTokurei",
         "value": "他市町村住所地特例措置"
        }
       ],
       "onChange": "",
       "selectedItem": "",
       "required": false,
       "labelLText": "対象情報",
       "labelRText": "",
       "labelLWidth": "60",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": ""
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
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "入所日",
       "labelRText": "",
       "labelLWidth": "45]",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "readOnly": false,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onKeyPress": "",
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "permitCharactor": "./_-"
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
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "退所日",
       "labelRText": "",
       "labelLWidth": "45",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "readOnly": false,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onKeyPress": "",
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "radShisetsuShurui",
       "items": [],
       "controlType": "RadioButton",
       "width": "300",
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
       "onClick": "",
       "dataSource": [
        {
         "key": "kaigoHokenShisetsu",
         "value": "介護保険施設"
        },
        {
         "key": "other",
         "value": "その他特例施設"
        }
       ],
       "onChange": "",
       "selectedItem": "kaigoHokenShisetsu",
       "required": false,
       "labelLText": "",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "newLineItemNumber": 2,
       "spaceSize": 1
      },
      {
       "fieldName": "txtShisetsuCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "90",
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
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "入所施設",
       "labelRText": "",
       "labelLWidth": "60",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "readOnly": false,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "onKeyPress": "",
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "btnJigyoshaInputGuide",
       "items": [],
       "controlType": "ButtonDialog",
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
       "marginLeft": "0",
       "marginRight": "0",
       "onClick": "",
       "text": "■",
       "appearance": 1,
       "imageFileUrl": "/uz/uza/css/rireki_brue.png",
       "imageWidth": "20",
       "imageHeight": "20",
       "displayChildDivName": "DBZ.JigyoshaInputGuide",
       "dataPassing": [
        {
         "key": "jigyoshaCode",
         "controlName": "txtShisetsuCode"
        },
        {
         "key": "jigyoshaMeisho",
         "controlName": "txtShisetsuMeisho"
        }
       ],
       "visibleCloseButton": true,
       "onOkClose": "",
       "onBeforeOpenDialog": ""
      },
      {
       "fieldName": "btnOtherTokureiShisetsuInputGuide",
       "items": [],
       "controlType": "ButtonDialog",
       "width": "20",
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
       "marginLeft": "0",
       "marginRight": "0",
       "onClick": "",
       "text": "■",
       "appearance": 1,
       "imageFileUrl": "/uz/uza/css/rireki_brue.png",
       "imageWidth": "20",
       "imageHeight": "20",
       "displayChildDivName": "DBZ.OtherTokureiShisetsuInputGuide",
       "dataPassing": [
        {
         "key": "otherShisetsuCode",
         "controlName": "txtShisetsuCode"
        },
        {
         "key": "otherShisetsuMeisho",
         "controlName": "txtShisetsuMeisho"
        }
       ],
       "visibleCloseButton": true,
       "onOkClose": "",
       "onBeforeOpenDialog": ""
      },
      {
       "fieldName": "btnJogaiShisetsuInputGuide",
       "items": [],
       "controlType": "ButtonDialog",
       "width": "20",
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
       "marginLeft": "0",
       "marginRight": "0",
       "onClick": "",
       "text": "■",
       "appearance": 1,
       "imageFileUrl": "/uz/uza/css/rireki_brue.png",
       "imageWidth": "20",
       "imageHeight": "20",
       "displayChildDivName": "DBZ.TekiyoJogaiShisetsuInputGuide",
       "dataPassing": [
        {
         "key": "otherShisetsuCode",
         "controlName": "txtShisetsuCode"
        },
        {
         "key": "otherShisetsuMeisho",
         "controlName": "txtShisetsuMeisho"
        }
       ],
       "visibleCloseButton": true,
       "onOkClose": "",
       "onBeforeOpenDialog": ""
      },
      {
       "fieldName": "txtShisetsuMeisho",
       "items": [],
       "controlType": "TextBox",
       "width": "450",
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
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "readOnly": true,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onKeyPress": "",
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
     "width": "1050",
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
     "isGroupBox": true
    },
    {
     "fieldName": "btnUpdateShisetsuNyutaisho",
     "items": [],
     "controlType": "Button",
     "width": "180",
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
     "onClick": "onClick_btnUpdateShisetsuNyutaisho",
     "text": "入退所情報を確定する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    }
   ],
   "controlType": "Panel",
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
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnAddShisetsuNyutaisho",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnUpdateShisetsuNyutaisho",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnDeleteShisetsuNyutaisho",
     "requestUrl": ""
    }
   ],
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

