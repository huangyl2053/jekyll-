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
	                    this.controls.btnDetailAdd().displayNone = false;
	                    this.controls.dgGaisyuList().gridSetting.isShowModifyButtonColumn = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowDeleteButtonColumn = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = false;
	                    this.controls.dgGaisyuList()._control.afterPropertiesSet();
	                }
	                public teisei(): void {
	                    this.controls.btnDetailAdd().displayNone = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowModifyButtonColumn = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowDeleteButtonColumn = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = false;
	                    this.controls.dgGaisyuList()._control.afterPropertiesSet();
	                }
	                public sansyo(): void {
	                    this.controls.btnDetailAdd().displayNone = true;
	                    this.controls.dgGaisyuList().gridSetting.isShowModifyButtonColumn = false;
	                    this.controls.dgGaisyuList().gridSetting.isShowDeleteButtonColumn = false;
	                    this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = true;
	                    this.controls.dgGaisyuList()._control.afterPropertiesSet();
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

