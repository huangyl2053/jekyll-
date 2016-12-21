/// <reference path='ImageJohoMaskingDialog_Design.ts' />
/// <reference path='../../d.ts/UZICommonChildDiv.d.ts' />
module DBE
{
    export module ImageJohoMaskingDialog
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
                Uz.GyomuJSHelper.registOriginalEvent(DBE.ImageJohoMaskingDialog.Events.onClick_btnHozon(),
                function (control) {
                         (<any>Uz)._MessageUtil.confirm("保存します。よろしいですか？", function (isOk) {
                             if (isOk) { UZI.ImageMasking.EventScripts.beforeClick();
                                 $("#" + Uz.JSControlUtil.getJSControl("btnSave").fieldName).click();
                             }
                         });
                 });
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

module DBE
{
    export module ImageJohoMaskingDialog
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

                return editTypes;
            }
        }
    }
}
