/// <reference path="IchijiHanteiKekkaJoho_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBE
{
    export module IchijiHanteiKekkaJoho {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return [];
            }

             public State() {
                return new Modes.State(this.controls);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }
     export module Modes {
        export class State {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai (): void {
                }

                public touroku (): void {
                }
            }
        
        }


    }
}



module DBE {

    export module IchijiHanteiKekkaJoho {

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




