var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoGaikyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Moderu = function () {
                return "onClick_Moderu";
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

            Controls.prototype.txtChosaJisshiBashoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            };

            Controls.prototype.TokkiPanel = function () {
                return new UZA.Panel(this.convFiledName("TokkiPanel"));
            };

            Controls.prototype.txtTokki = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokki"));
            };

            Controls.prototype.ServiceJokyoPanel = function () {
                return new UZA.Panel(this.convFiledName("ServiceJokyoPanel"));
            };

            Controls.prototype.dgServiceJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceJokyo"));
            };

            Controls.prototype.radServiceKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            };

            Controls.prototype.rdoJutakuKaishu = function () {
                return new UZA.RadioButton(this.convFiledName("rdoJutakuKaishu"));
            };

            Controls.prototype.KubetsuKyufuPanel = function () {
                return new UZA.Panel(this.convFiledName("KubetsuKyufuPanel"));
            };

            Controls.prototype.txtkubetsuKyufu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtkubetsuKyufu"));
            };

            Controls.prototype.ZaitakuServicePanel = function () {
                return new UZA.Panel(this.convFiledName("ZaitakuServicePanel"));
            };

            Controls.prototype.txtZaitakuService = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtZaitakuService"));
            };

            Controls.prototype.RiyoShisetsuPanel = function () {
                return new UZA.Panel(this.convFiledName("RiyoShisetsuPanel"));
            };

            Controls.prototype.dgRiyoShisetsu = function () {
                return new UZA.DataGrid(this.convFiledName("dgRiyoShisetsu"));
            };

            Controls.prototype.txtRiyoShisetsuShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuShimei"));
            };

            Controls.prototype.txtRiyoShisetsuJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuJusho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.GaikyoTokkiTextPanel = function () {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiTextPanel"));
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

            Controls.prototype.lblTokuBetsuKyufuService = function () {
                return new UZA.Label(this.convFiledName("lblTokuBetsuKyufuService"));
            };

            Controls.prototype.txtTokuBetsuKyufuService = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokuBetsuKyufuService"));
            };

            Controls.prototype.line2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line2"));
            };

            Controls.prototype.lblTokkiZaitakuService = function () {
                return new UZA.Label(this.convFiledName("lblTokkiZaitakuService"));
            };

            Controls.prototype.txtTokkiZaitakuService = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkiZaitakuService"));
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

            Controls.prototype.GaikyoTokkiImagePanel = function () {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiImagePanel"));
            };

            Controls.prototype.gaikyoChosaImage = function () {
                return new UZA.DynamicImage(this.convFiledName("gaikyoChosaImage"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        ChosaKekkaInfoGaikyo.Controls = Controls;
    })(DBE.ChosaKekkaInfoGaikyo || (DBE.ChosaKekkaInfoGaikyo = {}));
    var ChosaKekkaInfoGaikyo = DBE.ChosaKekkaInfoGaikyo;
})(DBE || (DBE = {}));
