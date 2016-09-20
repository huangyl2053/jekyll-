/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChosaJisshishaJoho {

        export class Events {

            public static onChange_ddlChosaJisshiBasho(): string {
                return "onChange_ddlChosaJisshiBasho";
            }

            public static onChange_ddlShozokuKikan(): string {
                return "onChange_ddlShozokuKikan";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaJisshishaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType() + "_" + fieldName;
            }

            public ChosaJisshishaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtChosaJisshiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtChosaJisshiDate"));
            }

            public ddlChosaJisshiBasho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            }

            public txtJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJisshiBashoMeisho"));
            }

            public ddlShozokuKikan(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShozokuKikan"));
            }

            public ddlKinyusha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKinyusha"));
            }

            public txtChosaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaKubun"));
            }

        }

     }

}

