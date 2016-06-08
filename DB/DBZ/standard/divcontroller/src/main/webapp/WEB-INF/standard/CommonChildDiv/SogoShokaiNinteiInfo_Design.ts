/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiNinteiInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiNinteiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiNinteiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNinteiShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShinseiYMD"));
            }

            public txtNinteiShinseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinseiKubun"));
            }

            public txtNinteiYukoKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiYukoKubun"));
            }

            public txtNinteiChosaJissiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJissiYMD"));
            }

            public txtNinteiChosaJuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJuryoYMD"));
            }

            public txtNinteiChosaKanryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaKanryoYMD"));
            }

            public txtNinteiChosaItakusaki(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusaki"));
            }

            public txtNinteiChosain(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosain"));
            }

            public txtNinteiShujiiIryoKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujiiIryoKikan"));
            }

            public txtNinteiShujii(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujii"));
            }

            public txtNinteiIkenshoJuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoJuryoYMD"));
            }

            public txtNinteiIkenshoKanryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoKanryoYMD"));
            }

            public txtNinteiIchijiHantei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHantei"));
            }

            public txtNinteiIchijiHanteiNinchi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHanteiNinchi"));
            }

            public txtNinteiIchijiHanteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiHanteiYMD"));
            }

            public txtNinteiIchijiKanryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiKanryoYMD"));
            }

            public txtNinteiNinteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiNinteiYMD"));
            }

            public txtNinteiJotaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiJotaiKubun"));
            }

            public txtNinteiYukoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            }

            public txtNinteiIdoJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiIdoJiyu"));
            }

            public txtNinteiIdoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIdoYMD"));
            }

            public txtNinteiSoshitsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiSoshitsuYMD"));
            }

            public txtNinteiTorikeshiRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiTorikeshiRiyu"));
            }

            public txtNinteiTorikeshiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiTorikeshiYMD"));
            }

            public txtNinteiTokuteiShippei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiTokuteiShippei"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

