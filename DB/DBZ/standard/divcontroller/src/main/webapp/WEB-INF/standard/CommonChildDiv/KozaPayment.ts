/// <reference path="KozaPayment_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KozaPayment {

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

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

    }
}



module DBZ {

    export module KozaPayment {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.KozaPayment().title;
            }

            public settitle(value) {
                this.controls.KozaPayment().title = value;
            }

            public geteraseBorder() {
                return this.controls.KozaPayment().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.KozaPayment().eraseBorder = value;
            }

            public getpanelDisplay() {
                return this.controls.KozaPayment().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.KozaPayment().panelDisplay = value;
            }

        }
    }
}




