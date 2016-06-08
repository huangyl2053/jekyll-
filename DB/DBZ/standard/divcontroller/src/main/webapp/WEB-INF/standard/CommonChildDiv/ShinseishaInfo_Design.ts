/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShinseishaInfo {

        export class Events {

            public static onChange_ddlShinseishaKubun(): string {
                return "onChange_ddlShinseishaKubun";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShinseishaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            }

            public ShinseishaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShinseiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));
            }

            public ddlShinseishaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));
            }

            public txtUketsukeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            }

            public txtShinseiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public btnJigyoshaInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            }

            public btnHonninJohoCopy(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));
            }

            public ddlHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            }

            public txtShinseishaNameKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));
            }

            public txtShinseishaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtAddress(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            }

        }

     }

}

