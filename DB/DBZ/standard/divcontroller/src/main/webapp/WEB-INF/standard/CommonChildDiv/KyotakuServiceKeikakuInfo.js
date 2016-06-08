var DBZ;
(function (DBZ) {
    (function (KyotakuServiceKeikakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KyotakuServiceKeikakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KyotakuServiceKeikakuInfo.ModeController = ModeController;
    })(DBZ.KyotakuServiceKeikakuInfo || (DBZ.KyotakuServiceKeikakuInfo = {}));
    var KyotakuServiceKeikakuInfo = DBZ.KyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KyotakuServiceKeikakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyotakuServiceKeikakuInfo.PublicProperties = PublicProperties;
    })(DBZ.KyotakuServiceKeikakuInfo || (DBZ.KyotakuServiceKeikakuInfo = {}));
    var KyotakuServiceKeikakuInfo = DBZ.KyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));
