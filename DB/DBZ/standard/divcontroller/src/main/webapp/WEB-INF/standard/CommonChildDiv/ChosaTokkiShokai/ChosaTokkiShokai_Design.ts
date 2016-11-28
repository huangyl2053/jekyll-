/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChosaTokkiShokai {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaTokkiShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaTokkiShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaTokkiShokai.Controls.myType() + "_" + fieldName;
            }

            public ChosaTokkiShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTokkiJikouNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
            }

            public txtTokkiJikouName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            }

            public lblTextGenpon(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextGenpon"));
            }

            public lblTextMask(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextMask"));
            }

            public txtTokkijikoNo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo1"));
            }

            public lbl1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl1"));
            }

            public txtRemban1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban1"));
            }

            public txtTextGenpo1(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo1"));
            }

            public txtTextMask1(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask1"));
            }

            public txtTokkijikoNo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo2"));
            }

            public lbl2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl2"));
            }

            public txtRemban2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban2"));
            }

            public txtTextGenpo2(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo2"));
            }

            public txtTextMask2(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask2"));
            }

            public txtTokkijikoNo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo3"));
            }

            public lbl3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl3"));
            }

            public txtRemban3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban3"));
            }

            public txtTextGenpo3(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo3"));
            }

            public txtTextMask3(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask3"));
            }

            public txtTokkijikoNo4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo4"));
            }

            public lbl4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl4"));
            }

            public txtRemban4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban4"));
            }

            public txtTextGenpo4(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo4"));
            }

            public txtTextMask4(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask4"));
            }

            public txtTokkijikoNo5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo5"));
            }

            public lbl5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl5"));
            }

            public txtRemban5(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban5"));
            }

            public txtTextGenpo5(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo5"));
            }

            public txtTextMask5(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask5"));
            }

            public txtTokkijikoNo6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo6"));
            }

            public lbl6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl6"));
            }

            public txtRemban6(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban6"));
            }

            public txtTextGenpo6(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo6"));
            }

            public txtTextMask6(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask6"));
            }

            public txtTokkijikoNo7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo7"));
            }

            public lbl7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl7"));
            }

            public txtRemban7(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban7"));
            }

            public txtTextGenpo7(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo7"));
            }

            public txtTextMask7(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask7"));
            }

            public txtTokkijikoNo8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo8"));
            }

            public lbl8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl8"));
            }

            public txtRemban8(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban8"));
            }

            public txtTextGenpo8(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo8"));
            }

            public txtTextMask8(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask8"));
            }

            public txtTokkijikoNo9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo9"));
            }

            public lbl9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl9"));
            }

            public txtRemban9(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban9"));
            }

            public txtTextGenpo9(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo9"));
            }

            public txtTextMask9(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask9"));
            }

            public txtTokkijikoNo10(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo10"));
            }

            public lbl10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl10"));
            }

            public txtRemban10(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban10"));
            }

            public txtTextGenpo10(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo10"));
            }

            public txtTextMask10(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask10"));
            }

            public txtTokkijikoNo11(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo11"));
            }

            public lbl11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl11"));
            }

            public txtRemban11(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban11"));
            }

            public imgGenpo1(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo1"));
            }

            public imgMasking1(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking1"));
            }

            public txtTokkijikoNo12(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo12"));
            }

            public lbl12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl12"));
            }

            public txtRemban12(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban12"));
            }

            public imgGenpo2(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo2"));
            }

            public imgMasking2(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking2"));
            }

            public txtTokkijikoNo13(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo13"));
            }

            public lbl13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl13"));
            }

            public txtRemban13(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban13"));
            }

            public imgGenpo3(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo3"));
            }

            public imgMasking3(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking3"));
            }

            public txtTokkijikoNo14(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo14"));
            }

            public lbl14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl14"));
            }

            public txtRemban14(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban14"));
            }

            public imgGenpo4(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo4"));
            }

            public imgMasking4(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking4"));
            }

            public txtTokkijikoNo15(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo15"));
            }

            public lbl15(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl15"));
            }

            public txtRemban15(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban15"));
            }

            public imgGenpo5(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo5"));
            }

            public imgMasking5(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking5"));
            }

            public txtTokkijikoNo16(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo16"));
            }

            public lbl16(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl16"));
            }

            public txtRemban16(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban16"));
            }

            public imgGenpo6(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo6"));
            }

            public imgMasking6(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking6"));
            }

            public txtTokkijikoNo17(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo17"));
            }

            public lbl17(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl17"));
            }

            public txtRemban17(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban17"));
            }

            public imgGenpo7(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo7"));
            }

            public imgMasking7(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking7"));
            }

            public txtTokkijikoNo18(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo18"));
            }

            public lbl18(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl18"));
            }

            public txtRemban18(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban18"));
            }

            public imgGenpo8(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo8"));
            }

            public imgMasking8(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking8"));
            }

            public txtTokkijikoNo19(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo19"));
            }

            public lbl19(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl19"));
            }

            public txtRemban19(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban19"));
            }

            public imgGenpo9(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo9"));
            }

            public imgMasking9(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking9"));
            }

            public txtTokkijikoNo20(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo20"));
            }

            public lbl20(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl20"));
            }

            public txtRemban20(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban20"));
            }

            public imgGenpo10(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo10"));
            }

            public imgMasking10(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking10"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

