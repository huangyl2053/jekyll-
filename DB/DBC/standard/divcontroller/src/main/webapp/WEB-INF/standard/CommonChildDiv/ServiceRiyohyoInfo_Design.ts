/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ServiceRiyohyoInfo {

        export class Events {

            public static onBlurServiceCode(): string {
                return "onBlurServiceCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceRiyohyoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType() + "_" + fieldName;
            }

            public ServiceRiyohyoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTodokedeYMD"));
            }

            public txtTekiyoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoKikan"));
            }

            public txtKeikakuJigyoshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKeikakuJigyoshaCode"));
            }

            public txtKeikakuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaName"));
            }

            public txtTaishoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoYM"));
            }

            public txtRiyohyoSakuseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoSakuseiYMD"));
            }

            public txtRiyohyoTodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoTodokedeYMD"));
            }

            public txtKubunShikyuGendogaku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKubunShikyuGendogaku"));
            }

            public txtRiyohyoSakuseisha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyohyoSakuseisha"));
            }

            public txtGendoKanriKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            }

            public btnZengetsuCopy(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZengetsuCopy"));
            }

            public tabServiceRiyohyo(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabServiceRiyohyo"));
            }

            public ServiceRiyohyo(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyo"));
            }

            public lblServiceRiyohyoList(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceRiyohyoList"));
            }

            public btnRiyohyoMeisaiAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnRiyohyoMeisaiAdd"));
            }

            public dgServiceRiyohyoList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoList"));
            }

            public ServiceRiyohyoBeppyo(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyoBeppyo"));
            }

            public ServiceRiyohyoBeppyoRiyoNissu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoRiyoNissu"));
            }

            public txtZengetsuRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuRiyoNissu"));
            }

            public txtTogetsuRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuRiyoNissu"));
            }

            public txtRuikeiRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRuikeiRiyoNissu"));
            }

            public ServiceRiyohyoBeppyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoList"));
            }

            public btnBeppyoMeisaiNew(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiNew"));
            }

            public btnBeppyoGokeiNew(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiNew"));
            }

            public dgServiceRiyohyoBeppyoList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoBeppyoList"));
            }

            public ServiceRiyohyoBeppyoMeisai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisai"));
            }

            public txtJigyoshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaCode"));
            }

            public btnJigyosha(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyosha"));
            }

            public txtJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            }

            public txtServiceCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            }

            public btnService(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnService"));
            }

            public txtServiceName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceName"));
            }

            public txtTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTani"));
            }

            public txtWaribikigoRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoRitsu"));
            }

            public txtWaribikigoTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoTani"));
            }

            public txtKaisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));
            }

            public lblKaisu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisu"));
            }

            public txtServiceTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            }

            public lblServiceTani(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceTani"));
            }

            public btnCalcMeisai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcMeisai"));
            }

            public btnBeppyoMeisaiKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiKakutei"));
            }

            public ServiceRiyohyoBeppyoGokei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokei"));
            }

            public txtShuruiGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));
            }

            public txtShuruiGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));
            }

            public txtTanisuTanka(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTanisuTanka"));
            }

            public txtKubunGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));
            }

            public txtKubunGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));
            }

            public txtKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            }

            public txtHiyoSogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));
            }

            public lblHiyoSogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHiyoSogaku"));
            }

            public txtHokenKyufugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufugaku"));
            }

            public lblHokenKyufugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenKyufugaku"));
            }

            public txtRiyoshaFutangakuHoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuHoken"));
            }

            public lblRiyoshaFutangakuHoken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuHoken"));
            }

            public txtRiyoshaFutangakuZengaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuZengaku"));
            }

            public lblRiyoshaFutangakuZengaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuZengaku"));
            }

            public btnCalcGokei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcGokei"));
            }

            public btnBeppyoGokeiKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiKakutei"));
            }

        }

     }

}

