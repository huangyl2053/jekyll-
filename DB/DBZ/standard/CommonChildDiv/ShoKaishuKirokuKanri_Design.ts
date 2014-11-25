/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />


/// <reference path="ShoKaishuJokyoList.ts" />
/// <reference path="ShoKaishuJokyoShosai.ts" />


module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module ShoKaishuKirokuKanri {

        export class Events {

            public static get onSelectByDblClick_dgShoKaishuJokyo(): string {
                return "onSelectByDblClick_dgShoKaishuJokyo";
            }
            public static get onClick_btnUpdateShoKaishuJokyo(): string {
                return "onClick_btnUpdateShoKaishuJokyo";
            }
            public static get onSelectBySelectButton_dgShoKaishuJokyo(): string {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "ShoKaishuKirokuKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public ShoKaishuJokyoList() : DBZ.ShoKaishuJokyoList.ModeController {
                return new DBZ.ShoKaishuJokyoList.ModeController("ShoKaishuJokyoList");
            }

            public ShoKaishuJokyoShosai() : DBZ.ShoKaishuJokyoShosai.ModeController {
                return new DBZ.ShoKaishuJokyoShosai.ModeController("ShoKaishuJokyoShosai");
            }


            public ShoKaishuKirokuKanri() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public btnUpdateShoKaishuJokyo() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnUpdateShoKaishuJokyo"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class ShoKaishuKirokuKanri_Design extends Uz.CommonChildDiv {
    
        public get onBlur_txtKaishuDate() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuDate"];
        }
        
        public set onBlur_txtKaishuDate(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuDate"] = value;
            } else {
                this.layout.items[0].items[1]["onBlur_txtKaishuDate"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onChange_ddlKaishuJiyu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onChange_ddlKaishuJiyu"];
        }
        
        public set onChange_ddlKaishuJiyu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onChange_ddlKaishuJiyu"] = value;
            } else {
                this.layout.items[0].items[1]["onChange_ddlKaishuJiyu"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onBlur_txtKaishuRiyu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuRiyu"];
        }
        
        public set onBlur_txtKaishuRiyu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuRiyu"] = value;
            } else {
                this.layout.items[0].items[1]["onBlur_txtKaishuRiyu"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShoKaishuJokyoShosai_panalDisplay() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_panelDisplay"];
        }
        
        public set ShoKaishuJokyoShosai_panalDisplay(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_panelDisplay"] = value;
            } else {
                this.layout.items[0].items[1]["ShoKaishuJokyoShosai_panelDisplay"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShoKaishuJokyoShosai_canOpenAndClose() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_canOpenAndClose"];
        }
        
        public set ShoKaishuJokyoShosai_canOpenAndClose(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_canOpenAndClose"] = value;
            } else {
                this.layout.items[0].items[1]["ShoKaishuJokyoShosai_canOpenAndClose"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ShoKaishuKirokuKanri_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuDate");
            Uz.JSControlUtil.registProperty("onChange_ddlKaishuJiyu");
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuRiyu");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_panalDisplay");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_canOpenAndClose");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onBlur_txtKaishuDate"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onBlur_txtKaishuDate"];
            editablePropertyInfo["onChange_ddlKaishuJiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onChange_ddlKaishuJiyu"];
            editablePropertyInfo["onBlur_txtKaishuRiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onBlur_txtKaishuRiyu"];
            editablePropertyInfo["ShoKaishuJokyoShosai_panalDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["ShoKaishuJokyoShosai_panelDisplay"];
            editablePropertyInfo["ShoKaishuJokyoShosai_canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["ShoKaishuJokyoShosai_canOpenAndClose"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ShoKaishuKirokuKanri",
   "items": [
    {
     "fieldName": "ShoKaishuJokyoList",
     "items": [],
     "controlType": "CommonChildDiv",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "ShoKaishuJokyoList",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "businessId": "DBZ",
     "controlName": "ShoKaishuJokyoList",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": true,
      "isShowSelectButtonColumn": false,
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
        "columnName": "選択",
        "dataName": "btnSelect",
        "toolTip": "",
        "bgColor": 0,
        "width": 40,
        "visible": true,
        "cellType": 8,
        "cellDetails": {
         "cellType": 8,
         "text": "",
         "onClick": "onClick_btnSelect",
         "imageFileUrl": "/uz/uza/image/UZ_RowSelect_On.png",
         "imageWidth": "20",
         "imageHeight": "20"
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "交付証種類",
        "dataName": "kofushoShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 180,
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
        "columnName": "交付日",
        "dataName": "kofuDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
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
        "columnName": "交付事由Key",
        "dataName": "kofuJiyuKey",
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
        "columnName": "交付事由",
        "dataName": "kofuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "交付理由",
        "dataName": "kofuRiyu",
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
        "columnName": "回収日",
        "dataName": "kaishuDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
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
        "columnName": "回収事由Key",
        "dataName": "kaishuJiyuKey",
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
        "columnName": "回収事由",
        "dataName": "kaishuJiyu",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": ""
       },
       {
        "columnName": "回収理由",
        "dataName": "kaishuRiyu",
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
        "columnName": "有効期限",
        "dataName": "yukoKigen",
        "toolTip": "",
        "bgColor": 0,
        "width": 90,
        "visible": true,
        "cellType": 7,
        "cellDetails": {
         "cellType": 7,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": ""
        },
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": ""
       }
      ]
     },
     "onSelectByDblClick": "onSelectByDblClick_dgShoKaishuJokyo",
     "onSelectBySelectButton": "onSelectBySelectButton_dgShoKaishuJokyo"
    },
    {
     "fieldName": "ShoKaishuJokyoShosai",
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
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "ShoKaishuJokyoShosai",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "businessId": "DBZ",
     "controlName": "ShoKaishuJokyoShosai",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M",
     "onBlur_txtKaishuDate": "",
     "onChange_ddlKaishuJiyu": "",
     "onBlur_txtKaishuRiyu": "",
     "ShoKaishuJokyoShosai_panelDisplay": 0,
     "ShoKaishuJokyoShosai_canOpenAndClose": true
    },
    {
     "fieldName": "btnUpdateShoKaishuJokyo",
     "items": [],
     "controlType": "Button",
     "width": "150",
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
     "selectControlID": "btnUpdateShoKaishuJokyo",
     "helpMessageID": "",
     "jpControlName": "",
     "onClick": "onClick_btnUpdateShoKaishuJokyo",
     "text": "交付情報を確定する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "1030",
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
   "selectControlID": "ShoKaishuKirokuKanri",
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
     "postParameterPanelNames": "ShoKaishuKirokuKanri"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnSelect",
     "requestUrl": "dbz/db/dbz/ShoKaishuKirokuKanri/onClick_btnSelect"
    },
    {
     "eventName": "onClick_btnUpdateShoKaishuJokyo",
     "requestUrl": "dbz/db/dbz/ShoKaishuKirokuKanri/onClick_btnUpdateShoKaishuJokyo"
    }
   ],
   "hiddenInput": [
    {
     "propertyName": "mode",
     "value": ""
    },
    {
     "propertyName": "selectRow",
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
 "controlName": "ShoKaishuKirokuKanri",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "onBlur_txtKaishuDate",
   "newPropertyName": "onBlur_txtKaishuDate"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "onChange_ddlKaishuJiyu",
   "newPropertyName": "onChange_ddlKaishuJiyu"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "onBlur_txtKaishuRiyu",
   "newPropertyName": "onBlur_txtKaishuRiyu"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "ShoKaishuJokyoShosai_panelDisplay",
   "newPropertyName": "ShoKaishuJokyoShosai_panalDisplay"
  },
  {
   "publicChildFieldName": "ShoKaishuJokyoShosai",
   "publicChildProperty": "ShoKaishuJokyoShosai_canOpenAndClose",
   "newPropertyName": "ShoKaishuJokyoShosai_canOpenAndClose"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M"
}        
    }
}

