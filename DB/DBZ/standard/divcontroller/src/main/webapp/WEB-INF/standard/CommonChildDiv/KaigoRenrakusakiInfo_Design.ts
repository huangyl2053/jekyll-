/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoRenrakusakiInfo {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onClick_btnDelete(): string {
                return "onClick_btnDelete";
            }

            public static onSelectByDC_Renrakusaki(): string {
                return "onSelectByDC_Renrakusaki";
            }

            public static onSelectBySB_Renrakusaki(): string {
                return "onSelectBySB_Renrakusaki";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

            public static onClick_btnKoshin(): string {
                return "onClick_btnKoshin";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoRenrakusakiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoRenrakusakiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public btnDelete(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDelete"));
            }

            public dgRenrakusaki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRenrakusaki"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

            public SelectedContents(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            }

            public txtRenrakusakiKbnNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRenrakusakiKbnNo"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtShimeiKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimeiKana"));
            }

            public txtTsuzukigara(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTsuzukigara"));
            }

            public txtTel(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTel"));
            }

            public txtKeitaiNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeitaiNo"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            }

            public btnUpdate(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

