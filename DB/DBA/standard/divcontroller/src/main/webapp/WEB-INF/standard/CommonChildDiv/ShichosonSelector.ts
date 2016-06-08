/// <reference path="ShichosonSelector_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBA
{
    export module ShichosonSelector {

        export class ModeController{
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

                public RadioBtnNoKyuShichosonMode(): void {
                    this.controls.radShichosonKubun().displayNone = true;
                                      
                }

                public RadioBtnNoKoseiShichosonMode(): void {
                    this.controls.radShichosonKubun().displayNone = true;
                   
                }
				public RadioBtnYesShichosonMode(): void {
                                       
                }
            }
        }
}    }

    

module DBA {

    export module ShichosonSelector {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}




