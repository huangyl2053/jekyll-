var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuhiKashitsukekinInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyufuhiKashitsukekinInfo.ModeController = ModeController;
    })(DBC.KyufuhiKashitsukekinInfo || (DBC.KyufuhiKashitsukekinInfo = {}));
    var KyufuhiKashitsukekinInfo = DBC.KyufuhiKashitsukekinInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyufuhiKashitsukekinInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyufuhiKashitsukekinInfo.PublicProperties = PublicProperties;
    })(DBC.KyufuhiKashitsukekinInfo || (DBC.KyufuhiKashitsukekinInfo = {}));
    var KyufuhiKashitsukekinInfo = DBC.KyufuhiKashitsukekinInfo;
})(DBC || (DBC = {}));
