/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBD {

     export module HikazeiNenkinKensaku {

        export class Events {

            public static onClick_SelectedItem(): string {
                return "onClick_SelectedItem";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HikazeiNenkinKensaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType() + "_" + fieldName;
            }

            public HikazeiNenkinKensaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihokenshano(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshano"));
            }

            public txtTaishom(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaishom"));
            }

            public dgHikazeNenkinKensaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHikazeNenkinKensaku"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

