/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseiRenrakusakiKihon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseiRenrakusakiKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiKihon.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseiRenrakusakiKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public ddlTsuzukigara(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTsuzukigara"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJusho"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtMobileNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtMobileNo"));
            }

        }

     }

}

