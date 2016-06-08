var DBD;
(function (DBD) {
    (function (IchijiSashitome1Go) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IchijiSashitome1Go.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IchijiSashitome1Go";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.IchijiSashitome1Go.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.IchijiSashitome1Go.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IchijiSashitome1Go = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SashitomeTorokuOrKojoToroku = function () {
                return new UZA.Panel(this.convFiledName("SashitomeTorokuOrKojoToroku"));
            };

            Controls.prototype.btnSashitomeToroku = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeToroku"));
            };

            Controls.prototype.btnKojoToroku = function () {
                return new UZA.Button(this.convFiledName("btnKojoToroku"));
            };

            Controls.prototype.SashitomeOrKojoJokyoShokai = function () {
                return new UZA.Panel(this.convFiledName("SashitomeOrKojoJokyoShokai"));
            };

            Controls.prototype.btnSashitomeOrKojoJokyoShokai = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoJokyoShokai"));
            };

            Controls.prototype.ShokanJoho = function () {
                return new UZA.Panel(this.convFiledName("ShokanJoho"));
            };

            Controls.prototype.lblKyufuIchijiSashitomeTorokuShokanJoho = function () {
                return new UZA.Label(this.convFiledName("lblKyufuIchijiSashitomeTorokuShokanJoho"));
            };

            Controls.prototype.txtKyufuIchijiSashitomeTorokuSagakuGokeiKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuIchijiSashitomeTorokuSagakuGokeiKingaku"));
            };

            Controls.prototype.dgSashitomeOrKojoJokyoShokai = function () {
                return new UZA.DataGrid(this.convFiledName("dgSashitomeOrKojoJokyoShokai"));
            };

            Controls.prototype.dgKyufuIchijiSashitomeTorokuOrHokenryoKojoToroku = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyufuIchijiSashitomeTorokuOrHokenryoKojoToroku"));
            };

            Controls.prototype.SashitomeTorokuOrKojoTorokuOrKojoJokyoShokai = function () {
                return new UZA.Panel(this.convFiledName("SashitomeTorokuOrKojoTorokuOrKojoJokyoShokai"));
            };

            Controls.prototype.txtSashitomeTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtSashitomeTorokuKubun"));
            };

            Controls.prototype.txtSashitomeTorokuSashitomeTorokubi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuSashitomeTorokubi"));
            };

            Controls.prototype.txtSashitomeTorokuSashitomeNofuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuSashitomeNofuKigen"));
            };

            Controls.prototype.txtSashitomeTorokuTuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuTuchiHakkobi"));
            };

            Controls.prototype.txtKojoTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKojoTorokuKubun"));
            };

            Controls.prototype.txtKojoTorokuKojoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuKojoKetteibi"));
            };

            Controls.prototype.txtKojoTorokuHokenshoTeishutsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuHokenshoTeishutsuKigen"));
            };

            Controls.prototype.txtKojoTorokuTuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuTuchiHakkobi"));
            };

            Controls.prototype.ddlKojoTorokuKojoNo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKojoTorokuKojoNo"));
            };

            Controls.prototype.SashitomeToroku = function () {
                return new UZA.Panel(this.convFiledName("SashitomeToroku"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiSashitomeTorokubi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeTorokubi"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiSashitomeNofuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeNofuKigen"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiSashitomeTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeTorokuTsuchiHakkobi"));
            };

            Controls.prototype.SasitomeKaijo = function () {
                return new UZA.Panel(this.convFiledName("SasitomeKaijo"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiSashitomeKaijobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiSashitomeKaijobi"));
            };

            Controls.prototype.Kojotoroku = function () {
                return new UZA.Panel(this.convFiledName("Kojotoroku"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiKojoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiKojoKetteibi"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiHokenshoTeishutsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiHokenshoTeishutsuKigen"));
            };

            Controls.prototype.txtSashitomeKojoJokyoShokaiKojoTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKojoJokyoShokaiKojoTorokuTsuchiHakkobi"));
            };

            Controls.prototype.txtSashitomeOrKojoJokyoShokaiKojoTorokuKojoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtSashitomeOrKojoJokyoShokaiKojoTorokuKojoNo"));
            };

            Controls.prototype.TainoJokyo = function () {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            };

            Controls.prototype.btnTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTainoJokyo"));
            };

            Controls.prototype.btnSashitomeOrKojoJokyoShokaiClose = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoJokyoShokaiClose"));
            };

            Controls.prototype.btnSashitomeOrKojoTorokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoTorokuKakutei"));
            };

            Controls.prototype.btnSashitomeOrKojoTorokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoTorokuTorikeshi"));
            };

            Controls.prototype.IchijiSashitome1GoKakutei = function () {
                return new UZA.Button(this.convFiledName("IchijiSashitome1GoKakutei"));
            };

            Controls.prototype.IchijiSashitome1GoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("IchijiSashitome1GoTorikeshi"));
            };
            return Controls;
        })();
        IchijiSashitome1Go.Controls = Controls;
    })(DBD.IchijiSashitome1Go || (DBD.IchijiSashitome1Go = {}));
    var IchijiSashitome1Go = DBD.IchijiSashitome1Go;
})(DBD || (DBD = {}));
