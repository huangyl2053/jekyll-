/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../KaigoNinteiShinseiKihonJohoInput/KaigoNinteiShinseiKihonJohoInput.ts" />
// <reference path="./../NinteiShinseiTodokedesha/NinteiShinseiTodokedesha.ts" />
// <reference path="./../shujiiIryokikanandshujiiinput/ShujiiIryokikanAndShujiiInput.ts" />
// <reference path="./../NinteiInput/NinteiInput.ts" />
// <reference path="./../ZenkaiNinteiKekkaJoho/ZenkaiNinteiKekkaJoho.ts" />
// <reference path="./../ShinseiSonotaJohoInput/ShinseiSonotaJohoInput.ts" />

module DBZ {

     export module RirekiShusei {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RirekiShusei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType() + "_" + fieldName;
            }

            public RirekiShusei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdKaigoNinteiShinseiKihonJohoInput(): DBZ.KaigoNinteiShinseiKihonJohoInput.ModeController {
            //    return new DBZ.KaigoNinteiShinseiKihonJohoInput.ModeController(this.convFiledName("ccdKaigoNinteiShinseiKihonJohoInput"));
            //}

            //public ccdNinteiShinseiTodokedesha(): DBZ.NinteiShinseiTodokedesha.ModeController {
            //    return new DBZ.NinteiShinseiTodokedesha.ModeController(this.convFiledName("ccdNinteiShinseiTodokedesha"));
            //}

            //public ccdShujiiIryokikanAndShujiiInput(): DBZ.ShujiiIryokikanAndShujiiInput.ModeController {
            //    return new DBZ.ShujiiIryokikanAndShujiiInput.ModeController(this.convFiledName("ccdShujiiIryokikanAndShujiiInput"));
            //}

            //public ccdNinteiJohoInput(): DBZ.NinteiInput.ModeController {
            //    return new DBZ.NinteiInput.ModeController(this.convFiledName("ccdNinteiJohoInput"));
            //}

            //public ccdZenkaiNinteiKekka(): DBZ.ZenkaiNinteiKekkaJoho.ModeController {
            //    return new DBZ.ZenkaiNinteiKekkaJoho.ModeController(this.convFiledName("ccdZenkaiNinteiKekka"));
            //}

            //public ccdShinseiSonotaJohoInput(): DBZ.ShinseiSonotaJohoInput.ModeController {
            //    return new DBZ.ShinseiSonotaJohoInput.ModeController(this.convFiledName("ccdShinseiSonotaJohoInput"));
            //}

            public btnChosaJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaJokyo"));
            }

            public btnOK(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOK"));
            }

            public btnCansel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCansel"));
            }

        }

     }

}

