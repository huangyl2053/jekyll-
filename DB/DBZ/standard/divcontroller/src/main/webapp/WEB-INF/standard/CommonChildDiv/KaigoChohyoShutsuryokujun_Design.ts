/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module KaigoChohyoShutsuryokujun {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoChohyoShutsuryokujun";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType() + "_" + fieldName;
            }

            public KaigoChohyoShutsuryokujun(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public kaigoChohyoShutsuryokujun(): URZ.ChohyoShutsuryokujun.ModeController {
            //    return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("kaigoChohyoShutsuryokujun"));
            //}

        }

     }

}

