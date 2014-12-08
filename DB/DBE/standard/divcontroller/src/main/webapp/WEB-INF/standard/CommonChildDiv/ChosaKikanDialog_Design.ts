/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKikanDialog {

        export class Events {

            public static onSelect_dgKikanIchiran(): string {
                return "onSelect_dgKikanIchiran";
            }

            public static onSelect_dgChosainIchiran(): string {
                return "onSelect_dgChosainIchiran";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaKikanDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ChosaKikanDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaKikanDialog.Controls.myType() + "_" + fieldName;
            }

            public ChosaKikanDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnToMentenanceChosaKikan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            }

            public dgKikanIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKikanIchiran"));
            }

            public dgChosainIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgChosainIchiran"));
            }

            public btnSelectKikan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelectKikan"));
            }

            public btnNonSelectReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            }

        }

     }

}

