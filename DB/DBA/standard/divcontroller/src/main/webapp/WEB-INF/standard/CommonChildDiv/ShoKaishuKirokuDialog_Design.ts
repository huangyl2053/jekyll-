/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./ShoKaishuKirokuKanri.ts" />

module DBA {

     export module ShoKaishuKirokuDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuKirokuDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialog.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuKirokuDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdShoKaishuKiroku(): DBA.ShoKaishuKirokuKanri.ModeController {
            //    return new DBA.ShoKaishuKirokuKanri.ModeController(this.convFiledName("ccdShoKaishuKiroku"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

