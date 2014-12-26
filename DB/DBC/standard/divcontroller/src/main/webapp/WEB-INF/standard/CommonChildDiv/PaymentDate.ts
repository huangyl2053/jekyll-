/// <reference path="PaymentDate_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module PaymentDate {

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

    export module PaymentDate {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getpanelDisplay() {
                return this.controls.PaymentDate().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.PaymentDate().panelDisplay = value;
            }

        }
    }
}




