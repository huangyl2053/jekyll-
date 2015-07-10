var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoHenshuSettei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoBunshoBangoHenshuSettei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoBunshoBangoHenshuSettei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoBunshoBangoHenshuSettei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoBunshoBangoHenshuSettei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoBunshoBangoHenshuSettei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            };

            Controls.prototype.txtShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShuryoYMD"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.radBunshuBangoShuchuryokuUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radBunshuBangoShuchuryokuUmu"));
            };

            Controls.prototype.txtYukoKetasu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYukoKetasu"));
            };

            Controls.prototype.lin2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            };

            Controls.prototype.BunshoBangoKigo = function () {
                return new UZA.Panel(this.convFiledName("BunshoBangoKigo"));
            };

            Controls.prototype.radBunshoBangoKigoFuyoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radBunshoBangoKigoFuyoUmu"));
            };

            Controls.prototype.txtBunshoBangoKigo = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoBangoKigo"));
            };

            Controls.prototype.BunshoHeader = function () {
                return new UZA.Panel(this.convFiledName("BunshoHeader"));
            };

            Controls.prototype.radBunshoHeaderFuyoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radBunshoHeaderFuyoUmu"));
            };

            Controls.prototype.txtBunshoNoHeader = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoNoHeader"));
            };

            Controls.prototype.BunshoNoHenshu = function () {
                return new UZA.Panel(this.convFiledName("BunshoNoHenshu"));
            };

            Controls.prototype.ddlBunshoNoHenshu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBunshoNoHenshu"));
            };

            Controls.prototype.ddlBunshoNoHatsuban = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBunshoNoHatsuban"));
            };

            Controls.prototype.txtBunshoKoseiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoKoseiNo"));
            };

            Controls.prototype.BunshoFooter = function () {
                return new UZA.Panel(this.convFiledName("BunshoFooter"));
            };

            Controls.prototype.radBunshoNoFooterFuyoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radBunshoNoFooterFuyoUmu"));
            };

            Controls.prototype.txtBunshoNoFooter = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoNoFooter"));
            };
            return Controls;
        })();
        KaigoBunshoBangoHenshuSettei.Controls = Controls;
    })(DBZ.KaigoBunshoBangoHenshuSettei || (DBZ.KaigoBunshoBangoHenshuSettei = {}));
    var KaigoBunshoBangoHenshuSettei = DBZ.KaigoBunshoBangoHenshuSettei;
})(DBZ || (DBZ = {}));
