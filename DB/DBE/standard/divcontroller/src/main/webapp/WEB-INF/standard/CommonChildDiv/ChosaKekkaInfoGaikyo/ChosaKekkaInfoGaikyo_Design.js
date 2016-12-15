var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoGaikyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        ChosaKekkaInfoGaikyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaKekkaInfoGaikyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaKekkaInfoGaikyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaKekkaInfoGaikyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaKekkaInfoGaikyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNinteichosaJisshiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteichosaJisshiYMD"));
            };

            Controls.prototype.lblJisshiBasho = function () {
                return new UZA.Label(this.convFiledName("lblJisshiBasho"));
            };

            Controls.prototype.txtChosaJisshiBashoCode = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoCode"));
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

            Controls.prototype.lblNoImageJisshiBasho = function () {
                return new UZA.Label(this.convFiledName("lblNoImageJisshiBasho"));
            };

            Controls.prototype.GaikyoChosaTokkiPanel = function () {
                return new UZA.Panel(this.convFiledName("GaikyoChosaTokkiPanel"));
            };

            Controls.prototype.txtGaikyoChosaTokki = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoChosaTokki"));
            };

            Controls.prototype.imgGaikyoChosaTokki = function () {
                return new UZA.DynamicImage(this.convFiledName("imgGaikyoChosaTokki"));
            };

            Controls.prototype.lblNoImageGaikyoChosaTokki = function () {
                return new UZA.Label(this.convFiledName("lblNoImageGaikyoChosaTokki"));
            };

            Controls.prototype.radServiceKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            };

            Controls.prototype.rdoJutakuKaishu = function () {
                return new UZA.RadioButton(this.convFiledName("rdoJutakuKaishu"));
            };

            Controls.prototype.ServiceJokyoPanel = function () {
                return new UZA.Panel(this.convFiledName("ServiceJokyoPanel"));
            };

            Controls.prototype.dgServiceJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceJokyo"));
            };

            Controls.prototype.ShisetsuRiyoPanel = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuRiyoPanel"));
            };

            Controls.prototype.lblShisetsuShurui = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuShurui"));
            };

            Controls.prototype.txtRiyoShisetsuShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuShurui"));
            };

            Controls.prototype.lblShisetsuShimei = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuShimei"));
            };

            Controls.prototype.lblTelNo = function () {
                return new UZA.Label(this.convFiledName("lblTelNo"));
            };

            Controls.prototype.txtRiyoShisetsuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuMeisho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.ShisetsuMeishoPanel = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuMeishoPanel"));
            };

            Controls.prototype.imgRiyoShisetsuMeisho = function () {
                return new UZA.DynamicImage(this.convFiledName("imgRiyoShisetsuMeisho"));
            };

            Controls.prototype.lblNoImageRiyoShisetsuMeisho = function () {
                return new UZA.Label(this.convFiledName("lblNoImageRiyoShisetsuMeisho"));
            };

            Controls.prototype.TelNoPanel = function () {
                return new UZA.Panel(this.convFiledName("TelNoPanel"));
            };

            Controls.prototype.imgTelNo = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTelNo"));
            };

            Controls.prototype.lblNoImageTelNo = function () {
                return new UZA.Label(this.convFiledName("lblNoImageTelNo"));
            };

            Controls.prototype.lblRiyoShisetsuJusho = function () {
                return new UZA.Label(this.convFiledName("lblRiyoShisetsuJusho"));
            };

            Controls.prototype.txtRiyoShisetsuJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuJusho"));
            };

            Controls.prototype.ShisetsuJushoPanel = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuJushoPanel"));
            };

            Controls.prototype.imgRiyoShisetsuJusho = function () {
                return new UZA.DynamicImage(this.convFiledName("imgRiyoShisetsuJusho"));
            };

            Controls.prototype.lblNoImageRiyoShisetsuJusho = function () {
                return new UZA.Label(this.convFiledName("lblNoImageRiyoShisetsuJusho"));
            };

            Controls.prototype.TokubetsuKyufuPanel = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuKyufuPanel"));
            };

            Controls.prototype.txtTokubetsuKyufu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokubetsuKyufu"));
            };

            Controls.prototype.imgTokubetsuKyufu = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokubetsuKyufu"));
            };

            Controls.prototype.lblNoImageTokubetsuKyufu = function () {
                return new UZA.Label(this.convFiledName("lblNoImageTokubetsuKyufu"));
            };

            Controls.prototype.ZaitakuServicePanel = function () {
                return new UZA.Panel(this.convFiledName("ZaitakuServicePanel"));
            };

            Controls.prototype.txtZaitakuService = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtZaitakuService"));
            };

            Controls.prototype.imgZaitakuService = function () {
                return new UZA.DynamicImage(this.convFiledName("imgZaitakuService"));
            };

            Controls.prototype.lblNoImageZaitakuService = function () {
                return new UZA.Label(this.convFiledName("lblNoImageZaitakuService"));
            };

            Controls.prototype.GaikyoTokkiPanel = function () {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiPanel"));
            };

            Controls.prototype.lblJutakuKaishu = function () {
                return new UZA.Label(this.convFiledName("lblJutakuKaishu"));
            };

            Controls.prototype.txtJutakuKaishu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJutakuKaishu"));
            };

            Controls.prototype.line1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line1"));
            };

            Controls.prototype.lblGaikyoTokkiTokubetsuKyufu = function () {
                return new UZA.Label(this.convFiledName("lblGaikyoTokkiTokubetsuKyufu"));
            };

            Controls.prototype.txtGaikyoTokkiTokubetsuKyufu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoTokkiTokubetsuKyufu"));
            };

            Controls.prototype.line2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line2"));
            };

            Controls.prototype.lblZaitakuService = function () {
                return new UZA.Label(this.convFiledName("lblZaitakuService"));
            };

            Controls.prototype.txtGaikyoTokkiZaitakuService = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoTokkiZaitakuService"));
            };

            Controls.prototype.line3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line3"));
            };

            Controls.prototype.lblShuso = function () {
                return new UZA.Label(this.convFiledName("lblShuso"));
            };

            Controls.prototype.txtShuso = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShuso"));
            };

            Controls.prototype.line4 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line4"));
            };

            Controls.prototype.lblKazokuJokyo = function () {
                return new UZA.Label(this.convFiledName("lblKazokuJokyo"));
            };

            Controls.prototype.txtKazokuJokyo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKazokuJokyo"));
            };

            Controls.prototype.line5 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line5"));
            };

            Controls.prototype.lblKyojuKankyo = function () {
                return new UZA.Label(this.convFiledName("lblKyojuKankyo"));
            };

            Controls.prototype.txtKyojuKankyo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKyojuKankyo"));
            };

            Controls.prototype.line6 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line6"));
            };

            Controls.prototype.lblKikaiKiki = function () {
                return new UZA.Label(this.convFiledName("lblKikaiKiki"));
            };

            Controls.prototype.txtKikaiKiki = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKikaiKiki"));
            };

            Controls.prototype.imgGaikyoTokki = function () {
                return new UZA.DynamicImage(this.convFiledName("imgGaikyoTokki"));
            };

            Controls.prototype.lblNoImageGaikyoTokki = function () {
                return new UZA.Label(this.convFiledName("lblNoImageGaikyoTokki"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ChosaKekkaInfoGaikyo.Controls = Controls;
    })(DBE.ChosaKekkaInfoGaikyo || (DBE.ChosaKekkaInfoGaikyo = {}));
    var ChosaKekkaInfoGaikyo = DBE.ChosaKekkaInfoGaikyo;
})(DBE || (DBE = {}));
