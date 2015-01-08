/// <reference path='KaigoSaikinShorishaRireki_Design.ts' />
module DBZ {
    export module KaigoSaikinShorishaRireki {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSaikinShorishaHyoji", () => {
                    (<any>this.controls.btnKaigoSaikinShorishaHyoji()._control).fireEvent("onClick_btnKaigoSaikinShorishaHyoji");
                });
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public priorities(): Array {
                return [
                    "DummyMode1",
                ];
            }

            public DummyMode1() {
                return new Modes.DummyMode1(this.controls);
            }
        }

        export module Modes {

            export class DummyMode1 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public val1(): void {
                }
            }
        }
    }
}
