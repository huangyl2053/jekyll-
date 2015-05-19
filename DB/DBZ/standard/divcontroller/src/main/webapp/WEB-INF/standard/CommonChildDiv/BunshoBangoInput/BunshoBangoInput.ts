/// <reference path='BunshoBangoInput_Design.ts' />
module DBZ
{
    export module BunshoBangoInput
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

            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }
        }

        export module Modes {
            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public ShudoNyuryoku(): void {
                    this.controls.txtBunshoNo().readOnly = false;
                    this.controls.btnGetBunshoNo().visible = false;
                }

                public JidoSaiban(): void {
                    this.controls.txtBunshoNo().readOnly = true;
                    this.controls.btnGetBunshoNo().visible = false;
                }

                public Kotei(): void {
                    this.controls.txtBunshoNo().readOnly = true;
                    this.controls.btnGetBunshoNo().visible = true;
                }
            }

        }
    }
}

module DBZ
{
    export module BunshoBangoInput
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

