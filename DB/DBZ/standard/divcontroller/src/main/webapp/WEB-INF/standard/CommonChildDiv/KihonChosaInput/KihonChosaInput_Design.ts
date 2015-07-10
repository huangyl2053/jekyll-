/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonChosaInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KihonChosaIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KihonChosaIchiran"));
            }

            public dgKihonChosaKomokuIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKihonChosaKomokuIchiran"));
            }

            public btnNextGun(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNextGun"));
            }

            public TokkiJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokkiJiko"));
            }

            public dgHanrei(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHanrei"));
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

            public lblTextTokkiJikoGun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoGun"));
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

            public lblTextTokkiJikoNaiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoNaiyo"));
            }

            public btnTeikeiBunGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikeiBunGuide"));
            }

            public celTokkijikoInput(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokkijikoInput"));
            }

            public txtTokkijikoInput(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInput"));
            }

            public btnTextMasking(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTextMasking"));
            }

            public btnBeforeTextTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
            }

            public lblTextCurrentHyojiNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextCurrentHyojiNo"));
            }

            public lblTextMaxPerCurrent(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextMaxPerCurrent"));
            }

            public lblTextMaxHyojino(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextMaxHyojino"));
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

            public lblImageTokkiJikkoGun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikkoGun"));
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

            public lblTokkiJikoNaiyomage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokkiJikoNaiyomage"));
            }

            public celimgMaskingImage(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celimgMaskingImage"));
            }

            public imgMaskingImage(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgMaskingImage"));
            }

            public btnBeforeImageTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeImageTokkiJiko"));
            }

            public lblImageCurrentHyojiNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageCurrentHyojiNo"));
            }

            public lblImageMaxPerCurrent(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageMaxPerCurrent"));
            }

            public lblImageTokkiNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageTokkiNo"));
            }

            public btnImageMasking(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnImageMasking"));
            }

            public btnAfterImageTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterImageTokkiJiko"));
            }

            public btnSakujo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSakujo"));
            }

            public btnHozon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHozon"));
            }

        }

     }

}

