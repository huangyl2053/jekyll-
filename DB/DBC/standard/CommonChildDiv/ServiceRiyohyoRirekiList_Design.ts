/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     * ServiceRiyohyoRirekiListクラスのみで継承して使えます。
     */
    export class ServiceRiyohyoRirekiList_Design extends Uz.CommonChildDiv {
    
        public get RirekiListGridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"];
        }
        
        public set RirekiListGridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[0]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get RirekiListHeight() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"];
        }
        
        public set RirekiListHeight(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"] = value;
            } else {
                this.layout.items[0].items[0]["height"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ServiceRiyohyoRirekiList_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("RirekiListGridSetting");
            Uz.JSControlUtil.registProperty("RirekiListHeight");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["RirekiListGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["RirekiListHeight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ServiceRiyohyoRirekiList",
   "items": [
    {
     "fieldName": "dgServiceRiyohyoRirekiList",
     "items": [],
     "controlType": "DataGrid",
     "width": "1180",
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
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": false,
      "header": {
       "combineColumns": [
        {
         "combineColumnName": "計画適用期間",
         "combineItem": [
          "txtTekiyoKaishiYMD",
          "txtTekiyoShuryoYMD"
         ]
        }
       ],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "",
        "dataName": "btnSelect",
        "toolTip": "",
        "bgColor": 0,
        "width": 35,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "選",
         "onClick": "",
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "btnSelect"
       },
       {
        "columnName": "状態",
        "dataName": "txtJotai",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtJotai"
       },
       {
        "columnName": "",
        "dataName": "txtTodokedeYMDInvisible",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 5,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "txtTodokedeYMDInvisible"
       },
       {
        "columnName": "届出日",
        "dataName": "txtTodokedeYMD",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTodokedeYMD"
       },
       {
        "columnName": "届出区分",
        "dataName": "txtTodokedeKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 70,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTodokedeKubun"
       },
       {
        "columnName": "開始日",
        "dataName": "txtTekiyoKaishiYMD",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTekiyoKaishiYMD"
       },
       {
        "columnName": "終了日",
        "dataName": "txtTekiyoShuryoYMD",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTekiyoShuryoYMD"
       },
       {
        "columnName": "計画依頼事業者",
        "dataName": "txtIraiJigyosha",
        "toolTip": "",
        "bgColor": 0,
        "width": 720,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtIraiJigyosha"
       }
      ]
     },
     "height": "175",
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    }
   ],
   "controlType": "Panel",
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
   "marginLeft": "0",
   "marginRight": "0",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "ServiceRiyohyoRirekiList"
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
   "widthAuto": true,
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
 "businessId": "DBC",
 "controlName": "ServiceRiyohyoRirekiList",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "dgServiceRiyohyoRirekiList",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "RirekiListGridSetting"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoRirekiList",
   "publicChildProperty": "height",
   "newPropertyName": "RirekiListHeight"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

