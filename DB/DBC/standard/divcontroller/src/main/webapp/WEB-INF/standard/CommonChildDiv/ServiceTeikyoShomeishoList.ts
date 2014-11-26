/// <reference path="ServiceTeikyoShomeishoList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module ServiceTeikyoShomeishoList {

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

    export module ServiceTeikyoShomeishoList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoOnSelectDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getAddButtonVisible() {
                return this.controls.btnAdd().visible;
            }

            public setAddButtonVisible(value) {
                this.controls.btnAdd().visible = value;
            }

            public getAddButtonDisplayNone() {
                return this.controls.btnAdd().displayNone;
            }

            public setAddButtonDisplayNone(value) {
                this.controls.btnAdd().displayNone = value;
            }

            public getAddButtonOnClick() {
                return this.controls.btnAdd().onClick;
            }

            public setAddButtonOnClick(value) {
                this.controls.btnAdd().onClick = value;
            }
            
            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getShomeishoGridSetting() {
                return this.controls.dgServiceTeikyoShomeishoList().gridSetting;
            }

            public setShomeishoGridSetting(value) {
                this.controls.dgServiceTeikyoShomeishoList().gridSetting = value;
            }
            */

            public getShomeishoHeight() {
                return this.controls.dgServiceTeikyoShomeishoList().height;
            }

            public setShomeishoHeight(value) {
                this.controls.dgServiceTeikyoShomeishoList().height = value;
            }

            public getShomeishoOnSelect() {
                return this.controls.dgServiceTeikyoShomeishoList().onSelect;
            }

            public setShomeishoOnSelect(value) {
                this.controls.dgServiceTeikyoShomeishoList().onSelect = value;
            }

            public getShomeishoOnSelectDblClick() {
                return this.controls.dgServiceTeikyoShomeishoList().onSelectByDblClick;
            }

            public setShomeishoOnSelectDblClick(value) {
                this.controls.dgServiceTeikyoShomeishoList().onSelectByDblClick = value;
            }

        }
    }
}




