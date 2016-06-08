/// <reference path='KaigoAtesakiJushoSettei_Design.ts' />
module DBZ
{
    export module KaigoAtesakiJushoSettei
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public DisplayJushoSetteiRad() {
                return new Modes.DisplayJushoSetteiRad(this.controls);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
            export class DisplayJushoSetteiRad {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public NotDisplay(): void {
                    this.controls.radJushoSettei().displayNone = true;
                }

                public Display(): void {
                    this.controls.radJushoSettei().displayNone = false;
                }
            }
        }
    }
}

module DBZ
{
    export module KaigoAtesakiJushoSettei
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

