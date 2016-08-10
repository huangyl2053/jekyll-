var DBD;
(function (DBD) {
    (function (IchijiSashitome1Go) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_SashitomeToRoku = function () {
                return "onClick_SashitomeToRoku";
            };

            Events.onClick_KaijoToRoku = function () {
                return "onClick_KaijoToRoku";
            };

            Events.onClick_SashitomeKojo = function () {
                return "onClick_SashitomeKojo";
            };

            Events.onClick_SelectedItem = function () {
                return "onClick_SelectedItem";
            };

            Events.onClick_DeleteItem = function () {
                return "onClick_DeleteItem";
            };

            Events.onOkClose_BtnTainoJokyo = function () {
                return "onOkClose_BtnTainoJokyo";
            };

            Events.onBeforeOpenDialog_BtnTainoJokyo = function () {
                return "onBeforeOpenDialog_BtnTainoJokyo";
            };

            Events.onClick_SashitomeToRokuKaKuTei = function () {
                return "onClick_SashitomeToRokuKaKuTei";
            };

            Events.onClick_SashitomeToRokuToRiKeShi = function () {
                return "onClick_SashitomeToRokuToRiKeShi";
            };

            Events.onClick_BtnKakutei = function () {
                return "onClick_BtnKakutei";
            };

            Events.onClick_BtnTorikeshi = function () {
                return "onClick_BtnTorikeshi";
            };
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

            Controls.prototype.btnSashitomeToroku = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeToroku"));
            };

            Controls.prototype.btnKojoToroku = function () {
                return new UZA.Button(this.convFiledName("btnKojoToroku"));
            };

            Controls.prototype.btnSashitomeOrKojoJokyoShokai = function () {
                return new UZA.Button(this.convFiledName("btnSashitomeOrKojoJokyoShokai"));
            };

            Controls.prototype.dgSashitomeKojoIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgSashitomeKojoIchiran"));
            };

            Controls.prototype.ShokanJoho = function () {
                return new UZA.Panel(this.convFiledName("ShokanJoho"));
            };

            Controls.prototype.lblShokanJoho = function () {
                return new UZA.Label(this.convFiledName("lblShokanJoho"));
            };

            Controls.prototype.txtSagakuKingakuGokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSagakuKingakuGokei"));
            };

            Controls.prototype.dgShokanJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgShokanJoho"));
            };

            Controls.prototype.SashitomeKojoJokyo = function () {
                return new UZA.Panel(this.convFiledName("SashitomeKojoJokyo"));
            };

            Controls.prototype.txtSashitomeTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtSashitomeTorokuKubun"));
            };

            Controls.prototype.txtSashitomeTorokuYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuYMD"));
            };

            Controls.prototype.txtSashitomeTorokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTorokuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtSashitomeNofuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeNofuKigenYMD"));
            };

            Controls.prototype.txtSashitomeKaijoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKaijoYMD"));
            };

            Controls.prototype.txtKojoTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKojoTorokuKubun"));
            };

            Controls.prototype.txtKojoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoKetteiYMD"));
            };

            Controls.prototype.txtKojoTorokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKojoTorokuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtHokenshoTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHokenshoTeishutsuKigenYMD"));
            };

            Controls.prototype.ddlTorokuKojoNo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTorokuKojoNo"));
            };

            Controls.prototype.SashitomeToroku = function () {
                return new UZA.Panel(this.convFiledName("SashitomeToroku"));
            };

            Controls.prototype.txtShokaiSashitomeTorokuYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeTorokuYMD"));
            };

            Controls.prototype.txtShokaiSashitomeNofuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeNofuKigenYMD"));
            };

            Controls.prototype.txtShokaiSashitomeTorokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeTorokuTsuchiHakkoYMD"));
            };

            Controls.prototype.SasitomeKaijo = function () {
                return new UZA.Panel(this.convFiledName("SasitomeKaijo"));
            };

            Controls.prototype.txtShokaiSashitomeKaijoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiSashitomeKaijoYMD"));
            };

            Controls.prototype.KojoToroku = function () {
                return new UZA.Panel(this.convFiledName("KojoToroku"));
            };

            Controls.prototype.txtShokaiKojoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiKojoKetteiYMD"));
            };

            Controls.prototype.txtShokaiHokenshoTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiHokenshoTeishutsuKigenYMD"));
            };

            Controls.prototype.txtShokaiKojoTorokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokaiKojoTorokuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtShokaiKojoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtShokaiKojoNo"));
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
