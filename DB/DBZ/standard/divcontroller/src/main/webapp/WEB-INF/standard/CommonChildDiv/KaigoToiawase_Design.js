var DBZ;
(function (DBZ) {
    (function (KaigoToiawase) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoToiawase.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoToiawase";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoToiawase.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoToiawase.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoToiawase = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlHakkoBusho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHakkoBusho"));
            };

            Controls.prototype.InjiNaiyo = function () {
                return new UZA.Panel(this.convFiledName("InjiNaiyo"));
            };

            Controls.prototype.ddlBusho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBusho"));
            };

            Controls.prototype.dllBushomeiKuhakuUMu = function () {
                return new UZA.DropDownList(this.convFiledName("dllBushomeiKuhakuUMu"));
            };

            Controls.prototype.txtName = function () {
                return new UZA.TextBox(this.convFiledName("txtName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtNaisenNo = function () {
                return new UZA.TextBox(this.convFiledName("txtNaisenNo"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.ddlKenmeiFuyo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKenmeiFuyo"));
            };

            Controls.prototype.ddlShichoshonMei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShichoshonMei"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            };
            return Controls;
        })();
        KaigoToiawase.Controls = Controls;
    })(DBZ.KaigoToiawase || (DBZ.KaigoToiawase = {}));
    var KaigoToiawase = DBZ.KaigoToiawase;
})(DBZ || (DBZ = {}));
