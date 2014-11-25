/// <reference path="HihokenshaShikakuHakko_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBU
{
    export module HihokenshaShikakuHakko {

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



module DBU {

    export module HihokenshaShikakuHakko {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtYukoKigen_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("radInjiIchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtYukoKigen_displayNone() {
                return this.controls.txtYukoKigen().displayNone;
            }

            public settxtYukoKigen_displayNone(value) {
                this.controls.txtYukoKigen().displayNone = value;
            }

            public getradInjiIchi_displayNone() {
                return this.controls.radInjiIchi().displayNone;
            }

            public setradInjiIchi_displayNone(value) {
                this.controls.radInjiIchi().displayNone = value;
            }

        }
    }
}




