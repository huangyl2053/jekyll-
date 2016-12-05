/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseiRenrakusakiJoho {

        export class Events {

            public static onClilck_btnShinkiTsuika(): string {
                return "onClilck_btnShinkiTsuika";
            }

            public static onClilck_btnFukushaTsuika(): string {
                return "onClilck_btnFukushaTsuika";
            }

            public static onClilck_btnZenkaiFukusha(): string {
                return "onClilck_btnZenkaiFukusha";
            }

            public static onSelect_RenrakusakiIchiran(): string {
                return "onSelect_RenrakusakiIchiran";
            }

            public static onClick_btnShusei(): string {
                return "onClick_btnShusei";
            }

            public static onClick_btnSakujo(): string {
                return "onClick_btnSakujo";
            }

            public static onClick_btnToroku(): string {
                return "onClick_btnToroku";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseiRenrakusakiJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiJoho.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseiRenrakusakiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public RenrakusakiIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RenrakusakiIchiran"));
            }

            public btnShinkiTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShinkiTsuika"));
            }

            public btnFukushaTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnFukushaTsuika"));
            }

            public btnZenkaiFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            }

            public dgRenrakusakiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRenrakusakiIchiran"));
            }

            public RenrakusakiNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RenrakusakiNyuryoku"));
            }

            public txtRenban(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRenban"));
            }

            public ddlRenrakusakiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlRenrakusakiKubun"));
            }

            public ddlShisho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShisho"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtKanaShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKanaShimei"));
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

            public btnToroku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToroku"));
            }

            public txtMobileNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtMobileNo"));
            }

            public txtYusenJuni(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtYusenJuni"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

