/// <reference path="ShinseishaInfo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module ShinseishaInfo {

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



module DBC {

    export module ShinseishaInfo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnSearch_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getbtnSearch_displayNone() {
                return this.controls.btnSearchJigyosha().displayNone;
            }

            public setbtnSearch_displayNone(value) {
                this.controls.btnSearchJigyosha().displayNone = value;
            }

        }
    }
}




