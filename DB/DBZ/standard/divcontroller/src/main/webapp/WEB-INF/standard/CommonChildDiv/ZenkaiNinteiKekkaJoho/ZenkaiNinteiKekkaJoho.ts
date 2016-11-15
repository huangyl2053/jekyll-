/// <reference path='ZenkaiNinteiKekkaJoho_Design.ts' />
module DBZ
{
    export module ZenkaiNinteiKekkaJoho
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
            
            public ShokaiButtonType() {
                return new Modes.ShokaiButtonType(this.controls);
            }
            public DivSize() {
                return new Modes.DivSize(this.controls);

            }
        }

        export module Modes {
            export class ShokaiButtonType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public ShokaiButtonMode():void {
                    this.controls.btnZenkaiShosai().displayNone = false;
                    this.controls.btnZenkaiShosai().disabled = false;
                }

                public ShokaiButtonNoneMode(): void {
                    this.controls.btnZenkaiShosai().displayNone = true;
                    this.controls.btnZenkaiShosai().disabled = false;
                }
                
                public ShokaiButtonDisabledMode(): void {
                    this.controls.btnZenkaiShosai().displayNone = false;
                    this.controls.btnZenkaiShosai().disabled = true;
                }
            }

            export class DivSize {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public ShinseiUketsuke(): void {
                    this.controls.ZenkaiNinteiKekkaJoho().width = 1050;
                }

                public ChosaKekkaToroku(): void {
                    this.controls.ZenkaiNinteiKekkaJoho().width = 1110;
                }
            }
        }
    }
}

module DBZ
{
    export module ZenkaiNinteiKekkaJoho
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

