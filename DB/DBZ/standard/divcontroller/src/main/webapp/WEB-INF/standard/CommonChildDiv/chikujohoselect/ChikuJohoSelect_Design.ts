/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChikuJohoSelect {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChikuJohoSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType() + "_" + fieldName;
            }

            public ChikuJohoSelect(): UZA.Panel {
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

            public btnSelect(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelect"));
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

