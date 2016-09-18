/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShikakuTokusoRireki {

        export class Events {

            public static onClick_btnAddShikakuShutoku(): string {
                return "onClick_btnAddShikakuShutoku";
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

            public static onSelectByDeleteButton(): string {
                return "onSelectByDeleteButton";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
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

            public btnAddShikakuShutoku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddShikakuShutoku"));
            }

            public dgShikakuShutokuRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

