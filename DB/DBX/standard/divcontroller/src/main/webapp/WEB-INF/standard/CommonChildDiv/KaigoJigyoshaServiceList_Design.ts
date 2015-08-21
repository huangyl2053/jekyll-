/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module KaigoJigyoshaServiceList {

        export class Events {

            public static onClick_btnSettle(): string {
                return "onClick_btnSettle";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoJigyoshaServiceList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.KaigoJigyoshaServiceList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.KaigoJigyoshaServiceList.Controls.myType() + "_" + fieldName;
            }

            public KaigoJigyoshaServiceList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKaigoJigyoshaService(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKaigoJigyoshaService"));
            }

            public btnSet(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSet"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

