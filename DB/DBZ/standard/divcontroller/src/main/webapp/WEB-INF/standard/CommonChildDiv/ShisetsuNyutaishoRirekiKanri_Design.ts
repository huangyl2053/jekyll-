/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShisetsuNyutaishoRirekiKanri {

        export class Events {

            public static onClick_btnAddShisetsuNyutaisho(): string {
                return "onClick_btnAddShisetsuNyutaisho";
            }

            public static onSelect_dgShisetsuNyutaishoRireki(): string {
                return "onSelect_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByDblClick_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByDblClick_dgShisetsuNyutaishoRireki";
            }

            public static onSelectBySelectButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByModifyButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByDeleteButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuNyutaishoRirekiKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuNyutaishoRirekiKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddShisetsuNyutaisho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            }

            public dgShisetsuNyutaishoRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            }

        }

     }

}

