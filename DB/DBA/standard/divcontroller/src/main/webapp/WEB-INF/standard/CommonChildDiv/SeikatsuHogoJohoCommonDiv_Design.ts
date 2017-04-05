/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module SeikatsuHogoJohoCommonDiv {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuHogoJohoCommonDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.SeikatsuHogoJohoCommonDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.SeikatsuHogoJohoCommonDiv.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuHogoJohoCommonDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlSeikatsuHogoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlSeikatsuHogoJoho"));
            }

            public panelSeikatsuHogoIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelSeikatsuHogoIchiran"));
            }

            public dgRirekiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRirekiIchiran"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

