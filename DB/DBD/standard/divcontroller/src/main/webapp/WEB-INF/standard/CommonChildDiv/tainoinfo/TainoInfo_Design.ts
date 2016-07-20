/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module TainoInfo {

        export class Events {

            public static onClick_btnKensaku(): string {
                return "onClick_btnKensaku";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TainoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.TainoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.TainoInfo.Controls.myType() + "_" + fieldName;
            }

            public TainoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHanteiKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public btnDispGengakuJoho(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnDispGengakuJoho"));
            }

            public txtSaikoNokigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSaikoNokigen"));
            }

            public txtKeikaNen(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikaNen"));
            }

            public txtKeikaTsuki(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikaTsuki"));
            }

            public linTaino1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linTaino1"));
            }

            public txtFukaNendo(): UZA.TextBoxFlexibleYear {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo"));
            }

            public txtFukaNendo2(): UZA.TextBoxFlexibleYear {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo2"));
            }

            public txtFukaNendo1(): UZA.TextBoxFlexibleYear {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo1"));
            }

            public dgTainoJokyo3(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo3"));
            }

            public dgTainoJokyo2(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo2"));
            }

            public dgTainoJokyo1(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo1"));
            }

            public txtSonotaHokenryo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotaHokenryo"));
            }

            public txtSonotatainoGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotatainoGaku"));
            }

            public TainoSetsumei(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainoSetsumei"));
            }

            public celTainoSetsumei1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei1"));
            }

            public TainocolorKanno(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            }

            public WhiteCell(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("WhiteCell"));
            }

            public lblDummyWhite(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyWhite"));
            }

            public TainocolorMino(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorMino"));
            }

            public RedCell(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("RedCell"));
            }

            public lblDummyRed(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            }

            public celTainoSetsumei2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei2"));
            }

            public lblMassage1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMassage1"));
            }

            public lblMassage2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMassage2"));
            }

            public celTainoSetsumei3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei3"));
            }

            public TainocolorMitorai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            }

            public YellowCell(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("YellowCell"));
            }

            public lblDummyYellow(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            }

            public TainocolorKano(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            }

            public GreenCell1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("GreenCell1"));
            }

            public lblDummyGreen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            }

            public celTainoSetsumei4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei4"));
            }

            public lblMassage3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMassage3"));
            }

            public lblMassage4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMassage4"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

