/// <reference path='HokenshaJoho_Design.ts' />
module DBZ
{
    export module HokenshaJoho
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

                public reference (): void {
                    this.controls.btnHokenshaSelect().visible = false;
                }

                public modify (): void {
                    this.controls.btnHokenshaSelect().visible = true;
                }
            }
        
        }
    }
}

module DBZ
{
    export module HokenshaJoho
    {
        export class PublicProperties {
            private controls: Controls;
            

            constructor(fieldName: string) {
                
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("HokenshaNo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("HokenshaNo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("HokenshaNo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }
            
            public getHokenshaNo_labelLText = function () {
                return this.controls.txtHokenshaNo().labelLText;
            }
            
            public setHokenshaNo_labelLText = function (value) {
                this.controls.txtHokenshaNo().labelLText = value;
            }
            
             public getHokenshaNo_labelLWidth = function () {
                return this.controls.txtHokenshaNo().labelLWidth;
            }
            
            public setHokenshaNo_labelLWidth = function (value) {
                this.controls.txtHokenshaNo().labelLWidth = value;
            }
			 public getHokenshaNo_required = function () {
                return this.controls.txtHokenshaNo().required;
            }
            
            public setHokenshaNo_required = function (value) {
                this.controls.txtHokenshaNo().required = value;
            }
        }
    }
}

