/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module IryoKikanDialog {

        export class Events {

            public static onSelect_dgKikanIchiran(): string {
                return "onSelect_dgKikanIchiran";
            }

            public static onSelect_dgShujiiIchiran(): string {
                return "onSelect_dgShujiiIchiran";
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
                return "IryoKikanDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IryoKikanDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IryoKikanDialog.Controls.myType() + "_" + fieldName;
            }

            public IryoKikanDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnToMentenanceChosaKikan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            }

            public dgKikanIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKikanIchiran"));
            }

            public dgShujiiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIchiran"));
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

