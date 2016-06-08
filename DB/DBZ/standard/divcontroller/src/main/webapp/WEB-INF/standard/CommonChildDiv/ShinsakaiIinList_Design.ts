/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ShinsakaiIinList {

        export class Events {

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShinsakaiIinList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShinsakaiIinList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShinsakaiIinList.Controls.myType() + "_" + fieldName;
            }

            public ShinsakaiIinList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShinsakaiIinChildList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinChildList"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

