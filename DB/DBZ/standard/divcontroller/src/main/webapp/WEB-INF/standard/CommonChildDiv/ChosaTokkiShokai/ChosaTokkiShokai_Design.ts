/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

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

            public TestTokki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TestTokki"));
            }

            public lblTextTokkiJikoTitle(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoTitle"));
            }

            public txtTokkiJikouNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
            }

            public lblTextTokkiJikoHyphen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoHyphen"));
            }

            public txtTokkiJikoNoText(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoText"));
            }

            public txtTokkiJikouName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            }

            public txtTokkijikoInputGenpo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputGenpo"));
            }

            public txtTokkijikoInputMask(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputMask"));
            }

            public btnBeforeTextTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
            }

            public btnAfterTextTokkiJiko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterTextTokkiJiko"));
            }

            public btnBeforeTokkiJikoNoText(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeTokkiJikoNoText"));
            }

            public btnAfterTokkiJikoNoText(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterTokkiJikoNoText"));
            }

            public lblImageTokkiJikoTitle(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikoTitle"));
            }

            public ImageTokki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki"));
            }

            public txtTokkiJikouNoImage(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNoImage"));
            }

            public lblTokkiJikoHyphenImage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokkiJikoHyphenImage"));
            }

            public txtTokkiJikoNoImage(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoImage"));
            }

            public txtTokkiJikouNameImage(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNameImage"));
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

            public btnBeforeTokkiJikoNoImg(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeforeTokkiJikoNoImg"));
            }

            public btnAfterTokkiJikoNoImg(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterTokkiJikoNoImg"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

