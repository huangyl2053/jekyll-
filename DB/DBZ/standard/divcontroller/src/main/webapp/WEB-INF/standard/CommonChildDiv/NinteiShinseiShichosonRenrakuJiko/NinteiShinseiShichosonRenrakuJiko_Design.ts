/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseiShichosonRenrakuJiko {

        export class Events {

            public static onClick_btnToroku(): string {
                return "onClick_btnToroku";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseiShichosonRenrakuJiko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJiko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJiko.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseiShichosonRenrakuJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtRenrakujiko(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtRenrakujiko"));
            }

            public btnToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToroku"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

