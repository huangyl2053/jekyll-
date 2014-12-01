/// <reference path="ShoKaishuKirokuKanri_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module ShoKaishuKirokuKanri {

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

    export module ShoKaishuKirokuKanri {

        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ShoKaishuJokyoShosai_panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getShoKaishuJokyoShosai_penalDisplay() {
                return this.controls.ShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_panelDisplay;
            }

            public setShoKaishuJokyoShosai_penalDisplay(value) {
                this.controls.ShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_panelDisplay = value;
            }

            public getShoKaishuJokyoShosai_canOpenAndClose() {
                return this.controls.ShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_canOpenAndClose;
            }

            public setShoKaishuJokyoShosai_canOpenAndClose(value) {
                this.controls.ShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_canOpenAndClose = value;
            }

        }
    }
}




