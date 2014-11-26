/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />


/// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />
/// <reference path="KyufugakuSummary.ts" />


module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module JutakuKaishuJizenShinseiTab {

        export class Events {

            public static get onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "JutakuKaishuJizenShinseiTab";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public JutakuKaishuJizenShinseisha() : DBZ.ShinseishaInfo.ModeController {
                return new DBZ.ShinseishaInfo.ModeController("JutakuKaishuJizenShinseisha");
            }

            public JutakuKaishuJizenShinseiKyufugakuSummary() : DBC.KyufugakuSummary.ModeController {
                return new DBC.KyufugakuSummary.ModeController("JutakuKaishuJizenShinseiKyufugakuSummary");
            }

            public PaymentMethod() : DBZ.PaymentMethod.ModeController {
                return new DBZ.PaymentMethod.ModeController("PaymentMethod");
            }


            public JutakuKaishuJizenShinseiTab() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public tabJizenShinsei() : UZA.TabContainer {

                return new UZA.TabContainer(this.convFiledName("tabJizenShinsei"));

            }

            public tplJizenShinseiContents() : UZA.TabPanel {

                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiContents"));

            }

            public txtJutakuOwner() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));

            }

            public txtRelationWithHihokensha() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));

            }

            public dgJutakuKaishuJizenShinseiDetail() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));

            }

            public JutakuKaishuJizenShinseiReasonForTab() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiReasonForTab"));

            }

            public txtCreateDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));

            }

            public txtCreatorKanaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));

            }

            public txtCreatorName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtCreatorName"));

            }

            public txtCreationJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));

            }

            public txtCreationJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));

            }

            public tplJizenShinseiResult() : UZA.TabPanel {

                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiResult"));

            }

            public hl() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("hl"));

            }

            public txtJudgeDate() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtJudgeDate"));

            }

            public radJudgeKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radJudgeKubun"));

            }

            public txtShoninCondition() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtShoninCondition"));

            }

            public txtFushoninReason() : UZA.TextBoxMultiLine {

                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninReason"));

            }

            public chkResetInfo() : UZA.CheckBoxList {

                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));

            }

            public tplJizenShinseiPayMethod() : UZA.TabPanel {

                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiPayMethod"));

            }

            public btnClose() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnClose"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class JutakuKaishuJizenShinseiTab_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, JutakuKaishuJizenShinseiTab_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("");
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
   "fieldName": "JutakuKaishuJizenShinseiTab",
   "items": [
    {
     "fieldName": "tabJizenShinsei",
     "items": [
      {
       "fieldName": "tplJizenShinseiContents",
       "items": [
        {
         "fieldName": "txtJutakuOwner",
         "items": [],
         "controlType": "TextBox",
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
         "selectControlID": "txtJutakuOwner_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "required": false,
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "isComboBox": false,
         "onFocus": "",
         "onBlur": "",
         "onKeyPress": "",
         "text": "",
         "suggest": [],
         "value": "",
         "labelLText": "住宅所有者",
         "labelRText": "",
         "labelLWidth": "90",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "permitCharactor": ""
        },
        {
         "fieldName": "txtRelationWithHihokensha",
         "items": [],
         "controlType": "TextBox",
         "width": "100",
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
         "selectControlID": "txtRelationWithHihokensha_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "required": false,
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "isComboBox": false,
         "onFocus": "",
         "onBlur": "",
         "onKeyPress": "",
         "text": "",
         "suggest": [],
         "value": "",
         "labelLText": "被保険者との関係",
         "labelRText": "",
         "labelLWidth": "140",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "decorationClass": "",
         "permitCharactor": ""
        },
        {
         "fieldName": "dgJutakuKaishuJizenShinseiDetail",
         "items": [],
         "controlType": "DataGrid",
         "width": "965",
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
         "selectControlID": "dgJutakuKaishuJizenShinseiDetail",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": true,
         "height": "155",
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
          "header": {
           "combineColumns": [],
           "frozenColumn": "",
           "headerHeight": 1
          },
          "columns": [
           {
            "columnName": "着工日",
            "dataName": "txtChakkoDate",
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
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtChakkoDate"
           },
           {
            "columnName": "完成日",
            "dataName": "txtKanseiDate",
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
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtKanseiDate"
           },
           {
            "columnName": "見積金額",
            "dataName": "txtMitsumoriAmount",
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
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtMitsumoriAmount"
           },
           {
            "columnName": "事業者",
            "dataName": "txtKaishuJigyosha",
            "toolTip": "",
            "bgColor": 0,
            "width": 150,
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
            "columnName": "対象住宅住所",
            "dataName": "txtTaishoJutakuAddress",
            "toolTip": "",
            "bgColor": 0,
            "width": 240,
            "visible": true,
            "cellType": 0,
            "cellDetails": {
             "cellType": 0
            },
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtTaishoJutakuAddress"
           },
           {
            "columnName": "改修内容",
            "dataName": "txtKaishuContents",
            "toolTip": "",
            "bgColor": 0,
            "width": 290,
            "visible": true,
            "cellType": 0,
            "cellDetails": null,
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
         "dataSource": [],
         "sortOrder": "txtChakkoDate",
         "isAscending": true,
         "filterList": [],
         "activeRowId": -1
        },
        {
         "fieldName": "JutakuKaishuJizenShinseisha",
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
         "selectControlID": "JutakuKaishuJizenShinseisha",
         "helpMessageID": "",
         "jpControlName": "",
         "title": "申請者情報",
         "relation": [],
         "businessId": "DBZ",
         "controlName": "ShinseishaInfo",
         "marginTop": 0,
         "marginBottom": 0,
         "originalProperty": [],
         "dataPassingForDialog": [],
         "dialogOkEventNameForDialog": "",
         "dialogCancelEventNameForDialog": "",
         "canTransferEvent": true,
         "heightForDialog": "M",
         "panelDisplay": 1,
         "btnJigyoshaInputGuide_displayNone": false,
         "txtUkestukeDate_displayNone": true,
         "txtJigyoshaNo_disabled": true,
         "txtShinseishaName_labelLText": "氏名",
         "txtYubinNo_displayNone": false,
         "txtAddress_displayNone": false,
         "btnJigyoshaInputGuide_disabled": false
        },
        {
         "fieldName": "JutakuKaishuJizenShinseiReasonForTab",
         "items": [
          {
           "fieldName": "txtCreateDate",
           "items": [],
           "controlType": "TextBoxDate",
           "width": "85",
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
           "selectControlID": "txtCreateDate_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "onChange": "",
           "required": false,
           "placeHolder": "",
           "textKind": 0,
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onKeyPress": "",
           "text": "",
           "value": "",
           "labelLText": "作成日",
           "labelRText": "",
           "labelLWidth": "90",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "ymdKubun": 2,
           "displayFormat": 0,
           "permitCharactor": "./_-"
          },
          {
           "fieldName": "txtCreatorKanaName",
           "items": [],
           "controlType": "TextBox",
           "width": "200",
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
           "selectControlID": "txtCreatorKanaName_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "onChange": "",
           "required": false,
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "placeHolder": "",
           "textKind": 0,
           "isPrivateInfo": false,
           "isPassword": false,
           "isComboBox": false,
           "onFocus": "",
           "onBlur": "",
           "onKeyPress": "",
           "text": "",
           "suggest": [],
           "value": "",
           "labelLText": "作成者氏名",
           "labelRText": "",
           "labelLWidth": "90",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "decorationClass": "",
           "permitCharactor": ""
          },
          {
           "fieldName": "txtCreatorName",
           "items": [],
           "controlType": "TextBox",
           "width": "200",
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
           "marginLeft": "6.1",
           "marginRight": "XS",
           "selectControlID": "txtCreatorName_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "onChange": "",
           "required": false,
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "placeHolder": "",
           "textKind": 0,
           "isPrivateInfo": false,
           "isPassword": false,
           "isComboBox": false,
           "onFocus": "",
           "onBlur": "",
           "onKeyPress": "",
           "text": "",
           "suggest": [],
           "value": "",
           "labelLText": "",
           "labelRText": "",
           "labelLWidth": "S",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "decorationClass": "",
           "permitCharactor": ""
          },
          {
           "fieldName": "txtCreationJigyoshaNo",
           "items": [],
           "controlType": "TextBoxCode",
           "width": "85",
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
           "selectControlID": "txtCreationJigyoshaNo_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "onChange": "",
           "required": false,
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "placeHolder": "",
           "textKind": 2,
           "isPrivateInfo": false,
           "isPassword": false,
           "isComboBox": false,
           "onFocus": "",
           "onBlur": "",
           "onKeyPress": "",
           "text": "",
           "suggest": [],
           "value": "",
           "labelLText": "作成事業者",
           "labelRText": "",
           "labelLWidth": "90",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "decorationClass": "",
           "permitCharactor": "",
           "formatLength": "10"
          },
          {
           "fieldName": "txtCreationJigyoshaName",
           "items": [],
           "controlType": "TextBox",
           "width": "320",
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
           "marginLeft": "6.1",
           "marginRight": "XS",
           "selectControlID": "txtCreationJigyoshaName_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "onChange": "",
           "required": false,
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "placeHolder": "",
           "textKind": 0,
           "isPrivateInfo": false,
           "isPassword": false,
           "isComboBox": false,
           "onFocus": "",
           "onBlur": "",
           "onKeyPress": "",
           "text": "",
           "suggest": [],
           "value": "",
           "labelLText": "",
           "labelRText": "",
           "labelLWidth": "S",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "decorationClass": "",
           "permitCharactor": ""
          }
         ],
         "controlType": "Panel",
         "width": "440",
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
         "marginRight": "0",
         "selectControlID": "JutakuKaishuJizenShinseiReasonForTab",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "住宅改修理由書",
         "marginTop": "0",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "JutakuKaishuJizenShinseiReasonForTab"
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
         "height": "Auto",
         "focusPositionID": "restoreLayoutButton",
         "eraseBorderTop": false,
         "eraseBorderBottom": false,
         "eraseBorderRight": false,
         "eraseBorderLeft": false
        }
       ],
       "controlType": "TabPanel",
       "width": "1085",
       "visible": true,
       "displayNone": false,
       "disabled": true,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": false,
       "dependencies": [],
       "float": 0,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplJizenShinseiContents",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "事前申請内容",
       "onActive": "",
       "onFirstActive": ""
      },
      {
       "fieldName": "tplJizenShinseiResult",
       "items": [
        {
         "fieldName": "JutakuKaishuJizenShinseiKyufugakuSummary",
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
         "selectControlID": "JutakuKaishuJizenShinseiKyufugakuSummary",
         "helpMessageID": "",
         "jpControlName": "",
         "relation": [],
         "businessId": "DBC",
         "controlName": "KyufugakuSummary",
         "marginTop": "0",
         "marginBottom": 0,
         "originalProperty": [],
         "dataPassingForDialog": [],
         "dialogOkEventNameForDialog": "",
         "dialogCancelEventNameForDialog": "",
         "canTransferEvent": true,
         "heightForDialog": "M",
         "btnLimitOverCheck_displayNone": true,
         "btnRireki_displayNone": true
        },
        {
         "fieldName": "hl",
         "items": [],
         "controlType": "HorizontalLine",
         "visible": true,
         "displayNone": false,
         "disabled": false,
         "accessKey": "",
         "nextFocusFieldName": "",
         "wrap": true,
         "dependencies": [],
         "toolTip": "",
         "authorityMode": 0,
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "hl",
         "helpMessageID": "",
         "jpControlName": "",
         "size": "960"
        },
        {
         "fieldName": "txtJudgeDate",
         "items": [],
         "controlType": "TextBoxDate",
         "width": "85",
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
         "selectControlID": "txtJudgeDate_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "required": false,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "判定決定日",
         "labelRText": "",
         "labelLWidth": "S",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "ymdKubun": 2,
         "displayFormat": 0,
         "permitCharactor": "./_-"
        },
        {
         "fieldName": "radJudgeKubun",
         "items": [],
         "controlType": "RadioButton",
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
         "selectControlID": "radJudgeKubun_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "selectedItem": null,
         "required": false,
         "labelLText": "判定区分",
         "labelLWidth": "75",
         "labelLAlign": 2,
         "dataSource": [
          {
           "key": "shonin",
           "value": "承認"
          },
          {
           "key": "fushonin",
           "value": "不承認"
          }
         ],
         "onClick": "",
         "icon": [],
         "newLineItemNumber": 2,
         "spaceSize": "M",
         "disabledItem": []
        },
        {
         "fieldName": "txtShoninCondition",
         "items": [],
         "controlType": "TextBoxMultiLine",
         "width": "360",
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
         "selectControlID": "txtShoninCondition_text_area",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "XS",
         "onChange": "",
         "required": false,
         "maxLength": 100000000,
         "minLength": 0,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "onFocus": "",
         "onBlur": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "承認条件",
         "labelRText": "",
         "labelLWidth": "S",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "limitLength": "",
         "countDisp": false
        },
        {
         "fieldName": "txtFushoninReason",
         "items": [],
         "controlType": "TextBoxMultiLine",
         "width": "360",
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
         "selectControlID": "txtFushoninReason_text_area",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "XS",
         "onChange": "",
         "required": false,
         "maxLength": 100000000,
         "minLength": 0,
         "placeHolder": "",
         "textKind": 0,
         "isPrivateInfo": false,
         "onFocus": "",
         "onBlur": "",
         "onKeyPress": "",
         "text": "",
         "value": "",
         "labelLText": "不承認理由",
         "labelRText": "",
         "labelLWidth": "90",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "limitLength": "",
         "countDisp": false
        },
        {
         "fieldName": "chkResetInfo",
         "items": [],
         "controlType": "CheckBoxList",
         "width": "L",
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
         "selectControlID": "chkResetInfo_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "onChange": "",
         "selectedItem": null,
         "required": false,
         "labelLText": "限度額リセット",
         "labelLWidth": "S",
         "labelLAlign": 2,
         "dataSource": [
          {
           "key": "threeUp",
           "value": "要介護状態区分３段階変更による"
          },
          {
           "key": "changeAddress",
           "value": "住宅住所変更による"
          }
         ],
         "onClick": "",
         "icon": [],
         "newLineItemNumber": 1,
         "spaceSize": 1,
         "disabledItem": [],
         "selectedItems": [],
         "minCheckedItem": 0,
         "maxCheckedItem": 2,
         "isAllSelectable": false,
         "isAllSelectableBreakLine": false
        }
       ],
       "controlType": "TabPanel",
       "width": "1085",
       "visible": true,
       "displayNone": false,
       "disabled": true,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": false,
       "dependencies": [],
       "float": 0,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplJizenShinseiResult",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "事前申請結果",
       "onActive": "",
       "onFirstActive": ""
      },
      {
       "fieldName": "tplJizenShinseiPayMethod",
       "items": [
        {
         "fieldName": "PaymentMethod",
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
         "selectControlID": "PaymentMethod",
         "helpMessageID": "",
         "jpControlName": "",
         "title": "",
         "relation": [],
         "businessId": "DBZ",
         "controlName": "PaymentMethod",
         "marginTop": 0,
         "marginBottom": "XS",
         "originalProperty": [],
         "dataPassingForDialog": [],
         "dialogOkEventNameForDialog": "",
         "dialogCancelEventNameForDialog": "",
         "canTransferEvent": true,
         "heightForDialog": "M",
         "eraseBorder": true,
         "panelDisplay": 0,
         "KozaPayment_title": "",
         "onClick_radPayMethod": "",
         "Juryoinin_displayNone": true,
         "Madoguchi_displayNone": true,
         "Koza_displayNone": false,
         "eraseBorderTop": false,
         "eraseBorderBottom": false,
         "eraseBorderRight": false,
         "eraseBorderLeft": false
        }
       ],
       "controlType": "TabPanel",
       "width": "1085",
       "visible": true,
       "displayNone": false,
       "disabled": true,
       "accessKey": "",
       "nextFocusFieldName": "",
       "wrap": false,
       "dependencies": [],
       "float": 0,
       "toolTip": "",
       "authorityMode": 0,
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "tplJizenShinseiPayMethod",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "支払情報",
       "onActive": "",
       "onFirstActive": ""
      }
     ],
     "controlType": "TabContainer",
     "width": "1090",
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
     "selectControlID": "tabJizenShinsei",
     "helpMessageID": "",
     "jpControlName": "",
     "onChange": "",
     "selectedItem": null,
     "tabpanelPosition": [
      "tplJizenShinseiContents",
      "tplJizenShinseiResult",
      "tplJizenShinseiPayMethod"
     ],
     "isDraggable": false,
     "selectedItemFieldName": "tplJizenShinseiContents",
     "initialTab": 0,
     "isLazyLoading": false
    },
    {
     "fieldName": "btnClose",
     "items": [],
     "controlType": "Button",
     "width": "S",
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
     "selectControlID": "btnClose",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "閉じる",
     "onClick": "onClick_btnClose",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    }
   ],
   "controlType": "Panel",
   "width": "G12",
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
   "selectControlID": "JutakuKaishuJizenShinseiTab",
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
     "postParameterPanelNames": "JutakuKaishuJizenShinseiTab"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbc/db/dbc/JutakuKaishuJizenShinseiTab/onLoad"
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
   "height": "435",
   "focusPositionID": "restoreLayoutButton",
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false
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
 "businessId": "DBC",
 "controlName": "JutakuKaishuJizenShinseiTab",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "",
   "publicChildProperty": "",
   "newPropertyName": ""
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "onClick_btnClose",
 "canTransferEvent": true,
 "heightForDialog": "485"
}        
    }
}

