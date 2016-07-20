var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChosaKekkaInfoKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaKekkaInfoKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaKekkaInfoKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaKekkaInfoKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaKekkaInfoKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNinteichosaJisshiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteichosaJisshiYMD"));
            };

            Controls.prototype.txtChosaJisshiBashoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            };

            Controls.prototype.KihonChosaPanel = function () {
                return new UZA.Panel(this.convFiledName("KihonChosaPanel"));
            };

            Controls.prototype.dgKihonChosa = function () {
                return new UZA.DataGrid(this.convFiledName("dgKihonChosa"));
            };

            Controls.prototype.txtNinchishoNichijoSeikatsuJiritsudoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNinchishoNichijoSeikatsuJiritsudoCode"));
            };

            Controls.prototype.txtShogaiNichijoSeikatsuJiritsudoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaiNichijoSeikatsuJiritsudoCode"));
            };

            Controls.prototype.Button1 = function () {
                return new UZA.Button(this.convFiledName("Button1"));
            };
            return Controls;
        })();
        ChosaKekkaInfoKihon.Controls = Controls;
    })(DBE.ChosaKekkaInfoKihon || (DBE.ChosaKekkaInfoKihon = {}));
    var ChosaKekkaInfoKihon = DBE.ChosaKekkaInfoKihon;
})(DBE || (DBE = {}));
