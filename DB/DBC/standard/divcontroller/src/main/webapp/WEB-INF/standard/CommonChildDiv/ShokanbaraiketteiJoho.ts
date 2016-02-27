/// <reference path='ShokanbaraiketteiJoho_Design.ts' />
module DBC
{
    export module ShokanbaraiketteiJoho
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

			public touroku(): void {
	                    this.controls.txtKetebi().disabled = false;
	                    this.controls.rdoShikyukubun().disabled = false;
			    this.controls.txtZogenriyu().disabled = false;
			    this.controls.txtShiharaikingakugoke().disabled = false;
			    this.controls.txtZogentani().disabled = false;
			    this.controls.txtFuSyikyuriyu1().disabled = false; 
		            this.controls.txtFushikyuriyu2().disabled = true;
	                }

	                public sagakutouroku(): void {
	                    this.controls.txtKetebi().disabled = false;
	                    this.controls.rdoShikyukubun().disabled = false;
			    this.controls.txtZogenriyu().disabled = false;
			    this.controls.txtShiharaikingakugoke().disabled = false;
			    this.controls.txtZogentani().disabled = false;
			    this.controls.txtFuSyikyuriyu1().disabled = false; 
		            this.controls.txtFushikyuriyu2().disabled = true;
	                }
			public sansyo(): void {
			    this.controls.txtKetebi().disabled = true;
	                    this.controls.rdoShikyukubun().disabled = true;
			    this.controls.txtZogenriyu().disabled = true;
			    this.controls.txtShiharaikingakugoke().disabled = true;
			    this.controls.txtZogentani().disabled = true;
			    this.controls.txtFuSyikyuriyu1().disabled = true; 
		            this.controls.txtFushikyuriyu2().disabled = true;
	                }
			
			
 		}
        }
    }
}

module DBC
{
    export module ShokanbaraiketteiJoho
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
					editTypes.addEditType("GyomuCode", UZA.EditTypeEnumForPublicProperty.StringType);

                return editTypes;
            }
			 public getGyomuCode = function () {
                return this.controls.lblGyomuCode().text;
            }
            
            public  setGyomuCode = function (value) {
                this.controls.lblGyomuCode().text = value;
            }
        }
    }
}

