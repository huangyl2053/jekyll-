var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoSaikinShorishaRireki.ModeController = ModeController;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoSaikinShorishaRireki.PublicProperties = PublicProperties;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
