/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module DataOutputInfomation {

        export class Events {

            public static onClick_btnKakunin(): string {
                return "onClick_btnKakunin";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "DataOutputInfomation";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.DataOutputInfomation.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.DataOutputInfomation.Controls.myType() + "_" + fieldName;
            }

            public DataOutputInfomation(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public icnKanryo(): UZA.Icon {
                return new UZA.Icon(this.convFiledName("icnKanryo"));
            }

            public lblMessage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMessage"));
            }

            public btnKakunin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakunin"));
            }

        }

     }

}

