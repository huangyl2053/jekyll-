/// <reference path="ShokanShikyuShinseishoList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module ShokanShikyuShinseishoList {

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

    export module ShokanShikyuShinseishoList {

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
                editTypes.addEditType("ShinseishoListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShinseishoListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShinseishoListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
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
            public getShinseishoListGridSetting() {
                return this.controls.dgShokanShikyuShinseishoList().gridSetting;
            }

            public setShinseishoListGridSetting(value) {
                this.controls.dgShokanShikyuShinseishoList().gridSetting = value;
            }
            */

            public getShinseishoListHeight() {
                return this.controls.dgShokanShikyuShinseishoList().height;
            }

            public setShinseishoListHeight(value) {
                this.controls.dgShokanShikyuShinseishoList().height = value;
            }

            public getShinseishoListOnSelect() {
                return this.controls.dgShokanShikyuShinseishoList().onSelect;
            }

            public setShinseishoListOnSelect(value) {
                this.controls.dgShokanShikyuShinseishoList().onSelect = value;
            }

            public getShinseishoListOnSelectByDblClick() {
                return this.controls.dgShokanShikyuShinseishoList().onSelectByDblClick;
            }

            public setShinseishoListOnSelectByDblClick(value) {
                this.controls.dgShokanShikyuShinseishoList().onSelectByDblClick = value;
            }

        }
    }
}




