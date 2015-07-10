/// <reference path='KekkaShosaiJoho_Design.ts' />
module DBZ {
    export module KekkaShosaiJoho {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
        }

        export module Modes {
            export class ShoriType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public SoshitsuMode(): void {
                    this.controls.ccdNinteiInput().shoriType().InputMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().SoshitsuMode();
                    this.controls.btnToroku().displayNone = false;

                }
                public ShokkenTorikeshiInputMode(): void {
                    this.controls.ccdNinteiInput().shoriType().IchibuSoshitsuMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().TokushuTsuikaMode();
                    this.controls.btnToroku().displayNone = false;
                
                }

                public ShokaiMode(): void {
                    this.controls.ccdNinteiInput().shoriType().ShokaiMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().ShokaiMode();
                    this.controls.btnToroku().displayNone = true;
                
                }
            }
        }
    }
}
        module DBZ {
            export module KekkaShosaiJoho {
                export class PublicProperties {
                    private controls: Controls;
                    private fieldName: string;

                    constructor(fieldName: string) {
                        this.fieldName = fieldName;
                        this.controls = new Controls(fieldName);
                    }

                    public getEditTypes(): UZA.EditTypeForPublicProperty {
                        var editTypes = new UZA.EditTypeForPublicProperty();

                        return editTypes;
                    }
                }
            }
        }

    
