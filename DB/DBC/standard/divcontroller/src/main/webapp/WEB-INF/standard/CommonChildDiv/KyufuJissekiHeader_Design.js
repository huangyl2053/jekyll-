var DBC;
(function (DBC) {
    (function (KyufuJissekiHeader) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyufuJissekiHeader.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuJissekiHeader";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufuJissekiHeader.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufuJissekiHeader.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuJissekiHeader = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihoNo"));
            };

            Controls.prototype.txtJuminShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtJuminShubetsu"));
            };

            Controls.prototype.txtYoKaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYoKaigodo"));
            };

            Controls.prototype.txtYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukoKikan"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtSeibetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            };

            Controls.prototype.txtSeinengappi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeinengappi"));
            };

            Controls.prototype.txtTeikyoNengetsu = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoNengetsu"));
            };

            Controls.prototype.txtJissekiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJissekiKubun"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };

            Controls.prototype.txtYoshikiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtYoshikiNo"));
            };

            Controls.prototype.txtJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha"));
            };
            return Controls;
        })();
        KyufuJissekiHeader.Controls = Controls;
    })(DBC.KyufuJissekiHeader || (DBC.KyufuJissekiHeader = {}));
    var KyufuJissekiHeader = DBC.KyufuJissekiHeader;
})(DBC || (DBC = {}));
