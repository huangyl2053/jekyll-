var DBA;
(function (DBA) {
    (function (JukyuSikakuShomeishoHakkoCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyuSikakuShomeishoHakkoCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuSikakuShomeishoHakkoCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.JukyuSikakuShomeishoHakkoCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.JukyuSikakuShomeishoHakkoCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuSikakuShomeishoHakkoCommonChildDiv = function () {
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
        JukyuSikakuShomeishoHakkoCommonChildDiv.Controls = Controls;
    })(DBA.JukyuSikakuShomeishoHakkoCommonChildDiv || (DBA.JukyuSikakuShomeishoHakkoCommonChildDiv = {}));
    var JukyuSikakuShomeishoHakkoCommonChildDiv = DBA.JukyuSikakuShomeishoHakkoCommonChildDiv;
})(DBA || (DBA = {}));
