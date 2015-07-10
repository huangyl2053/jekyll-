/// <reference path='NinteiShinseiTodokedesha_Design.ts' />
module DBZ {
    export module NinteiShinseiTodokedesha {
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
            public AtenaType() {
                return new Modes.AtenaType(this.controls);
            }

        }

        export module Modes {

            export class ShoriType {

                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public InputMode() {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = false;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtHonninKankeisei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                }

                public ShgokaiMode() {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtHonninKankeisei().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }
            }
            export class AtenaType {

                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public AtenaMode(): void {


                }

                public AtenaNonMode(): void {
                

                }

            }


        }
    }
}

module DBZ
{
    export module NinteiShinseiTodokedesha
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

