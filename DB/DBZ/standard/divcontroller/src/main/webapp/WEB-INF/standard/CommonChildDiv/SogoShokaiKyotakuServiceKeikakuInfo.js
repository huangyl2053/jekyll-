var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyotakuServiceKeikakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKyotakuServiceKeikakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKyotakuServiceKeikakuInfo || (DBZ.SogoShokaiKyotakuServiceKeikakuInfo = {}));
    var SogoShokaiKyotakuServiceKeikakuInfo = DBZ.SogoShokaiKyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyotakuServiceKeikakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKyotakuServiceKeikakuInfo || (DBZ.SogoShokaiKyotakuServiceKeikakuInfo = {}));
    var SogoShokaiKyotakuServiceKeikakuInfo = DBZ.SogoShokaiKyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));
