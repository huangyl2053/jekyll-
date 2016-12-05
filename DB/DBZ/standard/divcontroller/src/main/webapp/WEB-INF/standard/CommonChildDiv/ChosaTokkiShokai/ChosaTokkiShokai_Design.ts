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

            public textPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("textPanel"));
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

            public imgPanel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("imgPanel1"));
            }

            public lblImgGenpon(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImgGenpon"));
            }

            public lblImgMask(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImgMask"));
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

            public genpoPanel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel1"));
            }

            public imgGenpo1(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo1"));
            }

            public maskPanel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel1"));
            }

            public imgMasking1(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking1"));
            }

            public LabelNoImage1(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage1"));
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

            public genpoPanel2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel2"));
            }

            public imgGenpo2(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo2"));
            }

            public maskPanel2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel2"));
            }

            public imgMasking2(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking2"));
            }

            public LabelNoImage2(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage2"));
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

            public genpoPanel3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel3"));
            }

            public imgGenpo3(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo3"));
            }

            public maskPanel3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel3"));
            }

            public imgMasking3(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking3"));
            }

            public LabelNoImage3(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage3"));
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

            public genpoPanel4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel4"));
            }

            public imgGenpo4(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo4"));
            }

            public maskPanel4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel4"));
            }

            public imgMasking4(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking4"));
            }

            public LabelNoImage4(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage4"));
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

            public genpoPanel5(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel5"));
            }

            public imgGenpo5(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo5"));
            }

            public maskPanel5(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel5"));
            }

            public imgMasking5(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking5"));
            }

            public LabelNoImage5(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage5"));
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

            public genpoPanel6(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel6"));
            }

            public imgGenpo6(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo6"));
            }

            public maskPanel6(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel6"));
            }

            public imgMasking6(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking6"));
            }

            public LabelNoImage6(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage6"));
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

            public genpoPanel7(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel7"));
            }

            public imgGenpo7(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo7"));
            }

            public maskPanel7(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel7"));
            }

            public imgMasking7(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking7"));
            }

            public LabelNoImage7(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage7"));
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

            public genpoPanel8(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel8"));
            }

            public imgGenpo8(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo8"));
            }

            public maskPanel8(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel8"));
            }

            public imgMasking8(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking8"));
            }

            public LabelNoImage8(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage8"));
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

            public genpoPanel9(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel9"));
            }

            public imgGenpo9(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo9"));
            }

            public maskPanel9(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel9"));
            }

            public imgMasking9(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking9"));
            }

            public LabelNoImage9(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage9"));
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

            public genpoPanel10(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel10"));
            }

            public imgGenpo10(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo10"));
            }

            public maskPanel10(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel10"));
            }

            public imgMasking10(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking10"));
            }

            public LabelNoImage10(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage10"));
            }

            public imgPanel2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("imgPanel2"));
            }

            public lblImg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImg"));
            }

            public txtTokkijikoNo21(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo21"));
            }

            public lbl21(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl21"));
            }

            public txtRemban21(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban21"));
            }

            public genpoPanel11(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel11"));
            }

            public imgGenpo11(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo11"));
            }

            public maskPanel11(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel11"));
            }

            public imgMasking11(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking11"));
            }

            public LabelNoImage11(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage11"));
            }

            public txtTokkijikoNo22(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo22"));
            }

            public lbl22(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl22"));
            }

            public txtRemban22(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban22"));
            }

            public genpoPanel12(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel12"));
            }

            public imgGenpo12(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo12"));
            }

            public maskPanel12(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel12"));
            }

            public imgMasking12(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking12"));
            }

            public LabelNoImage12(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage12"));
            }

            public txtTokkijikoNo23(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo23"));
            }

            public lbl23(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl23"));
            }

            public txtRemban23(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban23"));
            }

            public genpoPanel13(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel13"));
            }

            public imgGenpo13(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo13"));
            }

            public maskPanel13(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel13"));
            }

            public imgMasking13(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking13"));
            }

            public LabelNoImage13(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage13"));
            }

            public txtTokkijikoNo24(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo24"));
            }

            public lbl24(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl24"));
            }

            public txtRemban24(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban24"));
            }

            public genpoPanel14(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel14"));
            }

            public imgGenpo14(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo14"));
            }

            public maskPanel14(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel14"));
            }

            public imgMasking14(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking14"));
            }

            public LabelNoImage14(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage14"));
            }

            public txtTokkijikoNo25(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo25"));
            }

            public lbl25(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl25"));
            }

            public txtRemban25(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban25"));
            }

            public genpoPanel15(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel15"));
            }

            public imgGenpo15(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo15"));
            }

            public maskPanel15(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel15"));
            }

            public imgMasking15(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking15"));
            }

            public LabelNoImage15(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage15"));
            }

            public txtTokkijikoNo26(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo26"));
            }

            public lbl26(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl26"));
            }

            public txtRemban26(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban26"));
            }

            public genpoPanel16(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel16"));
            }

            public imgGenpo16(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo16"));
            }

            public maskPanel16(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel16"));
            }

            public imgMasking16(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking16"));
            }

            public LabelNoImage16(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage16"));
            }

            public txtTokkijikoNo27(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo27"));
            }

            public lbl27(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl27"));
            }

            public txtRemban27(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban27"));
            }

            public genpoPanel17(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel17"));
            }

            public imgGenpo17(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo17"));
            }

            public maskPanel17(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel17"));
            }

            public imgMasking17(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking17"));
            }

            public LabelNoImage17(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage17"));
            }

            public txtTokkijikoNo28(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo28"));
            }

            public lbl28(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl28"));
            }

            public txtRemban28(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban28"));
            }

            public genpoPanel18(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel18"));
            }

            public imgGenpo18(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo18"));
            }

            public maskPanel18(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel18"));
            }

            public imgMasking18(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking18"));
            }

            public LabelNoImage18(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage18"));
            }

            public txtTokkijikoNo29(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo29"));
            }

            public lbl29(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl29"));
            }

            public txtRemban29(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban29"));
            }

            public genpoPanel19(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel19"));
            }

            public imgGenpo19(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo19"));
            }

            public maskPanel19(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel19"));
            }

            public imgMasking19(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking19"));
            }

            public LabelNoImage19(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage19"));
            }

            public txtTokkijikoNo30(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo30"));
            }

            public lbl30(): UZA.Label {
                return new UZA.Label(this.convFiledName("lbl30"));
            }

            public txtRemban30(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban30"));
            }

            public genpoPanel20(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("genpoPanel20"));
            }

            public imgGenpo20(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpo20"));
            }

            public maskPanel20(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("maskPanel20"));
            }

            public imgMasking20(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMasking20"));
            }

            public LabelNoImage20(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelNoImage20"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

