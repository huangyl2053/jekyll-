/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SetaiShotokuIchiran {

        export class Events {

            public static onClick_Saihyoji(): string {
                return "onClick_Saihyoji";
            }

            public static onClick_Hikaku(): string {
                return "onClick_Hikaku";
            }

            public static onClick_SetaiKakunin(): string {
                return "onClick_SetaiKakunin";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SetaiShotokuIchiran";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType() + "_" + fieldName;
            }

            public SetaiShotokuIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSetaiIchiranKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSetaiIchiranKijunYMD"));
            }

            public txtSetaiIchiranKazeiNendo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSetaiIchiranKazeiNendo"));
            }

            public ddlSetaiIchiranKazeiNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSetaiIchiranKazeiNendo"));
            }

            public btnSaiHyoji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            }

            public txtSetaiIchiranSetaiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSetaiIchiranSetaiCode"));
            }

            public chkSetaiIchiranAll(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSetaiIchiranAll"));
            }

            public lblSetaiIchiranMsg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSetaiIchiranMsg"));
            }

            public btnNarabeteHyoji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNarabeteHyoji"));
            }

            public dgSetaiShotoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSetaiShotoku"));
            }

        }

     }

}

