/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="../../d.ts/UZICommonChildDiv.d.ts" />

module DBE {

     export module ImageJohoMaskingDialog {

        export class Events {

            public static onClick_btnTorikeshi(): string {
                return "onClick_btnTorikeshi";
            }

            public static onClick_btnHozon(): string {
                return "onClick_btnHozon";
            }

            public static onClick_btnSave(): string {
                return "onClick_btnSave";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ImageJohoMaskingDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ImageJohoMaskingDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ImageJohoMaskingDialog.Controls.myType() + "_" + fieldName;
            }

            public ImageJohoMaskingDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdImageMasking(): UZI.ImageMasking.ModeController {
                return new UZI.ImageMasking.ModeController(this.convFiledName("ccdImageMasking"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

            public btnHozon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHozon"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

        }

     }

}

