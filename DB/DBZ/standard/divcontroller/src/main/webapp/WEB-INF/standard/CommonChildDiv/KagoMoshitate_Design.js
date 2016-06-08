var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KagoMoshitate.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KagoMoshitate";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KagoMoshitate = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtSendYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendYM"));
            };

            Controls.prototype.txtMoshitateshaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtMoshitateshaKubun"));
            };

            Controls.prototype.txtShokisaiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            };

            Controls.prototype.txtShokisaiHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShokisaiHokenshaName"));
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtKagoForm = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoForm"));
            };

            Controls.prototype.txtMoshitateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMoshitateDate"));
            };

            Controls.prototype.ddlKagoMoshitateRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKagoMoshitateRiyu"));
            };

            Controls.prototype.chkForDogetsuShinsa = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkForDogetsuShinsa"));
            };
            return Controls;
        })();
        KagoMoshitate.Controls = Controls;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
