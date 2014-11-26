var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));
