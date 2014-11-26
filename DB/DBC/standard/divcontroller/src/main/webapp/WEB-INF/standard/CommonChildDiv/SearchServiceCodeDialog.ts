/// <reference path="SearchServiceCodeDialog_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module SearchServiceCodeDialog {

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

    export module SearchServiceCodeDialog {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClickDialogBtnCancel", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getonClickDialogBtnCancel() {
                return this.controls.btnCancel().onClick;
            }

            public setonClickDialogBtnCancel(value) {
                this.controls.btnCancel().onClick = value;
            }

        }
    }
}




