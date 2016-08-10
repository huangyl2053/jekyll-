/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module IchijiSashitome1Go {

        export class Events {

            public static onClick_SashitomeToRoku(): string {
                return "onClick_SashitomeToRoku";
            }

            public static onClick_KaijoToRoku(): string {
                return "onClick_KaijoToRoku";
            }

            public static onClick_SashitomeKojo(): string {
                return "onClick_SashitomeKojo";
            }

            public static onClick_SelectedItem(): string {
                return "onClick_SelectedItem";
            }

            public static onClick_DeleteItem(): string {
                return "onClick_DeleteItem";
            }

            public static onOkClose_BtnTainoJokyo(): string {
                return "onOkClose_BtnTainoJokyo";
            }

            public static onBeforeOpenDialog_BtnTainoJokyo(): string {
                return "onBeforeOpenDialog_BtnTainoJokyo";
            }

            public static onClick_SashitomeToRokuKaKuTei(): string {
                return "onClick_SashitomeToRokuKaKuTei";
            }

            public static onClick_SashitomeToRokuToRiKeShi(): string {
                return "onClick_SashitomeToRokuToRiKeShi";
            }

            public static onClick_BtnKakutei(): string {
                return "onClick_BtnKakutei";
            }

            public static onClick_BtnTorikeshi(): string {
                return "onClick_BtnTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiSashitome1Go";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.IchijiSashitome1Go.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.IchijiSashitome1Go.Controls.myType() + "_" + fieldName;
            }

            public IchijiSashitome1Go(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnSashitomeToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSashitomeToroku"));
            }

            public btnKojoToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKojoToroku"));
            }

            public btnSashitomeOrKojoJokyoShokai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoJokyoShokai"));
            }

            public dgSashitomeKojoIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSashitomeKojoIchiran"));
            }

            public ShokanJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShokanJoho"));
            }

            public lblShokanJoho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShokanJoho"));
            }

            public txtSagakuKingakuGokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSagakuKingakuGokei"));
            }

            public dgShokanJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShokanJoho"));
            }

            public SashitomeKojoJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SashitomeKojoJokyo"));
            }

            public txtSashitomeTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSashitomeTorokuKubun"));
            }

            public txtSashitomeTorokuYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuYMD"));
            }

            public txtSashitomeTorokuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuTsuchiHakkoYMD"));
            }

            public txtSashitomeNofuKigenYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeNofuKigenYMD"));
            }

            public txtSashitomeKaijoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKaijoYMD"));
            }

            public txtKojoTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojoTorokuKubun"));
            }

            public txtKojoKetteiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoKetteiYMD"));
            }

            public txtKojoTorokuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuTsuchiHakkoYMD"));
            }

            public txtHokenshoTeishutsuKigenYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHokenshoTeishutsuKigenYMD"));
            }

            public ddlTorokuKojoNo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTorokuKojoNo"));
            }

            public SashitomeToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SashitomeToroku"));
            }

            public txtShokaiSashitomeTorokuYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeTorokuYMD"));
            }

            public txtShokaiSashitomeNofuKigenYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeNofuKigenYMD"));
            }

            public txtShokaiSashitomeTorokuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeTorokuTsuchiHakkoYMD"));
            }

            public SasitomeKaijo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SasitomeKaijo"));
            }

            public txtShokaiSashitomeKaijoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeKaijoYMD"));
            }

            public KojoToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KojoToroku"));
            }

            public txtShokaiKojoKetteiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiKojoKetteiYMD"));
            }

            public txtShokaiHokenshoTeishutsuKigenYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiHokenshoTeishutsuKigenYMD"));
            }

            public txtShokaiKojoTorokuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiKojoTorokuTsuchiHakkoYMD"));
            }

            public txtShokaiKojoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShokaiKojoNo"));
            }

            public TainoJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            }

            public btnTainoJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTainoJokyo"));
            }

            public btnSashitomeOrKojoJokyoShokaiClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoJokyoShokaiClose"));
            }

            public btnSashitomeOrKojoTorokuKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoTorokuKakutei"));
            }

            public btnSashitomeOrKojoTorokuTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoTorokuTorikeshi"));
            }

            public IchijiSashitome1GoKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("IchijiSashitome1GoKakutei"));
            }

            public IchijiSashitome1GoTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("IchijiSashitome1GoTorikeshi"));
            }

        }

     }

}

