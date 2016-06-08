/// <reference path='KaigoUploadPanel_Design.ts' />
module DBZ
{
    export module KaigoUploadPanel
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

            public priorities(): Array {
                return [
                    "isSimpleMode"
                ];
            }

            public isSimpleMode() {
                return new Modes.isSimpleMode(this.controls);
            }

        }

        export module Modes {
            export class isSimpleMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public TRUE(): void {
                    this.controls.lblFileName().visible = true;
                    this.controls.lblUploadFileName().visible = true;
                }

                public FALSE(): void {
                    this.controls.lblFileName().visible = false;
                    this.controls.lblUploadFileName().visible = false;
                }
            }

        }
    }
}

module DBZ
{
    export module KaigoUploadPanel
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

