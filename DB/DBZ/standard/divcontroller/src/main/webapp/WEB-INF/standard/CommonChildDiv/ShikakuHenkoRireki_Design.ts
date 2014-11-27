/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShikakuHenkoRireki {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgHenko(): string {
                return "onSelect_dgHenko";
            }

            public static onSelectByDblClick_dgHenko(): string {
                return "onSelectByDblClick_dgHenko";
            }

            public static onSelectByModifyButton_dgHenko(): string {
                return "onSelectByModifyButton_dgHenko";
            }

            public static onSelectByDeleteButton_dgHenko(): string {
                return "onSelectByDeleteButton_dgHenko";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuHenkoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            }

            public ShikakuHenkoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgHenko(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            }

        }

     }

}

