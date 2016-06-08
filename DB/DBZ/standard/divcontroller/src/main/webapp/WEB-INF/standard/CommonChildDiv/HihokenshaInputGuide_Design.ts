/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./HihokenshaFinder.ts" />

module DBZ {

     export module HihokenshaInputGuide {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HihokenshaInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType() + "_" + fieldName;
            }

            public HihokenshaInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public HihokenshaFinder(): DBZ.HihokenshaFinder.ModeController {
            //    return new DBZ.HihokenshaFinder.ModeController(this.convFiledName("HihokenshaFinder"));
            //}

            public lblSearchResultOfHihokensha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSearchResultOfHihokensha"));
            }

            public dgSearchResultOfHihokensha(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOfHihokensha"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

