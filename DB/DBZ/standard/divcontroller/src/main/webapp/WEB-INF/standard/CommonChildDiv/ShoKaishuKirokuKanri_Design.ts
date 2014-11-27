/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShoKaishuJokyoList.ts" />
/// <reference path="./ShoKaishuJokyoShosai.ts" />

module DBZ {

     export module ShoKaishuKirokuKanri {

        export class Events {

            public static onSelectByDblClick_dgShoKaishuJokyo(): string {
                return "onSelectByDblClick_dgShoKaishuJokyo";
            }

            public static onSelectBySelectButton_dgShoKaishuJokyo(): string {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            }

            public static onClick_btnUpdateShoKaishuJokyo(): string {
                return "onClick_btnUpdateShoKaishuJokyo";
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

            public ShoKaishuJokyoList(): DBZ.ShoKaishuJokyoList.ModeController {
                return new DBZ.ShoKaishuJokyoList.ModeController(this.convFiledName("ShoKaishuJokyoList"));
            }

            public ShoKaishuJokyoShosai(): DBZ.ShoKaishuJokyoShosai.ModeController {
                return new DBZ.ShoKaishuJokyoShosai.ModeController(this.convFiledName("ShoKaishuJokyoShosai"));
            }

            public btnUpdateShoKaishuJokyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdateShoKaishuJokyo"));
            }

        }

     }

}

