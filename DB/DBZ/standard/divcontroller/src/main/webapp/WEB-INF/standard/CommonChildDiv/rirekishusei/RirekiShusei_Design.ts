/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./KaigoNinteiShinseiKihonJohoInput/KaigoNinteiShinseiKihonJohoInput.ts" />
/// <reference path="./NinteiShinseiTodokedesha/NinteiShinseiTodokedesha.ts" />
/// <reference path="./shujiiIryokikanandshujiiinput/ShujiiIryokikanAndShujiiInput.ts" />
/// <reference path="./chosaitakusakiandchosaininput/ChosaItakusakiAndChosainInput.ts" />
/// <reference path="./NinteiInput/NinteiInput.ts" />
/// <reference path="./ZenkaiNinteiKekkaJoho/ZenkaiNinteiKekkaJoho.ts" />
/// <reference path="./ShinseiSonotaJohoInput/ShinseiSonotaJohoInput.ts" />

module DBZ {

     export module RirekiShusei {

        export class Events {

            public static onOkClose_btnChosaJokyo(): string {
                return "onOkClose_btnChosaJokyo";
            }

            public static onBefore_btnChosaJokyo(): string {
                return "onBefore_btnChosaJokyo";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

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

            public ccdKaigoNinteiShinseiKihonJohoInput(): DBZ.KaigoNinteiShinseiKihonJohoInput.ModeController {
                return new DBZ.KaigoNinteiShinseiKihonJohoInput.ModeController(this.convFiledName("ccdKaigoNinteiShinseiKihonJohoInput"));
            }

            public ccdNinteiShinseiTodokedesha(): DBZ.NinteiShinseiTodokedesha.ModeController {
                return new DBZ.NinteiShinseiTodokedesha.ModeController(this.convFiledName("ccdNinteiShinseiTodokedesha"));
            }

            public ShijiiIryokikanAndShijiiInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShijiiIryokikanAndShijiiInput"));
            }

            public ccdShujiiIryokikanAndShujiiInput(): DBZ.ShujiiIryokikanAndShujiiInput.ModeController {
                return new DBZ.ShujiiIryokikanAndShujiiInput.ModeController(this.convFiledName("ccdShujiiIryokikanAndShujiiInput"));
            }

            public ChsaItakusakiAndChosainInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChsaItakusakiAndChosainInput"));
            }

            public ccdChosaItakusakiAndChosainInput(): DBZ.ChosaItakusakiAndChosainInput.ModeController {
                return new DBZ.ChosaItakusakiAndChosainInput.ModeController(this.convFiledName("ccdChosaItakusakiAndChosainInput"));
            }

            public ccdNinteiJohoInput(): DBZ.NinteiInput.ModeController {
                return new DBZ.NinteiInput.ModeController(this.convFiledName("ccdNinteiJohoInput"));
            }

            public ccdZenkaiNinteiKekka(): DBZ.ZenkaiNinteiKekkaJoho.ModeController {
                return new DBZ.ZenkaiNinteiKekkaJoho.ModeController(this.convFiledName("ccdZenkaiNinteiKekka"));
            }

            public ccdShinseiSonotaJohoInput(): DBZ.ShinseiSonotaJohoInput.ModeController {
                return new DBZ.ShinseiSonotaJohoInput.ModeController(this.convFiledName("ccdShinseiSonotaJohoInput"));
            }

            public btnChosaJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaJokyo"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

