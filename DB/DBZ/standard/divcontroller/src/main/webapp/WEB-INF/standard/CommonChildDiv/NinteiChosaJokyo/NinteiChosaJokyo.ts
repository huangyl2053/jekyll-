/// <reference path='NinteiChosaJokyo_Design.ts' />
module DBZ
{
    export module NinteiChosaJokyo {
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
                public shokai(): void {
                    this.controls.NinteiChosaJokyo().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;
                    this.controls.btnIryoKikanGuide().disabled = true;
                    this.controls.btnItakusakiGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = true;
                }
                public input(): void {
                    this.controls.NinteiChosaJokyo().readOnly = false;
                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.btnIryoKikanGuide().disabled = false;
                    this.controls.btnItakusakiGuide().disabled = false;
                    this.controls.btnShujiiGuide().disabled = false;
                }
            }
        }
    }
}

module DBZ
{
    export module NinteiChosaJokyo
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

