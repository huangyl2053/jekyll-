/// <reference path='KaigoNinteiShinseishaInfo_Design.ts' />
module DBZ
{
    export module KaigoNinteiShinseishaInfo
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

            public AtenaType() {
                return new Modes.AtenaType(this.controls);
            }
        }

        export module Modes {
            export class AtenaType{
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public AtenaMode(): void {
                    this.controls.ccdKaigoNinteiAtenaInfo().AtenaType().AtenaMode;

                }

                public AtenNoneMode(): void {
                    this.controls.ccdKaigoNinteiAtenaInfo().AtenaType().AtenaNonMode;

                }
            }
        }
    }
}

module DBZ
{
    export module KaigoNinteiShinseishaInfo
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

