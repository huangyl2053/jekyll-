var DBD;
(function (DBD) {
    (function (MenjoKaijoSaiTennyu) {
        var Events = (function () {
            function Events() {
            }
            Events.selectedItem = function () {
                return "selectedItem";
            };

            Events.onOkClose_BtnTainoJokyo = function () {
                return "onOkClose_BtnTainoJokyo";
            };

            Events.onBeforeOpenDialog_BtnTainoJokyo = function () {
                return "onBeforeOpenDialog_BtnTainoJokyo";
            };

            Events.onClick_BtnKakutei = function () {
                return "onClick_BtnKakutei";
            };

            Events.onClick_BtnTorikeshi = function () {
                return "onClick_BtnTorikeshi";
            };

            Events.onClick_btnToJiRu = function () {
                return "onClick_btnToJiRu";
            };
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

            Controls.prototype.dgMenjoKaijoOrSaitennyu = function () {
                return new UZA.DataGrid(this.convFiledName("dgMenjoKaijoOrSaitennyu"));
            };

            Controls.prototype.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid = function () {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid"));
            };

            Controls.prototype.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1 = function () {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1"));
            };

            Controls.prototype.lblExplanation2 = function () {
                return new UZA.Label(this.convFiledName("lblExplanation2"));
            };

            Controls.prototype.lblExplanation3 = function () {
                return new UZA.Label(this.convFiledName("lblExplanation3"));
            };

            Controls.prototype.lblExplanation4 = function () {
                return new UZA.Label(this.convFiledName("lblExplanation4"));
            };

            Controls.prototype.lblExplanation5 = function () {
                return new UZA.Label(this.convFiledName("lblExplanation5"));
            };

            Controls.prototype.KyufugakuGengakuToroku = function () {
                return new UZA.Panel(this.convFiledName("KyufugakuGengakuToroku"));
            };

            Controls.prototype.txtTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            };

            Controls.prototype.txtKyufugakuGengakuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufugakuGengakuKikan"));
            };

            Controls.prototype.txtGengakuTekiyoKikanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTekiyoKikanKaishiYMD"));
            };

            Controls.prototype.txtGengakuTekiyoKikanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTekiyoKikanShuryoYMD"));
            };

            Controls.prototype.txtChoshukenShometsuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoshukenShometsuKikan"));
            };

            Controls.prototype.txtNofuzumiKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumiKikan"));
            };

            Controls.prototype.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo"));
            };

            Controls.prototype.txtGengakuKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuKetteiYMD"));
            };

            Controls.prototype.txtTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("txtTainoJokyo"));
            };

            Controls.prototype.txtZenkaiKikanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanKaishiYMD"));
            };

            Controls.prototype.txtZenkaiKikanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanShuryoYMD"));
            };

            Controls.prototype.txtGengakuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtKonkaiKikanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanKaishiYMD"));
            };

            Controls.prototype.txtKonkaiKikanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanShuryoYMD"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
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
