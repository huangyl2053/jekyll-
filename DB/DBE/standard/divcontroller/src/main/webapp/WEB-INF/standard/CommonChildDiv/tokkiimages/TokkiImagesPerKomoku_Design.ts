/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module TokkiImagesPerKomoku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokkiImagesPerKomoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.TokkiImagesPerKomoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokkiImagesPerKomoku.Controls.myType() + "_" + fieldName;
            }

            public TokkiImagesPerKomoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo1"));
            }

            public txtRemban1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban1"));
            }

            public ImageTokki1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki1"));
            }

            public imgTokki1(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki1"));
            }

            public txtNewRemban1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban1"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            }

            public txtNo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo2"));
            }

            public txtRemban2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban2"));
            }

            public ImageTokki2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki2"));
            }

            public imgTokki2(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki2"));
            }

            public txtNewRemban2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban2"));
            }

            public lin3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            }

            public txtNo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo3"));
            }

            public txtRemban3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban3"));
            }

            public ImageTokki3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki3"));
            }

            public imgTokki3(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki3"));
            }

            public txtNewRemban3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban3"));
            }

            public lin4(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin4"));
            }

            public txtNo4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo4"));
            }

            public txtRemban4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban4"));
            }

            public ImageTokki4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki4"));
            }

            public imgTokki4(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki4"));
            }

            public txtNewRemban4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban4"));
            }

            public lin5(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin5"));
            }

            public txtNo5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo5"));
            }

            public txtRemban5(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban5"));
            }

            public ImageTokki5(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki5"));
            }

            public imgTokki5(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki5"));
            }

            public txtNewRemban5(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban5"));
            }

            public lin6(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin6"));
            }

            public txtNo6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo6"));
            }

            public txtRemban6(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban6"));
            }

            public ImageTokki6(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki6"));
            }

            public imgTokki6(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki6"));
            }

            public txtNewRemban6(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban6"));
            }

            public lin7(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin7"));
            }

            public txtNo7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo7"));
            }

            public txtRemban7(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban7"));
            }

            public ImageTokki7(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki7"));
            }

            public imgTokki7(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki7"));
            }

            public txtNewRemban7(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban7"));
            }

            public lin8(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin8"));
            }

            public txtNo8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo8"));
            }

            public txtRemban8(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban8"));
            }

            public ImageTokki8(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki8"));
            }

            public imgTokki8(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki8"));
            }

            public txtNewRemban8(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban8"));
            }

            public lin9(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin9"));
            }

            public txtNo9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo9"));
            }

            public txtRemban9(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban9"));
            }

            public ImageTokki9(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ImageTokki9"));
            }

            public imgTokki9(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokki9"));
            }

            public txtNewRemban9(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban9"));
            }

        }

     }

}

