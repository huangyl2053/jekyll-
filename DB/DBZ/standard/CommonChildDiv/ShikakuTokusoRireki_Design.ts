/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * ShikakuTokusoRirekiクラスのみで継承して使えます。
     */
    export class ShikakuTokusoRireki_Design extends Uz.CommonChildDiv {
    
        public get onSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"];
        }
        
        public set onSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelectByModifyButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByModifyButton"];
        }
        
        public set onSelectByModifyButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByModifyButton"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByModifyButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onSelectByDeleteButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDeleteButton"];
        }
        
        public set onSelectByDeleteButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDeleteButton"] = value;
            } else {
                this.layout.items[0].items[0]["onSelectByDeleteButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get panel_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
        }
        
        public set panel_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get grid_width() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"];
        }
        
        public set grid_width(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["width"] = value;
            } else {
                this.layout.items[0].items[0]["width"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get () {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
        }
        
        public set (value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShikakuTokusoRireki_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onSelectByDblClick");
            Uz.JSControlUtil.registProperty("onSelectByModifyButton");
            Uz.JSControlUtil.registProperty("onSelectByDeleteButton");
            Uz.JSControlUtil.registProperty("panel_width");
            Uz.JSControlUtil.registProperty("grid_width");
            Uz.JSControlUtil.registProperty("");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onSelectByModifyButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByModifyButton"];
            editablePropertyInfo["onSelectByDeleteButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDeleteButton"];
            editablePropertyInfo["panel_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            editablePropertyInfo["grid_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["width"];
            editablePropertyInfo[""] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShikakuTokusoRireki",
   "items": [
    {
     "fieldName": "dgShikakuShutokuRireki",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "dgShikakuShutokuRireki",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "S",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": true,
      "isShowDeleteButtonColumn": true,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [
        {
         "combineColumnName": "取得情報",
         "combineItem": [
          "shutokuTodokedeDate",
          "shutokuDate",
          "shutokuJiyuKey",
          "shutokuJiyu"
         ]
        },
        {
         "combineColumnName": "喪失情報",
         "combineItem": [
          "soshitsuTodokedeDate",
          "soshitsuDate",
          "soshitsuJiyuKey",
          "soshitsuJiyu"
         ]
        },
        {
         "combineColumnName": "住所地特例適用",
         "combineItem": [
          "jutokuTekiyoTodokedeDate",
          "jutokuTekiyoDate",
          "jutokuTekiyoJiyuKey",
          "jutokuTekiyoJiyu"
         ]
        },
        {
         "combineColumnName": "住所地特例解除",
         "combineItem": [
          "jutokuKaijoTodokedeDate",
          "jutokuKaijoDate",
          "jutokuKaijoJiyuKey",
          "jutokuKaijoJiyu"
         ]
        },
        {
         "combineColumnName": "変更情報",
         "combineItem": [
          "henkoTodokedeDate",
          "henkoDate",
          "henkoJiyuKey",
          "henkoJiyu"
         ]
        }
       ],
       "frozenColumn": "shutokuJiyu",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "届出日",
        "dataName": "shutokuTodokedeDate",
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
        "sortKey": "shutokuTodokedeDate"
       },
       {
        "columnName": "取得日",
        "dataName": "shutokuDate",
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
        "sortKey": "shutokuDate"
       },
       {
        "columnName": "取得事由Key",
        "dataName": "shutokuJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "shutokuJiyuKey"
       },
       {
        "columnName": "取得事由",
        "dataName": "shutokuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shutokuJiyu"
       },
       {
        "columnName": "届出日",
        "dataName": "soshitsuTodokedeDate",
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
        "sortKey": "soshitsuTodokedeDate"
       },
       {
        "columnName": "喪失日",
        "dataName": "soshitsuDate",
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
        "sortKey": "soshitsuDate"
       },
       {
        "columnName": "喪失事由Key",
        "dataName": "soshitsuJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "soshitsuJiyuKey"
       },
       {
        "columnName": "喪失事由",
        "dataName": "soshitsuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "soshitsuJiyu"
       },
       {
        "columnName": "被保区分Key",
        "dataName": "hihokenshaKubunKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaKubunKey"
       },
       {
        "columnName": "被保区分",
        "dataName": "hihokenshaKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hihokenshaKubun"
       },
       {
        "columnName": "届出日",
        "dataName": "jutokuTekiyoTodokedeDate",
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
        "sortKey": "jutokuTekiyoTodokedeDate"
       },
       {
        "columnName": "適用日",
        "dataName": "jutokuTekiyoDate",
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
        "sortKey": "jutokuTekiyoDate"
       },
       {
        "columnName": "適用事由Key",
        "dataName": "jutokuTekiyoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "jutokuTekiyoJiyuKey"
       },
       {
        "columnName": "適用事由",
        "dataName": "jutokuTekiyoJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0,
         "isSetValueToToolTip": false
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "jutokuTekiyoJiyu"
       },
       {
        "columnName": "届出日",
        "dataName": "jutokuKaijoTodokedeDate",
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
        "sortKey": "jutokuKaijoTodokedeDate"
       },
       {
        "columnName": "解除日",
        "dataName": "jutokuKaijoDate",
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
        "sortKey": "jutokuKaijoDate"
       },
       {
        "columnName": "解除事由Key",
        "dataName": "jutokuKaijoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "jutokuKaijoJiyuKey"
       },
       {
        "columnName": "解除事由",
        "dataName": "jutokuKaijoJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "jutokuKaijoJiyu"
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
        "columnName": "変更事由Key",
        "dataName": "henkoJiyuKey",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "henkoJiyuKey"
       },
       {
        "columnName": "変更事由",
        "dataName": "henkoJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
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
        "columnName": "1号年齢到達日",
        "dataName": "nenreiTotatsuDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
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
        "sortKey": "nenreiTotatsuDate"
       },
       {
        "columnName": "保険者",
        "dataName": "hokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hokensha"
       },
       {
        "columnName": "措置元保険者",
        "dataName": "sochimotoHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "sochimotoHokensha"
       },
       {
        "columnName": "旧保険者",
        "dataName": "kyuHokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kyuHokensha"
       },
       {
        "columnName": "再交付区分",
        "dataName": "saikofuKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "saikofuKubun"
       },
       {
        "columnName": "再交付事由",
        "dataName": "saikofuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "saikofuJiyu"
       },
       {
        "columnName": "帳票交付履歴ID",
        "dataName": "chohyoKofuRirekiId",
        "toolTip": "",
        "bgColor": 0,
        "width": 140,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "chohyoKofuRirekiId"
       },
       {
        "columnName": "識別コード",
        "dataName": "shikibetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shikibetsuCode"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton_dgShikakuShutokuRireki",
     "onSelectByDeleteButton": "onSelectByDeleteButton_dgShikakuShutokuRireki",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "jutokuTekiyoTodokedeDate",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    }
   ],
   "controlType": "Panel",
   "width": "1100",
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
   "selectControlID": "ShikakuTokusoRireki",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "onLoad_ShikakuShutokuTaishoshaJoho",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ShikakuTokusoRireki"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbz/db/dbz/ShikakuTokusoRireki/onLoad"
    },
    {
     "eventName": "onClick_btnJutokuTekiyo",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnShikakuShutoku",
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
   "eraseBorderTop": true,
   "eraseBorderBottom": true,
   "eraseBorderRight": true,
   "eraseBorderLeft": true,
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
 "controlName": "ShikakuTokusoRireki",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "dgShikakuShutokuRireki",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "onSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgShikakuShutokuRireki",
   "publicChildProperty": "onSelectByModifyButton",
   "newPropertyName": "onSelectByModifyButton"
  },
  {
   "publicChildFieldName": "dgShikakuShutokuRireki",
   "publicChildProperty": "onSelectByDeleteButton",
   "newPropertyName": "onSelectByDeleteButton"
  },
  {
   "publicChildFieldName": "ShikakuTokusoRireki",
   "publicChildProperty": "width",
   "newPropertyName": "panel_width"
  },
  {
   "publicChildFieldName": "dgShikakuShutokuRireki",
   "publicChildProperty": "width",
   "newPropertyName": "grid_width"
  },
  {
   "publicChildFieldName": "ShikakuTokusoRireki",
   "publicChildProperty": "visible",
   "newPropertyName": ""
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

