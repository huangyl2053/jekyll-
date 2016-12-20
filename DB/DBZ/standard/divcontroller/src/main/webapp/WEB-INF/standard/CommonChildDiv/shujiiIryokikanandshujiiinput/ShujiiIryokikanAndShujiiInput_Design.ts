/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShujiiIryokikanAndShujiiInput {

        export class Events {

            public static onBlur_txtShujiiIryokikan(): string {
                return "onBlur_txtShujiiIryokikan";
            }

            public static onOKClose_btnIryokikanGuide(): string {
                return "onOKClose_btnIryokikanGuide";
            }

            public static onClick_btnIryokikanGuide(): string {
                return "onClick_btnIryokikanGuide";
            }

            public static onOKClose_btnShujiiRenrakuJiko(): string {
                return "onOKClose_btnShujiiRenrakuJiko";
            }

            public static onBefore_btnShujiiRenrakuJiko(): string {
                return "onBefore_btnShujiiRenrakuJiko";
            }

            public static onClick_btnZankaiFukusha(): string {
                return "onClick_btnZankaiFukusha";
            }

            public static onBlur_txtShujii(): string {
                return "onBlur_txtShujii";
            }

            public static onOKClose_btnShujiiGuide(): string {
                return "onOKClose_btnShujiiGuide";
            }

            public static onClick_btnShujiiGuide(): string {
                return "onClick_btnShujiiGuide";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShujiiIryokikanAndShujiiInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiInput.Controls.myType() + "_" + fieldName;
            }

            public ShujiiIryokikanAndShujiiInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtIryoKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCode"));
            }

            public btnIryokikanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIryokikanGuide"));
            }

            public txtIryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            }

            public btnShujiiRenrakuJiko(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiRenrakuJiko"));
            }

            public btnZenkaiIrokikanJoho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZenkaiIrokikanJoho"));
            }

            public txtShujiiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCode"));
            }

            public btnShujiiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            }

            public txtShujiiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            }

            public chkShiteii(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShiteii"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

        }

     }

}

