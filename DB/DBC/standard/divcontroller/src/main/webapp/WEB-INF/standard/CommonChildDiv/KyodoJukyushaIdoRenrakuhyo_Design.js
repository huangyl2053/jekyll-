var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyodoJukyushaIdoRenrakuhyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyodoJukyushaIdoRenrakuhyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TextBox1 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox1"));
            };

            Controls.prototype.TextBoxDate1 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate1"));
            };

            Controls.prototype.TextBoxDate2 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate2"));
            };

            Controls.prototype.TextBox2 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox2"));
            };

            Controls.prototype.RadioButton5 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton5"));
            };

            Controls.prototype.DropDownList1 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList1"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoTeisei = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));
            };

            Controls.prototype.HorizontalLine1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine1"));
            };

            Controls.prototype.TextBoxDate3 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate3"));
            };

            Controls.prototype.RadioButton6 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton6"));
            };

            Controls.prototype.HorizontalLine5 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine5"));
            };

            Controls.prototype.CheckBoxList1 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList1"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKihon = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihon"));
            };

            Controls.prototype.TextBoxDate4 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate4"));
            };

            Controls.prototype.TextBoxNum1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum1"));
            };

            Controls.prototype.HorizontalLine2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine2"));
            };

            Controls.prototype.TextBox3 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox3"));
            };

            Controls.prototype.TextBox4 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox4"));
            };

            Controls.prototype.TextBox5 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox5"));
            };

            Controls.prototype.TextBoxYubinNo1 = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("TextBoxYubinNo1"));
            };

            Controls.prototype.TextBox7 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox7"));
            };

            Controls.prototype.TextBoxKana1 = function () {
                return new UZA.TextBoxKana(this.convFiledName("TextBoxKana1"));
            };

            Controls.prototype.CheckBoxList2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList2"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoShokan = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokan"));
            };

            Controls.prototype.TextBoxDate5 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate5"));
            };

            Controls.prototype.TextBoxNum2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum2"));
            };

            Controls.prototype.HorizontalLine3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine3"));
            };

            Controls.prototype.TextBoxDateRange1 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("TextBoxDateRange1"));
            };

            Controls.prototype.DropDownList7 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList7"));
            };

            Controls.prototype.TextBoxNum4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum4"));
            };

            Controls.prototype.CheckBoxList3 = function () {
                return new UZA.CheckBoxList(this.convFiledName("CheckBoxList3"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKogaku = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku"));
            };

            Controls.prototype.TextBoxDate6 = function () {
                return new UZA.TextBoxDate(this.convFiledName("TextBoxDate6"));
            };

            Controls.prototype.TextBoxNum3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("TextBoxNum3"));
            };

            Controls.prototype.HorizontalLine4 = function () {
                return new UZA.HorizontalLine(this.convFiledName("HorizontalLine4"));
            };

            Controls.prototype.TextBox6 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox6"));
            };

            Controls.prototype.DropDownList8 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList8"));
            };

            Controls.prototype.DropDownList9 = function () {
                return new UZA.DropDownList(this.convFiledName("DropDownList9"));
            };

            Controls.prototype.Panel1 = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogaku_Panel1"));
            };

            Controls.prototype.RadioButton1 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton1"));
            };

            Controls.prototype.RadioButton2 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton2"));
            };

            Controls.prototype.RadioButton3 = function () {
                return new UZA.RadioButton(this.convFiledName("RadioButton3"));
            };
            return Controls;
        })();
        KyodoJukyushaIdoRenrakuhyo.Controls = Controls;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
