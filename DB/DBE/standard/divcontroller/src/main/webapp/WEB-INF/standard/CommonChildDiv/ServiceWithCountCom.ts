/// <reference path='ServiceWithCountCom_Design.ts' />
module DBE
{
    export module ServiceWithCountCom
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

    export module ServiceWithCountCom {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("text_ServiceName", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_Frequency", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_Unit", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radKaigoOrYobo_dataSource", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettext_ServiceName() {
                return this.controls.lblServiceName().text;
            }

            public settext_ServiceName(value) {
                this.controls.lblServiceName().text = value;
            }

            public gettext_Frequency() {
                return this.controls.txtNum().labelLText;
            }

            public settext_Frequency(value) {
                this.controls.txtNum().labelLText = value;
            }

            public gettext_Unit() {
                return this.controls.txtNum().labelRText;
            }

            public settext_Unit(value) {
                this.controls.txtNum().labelRText = value;
            }

            public getradKaigoOrYobo_dataSource() {
                return this.controls.radKaigoOrYobo().selectedItem;
            }

            public setradKaigoOrYobo_dataSource(value) {
                this.controls.radKaigoOrYobo().selectedItem = value;
            }

        }
    }
}




