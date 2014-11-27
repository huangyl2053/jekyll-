/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module CompleteProcess {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "CompleteProcess";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType() + "_" + fieldName;
            }

            public CompleteProcess(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public CompleteProssessPadding(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("CompleteProssessPadding"));
            }

            public lblCompleteMessage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblCompleteMessage"));
            }

        }

     }

}

