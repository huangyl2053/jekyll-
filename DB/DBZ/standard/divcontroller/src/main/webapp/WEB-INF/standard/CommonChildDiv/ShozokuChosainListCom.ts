/// <reference path='ShozokuChosainListCom_Design.ts' />
module DBE
{
    export module ShozokuChosainListCom
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

    export module ShozokuChosainListCom {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onOnlyRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onNoRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onMultiRows", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getheight() {
                return this.controls.dgShozokuChosainList().height;
            }

            public setheight(value) {
                this.controls.dgShozokuChosainList().height = value;
            }

            public getonSort() {
                return this.controls.dgShozokuChosainList().onSort;
            }

            public setonSort(value) {
                this.controls.dgShozokuChosainList().onSort = value;
            }

            public getonSelect() {
                return this.controls.dgShozokuChosainList().onSelect;
            }

            public setonSelect(value) {
                this.controls.dgShozokuChosainList().onSelect = value;
            }

            public getonSelectByDblClick() {
                return this.controls.dgShozokuChosainList().onSelectByDblClick;
            }

            public setonSelectByDblClick(value) {
                this.controls.dgShozokuChosainList().onSelectByDblClick = value;
            }

            public getonOnlyRow() {
                return this.controls.dgShozokuChosainList().onOnlyRow;
            }

            public setonOnlyRow(value) {
                this.controls.dgShozokuChosainList().onOnlyRow = value;
            }

            public getonNoRow() {
                return this.controls.dgShozokuChosainList().onNoRow;
            }

            public setonNoRow(value) {
                this.controls.dgShozokuChosainList().onNoRow = value;
            }

            public getonMultiRows() {
                return this.controls.dgShozokuChosainList().onMultiRows;
            }

            public setonMultiRows(value) {
                this.controls.dgShozokuChosainList().onMultiRows = value;
            }

        }
    }
}




