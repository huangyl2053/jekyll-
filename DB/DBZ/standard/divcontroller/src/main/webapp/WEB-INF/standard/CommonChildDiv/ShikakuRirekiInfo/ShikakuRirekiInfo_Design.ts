/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShikakuRirekiInfo {

        export class Events {

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

            public static onClick_BtnClose(): string {
                return "onClick_BtnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuRirekiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShikakuRirekiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShikakuRirekiInfo.Controls.myType() + "_" + fieldName;
            }

            public ShikakuRirekiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShikakuRirekiInfo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShikakuRirekiInfo"));
            }

            public BtnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("BtnClose"));
            }

        }

     }

}

