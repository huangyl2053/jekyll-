/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HihokenshaFinderクラスのみで継承して使えます。
     */
    export class HihokenshaFinder_Design extends Uz.CommonChildDiv {
    
        public get onClick_BtnToSearch() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"] + "_" + this.layout.items[0].items[2].items[1]["fieldName"])["onClick"];
        }
        
        public set onClick_BtnToSearch(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"] + "_" + this.layout.items[0].items[2].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"] + "_" + this.layout.items[0].items[2].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"] + "_" + this.layout.items[0].items[2].items[1]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[2].items[1]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_txtTsuchishoNo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[2]["fieldName"])["displayNone"];
        }
        
        public set displayNone_txtTsuchishoNo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[2]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[2]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_ddlFukaNendo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[3]["fieldName"])["displayNone"];
        }
        
        public set displayNone_ddlFukaNendo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[3]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_SearchCriteriaDetail() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"])["displayNone"];
        }
        
        public set displayNone_SearchCriteriaDetail(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[4]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get canOpenAndClose_HihokenshaFinder() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"];
        }
        
        public set canOpenAndClose_HihokenshaFinder(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["canOpenAndClose"] = value;
            } else {
                this.layout.items[0]["canOpenAndClose"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_saikinShorisha() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
        }
        
        public set displayNone_saikinShorisha(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[3]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_ddlHokensha() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["displayNone"];
        }
        
        public set displayNone_ddlHokensha(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_chkMinashiNigo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"] + "_" + this.layout.items[0].items[0].items[4].items[2]["fieldName"])["displayNone"];
        }
        
        public set displayNone_chkMinashiNigo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"] + "_" + this.layout.items[0].items[0].items[4].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"] + "_" + this.layout.items[0].items[0].items[4].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"] + "_" + this.layout.items[0].items[0].items[4].items[2]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[0].items[4].items[2]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, HihokenshaFinder_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("onClick_BtnToSearch");
            Uz.JSControlUtil.registProperty("displayNone_txtTsuchishoNo");
            Uz.JSControlUtil.registProperty("displayNone_ddlFukaNendo");
            Uz.JSControlUtil.registProperty("displayNone_SearchCriteriaDetail");
            Uz.JSControlUtil.registProperty("canOpenAndClose_HihokenshaFinder");
            Uz.JSControlUtil.registProperty("displayNone_saikinShorisha");
            Uz.JSControlUtil.registProperty("displayNone_ddlHokensha");
            Uz.JSControlUtil.registProperty("displayNone_chkMinashiNigo");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onClick_BtnToSearch"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"] + "_" + this.layout.items[0].items[2].items[1]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["displayNone_txtTsuchishoNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_ddlFukaNendo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_SearchCriteriaDetail"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["canOpenAndClose_HihokenshaFinder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["displayNone_saikinShorisha"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_ddlHokensha"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_chkMinashiNigo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"] + "_" + this.layout.items[0].items[0].items[4].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "HihokenshaFinder",
   "items": [
    {
     "fieldName": "SearchCriteriaOfHihokensha",
     "items": [
      {
       "fieldName": "ddlHokensha",
       "items": [],
       "controlType": "DropDownList",
       "width": "M",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "ddlHokensha_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "selectedItem": "1",
       "dataSource": [
        {
         "key": "1",
         "value": "電算市"
        },
        {
         "key": "2",
         "value": "南魚沼市"
        }
       ],
       "required": false,
       "labelLText": "保険者",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "text": "",
       "disabledItem": []
      },
      {
       "fieldName": "txtHihokenshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "82",
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
       "selectControlID": "txtHihokenshaNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "required": false,
       "labelLText": "被保番号",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": "10",
       "minLength": "10",
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "text": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtTuchishoNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "130",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "txtTuchishoNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "required": false,
       "labelLText": "通知書番号",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": "16",
       "minLength": "1",
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "text": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "16"
      },
      {
       "fieldName": "ddlFukaNendo",
       "items": [],
       "controlType": "DropDownList",
       "width": "80",
       "visible": true,
       "displayNone": true,
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
       "selectControlID": "ddlFukaNendo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "selectedItem": "key0",
       "dataSource": [
        {
         "key": "key0",
         "value": "全年度"
        },
        {
         "key": "key1",
         "value": "平26"
        }
       ],
       "labelLText": "賦課年度　",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "disabledItem": []
      },
      {
       "fieldName": "SearchCriteriaDetail",
       "items": [
        {
         "fieldName": "chkHihokensha",
         "items": [],
         "controlType": "CheckBoxList",
         "width": "700",
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
         "selectControlID": "chkHihokensha_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "selectedItem": null,
         "dataSource": [
          {
           "key": "1",
           "value": "被保険者台帳登録者"
          },
          {
           "key": "2",
           "value": "受給者台帳登録者"
          },
          {
           "key": "3",
           "value": "住所地特例者"
          }
         ],
         "labelLText": "被保険者状態",
         "labelLWidth": "S",
         "labelLAlign": 2,
         "onClick": "",
         "selectedItems": [],
         "newLineItemNumber": 5,
         "minCheckedItem": 0,
         "maxCheckedItem": 2,
         "spaceSize": "L",
         "isAllSelectable": false,
         "isAllSelectableBreakLine": false,
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "radMinashiNigo",
         "items": [],
         "controlType": "RadioButton",
         "width": "M",
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
         "selectControlID": "radMinashiNigo_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "selectedItem": "1",
         "dataSource": [
          {
           "key": "1",
           "value": "含む"
          },
          {
           "key": "2",
           "value": "含まない"
          }
         ],
         "labelLText": "みなし2号",
         "labelLWidth": "S",
         "labelLAlign": 2,
         "onClick": "",
         "newLineItemNumber": 2,
         "spaceSize": "M",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "chkMinashiNigo",
         "items": [],
         "controlType": "CheckBoxList",
         "width": "M",
         "visible": true,
         "displayNone": true,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "float": 0,
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "8",
         "marginRight": "XS",
         "selectControlID": "chkMinashiNigo_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "selectedItem": null,
         "dataSource": [
          {
           "key": "1",
           "value": "みなし2号のみ"
          }
         ],
         "labelLText": "",
         "labelLWidth": "S",
         "labelLAlign": 2,
         "onClick": "",
         "selectedItems": [],
         "newLineItemNumber": 2,
         "minCheckedItem": 0,
         "maxCheckedItem": 2,
         "spaceSize": "M",
         "isAllSelectable": false,
         "isAllSelectableBreakLine": false,
         "disabledItem": [],
         "icon": []
        }
       ],
       "controlType": "Panel",
       "width": "1100",
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
       "selectControlID": "SearchCriteriaDetail",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "詳細条件",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": false,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "SearchCriteriaDetail"
        }
       ],
       "requestSettings": [],
       "hiddenInput": [],
       "onOpen": "",
       "onClose": "",
       "session": {},
       "eraseBorder": false,
       "backgroundColor": 0,
       "widthAuto": false,
       "panelDisplay": 2,
       "isGroupBox": false,
       "readOnly": false,
       "height": "Auto"
      }
     ],
     "controlType": "Panel",
     "width": "G12",
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
     "marginRight": "XS",
     "selectControlID": "SearchCriteriaOfHihokensha",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "介護検索条件",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchCriteriaOfHihokensha"
      }
     ],
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
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "KaigoAtenaFinder",
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
     "selectControlID": "KaigoAtenaFinder",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "businessId": "URA",
     "controlName": "AtenaFinder",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M",
     "AtenaFinder_title": "宛名検索条件",
     "AtenaFinder_canOpenAndClose": true,
     "AtenaFinder_width": "G12",
     "txtSeinenGappi_displayNone": false,
     "ddlSeibetsu_displayNone": false,
     "txtBanchiCode4_displayNone": true,
     "txtSetaiCode_displayNone": false,
     "txtKojinNo_displayNone": false,
     "txtHojinNo_displayNone": true,
     "txtHojinKeitaiCode_displayNone": true,
     "btnHojinKeitaiGuide_displayNone": true,
     "txtHojinKeitaiMeisho_displayNone": true,
     "txtJuminhyoCode_displayNone": true,
     "txtZairyuCardCode_displayNone": true,
     "txtKokuhoNo_displayNone": true,
     "txtKokiKoreiHihokenshaNo_displayNone": true,
     "txtKaigoHihokenshaNo_displayNone": true,
     "txtKisoNenkinNo_displayNone": true,
     "txtInkanNo_displayNone": true,
     "AtenaFinderShosai_title": "詳細条件",
     "AtenaFinderShosai_displayNone": false,
     "AtenaFinderShosai_width": "1100",
     "chkJuminShubetsu_displayNone": false,
     "chkJuminShubetsu_dataSource": [
      {
       "key": "key0",
       "value": "住登内個人"
      },
      {
       "key": "key1",
       "value": "住登外個人"
      },
      {
       "key": "key2",
       "value": "法人　　　"
      },
      {
       "key": "key3",
       "value": "共有者　　"
      }
     ],
     "chkJuminShubetsu_isAllSelectable": true,
     "chkJuminJotai_displayNone": false,
     "chkJuminJotai_dataSource": [
      {
       "key": "key0",
       "value": "住民　　　"
      },
      {
       "key": "key1",
       "value": "未登録住民"
      },
      {
       "key": "key2",
       "value": "消除者　　"
      },
      {
       "key": "key3",
       "value": "転出者　　"
      },
      {
       "key": "key4",
       "value": "死亡者"
      }
     ],
     "chkJuminJotai_isAllSelectable": true,
     "radNihonjinKubun_displayNone": false,
     "radGaikokujinKubun_displayNone": false,
     "txtGyoseikuCode_displayNone": false,
     "btnGyoseikuGuide_displayNone": false,
     "txtGyoseikuMeisho_displayNone": false,
     "txtRenrakusaki_displayNone": false,
     "AtenaFinder_eraseBorder": false
    },
    {
     "fieldName": "ButtonsForHihokenshaFinder",
     "items": [
      {
       "fieldName": "btnToClear",
       "items": [],
       "controlType": "Button",
       "width": "M",
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
       "selectControlID": "btnToClear",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "条件をクリアする",
       "onClick": "onClick_btnToClear",
       "icon": 0,
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      },
      {
       "fieldName": "btnToSearch",
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
       "selectControlID": "btnToSearch",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "検索する",
       "onClick": "",
       "icon": 0,
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      },
      {
       "fieldName": "txtMaxNumber",
       "items": [],
       "controlType": "TextBoxNum",
       "width": "XS",
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
       "selectControlID": "txtMaxNumber_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "required": false,
       "labelLText": "最大表示件数",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 1,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "text": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "+-,.\\",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": false,
       "decimalPointLength": 0
      }
     ],
     "controlType": "Panel",
     "width": "1110",
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
     "selectControlID": "ButtonsForHihokenshaFinder",
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
       "postParameterPanelNames": "ButtonsForHihokenshaFinder"
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
     "height": "Auto"
    },
    {
     "fieldName": "saikinShorisha",
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
     "selectControlID": "saikinShorisha",
     "helpMessageID": "",
     "jpControlName": "",
     "relation": [],
     "businessId": "DBZ",
     "controlName": "KaigoSaikinShorishaRireki",
     "marginTop": 0,
     "marginBottom": 0,
     "originalProperty": [],
     "dataPassingForDialog": [],
     "dialogOkEventNameForDialog": "",
     "dialogCancelEventNameForDialog": "",
     "canTransferEvent": true,
     "heightForDialog": "M"
    }
   ],
   "controlType": "Panel",
   "width": "G12",
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
   "marginRight": "XS",
   "selectControlID": "HihokenshaFinder",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "HihokenshaFinder"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbz/db/dbz/HihokenshaFinder/onLoad"
    },
    {
     "eventName": "onClick_btnToClear",
     "requestUrl": "dbz/db/dbz/HihokenshaFinder/onClick_btnToClear"
    }
   ],
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
 "controlName": "HihokenshaFinder",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnToSearch",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClick_BtnToSearch"
  },
  {
   "publicChildFieldName": "txtTuchishoNo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_txtTsuchishoNo"
  },
  {
   "publicChildFieldName": "ddlFukaNendo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_ddlFukaNendo"
  },
  {
   "publicChildFieldName": "SearchCriteriaDetail",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_SearchCriteriaDetail"
  },
  {
   "publicChildFieldName": "HihokenshaFinder",
   "publicChildProperty": "canOpenAndClose",
   "newPropertyName": "canOpenAndClose_HihokenshaFinder"
  },
  {
   "publicChildFieldName": "saikinShorisha",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_saikinShorisha"
  },
  {
   "publicChildFieldName": "ddlHokensha",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_ddlHokensha"
  },
  {
   "publicChildFieldName": "chkMinashiNigo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "displayNone_chkMinashiNigo"
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

