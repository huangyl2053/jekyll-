/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShikakuTokusoRireki {

        export class Events {

            public static onLoad_ShikakuShutokuTaishoshaJoho(): string {
                return "onLoad_ShikakuShutokuTaishoshaJoho";
            }

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgShikakuShutokuRireki(): string {
                return "onSelect_dgShikakuShutokuRireki";
            }

            public static onSelectByDblClick_dgShikakuShutokuRireki(): string {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            }

            public static onSelectByModifyButton_dgShikakuShutokuRireki(): string {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            }

            public static onSelectByDeleteButton_dgShikakuShutokuRireki(): string {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuTokusoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType() + "_" + fieldName;
            }

            public ShikakuTokusoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgShikakuShutokuRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            }

        }

     }

}

