var DBZ;
(function (DBZ) {
    (function (JukyuSikakuShomeishoHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyuSikakuShomeishoHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuSikakuShomeishoHakko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JukyuSikakuShomeishoHakko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JukyuSikakuShomeishoHakko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuSikakuShomeishoHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlJukyushaJoho1 = function () {
                return new UZA.Panel(this.convFiledName("pnlJukyushaJoho1"));
            };

            Controls.prototype.txtKofubi = function () {
                return new UZA.TextBox(this.convFiledName("txtKofubi"));
            };

            Controls.prototype.txtIdoYotebi = function () {
                return new UZA.TextBox(this.convFiledName("txtIdoYotebi"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtShinsebi = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsebi"));
            };

            Controls.prototype.txtdrYukokikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtdrYukokikan"));
            };

            Controls.prototype.txtfutanWariaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtfutanWariaiKubun"));
            };

            Controls.prototype.txtfutanWariai = function () {
                return new UZA.TextBox(this.convFiledName("txtfutanWariai"));
            };

            Controls.prototype.cblInji = function () {
                return new UZA.CheckBoxList(this.convFiledName("cblInji"));
            };

            Controls.prototype.pnlJukyushaJoho2 = function () {
                return new UZA.Panel(this.convFiledName("pnlJukyushaJoho2"));
            };

            Controls.prototype.lblShinsakaiYikan = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiYikan"));
            };

            Controls.prototype.tbmShinsakaiYikan = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("tbmShinsakaiYikan"));
            };

            Controls.prototype.lblBiko = function () {
                return new UZA.Label(this.convFiledName("lblBiko"));
            };

            Controls.prototype.tbmBiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("tbmBiko"));
            };
            return Controls;
        })();
        JukyuSikakuShomeishoHakko.Controls = Controls;
    })(DBZ.JukyuSikakuShomeishoHakko || (DBZ.JukyuSikakuShomeishoHakko = {}));
    var JukyuSikakuShomeishoHakko = DBZ.JukyuSikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
