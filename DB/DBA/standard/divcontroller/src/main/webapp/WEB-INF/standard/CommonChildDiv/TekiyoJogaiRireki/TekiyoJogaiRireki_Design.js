var DBA;
(function (DBA) {
    (function (TekiyoJogaiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnAdd = function () {
                return "onClick_BtnAdd";
            };

            Events.onClick_Selected = function () {
                return "onClick_Selected";
            };

            Events.onClick_Update = function () {
                return "onClick_Update";
            };

            Events.onClick_Delete = function () {
                return "onClick_Delete";
            };

            Events.onBlur_TekiyoRireki = function () {
                return "onBlur_TekiyoRireki";
            };

            Events.onBlur_KayijoRireki = function () {
                return "onBlur_KayijoRireki";
            };

            Events.onBlur_Tekiyo = function () {
                return "onBlur_Tekiyo";
            };

            Events.onBlur_Kayijo = function () {
                return "onBlur_Kayijo";
            };

            Events.onClick_BtnKakunin = function () {
                return "onClick_BtnKakunin";
            };

            Events.onClick_Torikeshi = function () {
                return "onClick_Torikeshi";
            };
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
                return this._myName + "_" + DBA.TekiyoJogaiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.TekiyoJogaiRireki.Controls.myType() + "_" + fieldName;
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

            Controls.prototype.txtKayijoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKayijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijyoJiyu"));
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
    })(DBA.TekiyoJogaiRireki || (DBA.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBA.TekiyoJogaiRireki;
})(DBA || (DBA = {}));
