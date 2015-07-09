/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module HanteiKekkaIchiranShinsakaiPrint {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HanteiKekkaIchiranShinsakaiPrint";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.HanteiKekkaIchiranShinsakaiPrint.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.HanteiKekkaIchiranShinsakaiPrint.Controls.myType() + "_" + fieldName;
            }

            public HanteiKekkaIchiranShinsakaiPrint(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNinteiShinsakaiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinsakaiName"));
            }

            public chkPrintTaisho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkPrintTaisho"));
            }

            public chkShinsaGijiroku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShinsaGijiroku"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnInsatsuChohyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnInsatsuChohyo"));
            }

        }

     }

}

