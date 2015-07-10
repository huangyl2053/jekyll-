/// <reference path="KanryoDialog_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBE
{
    export module KanryoDialog {

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



module DBE {

    export module KanryoDialog {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoDialog_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getKanryoDialog_width() {
                return this.controls.KanryoDialog().width;
            }

            public setKanryoDialog_width(value) {
                this.controls.KanryoDialog().width = value;
            }

        }
    }
}




