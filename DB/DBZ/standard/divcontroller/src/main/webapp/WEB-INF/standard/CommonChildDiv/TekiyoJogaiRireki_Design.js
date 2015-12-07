var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TekiyoJogaiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TekiyoJogaiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.TekiyoJogaiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TekiyoJogaiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TekiyoJogaiRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.panelTekiyoRireki = function () {
                return new UZA.Panel(this.convFiledName("panelTekiyoRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.datagridTekiyoJogai = function () {
                return new UZA.DataGrid(this.convFiledName("datagridTekiyoJogai"));
            };

            Controls.prototype.panelTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("panelTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoTodokeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.txtNyusyoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyusyoDate"));
            };

            Controls.prototype.txtKayijoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKayijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijyoJiyu"));
            };

            Controls.prototype.txtTaisyoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoDate"));
            };

            Controls.prototype.panelTekiyoJokaiTekiInput = function () {
                return new UZA.Panel(this.convFiledName("panelTekiyoJokaiTekiInput"));
            };

            Controls.prototype.panelJogaisyaTekiyo = function () {
                return new UZA.Panel(this.convFiledName("panelJogaisyaTekiyo"));
            };

            Controls.prototype.txtNyusyoDateInput = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyusyoDateInput"));
            };

            Controls.prototype.txtTekiyoDateInput = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoDateInput"));
            };

            Controls.prototype.txtTkyoTododkDateIn = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTkyoTododkDateIn"));
            };

            Controls.prototype.ddlTekiyoJiyuInput = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyuInput"));
            };

            Controls.prototype.ccdShisetsuJoho = function () {
                return new DBZ.ShisetsuJoho.ModeController(this.convFiledName("ccdShisetsuJoho"));
            };

            Controls.prototype.panelTekiyoJokaiKaiJyoInput = function () {
                return new UZA.Panel(this.convFiledName("panelTekiyoJokaiKaiJyoInput"));
            };

            Controls.prototype.panelJogaisyaKaijo = function () {
                return new UZA.Panel(this.convFiledName("panelJogaisyaKaijo"));
            };

            Controls.prototype.txtTaisyoDateInput = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoDateInput"));
            };

            Controls.prototype.txtKaijoDateInput = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoDateInput"));
            };

            Controls.prototype.txtKaijoTododkDateIn = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTododkDateIn"));
            };

            Controls.prototype.ddlKaijoJiyuInput = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyuInput"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnInputClear = function () {
                return new UZA.Button(this.convFiledName("btnInputClear"));
            };
            return Controls;
        })();
        TekiyoJogaiRireki.Controls = Controls;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));
