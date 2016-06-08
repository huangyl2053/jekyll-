/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoToiawasesaki {

        export class Events {

            public static onClick_btnAddChohyoDokuji(): string {
                return "onClick_btnAddChohyoDokuji";
            }

            public static onClick_dgToiawasesakiControl(): string {
                return "onClick_dgToiawasesakiControl";
            }

            public static onClick_dgToiawasesakiControl_modify(): string {
                return "onClick_dgToiawasesakiControl_modify";
            }

            public static onClick_dgToiawasesakiControl_delete(): string {
                return "onClick_dgToiawasesakiControl_delete";
            }

            public static onClick_btnDecide(): string {
                return "onClick_btnDecide";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

            public static onClick_btnSave(): string {
                return "onClick_btnSave";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoToiawasesaki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoToiawasesaki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoToiawasesaki.Controls.myType() + "_" + fieldName;
            }

            public KaigoToiawasesaki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ToiawasesakiControl(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ToiawasesakiControl"));
            }

            public btnAddChohyoDokuji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddChohyoDokuji"));
            }

            public dgToiawasesakiControl(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgToiawasesakiControl"));
            }

            public ToiawasesakiShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ToiawasesakiShosai"));
            }

            public lblHensyuTaisho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHensyuTaisho"));
            }

            public Detail1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Detail1"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtShozaichi(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShozaichi"));
            }

            public txtChoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoshaName"));
            }

            public Detail2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Detail2"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtNaisenNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNaisenNo"));
            }

            public txtBushoName(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBushoName"));
            }

            public txtTantoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTantoshaName"));
            }

            public line1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line1"));
            }

            public btnDecide(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDecide"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

