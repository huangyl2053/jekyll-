var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoKihon) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeOpenDialog_btnChosaTokkiImageShokai = function () {
                return "onBeforeOpenDialog_btnChosaTokkiImageShokai";
            };

            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
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

            Controls.prototype.lblJisshiBasho = function () {
                return new UZA.Label(this.convFiledName("lblJisshiBasho"));
            };

            Controls.prototype.txtChosaJisshiBashoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            };

            Controls.prototype.JisshiBashoMeishoPanel = function () {
                return new UZA.Panel(this.convFiledName("JisshiBashoMeishoPanel"));
            };

            Controls.prototype.imgChosaJisshiBashoMeisho = function () {
                return new UZA.DynamicImage(this.convFiledName("imgChosaJisshiBashoMeisho"));
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

            Controls.prototype.btnChosaTokkiImageShokai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaTokkiImageShokai"));
            };

            Controls.prototype.txtShogaiNichijoSeikatsuJiritsudoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaiNichijoSeikatsuJiritsudoCode"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ChosaKekkaInfoKihon.Controls = Controls;
    })(DBE.ChosaKekkaInfoKihon || (DBE.ChosaKekkaInfoKihon = {}));
    var ChosaKekkaInfoKihon = DBE.ChosaKekkaInfoKihon;
})(DBE || (DBE = {}));
