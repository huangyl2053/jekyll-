/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module JukyushaIdoRenrakuhyo {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "JukyushaIdoRenrakuhyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public JukyushaIdoRenrakuhyo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public JukyushaIdoRenrakuhyoKihonJoho() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKihonJoho"));

            }

            public txtRenrakuhyoIdoDate() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoIdoDate"));

            }

            public radRenrakuhyoIdoKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radRenrakuhyoIdoKubun"));

            }

            public ddlIdoJiyu() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlIdoJiyu"));

            }

            public Button1() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button1"));

            }

            public txtRenrakuhyoHihoNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtRenrakuhyoHihoNo"));

            }

            public txtRenrakuhyoHihoName() : UZA.TextBoxKana {

                return new UZA.TextBoxKana(this.convFiledName("txtRenrakuhyoHihoName"));

            }

            public txtHihoBirthday() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHihoBirthday"));

            }

            public radHihoSex() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radHihoSex"));

            }

            public txtShikakuShutokuDate() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuShutokuDate"));

            }

            public txtShikakuSoshitsuDate() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuSoshitsuDate"));

            }

            public txtShokisaiHokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));

            }

            public txtKoikiHokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKoikiHokenshaNo"));

            }

            public txtRenrakuhyoSendYM() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoSendYM"));

            }

            public JukyushaIdoRenrakuhyoTeisei() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTeisei"));

            }

            public HorizontalLine1() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine1"));

            }

            public TextBoxDate1() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate1"));

            }

            public RadioButton1() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("RadioButton1"));

            }

            public HorizontalLine2() : UZA.HorizontalLine {

                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine2"));

            }

            public JukyushaIdoRenrakuhyoYokaigonintei() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoYokaigonintei"));

            }

            public txtShinseiDate() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));

            }

            public radShinseiType() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radShinseiType"));

            }

            public Button3() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button3"));

            }

            public ddlYokaigoJotaiKubun() : UZA.DropDownList {

                return new UZA.DropDownList(this.convFiledName("ddlYokaigoJotaiKubun"));

            }

            public radHenkoShinseichuKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radHenkoShinseichuKubun"));

            }

            public txtNinteiDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiDateRange"));

            }

            public radMinashiYokaigoKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radMinashiYokaigoKubun"));

            }

            public JukyushaIdoRenrakuhyoShikyugendoKijungaku() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoShikyugendoKijungaku"));

            }

            public lblKyuHomonTsusho() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKyuHomonTsusho"));

            }

            public txtKyuHomonTsushoShikyuGendoKijungaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKyuHomonTsushoShikyuGendoKijungaku"));

            }

            public txtKyuHomonTsushoKanriTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuHomonTsushoKanriTekiyoDateRange"));

            }

            public lblKyuTankiNyusho() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKyuTankiNyusho"));

            }

            public txtKyuTankiNyushoShikyuGendoKijungaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKyuTankiNyushoShikyuGendoKijungaku"));

            }

            public txtKyuTankiNyushoKanriTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuTankiNyushoKanriTekiyoDateRange"));

            }

            public JukyushaIdoRenrakuhyoKyotakuServicePlan() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyotakuServicePlan"));

            }

            public radPlanSakuseiKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radPlanSakuseiKubun"));

            }

            public Button4() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button4"));

            }

            public txtShienJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));

            }

            public txtShienJigyoshaName() : UZA.TextBoxKana {

                return new UZA.TextBoxKana(this.convFiledName("txtShienJigyoshaName"));

            }

            public txtKyotakuServicePlanTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtKyotakuServicePlanTekiyoDateRange"));

            }

            public radShokiboKyotakuServiceRiyoUmu() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radShokiboKyotakuServiceRiyoUmu"));

            }

            public JukyushaIdoRenrakuhyoGemmenGengaku() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengaku"));

            }

            public radGemmenShinseichuKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radGemmenShinseichuKubun"));

            }

            public Button5() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button5"));

            }

            public JukyushaIdoRenrakuhyoGemmenGengakuSub() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengakuSub"));

            }

            public JukyushaIdoRenrakuhyoRiyoshaFutan() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRiyoshaFutan"));

            }

            public radRiyoshaFutanKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutanKubun"));

            }

            public txtRiyoshaFutanKyufuritsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanKyufuritsu"));

            }

            public txtRiyoshaFutanTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyoshaFutanTekiyoDateRange"));

            }

            public JukyushaIdoRenrakuhyoFukushiHojinKeigen() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoFukushiHojinKeigen"));

            }

            public txtKeigenritsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKeigenritsu"));

            }

            public txtKeigenritsuTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtKeigenritsuTekiyoDateRange"));

            }

            public JukyushaIdoRenrakuhyoHyojunFutan() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoHyojunFutan"));

            }

            public radHyojunFutanKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radHyojunFutanKubun"));

            }

            public txtHyojunFutangaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHyojunFutangaku"));

            }

            public txtHyojunFutanTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtHyojunFutanTekiyoDateRange"));

            }

            public JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"));

            }

            public radNinteiShinseichuKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radNinteiShinseichuKubun"));

            }

            public radServiceKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));

            }

            public radTokureiKeigenSochiTaisho() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radTokureiKeigenSochiTaisho"));

            }

            public txtShokuhiFutanGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtShokuhiFutanGendogaku"));

            }

            public txtFutanGendogakuTekiyoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtFutanGendogakuTekiyoDateRange"));

            }

            public lblKyojuhiFutanGendogaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKyojuhiFutanGendogaku"));

            }

            public txtUnitKoshitsuGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtUnitKoshitsuGendogaku"));

            }

            public txtUnitJunKoshitsuFutanGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtUnitJunKoshitsuFutanGendogaku"));

            }

            public txtJuraigataKoshitsuTokuyoFutanGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuTokuyoFutanGendogaku"));

            }

            public txtJuraigataKoshitsuRokenRyoyoFutanGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku"));

            }

            public txtTashoshitsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTashoshitsu"));

            }

            public JukyushaIdoRenrakuhyoKokiKoreiKokuho() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKoreiKokuho"));

            }

            public JukyushaIdoRenrakuhyoKokiKorei() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKorei"));

            }

            public txtKokiKoreiHokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHokenshaNo"));

            }

            public txtKokiKoreiHihokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHihokenshaNo"));

            }

            public JukyushaIdoRenrakuhyoKokuho() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokuho"));

            }

            public txtKokuhoHokenshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHokenshaNo"));

            }

            public txtKokuhoHihokenshashoNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHihokenshashoNo"));

            }

            public txtKokuhoKojinNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoKojinNo"));

            }

            public JukyushaIdoRenrakuhyoKyufuSeigen() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyufuSeigen"));

            }

            public radKohiFutanJogengakuGengakuUmu() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radKohiFutanJogengakuGengakuUmu"));

            }

            public Button6() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button6"));

            }

            public txtKyufuritsuHikisageDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuritsuHikisageDateRange"));

            }

            public txtShokanBaraikaDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtShokanBaraikaDateRange"));

            }

            public JukyushaIdoRenrakuhyoNijiyoboJigyo() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoNijiyoboJigyo"));

            }

            public radNijiyoboJigyoKubun() : UZA.RadioButton {

                return new UZA.RadioButton(this.convFiledName("radNijiyoboJigyoKubun"));

            }

            public txtNijiyoboJigyoYukoDateRange() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiyoboJigyoYukoDateRange"));

            }

            public Button7() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button7"));

            }

            public JukyushaIdoRenrakuhyoRojinHoken() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRojinHoken"));

            }

            public RokenShichosonNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("RokenShichosonNo"));

            }

            public RokenJukyushaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("RokenJukyushaNo"));

            }

            public RokenKohiFutanshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("RokenKohiFutanshaNo"));

            }

            public Button8() : UZA.Button {

                return new UZA.Button(this.convFiledName("Button8"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class JukyushaIdoRenrakuhyo_Design extends Uz.CommonChildDiv {
    
        public get TeiseiInfoVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["visible"];
        }
        
        public set TeiseiInfoVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[1]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get TeiseiInfoDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
        }
        
        public set TeiseiInfoDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[1]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, JukyushaIdoRenrakuhyo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("TeiseiInfoVisible");
            Uz.JSControlUtil.registProperty("TeiseiInfoDisplayNone");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["TeiseiInfoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TeiseiInfoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "JukyushaIdoRenrakuhyo",
   "items": [
    {
     "fieldName": "JukyushaIdoRenrakuhyoKihonJoho",
     "items": [
      {
       "fieldName": "txtRenrakuhyoIdoDate",
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
       "selectControlID": "txtRenrakuhyoIdoDate_core",
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
       "labelLText": "異動日",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "radRenrakuhyoIdoKubun",
       "items": [],
       "controlType": "RadioButton",
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
       "selectControlID": "radRenrakuhyoIdoKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "異動区分",
       "labelLWidth": "70",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "new",
         "value": "新規"
        },
        {
         "key": "change",
         "value": "変更"
        },
        {
         "key": "end",
         "value": "終了"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 3,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "ddlIdoJiyu",
       "items": [],
       "controlType": "DropDownList",
       "width": "325",
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
       "selectControlID": "ddlIdoJiyu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "text": "",
       "labelLText": "異動事由",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "space",
       "dataSource": [
        {
         "key": "space",
         "value": ""
        },
        {
         "key": "shutoku",
         "value": "受給資格取得"
        },
        {
         "key": "soshitsu",
         "value": "受給資格喪失"
        },
        {
         "key": "koikinaiIdo",
         "value": "広域連合市町村間異動（政令市区間異動）"
        },
        {
         "key": "shinki",
         "value": "合併による新規"
        },
        {
         "key": "sonotaIdo",
         "value": "その他異動"
        }
       ],
       "disabledItem": []
      },
      {
       "fieldName": "Button1",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button1",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "資格履歴を表示する",
       "onClick": "",
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
       "fieldName": "txtRenrakuhyoHihoNo",
       "items": [],
       "controlType": "TextBoxCode",
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
       "selectControlID": "txtRenrakuhyoHihoNo_core",
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
       "labelLText": "被保番号",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtRenrakuhyoHihoName",
       "items": [],
       "controlType": "TextBoxKana",
       "width": "280",
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
       "selectControlID": "txtRenrakuhyoHihoName_core",
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
       "labelLText": "カナ氏名",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "kanjiInField": "TextBox1",
       "kanaType": 0
      },
      {
       "fieldName": "txtHihoBirthday",
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
       "selectControlID": "txtHihoBirthday_core",
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
       "labelLText": "生年月日",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "radHihoSex",
       "items": [],
       "controlType": "RadioButton",
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
       "selectControlID": "radHihoSex_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "性別",
       "labelLWidth": "40",
       "labelLAlign": 2,
       "selectedItem": null,
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
       "newLineItemNumber": 2,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "txtShikakuShutokuDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
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
       "selectControlID": "txtShikakuShutokuDate_core",
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
       "labelLText": "資格取得日",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtShikakuSoshitsuDate",
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
       "selectControlID": "txtShikakuSoshitsuDate_core",
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
       "labelLText": "資格喪失日",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "txtShokisaiHokenshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "50",
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
       "selectControlID": "txtShokisaiHokenshaNo_core",
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
       "labelLText": "証記載保険者番号",
       "labelRText": "",
       "labelLWidth": "135",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "6"
      },
      {
       "fieldName": "txtKoikiHokenshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "50",
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
       "selectControlID": "txtKoikiHokenshaNo_core",
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
       "labelLText": "広域保険者番号",
       "labelRText": "",
       "labelLWidth": "120",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "6"
      },
      {
       "fieldName": "txtRenrakuhyoSendYM",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
       "width": "60",
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
       "selectControlID": "txtRenrakuhyoSendYM_core",
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
       "labelLText": "送付年月",
       "labelRText": "",
       "labelLWidth": "70",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 1,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoKihonJoho",
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
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoKihonJoho"
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
     "height": "Auto",
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoTeisei",
     "items": [
      {
       "fieldName": "HorizontalLine1",
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
       "selectControlID": "HorizontalLine1",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      },
      {
       "fieldName": "TextBoxDate1",
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
       "selectControlID": "TextBoxDate1_core",
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
       "labelLText": "訂正日",
       "labelRText": "",
       "labelLWidth": "92",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "RadioButton1",
       "items": [],
       "controlType": "RadioButton",
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
       "selectControlID": "RadioButton1_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "onChange": "",
       "labelLText": "訂正区分",
       "labelLWidth": "70",
       "labelLAlign": 2,
       "selectedItem": "",
       "dataSource": [
        {
         "key": "key0",
         "value": "修正"
        },
        {
         "key": "key1",
         "value": "削除"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 2,
       "spaceSize": "S",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "HorizontalLine2",
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
       "selectControlID": "HorizontalLine2",
       "helpMessageID": "",
       "jpControlName": "",
       "size": "Default"
      }
     ],
     "controlType": "Panel",
     "width": "1105",
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
     "selectControlID": "JukyushaIdoRenrakuhyoTeisei",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
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
     "height": "Auto",
     "focusPositionID": "defaultLayout",
     "canPost": false
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoYokaigonintei",
     "items": [
      {
       "fieldName": "txtShinseiDate",
       "items": [],
       "controlType": "TextBoxFlexibleDate",
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
       "selectControlID": "txtShinseiDate_core",
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
       "labelLText": "申請日 ",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "value": "",
       "maxLength": 1000000000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "permitCharactor": "./_-"
      },
      {
       "fieldName": "radShinseiType",
       "items": [],
       "controlType": "RadioButton",
       "width": "350",
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
       "selectControlID": "radShinseiType_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "申請種別",
       "labelLWidth": "260",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "nashi",
         "value": "未選択"
        },
        {
         "key": "new",
         "value": "新規"
        },
        {
         "key": "update",
         "value": "更新"
        },
        {
         "key": "change",
         "value": "変更"
        },
        {
         "key": "shokken",
         "value": "職権"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 5,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "Button3",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button3",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
       "fieldName": "ddlYokaigoJotaiKubun",
       "items": [],
       "controlType": "DropDownList",
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
       "selectControlID": "ddlYokaigoJotaiKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "text": "",
       "labelLText": "状態区分",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "space",
       "dataSource": [
        {
         "key": "space",
         "value": ""
        },
        {
         "key": "higaito ",
         "value": "非該当"
        },
        {
         "key": "yoshienKeikatekiYokaigo",
         "value": "要支援（経過的要介護）"
        },
        {
         "key": "yoshien1",
         "value": "要支援1"
        },
        {
         "key": "yoshien2",
         "value": "要支援2"
        },
        {
         "key": "yokaigo1",
         "value": "要介護1"
        },
        {
         "key": "yokaigo2",
         "value": "要介護2"
        },
        {
         "key": "yokaigo3",
         "value": "要介護3"
        },
        {
         "key": "yokaigo4",
         "value": "要介護4"
        },
        {
         "key": "yokaigo5",
         "value": "要介護5"
        }
       ],
       "disabledItem": []
      },
      {
       "fieldName": "radHenkoShinseichuKubun",
       "items": [],
       "controlType": "RadioButton",
       "width": "330",
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
       "selectControlID": "radHenkoShinseichuKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "変更申請中区分",
       "labelLWidth": "144",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "nashi",
         "value": "未選択"
        },
        {
         "key": "shinseiNashi",
         "value": "申請無"
        },
        {
         "key": "shinseiTyu",
         "value": "申請中"
        },
        {
         "key": "ketteiZumi",
         "value": "決定済"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 4,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "txtNinteiDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtNinteiDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "認定期間",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtNinteiDateRangeFrom",
       "toSelectControlID": "txtNinteiDateRangeTo"
      },
      {
       "fieldName": "radMinashiYokaigoKubun",
       "items": [],
       "controlType": "RadioButton",
       "width": "460",
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
       "selectControlID": "radMinashiYokaigoKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "みなし区分",
       "labelLWidth": "110",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "nashi",
         "value": "未選択"
        },
        {
         "key": "normal",
         "value": "通常認定"
        },
        {
         "key": "minashi",
         "value": "みなし認定"
        },
        {
         "key": "yamuwoenai",
         "value": "やむを得ない事由"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 4,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoYokaigonintei",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "要介護認定",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoYokaigonintei"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoShikyugendoKijungaku",
     "items": [
      {
       "fieldName": "lblKyuHomonTsusho",
       "items": [],
       "controlType": "Label",
       "width": "105",
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
       "selectControlID": "lblKyuHomonTsusho",
       "helpMessageID": "",
       "jpControlName": "",
       "required": false,
       "isPrivateInfo": false,
       "text": "(旧訪問通所)",
       "decorationClass": "",
       "align": 2
      },
      {
       "fieldName": "txtKyuHomonTsushoShikyuGendoKijungaku",
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
       "marginLeft": "0",
       "marginRight": "XS",
       "selectControlID": "txtKyuHomonTsushoShikyuGendoKijungaku_core",
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
       "labelLText": "基準額",
       "labelRText": "",
       "labelLWidth": "55",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "+-,.",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": true,
       "decimalPointLength": 0
      },
      {
       "fieldName": "txtKyuHomonTsushoKanriTekiyoDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtKyuHomonTsushoKanriTekiyoDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "管理適用期間",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtKyuHomonTsushoKanriTekiyoDateRangeFrom",
       "toSelectControlID": "txtKyuHomonTsushoKanriTekiyoDateRangeTo"
      },
      {
       "fieldName": "lblKyuTankiNyusho",
       "items": [],
       "controlType": "Label",
       "width": "105",
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
       "selectControlID": "lblKyuTankiNyusho",
       "helpMessageID": "",
       "jpControlName": "",
       "required": false,
       "isPrivateInfo": false,
       "text": "(旧短期入所)",
       "decorationClass": "",
       "align": 2
      },
      {
       "fieldName": "txtKyuTankiNyushoShikyuGendoKijungaku",
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
       "marginLeft": "0",
       "marginRight": "XS",
       "selectControlID": "txtKyuTankiNyushoShikyuGendoKijungaku_core",
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
       "labelLText": "基準額",
       "labelRText": "",
       "labelLWidth": "55",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 2,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "+-,.",
       "maxValue": 1.7976931348623157e+308,
       "minValue": 0,
       "isCurrency": false,
       "isComma": true,
       "decimalPointLength": 0
      },
      {
       "fieldName": "txtKyuTankiNyushoKanriTekiyoDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtKyuTankiNyushoKanriTekiyoDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "管理適用期間",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtKyuTankiNyushoKanriTekiyoDateRangeFrom",
       "toSelectControlID": "txtKyuTankiNyushoKanriTekiyoDateRangeTo"
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoShikyugendoKijungaku",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "支給限度基準額",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoShikyugendoKijungaku"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoKyotakuServicePlan",
     "items": [
      {
       "fieldName": "radPlanSakuseiKubun",
       "items": [],
       "controlType": "RadioButton",
       "width": "600",
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
       "selectControlID": "radPlanSakuseiKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "計画作成区分",
       "labelLWidth": "105",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "selectNot",
         "value": "未選択"
        },
        {
         "key": "kyotakuShienJigyosha",
         "value": "居宅介護支援事業所作成"
        },
        {
         "key": "myself",
         "value": "自己作成"
        },
        {
         "key": "kaigoyoboJigyosha",
         "value": "介護予防支援事業所作成"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 4,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "Button4",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button4",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
       "fieldName": "txtShienJigyoshaNo",
       "items": [],
       "controlType": "TextBoxCode",
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
       "selectControlID": "txtShienJigyoshaNo_core",
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
       "labelLText": "支援事業者",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "10"
      },
      {
       "fieldName": "txtShienJigyoshaName",
       "items": [],
       "controlType": "TextBoxKana",
       "width": "400",
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
       "marginLeft": "-0.2",
       "marginRight": "XS",
       "selectControlID": "txtShienJigyoshaName_core",
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
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 0,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "kanjiInField": "TextBox1",
       "kanaType": 0
      },
      {
       "fieldName": "txtKyotakuServicePlanTekiyoDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtKyotakuServicePlanTekiyoDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "適用期間",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtKyotakuServicePlanTekiyoDateRangeFrom",
       "toSelectControlID": "txtKyotakuServicePlanTekiyoDateRangeTo"
      },
      {
       "fieldName": "radShokiboKyotakuServiceRiyoUmu",
       "items": [],
       "controlType": "RadioButton",
       "width": "210",
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
       "selectControlID": "radShokiboKyotakuServiceRiyoUmu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "小規模居宅サービス利用",
       "labelLWidth": "185",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "selectNot",
         "value": "未選択"
        },
        {
         "key": "nashi",
         "value": "なし"
        },
        {
         "key": "ari",
         "value": "あり"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 3,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoKyotakuServicePlan",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "居宅サービス計画",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoKyotakuServicePlan"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoGemmenGengaku",
     "items": [
      {
       "fieldName": "radGemmenShinseichuKubun",
       "items": [],
       "controlType": "RadioButton",
       "width": "330",
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
       "selectControlID": "radGemmenShinseichuKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "減免申請中区分",
       "labelLWidth": "120",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "nashi",
         "value": "未選択"
        },
        {
         "key": "shinseiNashi",
         "value": "申請無"
        },
        {
         "key": "shinseiTyu",
         "value": "申請中"
        },
        {
         "key": "ketteiZumi",
         "value": "決定済"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 4,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "Button5",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button5",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
       "fieldName": "JukyushaIdoRenrakuhyoGemmenGengakuSub",
       "items": [
        {
         "fieldName": "JukyushaIdoRenrakuhyoRiyoshaFutan",
         "items": [
          {
           "fieldName": "radRiyoshaFutanKubun",
           "items": [],
           "controlType": "RadioButton",
           "width": "310",
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
           "selectControlID": "radRiyoshaFutanKubun_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "required": false,
           "onChange": "",
           "labelLText": "区分",
           "labelLWidth": "55",
           "labelLAlign": 2,
           "selectedItem": null,
           "dataSource": [
            {
             "key": "nashi",
             "value": "未選択"
            },
            {
             "key": "standard",
             "value": "標準負担"
            },
            {
             "key": "tokuteiStandard",
             "value": "特定標準負担"
            }
           ],
           "onClick": "",
           "newLineItemNumber": 3,
           "spaceSize": "M",
           "disabledItem": [],
           "icon": []
          },
          {
           "fieldName": "txtRiyoshaFutanKyufuritsu",
           "items": [],
           "controlType": "TextBoxNum",
           "width": "60",
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
           "selectControlID": "txtRiyoshaFutanKyufuritsu_core",
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
           "labelLText": "給付率",
           "labelRText": "",
           "labelLWidth": "55",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "permitCharactor": "+-,.",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtRiyoshaFutanTekiyoDateRange",
           "items": [],
           "controlType": "TextBoxDateRange",
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
           "selectControlID": "txtRiyoshaFutanTekiyoDateRange_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "labelLText": "適用期間",
           "labelRText": "",
           "labelLWidth": "70",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "ymdKubun": 2,
           "displayFormat": 0,
           "permitCharactor": "",
           "fromPlaceHolder": "",
           "toPlaceHolder": "",
           "minDate": "",
           "maxDate": "",
           "fromText": "",
           "toText": "",
           "fromValue": "",
           "toValue": "",
           "fromSelectControlID": "txtRiyoshaFutanTekiyoDateRangeFrom",
           "toSelectControlID": "txtRiyoshaFutanTekiyoDateRangeTo"
          }
         ],
         "controlType": "Panel",
         "width": "537",
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
         "marginRight": "0",
         "selectControlID": "JukyushaIdoRenrakuhyoRiyoshaFutan",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "利用者負担",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "JukyushaIdoRenrakuhyoRiyoshaFutan"
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
         "height": "52",
         "focusPositionID": "restoreLayoutButton",
         "canPost": true
        },
        {
         "fieldName": "JukyushaIdoRenrakuhyoFukushiHojinKeigen",
         "items": [
          {
           "fieldName": "txtKeigenritsu",
           "items": [],
           "controlType": "TextBoxNum",
           "width": "60",
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
           "selectControlID": "txtKeigenritsu_core",
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
           "labelLText": "軽減率",
           "labelRText": "",
           "labelLWidth": "55",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "permitCharactor": "+-,.",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtKeigenritsuTekiyoDateRange",
           "items": [],
           "controlType": "TextBoxDateRange",
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
           "selectControlID": "txtKeigenritsuTekiyoDateRange_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "labelLText": "適用期間",
           "labelRText": "",
           "labelLWidth": "70",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "ymdKubun": 2,
           "displayFormat": 0,
           "permitCharactor": "",
           "fromPlaceHolder": "",
           "toPlaceHolder": "",
           "minDate": "",
           "maxDate": "",
           "fromText": "",
           "toText": "",
           "fromValue": "",
           "toValue": "",
           "fromSelectControlID": "txtKeigenritsuTekiyoDateRangeFrom",
           "toSelectControlID": "txtKeigenritsuTekiyoDateRangeTo"
          }
         ],
         "controlType": "Panel",
         "width": "537",
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
         "selectControlID": "JukyushaIdoRenrakuhyoFukushiHojinKeigen",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "社会福祉法人軽減情報",
         "marginTop": "0.6",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "JukyushaIdoRenrakuhyoFukushiHojinKeigen"
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
         "height": "29",
         "focusPositionID": "restoreLayoutButton",
         "canPost": true
        },
        {
         "fieldName": "JukyushaIdoRenrakuhyoHyojunFutan",
         "items": [
          {
           "fieldName": "radHyojunFutanKubun",
           "items": [],
           "controlType": "RadioButton",
           "width": "410",
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
           "selectControlID": "radHyojunFutanKubun_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "required": false,
           "onChange": "",
           "labelLText": "区分",
           "labelLWidth": "55",
           "labelLAlign": 2,
           "selectedItem": null,
           "dataSource": [
            {
             "key": "nashi",
             "value": "未選択"
            },
            {
             "key": "riyosha",
             "value": "利用者負担"
            },
            {
             "key": "kyushochiNyushosha",
             "value": "旧措置入所者利用者負担"
            }
           ],
           "onClick": "",
           "newLineItemNumber": 3,
           "spaceSize": "M",
           "disabledItem": [],
           "icon": []
          },
          {
           "fieldName": "txtHyojunFutangaku",
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
           "selectControlID": "txtHyojunFutangaku_core",
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
           "labelLText": "負担額",
           "labelRText": "",
           "labelLWidth": "55",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "permitCharactor": "+-,.",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtHyojunFutanTekiyoDateRange",
           "items": [],
           "controlType": "TextBoxDateRange",
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
           "selectControlID": "txtHyojunFutanTekiyoDateRange_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "labelLText": "適用期間",
           "labelRText": "",
           "labelLWidth": "70",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "ymdKubun": 2,
           "displayFormat": 0,
           "permitCharactor": "",
           "fromPlaceHolder": "",
           "toPlaceHolder": "",
           "minDate": "",
           "maxDate": "",
           "fromText": "",
           "toText": "",
           "fromValue": "",
           "toValue": "",
           "fromSelectControlID": "txtHyojunFutanTekiyoDateRangeFrom",
           "toSelectControlID": "txtHyojunFutanTekiyoDateRangeTo"
          }
         ],
         "controlType": "Panel",
         "width": "537",
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
         "selectControlID": "JukyushaIdoRenrakuhyoHyojunFutan",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "標準負担",
         "marginTop": "0.6",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "JukyushaIdoRenrakuhyoHyojunFutan"
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
         "height": "52",
         "focusPositionID": "restoreLayoutButton",
         "canPost": true
        }
       ],
       "controlType": "Panel",
       "width": "544",
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
       "selectControlID": "JukyushaIdoRenrakuhyoGemmenGengakuSub",
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
         "postParameterPanelNames": "JukyushaIdoRenrakuhyoGemmenGengakuSub"
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
       "height": "Auto",
       "focusPositionID": "restoreLayoutButton",
       "canPost": true
      },
      {
       "fieldName": "JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi",
       "items": [
        {
         "fieldName": "radNinteiShinseichuKubun",
         "items": [],
         "controlType": "RadioButton",
         "width": "340",
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
         "selectControlID": "radNinteiShinseichuKubun_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "onChange": "",
         "labelLText": "認定申請中区分",
         "labelLWidth": "155",
         "labelLAlign": 2,
         "selectedItem": null,
         "dataSource": [
          {
           "key": "nashi",
           "value": "未選択"
          },
          {
           "key": "shinseiNashi",
           "value": "申請無"
          },
          {
           "key": "shinseiTyu",
           "value": "申請中"
          },
          {
           "key": "ketteiZumi",
           "value": "決定済"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 4,
         "spaceSize": "M",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "radServiceKubun",
         "items": [],
         "controlType": "RadioButton",
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
         "marginLeft": "XS",
         "marginRight": "XS",
         "selectControlID": "radServiceKubun_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "onChange": "",
         "labelLText": "サービス区分",
         "labelLWidth": "155",
         "labelLAlign": 2,
         "selectedItem": null,
         "dataSource": [
          {
           "key": "nashi",
           "value": "未選択"
          },
          {
           "key": "kyusochiNyushosha",
           "value": "通常受給者"
          },
          {
           "key": "standard",
           "value": "旧措置入所者"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 3,
         "spaceSize": "M",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "radTokureiKeigenSochiTaisho",
         "items": [],
         "controlType": "RadioButton",
         "width": "240",
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
         "selectControlID": "radTokureiKeigenSochiTaisho_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "required": false,
         "onChange": "",
         "labelLText": "特例減額措置対象",
         "labelLWidth": "155",
         "labelLAlign": 2,
         "selectedItem": null,
         "dataSource": [
          {
           "key": "selectnashi",
           "value": "未選択"
          },
          {
           "key": "nashi",
           "value": "該当無"
          },
          {
           "key": "ari",
           "value": "該当有"
          }
         ],
         "onClick": "",
         "newLineItemNumber": 3,
         "spaceSize": "M",
         "disabledItem": [],
         "icon": []
        },
        {
         "fieldName": "txtShokuhiFutanGendogaku",
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
         "selectControlID": "txtShokuhiFutanGendogaku_core",
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
         "labelLText": "食費負担限度額 ",
         "labelRText": "",
         "labelLWidth": "155",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtFutanGendogakuTekiyoDateRange",
         "items": [],
         "controlType": "TextBoxDateRange",
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
         "selectControlID": "txtFutanGendogakuTekiyoDateRange_core",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "isPrivateInfo": false,
         "isPassword": false,
         "onFocus": "",
         "onBlur": "",
         "onChange": "",
         "onKeyPress": "",
         "labelLText": "負担限度額適用期間",
         "labelRText": "",
         "labelLWidth": "155",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "ymdKubun": 2,
         "displayFormat": 0,
         "permitCharactor": "",
         "fromPlaceHolder": "",
         "toPlaceHolder": "",
         "minDate": "",
         "maxDate": "",
         "fromText": "",
         "toText": "",
         "fromValue": "",
         "toValue": "",
         "fromSelectControlID": "txtFutanGendogakuTekiyoDateRangeFrom",
         "toSelectControlID": "txtFutanGendogakuTekiyoDateRangeTo"
        },
        {
         "fieldName": "lblKyojuhiFutanGendogaku",
         "items": [],
         "controlType": "Label",
         "width": "155",
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
         "selectControlID": "lblKyojuhiFutanGendogaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "居住費負担限度額",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "txtUnitKoshitsuGendogaku",
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
         "selectControlID": "txtUnitKoshitsuGendogaku_core",
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
         "labelLText": "ユニット型個室",
         "labelRText": "",
         "labelLWidth": "155",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtUnitJunKoshitsuFutanGendogaku",
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
         "selectControlID": "txtUnitJunKoshitsuFutanGendogaku_core",
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
         "labelLText": "ユニット型準個室",
         "labelRText": "",
         "labelLWidth": "135",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtJuraigataKoshitsuTokuyoFutanGendogaku",
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
         "selectControlID": "txtJuraigataKoshitsuTokuyoFutanGendogaku_core",
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
         "labelLText": "従来型個室(特養等)",
         "labelRText": "",
         "labelLWidth": "155",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtJuraigataKoshitsuRokenRyoyoFutanGendogaku",
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
         "selectControlID": "txtJuraigataKoshitsuRokenRyoyoFutanGendogaku_core",
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
         "labelLText": "(老健、療養等)",
         "labelRText": "",
         "labelLWidth": "135",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        },
        {
         "fieldName": "txtTashoshitsu",
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
         "selectControlID": "txtTashoshitsu_core",
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
         "labelLText": "多床室",
         "labelRText": "",
         "labelLWidth": "155",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 2,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "+-,.",
         "maxValue": 1.7976931348623157e+308,
         "minValue": 0,
         "isCurrency": false,
         "isComma": true,
         "decimalPointLength": 0
        }
       ],
       "controlType": "Panel",
       "width": "537",
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
       "selectControlID": "JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "特定入所者サービス費",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"
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
       "canPost": true
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoGemmenGengaku",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "減免・減額",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoGemmenGengaku"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoKokiKoreiKokuho",
     "items": [
      {
       "fieldName": "JukyushaIdoRenrakuhyoKokiKorei",
       "items": [
        {
         "fieldName": "txtKokiKoreiHokenshaNo",
         "items": [],
         "controlType": "TextBoxCode",
         "width": "65",
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
         "selectControlID": "txtKokiKoreiHokenshaNo_core",
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
         "labelLText": "保険者番号",
         "labelRText": "",
         "labelLWidth": "85",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "",
         "formatLength": "8"
        },
        {
         "fieldName": "txtKokiKoreiHihokenshaNo",
         "items": [],
         "controlType": "TextBoxCode",
         "width": "65",
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
         "selectControlID": "txtKokiKoreiHihokenshaNo_core",
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
         "labelLText": "被保番号",
         "labelRText": "",
         "labelLWidth": "70",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "",
         "formatLength": "8"
        }
       ],
       "controlType": "Panel",
       "width": "352",
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
       "selectControlID": "JukyushaIdoRenrakuhyoKokiKorei",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "後期高齢",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "JukyushaIdoRenrakuhyoKokiKorei"
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
       "canPost": true
      },
      {
       "fieldName": "JukyushaIdoRenrakuhyoKokuho",
       "items": [
        {
         "fieldName": "txtKokuhoHokenshaNo",
         "items": [],
         "controlType": "TextBoxCode",
         "width": "65",
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
         "selectControlID": "txtKokuhoHokenshaNo_core",
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
         "labelLText": "保険者番号",
         "labelRText": "",
         "labelLWidth": "85",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "",
         "formatLength": "8"
        },
        {
         "fieldName": "txtKokuhoHihokenshashoNo",
         "items": [],
         "controlType": "TextBoxCode",
         "width": "162",
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
         "selectControlID": "txtKokuhoHihokenshashoNo_core",
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
         "labelLText": "被保険者証番号",
         "labelRText": "",
         "labelLWidth": "120",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "",
         "formatLength": "20"
        },
        {
         "fieldName": "txtKokuhoKojinNo",
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
         "selectControlID": "txtKokuhoKojinNo_core",
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
         "labelLText": "個人番号",
         "labelRText": "",
         "labelLWidth": "75",
         "labelRWidth": "S",
         "labelLAlign": 2,
         "labelRAlign": 0,
         "value": "",
         "maxLength": 100000000,
         "minLength": 0,
         "textAlign": 0,
         "textKind": 2,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": "",
         "formatLength": "10"
        }
       ],
       "controlType": "Panel",
       "width": "723",
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
       "selectControlID": "JukyushaIdoRenrakuhyoKokuho",
       "helpMessageID": "",
       "jpControlName": "",
       "onLoad": "",
       "title": "国保",
       "marginTop": "Default",
       "marginBottom": "Default",
       "isOpen": true,
       "canOpenAndClose": false,
       "postParameterPanelNames": [
        {
         "postParameterPanelNames": "JukyushaIdoRenrakuhyoKokuho"
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
       "canPost": true
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoKokiKoreiKokuho",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "後期高齢・国保",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoKokiKoreiKokuho"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoKyufuSeigen",
     "items": [
      {
       "fieldName": "radKohiFutanJogengakuGengakuUmu",
       "items": [],
       "controlType": "RadioButton",
       "width": "210",
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
       "selectControlID": "radKohiFutanJogengakuGengakuUmu_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "公費負担上限額減額(生活保護等)",
       "labelLWidth": "245",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "selnashi",
         "value": "未選択"
        },
        {
         "key": "nashi",
         "value": "なし"
        },
        {
         "key": "ari",
         "value": "あり"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 3,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "Button6",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button6",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
       "fieldName": "txtKyufuritsuHikisageDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtKyufuritsuHikisageDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "償還払化期間",
       "labelRText": "",
       "labelLWidth": "105",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtKyufuritsuHikisageDateRangeFrom",
       "toSelectControlID": "txtKyufuritsuHikisageDateRangeTo"
      },
      {
       "fieldName": "txtShokanBaraikaDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtShokanBaraikaDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "給付率引下げ期間",
       "labelRText": "",
       "labelLWidth": "135",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtShokanBaraikaDateRangeFrom",
       "toSelectControlID": "txtShokanBaraikaDateRangeTo"
      }
     ],
     "controlType": "Panel",
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoKyufuSeigen",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "給付制限",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoKyufuSeigen"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoNijiyoboJigyo",
     "items": [
      {
       "fieldName": "radNijiyoboJigyoKubun",
       "items": [],
       "controlType": "RadioButton",
       "width": "230",
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
       "selectControlID": "radNijiyoboJigyoKubun_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "required": false,
       "onChange": "",
       "labelLText": "事業区分",
       "labelLWidth": "70",
       "labelLAlign": 2,
       "selectedItem": null,
       "dataSource": [
        {
         "key": "selnashi",
         "value": "未選択"
        },
        {
         "key": "higaito",
         "value": "非該当"
        },
        {
         "key": "gaito",
         "value": "該当"
        }
       ],
       "onClick": "",
       "newLineItemNumber": 3,
       "spaceSize": "M",
       "disabledItem": [],
       "icon": []
      },
      {
       "fieldName": "txtNijiyoboJigyoYukoDateRange",
       "items": [],
       "controlType": "TextBoxDateRange",
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
       "selectControlID": "txtNijiyoboJigyoYukoDateRange_core",
       "helpMessageID": "",
       "jpControlName": "",
       "readOnly": false,
       "isPrivateInfo": false,
       "isPassword": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "onKeyPress": "",
       "labelLText": "事業有効期間",
       "labelRText": "",
       "labelLWidth": "100",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "ymdKubun": 2,
       "displayFormat": 0,
       "permitCharactor": "",
       "fromPlaceHolder": "",
       "toPlaceHolder": "",
       "minDate": "",
       "maxDate": "",
       "fromText": "",
       "toText": "",
       "fromValue": "",
       "toValue": "",
       "fromSelectControlID": "txtNijiyoboJigyoYukoDateRangeFrom",
       "toSelectControlID": "txtNijiyoboJigyoYukoDateRangeTo"
      },
      {
       "fieldName": "Button7",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button7",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoNijiyoboJigyo",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "二次予防事業",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoNijiyoboJigyo"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
    },
    {
     "fieldName": "JukyushaIdoRenrakuhyoRojinHoken",
     "items": [
      {
       "fieldName": "RokenShichosonNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "65",
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
       "selectControlID": "RokenShichosonNo_core",
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
       "labelLText": "市町村番号",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "8"
      },
      {
       "fieldName": "RokenJukyushaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "65",
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
       "selectControlID": "RokenJukyushaNo_core",
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
       "labelLText": "受給者番号",
       "labelRText": "",
       "labelLWidth": "85",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "8"
      },
      {
       "fieldName": "RokenKohiFutanshaNo",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "65",
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
       "selectControlID": "RokenKohiFutanshaNo_core",
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
       "labelLText": "公費負担者番号",
       "labelRText": "",
       "labelLWidth": "120",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "value": "",
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "textKind": 2,
       "isComboBox": false,
       "suggest": [],
       "decorationClass": "",
       "permitCharactor": "",
       "formatLength": "8"
      },
      {
       "fieldName": "Button8",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "Button8",
       "helpMessageID": "",
       "jpControlName": "",
       "text": "詳細情報を表示する",
       "onClick": "",
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
     "width": "1098",
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
     "marginRight": "0",
     "selectControlID": "JukyushaIdoRenrakuhyoRojinHoken",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "老人保健",
     "marginTop": "XS",
     "marginBottom": "XS",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "JukyushaIdoRenrakuhyoRojinHoken"
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
     "focusPositionID": "restoreLayoutButton",
     "canPost": true
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
   "marginRight": "0",
   "selectControlID": "JukyushaIdoRenrakuhyo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "0",
   "marginBottom": "0",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "JukyushaIdoRenrakuhyo"
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
   "height": "Auto",
   "focusPositionID": "restoreLayoutButton",
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
 "marginLeft": "0",
 "marginRight": "0",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "businessId": "DBC",
 "controlName": "JukyushaIdoRenrakuhyo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "JukyushaIdoRenrakuhyoTeisei",
   "publicChildProperty": "visible",
   "newPropertyName": "TeiseiInfoVisible"
  },
  {
   "publicChildFieldName": "JukyushaIdoRenrakuhyoTeisei",
   "publicChildProperty": "displayNone",
   "newPropertyName": "TeiseiInfoDisplayNone"
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

