/// <reference path='NinteichosaIraiListForByHandCom_Design.ts' />
module DBE
{
    export module NinteichosaIraiListForByHandCom
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }
    }
}



module DBE {

    export module NinteichosaIraiListForByHandCom {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onOnlyRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onNoRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onMultiRows", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("withOfGrid", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getonSort() {
                return this.controls.dgNinteichosaIraiListForByHand().onSort;
            }

            public setonSort(value) {
                this.controls.dgNinteichosaIraiListForByHand().onSort = value;
            }

            public getonSelect() {
                return this.controls.dgNinteichosaIraiListForByHand().onSelect;
            }

            public setonSelect(value) {
                this.controls.dgNinteichosaIraiListForByHand().onSelect = value;
            }

            public getonSelectByDblClick() {
                return this.controls.dgNinteichosaIraiListForByHand().onSelectByDblClick;
            }

            public setonSelectByDblClick(value) {
                this.controls.dgNinteichosaIraiListForByHand().onSelectByDblClick = value;
            }

            public getonOnlyRow() {
                return this.controls.dgNinteichosaIraiListForByHand().onOnlyRow;
            }

            public setonOnlyRow(value) {
                this.controls.dgNinteichosaIraiListForByHand().onOnlyRow = value;
            }

            public getonNoRow() {
                return this.controls.dgNinteichosaIraiListForByHand().onNoRow;
            }

            public setonNoRow(value) {
                this.controls.dgNinteichosaIraiListForByHand().onNoRow = value;
            }

            public getonMultiRows() {
                return this.controls.dgNinteichosaIraiListForByHand().onMultiRows;
            }

            public setonMultiRows(value) {
                this.controls.dgNinteichosaIraiListForByHand().onMultiRows = value;
            }

            public getheight() {
                return this.controls.dgNinteichosaIraiListForByHand().height;
            }

            public setheight(value) {
                this.controls.dgNinteichosaIraiListForByHand().height = value;
            }

            public getwithOfGrid() {
                return this.controls.dgNinteichosaIraiListForByHand().width;
            }

            public setwithOfGrid(value) {
                this.controls.dgNinteichosaIraiListForByHand().width = value;
            }

        }
    }
}




