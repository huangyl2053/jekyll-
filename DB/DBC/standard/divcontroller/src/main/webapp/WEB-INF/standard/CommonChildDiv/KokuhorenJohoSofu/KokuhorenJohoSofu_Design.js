var DBC;
(function (DBC) {
    (function (KokuhorenJohoSofu) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KokuhorenJohoSofu.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KokuhorenJohoSofu";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KokuhorenJohoSofu.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KokuhorenJohoSofu.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KokuhorenJohoSofu = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblChushutsuJoken = function () {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            };

            Controls.prototype.txtShoriSaikuruKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShoriSaikuruKubun"));
            };

            Controls.prototype.txtShoritaishoNengetsu = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShoritaishoNengetsu"));
            };

            Controls.prototype.txtsaishoriKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtsaishoriKubun"));
            };

            Controls.prototype.txtFileName = function () {
                return new UZA.TextBox(this.convFiledName("txtFileName"));
            };

            Controls.prototype.ddlSofuTaishojoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSofuTaishojoho"));
            };

            Controls.prototype.ShoriJikkoMaekakuninJiko = function () {
                return new UZA.Panel(this.convFiledName("ShoriJikkoMaekakuninJiko"));
            };

            Controls.prototype.lblKakuninJiko1 = function () {
                return new UZA.Label(this.convFiledName("lblKakuninJiko1"));
            };

            Controls.prototype.lblKakuninJiko2 = function () {
                return new UZA.Label(this.convFiledName("lblKakuninJiko2"));
            };
            return Controls;
        })();
        KokuhorenJohoSofu.Controls = Controls;
    })(DBC.KokuhorenJohoSofu || (DBC.KokuhorenJohoSofu = {}));
    var KokuhorenJohoSofu = DBC.KokuhorenJohoSofu;
})(DBC || (DBC = {}));
