/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBE {

     export module ChosaIraishoAndChosahyoAndIkenshoPrint {

        export class Events {

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
                return this._myName + "_" + DBE.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType() + "_" + fieldName;
            }

            public ChosaIraishoAndChosahyoAndIkenshoPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdHokenshaList(): DBZ.HokenshaList.ModeController {
            //    return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            //}

            public InsatsuTaishoShitei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("InsatsuTaishoShitei"));
            }

            public NinteiChosa(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            }

            //public ccdChosaItakusakiAndChosainGuide(): DBZ.ChosaItakusakiAndChosainInput.ModeController {
            //    return new DBZ.ChosaItakusakiAndChosainInput.ModeController(this.convFiledName("ccdChosaItakusakiAndChosainGuide"));
            //}

            public chk(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk"));
            }

            public chkOcrChosahyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkOcrChosahyo"));
            }

            public spSpace1(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace1"));
            }

            public txtInsatsuSu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtInsatsuSu"));
            }

            public ShujiiIkensho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiIkensho"));
            }

            public dgShujiiIkensho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIkensho"));
            }

            public chkInsatsuIkensho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkInsatsuIkensho"));
            }

            public chkIkenshoSakuseiryoSeikyusho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiryoSeikyusho"));
            }

            public chkIkenshoSakuseiIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiIchiran"));
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

            public txtShiteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShiteiDay"));
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

