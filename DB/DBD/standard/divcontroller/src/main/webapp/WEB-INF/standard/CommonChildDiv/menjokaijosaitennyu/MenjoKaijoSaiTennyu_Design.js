var DBD;
(function (DBD) {
    (function (MenjoKaijoSaiTennyu) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        MenjoKaijoSaiTennyu.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "MenjoKaijoSaiTennyu";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.MenjoKaijoSaiTennyu.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.MenjoKaijoSaiTennyu.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.MenjoKaijoSaiTennyu = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid = function () {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu2 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu2"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu3 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu3"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu4 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu4"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu5 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu5"));
            };

            Controls.prototype.IchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuToroku = function () {
                return new UZA.Panel(this.convFiledName("IchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuToroku"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuJokyo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuKyufugakuGengakuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuKyufugakuGengakuKikan"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuChoshukenShometsuKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuChoshukenShometsuKikan"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuNofuzumiKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuNofuzumiKikan"));
            };

            Controls.prototype.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuKetteibi"));
            };

            Controls.prototype.btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTainoJokyo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanKaishi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanShuryo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTsuchiHakkobi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishiInput = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishiInput"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryoInput = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryoInput"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };

            Controls.prototype.dgIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu = function () {
                return new UZA.DataGrid(this.convFiledName("dgIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu"));
            };

            Controls.prototype.btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose = function () {
                return new UZA.Button(this.convFiledName("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose"));
            };
            return Controls;
        })();
        MenjoKaijoSaiTennyu.Controls = Controls;
    })(DBD.MenjoKaijoSaiTennyu || (DBD.MenjoKaijoSaiTennyu = {}));
    var MenjoKaijoSaiTennyu = DBD.MenjoKaijoSaiTennyu;
})(DBD || (DBD = {}));
