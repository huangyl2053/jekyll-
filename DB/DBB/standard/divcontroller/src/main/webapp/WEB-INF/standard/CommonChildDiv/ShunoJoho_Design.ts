/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBB {

     export module ShunoJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShunoJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType() + "_" + fieldName;
            }

            public ShunoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtChoteiNendo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiNendo"));
            }

            public txtFukaNendo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaNendo"));
            }

            public txtTsuchiNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTsuchiNo"));
            }

            public ddlChoteiNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChoteiNendo"));
            }

            public ddlFukaNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            }

            public btnNendoChange(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNendoChange"));
            }

            public ShunoJohoTokucho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShunoJohoTokucho"));
            }

            public dgTokucho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTokucho"));
            }

            public txtTokuChoteiGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuChoteiGeoukei"));
            }

            public txtTokuShunyuGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuShunyuGeoukei"));
            }

            public ShunoJohoFucho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShunoJohoFucho"));
            }

            public dgFucho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFucho"));
            }

            public txtFuChoteiGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFuChoteiGeoukei"));
            }

            public txtFuShunyuGeoukei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFuShunyuGeoukei"));
            }

        }

     }

}

