/// <reference path="KyufuKanrihyoInfo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyufuKanrihyoInfo {

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

    export module KyufuKanrihyoInfo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ZengetsuNissuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ShikyuGendogakuIsComma", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("GokeiTanisuLabelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("GokeiTanisuIsComma", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TantoSenmonNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TantoSenmonNoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNoDisplayNode", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNameVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNameDisplayNode", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuSenmonNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuSenmonNoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("MeisaiListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectbyModifyButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectByDeleteButton", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getZengetsuNissuVisible() {
                return this.controls.txtZengetsuNissu().visible;
            }

            public setZengetsuNissuVisible(value) {
                this.controls.txtZengetsuNissu().visible = value;
            }

            public getShikyuGendogakuIsComma() {
                return this.controls.txtShikyuGendogaku().isComma;
            }

            public setShikyuGendogakuIsComma(value) {
                this.controls.txtShikyuGendogaku().isComma = value;
            }

            public getGokeiTanisuLabelLText() {
                return this.controls.txtGokeiTanisu().labelLText;
            }

            public setGokeiTanisuLabelLText(value) {
                this.controls.txtGokeiTanisu().labelLText = value;
            }

            public getGokeiTanisuIsComma() {
                return this.controls.txtGokeiTanisu().isComma;
            }

            public setGokeiTanisuIsComma(value) {
                this.controls.txtGokeiTanisu().isComma = value;
            }

            public getTantoSenmonNoVisible() {
                return this.controls.txtTantoSenmonNo().visible;
            }

            public setTantoSenmonNoVisible(value) {
                this.controls.txtTantoSenmonNo().visible = value;
            }

            public getTantoSenmonNoDisplayNone() {
                return this.controls.txtTantoSenmonNo().displayNone;
            }

            public setTantoSenmonNoDisplayNone(value) {
                this.controls.txtTantoSenmonNo().displayNone = value;
            }

            public getItakuJigyoshaNoVisible() {
                return this.controls.txtItakuJigyoshaNo().visible;
            }

            public setItakuJigyoshaNoVisible(value) {
                this.controls.txtItakuJigyoshaNo().visible = value;
            }

            public getItakuJigyoshaNoDisplayNode() {
                return this.controls.txtItakuJigyoshaNo().displayNone;
            }

            public setItakuJigyoshaNoDisplayNode(value) {
                this.controls.txtItakuJigyoshaNo().displayNone = value;
            }

            public getItakuJigyoshaNameVisible() {
                return this.controls.txtItakuJigyoshaName().visible;
            }

            public setItakuJigyoshaNameVisible(value) {
                this.controls.txtItakuJigyoshaName().visible = value;
            }

            public getItakuJigyoshaNameDisplayNode() {
                return this.controls.txtItakuJigyoshaName().displayNone;
            }

            public setItakuJigyoshaNameDisplayNode(value) {
                this.controls.txtItakuJigyoshaName().displayNone = value;
            }

            public getItakuSenmonNoVisible() {
                return this.controls.txtItakuSenmonNo().visible;
            }

            public setItakuSenmonNoVisible(value) {
                this.controls.txtItakuSenmonNo().visible = value;
            }

            public getItakuSenmonNoDisplayNone() {
                return this.controls.txtItakuSenmonNo().displayNone;
            }

            public setItakuSenmonNoDisplayNone(value) {
                this.controls.txtItakuSenmonNo().displayNone = value;
            }
            
            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getMeisaiListGridSetting() {
                return this.controls.dgMeisaiList().gridSetting;
            }

            public setMeisaiListGridSetting(value) {
                this.controls.dgMeisaiList().gridSetting = value;
            }
            */
            public getMeisaiListHeight() {
                return this.controls.dgMeisaiList().height;
            }

            public setMeisaiListHeight(value) {
                this.controls.dgMeisaiList().height = value;
            }

            public getMeisaiListOnSort() {
                return this.controls.dgMeisaiList().onSort;
            }

            public setMeisaiListOnSort(value) {
                this.controls.dgMeisaiList().onSort = value;
            }

            public getMeisaiListOnSelect() {
                return this.controls.dgMeisaiList().onSelect;
            }

            public setMeisaiListOnSelect(value) {
                this.controls.dgMeisaiList().onSelect = value;
            }

            public getMeisaiListOnSelectByDblClick() {
                return this.controls.dgMeisaiList().onSelectByDblClick;
            }

            public setMeisaiListOnSelectByDblClick(value) {
                this.controls.dgMeisaiList().onSelectByDblClick = value;
            }

            public getMeisaiListOnSelectBySelectButton() {
                return this.controls.dgMeisaiList().onSelectBySelectButton;
            }

            public setMeisaiListOnSelectBySelectButton(value) {
                this.controls.dgMeisaiList().onSelectBySelectButton = value;
            }

            public getMeisaiListOnSelectbyModifyButton() {
                return this.controls.dgMeisaiList().onSelectByModifyButton;
            }

            public setMeisaiListOnSelectbyModifyButton(value) {
                this.controls.dgMeisaiList().onSelectByModifyButton = value;
            }

            public getMeisaiListOnSelectByDeleteButton() {
                return this.controls.dgMeisaiList().onSelectByDeleteButton;
            }

            public setMeisaiListOnSelectByDeleteButton(value) {
                this.controls.dgMeisaiList().onSelectByDeleteButton = value;
            }

        }
    }
}




