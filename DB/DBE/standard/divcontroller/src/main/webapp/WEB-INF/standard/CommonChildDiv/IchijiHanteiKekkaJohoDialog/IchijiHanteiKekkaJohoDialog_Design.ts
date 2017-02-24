/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../IchijiHanteiKekkaJoho/IchijiHanteiKekkaJoho.ts" />

module DBE {

     export module IchijiHanteiKekkaJohoDialog {

        export class Events {

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiHanteiKekkaJohoDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJohoDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJohoDialog.Controls.myType() + "_" + fieldName;
            }

            public IchijiHanteiKekkaJohoDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdIchijiHanteiKekkaJoho(): DBE.IchijiHanteiKekkaJoho.ModeController {
            //    return new DBE.IchijiHanteiKekkaJoho.ModeController(this.convFiledName("ccdIchijiHanteiKekkaJoho"));
            //}

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

