/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyodoJukyushaIdoRenrakuhyoShokai {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyodoJukyushaIdoRenrakuhyoShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyoShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyoShokai.Controls.myType() + "_" + fieldName;
            }

            public KyodoJukyushaIdoRenrakuhyoShokai(): UZA.Panel {
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

            public KyodoJukyushaIdoRenrakuhyoKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihon"));
            }

            public TextBoxNum1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum1"));
            }

            public TextBox16(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox16"));
            }

            public TextBox17(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox17"));
            }

            public TextBox18(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox18"));
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

            public KyodoJukyushaIdoRenrakuhyoShokan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokan"));
            }

            public TextBoxNum4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum4"));
            }

            public TextBox19(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox19"));
            }

            public TextBox20(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox20"));
            }

            public TextBox21(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox21"));
            }

            public TextBoxDateRange1(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("TextBoxDateRange1"));
            }

            public TextBox22(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox22"));
            }

            public TextBoxNum2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum2"));
            }

            public KyodoJukyushaIdoRenrakuhyoKogaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku"));
            }

            public TextBoxNum3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum3"));
            }

            public TextBox8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox8"));
            }

            public TextBox9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox9"));
            }

            public TextBox10(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox10"));
            }

            public TextBox6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox6"));
            }

            public TextBox11(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox11"));
            }

            public TextBox12(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox12"));
            }

            public Panel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku_Panel1"));
            }

            public TextBox13(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox13"));
            }

            public TextBox14(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox14"));
            }

            public TextBox15(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox15"));
            }

        }

     }

}

