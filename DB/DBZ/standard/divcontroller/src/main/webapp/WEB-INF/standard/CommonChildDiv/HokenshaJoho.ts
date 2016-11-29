/// <reference path='HokenshaJoho_Design.ts' />
module DBZ
{
    export module HokenshaJoho
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

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        }
    }
}

module DBZ
{
    export module HokenshaJoho
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();
                editTypes.addEditType("TxtHokenshaNo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("TxtHokenshaNo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TxtHokenshaNo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

			public getTxtHokenshaNo_labelLWidth = function () {
                return this.controls.txtHokenshaNo().labelLWidth;
            }

            public setTxtHokenshaNo_labelLWidth = function (value) {
                this.controls.txtHokenshaNo().labelLWidth = value;
            }

			public getTxtHokenshaNo_required = function () {
                return this.controls.txtHokenshaNo().required;
            }

            public setTxtHokenshaNo_required = function (value) {
                this.controls.txtHokenshaNo().required = value;
            }

            public getTxtHokenshaNo_labelLText = function () {
                return this.controls.txtHokenshaNo().labelLText;
            }

            public setTxtHokenshaNo_labelLText = function (value) {
                this.controls.txtHokenshaNo().labelLText = value;
            }


        }
    }
}

