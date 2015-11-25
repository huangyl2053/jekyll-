/// <reference path='JyutakugaisyunaiyoList_Design.ts' />
module DBC
{
    export module JyutakugaisyunaiyoList
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
	                    this.controls.txtKaisyunaiyo().readOnly = false;
	                    this.controls.txtJigyosya().readOnly = false;
			    this.controls.txtJyusyo().readOnly = false;
			    this.controls.txtTyakkoyotebi().readOnly = false;
			    this.controls.txtKanseyotebi().readOnly = false;
			    this.controls.txtKaisyukingaku().readOnly = false; 
		            this.controls.btnHonnijyusyoCopy().disabled = true;
			    this.controls.btnClear().disabled = true;
                            this.controls.btnDetailConfirm().disabled = true;
	                }
	                public teisei(): void {
	                    this.controls.txtKaisyunaiyo().readOnly = false;
	                    this.controls.txtJigyosya().readOnly = false;
			    this.controls.txtJyusyo().readOnly = false;
			    this.controls.txtTyakkoyotebi().readOnly = false;
			    this.controls.txtKanseyotebi().readOnly = false;
			    this.controls.txtKaisyukingaku().readOnly = false; 
		            this.controls.btnHonnijyusyoCopy().disabled = true;
			    this.controls.btnClear().disabled = true;
                            this.controls.btnDetailConfirm().disabled = true;
	                }
			 public sansyo(): void {
                          //this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = true;
	                    this.controls.txtKaisyunaiyo().readOnly = false;
	                    this.controls.txtJigyosya().readOnly = false;
			    this.controls.txtJyusyo().readOnly = false;
			    this.controls.txtTyakkoyotebi().readOnly = false;
			    this.controls.txtKanseyotebi().readOnly = false;
			    this.controls.txtKaisyukingaku().readOnly = false; 
		            this.controls.btnHonnijyusyoCopy().disabled = true;
			    this.controls.btnClear().disabled = true;
                            this.controls.btnDetailConfirm().disabled = true; 
	                }
			
			
 		}
        }
    }
}

module DBC
{
    export module JyutakugaisyunaiyoList
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

