var DBD;
(function (DBD) {
    (function (ShakaiFukushiHojinKeigen) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgShakaiFukushiHojinKeigenList = function () {
                return "onSelect_dgShakaiFukushiHojinKeigenList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        ShakaiFukushiHojinKeigen.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShakaiFukushiHojinKeigen";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.ShakaiFukushiHojinKeigen.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.ShakaiFukushiHojinKeigen.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShakaiFukushiHojinKeigen = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShakaiFukushiHojinKeigenList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShakaiFukushiHojinKeigenList"));
            };

            Controls.prototype.ShakaiFukushiHojinKeigenDetail = function () {
                return new UZA.Panel(this.convFiledName("ShakaiFukushiHojinKeigenDetail"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.ShakaiFukushiHojinKeigenRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("ShakaiFukushiHojinKeigenRiyoshaFutan"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.txtKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtYukokigenDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            };

            Controls.prototype.txtKeigenJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKeigenJiyu"));
            };

            Controls.prototype.txtKeigenRitsuBunshi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenRitsuBunshi"));
            };

            Controls.prototype.lblIKeigenRitsuVinculum = function () {
                return new UZA.Label(this.convFiledName("lblIKeigenRitsuVinculum"));
            };

            Controls.prototype.txtKeigenRitsuBunbo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenRitsuBunbo"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.txtKakuninNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKakuninNo"));
            };

            Controls.prototype.txtKyotakuServiceOnly = function () {
                return new UZA.TextBox(this.convFiledName("txtKyotakuServiceOnly"));
            };

            Controls.prototype.txtKyojuhiShokujiOnly = function () {
                return new UZA.TextBox(this.convFiledName("txtKyojuhiShokujiOnly"));
            };

            Controls.prototype.txtUnitPrivateRoomOnly = function () {
                return new UZA.TextBox(this.convFiledName("txtUnitPrivateRoomOnly"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShakaiFukushiHojinKeigen.Controls = Controls;
    })(DBD.ShakaiFukushiHojinKeigen || (DBD.ShakaiFukushiHojinKeigen = {}));
    var ShakaiFukushiHojinKeigen = DBD.ShakaiFukushiHojinKeigen;
})(DBD || (DBD = {}));
