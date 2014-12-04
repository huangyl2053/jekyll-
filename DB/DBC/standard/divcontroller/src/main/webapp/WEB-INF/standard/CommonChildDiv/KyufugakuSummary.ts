/// <reference path="KyufugakuSummary_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyufugakuSummary {

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

    export module KyufugakuSummary {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnLimitOverCheck_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnRireki_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnRireki_text", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getbtnLimitOverCheck_displayNone() {
                return this.controls.btnLimitOverCheck().displayNone;
            }

            public setbtnLimitOverCheck_displayNone(value) {
                this.controls.btnLimitOverCheck().displayNone = value;
            }

            public getbtnRireki_displayNone() {
                return this.controls.btnRireki().displayNone;
            }

            public setbtnRireki_displayNone(value) {
                this.controls.btnRireki().displayNone = value;
            }

            public getbtnRireki_text() {
                return this.controls.btnRireki().text;
            }

            public setbtnRireki_text(value) {
                this.controls.btnRireki().text = value;
            }

        }
    }
}




