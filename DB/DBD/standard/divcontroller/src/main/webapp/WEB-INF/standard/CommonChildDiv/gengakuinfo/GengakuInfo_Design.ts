/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module GengakuInfo {

        export class Events {

            public static onClick_btnKensaku(): string {
                return "onClick_btnKensaku";
            }

            public static onSelect_dgGenGaku(): string {
                return "onSelect_dgGenGaku";
            }

            public static onClick_chkHyojiKirikae(): string {
                return "onClick_chkHyojiKirikae";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "GengakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.GengakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.GengakuInfo.Controls.myType() + "_" + fieldName;
            }

            public GengakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TainoNendo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoNendo"));
            }

            public txtHanteiKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public dgGenGaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGenGaku"));
            }

            public GenGakuKeisan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GenGakuKeisan"));
            }

            public ChoshuKenKeimetsuKikan1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan1"));
            }

            public lblChoShushometsu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu1"));
            }

            public txtChoShushometsu1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu1"));
            }

            public Kakesan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kakesan"));
            }

            public lblKakesan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakesan"));
            }

            public ChoshuKenKeimetsuKikan2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan2"));
            }

            public ChoshuKenKeimetsuKikan3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan3"));
            }

            public lblChoShushometsu2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu2"));
            }

            public txtChoShushometsu2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu2"));
            }

            public lblLine(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLine"));
            }

            public ChoshuKenKeimetsuKikan4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan4"));
            }

            public lblChoShushometsu3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChoShushometsu3"));
            }

            public txtChoShushometsu3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu3"));
            }

            public Kasan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kasan"));
            }

            public lblKasan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKasan"));
            }

            public NofuZumiKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NofuZumiKikan"));
            }

            public lblNofuZumiKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNofuZumiKikan"));
            }

            public txtNofuZumiKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuZumiKikan"));
            }

            public GnegakuKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GnegakuKikan"));
            }

            public lblKeisanShiki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKeisanShiki"));
            }

            public GenGakuKikan2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GenGakuKikan2"));
            }

            public lblGenGakuKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenGakuKikan"));
            }

            public txtGenGakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenGakuKikan"));
            }

            public TainoGengakuShosaiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo"));
            }

            public chkHyojiKirikae(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHyojiKirikae"));
            }

            public txtNendo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNendo"));
            }

            public dgTainoShosaiInfo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTainoShosaiInfo"));
            }

            public tblComment(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblComment"));
            }

            public celTainocolorKanno(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorKanno"));
            }

            public TainocolorKanno(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            }

            public celWhite(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celWhite"));
            }

            public lblColorWhite(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblColorWhite"));
            }

            public celTainoSetsumeiKanno(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKanno"));
            }

            public lblTainoSetsumeiKanno(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKanno"));
            }

            public celTainocolorMitorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorMitorai"));
            }

            public TainocolorMitorai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            }

            public celDummyYellow(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyYellow"));
            }

            public lblDummyYellow(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            }

            public celTainoSetsumeiMiTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiMiTorai"));
            }

            public lblTainoSetsumeiMiTorai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiMiTorai"));
            }

            public celTainocolorTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorTorai"));
            }

            public TainocolorTorai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorTorai"));
            }

            public celDummyRed(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyRed"));
            }

            public lblDummyRed(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            }

            public celTainoSetsumeiTorai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTorai"));
            }

            public lblTainoSetsumeiTorai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTorai"));
            }

            public celTainocolorTaishoGai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorTaishoGai"));
            }

            public TainocolorTaishoGai(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorTaishoGai"));
            }

            public celLightSalmon(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celLightSalmon"));
            }

            public lblLightSalmon(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLightSalmon"));
            }

            public celTainoSetsumeiTaishoGai(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTaishoGai"));
            }

            public lblTainoSetsumeiTaishoGai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTaishoGai"));
            }

            public celTainocolorKano(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainocolorKano"));
            }

            public TainocolorKano(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            }

            public celDummyGreen(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDummyGreen"));
            }

            public lblDummyGreen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            }

            public celTainoSetsumeiKano(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKano"));
            }

            public lblTainoSetsumeiKano(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKano"));
            }

            public Modoru(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Modoru"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

