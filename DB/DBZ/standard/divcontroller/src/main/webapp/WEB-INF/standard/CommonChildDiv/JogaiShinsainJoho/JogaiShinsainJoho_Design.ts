/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JogaiShinsainJoho {

        export class Events {

            public static onClick_btnToroku(): string {
                return "onClick_btnToroku";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JogaiShinsainJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JogaiShinsainJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JogaiShinsainJoho.Controls.myType() + "_" + fieldName;
            }

            public JogaiShinsainJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ShinsakaiIinIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            }

            public btnShinkiTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShinkiTsuika"));
            }

            public dgShinsakaiIinIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            }

            public ShinsakaiIinJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinJoho"));
            }

            public txtShinsakaiIinCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinCode"));
            }

            public btnShinsakaiIinGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShinsakaiIinGuide"));
            }

            public txtShinsakaiIinName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            }

            public dgShozokuKikanIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShozokuKikanIchiran"));
            }

            public lblShozokuKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShozokuKikan"));
            }

            public btnToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToroku"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

