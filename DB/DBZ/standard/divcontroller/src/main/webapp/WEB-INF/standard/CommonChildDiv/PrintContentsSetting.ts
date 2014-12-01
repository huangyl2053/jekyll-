/// <reference path="PrintContentsSetting_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module PrintContentsSetting {

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

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

    }
}



module DBZ {

    export module PrintContentsSetting {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSendData_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("PrintContentsSetting_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("PrintContentsSetting_eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtSendData_displayNone() {
                return this.controls.txtSendDate().displayNone;
            }

            public settxtSendData_displayNone(value) {
                this.controls.txtSendDate().displayNone = value;
            }

            public getPrintContentsSetting_title() {
                return this.controls.PrintContentsSetting().title;
            }

            public setPrintContentsSetting_title(value) {
                this.controls.PrintContentsSetting().title = value;
            }

            public getPrintContentsSetting_eraseBorder() {
                return this.controls.PrintContentsSetting().eraseBorder;
            }

            public setPrintContentsSetting_eraseBorder(value) {
                this.controls.PrintContentsSetting().eraseBorder = value;
            }
        }
    }
}




