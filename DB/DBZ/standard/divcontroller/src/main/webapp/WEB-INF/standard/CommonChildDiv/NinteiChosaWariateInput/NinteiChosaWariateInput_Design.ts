/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiChosaWariateInput {

        export class Events {

            public static onClick_btnSearchTaishosha(): string {
                return "onClick_btnSearchTaishosha";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiChosaWariateInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiChosaWariateInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiChosaWariateInput.Controls.myType() + "_" + fieldName;
            }

            public NinteiChosaWariateInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public WariateJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("WariateJokyo"));
            }

            public txtNinteiChosainCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosainCode"));
            }

            public txtNinteiChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            }

            public txtNinteiChosaItakusakiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosaItakusakiCode"));
            }

            public txtNinteiChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            }

            public txtNinteiChosaDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaDate"));
            }

            public txtNinteiChosaTime(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaTime"));
            }

            public txtNinteiChosaTimeFrame(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaTimeFrame"));
            }

            public radYoyakuKahi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radYoyakuKahi"));
            }

            public txtNinteiChosaBiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaBiko"));
            }

            public radYoyakuJokyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radYoyakuJokyo"));
            }

            public btnSearchTaishosha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchTaishosha"));
            }

            public btnDisplayLatestInformation(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDisplayLatestInformation"));
            }

            public TaishoshaShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TaishoshaShosai"));
            }

            public txtHihoBangoNumber(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihoBangoNumber"));
            }

            public txtHihoBangoGosu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihoBangoGosu"));
            }

            public txtHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            }

            public txtNinteiShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDate"));
            }

            public txtNinteiShinseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinseiKubun"));
            }

            public txtTaishoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaishoshaName"));
            }

            public txtTaishoshaNameKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaishoshaNameKana"));
            }

            public txtBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBasho"));
            }

            public txtChushajo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChushajo"));
            }

            public txtTachiainin1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTachiainin1"));
            }

            public txtRenrakusaki1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRenrakusaki1"));
            }

            public txtTachiainin2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTachiainin2"));
            }

            public txtRenrakusaki2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRenrakusaki2"));
            }

            public txtTaishoshaShosaiMemo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTaishoshaShosaiMemo"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

        }

     }

}

