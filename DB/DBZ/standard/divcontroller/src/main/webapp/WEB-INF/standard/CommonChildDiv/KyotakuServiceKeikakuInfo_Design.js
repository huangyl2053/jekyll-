var DBZ;
(function (DBZ) {
    (function (KyotakuServiceKeikakuInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyotakuServiceKeikakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyotakuServiceKeikakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KyotakuServiceKeikakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KyotakuServiceKeikakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyotakuServiceKeikakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKyotakujigyoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakujigyoCode"));
            };

            Controls.prototype.txtKyotakuJigyoName = function () {
                return new UZA.TextBox(this.convFiledName("txtKyotakuJigyoName"));
            };

            Controls.prototype.txtSakuseiKubun = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSakuseiKubun"));
            };

            Controls.prototype.txtTekiyokaishiDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyokaishiDay"));
            };

            Controls.prototype.txtTekiyoshuryoDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoshuryoDay"));
            };
            return Controls;
        })();
        KyotakuServiceKeikakuInfo.Controls = Controls;
    })(DBZ.KyotakuServiceKeikakuInfo || (DBZ.KyotakuServiceKeikakuInfo = {}));
    var KyotakuServiceKeikakuInfo = DBZ.KyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));
