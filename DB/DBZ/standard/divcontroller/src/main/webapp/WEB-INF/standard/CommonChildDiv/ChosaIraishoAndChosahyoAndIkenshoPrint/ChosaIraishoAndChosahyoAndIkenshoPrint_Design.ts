/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module ChosaIraishoAndChosahyoAndIkenshoPrint {

        export class Events {

            public static onChange_chkIkenshoSakuseiryoSeikyusho(): string {
                return "onChange_chkIkenshoSakuseiryoSeikyusho";
            }

            public static onChange_radJyushinKikan(): string {
                return "onChange_radJyushinKikan";
            }

            public static onChange_radTeishutsuKigen(): string {
                return "onChange_radTeishutsuKigen";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaIraishoAndChosahyoAndIkenshoPrint";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType() + "_" + fieldName;
            }

            public ChosaIraishoAndChosahyoAndIkenshoPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public InsatsuTaishoShitei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("InsatsuTaishoShitei"));
            }

            //public ccdHokenshaList(): DBZ.HokenshaList.ModeController {
            //    return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            //}

            public NinteiChosa(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            }

            public dgNinteiChosa(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiChosa"));
            }

            public NinteiChosaPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiChosaPrint"));
            }

            public chk(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk"));
            }

            public chkChosahyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkChosahyo"));
            }

            public chkOcrChosahyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkOcrChosahyo"));
            }

            public chkChosahyo2(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkChosahyo2"));
            }

            public ShujiiIkensho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiIkensho"));
            }

            public dgShujiiIkensho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIkensho"));
            }

            public ShujiiIkenshoPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiIkenshoPrint"));
            }

            public chkInsatsuIkensho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkInsatsuIkensho"));
            }

            public chkIkenshoSakuseiIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiIchiran"));
            }

            public chkIkenshoSakuseiryoSeikyusho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiryoSeikyusho"));
            }

            public ShindanMeirei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShindanMeirei"));
            }

            public radJyushinKikan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJyushinKikan"));
            }

            public txtJyushinymd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJyushinymd"));
            }

            public txtJushinTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtJushinTime"));
            }

            public spSpace1(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace1"));
            }

            public txtJushinKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushinKikan"));
            }

            public spSpace3(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace3"));
            }

            public txtJushinBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJushinBasho"));
            }

            public TeishutsuKigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TeishutsuKigen"));
            }

            public radTeishutsuKigen(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeishutsuKigen"));
            }

            public spSpace2(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace2"));
            }

            public txtKyotsuDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKyotsuDay"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnPrint(): UZA.ButtonPrint {
                return new UZA.ButtonPrint(this.convFiledName("btnPrint"));
            }

        }

     }

}

