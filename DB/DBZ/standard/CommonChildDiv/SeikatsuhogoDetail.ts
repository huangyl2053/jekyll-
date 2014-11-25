/// <reference path="SeikatsuhogoDetail_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module SeikatsuhogoDetail {

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



module DBZ {

    export module SeikatsuhogoDetail {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnHokenshaGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getbtnHokenshaGuide_displayNone() {
                return this.controls.btnHokenshaGuide().displayNone;
            }

            public setbtnHokenshaGuide_displayNone(value) {
                this.controls.btnHokenshaGuide().displayNone = value;
            }

        }
    }
}




