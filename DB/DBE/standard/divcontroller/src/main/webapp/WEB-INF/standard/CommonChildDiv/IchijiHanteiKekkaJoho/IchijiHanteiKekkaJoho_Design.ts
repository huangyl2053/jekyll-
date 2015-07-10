/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../IchijiHanteiKekkaInfo.ts" />

module DBE {

     export module IchijiHanteiKekkaJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiHanteiKekkaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType() + "_" + fieldName;
            }

            public IchijiHanteiKekkaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdIchijiHanteiKekkaInfo(): DBE.IchijiHanteiKekkaInfo.ModeController {
            //    return new DBE.IchijiHanteiKekkaInfo.ModeController(this.convFiledName("ccdIchijiHanteiKekkaInfo"));
            //}

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

