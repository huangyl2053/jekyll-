/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module HanteiKekkaIchiranPrint {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HanteiKekkaIchiranPrint";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.HanteiKekkaIchiranPrint.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.HanteiKekkaIchiranPrint.Controls.myType() + "_" + fieldName;
            }

            public HanteiKekkaIchiranPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHokenshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaCode"));
            }

            public txtHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            }

            public chkPrintChohyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkPrintChohyo"));
            }

            public spSpace1(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace1"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnPritBatch(): UZA.ButtonBatchRegister {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnPritBatch"));
            }

        }

     }

}

