/// <reference path="KagoMoshitate_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KagoMoshitate {

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

    export module KagoMoshitate {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.KagoMoshitate().title;
            }

            public settitle(value) {
                this.controls.KagoMoshitate().title = value;
            }

            public geteraseBorder() {
                return this.controls.KagoMoshitate().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            }

            public getpanelDisplay() {
                return this.controls.KagoMoshitate().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.KagoMoshitate().panelDisplay = value;
            }

        }
    }
}




