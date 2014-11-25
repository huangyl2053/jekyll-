

/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='NenReiTotatsuSrchConInfo_Design.ts' />

module DBZ {
    export module NenReiTotatsuSrchConInfo {

        export class ModeController {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
        
        }

        export module Modes {

            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public KensakuInput(): void {
                    this.controls.btnKensaku().displayNone = false;
                }

                public ChushutsuInput(): void {
                    this.controls.btnKensaku().displayNone = true;
                }
            }
        }
    }
}


module DBZ {

    export module NenReiTotatsuSrchConInfo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}




