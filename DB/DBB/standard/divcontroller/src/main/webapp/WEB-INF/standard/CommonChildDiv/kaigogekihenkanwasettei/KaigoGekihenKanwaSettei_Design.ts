/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module KaigoGekihenKanwaSettei {

        export class Events {

            public static onClickBtnClose(): string {
                return "onClickBtnClose";
            }

            public static onClickBtnKakutei(): string {
                return "onClickBtnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoGekihenKanwaSettei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.KaigoGekihenKanwaSettei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.KaigoGekihenKanwaSettei.Controls.myType() + "_" + fieldName;
            }

            public KaigoGekihenKanwaSettei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgGekihenKanwa(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGekihenKanwa"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

