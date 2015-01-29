var DBB;
(function (DBB) {
    (function (KaigoNonyutuchishoHakkoJoken) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNonyutuchishoHakkoJoken.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNonyutuchishoHakkoJoken";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.KaigoNonyutuchishoHakkoJoken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.KaigoNonyutuchishoHakkoJoken.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNonyutuchishoHakkoJoken = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHakkoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoYmd"));
            };

            Controls.prototype.lblMsg = function () {
                return new UZA.Label(this.convFiledName("lblMsg"));
            };

            Controls.prototype.txtShutsuryokuKi = function () {
                return new UZA.TextBox(this.convFiledName("txtShutsuryokuKi"));
            };

            Controls.prototype.ddlShutsuryokuKi = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShutsuryokuKi"));
            };

            Controls.prototype.chkTaishosha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTaishosha"));
            };

            Controls.prototype.radSeiho = function () {
                return new UZA.RadioButton(this.convFiledName("radSeiho"));
            };

            Controls.prototype.radYamawake = function () {
                return new UZA.RadioButton(this.convFiledName("radYamawake"));
            };
            return Controls;
        })();
        KaigoNonyutuchishoHakkoJoken.Controls = Controls;
    })(DBB.KaigoNonyutuchishoHakkoJoken || (DBB.KaigoNonyutuchishoHakkoJoken = {}));
    var KaigoNonyutuchishoHakkoJoken = DBB.KaigoNonyutuchishoHakkoJoken;
})(DBB || (DBB = {}));
