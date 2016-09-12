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

            public IsSimpleMode() {
                return new Modes.IsSimpleMode(this.controls);
            }

        }

        export module Modes {
            export class IsSimpleMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public TRUE(): void {
                    this.controls.uplUploadFile().displayNone = false;
                    this.controls.uplUploadFile1().displayNone = true;
                    this.controls.btnUpload().displayNone = false;
                    this.controls.btnUpload1().displayNone = true;
                    this.controls.lblFileName().visible = true;
                    this.controls.lblUploadFileName().visible = true;
                }

                public FALSE(): void {
                    this.controls.uplUploadFile().displayNone = true;
                    this.controls.uplUploadFile1().displayNone = false;
                    this.controls.btnUpload().displayNone = true;
                    this.controls.btnUpload1().displayNone = false;
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

