﻿/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='KaigoShikakuKihon_Design.ts' />

module DBZ {
    export module KaigoShikakuKihon {

        export class ModeController {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public RenrakusakiAriMode() {
                return new Modes.RenrakusakiAriMode(this.controls);
            }
            
            public HihokenrirekiNashiMode() {
                return new Modes.HihokenrirekiNashiMode(this.controls);
            }

            public NinteirirekiNashiMode() {
                return new Modes.NinteirirekiNashiMode(this.controls);
            }
        }

        export module Modes {

            export class RenrakusakiAriMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public RenrakusakiAri(): void {
                    this.controls.btnRenrakusaki().displayNone = false;

                 
                }
            }

            export class HihokenrirekiNashiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public HihokenrirekiNashi(): void {
                    this.controls.btnHihoRireki().displayNone = true;
                }
            }

            export class NinteirirekiNashiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public NinteirirekiAri(): void {
                    this.controls.btnNinteiRireki().displayNone = true;
                }
            }
        }
    }

}




