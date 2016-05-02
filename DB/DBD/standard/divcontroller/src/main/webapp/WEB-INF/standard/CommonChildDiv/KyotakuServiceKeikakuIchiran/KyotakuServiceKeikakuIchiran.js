var DBD;
(function (DBD) {
    (function (KyotakuServiceKeikakuIchiran) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyotakuServiceKeikakuIchiran.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KyotakuServiceKeikakuIchiran.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KyotakuServiceKeikakuIchiran.ModeController = ModeController;
    })(DBD.KyotakuServiceKeikakuIchiran || (DBD.KyotakuServiceKeikakuIchiran = {}));
    var KyotakuServiceKeikakuIchiran = DBD.KyotakuServiceKeikakuIchiran;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (KyotakuServiceKeikakuIchiran) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyotakuServiceKeikakuIchiran.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyotakuServiceKeikakuIchiran.PublicProperties = PublicProperties;
    })(DBD.KyotakuServiceKeikakuIchiran || (DBD.KyotakuServiceKeikakuIchiran = {}));
    var KyotakuServiceKeikakuIchiran = DBD.KyotakuServiceKeikakuIchiran;
})(DBD || (DBD = {}));
