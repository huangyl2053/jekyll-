/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module ServiceRiyohyoInfo {

        export class Events {

            public static get onBlurServiceCode(): string {
                return "onBlurServiceCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "ServiceRiyohyoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public ServiceRiyohyoInfo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtTodokedeYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtTodokedeYMD"));

            }

            public txtTekiyoKikan() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoKikan"));

            }

            public txtKeikakuJigyoshaCode() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtKeikakuJigyoshaCode"));

            }

            public txtKeikakuJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaName"));

            }

            public txtTaishoYM() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtTaishoYM"));

            }

            public txtRiyohyoSakuseiYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoSakuseiYMD"));

            }

            public txtRiyohyoTodokedeYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoTodokedeYMD"));

            }

            public txtKubunShikyuGendogaku() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKubunShikyuGendogaku"));

            }

            public txtRiyohyoSakuseisha() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtRiyohyoSakuseisha"));

            }

            public txtGendoKanriKikan() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));

            }

            public btnZengetsuCopy() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnZengetsuCopy"));

            }

            public tabServiceRiyohyo() : UZA.TabContainer {

                return new UZA.TabContainer(this.convFiledName("tabServiceRiyohyo"));

            }

            public ServiceRiyohyo() : UZA.TabPanel {

                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyo"));

            }

            public lblServiceRiyohyoList() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblServiceRiyohyoList"));

            }

            public btnRiyohyoMeisaiAdd() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnRiyohyoMeisaiAdd"));

            }

            public dgServiceRiyohyoList() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoList"));

            }

            public ServiceRiyohyoBeppyo() : UZA.TabPanel {

                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyoBeppyo"));

            }

            public ServiceRiyohyoBeppyoRiyoNissu() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoRiyoNissu"));

            }

            public txtZengetsuRiyoNissu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuRiyoNissu"));

            }

            public txtTogetsuRiyoNissu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuRiyoNissu"));

            }

            public txtRuikeiRiyoNissu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRuikeiRiyoNissu"));

            }

            public ServiceRiyohyoBeppyoList() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoList"));

            }

            public btnBeppyoMeisaiNew() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiNew"));

            }

            public btnBeppyoGokeiNew() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnBeppyoGokeiNew"));

            }

            public dgServiceRiyohyoBeppyoList() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoBeppyoList"));

            }

            public ServiceRiyohyoBeppyoMeisai() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisai"));

            }

            public txtJigyoshaCode() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaCode"));

            }

            public btnJigyosha() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnJigyosha"));

            }

            public txtJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));

            }

            public txtServiceCode() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));

            }

            public btnService() : UZA.ButtonDialog {

                return new UZA.ButtonDialog(this.convFiledName("btnService"));

            }

            public txtServiceName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtServiceName"));

            }

            public txtTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTani"));

            }

            public txtWaribikigoRitsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoRitsu"));

            }

            public txtWaribikigoTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoTani"));

            }

            public txtKaisu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));

            }

            public lblKaisu() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKaisu"));

            }

            public txtServiceTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));

            }

            public lblServiceTani() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblServiceTani"));

            }

            public btnCalcMeisai() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnCalcMeisai"));

            }

            public btnBeppyoMeisaiKakutei() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiKakutei"));

            }

            public ServiceRiyohyoBeppyoGokei() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokei"));

            }

            public txtShuruiGendoChokaTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));

            }

            public txtShuruiGendonaiTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));

            }

            public txtTanisuTanka() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTanisuTanka"));

            }

            public txtKubunGendoChokaTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));

            }

            public txtKubunGendonaiTani() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));

            }

            public txtKyufuritsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));

            }

            public txtHiyoSogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));

            }

            public lblHiyoSogaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHiyoSogaku"));

            }

            public txtHokenKyufugaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufugaku"));

            }

            public lblHokenKyufugaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHokenKyufugaku"));

            }

            public txtRiyoshaFutangakuHoken() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuHoken"));

            }

            public lblRiyoshaFutangakuHoken() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuHoken"));

            }

            public txtRiyoshaFutangakuZengaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuZengaku"));

            }

            public lblRiyoshaFutangakuZengaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuZengaku"));

            }

            public btnCalcGokei() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnCalcGokei"));

            }

            public btnBeppyoGokeiKakutei() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnBeppyoGokeiKakutei"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class ServiceRiyohyoInfo_Design extends Uz.CommonChildDiv {
    
        public get BeppyoMeisaiVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"])["visible"];
        }
        
        public set BeppyoMeisaiVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[2]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get BeppyoMeisaiDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"])["displayNone"];
        }
        
        public set BeppyoMeisaiDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[2]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get BeppyoGokeiVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"])["visible"];
        }
        
        public set BeppyoGokeiVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[3]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get BeppyoGokeiDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"])["displayNone"];
        }
        
        public set BeppyoGokeiDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[3]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get BeppyoRiyoNissuVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"])["visible"];
        }
        
        public set BeppyoRiyoNissuVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[0]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get BeppyoRiyoNissuDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"])["displayNone"];
        }
        
        public set BeppyoRiyoNissuDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[0]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get KeikakuJigyoshaCodeVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"];
        }
        
        public set KeikakuJigyoshaCodeVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[2]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get KeikakuJigyoshaCodeDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"];
        }
        
        public set KeikakuJigyoshaCodeDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[2]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get KeikakuJigyoshaNameVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["visible"];
        }
        
        public set KeikakuJigyoshaNameVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[3]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get KeikakuJigyoshaNameDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
        }
        
        public set KeikakuJigyoshaNameDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[3]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoListGridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["gridSetting"];
        }
        
        public set dgServiceRiyohyoListGridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[11].items[0].items[2]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickZengetsuCopy() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["onClick"];
        }
        
        public set onClickZengetsuCopy(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[10]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickRiyohyoMeisaiAdd() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[1]["fieldName"])["onClick"];
        }
        
        public set onClickRiyohyoMeisaiAdd(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[1]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[0].items[1]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBeppyoMeisaiNew() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[0]["fieldName"])["onClick"];
        }
        
        public set onClickBeppyoMeisaiNew(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[0]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[0]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBeppyoGokeiNew() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[1]["fieldName"])["onClick"];
        }
        
        public set onClickBeppyoGokeiNew(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[1]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[1]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[1]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[1]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBeppyoMeisaiKakutei() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[14]["fieldName"])["onClick"];
        }
        
        public set onClickBeppyoMeisaiKakutei(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[14]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[14]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[14]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[2].items[14]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBeppyoGokeiKakutei() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[15]["fieldName"])["onClick"];
        }
        
        public set onClickBeppyoGokeiKakutei(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[15]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[15]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[15]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[3].items[15]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoBeppyoListGridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["gridSetting"];
        }
        
        public set dgServiceRiyohyoBeppyoListGridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[2]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoListSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectByDblClick"];
        }
        
        public set dgServiceRiyohyoListSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[11].items[0].items[2]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoListSelectBySelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectBySelectButton"];
        }
        
        public set dgServiceRiyohyoListSelectBySelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectBySelectButton"] = value;
            } else {
                this.layout.items[0].items[11].items[0].items[2]["onSelectBySelectButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoListSelectByDelete() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectByDeleteButton"];
        }
        
        public set dgServiceRiyohyoListSelectByDelete(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"])["onSelectByDeleteButton"] = value;
            } else {
                this.layout.items[0].items[11].items[0].items[2]["onSelectByDeleteButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoBeppyoListSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectByDblClick"];
        }
        
        public set dgServiceRiyohyoBeppyoListSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[2]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoBeppyoListSelectBySelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectBySelectButton"];
        }
        
        public set dgServiceRiyohyoBeppyoListSelectBySelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectBySelectButton"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[2]["onSelectBySelectButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get dgServiceRiyohyoBeppyoListSelectByDelete() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectByDeleteButton"];
        }
        
        public set dgServiceRiyohyoBeppyoListSelectByDelete(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"])["onSelectByDeleteButton"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[1].items[2]["onSelectByDeleteButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ServiceRiyohyoEraseBorder() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
        }
        
        public set ServiceRiyohyoEraseBorder(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
            } else {
                this.layout.items[0]["eraseBorder"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBtnCalcMeisai() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[13]["fieldName"])["onClick"];
        }
        
        public set onClickBtnCalcMeisai(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[13]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[13]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[13]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[2].items[13]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onClickBtnCalcGokei() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[14]["fieldName"])["onClick"];
        }
        
        public set onClickBtnCalcGokei(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[14]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[14]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[14]["fieldName"])["onClick"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[3].items[14]["onClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get onBlurTxtSreviceCode() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[3]["fieldName"])["onBlur"];
        }
        
        public set onBlurTxtSreviceCode(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[3]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[3]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[3]["fieldName"])["onBlur"] = value;
            } else {
                this.layout.items[0].items[11].items[1].items[2].items[3]["onBlur"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, ServiceRiyohyoInfo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("BeppyoMeisaiVisible");
            Uz.JSControlUtil.registProperty("BeppyoMeisaiDisplayNone");
            Uz.JSControlUtil.registProperty("BeppyoGokeiVisible");
            Uz.JSControlUtil.registProperty("BeppyoGokeiDisplayNone");
            Uz.JSControlUtil.registProperty("BeppyoRiyoNissuVisible");
            Uz.JSControlUtil.registProperty("BeppyoRiyoNissuDisplayNone");
            Uz.JSControlUtil.registProperty("KeikakuJigyoshaCodeVisible");
            Uz.JSControlUtil.registProperty("KeikakuJigyoshaCodeDisplayNone");
            Uz.JSControlUtil.registProperty("KeikakuJigyoshaNameVisible");
            Uz.JSControlUtil.registProperty("KeikakuJigyoshaNameDisplayNone");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoListGridSetting");
            Uz.JSControlUtil.registProperty("onClickZengetsuCopy");
            Uz.JSControlUtil.registProperty("onClickRiyohyoMeisaiAdd");
            Uz.JSControlUtil.registProperty("onClickBeppyoMeisaiNew");
            Uz.JSControlUtil.registProperty("onClickBeppyoGokeiNew");
            Uz.JSControlUtil.registProperty("onClickBeppyoMeisaiKakutei");
            Uz.JSControlUtil.registProperty("onClickBeppyoGokeiKakutei");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoBeppyoListGridSetting");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoListSelectByDblClick");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoListSelectBySelect");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoListSelectByDelete");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoBeppyoListSelectByDblClick");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoBeppyoListSelectBySelect");
            Uz.JSControlUtil.registProperty("dgServiceRiyohyoBeppyoListSelectByDelete");
            Uz.JSControlUtil.registProperty("ServiceRiyohyoEraseBorder");
            Uz.JSControlUtil.registProperty("onClickBtnCalcMeisai");
            Uz.JSControlUtil.registProperty("onClickBtnCalcGokei");
            Uz.JSControlUtil.registProperty("onBlurTxtSreviceCode");
            Uz.JSControlUtil.registProperty("");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["BeppyoMeisaiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["BeppyoMeisaiDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["BeppyoGokeiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["BeppyoGokeiDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["BeppyoRiyoNissuVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["BeppyoRiyoNissuDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["KeikakuJigyoshaCodeVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["KeikakuJigyoshaCodeDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["KeikakuJigyoshaNameVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["KeikakuJigyoshaNameDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["dgServiceRiyohyoListGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["onClickZengetsuCopy"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickRiyohyoMeisaiAdd"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickBeppyoMeisaiNew"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickBeppyoGokeiNew"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[1]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickBeppyoMeisaiKakutei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[14]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickBeppyoGokeiKakutei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[15]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["dgServiceRiyohyoBeppyoListGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["dgServiceRiyohyoListSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["dgServiceRiyohyoListSelectBySelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectBySelectButton"];
            editablePropertyInfo["dgServiceRiyohyoListSelectByDelete"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[0]["fieldName"] + "_" + this.layout.items[0].items[11].items[0].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectByDeleteButton"];
            editablePropertyInfo["dgServiceRiyohyoBeppyoListSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["dgServiceRiyohyoBeppyoListSelectBySelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectBySelectButton"];
            editablePropertyInfo["dgServiceRiyohyoBeppyoListSelectByDelete"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[1].items[2]["fieldName"]).getEditablePropertyInfo()["onSelectByDeleteButton"];
            editablePropertyInfo["ServiceRiyohyoEraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["onClickBtnCalcMeisai"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[13]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onClickBtnCalcGokei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[3].items[14]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["onBlurTxtSreviceCode"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"] + "_" + this.layout.items[0].items[11].items[1]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2]["fieldName"] + "_" + this.layout.items[0].items[11].items[1].items[2].items[3]["fieldName"]).getEditablePropertyInfo()["onBlur"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "ServiceRiyohyoInfo",
   "items": [
    {
     "fieldName": "txtTodokedeYMD",
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
     "selectControlID": "txtTodokedeYMD_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "届出日",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "20140504",
     "permitCharactor": "./_-",
     "textKind": 0
    },
    {
     "fieldName": "txtTekiyoKikan",
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
     "marginRight": "0",
     "selectControlID": "txtTekiyoKikan_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "適用期間",
     "labelRText": "",
     "labelLWidth": "75",
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
     "fromSelectControlID": "txtTekiyoKikanFrom",
     "toSelectControlID": "txtTekiyoKikanTo"
    },
    {
     "fieldName": "txtKeikakuJigyoshaCode",
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
     "marginRight": "0",
     "selectControlID": "txtKeikakuJigyoshaCode_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "計画作成事業者",
     "labelRText": "",
     "labelLWidth": "145",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "permitCharactor": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "textKind": 2,
     "isComboBox": false,
     "suggest": [],
     "decorationClass": "",
     "formatLength": "10"
    },
    {
     "fieldName": "txtKeikakuJigyoshaName",
     "items": [],
     "controlType": "TextBox",
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
     "marginLeft": "0",
     "marginRight": "XS",
     "selectControlID": "txtKeikakuJigyoshaName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
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
     "permitCharactor": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "textKind": 0,
     "isComboBox": false,
     "suggest": [],
     "decorationClass": ""
    },
    {
     "fieldName": "txtTaishoYM",
     "items": [],
     "controlType": "TextBoxDate",
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
     "selectControlID": "txtTaishoYM_core",
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
     "labelLText": "対象年月",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 1,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-",
     "textKind": 0
    },
    {
     "fieldName": "txtRiyohyoSakuseiYMD",
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
     "marginLeft": "0",
     "marginRight": "XS",
     "selectControlID": "txtRiyohyoSakuseiYMD_core",
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
     "labelLText": "利用票作成日",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-",
     "textKind": 0
    },
    {
     "fieldName": "txtRiyohyoTodokedeYMD",
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
     "selectControlID": "txtRiyohyoTodokedeYMD_core",
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
     "labelLText": "利用票届出日",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-",
     "textKind": 0
    },
    {
     "fieldName": "txtKubunShikyuGendogaku",
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
     "selectControlID": "txtKubunShikyuGendogaku_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "labelLText": "区分支給限度額",
     "labelRText": "",
     "labelLWidth": "120",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "permitCharactor": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "textKind": 0,
     "isComboBox": false,
     "suggest": [],
     "decorationClass": ""
    },
    {
     "fieldName": "txtRiyohyoSakuseisha",
     "items": [],
     "controlType": "TextBox",
     "width": "350",
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
     "selectControlID": "txtRiyohyoSakuseisha_core",
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
     "labelLText": "利用票作成者",
     "labelRText": "",
     "labelLWidth": "100",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "permitCharactor": "",
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "textKind": 0,
     "isComboBox": false,
     "suggest": [],
     "decorationClass": ""
    },
    {
     "fieldName": "txtGendoKanriKikan",
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
     "selectControlID": "txtGendoKanriKikan_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "限度管理期間",
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
     "fromSelectControlID": "txtGendoKanriKikanFrom",
     "toSelectControlID": "txtGendoKanriKikanTo"
    },
    {
     "fieldName": "btnZengetsuCopy",
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
     "marginLeft": "6",
     "marginRight": "XS",
     "selectControlID": "btnZengetsuCopy",
     "helpMessageID": "",
     "jpControlName": "",
     "text": "前月の情報をコピーする",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "icon": 0,
     "heightTextBoxMatches": false
    },
    {
     "fieldName": "tabServiceRiyohyo",
     "items": [
      {
       "fieldName": "ServiceRiyohyo",
       "items": [
        {
         "fieldName": "lblServiceRiyohyoList",
         "items": [],
         "controlType": "Label",
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
         "selectControlID": "lblServiceRiyohyoList",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "月間サービス計画及び実績の記録",
         "decorationClass": "",
         "align": 2
        },
        {
         "fieldName": "btnRiyohyoMeisaiAdd",
         "items": [],
         "controlType": "Button",
         "width": "180",
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
         "selectControlID": "btnRiyohyoMeisaiAdd",
         "helpMessageID": "",
         "jpControlName": "",
         "text": "明細行を追加する",
         "onClick": "",
         "appearance": 0,
         "imageFileUrl": "",
         "imageWidth": "",
         "imageHeight": "",
         "icon": 0,
         "heightTextBoxMatches": false
        },
        {
         "fieldName": "dgServiceRiyohyoList",
         "items": [],
         "controlType": "DataGrid",
         "width": "1080",
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
         "selectControlID": "dgServiceRiyohyoList",
         "helpMessageID": "",
         "jpControlName": "",
         "readOnly": false,
         "height": "294",
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
           "combineColumns": [
            {
             "combineColumnName": "提供時間帯",
             "combineItem": [
              "txtKaishi",
              "txtShuryo"
             ]
            },
            {
             "combineColumnName": "日",
             "combineItem": [
              "txtYoJitsu"
             ]
            },
            {
             "combineColumnName": "1",
             "combineItem": [
              "txtDay1"
             ]
            },
            {
             "combineColumnName": "2",
             "combineItem": [
              "txtDay2"
             ]
            },
            {
             "combineColumnName": "3",
             "combineItem": [
              "txtDay3"
             ]
            },
            {
             "combineColumnName": "4",
             "combineItem": [
              "txtDay4"
             ]
            },
            {
             "combineColumnName": "5",
             "combineItem": [
              "txtDay5"
             ]
            },
            {
             "combineColumnName": "6",
             "combineItem": [
              "txtDay6"
             ]
            },
            {
             "combineColumnName": "7",
             "combineItem": [
              "txtDay7"
             ]
            },
            {
             "combineColumnName": "8",
             "combineItem": [
              "txtDay8"
             ]
            },
            {
             "combineColumnName": "9",
             "combineItem": [
              "txtDay9"
             ]
            },
            {
             "combineColumnName": "10",
             "combineItem": [
              "txtDay10"
             ]
            },
            {
             "combineColumnName": "11",
             "combineItem": [
              "txtDay11"
             ]
            },
            {
             "combineColumnName": "12",
             "combineItem": [
              "txtDay12"
             ]
            },
            {
             "combineColumnName": "13",
             "combineItem": [
              "txtDay13"
             ]
            },
            {
             "combineColumnName": "14",
             "combineItem": [
              "txtDay14"
             ]
            },
            {
             "combineColumnName": "15",
             "combineItem": [
              "txtDay15"
             ]
            },
            {
             "combineColumnName": "16",
             "combineItem": [
              "txtDay16"
             ]
            },
            {
             "combineColumnName": "17",
             "combineItem": [
              "txtDay17"
             ]
            },
            {
             "combineColumnName": "18",
             "combineItem": [
              "txtDay18"
             ]
            },
            {
             "combineColumnName": "19",
             "combineItem": [
              "txtDay19"
             ]
            },
            {
             "combineColumnName": "20",
             "combineItem": [
              "txtDay20"
             ]
            },
            {
             "combineColumnName": "21",
             "combineItem": [
              "txtDay21"
             ]
            },
            {
             "combineColumnName": "22",
             "combineItem": [
              "txtDay22"
             ]
            },
            {
             "combineColumnName": "23",
             "combineItem": [
              "txtDay23"
             ]
            },
            {
             "combineColumnName": "24",
             "combineItem": [
              "txtDay24"
             ]
            },
            {
             "combineColumnName": "25",
             "combineItem": [
              "txtDay25"
             ]
            },
            {
             "combineColumnName": "26",
             "combineItem": [
              "txtDay26"
             ]
            },
            {
             "combineColumnName": "27",
             "combineItem": [
              "txtDay27"
             ]
            },
            {
             "combineColumnName": "28",
             "combineItem": [
              "txtDay28"
             ]
            },
            {
             "combineColumnName": "29",
             "combineItem": [
              "txtDay29"
             ]
            },
            {
             "combineColumnName": "30",
             "combineItem": [
              "txtDay30"
             ]
            },
            {
             "combineColumnName": "31",
             "combineItem": [
              "txtDay31"
             ]
            },
            {
             "combineColumnName": "合計",
             "combineItem": [
              "txtGokei"
             ]
            }
           ],
           "frozenColumn": "txtYoJitsu",
           "headerHeight": 0
          },
          "columns": [
           {
            "columnName": "",
            "dataName": "btnDelete",
            "toolTip": "",
            "bgColor": 0,
            "width": 35,
            "visible": true,
            "cellType": 8,
            "cellDetails": {
             "cellType": 8,
             "text": "削",
             "onClick": "",
             "imageFileUrl": "",
             "imageWidth": "",
             "imageHeight": ""
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "btnDelete"
           },
           {
            "columnName": "開始",
            "dataName": "txtKaishi",
            "toolTip": "",
            "bgColor": 0,
            "width": 60,
            "visible": true,
            "cellType": 1,
            "cellDetails": {
             "cellType": 1,
             "maxLength": "1000000000000",
             "minLength": "0",
             "textAlign": 1
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtKaishi"
           },
           {
            "columnName": "終了",
            "dataName": "txtShuryo",
            "toolTip": "",
            "bgColor": 0,
            "width": 60,
            "visible": true,
            "cellType": 1,
            "cellDetails": {
             "cellType": 1,
             "maxLength": "1000000000000",
             "minLength": "0",
             "textAlign": 1
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtShuryo"
           },
           {
            "columnName": "",
            "dataName": "btnService",
            "toolTip": "",
            "bgColor": 0,
            "width": 35,
            "visible": true,
            "cellType": 8,
            "cellDetails": {
             "cellType": 8,
             "text": "照",
             "onClick": "",
             "imageFileUrl": "",
             "imageWidth": "",
             "imageHeight": ""
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "btnService"
           },
           {
            "columnName": "サービス内容",
            "dataName": "txtService",
            "toolTip": "",
            "bgColor": 0,
            "width": 220,
            "visible": true,
            "cellType": 0,
            "cellDetails": {
             "cellType": 0
            },
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtService"
           },
           {
            "columnName": "",
            "dataName": "btnJigyosha",
            "toolTip": "",
            "bgColor": 0,
            "width": 35,
            "visible": true,
            "cellType": 8,
            "cellDetails": {
             "cellType": 8,
             "text": "照",
             "onClick": "",
             "imageFileUrl": "",
             "imageWidth": "",
             "imageHeight": ""
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "btnJigyosha"
           },
           {
            "columnName": "サービス事業者",
            "dataName": "txtJigyosha",
            "toolTip": "",
            "bgColor": 0,
            "width": 220,
            "visible": true,
            "cellType": 0,
            "cellDetails": {
             "cellType": 0
            },
            "align": 0,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtJigyosha"
           },
           {
            "columnName": "曜",
            "dataName": "txtYoJitsu",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 0,
            "cellDetails": null,
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtYoJitsu"
           },
           {
            "columnName": "日",
            "dataName": "txtDay1",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay1"
           },
           {
            "columnName": "月",
            "dataName": "txtDay2",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay2"
           },
           {
            "columnName": "火",
            "dataName": "txtDay3",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay3"
           },
           {
            "columnName": "水",
            "dataName": "txtDay4",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay4"
           },
           {
            "columnName": "木",
            "dataName": "txtDay5",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay5"
           },
           {
            "columnName": "金",
            "dataName": "txtDay6",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay6"
           },
           {
            "columnName": "土",
            "dataName": "txtDay7",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay7"
           },
           {
            "columnName": "日",
            "dataName": "txtDay8",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay8"
           },
           {
            "columnName": "月",
            "dataName": "txtDay9",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay9"
           },
           {
            "columnName": "火",
            "dataName": "txtDay10",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay10"
           },
           {
            "columnName": "水",
            "dataName": "txtDay11",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay11"
           },
           {
            "columnName": "木",
            "dataName": "txtDay12",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay12"
           },
           {
            "columnName": "金",
            "dataName": "txtDay13",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay13"
           },
           {
            "columnName": "土",
            "dataName": "txtDay14",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay14"
           },
           {
            "columnName": "日",
            "dataName": "txtDay15",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay15"
           },
           {
            "columnName": "月",
            "dataName": "txtDay16",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay16"
           },
           {
            "columnName": "火",
            "dataName": "txtDay17",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay17"
           },
           {
            "columnName": "水",
            "dataName": "txtDay18",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay18"
           },
           {
            "columnName": "木",
            "dataName": "txtDay19",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay19"
           },
           {
            "columnName": "金",
            "dataName": "txtDay20",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay20"
           },
           {
            "columnName": "土",
            "dataName": "txtDay21",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay21"
           },
           {
            "columnName": "日",
            "dataName": "txtDay22",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay22"
           },
           {
            "columnName": "月",
            "dataName": "txtDay23",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay23"
           },
           {
            "columnName": "火",
            "dataName": "txtDay24",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay24"
           },
           {
            "columnName": "水",
            "dataName": "txtDay25",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay25"
           },
           {
            "columnName": "木",
            "dataName": "txtDay26",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay26"
           },
           {
            "columnName": "金",
            "dataName": "txtDay27",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay27"
           },
           {
            "columnName": "土",
            "dataName": "txtDay28",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0",
             "onChange": "",
             "isSetValueToToolTip": false,
             "readOnly": false
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay28"
           },
           {
            "columnName": "日",
            "dataName": "txtDay29",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0"
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay29"
           },
           {
            "columnName": "月",
            "dataName": "txtDay30",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0",
             "onChange": "",
             "isSetValueToToolTip": false,
             "readOnly": false
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay30"
           },
           {
            "columnName": "火",
            "dataName": "txtDay31",
            "toolTip": "",
            "bgColor": 0,
            "width": 30,
            "visible": true,
            "cellType": 5,
            "cellDetails": {
             "cellType": 5,
             "maxLength": "1000000000000",
             "minLength": "0",
             "maxValue": "1.7976931348623157e+308",
             "minValue": "0",
             "isCurrency": false,
             "isComma": false,
             "decimalPointLength": "0",
             "onChange": "",
             "isSetValueToToolTip": false,
             "readOnly": false
            },
            "align": 1,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtDay31"
           },
           {
            "columnName": "",
            "dataName": "txtGokei",
            "toolTip": "",
            "bgColor": 0,
            "width": 40,
            "visible": true,
            "cellType": 0,
            "cellDetails": null,
            "align": 2,
            "resize": true,
            "isPrivateInfo": false,
            "sortKey": "txtGokei"
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
         "sortOrder": "txtJigyoshaName",
         "isAscending": true,
         "filterList": [],
         "activeRowId": -1
        }
       ],
       "controlType": "TabPanel",
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
       "selectControlID": "ServiceRiyohyo",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "サービス利用票",
       "onActive": "",
       "onFirstActive": ""
      },
      {
       "fieldName": "ServiceRiyohyoBeppyo",
       "items": [
        {
         "fieldName": "ServiceRiyohyoBeppyoRiyoNissu",
         "items": [
          {
           "fieldName": "txtZengetsuRiyoNissu",
           "items": [],
           "controlType": "TextBoxNum",
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
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "txtZengetsuRiyoNissu_core",
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
           "labelLText": "前月までの利用日数",
           "labelRText": "",
           "labelLWidth": "150",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtTogetsuRiyoNissu",
           "items": [],
           "controlType": "TextBoxNum",
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
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "txtTogetsuRiyoNissu_core",
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
           "labelLText": "当月の計画利用日数",
           "labelRText": "",
           "labelLWidth": "150",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtRuikeiRiyoNissu",
           "items": [],
           "controlType": "TextBoxNum",
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
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "txtRuikeiRiyoNissu_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "累積利用日数",
           "labelRText": "",
           "labelLWidth": "100",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
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
         "selectControlID": "ServiceRiyohyoBeppyoRiyoNissu",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "要介護認定期間中の短期入所利用日数",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": false,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "ServiceRiyohyoBeppyoRiyoNissu"
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
         "fieldName": "ServiceRiyohyoBeppyoList",
         "items": [
          {
           "fieldName": "btnBeppyoMeisaiNew",
           "items": [],
           "controlType": "Button",
           "width": "150",
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
           "selectControlID": "btnBeppyoMeisaiNew",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "明細情報を追加する",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
          },
          {
           "fieldName": "btnBeppyoGokeiNew",
           "items": [],
           "controlType": "Button",
           "width": "150",
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
           "selectControlID": "btnBeppyoGokeiNew",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "合計情報を追加する",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
          },
          {
           "fieldName": "dgServiceRiyohyoBeppyoList",
           "items": [],
           "controlType": "DataGrid",
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
           "selectControlID": "dgServiceRiyohyoBeppyoList",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "height": "210",
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
             "frozenColumn": "txtService",
             "headerHeight": 1
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
              "columnName": "",
              "dataName": "btnDelete",
              "toolTip": "",
              "bgColor": 0,
              "width": 35,
              "visible": true,
              "cellType": 8,
              "cellDetails": {
               "cellType": 8,
               "text": "削",
               "onClick": "",
               "imageFileUrl": "",
               "imageWidth": "",
               "imageHeight": ""
              },
              "align": 1,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "btnDelete"
             },
             {
              "columnName": "事業者",
              "dataName": "txtJigyosha",
              "toolTip": "",
              "bgColor": 0,
              "width": 220,
              "visible": true,
              "cellType": 0,
              "cellDetails": {
               "cellType": 0
              },
              "align": 0,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtJigyosha"
             },
             {
              "columnName": "サービス",
              "dataName": "txtService",
              "toolTip": "",
              "bgColor": 0,
              "width": 220,
              "visible": true,
              "cellType": 0,
              "cellDetails": {
               "cellType": 0
              },
              "align": 0,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtService"
             },
             {
              "columnName": "単位",
              "dataName": "txtTani",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtTani"
             },
             {
              "columnName": "割引適用<br>後率",
              "dataName": "txtWaribikigoRitsu",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtWaribikigoRitsu"
             },
             {
              "columnName": "割引適用<br>後単位",
              "dataName": "txtWaribikigoTani",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtWaribikigoTani"
             },
             {
              "columnName": "回数",
              "dataName": "txtKaisu",
              "toolTip": "",
              "bgColor": 0,
              "width": 60,
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
              "sortKey": "txtKaisu"
             },
             {
              "columnName": "サービス<br>単位",
              "dataName": "txtServiceTani",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtServiceTani"
             },
             {
              "columnName": "種類限度<br>超過単位",
              "dataName": "txtShuruiGendoChokaTani",
              "toolTip": "",
              "bgColor": 0,
              "width": 90,
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
              "sortKey": "txtShuruiGendoChokaTani"
             },
             {
              "columnName": "種類限度<br>内単位",
              "dataName": "txtShuruiGendonaiTani",
              "toolTip": "",
              "bgColor": 0,
              "width": 90,
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
              "sortKey": "txtShuruiGendonaiTani"
             },
             {
              "columnName": "区分限度<br>超過単位",
              "dataName": "txtKubunGendoChokaTani",
              "toolTip": "",
              "bgColor": 0,
              "width": 90,
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
              "sortKey": "txtKubunGendoChokaTani"
             },
             {
              "columnName": "区分限度<br>内単位",
              "dataName": "txtKubunGendonaiTani",
              "toolTip": "",
              "bgColor": 0,
              "width": 90,
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
              "sortKey": "txtKubunGendonaiTani"
             },
             {
              "columnName": "単位数<br>単価",
              "dataName": "txtTanisuTanka",
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
               "isComma": false,
               "decimalPointLength": "2",
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtTanisuTanka"
             },
             {
              "columnName": "費用<br>総額",
              "dataName": "txtHiyoSogaku",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtHiyoSogaku"
             },
             {
              "columnName": "給付<br>率",
              "dataName": "txtKyufuritsu",
              "toolTip": "",
              "bgColor": 0,
              "width": 60,
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
              "sortKey": "txtKyufuritsu"
             },
             {
              "columnName": "保険<br>給付額",
              "dataName": "txtHokenFutangaku",
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
               "onChange": "",
               "isSetValueToToolTip": false,
               "readOnly": true
              },
              "align": 2,
              "resize": true,
              "isPrivateInfo": false,
              "sortKey": "txtHokenFutangaku"
             },
             {
              "columnName": "利用者負担額<br>(保険対象)",
              "dataName": "txtRiyoshaFutangakuHoken",
              "toolTip": "",
              "bgColor": 0,
              "width": 110,
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
              "sortKey": "txtRiyoshaFutangakuHoken"
             },
             {
              "columnName": "利用者負担額<br>(全額)",
              "dataName": "txtRiyoshaFutangakuZengaku",
              "toolTip": "",
              "bgColor": 0,
              "width": 110,
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
              "sortKey": "txtRiyoshaFutangakuZengaku"
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
           "sortOrder": "",
           "isAscending": true,
           "filterList": [],
           "activeRowId": -1
          }
         ],
         "controlType": "Panel",
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
         "selectControlID": "ServiceRiyohyoBeppyoList",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "区分支給限度管理・利用者負担計算",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": true,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "ServiceRiyohyoBeppyoList"
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
         "height": "Auto"
        },
        {
         "fieldName": "ServiceRiyohyoBeppyoMeisai",
         "items": [
          {
           "fieldName": "txtJigyoshaCode",
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
           "selectControlID": "txtJigyoshaCode_core",
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
           "labelLWidth": "100",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "formatLength": "10"
          },
          {
           "fieldName": "btnJigyosha",
           "items": [],
           "controlType": "ButtonDialog",
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
           "selectControlID": "btnJigyosha",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "",
           "onClick": "",
           "appearance": 2,
           "imageFileUrl": "/uz/uza/image/UZ_Search.png",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": true,
           "displayChildDivName": "DBZ.JigyoshaInputGuide",
           "dataPassing": [
            {
             "key": "jigyoshaCode",
             "controlName": "txtJigyoshaCode"
            },
            {
             "key": "jigyoshaMeisho",
             "controlName": "txtJigyoshaName"
            }
           ],
           "visibleCloseButton": false,
           "onOkClose": "",
           "onBeforeOpenDialog": ""
          },
          {
           "fieldName": "txtJigyoshaName",
           "items": [],
           "controlType": "TextBox",
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
           "selectControlID": "txtJigyoshaName_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
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
           "permitCharactor": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "textKind": 0,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": ""
          },
          {
           "fieldName": "txtServiceCode",
           "items": [],
           "controlType": "TextBoxCode",
           "width": "50",
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
           "selectControlID": "txtServiceCode_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": false,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "onBlurServiceCode",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "サービス",
           "labelRText": "",
           "labelLWidth": "100",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "formatLength": "6"
          },
          {
           "fieldName": "btnService",
           "items": [],
           "controlType": "ButtonDialog",
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
           "selectControlID": "btnService",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "",
           "onClick": "",
           "appearance": 2,
           "imageFileUrl": "/uz/uza/image/UZ_Search.png",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": true,
           "displayChildDivName": "DBZ.ServiceInputGuide",
           "dataPassing": [
            {
             "key": "serviceCode",
             "controlName": "txtServiceCode"
            },
            {
             "key": "serviceMeisho",
             "controlName": "txtServiceName"
            }
           ],
           "visibleCloseButton": false,
           "onOkClose": "",
           "onBeforeOpenDialog": ""
          },
          {
           "fieldName": "txtServiceName",
           "items": [],
           "controlType": "TextBox",
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
           "selectControlID": "txtServiceName_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
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
           "permitCharactor": "",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 0,
           "textKind": 0,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": ""
          },
          {
           "fieldName": "txtTani",
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
           "selectControlID": "txtTani_core",
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
           "labelLText": "単位",
           "labelRText": " ",
           "labelLWidth": "100",
           "labelRWidth": "30",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtWaribikigoRitsu",
           "items": [],
           "controlType": "TextBoxNum",
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
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "txtWaribikigoRitsu_core",
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
           "labelLText": "【割引適用後率",
           "labelRText": "",
           "labelLWidth": "115",
           "labelRWidth": "15",
           "labelLAlign": 0,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtWaribikigoTani",
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
           "selectControlID": "txtWaribikigoTani_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "割引適用後単位",
           "labelRText": "】",
           "labelLWidth": "115",
           "labelRWidth": "15",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtKaisu",
           "items": [],
           "controlType": "TextBoxNum",
           "width": "50",
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
           "marginRight": "XL",
           "selectControlID": "txtKaisu_core",
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
           "labelLText": "回数",
           "labelRText": "",
           "labelLWidth": "100",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblKaisu",
           "items": [],
           "controlType": "Label",
           "width": "137",
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
           "marginLeft": "S",
           "marginRight": "XS",
           "selectControlID": "lblKaisu",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【月あたり】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "txtServiceTani",
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
           "marginRight": "0",
           "selectControlID": "txtServiceTani_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "サービス単位",
           "labelRText": "",
           "labelLWidth": "100",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblServiceTani",
           "items": [],
           "controlType": "Label",
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
           "selectControlID": "lblServiceTani",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【割引適用後単位×回数】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "btnCalcMeisai",
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
           "float": 0,
           "toolTip": "",
           "authorityMode": 0,
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "btnCalcMeisai",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "明細の計算",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
          },
          {
           "fieldName": "btnBeppyoMeisaiKakutei",
           "items": [],
           "controlType": "Button",
           "width": "180",
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
           "selectControlID": "btnBeppyoMeisaiKakutei",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "明細情報を確定する",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
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
         "selectControlID": "ServiceRiyohyoBeppyoMeisai",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "明細",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": true,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "ServiceRiyohyoBeppyoMeisai"
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
         "fieldName": "ServiceRiyohyoBeppyoGokei",
         "items": [
          {
           "fieldName": "txtShuruiGendoChokaTani",
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
           "selectControlID": "txtShuruiGendoChokaTani_core",
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
           "labelLText": "種類限度超過単位",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtShuruiGendonaiTani",
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
           "selectControlID": "txtShuruiGendonaiTani_core",
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
           "labelLText": "種類限度内単位",
           "labelRText": "",
           "labelLWidth": "120",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtTanisuTanka",
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
           "selectControlID": "txtTanisuTanka_core",
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
           "labelLText": "単位数単価",
           "labelRText": "",
           "labelLWidth": "80",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtKubunGendoChokaTani",
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
           "selectControlID": "txtKubunGendoChokaTani_core",
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
           "labelLText": "区分限度超過単位",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtKubunGendonaiTani",
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
           "selectControlID": "txtKubunGendonaiTani_core",
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
           "labelLText": "区分限度内単位",
           "labelRText": "",
           "labelLWidth": "120",
           "labelRWidth": "S",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtKyufuritsu",
           "items": [],
           "controlType": "TextBoxNum",
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
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "txtKyufuritsu_core",
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
           "labelLWidth": "80",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": false,
           "decimalPointLength": 0
          },
          {
           "fieldName": "txtHiyoSogaku",
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
           "selectControlID": "txtHiyoSogaku_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "費用総額",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblHiyoSogaku",
           "items": [],
           "controlType": "Label",
           "width": "390",
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
           "selectControlID": "lblHiyoSogaku",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【区分限度内単位×単位数単価】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "txtHokenKyufugaku",
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
           "selectControlID": "txtHokenKyufugaku_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "保険給付額",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblHokenKyufugaku",
           "items": [],
           "controlType": "Label",
           "width": "390",
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
           "selectControlID": "lblHokenKyufugaku",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【費用総額×給付率】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "txtRiyoshaFutangakuHoken",
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
           "selectControlID": "txtRiyoshaFutangakuHoken_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "保険対象利用者負担額",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblRiyoshaFutangakuHoken",
           "items": [],
           "controlType": "Label",
           "width": "390",
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
           "selectControlID": "lblRiyoshaFutangakuHoken",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【費用総額－保険給付額】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "txtRiyoshaFutangakuZengaku",
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
           "selectControlID": "txtRiyoshaFutangakuZengaku_core",
           "helpMessageID": "",
           "jpControlName": "",
           "readOnly": true,
           "required": false,
           "placeHolder": "",
           "isPrivateInfo": false,
           "isPassword": false,
           "onFocus": "",
           "onBlur": "",
           "onChange": "",
           "onKeyPress": "",
           "text": "",
           "labelLText": "全額利用者負担額",
           "labelRText": "",
           "labelLWidth": "160",
           "labelRWidth": "XS",
           "labelLAlign": 2,
           "labelRAlign": 0,
           "value": "",
           "permitCharactor": "+-,.\\",
           "maxLength": 100000000,
           "minLength": 0,
           "textAlign": 2,
           "textKind": 2,
           "isComboBox": false,
           "suggest": [],
           "decorationClass": "",
           "maxValue": 1.7976931348623157e+308,
           "minValue": 0,
           "isCurrency": false,
           "isComma": true,
           "decimalPointLength": 0
          },
          {
           "fieldName": "lblRiyoshaFutangakuZengaku",
           "items": [],
           "controlType": "Label",
           "width": "420",
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
           "selectControlID": "lblRiyoshaFutangakuZengaku",
           "helpMessageID": "",
           "jpControlName": "",
           "required": false,
           "isPrivateInfo": false,
           "text": "【(種類限度超過単位＋区分限度超過単位)×単位数単価】",
           "decorationClass": "",
           "align": 0
          },
          {
           "fieldName": "btnCalcGokei",
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
           "float": 0,
           "toolTip": "",
           "authorityMode": 0,
           "marginLeft": "XS",
           "marginRight": "XS",
           "selectControlID": "btnCalcGokei",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "合計の計算",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
          },
          {
           "fieldName": "btnBeppyoGokeiKakutei",
           "items": [],
           "controlType": "Button",
           "width": "180",
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
           "selectControlID": "btnBeppyoGokeiKakutei",
           "helpMessageID": "",
           "jpControlName": "",
           "text": "合計情報を確定する",
           "onClick": "",
           "appearance": 0,
           "imageFileUrl": "",
           "imageWidth": "",
           "imageHeight": "",
           "icon": 0,
           "heightTextBoxMatches": false
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
         "selectControlID": "ServiceRiyohyoBeppyoGokei",
         "helpMessageID": "",
         "jpControlName": "",
         "onLoad": "",
         "title": "合計",
         "marginTop": "Default",
         "marginBottom": "Default",
         "isOpen": true,
         "canOpenAndClose": true,
         "postParameterPanelNames": [
          {
           "postParameterPanelNames": "ServiceRiyohyoBeppyoMeisai"
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
        }
       ],
       "controlType": "TabPanel",
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
       "selectControlID": "ServiceRiyohyoBeppyo",
       "helpMessageID": "",
       "jpControlName": "",
       "title": "別表",
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
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "0",
     "marginRight": "0",
     "selectControlID": "tabServiceRiyohyo",
     "helpMessageID": "",
     "jpControlName": "",
     "onChange": "",
     "selectedItem": null,
     "tabpanelPosition": [
      "ServiceRiyohyo",
      "ServiceRiyohyoBeppyo"
     ],
     "isDraggable": false,
     "selectedItemFieldName": "",
     "initialTab": 0,
     "isLazyLoading": false
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
   "marginRight": "0",
   "selectControlID": "ServiceRiyohyoInfo",
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
     "postParameterPanelNames": "ServiceRiyohyoInfo"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    },
    {
     "eventName": "onChangeServiceRiyohyoListDayValue",
     "requestUrl": "dbc/db/dbc/ServiceRiyohyoInfo/onChangeServiceRiyohyoListDayValue"
    }
   ],
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
 "controlName": "ServiceRiyohyoInfo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoMeisai",
   "publicChildProperty": "visible",
   "newPropertyName": "BeppyoMeisaiVisible"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoMeisai",
   "publicChildProperty": "displayNone",
   "newPropertyName": "BeppyoMeisaiDisplayNone"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoGokei",
   "publicChildProperty": "visible",
   "newPropertyName": "BeppyoGokeiVisible"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoGokei",
   "publicChildProperty": "displayNone",
   "newPropertyName": "BeppyoGokeiDisplayNone"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoRiyoNissu",
   "publicChildProperty": "visible",
   "newPropertyName": "BeppyoRiyoNissuVisible"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoBeppyoRiyoNissu",
   "publicChildProperty": "displayNone",
   "newPropertyName": "BeppyoRiyoNissuDisplayNone"
  },
  {
   "publicChildFieldName": "txtKeikakuJigyoshaCode",
   "publicChildProperty": "visible",
   "newPropertyName": "KeikakuJigyoshaCodeVisible"
  },
  {
   "publicChildFieldName": "txtKeikakuJigyoshaCode",
   "publicChildProperty": "displayNone",
   "newPropertyName": "KeikakuJigyoshaCodeDisplayNone"
  },
  {
   "publicChildFieldName": "txtKeikakuJigyoshaName",
   "publicChildProperty": "visible",
   "newPropertyName": "KeikakuJigyoshaNameVisible"
  },
  {
   "publicChildFieldName": "txtKeikakuJigyoshaName",
   "publicChildProperty": "displayNone",
   "newPropertyName": "KeikakuJigyoshaNameDisplayNone"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoList",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "dgServiceRiyohyoListGridSetting"
  },
  {
   "publicChildFieldName": "btnZengetsuCopy",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickZengetsuCopy"
  },
  {
   "publicChildFieldName": "btnRiyohyoMeisaiAdd",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickRiyohyoMeisaiAdd"
  },
  {
   "publicChildFieldName": "btnBeppyoMeisaiNew",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBeppyoMeisaiNew"
  },
  {
   "publicChildFieldName": "btnBeppyoGokeiNew",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBeppyoGokeiNew"
  },
  {
   "publicChildFieldName": "btnBeppyoMeisaiKakutei",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBeppyoMeisaiKakutei"
  },
  {
   "publicChildFieldName": "btnBeppyoGokeiKakutei",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBeppyoGokeiKakutei"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoBeppyoList",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "dgServiceRiyohyoBeppyoListGridSetting"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoList",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "dgServiceRiyohyoListSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoList",
   "publicChildProperty": "onSelectBySelectButton",
   "newPropertyName": "dgServiceRiyohyoListSelectBySelect"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoList",
   "publicChildProperty": "onSelectByDeleteButton",
   "newPropertyName": "dgServiceRiyohyoListSelectByDelete"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoBeppyoList",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "dgServiceRiyohyoBeppyoListSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoBeppyoList",
   "publicChildProperty": "onSelectBySelectButton",
   "newPropertyName": "dgServiceRiyohyoBeppyoListSelectBySelect"
  },
  {
   "publicChildFieldName": "dgServiceRiyohyoBeppyoList",
   "publicChildProperty": "onSelectByDeleteButton",
   "newPropertyName": "dgServiceRiyohyoBeppyoListSelectByDelete"
  },
  {
   "publicChildFieldName": "ServiceRiyohyoInfo",
   "publicChildProperty": "eraseBorder",
   "newPropertyName": "ServiceRiyohyoEraseBorder"
  },
  {
   "publicChildFieldName": "btnCalcMeisai",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBtnCalcMeisai"
  },
  {
   "publicChildFieldName": "btnCalcGokei",
   "publicChildProperty": "onClick",
   "newPropertyName": "onClickBtnCalcGokei"
  },
  {
   "publicChildFieldName": "txtServiceCode",
   "publicChildProperty": "onBlur",
   "newPropertyName": "onBlurTxtSreviceCode"
  },
  {
   "publicChildFieldName": "",
   "publicChildProperty": "",
   "newPropertyName": ""
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

