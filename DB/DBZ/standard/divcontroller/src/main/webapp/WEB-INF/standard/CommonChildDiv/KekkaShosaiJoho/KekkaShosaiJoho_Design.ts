/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../NinteiInput/NinteiInput.ts" />
/// <reference path="./../ShinseiSonotaJohoInput/ShinseiSonotaJohoInput.ts" />

module DBZ {

     export module KekkaShosaiJoho {

        export class Events {

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

            public static onClick_btnToroku(): string {
                return "onClick_btnToroku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KekkaShosaiJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KekkaShosaiJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KekkaShosaiJoho.Controls.myType() + "_" + fieldName;
            }

            public KekkaShosaiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdNinteiInput(): DBZ.NinteiInput.ModeController {
                return new DBZ.NinteiInput.ModeController(this.convFiledName("ccdNinteiInput"));
            }

            public ccdShinseiSonotaJohoInput(): DBZ.ShinseiSonotaJohoInput.ModeController {
                return new DBZ.ShinseiSonotaJohoInput.ModeController(this.convFiledName("ccdShinseiSonotaJohoInput"));
            }

            public txtShinseiKubunShinsei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));
            }

            public txtShinseiKubunLaw(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunLaw"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToroku"));
            }

        }

     }

}

