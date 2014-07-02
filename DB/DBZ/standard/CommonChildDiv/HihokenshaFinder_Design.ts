/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * HihokenshaFinderクラスのみで継承して使えます。
     */
    export class HihokenshaFinder_Design extends Uz.CommonChildDiv {
    
        public get onClick_BtnToSearch() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"] + "_" + this.layout.items[0].items[5].items[1]["fieldName"])["onClick"];
        }
        
        public set onClick_BtnToSearch(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"] + "_" + this.layout.items[0].items[5].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"] + "_" + this.layout.items[0].items[5].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"] + "_" + this.layout.items[0].items[5].items[1]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[5].items[1]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_txtTsuchishoNo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[1]["fieldName"])["displayNone"];
        }
        
        public set displayNone_txtTsuchishoNo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[1]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[1].items[1]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_ddlFukaNendo() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[0]["fieldName"])["displayNone"];
        }
        
        public set displayNone_ddlFukaNendo(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[3].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get displayNone_SearchCriteriaDetail() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"];
        }
        
        public set displayNone_SearchCriteriaDetail(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[4]["displayNone"] = value;
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
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"];
        }
        
        public set displayNone_saikinShorisha(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[6]["displayNone"] = value;
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
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["onClick_BtnToSearch"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"] + "_" + this.layout.items[0].items[5].items[1]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["displayNone_txtTsuchishoNo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_ddlFukaNendo"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["displayNone_SearchCriteriaDetail"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["canOpenAndClose_HihokenshaFinder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["displayNone_saikinShorisha"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "HihokenshaFinder",
   "items": [
    {
     "fieldName": "SearchCriteriaOfHokensha",
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
       "text": "",
       "onChange": "",
       "selectedItem": "1",
       "required": false,
       "labelLText": "保険者",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "disabledItem": []
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
     "selectControlID": "SearchCriteriaOfHokensha",
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
       "postParameterPanelNames": "SearchCriteriaOfHokensha"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "SearchCriteriaOfHihokensha",
     "items": [
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
       "wrap": false,
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
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "被保番号",
       "labelRText": "",
       "labelLWidth": "S",
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
       "selectControlID": "txtTuchishoNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
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
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "16"
      }
     ],
     "controlType": "Panel",
     "width": "1075",
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
     "selectControlID": "SearchCriteriaOfHihokensha",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "被保険者",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": false,
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "SearchCriteriaOfKojin",
     "items": [
      {
       "fieldName": "txtShikibetsuCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "121",
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
       "selectControlID": "txtShikibetsuCode_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "識別コード",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": "15",
       "minLength": 0,
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": ""
      },
      {
       "fieldName": "txtSetaiCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "110",
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
       "selectControlID": "txtSetaiCode_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "世帯コード",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": "15",
       "minLength": 0,
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": 1
      },
      {
       "fieldName": "txtKojinNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "110",
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
       "selectControlID": "txtKojinNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "個人番号",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": "12",
       "minLength": "12",
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "12"
      },
      {
       "fieldName": "lblJuminShubetsu",
       "items": [],
       "controlType": "Label",
       "width": "120",
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
       "selectControlID": "lblJuminShubetsu",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "住民種別",
       "required": false,
       "isPrivateInfo": false,
       "decorationClass": "",
       "align": 2
      },
      {
       "fieldName": "ddlJuminShubetsu",
       "items": [],
       "controlType": "DropDownList",
       "width": "110",
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
       "selectControlID": "ddlJuminShubetsu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "key0",
         "value": "指定なし"
        },
        {
         "key": "key1",
         "value": "日本人"
        },
        {
         "key": "key2",
         "value": "外国人"
        }
       ],
       "text": "",
       "onChange": "",
       "selectedItem": "key0",
       "required": false,
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "disabledItem": []
      },
      {
       "fieldName": "txtShimei",
       "items": [],
       "controlType": "TextBox",
       "width": "L",
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
       "selectControlID": "txtShimei_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "氏名",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "ddlSearchPatternForName",
       "items": [],
       "controlType": "DropDownList",
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
       "selectControlID": "ddlSearchPatternForName_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "1",
         "value": "前方一致"
        },
        {
         "key": "2",
         "value": "後方一致"
        },
        {
         "key": "3",
         "value": "完全一致"
        },
        {
         "key": "4",
         "value": "部分一致"
        }
       ],
       "onChange": "",
       "selectedItem": "1",
       "labelLText": "",
       "labelRText": "で検索する。",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "disabledItem": []
      },
      {
       "fieldName": "txtYubinNo",
       "items": [],
       "controlType": "TextBoxYubinNo",
       "width": "68",
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
       "selectControlID": "txtYubinNo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "〒",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 2,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": ""
      },
      {
       "fieldName": "txtBirthDay",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
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
       "selectControlID": "txtBirthDay_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "生年月日",
       "labelRText": "",
       "labelLWidth": "170",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "placeHolder": "",
       "isPrivateInfo": false,
       "isPassword": false,
       "onKeyPress": "",
       "value": "",
       "permitCharactor": "./_-",
       "ymdKubun": 2,
       "displayFormat": 0
      },
      {
       "fieldName": "chkGender",
       "items": [],
       "controlType": "CheckBoxList",
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
       "selectControlID": "chkGender_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "man",
         "value": "男"
        },
        {
         "key": "woman",
         "value": "女"
        }
       ],
       "onClick": "",
       "icon": [],
       "onChange": "",
       "selectedItem": null,
       "required": false,
       "labelLText": "性別",
       "labelLWidth": "110",
       "labelLAlign": 2,
       "selectedItems": [],
       "newLineItemNumber": 2,
       "minCheckedItem": 0,
       "maxCheckedItem": 2,
       "spaceSize": "M",
       "isAllSelectable": false,
       "isAllSelectableBreakLine": false,
       "disabledItem": []
      },
      {
       "fieldName": "txtJusho",
       "items": [],
       "controlType": "TextBox",
       "width": "920",
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
       "selectControlID": "txtJusho_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "text": "",
       "onChange": "",
       "required": false,
       "labelLText": "住所",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "placeHolder": "",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "isComboBox": false,
       "onKeyPress": "",
       "suggest": [],
       "value": "",
       "decorationClass": "",
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
     "width": "1075",
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
     "selectControlID": "SearchCriteriaOfKojin",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "個人",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchCriteriaOfKojin"
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "SearchCriteriaOfOther",
     "items": [
      {
       "fieldName": "ddlFukaNendo",
       "items": [],
       "controlType": "DropDownList",
       "width": "60",
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
       "selectControlID": "ddlFukaNendo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "key0",
         "value": "平26"
        },
        {
         "key": "key1",
         "value": "平26"
        }
       ],
       "onChange": "",
       "selectedItem": "key0",
       "labelLText": "賦課年度　",
       "labelRText": "",
       "labelLWidth": "80",
       "labelRWidth": "S",
       "labelLAlign": 1,
       "labelRAlign": 0,
       "onFocus": "",
       "onBlur": "",
       "disabledItem": []
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
       "text": "",
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
     "width": "1075",
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
     "selectControlID": "SearchCriteriaOfOther",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SearchCriteriaOfOther"
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
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
    },
    {
     "fieldName": "SearchCriteriaDetail",
     "items": [
      {
       "fieldName": "chkMinashiNigo",
       "items": [],
       "controlType": "CheckBoxList",
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
       "selectControlID": "chkMinashiNigo_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "dataSource": [
        {
         "key": "1",
         "value": "含む"
        }
       ],
       "onClick": "",
       "icon": [],
       "onChange": "",
       "selectedItem": null,
       "labelLText": "みなし2号",
       "labelLWidth": "S",
       "labelLAlign": 2,
       "selectedItems": [],
       "newLineItemNumber": 2,
       "minCheckedItem": 0,
       "maxCheckedItem": 2,
       "spaceSize": "M",
       "isAllSelectable": false,
       "isAllSelectableBreakLine": false,
       "disabledItem": []
      }
     ],
     "controlType": "Panel",
     "width": "1075",
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
     "title": "詳細",
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
       "onClick": "onClick_btnToClear",
       "text": "条件をクリアする",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
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
       "onClick": "",
       "text": "検索する",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "heightTextBoxMatches": false
      }
     ],
     "controlType": "Panel",
     "width": "1075",
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
   "marginLeft": "XS",
   "marginRight": "XS",
   "selectControlID": "HihokenshaFinder",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "検索条件",
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
   "eraseBorder": false,
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

