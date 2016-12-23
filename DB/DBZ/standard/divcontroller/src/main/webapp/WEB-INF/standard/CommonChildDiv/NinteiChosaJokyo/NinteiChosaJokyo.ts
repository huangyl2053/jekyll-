/// <reference path='NinteiChosaJokyo_Design.ts' />
module DBZ
{
    export module NinteiChosaJokyo
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

                public input(): void{
                    this.controls.NinteiChosa().readOnly = false; 
                    this.controls.HomonChosasaki().readOnly = false; 
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = false; 
                    this.controls.IchijiHantei().readOnly = false; 
                    this.controls.KaigoNinteiShinsakai().readOnly = false; 
                    this.controls.EnkiTsuchi().readOnly = false;
                    this.controls.btnAllClear().displayNone = false; 
                    this.controls.btnKakutei().displayNone = false; 
                }

                public shokai(): void{
                    this.controls.NinteiChosa().readOnly = true; 
                    this.controls.HomonChosasaki().readOnly = true; 
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = true; 
                    this.controls.IchijiHantei().readOnly = true; 
                    this.controls.KaigoNinteiShinsakai().readOnly = true; 
                    this.controls.EnkiTsuchi().readOnly = true;
                    this.controls.btnAllClear().displayNone = true; 
                    this.controls.btnKakutei().displayNone = true; 
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

