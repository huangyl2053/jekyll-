/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoTeikeibun {

        export class Events {

            public static onChange_ddlTeikenbunShubetsu(): string {
                return "onChange_ddlTeikenbunShubetsu";
            }

            public static onSelectBySB_Teikeibun(): string {
                return "onSelectBySB_Teikeibun";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoTeikeibun";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType() + "_" + fieldName;
            }

            public KaigoTeikeibun(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlTeikenbunShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTeikenbunShubetsu"));
            }

            public dgTeikeibun(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTeikeibun"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

