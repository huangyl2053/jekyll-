var DBZ;
(function (DBZ) {
    (function (KaigoSonotaConfigInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoSonotaConfigInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoSonotaConfigInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoSonotaConfigInfo.ModeController = ModeController;
    })(DBZ.KaigoSonotaConfigInfo || (DBZ.KaigoSonotaConfigInfo = {}));
    var KaigoSonotaConfigInfo = DBZ.KaigoSonotaConfigInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoSonotaConfigInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoSonotaConfigInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoSonotaConfigInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoSonotaConfigInfo || (DBZ.KaigoSonotaConfigInfo = {}));
    var KaigoSonotaConfigInfo = DBZ.KaigoSonotaConfigInfo;
})(DBZ || (DBZ = {}));
