/// <reference path='NinteiShinseiShichosonRenrakuJoho_Design.ts' />
module DBZ
{
    export module NinteiShinseiShichosonRenrakuJoho
    {
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

                public InputMode(): void {
                    this.controls.txtRenrakujiko().readOnly = false;
                    this.controls.btnToroku().disabled = false;

                }

                public ShokaiMode(): void {
                    this.controls.txtRenrakujiko().readOnly = true;
                    this.controls.btnToroku().disabled = true;

                }
            }
        }
    }
}


module DBZ
{
    export module NinteiShinseiShichosonRenrakuJoho
    {
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

