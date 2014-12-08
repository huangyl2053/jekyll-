/// <reference path="FutanGendogakuNintei_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBD
{
    export module FutanGendogakuNintei {

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

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }

    }
}



module DBD {

    export module FutanGendogakuNintei {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("visible_Kyusochisha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getvisible_Kyusochisha() {
                return this.controls.txtKyushochisha().visible;
            }

            public setvisible_Kyusochisha(value) {
                this.controls.txtKyushochisha().visible = value;
            }

        }
    }
}




