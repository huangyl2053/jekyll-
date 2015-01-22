/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShoKaishuJokyoList.ts" />
/// <reference path="./ShoKaishuJokyoShosai.ts" />

module DBZ {

     export module ShoKaishuKirokuKanri {

        export class Events {

            public static onBeforeClick_btnShoKaishuKakutei(): string {
                return "onBeforeClick_btnShoKaishuKakutei";
            }

            public static onClick_btnShoKaishuKakutei(): string {
                return "onClick_btnShoKaishuKakutei";
            }

            public static onClick_btnShoKaishuTorikeshi(): string {
                return "onClick_btnShoKaishuTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuKirokuKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuKirokuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShoKaishuJokyoList(): DBZ.ShoKaishuJokyoList.ModeController {
                return new DBZ.ShoKaishuJokyoList.ModeController(this.convFiledName("ccdShoKaishuJokyoList"));
            }

            public ccdShoKaishuJokyoShosai(): DBZ.ShoKaishuJokyoShosai.ModeController {
                return new DBZ.ShoKaishuJokyoShosai.ModeController(this.convFiledName("ccdShoKaishuJokyoShosai"));
            }

            public btnShoKaishuKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShoKaishuKakutei"));
            }

            public btnShoKaishuTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShoKaishuTorikeshi"));
            }

        }

     }

}

