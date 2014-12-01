/// <reference path="PaymentMethod_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module PaymentMethod {

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

    export module PaymentMethod {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.PaymentMethod().title;
            }

            public settitle(value) {
                this.controls.PaymentMethod().title = value;
            }

            public getpanelDisplay() {
                return this.controls.PaymentMethod().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.PaymentMethod().panelDisplay = value;
            }

            public getonClick_radPayMethod() {
                return this.controls.radPayMethod1().onClick;
            }

            public setonClick_radPayMethod(value) {
                this.controls.radPayMethod1().onClick = value;
            }

            public getJuryoinin_displayNone() {
                return this.controls.JuryoininJoho().displayNone;
            }

            public setJuryoinin_displayNone(value) {
                this.controls.JuryoininJoho().displayNone = value;
            }

            public getMadoguchi_displayNone() {
                return this.controls.MadoguchiPayment().displayNone;
            }

            public setMadoguchi_displayNone(value) {
                this.controls.MadoguchiPayment().displayNone = value;
            }

            public getKoza_displayNone() {
                return this.controls.KozaPayment().Properties().displayNone;
            }

            public setKoza_displayNone(value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            }

            public geteraseBorder() {
                return this.controls.PaymentMethod().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.PaymentMethod().eraseBorder = value;
            }

        }
    }
}




