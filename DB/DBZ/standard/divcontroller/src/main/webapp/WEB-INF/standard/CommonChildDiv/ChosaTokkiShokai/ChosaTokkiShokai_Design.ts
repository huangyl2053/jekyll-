/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChosaTokkiShokai {

        export class Events {

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

            public TokkiJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokkiJiko"));
            }

            public tblTextTokkiJiko(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTextTokkiJiko"));
            }

            public celTextTokkiJikoTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoTitle"));
            }

            public lblTextTokkiJikoTitle(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoTitle"));
            }

            public celTextTokkiJikoGun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoGun"));
            }

            public txtTokkiJikouNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
            }

            public celTextTokkiJikoHyphen(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoHyphen"));
            }

            public lblTextTokkiJikoHyphen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoHyphen"));
            }

            public celTokkiJikoNoText(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokkiJikoNoText"));
            }

            public txtTokkiJikoNoText(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoText"));
            }

            public celTextTokkiJikoNaiyo(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoNaiyo"));
            }

            public txtTokkiJikouName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            }

            public celTokkijikoInput(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokkijikoInput"));
            }

            public txtTokkijikoInputGenpo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputGenpo"));
            }

            public txtTokkijikoInputMasking(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputMasking"));
            }

            public btnBeforeTextTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
            }

            public btnAfterTextTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterTextTokkiJiko"));
            }

            public linHolizontal(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHolizontal"));
            }

            public tblTokkiJiko(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTokkiJiko"));
            }

            public celImageTokkiJikoTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikoTitle"));
            }

            public lblImageTokkiJikoTitle(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikoTitle"));
            }

            public celImageTokkiJikkoGun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoGun"));
            }

            public txtTokkiJikouNoImage(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNoImage"));
            }

            public celImageTokkiJikkoHyphen(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoHyphen"));
            }

            public lblImageTokkiJikkoHyphen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikkoHyphen"));
            }

            public celImageTokkiJikkoNo(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoNo"));
            }

            public lblImageTokkiJikkoNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("lblImageTokkiJikkoNo"));
            }

            public celTokkiJikoNaiyomage(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokkiJikoNaiyomage"));
            }

            public txtTokkiJikouNameImage(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNameImage"));
            }

            public celimgMaskingImage(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celimgMaskingImage"));
            }

            public imgGenpoImage(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgGenpoImage"));
            }

            public imgMaskingImage(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMaskingImage"));
            }

            public btnBeforeImageTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeImageTokkiJiko"));
            }

            public btnAfterImageTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterImageTokkiJiko"));
            }

            public btnSakujo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSakujo"));
            }

        }

     }

}

