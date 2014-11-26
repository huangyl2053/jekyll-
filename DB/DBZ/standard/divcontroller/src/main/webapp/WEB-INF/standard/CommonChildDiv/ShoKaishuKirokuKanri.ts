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

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }
            
            /*
            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onBlur_txtKaishuDate", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onChange_ddlKaishuJiyu", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onBlur_txtKaishuRiyu", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_panalDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            //TODO n8178 城間篤人 資格得喪スケルトンの方で対応しているShoKaishuKirokuKanriとマージ後に修正する。
            public getonBlur_txtKaishuDate() {
                return this.controls.ShoKaishuJokyoShosai().Properties().onBlur_txtKaishuDate;
            }

            public setonBlur_txtKaishuDate(value) {
                this.controls.ShoKaishuJokyoShosai().onBlur_txtKaishuDate = value;
            }

            public getonChange_ddlKaishuJiyu() {
                return this.controls.ShoKaishuJokyoShosai().onChange_ddlKaishuJiyu;
            }

            public setonChange_ddlKaishuJiyu(value) {
                this.controls.ShoKaishuJokyoShosai().onChange_ddlKaishuJiyu = value;
            }

            public getonBlur_txtKaishuRiyu() {
                return this.controls.ShoKaishuJokyoShosai().onBlur_txtKaishuRiyu;
            }

            public setonBlur_txtKaishuRiyu(value) {
                this.controls.ShoKaishuJokyoShosai().onBlur_txtKaishuRiyu = value;
            }

            public getShoKaishuJokyoShosai_panalDisplay() {
                return this.controls.ShoKaishuJokyoShosai().ShoKaishuJokyoShosai_panelDisplay;
            }

            public setShoKaishuJokyoShosai_panalDisplay(value) {
                this.controls.ShoKaishuJokyoShosai().ShoKaishuJokyoShosai_panelDisplay = value;
            }

            public getShoKaishuJokyoShosai_canOpenAndClose() {
                return this.controls.ShoKaishuJokyoShosai().ShoKaishuJokyoShosai_canOpenAndClose;
            }

            public setShoKaishuJokyoShosai_canOpenAndClose(value) {
                this.controls.ShoKaishuJokyoShosai().ShoKaishuJokyoShosai_canOpenAndClose = value;
            }
            */

        }
    }
}




