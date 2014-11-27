/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JushochiTokureiRirekiList {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgJutoku(): string {
                return "onSelect_dgJutoku";
            }

            public static onSelectByDblClick_dgJutoku(): string {
                return "onSelectByDblClick_dgJutoku";
            }

            public static onSelectByModifyButton_dgJutoku(): string {
                return "onSelectByModifyButton_dgJutoku";
            }

            public static onSelectByDeleteButton_dgJutoku(): string {
                return "onSelectByDeleteButton_dgJutoku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgJutoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            }

        }

     }

}

