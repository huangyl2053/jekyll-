/// <reference path="KyufuhiKashitsukekinList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyufuhiKashitsukekinList {

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

    export module KyufuhiKashitsukekinList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickAddButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ListOnSelectBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ListOnSelectByModifyButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ListOnSelectByDeleteButton", UZA.EditTypeEnumForPublicProperty.StringType);
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

            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getListGridSetting() {
                return this.controls.dgKyufuhiKashitsukekinList().gridSetting;
            }

            public setListGridSetting(value) {
                this.controls.dgKyufuhiKashitsukekinList().gridSetting = value;
            }
            */

            public getListHeight() {
                return this.controls.dgKyufuhiKashitsukekinList().height;
            }

            public setListHeight(value) {
                this.controls.dgKyufuhiKashitsukekinList().height = value;
            }

            public getListOnSelect() {
                return this.controls.dgKyufuhiKashitsukekinList().onSelect;
            }

            public setListOnSelect(value) {
                this.controls.dgKyufuhiKashitsukekinList().onSelect = value;
            }

            public getListOnSelectByDblClick() {
                return this.controls.dgKyufuhiKashitsukekinList().onSelectByDblClick;
            }

            public setListOnSelectByDblClick(value) {
                this.controls.dgKyufuhiKashitsukekinList().onSelectByDblClick = value;
            }

            public getonClickAddButton() {
                return this.controls.btnAdd().onClick;
            }

            public setonClickAddButton(value) {
                this.controls.btnAdd().onClick = value;
            }

            public getListOnSelectBySelectButton() {
                return this.controls.dgKyufuhiKashitsukekinList().onSelectBySelectButton;
            }

            public setListOnSelectBySelectButton(value) {
                this.controls.dgKyufuhiKashitsukekinList().onSelectBySelectButton = value;
            }

            public getListOnSelectByModifyButton() {
                return this.controls.dgKyufuhiKashitsukekinList().onSelectByModifyButton;
            }

            public setListOnSelectByModifyButton(value) {
                this.controls.dgKyufuhiKashitsukekinList().onSelectByModifyButton = value;
            }

            public getListOnSelectByDeleteButton() {
                return this.controls.dgKyufuhiKashitsukekinList().onSelectByDeleteButton;
            }

            public setListOnSelectByDeleteButton(value) {
                this.controls.dgKyufuhiKashitsukekinList().onSelectByDeleteButton = value;
            }

        }
    }
}




