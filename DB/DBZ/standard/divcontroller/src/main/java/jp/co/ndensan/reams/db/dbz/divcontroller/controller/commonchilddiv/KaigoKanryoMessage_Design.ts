/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module KaigoKanryoMessage {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoKanryoMessage";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType() + "_" + fieldName;
            }

            public KaigoKanryoMessage(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdKanryoMessage(): URZ.KanryoMessage.ModeController {
                return new URZ.KanryoMessage.ModeController(this.convFiledName("ccdKanryoMessage"));
            }

        }

     }

}

