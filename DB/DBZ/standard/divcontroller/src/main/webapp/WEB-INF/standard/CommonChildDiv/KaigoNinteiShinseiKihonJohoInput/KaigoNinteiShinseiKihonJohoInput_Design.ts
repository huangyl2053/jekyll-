/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoNinteiShinseiKihonJohoInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNinteiShinseiKihonJohoInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoNinteiShinseiKihonJohoInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoNinteiShinseiKihonJohoInput.Controls.myType() + "_" + fieldName;
            }

            public KaigoNinteiShinseiKihonJohoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radShinseishoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseishoKubun"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public ddlShinseiShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiShubetsu"));
            }

            public ddlShinseiKubunShinseiji(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKubunShinseiji"));
            }

            public ddlShinseiKubunHorei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKubunHorei"));
            }

            public chkKyuSochisha(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKyuSochisha"));
            }

            public ddlHihokenshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaKubun"));
            }

            public chkShikakuShutokuMae(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShikakuShutokuMae"));
            }

            public ddlTokuteiShippei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));
            }

            public txtShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiJokyo"));
            }

            public ServiceSakujo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceSakujo"));
            }

            public btnServiceSakujoTeikeibun(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnServiceSakujoTeikeibun"));
            }

            public txtServiceSakujo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtServiceSakujo"));
            }

            public NinteiShinseiRiyu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiShinseiRiyu"));
            }

            public btnNinteiShinseiRiyuTeikeibun(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiShinseiRiyuTeikeibun"));
            }

            public txtNinteiShinseRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinseRiyu"));
            }

        }

     }

}

