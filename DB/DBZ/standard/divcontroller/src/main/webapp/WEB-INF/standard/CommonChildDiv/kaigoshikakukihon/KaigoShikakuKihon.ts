/// <reference path='KaigoShikakuKihon_Design.ts' />
module DBZ {
    export module KaigoShikakuKihon {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
            public HihoRirekiButtonWo() {
                return new Modes.HihoRirekiButtonWo(this.controls);
            }

            public NinteiRirekiButtonWo() {
                return new Modes.NinteiRirekiButtonWo(this.controls);
            }
        }

        export module Modes {

            export class HihoRirekiButtonWo {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public HyojiSuru(): void {
                    this.controls.btnHihoRireki().displayNone = false;
                }
                
                public HyojiShinai(): void {
                    this.controls.btnHihoRireki().displayNone = true;
                }
            }

            export class NinteiRirekiButtonWo {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public HyojiSuru(): void {
                    this.controls.btnNinteiRireki().displayNone = false;
                }
                
                public HyojiShinai(): void {
                    this.controls.btnNinteiRireki().displayNone = true;
                }
            }
        }
    }

}




