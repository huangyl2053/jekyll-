/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShotokuJokyo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
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
                return this._myName + "_" + DBC.ShotokuJokyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShotokuJokyo.Controls.myType() + "_" + fieldName;
            }

            public ShotokuJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKijunYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKijunYMD"));
            }

            public txtShoriNendo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShoriNendo"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public lblSetaiinShotoku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSetaiinShotoku"));
            }

            public dgSteaiinShotoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSteaiinShotoku"));
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

