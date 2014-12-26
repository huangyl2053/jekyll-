/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyodoJukyushaIdoRenrakuhyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyodoJukyushaIdoRenrakuhyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            }

            public KyodoJukyushaIdoRenrakuhyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TextBox1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox1"));
            }

            public TextBoxDate1(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate1"));
            }

            public TextBoxDate2(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate2"));
            }

            public TextBox2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox2"));
            }

            public RadioButton5(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("RadioButton5"));
            }

            public DropDownList1(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("DropDownList1"));
            }

            public KyodoJukyushaIdoRenrakuhyoTeisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));
            }

            public HorizontalLine1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine1"));
            }

            public TextBoxDate3(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate3"));
            }

            public RadioButton6(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("RadioButton6"));
            }

            public HorizontalLine5(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine5"));
            }

            public CheckBoxList1(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList1"));
            }

            public KyodoJukyushaIdoRenrakuhyoKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihon"));
            }

            public TextBoxDate4(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate4"));
            }

            public TextBoxNum1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum1"));
            }

            public HorizontalLine2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine2"));
            }

            public TextBox3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox3"));
            }

            public TextBox4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox4"));
            }

            public TextBox5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox5"));
            }

            public TextBoxYubinNo1(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("TextBoxYubinNo1"));
            }

            public TextBox7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox7"));
            }

            public TextBoxKana1(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("TextBoxKana1"));
            }

            public CheckBoxList2(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList2"));
            }

            public KyodoJukyushaIdoRenrakuhyoShokan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokan"));
            }

            public TextBoxDate5(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate5"));
            }

            public TextBoxNum2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum2"));
            }

            public HorizontalLine3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine3"));
            }

            public TextBoxDateRange1(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("TextBoxDateRange1"));
            }

            public DropDownList7(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("DropDownList7"));
            }

            public TextBoxNum4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum4"));
            }

            public CheckBoxList3(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList3"));
            }

            public KyodoJukyushaIdoRenrakuhyoKogaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku"));
            }

            public TextBoxDate6(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate6"));
            }

            public TextBoxNum3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum3"));
            }

            public HorizontalLine4(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine4"));
            }

            public TextBox6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox6"));
            }

            public DropDownList8(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("DropDownList8"));
            }

            public DropDownList9(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("DropDownList9"));
            }

            public Panel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku_Panel1"));
            }

            public RadioButton1(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("RadioButton1"));
            }

            public RadioButton2(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("RadioButton2"));
            }

            public RadioButton3(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("RadioButton3"));
            }

        }

     }

}

