/// <reference path="JutakuKaishuShinseiDetailInput_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module JutakuKaishuShinseiDetailInput {

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

    export module JutakuKaishuShinseiDetailInput {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtChakkoDate_lableLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKanseiDate_lableLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_btnModifyDetail", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnModify_text", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtChakkoDate_lableLText() {
                return this.controls.txtChakkoDueDate().labelLText;
            }

            public settxtChakkoDate_lableLText(value) {
                this.controls.txtChakkoDueDate().labelLText = value;
            }

            public gettxtKanseiDate_lableLText() {
                return this.controls.txtKanseiDueDate().labelLText;
            }

            public settxtKanseiDate_lableLText(value) {
                this.controls.txtKanseiDueDate().labelLText = value;
            }

            public getonClick_btnModifyDetail() {
                return this.controls.btnModifyDetail().onClick;
            }

            public setonClick_btnModifyDetail(value) {
                this.controls.btnModifyDetail().onClick = value;
            }

            public getbtnModify_text() {
                return this.controls.btnModifyDetail().text;
            }

            public setbtnModify_text(value) {
                this.controls.btnModifyDetail().text = value;
            }

            /*
            //TODO n8178 城間篤人 モード化か削除か作成者の判断が必要
            public getdg_gridSetting() {
                return this.controls.dgJutakuKaishuDetail().gridSetting;
            }

            public setdg_gridSetting(value) {
                this.controls.dgJutakuKaishuDetail().gridSetting = value;
            }
            */

        }
    }
}




