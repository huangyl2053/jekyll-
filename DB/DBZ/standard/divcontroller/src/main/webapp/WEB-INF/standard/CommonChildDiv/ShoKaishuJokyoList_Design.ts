/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShoKaishuJokyoList {

        export class Events {

            public static onSelect_dgShoKaishuJokyo(): string {
                return "onSelect_dgShoKaishuJokyo";
            }

            public static onSelectBySelectButton_dgShoKaishuJokyo(): string {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuJokyoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuJokyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShoKaishuJokyo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShoKaishuJokyo"));
            }

            public ShoKaishuJokyoShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShoKaishuJokyoShosai"));
            }

            public txtShoKofuShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtYukoKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            }

            public txtKofuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            }

            public txtKofuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            }

            public txtKaishuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            }

            public ddlKaishuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            }

            public txtKaishuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            }

        }

     }

}

