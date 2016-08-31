/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChikuShichosonSelect {

        export class Events {

            public static onChange_DdlChiku(): string {
                return "onChange_DdlChiku";
            }

            public static onOkClose_btnChoikiGuide(): string {
                return "onOkClose_btnChoikiGuide";
            }

            public static onOkClose_btnChikuNyuryokuGuide(): string {
                return "onOkClose_btnChikuNyuryokuGuide";
            }

            public static onChange_市町村DDL(): string {
                return "onChange_市町村DDL";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChikuShichosonSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChikuShichosonSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChikuShichosonSelect.Controls.myType() + "_" + fieldName;
            }

            public ChikuShichosonSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblChushutsuJoken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            }

            public TanitsuShichoson(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson"));
            }

            public ddlChiku(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            }

            public btnChoikiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChoikiGuide"));
            }

            public btnChikuNyuryokuGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChikuNyuryokuGuide"));
            }

            public SelectedResult(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SelectedResult"));
            }

            public ddlCodeList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("ddlCodeList"));
            }

            public KoikiShichoson(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KoikiShichoson"));
            }

            public ddlShichoson(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShichoson"));
            }

            public ddlKyushichosonKoiki(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonKoiki"));
            }

        }

     }

}

