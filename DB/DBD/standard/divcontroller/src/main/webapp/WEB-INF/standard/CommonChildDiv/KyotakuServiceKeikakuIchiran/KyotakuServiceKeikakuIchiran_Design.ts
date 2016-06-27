/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module KyotakuServiceKeikakuIchiran {

        export class Events {

            public static onClick_select(): string {
                return "onClick_select";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

            public static onClick_btnKeikakuIraiUketsuke(): string {
                return "onClick_btnKeikakuIraiUketsuke";
            }

            public static onClick_btnJikosakuseiKeikaku(): string {
                return "onClick_btnJikosakuseiKeikaku";
            }

            public static onClick_btnKyotakuService(): string {
                return "onClick_btnKyotakuService";
            }

            public static onClickClose_keikakuIraiUketsuke(): string {
                return "onClickClose_keikakuIraiUketsuke";
            }

            public static onClickClose_jikosakuseiKeikaku(): string {
                return "onClickClose_jikosakuseiKeikaku";
            }

            public static onClick_btnShuruiGendoGakuKakunin(): string {
                return "onClick_btnShuruiGendoGakuKakunin";
            }

            public static onSelect_dgKyotakuService(): string {
                return "onSelect_dgKyotakuService";
            }

            public static onClickClose_kyotakuServiceJoho(): string {
                return "onClickClose_kyotakuServiceJoho";
            }

            public static onClickClose_kyotakuServiceMeisai(): string {
                return "onClickClose_kyotakuServiceMeisai";
            }

            public static onClickClose_shuruiGendoGakuKakunin(): string {
                return "onClickClose_shuruiGendoGakuKakunin";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyotakuServiceKeikakuIchiran";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.KyotakuServiceKeikakuIchiran.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.KyotakuServiceKeikakuIchiran.Controls.myType() + "_" + fieldName;
            }

            public KyotakuServiceKeikakuIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKyotakuServiceKeikakuIchiranMain(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("dgKyotakuServiceKeikakuIchiranMain"));
            }

            public dgKyotakuServiceKeikakuIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuServiceKeikakuIchiran"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

            public DvJohoSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvJohoSelect"));
            }

            public btnKeikakuIraiUketsuke(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKeikakuIraiUketsuke"));
            }

            public btnJikosakuseiKeikaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJikosakuseiKeikaku"));
            }

            public btnKyotakuService(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKyotakuService"));
            }

            public DvKeikakuIraiUketsuke(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvKeikakuIraiUketsuke"));
            }

            public txtIraiNinteiShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIraiNinteiShinseiJokyo"));
            }

            public txtTodokedeKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTodokedeKubun"));
            }

            public txtIraiShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiShinseiDate"));
            }

            public txtKeikakuTekiyoStartDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuTekiyoStartDate"));
            }

            public txtIraiKeikakuTekiyoEndDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiKeikakuTekiyoEndDate"));
            }

            public txtKeikakuSakuseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            }

            public linLine1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine1"));
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public txtJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            }

            public txtServiceShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceShurui"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            }

            public txtKanrishaName(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKanrishaName"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtItakusakiJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtItakusakiJigyoshaNo"));
            }

            public txtItakusakiJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtItakusakiJigyoshaName"));
            }

            public txtHenkoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoDate"));
            }

            public txtHenkoRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtHenkoRiyu"));
            }

            public btnKeikakuIraiClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKeikakuIraiClose"));
            }

            public DvJikoSakuseiKeikaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvJikoSakuseiKeikaku"));
            }

            public txtJikoNinteiShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJikoNinteiShinseiJokyo"));
            }

            public linLine6(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine6"));
            }

            public txtSetteiYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSetteiYM"));
            }

            public linLine2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine2"));
            }

            public txtSakuseiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiDate"));
            }

            public txtJikoShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtJikoShinseiDate"));
            }

            public txtJikoKeikakuTekiyoStartDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJikoKeikakuTekiyoStartDate"));
            }

            public txtJikoKeikakuTekiyoEndDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJikoKeikakuTekiyoEndDate"));
            }

            public chkZanteiKeikaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkZanteiKeikaku"));
            }

            public ninteiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ninteiJoho"));
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtNinteiYukokikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukokikan"));
            }

            public btnJikoSakuseiClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJikoSakuseiClose"));
            }

            public DvKyotakuService(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvKyotakuService"));
            }

            public txtShikyuGendoGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuGendoGaku"));
            }

            public txtGendoKanriKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            }

            public tankiNyushoRiyoNissu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("tankiNyushoRiyoNissu"));
            }

            public txtZengetsuMadeRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuMadeRiyoNissu"));
            }

            public txtTogetsuKeikakuRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuKeikakuRiyoNissu"));
            }

            public txtRuisekiRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRuisekiRiyoNissu"));
            }

            public btnShuruiGendoGakuKakunin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShuruiGendoGakuKakunin"));
            }

            public dgKyotakuService(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuService"));
            }

            public btnKyotakuServiceClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceClose"));
            }

            public DvKyotakuMeisai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvKyotakuMeisai"));
            }

            public txtKyotakuJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakuJigyoshaNo"));
            }

            public txtKyotakuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyotakuJigyoshaName"));
            }

            public txtServiceCode1(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode1"));
            }

            public txtServiceCode2(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode2"));
            }

            public txtServiceName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceName"));
            }

            public txtTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTani"));
            }

            public txtWaribikiTekiyogoRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikiTekiyogoRitsu"));
            }

            public txtWaribikiTekiyogoTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikiTekiyogoTani"));
            }

            public txtKaisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));
            }

            public txtServiceTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            }

            public linLine3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine3"));
            }

            public txtShuruiGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));
            }

            public txtShuruiGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));
            }

            public txtTaniTanka(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTaniTanka"));
            }

            public txtKubunGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));
            }

            public txtKubunGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));
            }

            public txtKyufuRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            }

            public txtHiyoSogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));
            }

            public txtHokenKyufuGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuGaku"));
            }

            public txtHokenTaishoRiyoshaFutanGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoRiyoshaFutanGaku"));
            }

            public txtZengakuRiyoshaFutanngaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZengakuRiyoshaFutanngaku"));
            }

            public btnKyotakuServiceShosaiClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceShosaiClose"));
            }

            public DvShuruiGendoKakunin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvShuruiGendoKakunin"));
            }

            public dgShuruiGendoKakunin(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShuruiGendoKakunin"));
            }

            public btnShuruiGendoGakuKakuninClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShuruiGendoGakuKakuninClose"));
            }

        }

     }

}

