/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JushochiTokureiRireki {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgJushochiTokureiRireki(): string {
                return "onSelect_dgJushochiTokureiRireki";
            }

            public static onSelectByDblClick_dgJushochiTokureiRireki(): string {
                return "onSelectByDblClick_dgJushochiTokureiRireki";
            }

            public static onSelectBySelectButton_dgJushochiTokureiRireki(): string {
                return "onSelectBySelectButton_dgJushochiTokureiRireki";
            }

            public static onSelectByModifyButton_dgJushochiTokureiRireki(): string {
                return "onSelectByModifyButton_dgJushochiTokureiRireki";
            }

            public static onSelectByDeleteButton_dgJushochiTokureiRireki(): string {
                return "onSelectByDeleteButton_dgJushochiTokureiRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgJushochiTokureiRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJushochiTokureiRireki"));
            }

        }

     }

}

