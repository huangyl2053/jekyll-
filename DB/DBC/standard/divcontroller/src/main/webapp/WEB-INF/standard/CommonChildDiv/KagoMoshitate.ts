/// <reference path="KagoMoshitate_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
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



module DBC {

    export module KagoMoshitate {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("isGroupBox", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getisGroupBox() {
                return this.controls.KagoMoshitate().isGroupBox;
            }

            public setisGroupBox(value) {
                this.controls.KagoMoshitate().isGroupBox = value;
            }

            public geteraseBorder() {
                return this.controls.KagoMoshitate().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            }

            public gettitle() {
                return this.controls.KagoMoshitate().title;
            }

            public settitle(value) {
                this.controls.KagoMoshitate().title = value;
            }

        }
    }
}




