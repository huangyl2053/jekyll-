var DBD;
(function (DBD) {
    (function (KyufuGengaku1Go) {
        var Events = (function () {
            function Events() {
            }
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

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuKyufugakuGengakuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuKyufugakuGengakuKikan"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuGengakuMenjoShinseiChoshukenShometsuKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiChoshukenShometsuKikan"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuNofuzumiKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuNofuzumiKikan"));
            };

            Controls.prototype.linIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo"));
            };

            Controls.prototype.IchigoKyufugakuGengakuTorokuSinsei = function () {
                return new UZA.Panel(this.convFiledName("IchigoKyufugakuGengakuTorokuSinsei"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuKetteibi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanKaishi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanShuryo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTsuchiHakkobi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishiInput = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishiInput"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryoInput = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryoInput"));
            };

            Controls.prototype.ddlIchigoKyufugakuGengakuGengakuMenjoShinseiJokyo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiJokyo"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiUketsukebi"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseibi"));
            };

            Controls.prototype.ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiRiyu"));
            };

            Controls.prototype.txtIchigoKyufugakuGengakuGengakuMenjoShinseiNaiyoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiNaiyoKetteibi"));
            };

            Controls.prototype.ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinsaKekka"));
            };

            Controls.prototype.TainoJokyo = function () {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            };

            Controls.prototype.btnIchigoKyufugakuGengakuTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIchigoKyufugakuGengakuTainoJokyo"));
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
