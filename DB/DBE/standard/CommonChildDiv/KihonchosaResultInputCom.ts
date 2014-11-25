/// <reference path='KihonchosaResultInputCom_Design.ts' />
module DBE
{
    export module KihonchosaResultInputCom
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

    export module KihonchosaResultInputCom {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("text_ItemNo", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_ItemName", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("visible_ItemNo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                /*
                editTypes.addEditType("dataSource_Choices", UZA.EditTypeEnumForPublicProperty.StringType);
                */
                editTypes.addEditType("onFocus_Answer", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettext_ItemNo() {
                return this.controls.lblItemNo().text;
            }

            public settext_ItemNo(value) {
                this.controls.lblItemNo().text = value;
            }

            public gettext_ItemName() {
                return this.controls.lblItemName().text;
            }

            public settext_ItemName(value) {
                this.controls.lblItemName().text = value;
            }

            public getvisible_ItemNo() {
                return this.controls.lblItemNo().visible;
            }

            public setvisible_ItemNo(value) {
                this.controls.lblItemNo().visible = value;
            }

            /*
            //TODO n8178 城間篤人 削除するかモード対応するか作成者の判断が必要。
            public getdataSource_Choices() {
                return this.controls.radChoices().dataSource;
            }

            public setdataSource_Choices(value) {
                this.controls.radChoices().dataSource = value;
            }
            */
            public getonFocus_Answer() {
                return this.controls.txtAnswer().onFocus;
            }

            public setonFocus_Answer(value) {
                this.controls.txtAnswer().onFocus = value;
            }

        }
    }
}




