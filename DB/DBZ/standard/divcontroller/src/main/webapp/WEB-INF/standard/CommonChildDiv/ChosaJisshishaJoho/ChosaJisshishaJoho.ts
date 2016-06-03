/// <reference path='ChosaJisshishaJoho_Design.ts' />
module DBZ
{
    export module ChosaJisshishaJoho
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

            public State() {
                return new Modes.State(this.controls);
            }


        }

        export module Modes {
           export class State {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public Input():void {
                	this.controls.txtChosaJisshiDate ().readOnly = false;
                    this.controls.ddlChosaJisshiBasho().readOnly = false;
                    this.controls.txtJisshiBashoMeisho().readOnly = false;
                    this.controls.ddlShozokuKikan().readOnly = false;
                    this.controls.ddlKinyusha().readOnly = false;
                    this.controls.txtChosaKubun().readOnly = true;
                    this.controls.txtChosaJisshiDate().required = true;
                    this.controls.ddlChosaJisshiBasho().required = true;
                    this.controls.txtJisshiBashoMeisho().required = true;
                    this.controls.ddlShozokuKikan().required = true;
                    this.controls.ddlKinyusha().required = true;
                }
                
                 public Shokai(): void {
                    this.controls.txtChosaJisshiDate().readOnly = true;
                    this.controls.ddlChosaJisshiBasho().readOnly = true;
                    this.controls.txtJisshiBashoMeisho().readOnly = true;
                    this.controls.ddlShozokuKikan().readOnly = true;
                    this.controls.ddlKinyusha().readOnly = true;
                    this.controls.txtChosaKubun().readOnly = true;
                    this.controls.txtChosaJisshiDate().required = false;
                    this.controls.ddlChosaJisshiBasho().required = false;
                    this.controls.txtJisshiBashoMeisho().required = false;
                    this.controls.ddlShozokuKikan().required = false;
                    this.controls.ddlKinyusha().required = false;
                }

            }

        }
 }
}

module DBZ
{
    export module ChosaJisshishaJoho
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

