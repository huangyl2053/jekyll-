var DBD;
(function (DBD) {
    (function (KyufuGengaku1Go) {
        var Events = (function () {
            function Events() {
            }
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
            return Events;
        })();
        KyufuGengaku1Go.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuGengaku1Go";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.KyufuGengaku1Go.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.KyufuGengaku1Go.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuGengaku1Go = function () {
                return new UZA.Panel(this.convFiledNameSelf());
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

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.GengakuTorokuOrMenjoShinsei = function () {
                return new UZA.Panel(this.convFiledName("GengakuTorokuOrMenjoShinsei"));
            };

            Controls.prototype.txtGengakuKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuKetteiYMD"));
            };

            Controls.prototype.txtZenkaiKikanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanKaishiYMD"));
            };

            Controls.prototype.txtZenkaiKikanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanShuryoYMD"));
            };

            Controls.prototype.txtKyufuGengakuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGengakuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtKonkaiKikanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanKaishiYMD"));
            };

            Controls.prototype.txtKonkaiKikanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanShuryoYMD"));
            };

            Controls.prototype.ddlMenjoShinseiJokyo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlMenjoShinseiJokyo"));
            };

            Controls.prototype.txtMenjoShinseiUketsukeYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtMenjoShinseiUketsukeYMD"));
            };

            Controls.prototype.txtMenjoShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtMenjoShinseiYMD"));
            };

            Controls.prototype.ddlIMenjoShinseiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIMenjoShinseiRiyu"));
            };

            Controls.prototype.txtMenjoNaiyoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtMenjoNaiyoKetteiYMD"));
            };

            Controls.prototype.ddlMenjoShinseiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlMenjoShinseiShinsaKekka"));
            };

            Controls.prototype.TainoJokyo = function () {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            };

            Controls.prototype.btnTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTainoJokyo"));
            };

            Controls.prototype.KakuteiTorikeshi = function () {
                return new UZA.Panel(this.convFiledName("KakuteiTorikeshi"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        KyufuGengaku1Go.Controls = Controls;
    })(DBD.KyufuGengaku1Go || (DBD.KyufuGengaku1Go = {}));
    var KyufuGengaku1Go = DBD.KyufuGengaku1Go;
})(DBD || (DBD = {}));
