/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ShotokuJokyo {

        export class Events {

            public static onClick_Saihyoji(): string {
                return "onClick_Saihyoji";
            }

            public static onClick_SetaiinSentaku(): string {
                return "onClick_SetaiinSentaku";
            }

            public static onClick_btnRirekiClose(): string {
                return "onClick_btnRirekiClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShotokuJokyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.ShotokuJokyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.ShotokuJokyo.Controls.myType() + "_" + fieldName;
            }

            public ShotokuJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSetaiKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSetaiKijunYMD"));
            }

            public ddShotokuNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddShotokuNendo"));
            }

            public btnSaiHyoji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            }

            public dgSetaiShotoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSetaiShotoku"));
            }

            public btnRirekiClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnRirekiClose"));
            }

        }

     }

}

