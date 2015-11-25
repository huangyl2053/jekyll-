/// <reference path='ServiceTypeInputCommonChildDiv_Design.ts' />
module DBZ
{
    export module ServiceTypeInputCommonChildDiv
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
			public priorities(): Array<string> {
                return [
                    "State"
                ];
            }
            public State() {
                return new Modes.State(this.controls);
            }
            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
			export class State {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 入力(): void {
                    this.controls.txtServiceType().readOnly = false;
                    this.controls.btnKensaku().disabled = false;
                }

                public 照会(): void {
                    this.controls.txtServiceType().readOnly = true;
                    this.controls.btnKensaku().disabled = true;
                }
            }
        }
    }
}

module DBZ
{
    export module ServiceTypeInputCommonChildDiv
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

