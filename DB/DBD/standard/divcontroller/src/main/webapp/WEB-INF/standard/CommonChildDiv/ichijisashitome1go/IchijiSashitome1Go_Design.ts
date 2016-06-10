/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module IchijiSashitome1Go {

        export class Events {

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

            public SashitomeTorokuOrKojoToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SashitomeTorokuOrKojoToroku"));
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

            public dgKyufuIchijiSashitomeTorokuOrHokenryoKojoToroku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKyufuIchijiSashitomeTorokuOrHokenryoKojoToroku"));
            }

            public ShokanJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShokanJoho"));
            }

            public lblKyufuIchijiSashitomeTorokuShokanJoho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuIchijiSashitomeTorokuShokanJoho"));
            }

            public txtKyufuIchijiSashitomeTorokuSagakuGokeiKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuIchijiSashitomeTorokuSagakuGokeiKingaku"));
            }

            public dgSashitomeOrKojoJokyoShokai(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSashitomeOrKojoJokyoShokai"));
            }

            public SashitomeTorokuOrKojoTorokuOrKojoJokyoShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SashitomeTorokuOrKojoTorokuOrKojoJokyoShokai"));
            }

            public txtSashitomeTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSashitomeTorokuKubun"));
            }

            public txtSashitomeTorokuSashitomeTorokubi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuSashitomeTorokubi"));
            }

            public txtSashitomeTorokuSashitomeNofuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuSashitomeNofuKigen"));
            }

            public txtSashitomeTorokuTuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuTuchiHakkobi"));
            }

            public txtKojoTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojoTorokuKubun"));
            }

            public txtKojoTorokuKojoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuKojoKetteibi"));
            }

            public txtKojoTorokuHokenshoTeishutsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuHokenshoTeishutsuKigen"));
            }

            public txtKojoTorokuTuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuTuchiHakkobi"));
            }

            public ddlKojoTorokuKojoNo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKojoTorokuKojoNo"));
            }

            public SashitomeToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SashitomeToroku"));
            }

            public txtSashitomeKojoJokyoShokaiSashitomeTorokubi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeTorokubi"));
            }

            public txtSashitomeKojoJokyoShokaiSashitomeNofuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeNofuKigen"));
            }

            public txtSashitomeKojoJokyoShokaiSashitomeTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeTorokuTsuchiHakkobi"));
            }

            public SasitomeKaijo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SasitomeKaijo"));
            }

            public txtSashitomeKojoJokyoShokaiSashitomeKaijobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeKaijobi"));
            }

            public Kojotoroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kojotoroku"));
            }

            public txtSashitomeKojoJokyoShokaiKojoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiKojoKetteibi"));
            }

            public txtSashitomeKojoJokyoShokaiHokenshoTeishutsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiHokenshoTeishutsuKigen"));
            }

            public txtSashitomeKojoJokyoShokaiKojoTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiKojoTorokuTsuchiHakkobi"));
            }

            public txtSashitomeOrKojoJokyoShokaiKojoTorokuKojoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSashitomeOrKojoJokyoShokaiKojoTorokuKojoNo"));
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

