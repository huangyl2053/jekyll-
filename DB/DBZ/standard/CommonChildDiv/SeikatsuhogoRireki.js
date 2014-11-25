var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoRireki.ModeController = ModeController;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuhogoRireki.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));
