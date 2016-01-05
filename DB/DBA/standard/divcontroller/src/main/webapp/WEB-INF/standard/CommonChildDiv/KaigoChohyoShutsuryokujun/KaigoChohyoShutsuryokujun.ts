/// <reference path='KaigoChohyoShutsuryokujun_Design.ts' />
module DBZ
{
    export module KaigoChohyoShutsuryokujun
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
            

            public priorities(): Array<string> {
                return [
                    "DisplayType"
                ];
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

                public SORT_ONLY() {
                    this.controls.ccdChohyoShutsuryokujun().Grid().G12();
                    this.controls.ccdChohyoShutsuryokujun().DisplayNone().SORT_ONLY();
                }

                public SHUKEI_NONE() {
                    this.controls.ccdChohyoShutsuryokujun().Grid().G12();
                    this.controls.ccdChohyoShutsuryokujun().DisplayNone().SHUKEI_NONE();
                }
            }
        }
    }
}

module DBZ
{
    export module KaigoChohyoShutsuryokujun
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

