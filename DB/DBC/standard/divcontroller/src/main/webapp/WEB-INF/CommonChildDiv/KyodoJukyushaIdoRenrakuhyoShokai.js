var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyoShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyodoJukyushaIdoRenrakuhyoShokai.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyodoJukyushaIdoRenrakuhyoShokai.ModeController = ModeController;
    })(DBC.KyodoJukyushaIdoRenrakuhyoShokai || (DBC.KyodoJukyushaIdoRenrakuhyoShokai = {}));
    var KyodoJukyushaIdoRenrakuhyoShokai = DBC.KyodoJukyushaIdoRenrakuhyoShokai;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyoShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyodoJukyushaIdoRenrakuhyoShokai.Controls(fieldName);
            }
            return PublicProperties;
        })();
        KyodoJukyushaIdoRenrakuhyoShokai.PublicProperties = PublicProperties;
    })(DBC.KyodoJukyushaIdoRenrakuhyoShokai || (DBC.KyodoJukyushaIdoRenrakuhyoShokai = {}));
    var KyodoJukyushaIdoRenrakuhyoShokai = DBC.KyodoJukyushaIdoRenrakuhyoShokai;
})(DBC || (DBC = {}));
