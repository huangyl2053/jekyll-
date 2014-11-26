/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module JutakuKaishuShinseiDetailInput {

        export class Events {

            public static get onSelectByModifyButton(): string {
                return "onSelectByModifyButton";
            }
            public static get onClick_btnModifyDetail(): string {
                return "onClick_btnModifyDetail";
            }
            public static get onSelectByDeleteButton(): string {
                return "onSelectByDeleteButton";
            }
            public static get onClick_btnCopyAddress(): string {
                return "onClick_btnCopyAddress";
            }
            public static get onClick_btnClearDetail(): string {
                return "onClick_btnClearDetail";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "JutakuKaishuShinseiDetailInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public JutakuKaishuShinseiDetailInput() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public dgJutakuKaishuDetail() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));

            }

            public JutakuKaishuDetailInput() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JutakuKaishuDetailInput"));

            }

            public txtKaishuContents() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));

            }

            public txtKaishuJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));

            }

            public lblKaishuTaishoAddress() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKaishuTaishoAddress"));

            }

            public btnCopyAddress() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnCopyAddress"));

            }

            public txtKaishuTaishoAddress() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKaishuTaishoAddress"));

            }

            public txtChakkoDueDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));

            }

            public txtKanseiDueDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));

            }

            public txtEstimatedAmount() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));

            }

            public btnClearDetail() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnClearDetail"));

            }

            public btnModifyDetail() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnModifyDetail"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class JutakuKaishuShinseiDetailInput_Design extends Uz.CommonChildDiv {
    
        public get txtChakkoDate_lableLText() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"])["labelLText"];
        }
        
        public set txtChakkoDate_lableLText(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[1].items[5]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get txtKanseiDate_lableLText() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"])["labelLText"];
        }
        
        public set txtKanseiDate_lableLText(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[1].items[6]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClick_btnModifyDetail() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"];
        }
        
        public set onClick_btnModifyDetail(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[1].items[9]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get btnModify_text() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"];
        }
        
        public set btnModify_text(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"])["text"] = value;
            } else {
                this.layout.items[0].items[1].items[9]["text"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dg_gridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"];
        }
        
        public set dg_gridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[0]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, JutakuKaishuShinseiDetailInput_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("txtChakkoDate_lableLText");
            Uz.JSControlUtil.registProperty("txtKanseiDate_lableLText");
            Uz.JSControlUtil.registProperty("onClick_btnModifyDetail");
            Uz.JSControlUtil.registProperty("btnModify_text");
            Uz.JSControlUtil.registProperty("dg_gridSetting");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["txtChakkoDate_lableLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[5]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["txtKanseiDate_lableLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[6]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["onClick_btnModifyDetail"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnModify_text"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[9]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["dg_gridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "JutakuKaishuShinseiDetailInput",
   "items": [
    {
     "fieldName": "dgJutakuKaishuDetail",
     "items": [],
     "controlType": "DataGrid",
     "width": "545px",
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
     "marginRight": "0em",
     "selectControlID": "dgJutakuKaishuDetail",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "221px",
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
      "selectLimitRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 1
      },
      "columns": [
       {
        "columnName": "着工<br>予定日",
        "dataName": "txtChakkoDueDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": "",
         "isSetValueToToolTip": false,
         "readOnly": true
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtChakkoDueDate"
       },
       {
        "columnName": "完成<br>予定日",
        "dataName": "txtKanseiDueDate",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 6,
        "cellDetails": {
         "cellType": 6,
         "ymdKubun": 2,
         "displayFormat": 0,
         "onChange": "",
         "isSetValueToToolTip": false,
         "readOnly": true
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKanseiDueDate"
       },
       {
        "columnName": "改修金額",
        "dataName": "txtKaishuAmount",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 5,
        "cellDetails": {
         "cellType": 5,
         "maxLength": "1000000000000",
         "minLength": "0",
         "maxValue": "1.7976931348623157e+308",
         "minValue": "0",
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": "0",
         "onChange": "",
         "isSetValueToToolTip": false,
         "readOnly": true
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKaishuAmount"
       },
       {
        "columnName": "事業者",
        "dataName": "txtKaishuJigyosha",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKaishuJigyosha"
       },
       {
        "columnName": "改修対象住所",
        "dataName": "txtKaishuTaishoAddress",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKaishuTaishoAddress"
       },
       {
        "columnName": "改修内容",
        "dataName": "txtKaishuContents",
        "toolTip": "",
        "bgColor": 0,
        "width": 300,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtKaishuContents"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "onSelectByModifyButton",
     "onSelectByDeleteButton": "onSelectByDeleteButton",
     "onAfterRequest": "",
     "onAfterRequestByDblClick": "",
     "onAfterRequestBySelectButton": "",
     "onAfterRequestByModifyButton": "",
     "onAfterRequestByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtKaishuAmount",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
    },
    {
     "fieldName": "JutakuKaishuDetailInput",
     "items": [
      {
       "fieldName": "txtKaishuContents",
       "items": [],
       "controlType": "TextBoxMultiLine",
       "width": "415px",
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
       "selectControlID": "txtKaishuContents_text_area",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "height": "XS",
       "required": false,
       "placeHolder": "",
       "isPrivateInfo": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "改修の内容・<br>箇所及び規模",
       "labelRText": "",
       "labelLWidth": "105px",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "decorationClass": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textKind": 0,
       "limitLength": "",
       "countDisp": false
      },
      {
       "fieldName": "txtKaishuJigyoshaName",
       "items": [],
       "controlType": "TextBox",
       "width": "360px",
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
       "selectControlID": "txtKaishuJigyoshaName_core",
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
       "labelLText": "事業者",
       "labelRText": "",
       "labelLWidth": "105px",
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
       "fieldName": "lblKaishuTaishoAddress",
       "items": [],
       "controlType": "Label",
       "width": "105px",
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
       "selectControlID": "lblKaishuTaishoAddress",
       "helpMessageID": "",
       "jpControlName": "",
       "required": false,
       "isPrivateInfo": false,
       "text": "対象住宅住所",
       "decorationClass": "",
       "align": 2
      },
      {
       "fieldName": "btnCopyAddress",
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
       "float": 0,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "-0.1em",
       "marginRight": "XS",
       "selectControlID": "btnCopyAddress",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "本人住所をコピーする",
       "onClick": "onClick_btnCopyAddress",
       "icon": 0,
       "onBeforeClick": "",
       "onAfterClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      },
      {
       "fieldName": "txtKaishuTaishoAddress",
       "items": [],
       "controlType": "TextBox",
       "width": "415px",
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
       "marginLeft": "7em",
       "marginRight": "XS",
       "selectControlID": "txtKaishuTaishoAddress_core",
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
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "XS",
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
       "fieldName": "txtChakkoDueDate",
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
       "selectControlID": "txtChakkoDueDate_core",
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
       "labelLText": "着工予定日",
       "labelRText": "",
       "labelLWidth": "105px",
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
       "fieldName": "txtKanseiDueDate",
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
       "selectControlID": "txtKanseiDueDate_core",
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
       "labelLText": "完成予定日",
       "labelRText": "",
       "labelLWidth": "100px",
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
       "fieldName": "txtEstimatedAmount",
       "items": [],
       "controlType": "TextBoxNum",
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
       "selectControlID": "txtEstimatedAmount_core",
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
       "labelLText": "改修金額",
       "labelRText": "",
       "labelLWidth": "105px",
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
       "fieldName": "btnClearDetail",
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
       "selectControlID": "btnClearDetail",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "入力内容をクリアする",
       "onClick": "onClick_btnClearDetail",
       "icon": 0,
       "onBeforeClick": "",
       "onAfterClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      },
      {
       "fieldName": "btnModifyDetail",
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
       "selectControlID": "btnModifyDetail",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "明細を追加する",
       "onClick": "onClick_btnModifyDetail",
       "icon": 0,
       "onBeforeClick": "",
       "onAfterClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "heightTextBoxMatches": false
      }
     ],
     "controlType": "Panel",
     "width": "545px",
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
     "marginRight": "0em",
     "selectControlID": "JutakuKaishuDetailInput",
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
       "postParameterPanelNames": "JutakuKaishuDetailInput"
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
     "panelDisplay": 0,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto",
     "canPost": true
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
   "selectControlID": "JutakuKaishuShinseiDetailInput",
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
     "postParameterPanelNames": "JutakuKaishuShinseiDetailInput"
    }
   ],
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
 "businessId": "DBC",
 "controlName": "JutakuKaishuShinseiDetailInput",
 "marginTop": "0em",
 "marginBottom": "0em",
 "originalProperty": [
  {
   "publicChildFieldName": "txtChakkoDueDate",
   "publicChildProperty": "labelLText",
   "newPropertyName": "txtChakkoDate_lableLText"
  },
  {
   "publicChildFieldName": "txtKanseiDueDate",
   "publicChildProperty": "labelLText",
   "newPropertyName": "txtKanseiDate_lableLText"
  },
  {
   "publicChildFieldName": "btnModifyDetail",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClick_btnModifyDetail"
  },
  {
   "publicChildFieldName": "btnModifyDetail",
   "publicChildProperty": "text",
   "newPropertyName": "btnModify_text"
  },
  {
   "publicChildFieldName": "dgJutakuKaishuDetail",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "dg_gridSetting"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": ""
}        
    }
}

