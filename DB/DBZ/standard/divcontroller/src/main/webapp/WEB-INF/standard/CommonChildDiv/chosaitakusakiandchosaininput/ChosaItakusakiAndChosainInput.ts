/// <reference path='ChosaItakusakiAndChosainInput_Design.ts' />
module DBZ
{
    export module ChosaItakusakiAndChosainInput
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

            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
          }
            export module Modes {


            export class ShoriType{
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public InputMode(): void {
                    this.controls.txtChosainCode().readOnly = false;
                    this.controls.btnChosainGuide().disabled = false;

                    this.controls.txtChosaItakusakiCode().readOnly = false;
                    this.controls.btnChosaItakusakiGuide().disabled = false;

                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.btnClear().disabled = false;
                    this.controls.btnChosainRenrakuJiko().disabled = false;

                    this.controls.btnChosainRenrakuJiko().displayNone = false;
                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                }

                public ShokaiMode():void{
                    this.controls.txtChosainCode().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;

                    this.controls.txtChosaItakusakiCode().readOnly = true;
                    this.controls.btnChosaItakusakiGuide().disabled = true;

                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;

                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnChosainRenrakuJiko().disabled = true;

                    this.controls.btnChosainRenrakuJiko().displayNone = false;
                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                }
                
                public SimpleInputMode(): void {
                    this.controls.txtChosainCode().readOnly = false;
                    this.controls.txtChosaItakusakiCode().readOnly = false;

                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.btnChosaItakusakiGuide().disabled = false;

                    this.controls.btnZenkaiFukusha().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnChosainRenrakuJiko().displayNone = true;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                }

                public SimpleShokaiMode(): void {
                    this.controls.txtChosainCode().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;

                    this.controls.txtChosaItakusakiCode().readOnly = true;
                    this.controls.btnChosaItakusakiGuide().disabled = true;

                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnChosainRenrakuJiko().disabled = true;

                    this.controls.btnZenkaiFukusha().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnChosainRenrakuJiko().displayNone = true;
                    this.controls.btnChosaItakusakiGuide().displayNone = true;
                    this.controls.btnChosainGuide().displayNone = true;

                }
            }
        }
    }
}

module DBZ
{
    export module ChosaItakusakiAndChosainInput
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