/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * DankaibetsuShinseiListクラスのみで継承して使えます。
     */
    export class DankaibetsuShinseiList_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, DankaibetsuShinseiList_Design.myLayout, fieldName);
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
   "fieldName": "DankaibetsuShinseiList",
   "items": [
    {
     "fieldName": "btnToSearch",
     "items": [],
     "controlType": "Button",
     "width": "100px",
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
     "selectControlID": "btnToSearch",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "onClick_btnToSearch",
     "text": "検索する",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "txtKanryo",
     "items": [],
     "controlType": "TextBox",
     "width": "70px",
     "visible": true,
     "displayNone": false,
     "disabled": true,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "10px",
     "selectControlID": "txtKanryo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
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
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "完了",
     "labelRText": "",
     "labelLWidth": "40px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "txtGokei",
     "items": [],
     "controlType": "TextBox",
     "width": "70px",
     "visible": true,
     "displayNone": false,
     "disabled": true,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 2,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtGokei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "text": "",
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
     "onChange": "",
     "onKeyPress": "",
     "suggest": [],
     "value": "",
     "labelLText": "合計",
     "labelRText": "",
     "labelLWidth": "40px",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": ""
    },
    {
     "fieldName": "btnNarabikae",
     "items": [],
     "controlType": "ButtonDialog",
     "width": "100px",
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
     "selectControlID": "btnNarabikae",
     "helpMessageID": "",
     "jpControlName": "",
     "onBeforeClick": "",
     "onAfterClick": "",
     "onClick": "",
     "text": "並び替える",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false,
     "displayChildDivName": "DBE.Narabikae",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "dgTaishoIchiran",
     "items": [],
     "controlType": "DataGrid",
     "width": "1095px",
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
     "selectControlID": "dgTaishoIchiran",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": false,
     "height": "525px",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": true,
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
      "selectLimitRowCount": 0,
      "header": {
       "combineColumns": [
        {
         "combineColumnName": "調査票",
         "combineItem": [
          "chosaIraiKanryoYmd",
          "chosahyoNyushuKanryoYmd",
          "chosaWaritsukeYmd",
          "chosaIraishoHakkoYmd",
          "dataOutputYmd",
          "chosaKigenYmd",
          "chosaIraiKubun",
          "chosaDataInputYmd",
          "chosaChiku"
         ]
        },
        {
         "combineColumnName": "今回調査",
         "combineItem": [
          "konkaiChosaItakusaki",
          "konkaiChosain"
         ]
        },
        {
         "combineColumnName": "前回調査",
         "combineItem": [
          "zenkaiChosaItakusaki",
          "zenkaiChosain"
         ]
        },
        {
         "combineColumnName": "前々回調査",
         "combineItem": [
          "zenzenkaiChosaItakusaki",
          "zenzenkaiChosain"
         ]
        },
        {
         "combineColumnName": "意見書",
         "combineItem": [
          "ikenshoIraiKanryoYmd",
          "ikenshoNyushuKanryoYmd",
          "ikenSaiIrai",
          "ikenIraiYmd",
          "ikenshoIraishoHakkoYmd",
          "ikenshoOutYmd",
          "ikenshoIraiTorokuYmd",
          "ikenshoIraiKigenYmd",
          "ikenshoIraiKaisu",
          "ikenshoTeikei",
          "ikenshoTeikeigai",
          "gokomokuNyuryoku"
         ]
        },
        {
         "combineColumnName": "今回",
         "combineItem": [
          "konkaiIryoKikan",
          "konkaiShujii"
         ]
        },
        {
         "combineColumnName": "前回",
         "combineItem": [
          "zenkaiIryoKikan",
          "zenkaiShujii"
         ]
        },
        {
         "combineColumnName": "督促",
         "combineItem": [
          "chosahyoTokusokuHakkoYmd",
          "chosahyoTokusokuPattern",
          "chosahyoTokusokuKaisu",
          "chosahyoTokusokuKigenYmd",
          "ikenshoTokusokuHakkoYmd",
          "ikenshoTokusokuPattern",
          "ikenshoTokusokuKaisu",
          "ikenshoTokusokuKigenYmd"
         ]
        },
        {
         "combineColumnName": "一次判定",
         "combineItem": [
          "ichijiHanteiKanryoYmd",
          "saiChosa",
          "saiIken",
          "chosaIchiji",
          "ikenIchiji",
          "ichijiHanteiKekka",
          "keikokuCode"
         ]
        },
        {
         "combineColumnName": "審査会",
         "combineItem": [
          "shinsakaiTorokuKanryoYmd",
          "saiShinsa",
          "shinsakaiWaritsukeYmd",
          "shinsakaiKaisaiYmd",
          "kaisaiJikan",
          "yusenWaritsukesha",
          "shinsakaiNo",
          "gogitai"
         ]
        }
       ],
       "frozenColumn": "shimei",
       "headerHeight": 1
      },
      "columns": [
       {
        "columnName": "保険者",
        "dataName": "hokensha",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "hokensha"
       },
       {
        "columnName": "被保番号",
        "dataName": "hihoNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "hihoNo"
       },
       {
        "columnName": "申請日",
        "dataName": "shinseiYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "shinseiYmd"
       },
       {
        "columnName": "氏名",
        "dataName": "shimei",
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
        "sortKey": "shimei"
       },
       {
        "columnName": "申請区分",
        "dataName": "shinseiKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shinseiKubun"
       },
       {
        "columnName": "完了日",
        "dataName": "chosaIraiKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaIraiKanryoYmd"
       },
       {
        "columnName": "完了日",
        "dataName": "chosahyoNyushuKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosahyoNyushuKanryoYmd"
       },
       {
        "columnName": "調査<br>割付日",
        "dataName": "chosaWaritsukeYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaWaritsukeYmd"
       },
       {
        "columnName": "依頼書<br>発行日",
        "dataName": "chosaIraishoHakkoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaIraishoHakkoYmd"
       },
       {
        "columnName": "データ<br>出力日",
        "dataName": "dataOutputYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "dataOutputYmd"
       },
       {
        "columnName": "調査<br>期限",
        "dataName": "chosaKigenYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaKigenYmd"
       },
       {
        "columnName": "調査依頼<br>区分",
        "dataName": "chosaIraiKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosaIraiKubun"
       },
       {
        "columnName": "調査データ<br>入力",
        "dataName": "chosaDataInputYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaDataInputYmd"
       },
       {
        "columnName": "調査地区",
        "dataName": "chosaChiku",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosaChiku"
       },
       {
        "columnName": "調査委託先",
        "dataName": "konkaiChosaItakusaki",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "konkaiChosaItakusaki"
       },
       {
        "columnName": "調査員",
        "dataName": "konkaiChosain",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "konkaiChosain"
       },
       {
        "columnName": "調査委託先",
        "dataName": "zenkaiChosaItakusaki",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenkaiChosaItakusaki"
       },
       {
        "columnName": "調査員",
        "dataName": "zenkaiChosain",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenkaiChosain"
       },
       {
        "columnName": "調査委託先",
        "dataName": "zenzenkaiChosaItakusaki",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenzenkaiChosaItakusaki"
       },
       {
        "columnName": "調査員",
        "dataName": "zenzenkaiChosain",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenzenkaiChosain"
       },
       {
        "columnName": "郵便番号",
        "dataName": "chosaItakusakiYubinNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosaItakusakiYubinNo"
       },
       {
        "columnName": "住所",
        "dataName": "chosaItakusakiJusho",
        "toolTip": "",
        "bgColor": 0,
        "width": 300,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosaItakusakiJusho"
       },
       {
        "columnName": "完了日",
        "dataName": "ikenshoIraiKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoIraiKanryoYmd"
       },
       {
        "columnName": "完了日",
        "dataName": "ikenshoNyushuKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoNyushuKanryoYmd"
       },
       {
        "columnName": "意見<br>（再）",
        "dataName": "ikenSaiIrai",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenSaiIrai"
       },
       {
        "columnName": "依頼日",
        "dataName": "ikenIraiYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenIraiYmd"
       },
       {
        "columnName": "依頼書<br>発行日",
        "dataName": "ikenshoIraishoHakkoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoIraishoHakkoYmd"
       },
       {
        "columnName": "意見書<br>出力日",
        "dataName": "ikenshoOutYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoOutYmd"
       },
       {
        "columnName": "依頼<br>登録日",
        "dataName": "ikenshoIraiTorokuYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoIraiTorokuYmd"
       },
       {
        "columnName": "依頼<br>期限",
        "dataName": "ikenshoIraiKigenYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoIraiKigenYmd"
       },
       {
        "columnName": "依頼<br>回数",
        "dataName": "ikenshoIraiKaisu",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenshoIraiKaisu"
       },
       {
        "columnName": "意見書<br>(定型)",
        "dataName": "ikenshoTeikei",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenshoTeikei"
       },
       {
        "columnName": "意見書<br>(定型外)",
        "dataName": "ikenshoTeikeigai",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenshoTeikeigai"
       },
       {
        "columnName": "5項目<br>入力",
        "dataName": "gokomokuNyuryoku",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "gokomokuNyuryoku"
       },
       {
        "columnName": "医療機関",
        "dataName": "konkaiIryoKikan",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "konkaiIryoKikan"
       },
       {
        "columnName": "主治医",
        "dataName": "konkaiShujii",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "konkaiShujii"
       },
       {
        "columnName": "医療機関",
        "dataName": "zenkaiIryoKikan",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenkaiIryoKikan"
       },
       {
        "columnName": "主治医",
        "dataName": "zenkaiShujii",
        "toolTip": "",
        "bgColor": 0,
        "width": 200,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "zenkaiShujii"
       },
       {
        "columnName": "郵便番号",
        "dataName": "iryokikanYubinNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "iryokikanYubinNo"
       },
       {
        "columnName": "住所",
        "dataName": "iryokikanJusho",
        "toolTip": "",
        "bgColor": 0,
        "width": 300,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "iryokikanJusho"
       },
       {
        "columnName": "入所施設",
        "dataName": "nyushoShisetsu",
        "toolTip": "",
        "bgColor": 0,
        "width": 250,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "nyushoShisetsu"
       },
       {
        "columnName": "発行日",
        "dataName": "chosahyoTokusokuHakkoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosahyoTokusokuHakkoYmd"
       },
       {
        "columnName": "方法",
        "dataName": "chosahyoTokusokuPattern",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosahyoTokusokuPattern"
       },
       {
        "columnName": "回数",
        "dataName": "chosahyoTokusokuKaisu",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "chosahyoTokusokuKaisu"
       },
       {
        "columnName": "期限",
        "dataName": "chosahyoTokusokuKigenYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosahyoTokusokuKigenYmd"
       },
       {
        "columnName": "発行日",
        "dataName": "ikenshoTokusokuHakkoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoTokusokuHakkoYmd"
       },
       {
        "columnName": "方法",
        "dataName": "ikenshoTokusokuPattern",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenshoTokusokuPattern"
       },
       {
        "columnName": "回数",
        "dataName": "ikenshoTokusokuKaisu",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ikenshoTokusokuKaisu"
       },
       {
        "columnName": "期限",
        "dataName": "ikenshoTokusokuKigenYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenshoTokusokuKigenYmd"
       },
       {
        "columnName": "完了日",
        "dataName": "ichijiHanteiKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ichijiHanteiKanryoYmd"
       },
       {
        "columnName": "再調査",
        "dataName": "saiChosa",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "saiChosa"
       },
       {
        "columnName": "再意見",
        "dataName": "saiIken",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "saiIken"
       },
       {
        "columnName": "調査一次",
        "dataName": "chosaIchiji",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "chosaIchiji"
       },
       {
        "columnName": "意見一次",
        "dataName": "ikenIchiji",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "ikenIchiji"
       },
       {
        "columnName": "一次判定<br>結果",
        "dataName": "ichijiHanteiKekka",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "ichijiHanteiKekka"
       },
       {
        "columnName": "警告<br>コード",
        "dataName": "keikokuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "keikokuCode"
       },
       {
        "columnName": "完了日",
        "dataName": "shinsakaiTorokuKanryoYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "shinsakaiTorokuKanryoYmd"
       },
       {
        "columnName": "再審査",
        "dataName": "saiShinsa",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "saiShinsa"
       },
       {
        "columnName": "審査会<br>割付日",
        "dataName": "shinsakaiWaritsukeYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "shinsakaiWaritsukeYmd"
       },
       {
        "columnName": "審査会<br>開催日",
        "dataName": "shinsakaiKaisaiYmd",
        "toolTip": "",
        "bgColor": 0,
        "width": 85,
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
        "sortKey": "shinsakaiKaisaiYmd"
       },
       {
        "columnName": "開催時間",
        "dataName": "kaisaiJikan",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "kaisaiJikan"
       },
       {
        "columnName": "優先<br>割付者",
        "dataName": "yusenWaritsukesha",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "yusenWaritsukesha"
       },
       {
        "columnName": "審査会<br>番号",
        "dataName": "shinsakaiNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 80,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shinsakaiNo"
       },
       {
        "columnName": "合議体",
        "dataName": "gogitai",
        "toolTip": "",
        "bgColor": 0,
        "width": 150,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "gogitai"
       },
       {
        "columnName": "申請から",
        "dataName": "shinseiKeikaNissu",
        "toolTip": "",
        "bgColor": 0,
        "width": 100,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "shinseiKeikaNissu"
       },
       {
        "columnName": "取下げ区分",
        "dataName": "torisageKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "torisageKubun"
       },
       {
        "columnName": "通知区分",
        "dataName": "tsuchiKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 120,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "tsuchiKubun"
       },
       {
        "columnName": "申請書管理番号",
        "dataName": "shinseishoKanriNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "shinseishoKanriNo"
       },
       {
        "columnName": "厚労省ＩＦ識別コード",
        "dataName": "koroshoIfShikibetsuCode",
        "toolTip": "",
        "bgColor": 0,
        "width": 0,
        "visible": false,
        "cellType": 0,
        "cellDetails": null,
        "align": 0,
        "resize": false,
        "isPrivateInfo": false,
        "sortKey": "koroshoIfShikibetsuCode"
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
     "sortOrder": "shinseiYmd",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1,
     "gridAction": []
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
   "marginLeft": "0px",
   "marginRight": "0px",
   "selectControlID": "DankaibetsuShinseiList",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": false,
   "postParameterPanelNames": [],
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
   "height": "530px",
   "canPost": false
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
 "marginLeft": "0px",
 "marginRight": "0px",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "packageName": "",
 "businessId": "DBE",
 "controlName": "DankaibetsuShinseiList",
 "marginTop": "0px",
 "marginBottom": "0px",
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "",
 "canTransferEvent": true,
 "heightForDialog": "M",
 "firstFocusFieldName": "",
 "lastFocusFieldName": "",
 "modes": [],
 "publicEvents": [],
 "publicEventsAlias": []
}        
    }

     export module DankaibetsuShinseiList {

        export class Events {

            public static onClick_btnToSearch(): string {
                return "onClick_btnToSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "DankaibetsuShinseiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType() + "_" + fieldName;
            }

            public DankaibetsuShinseiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnToSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            }

            public txtKanryo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKanryo"));
            }

            public txtGokei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGokei"));
            }

            public btnNarabikae(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNarabikae"));
            }

            public dgTaishoIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTaishoIchiran"));
            }

        }

     }

}

