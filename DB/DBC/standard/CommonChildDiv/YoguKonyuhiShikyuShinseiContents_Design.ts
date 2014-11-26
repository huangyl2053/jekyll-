/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module YoguKonyuhiShikyuShinseiContents {

        export class Events {

            public static get onClick_btnReflect(): string {
                return "onClick_btnReflect";
            }
            public static get onClick_btnAddSeikyuDetail(): string {
                return "onClick_btnAddSeikyuDetail";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "YoguKonyuhiShikyuShinseiContents";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public YoguKonyuhiShikyuShinseiContents() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtKeikyoYM() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtKeikyoYM"));

            }

            public txtSeiriNo() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));

            }

            public txtKyufuRitsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));

            }

            public YoguKonyuhiShikyuShinseiSeikyuDetail() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));

            }

            public btnInputDetail() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnInputDetail"));

            }

            public dgSeikyuDetail() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));

            }

            public YoguKonyuhiShikyuShinseiSeikyuDetailInput() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetailInput"));

            }

            public txtBuyYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));

            }

            public ddlShumoku() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlShumoku"));

            }

            public txtShohinName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShohinName"));

            }

            public txtSeizoJigyosha() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));

            }

            public txtHanbaiJigyosha() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));

            }

            public txtBuyAmount() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));

            }

            public txtHinmokuCode() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));

            }

            public radShinsaMethod() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radShinsaMethod"));

            }

            public btnClear() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnClear"));

            }

            public btnAddSeikyuDetail() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnAddSeikyuDetail"));

            }

            public SeikyuSummary() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("SeikyuSummary"));

            }

            public tblSeikyuSummary() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));

            }

            public cel11() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel11"));

            }

            public lblSummary() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummary"));

            }

            public cel12() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel12"));

            }

            public lblPayTotal() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblPayTotal"));

            }

            public cel13() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel13"));

            }

            public lblHokenSeikyuAmount() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHokenSeikyuAmount"));

            }

            public cel21() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel21"));

            }

            public lblSummaryMae() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummaryMae"));

            }

            public cel22() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel22"));

            }

            public txtPayTotalMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalMae"));

            }

            public cel23() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel23"));

            }

            public txtHokenSeikyuAmountMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountMae"));

            }

            public cel31() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel31"));

            }

            public lblSummaryNow() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSummaryNow"));

            }

            public cel32() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel32"));

            }

            public txtPayTotalNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalNow"));

            }

            public cel33() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel33"));

            }

            public txtHokenSeikyuAmountNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountNow"));

            }

            public cel14() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel14"));

            }

            public lblRiyoshaFutanAmount() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));

            }

            public cel15() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel15"));

            }

            public lblLimitOverAmount() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblLimitOverAmount"));

            }

            public cel24() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel24"));

            }

            public txtRiyoshaFutanAmountMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));

            }

            public cel25() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel25"));

            }

            public txtLimitOverAmountMae() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountMae"));

            }

            public cel34() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel34"));

            }

            public txtRiyoshaFutanAmountNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));

            }

            public cel35() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel35"));

            }

            public txtLimitOverAmountNow() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountNow"));

            }

            public cel36() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("cel36"));

            }

            public btnLimitOverCheck() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));

            }

            public YoguKonyuhiShikyuShinseishaJoho() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho"));

            }

            public txtShinseiYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));

            }

            public txtUketsukeYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));

            }

            public YoguKonyuhiShikyuShinseisha() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseisha"));

            }

            public radShinseishaKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));

            }

            public txtShinseishaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));

            }

            public txtYubinNo() : UZA.TextBoxYubinNo {

                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));

            }

            public txtAddress() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtAddress"));

            }

            public txtTelNo() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtTelNo"));

            }

            public txtJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));

            }

            public btnSearchJigyosha() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));

            }

            public YoguKonyuhiShikyuShinseiPaymentMethod() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod"));

            }

            public radPayMethod() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radPayMethod"));

            }

            public URKoza() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("URKoza"));

            }

            public txtKari1() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKari1"));

            }

            public DBZJuryoinin() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("DBZJuryoinin"));

            }

            public txtKari2() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKari2"));

            }

            public btnUpdateShikyuShinsei() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnUpdateShikyuShinsei"));

            }

            public btnCancelShikyuShinsei() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnCancelShikyuShinsei"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class YoguKonyuhiShikyuShinseiContents_Design extends Uz.CommonChildDiv {
    
        public get AddSeikyuDetailOnclick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"])["onClick"];
        }
        
        public set AddSeikyuDetailOnclick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[3].items[2].items[9]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, YoguKonyuhiShikyuShinseiContents_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("AddSeikyuDetailOnclick");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["AddSeikyuDetailOnclick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "YoguKonyuhiShikyuShinseiContents",
   "items": [
    {
     "fieldName": "txtKeikyoYM",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "55",
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
     "required": false,
     "readOnly": true,
     "placeHolder": "平26.06",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "提供年月",
     "labelRText": "",
     "labelLWidth": "60",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 1,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtSeiriNo",
     "items": [],
     "controlType": "TextBox",
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
     "required": false,
     "readOnly": true,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "整理番号",
     "labelRText": "",
     "labelLWidth": "60",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "isComboBox": false,
     "suggest": [],
     "permitCharactor": ""
    },
    {
     "fieldName": "txtKyufuRitsu",
     "items": [],
     "controlType": "TextBoxNum",
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
     "required": false,
     "readOnly": false,
     "placeHolder": "90",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "給付率",
     "labelRText": "％",
     "labelLWidth": "45",
     "labelRWidth": "15",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 2,
     "isComboBox": false,
     "suggest": [],
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": false,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
     "items": [
      {
       "fieldName": "btnInputDetail",
       "items": [],
       "controlType": "Button",
       "width": "M",
       "visible": false,
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
       "text": "明細を入力する",
       "onClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": ""
      },
      {
       "fieldName": "dgSeikyuDetail",
       "items": [],
       "controlType": "DataGrid",
       "width": "760",
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
       "gridSetting": {
        "rowHeight": 25,
        "isMultiSelectable": false,
        "isShowFooter": true,
        "isShowFilter": false,
        "isShowFilterButton": false,
        "isShowRowState": false,
        "header": {
         "combineColumns": [],
         "frozenColumn": "",
         "headerHeight": 0
        },
        "columns": [
         {
          "columnName": "修正",
          "dataName": "btnModify",
          "toolTip": "",
          "bgColor": 0,
          "width": 50,
          "visible": true,
          "cellType": 8,
          "cellDetails": {
           "cellType": 8,
           "text": "修正",
           "onClick": "onClick_dgMeisai_modify",
           "imageFileUrl": "/uz/uza/css/Link.jpg",
           "imageWidth": "",
           "imageHeight": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "btnModify"
         },
         {
          "columnName": "削除",
          "dataName": "btnDelete",
          "toolTip": "",
          "bgColor": 0,
          "width": 50,
          "visible": true,
          "cellType": 8,
          "cellDetails": {
           "cellType": 8,
           "text": "...",
           "onClick": "onClick_dgMeisai_delete",
           "imageFileUrl": "/uz/uza/css/Link.jpg",
           "imageWidth": "",
           "imageHeight": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "btnDelete"
         },
         {
          "columnName": "状態",
          "dataName": "txtRowState",
          "toolTip": "",
          "bgColor": 0,
          "width": 50,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "15",
           "minLength": "0",
           "textAlign": 0,
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtRowState"
         },
         {
          "columnName": "購入日",
          "dataName": "txtBuyYMD",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
          "visible": true,
          "cellType": 6,
          "cellDetails": {
           "cellType": 6,
           "ymdKubun": 2,
           "displayFormat": 0,
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtBuyYMD"
         },
         {
          "columnName": "種目",
          "dataName": "txtShumoku",
          "toolTip": "",
          "bgColor": 0,
          "width": 120,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "1000000000000",
           "minLength": "0",
           "textAlign": 0,
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtShumoku"
         },
         {
          "columnName": "商品名",
          "dataName": "txtShohinName",
          "toolTip": "",
          "bgColor": 0,
          "width": 210,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "15",
           "minLength": "0",
           "textAlign": 0,
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtShohinName"
         },
         {
          "columnName": "購入金額",
          "dataName": "txtBuyAmount",
          "toolTip": "",
          "bgColor": 0,
          "width": 80,
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
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtBuyAmount"
         },
         {
          "columnName": "審査方法",
          "dataName": "txtShinsaMethod",
          "toolTip": "",
          "bgColor": 0,
          "width": 100,
          "visible": true,
          "cellType": 1,
          "cellDetails": {
           "cellType": 1,
           "maxLength": "1000000000000",
           "minLength": "0",
           "textAlign": 0,
           "onChange": ""
          },
          "align": 0,
          "resize": true,
          "isPrivateInfo": false,
          "sortKey": "txtShinsaMethod"
         }
        ]
       },
       "height": "155",
       "onSort": "",
       "onSelect": "",
       "onSelectByDblClick": "",
       "onOnlyRow": "",
       "onNoRow": "",
       "onMultiRows": "",
       "dataSource": [],
       "sortOrder": "txtShinsaMethod",
       "isAscending": true,
       "filterList": [],
       "activeRowId": -1
      },
      {
       "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
       "items": [
        {
         "fieldName": "txtBuyYMD",
         "items": [],
         "controlType": "TextBoxDate",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "平26.6.15",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "購入日",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "ymdKubun": 2,
         "displayFormat": 0,
         "value": "",
         "permitCharactor": "./_-"
        },
        {
         "fieldName": "ddlShumoku",
         "items": [],
         "controlType": "DropDownList",
         "width": "250",
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
         "required": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "labelLText": "種目",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "dataSource": [
          {
           "key": "code01",
           "value": "01:腰掛便座"
          },
          {
           "key": "code02",
           "value": "02:特殊尿器"
          },
          {
           "key": "code03",
           "value": "03:入浴補助用具"
          },
          {
           "key": "code04",
           "value": "04:簡易浴槽"
          },
          {
           "key": "code05",
           "value": "05:移動用リフトのつり具の部分"
          },
          {
           "key": "code06",
           "value": "06:自動排泄処理装置の交換可能部品"
          }
         ],
         "selectedItem": ""
        },
        {
         "fieldName": "txtShohinName",
         "items": [],
         "controlType": "TextBox",
         "width": "340",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "商品名",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtSeizoJigyosha",
         "items": [],
         "controlType": "TextBox",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "製造事業者",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtHanbaiJigyosha",
         "items": [],
         "controlType": "TextBox",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "販売事業者",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtBuyAmount",
         "items": [],
         "controlType": "TextBoxNum",
         "width": "80",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 2,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "購入金額",
         "labelRText": "円",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 2,
         "isComboBox": false,
         "suggest": [],
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": false,
         "decimalPointLength": 0,
         "permitCharactor": "+-,.\\"
        },
        {
         "fieldName": "txtHinmokuCode",
         "items": [],
         "controlType": "TextBoxCode",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 2,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "品目コード",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": "",
         "formatLength": 1
        },
        {
         "fieldName": "radShinsaMethod",
         "items": [],
         "controlType": "RadioButton",
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
         "required": false,
         "onChange": "",
         "labelLText": "審査方法",
         "labelLWidth": "75",
         "labelLAlign": 2,
         "onClick": "",
         "dataSource": [
          {
           "key": "judgeRequest",
           "value": "審査依頼"
          },
          {
           "key": "judgeDone",
           "value": "審査済み"
          }
         ],
         "selectedItem": "judgeDone",
         "newLineItemNumber": 2,
         "spaceSize": 1
        },
        {
         "fieldName": "btnClear",
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
         "text": "入力内容をクリアする",
         "onClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        },
        {
         "fieldName": "btnAddSeikyuDetail",
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
         "text": "明細を追加する",
         "onClick": "onClick_btnAddSeikyuDetail",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": ""
        }
       ],
       "controlType": "Panel",
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
       "marginLeft": "0.2",
       "marginRight": "0",
       "onLoad": "",
       "title": "",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetailInput"
        }
       ],
       "requestSettings": [
        {
         "eventName": "onLoad",
         "requestUrl": ""
        },
        {
         "eventName": "onClick_btnAdd",
         "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
        }
       ],
       "hiddenInput": [],
       "onOpen": "",
       "onClose": "",
       "session": {},
       "eraseBorderTop": false,
       "eraseBorderBottom": false,
       "eraseBorderRight": false,
       "eraseBorderLeft": false,
       "backgroundColor": 0,
       "widthAuto": false,
       "isGroupBox": false
      },
      {
       "fieldName": "SeikyuSummary",
       "items": [
        {
         "fieldName": "tblSeikyuSummary",
         "items": [
          {
           "fieldName": "cel11",
           "items": [
            {
             "fieldName": "lblSummary",
             "items": [],
             "controlType": "Label",
             "width": "XS",
             "visible": true,
             "displayNone": true,
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
             "required": false,
             "isPrivateInfo": false,
             "text": "集計",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R1C1"
          },
          {
           "fieldName": "cel12",
           "items": [
            {
             "fieldName": "lblPayTotal",
             "items": [],
             "controlType": "Label",
             "width": "90",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "支払金額合計",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R1C2"
          },
          {
           "fieldName": "cel13",
           "items": [
            {
             "fieldName": "lblHokenSeikyuAmount",
             "items": [],
             "controlType": "Label",
             "width": "75",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "保険請求額",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R1C3"
          },
          {
           "fieldName": "cel21",
           "items": [
            {
             "fieldName": "lblSummaryMae",
             "items": [],
             "controlType": "Label",
             "width": "135",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "前回までの支払結果",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R2C1"
          },
          {
           "fieldName": "cel22",
           "items": [
            {
             "fieldName": "txtPayTotalMae",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "0",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R2C2"
          },
          {
           "fieldName": "cel23",
           "items": [
            {
             "fieldName": "txtHokenSeikyuAmountMae",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "0",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R2C3"
          },
          {
           "fieldName": "cel31",
           "items": [
            {
             "fieldName": "lblSummaryNow",
             "items": [],
             "controlType": "Label",
             "width": "135",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "今回の支払状況",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C1"
          },
          {
           "fieldName": "cel32",
           "items": [
            {
             "fieldName": "txtPayTotalNow",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "123456789",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C2"
          },
          {
           "fieldName": "cel33",
           "items": [
            {
             "fieldName": "txtHokenSeikyuAmountNow",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "123456789",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C3"
          },
          {
           "fieldName": "cel14",
           "items": [
            {
             "fieldName": "lblRiyoshaFutanAmount",
             "items": [],
             "controlType": "Label",
             "width": "90",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "利用者負担額",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R1C4"
          },
          {
           "fieldName": "cel15",
           "items": [
            {
             "fieldName": "lblLimitOverAmount",
             "items": [],
             "controlType": "Label",
             "width": "75",
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
             "required": false,
             "isPrivateInfo": false,
             "text": "限度超過額",
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R1C5"
          },
          {
           "fieldName": "cel24",
           "items": [
            {
             "fieldName": "txtRiyoshaFutanAmountMae",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "0",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R2C4"
          },
          {
           "fieldName": "cel25",
           "items": [
            {
             "fieldName": "txtLimitOverAmountMae",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "0",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R2C5"
          },
          {
           "fieldName": "cel34",
           "items": [
            {
             "fieldName": "txtRiyoshaFutanAmountNow",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "123456789",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C4"
          },
          {
           "fieldName": "cel35",
           "items": [
            {
             "fieldName": "txtLimitOverAmountNow",
             "items": [],
             "controlType": "TextBoxNum",
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
             "required": false,
             "readOnly": false,
             "placeHolder": "123456789",
             "textKind": 2,
             "isPrivateInfo": false,
             "isPassword": false,
             "onFocus": "",
             "onBlur": "",
             "onChange": "",
             "onKeyPress": "",
             "text": "",
             "labelLText": "",
             "labelRText": "",
             "labelLWidth": "90",
             "labelRWidth": "15",
             "labelLAlign": 2,
             "labelRAlign": 0,
             "value": "",
             "maxLength": 1000000000000,
             "minLength": 0,
             "textAlign": 2,
             "isComboBox": false,
             "suggest": [],
             "maxValue": 1.7976931348623157e+308,
             "minValue": 0,
             "isCurrency": false,
             "isComma": true,
             "decimalPointLength": 0,
             "permitCharactor": "+-,.\\"
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C5"
          },
          {
           "fieldName": "cel36",
           "items": [
            {
             "fieldName": "btnLimitOverCheck",
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
             "marginLeft": "XS",
             "marginRight": "XS",
             "text": "限度額をチェックする",
             "onClick": "",
             "appearance": 0,
             "imageFileUrl": "",
             "imageWidth": "",
             "imageHeight": ""
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
           "marginLeft": 0,
           "marginRight": 0,
           "connectTd": "R3C6"
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
         "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td><td id='R3C6'></td></tr>\n  </tbody>\n</table>\n"
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "onLoad": "",
       "title": "",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "SeikyuSummary"
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
     "controlType": "Panel",
     "width": "1225",
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
     "onLoad": "",
     "title": "請求明細",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetail"
      }
     ],
     "requestSettings": [
      {
       "eventName": "onLoad",
       "requestUrl": ""
      },
      {
       "eventName": "onClick_btnAddSeikyuDetail",
       "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiSeikyuDetail/onClick_btnAddSeikyuDetail"
      }
     ],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "isGroupBox": true
    },
    {
     "fieldName": "YoguKonyuhiShikyuShinseishaJoho",
     "items": [
      {
       "fieldName": "txtShinseiYMD",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "75",
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
       "required": false,
       "readOnly": false,
       "placeHolder": "平26.07.01",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "申請日",
       "labelRText": "",
       "labelLWidth": "75",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtUketsukeYMD",
       "items": [],
       "controlType": "TextBoxDate",
       "width": "75",
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
       "required": false,
       "readOnly": false,
       "placeHolder": "平26.07.01",
       "textKind": 0,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "text": "",
       "labelLText": "受付日",
       "labelRText": "",
       "labelLWidth": "45",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "YoguKonyuhiShikyuShinseisha",
       "items": [
        {
         "fieldName": "radShinseishaKubun",
         "items": [],
         "controlType": "RadioButton",
         "width": "500",
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
         "required": false,
         "onChange": "",
         "labelLText": "区分",
         "labelLWidth": "75",
         "labelLAlign": 2,
         "onClick": "",
         "dataSource": [
          {
           "key": "myself",
           "value": "本人"
          },
          {
           "key": "family",
           "value": "家族"
          },
          {
           "key": "serviceJigyosha",
           "value": "サービス事業者"
          },
          {
           "key": "other",
           "value": "その他"
          }
         ],
         "selectedItem": "family",
         "newLineItemNumber": 4,
         "spaceSize": 1
        },
        {
         "fieldName": "txtShinseishaName",
         "items": [],
         "controlType": "TextBox",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "氏名",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtYubinNo",
         "items": [],
         "controlType": "TextBoxYubinNo",
         "width": "S",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 2,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "住所",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtAddress",
         "items": [],
         "controlType": "TextBox",
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
         "marginLeft": "0",
         "marginRight": "XS",
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
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
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtTelNo",
         "items": [],
         "controlType": "TextBox",
         "width": "120",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "00000000000",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "電話番号",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        },
        {
         "fieldName": "txtJigyoshaNo",
         "items": [],
         "controlType": "TextBoxCode",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "1234567890",
         "textKind": 2,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "text": "",
         "labelLText": "事業者番号",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": "",
         "formatLength": 1
        },
        {
         "fieldName": "btnSearchJigyosha",
         "items": [],
         "controlType": "Button",
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
         "marginRight": "XS",
         "text": "Button1",
         "onClick": "",
         "appearance": 1,
         "imageFileUrl": "/uz/uza/css/Link.jpg",
         "imageWidth": "18",
         "imageHeight": "20"
        }
       ],
       "controlType": "Panel",
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
       "onLoad": "",
       "title": "",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "YoguKonyuhiShikyuShinseisha"
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
     "controlType": "Panel",
     "width": "1220",
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
     "onLoad": "",
     "title": "申請者情報",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "YoguKonyuhiShikyuShinseishaJoho"
      }
     ],
     "requestSettings": [
      {
       "eventName": "onLoad",
       "requestUrl": ""
      },
      {
       "eventName": "onClick_btnAdd",
       "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
      }
     ],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "isGroupBox": true
    },
    {
     "fieldName": "YoguKonyuhiShikyuShinseiPaymentMethod",
     "items": [
      {
       "fieldName": "radPayMethod",
       "items": [],
       "controlType": "RadioButton",
       "width": "300",
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
       "required": false,
       "onChange": "",
       "labelLText": "",
       "labelLWidth": "60",
       "labelLAlign": 2,
       "onClick": "",
       "dataSource": [
        {
         "key": "payToKoza",
         "value": "口座払い"
        },
        {
         "key": "payToJuryoinin",
         "value": "受領委任払い"
        },
        {
         "key": "payToMadoguchi",
         "value": "窓口払い"
        }
       ],
       "selectedItem": "payToKoza",
       "newLineItemNumber": 3,
       "spaceSize": 1
      },
      {
       "fieldName": "URKoza",
       "items": [
        {
         "fieldName": "txtKari1",
         "items": [],
         "controlType": "TextBox",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
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
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
        }
       ],
       "controlType": "Panel",
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
       "onLoad": "",
       "title": "口座払い（UR共有子Div）",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "DBZJuryoinin"
        }
       ],
       "requestSettings": [],
       "hiddenInput": [],
       "onOpen": "",
       "onClose": "",
       "session": {},
       "eraseBorderTop": false,
       "eraseBorderBottom": false,
       "eraseBorderRight": false,
       "eraseBorderLeft": false,
       "backgroundColor": 0,
       "widthAuto": true,
       "isGroupBox": false
      },
      {
       "fieldName": "DBZJuryoinin",
       "items": [
        {
         "fieldName": "txtKari2",
         "items": [],
         "controlType": "TextBox",
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
         "required": false,
         "readOnly": false,
         "placeHolder": "",
         "textKind": 0,
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
         "maxLength": 1000000000000,
         "minLength": 0,
         "textAlign": 0,
         "isComboBox": false,
         "suggest": [],
         "permitCharactor": ""
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "onLoad": "",
       "title": "受領委任払い（DBZ共有子Div）",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": true,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "DBZJuryoinin"
        }
       ],
       "requestSettings": [],
       "hiddenInput": [],
       "onOpen": "",
       "onClose": "",
       "session": {},
       "eraseBorderTop": false,
       "eraseBorderBottom": false,
       "eraseBorderRight": false,
       "eraseBorderLeft": false,
       "backgroundColor": 0,
       "widthAuto": true,
       "isGroupBox": false
      }
     ],
     "controlType": "Panel",
     "width": "1220",
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
     "onLoad": "",
     "title": "支払方法",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "YoguKonyuhiShikyuShinseiPaymentMethod"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorderTop": false,
     "eraseBorderBottom": false,
     "eraseBorderRight": false,
     "eraseBorderLeft": false,
     "backgroundColor": 0,
     "widthAuto": false,
     "isGroupBox": true
    },
    {
     "fieldName": "btnUpdateShikyuShinsei",
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
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "text": "申請を追加する",
     "onClick": "onClick_btnReflect",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    },
    {
     "fieldName": "btnCancelShikyuShinsei",
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
     "text": "申請の追加をやめる",
     "onClick": "onClick_btnReflect",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": ""
    }
   ],
   "controlType": "Panel",
   "width": "1235",
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
   "onLoad": "",
   "title": "支給申請内容",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "YoguKonyuhiShikyuShinseiContents"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onClick_btnAdd",
     "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
    }
   ],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
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
 "businessId": "DBC",
 "controlName": "YoguKonyuhiShikyuShinseiContents",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "btnAddSeikyuDetail",
   "publicChildProperty": "onClick",
   "newPropertyName": "AddSeikyuDetailOnclick"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

