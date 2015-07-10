var DBZ;
(function (DBZ) {
    (function (FukaRirekiAll) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukaRirekiAll.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new FukaRirekiAll.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        FukaRirekiAll.ModeController = ModeController;
    })(DBZ.FukaRirekiAll || (DBZ.FukaRirekiAll = {}));
    var FukaRirekiAll = DBZ.FukaRirekiAll;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (FukaRirekiAll) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukaRirekiAll.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        FukaRirekiAll.PublicProperties = PublicProperties;
    })(DBZ.FukaRirekiAll || (DBZ.FukaRirekiAll = {}));
    var FukaRirekiAll = DBZ.FukaRirekiAll;
})(DBZ || (DBZ = {}));
